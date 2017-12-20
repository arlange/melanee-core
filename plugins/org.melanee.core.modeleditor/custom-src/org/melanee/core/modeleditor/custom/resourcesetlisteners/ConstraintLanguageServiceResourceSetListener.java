/*******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.resourcesetlisteners;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IConstraintLanguageService;

/**
 * 
 * This resource set listener listens to changes to the model,
 * informs the constraint language service and applies commands
 * supplied by it. This is needed for derived and init expressions
 *
 */
public class ConstraintLanguageServiceResourceSetListener implements ResourceSetListener{

	static ConstraintLanguageServiceResourceSetListener service = null;
	
	/**
	 * Start listening to the model which is passed over as parameter. This
	 * method adds a new listener to each model. The previously listened models
	 * are still listened after listening to a new model. Use stopListening(modelRoot)
	 * to stop listening to changes of a model.
	 * 
	 * @param modelRoot Model to listen for changes.
	 */
	public void startListening(EObject modelRoot) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelRoot);
		domain.addResourceSetListener(this);
	}
	
	/**
	 * Stops listening for changes to a model.
	 * 
	 * @param modelRoot Model to stop listen for changes.
	 */
	public void stopListening(EObject modelRoot) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelRoot);
		domain.removeResourceSetListener(this);
	}
	
	public static ConstraintLanguageServiceResourceSetListener getInstance(){
		if (service == null)
			service = new ConstraintLanguageServiceResourceSetListener();
			
		return service;
	}
	
	@Override
	public NotificationFilter getFilter() {
		return null;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		IConstraintLanguageService constraintLanguageService = null;
		try {
			constraintLanguageService = ExtensionPointService.Instance().getActiveConstraintLanguageService();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		//No constraint language service available, do nothing
		if (constraintLanguageService == null)
			return null;
		
		for (Notification notification : event.getNotifications()){
			//Only interseted in EMF notifications for Melanee model
			if(! (notification instanceof ENotificationImpl))
				continue;
			
			//On attribute creation a default has to be potentially set
			if (notification.getEventType() == ENotificationImpl.SET
					&& notification.getNewValue() instanceof Attribute)
				return constraintLanguageService.initAttrbute((Attribute)notification.getNewValue());
			//Every addition except deep model and level can cause derived values to be
			//recalculated
			else if (notification.getNewValue() instanceof Element
					&& ! (notification.getNewValue() instanceof DeepModel)
					&& ! (notification.getNewValue() instanceof Level)){
				//Add, move and remove
				if (notification.getEventType() == ENotificationImpl.ADD)
					return constraintLanguageService.recalculateDerivedAttributes((Element)notification.getNotifier(), notification.getEventType());
			}
			//Every addition except deep model and level can cause derived values to be
			//recalculated
			else if (notification.getNewValue() == null
					&& notification.getOldValue() instanceof Element
					&& ! (notification.getOldValue() instanceof DeepModel)
					&& ! (notification.getOldValue() instanceof Level)){
				//Add, move and remove
				if (notification.getEventType() == ENotificationImpl.REMOVE)
					return constraintLanguageService.recalculateDerivedAttributes((Element)notification.getNotifier(), notification.getEventType());
			}
			//The change of connectionend destinations and attribute values is interesting
			else if (notification.getNotifier() instanceof Attribute
						|| notification.getNotifier() instanceof ConnectionEnd){
				if(notification.getEventType() == ENotificationImpl.SET
						&& (notification.getFeature() == PLMPackage.eINSTANCE.getAttribute_Value()
						|| notification.getFeature() == PLMPackage.eINSTANCE.getConnectionEnd_Destination()))
					return constraintLanguageService.recalculateDerivedAttributes((Element)notification.getNotifier(), notification.getEventType());
			}
		}
		
		//No operation which is interesting for the constraint language service
		return null;
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		
	}

	@Override
	public boolean isAggregatePrecommitListener() {
		return false;
	}

	@Override
	public boolean isPrecommitOnly() {
		return true;
	}

	@Override
	public boolean isPostcommitOnly() {
		return false;
	}	
}

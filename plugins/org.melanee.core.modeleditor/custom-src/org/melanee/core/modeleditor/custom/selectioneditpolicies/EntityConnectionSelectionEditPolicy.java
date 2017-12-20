/*******************************************************************************
 * Copyright (c) 2013 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * This edit policy is responsible for making compartments visible
 * when hovering over an model element with a tool. E.g. if an
 * attribute tool is selected while hovering the attributes compartment
 * will become visible.
 *
 */
public class EntityConnectionSelectionEditPolicy extends ExtendableToolbarSelectionEditPolicy{
	
	
	private boolean hover = false;
	
	/**
	 * Make
	 */
	@Override
	public void showTargetFeedback(Request request) {
		
		if(hover)
			return;
		
		hover = true;
		
		//Code shall only be executed when a tool is selected which can add a child to entity
		if (! (request instanceof CreateUnspecifiedTypeRequest))
			return;
		
		CreateUnspecifiedTypeRequest req = (CreateUnspecifiedTypeRequest)request;
		
		if( !(
					req.getElementTypes().contains(PLMElementTypes.Attribute_3100)
					||req.getElementTypes().contains(PLMElementTypes.Attribute_3106)
					||req.getElementTypes().contains(PLMElementTypes.Method_3102)
					||req.getElementTypes().contains(PLMElementTypes.Method_3108)
					||req.getElementTypes().contains(PLMElementTypes.Entity_3105)
					||req.getElementTypes().contains(PLMElementTypes.Connection_3099)
			)
		)
			
		return;
		
		int compartments = 0;
		
		if (req.getElementTypes().contains(PLMElementTypes.Attribute_3100)
				||req.getElementTypes().contains(PLMElementTypes.Attribute_3106))
			compartments |= EntityEditPart.COMPARTMENT_ATTRIBUTES; // this constant should be the same in Entity2-, Connection- and Connection2EditPart
		
		if(	req.getElementTypes().contains(PLMElementTypes.Method_3102)
				||req.getElementTypes().contains(PLMElementTypes.Method_3108))
			compartments |= EntityEditPart.COMPARTMENT_METHODS;
		
		if( req.getElementTypes().contains(PLMElementTypes.Entity_3105)
				||req.getElementTypes().contains(PLMElementTypes.Connection_3099))
			compartments |= EntityEditPart.COMPARTMENT_CONTENT;
		
		AbstractClabjectEditPart clabjectEditPart = AbstractClabjectEditPart.create(getHost());
		clabjectEditPart.makeCompartmentsVisible(compartments);
		
		super.showTargetFeedback(request);
	}
	
	@Override
	public void eraseTargetFeedback(Request request) {
		
		boolean elementCreated = false;
		
		//Search in the stack if this code is called from an element creation via a tool
		for (StackTraceElement element : Thread.currentThread().getStackTrace())
			if (element.getClassName().equals("org.eclipse.gef.tools.CreationTool")
					&& element.getMethodName().equals("handleButtonUp")){
				elementCreated = true;
				break;
			}
		
		//Compartment visibility shall not be changed back after
		//an element was created
		if (!elementCreated){
			AbstractClabjectEditPart clabjectEditPart = AbstractClabjectEditPart.create(getHost());
			clabjectEditPart.makeCompartmentsVisible(EntityEditPart.COMPARTMENT_AUTOMATIC); // hides empty compartments
		}
		
		hover = false;
		
		super.eraseTargetFeedback(request);
	}
}

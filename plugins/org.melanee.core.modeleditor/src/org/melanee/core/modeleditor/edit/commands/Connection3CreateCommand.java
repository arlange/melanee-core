/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ralph Gerbig - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.modeleditor.providers.ElementInitializers;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.Package;

/**
 * @generated
 */
public class Connection3CreateCommand extends EditElementCommand {

	/**
	* @generated
	*/
	public Connection3CreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	* FIXME: replace with setElementToEdit()
	* @generated
	*/
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		return true;

	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Connection newElement = PLMFactory.eINSTANCE.createConnection();

		//Set the location to the visualizer
		if (getRequest().getParameter(ModelEditorConstants.CREATE_COMMAND_PRECONFIGURED_ELEMENT) != null)
			newElement = (Connection) getRequest()
					.getParameter(ModelEditorConstants.CREATE_COMMAND_PRECONFIGURED_ELEMENT);

		Package owner = (Package) getElementToEdit();
		owner.getContent().add(newElement);

		ElementInitializers.getInstance().init_Connection_3127(newElement);

		doConfigure(newElement, monitor, info);

		//Set the location			
		if (getRequest().getParameter(ModelEditorConstants.CREATE_COMMAND_LOCATION) != null) {
			Point location = (Point) getRequest().getParameter(ModelEditorConstants.CREATE_COMMAND_LOCATION);
			((Element) newElement).getVisualizer().get(0).setXLocation(location.x);
			((Element) newElement).getVisualizer().get(0).setYLocation(location.y);
		}

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	* @generated
	*/
	protected void doConfigure(Connection newElement, IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}

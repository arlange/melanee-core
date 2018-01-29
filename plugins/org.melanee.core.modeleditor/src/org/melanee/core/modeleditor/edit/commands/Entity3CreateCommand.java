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

import java.util.Iterator;

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
import org.eclipse.ui.PlatformUI;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.modeleditor.part.PLMDiagramEditor;
import org.melanee.core.modeleditor.providers.ElementInitializers;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.Package;

/**
 * @generated
 */
public class Entity3CreateCommand extends EditElementCommand {

	/**
	* @generated
	*/
	public Entity3CreateCommand(CreateElementRequest req) {
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
		PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		String typeName = editor.getPalette().getActiveTool().getLabel();
		String typeToolId = editor.getPalette().getActiveTool().getId();

		//check if we have a dsl element -> if we have no dsl element we can create
		if (!typeToolId.startsWith("dsl."))
			return true;

		Level m = getElementToEdit() instanceof Level ? (Level) getElementToEdit()
				: ((Clabject) getElementToEdit()).getLevel();

		DeepModel ont = (DeepModel) m.eContainer();

		//We cannot create an instance on the highest ontological layer
		if (ont.getContent().indexOf(m) < 1)
			return false;

		Level typeLevel = ont.getContent().get(ont.getContent().indexOf(m) - 1);

		Clabject type = null;

		Iterator<EObject> contentIterator = typeLevel.eAllContents();
		while (contentIterator.hasNext()) {
			EObject obj = contentIterator.next();
			//We found the type -> allowed to create an instance here
			if (obj instanceof Clabject && ((Clabject) obj).getName() != null
					&& ((Clabject) obj).getName().equals(typeName)) {
				type = (Clabject) obj;
				break;
			}
		}

		//no type found
		if (type == null)
			return false;

		//owned in level, not contained and added to model => OK
		if (type.eContainer() instanceof Level || type.eContainer() instanceof Package && type.getComposite() == null
				&& getElementToEdit() instanceof Level)
			return true;

		if ((type.getComposite() != null || (type.getAggregates().size() > 0))
				&& getElementToEdit() instanceof Clabject) {

			//Type is part of a composite
			if (type.getComposite() != null && ((Clabject) getElementToEdit()).getClassificationTreeAsInstance()
					.contains((Clabject) type.getComposite()))
				return true;

			for (Clabject a : type.getAggregates()) {
				if (((Clabject) getElementToEdit()).isInstanceOf((Clabject) a))
					return true;
			}
		}

		//We found no type -> not allowed to create an instance here
		return false;
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Entity newElement = PLMFactory.eINSTANCE.createEntity();

		//Set the location to the visualizer
		if (getRequest().getParameter(ModelEditorConstants.CREATE_COMMAND_PRECONFIGURED_ELEMENT) != null)
			newElement = (Entity) getRequest().getParameter(ModelEditorConstants.CREATE_COMMAND_PRECONFIGURED_ELEMENT);

		Package owner = (Package) getElementToEdit();
		owner.getContent().add(newElement);

		ElementInitializers.getInstance().init_Entity_3126(newElement);

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
	protected void doConfigure(Entity newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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

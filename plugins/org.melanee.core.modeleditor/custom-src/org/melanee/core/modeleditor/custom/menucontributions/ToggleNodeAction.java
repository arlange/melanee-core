/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/

package org.melanee.core.modeleditor.custom.menucontributions;

import java.util.LinkedList;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceEditPart;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.PLMPackage;


/**
 * 
 * @author  (rgerbig@rumms.uni-mannheim.de)
 *
 * This class is used to collapse/expand DomainConnections based on information
 * in the model. Collapsed means that the DomainConnection is rendered as small 
 * black rectangle. Collapsed means that the DomainConnection will rendered as
 * hexagon, its default figure.
 *
 */
public class ToggleNodeAction implements IObjectActionDelegate {

	public final static String ID = "org.melanee.core.modeleditor.custom.toggledomainconnectionationaction";
	
	private AbstractBorderedShapeEditPart selectedElement;
	
	public ToggleNodeAction()  {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Reads the rendering information attached to the ontology. If no information
	 * is present it will be created. After reading the information of collapsedDomainConnections
	 * Field it is decided whether the ID of the connection will be removed or added to the
	 * connection. In the end the visual state of the DomainConnectionEditPart is changed.
	 */
	@Override
	public void run(IAction action) {
		
		if (selectedElement == null)
			return;
		
		Element self = (Element)selectedElement.resolveSemanticElement();
		
		if (self.getVisualizer() == null)
			return;
		
		LinkedList<String> attributes = new LinkedList<String>();
		
		for (String attr : self.getVisualizer().get(0).getAttributes())
		{
			if (attr.startsWith("collapsed"))
			{
				attributes.remove(attr);
				String value = self.getVisualizer().get(0).getValueForKey("collapsed");
				attr = (value.equals("true")) ? "collapsed= false":"collapsed= true";
				attributes.add(attr);
			}
			else
			{
				attributes.add(attr);
			}
		}
		
		EditingDomain domain = selectedElement.getEditingDomain();
		domain.getCommandStack().execute(SetCommand.create(domain, self.getVisualizer().get(0), PLMPackage.eINSTANCE.getLMLVisualizer_Attributes(), attributes));
		
		//We are not toggeling elided nodes
		/*if (self instanceof Clabject && ((Clabject)self).isElided())
			return;*/
		
		//No rendering information found => add new rendering information
		//if (self.getVisualizer() == null)
		//{
		//	AddVisualizationAction.execute((ShapeNodeEditPart)selectedElement);
		//}
		
		//********************************************************
		//Do toggling based on information in the diagram
		//********************************************************
		//Field collapsedField = null;
		
		/*
		 * ************************************************************
		 * Needs to be fixed
		 * ************************************************************
		 * for(Element e : self.getVisualizer().getChildren())
		{
			//We are only interested in fields
			if (e instanceof Field)
			{
				if (e.getName().equals("collapsed"))
				{
					collapsedField = (Field)e;
					break;
				}
			}
		}*/
		
		//get a array with all collapsed ids
		//boolean collapsed = Boolean.parseBoolean(collapsedField.getValue());

		//write the new string to the command
		//SetRequest setNewValueRequest = 
		//	new SetRequest(collapsedField, PLMPackage.eINSTANCE.getField_Value(), Boolean.toString(!collapsed));
		//SetValueCommand setNewValueCommand = new SetValueCommand(setNewValueRequest);
		//selectedElement.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(setNewValueCommand));
		
		//********************************************************
		//Change the connection's new visual state
		//********************************************************
//		if (selectedElement instanceof ConnectionEditPart)
//			((ConnectionEditPart)selectedElement).updateView(false);
//		else if(selectedElement instanceof BinaryGeneralizationEditPart)
//			((BinaryGeneralizationEditPart)selectedElement).updateView(false);
//		else if(selectedElement instanceof MultipleSpecializationEditPart)
//			((MultipleSpecializationEditPart)selectedElement).updateView(false);
//		else if(selectedElement instanceof MultipleGeneralizationEditPart)
//			((MultipleGeneralizationEditPart)selectedElement).updateView(false);
	}

	//*****************************************************
	// Find edit part for semantic element
	//*****************************************************
	//********************************************************
	//Get currently open editor for retrieving of EditParts
	//********************************************************
	//IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	//If no PLM Diagram is opened we want to do nothing
	//if (! (editorPart instanceof PLMDiagramEditor))
	//	return;
	//PLMDiagramEditor plmEditor = (PLMDiagramEditor)editorPart;
	//EditPart ontologyPart = 
	//	(EditPart)plmEditor.getDiagramGraphicalViewer().findEditPartsForElement(EMFCoreUtil.getProxyID(ont), NodeEditPart.class).get(0);
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) 
		{
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof ConnectionEditPart 
					|| structuredSelection.getFirstElement() instanceof InheritanceEditPart) 
			{
				selectedElement = (AbstractBorderedShapeEditPart) structuredSelection.getFirstElement();
			}
		}
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}

}

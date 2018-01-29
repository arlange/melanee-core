package org.melanee.core.modelexplorer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.melanee.core.models.plm.PLM.Domain;

public class ModelExplorerAction extends Action {

	@Override
	public ImageDescriptor getImageDescriptor() {
		return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/explore.gif");
	}
	
	@Override
	public String getToolTipText() {
		return "Explore and Link Remote Models";
	}
	
	@Override
	public void run() {
		DiagramDocumentEditor editor = (DiagramDocumentEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		Domain domain = (Domain)editor.getDiagram().getElement();
		Diagram diagram = editor.getDiagram();
		ModelExplorerDialog med = new ModelExplorerDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), domain, diagram);
		int result = med.open();
		
		if (result == Window.CANCEL)
			return; 
		
		List<IGraphicalEditPart> editParts = new ArrayList<IGraphicalEditPart>();
		for(EObject elementToSelect : med.getCreatedElements())
			editParts.addAll(editor.getDiagramGraphicalViewer().findEditPartsForElement(EMFCoreUtil.getProxyID(elementToSelect), IGraphicalEditPart.class));
		
		for(IGraphicalEditPart ep : editParts)
			if(ep.isSelectable()){
				ep.activate();
				editor.getDiagramGraphicalViewer().appendSelection(ep);
			}
	}
}
package org.melanee.core.melanee2metadepth.wizards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.melanee.core.melanee2metadepth.main.GenerateMetadepth;
import org.melanee.core.models.plm.PLM.DeepModel;

public class Export2MetadepthWizard extends Wizard implements IExportWizard {
	
	private SelectSourceWizardPage selectSourceWizardPage;
	private SelectTargetWizardPage selectTargetWizardPage;
	
	public Export2MetadepthWizard() {
		setWindowTitle("Export to Metadepth");
	}

	@Override
	public void addPages() {
		super.addPages();
		
		addPage(selectSourceWizardPage);
		addPage(selectTargetWizardPage);
	}
	
	@Override
	public boolean performFinish() {
		
		//Load the example model
		URI sourceModel = URI.createPlatformResourceURI(selectSourceWizardPage.getSelection(), true);
		List<String> arguments = new ArrayList<String>();
		//Get the path of the plugins result folder
		String targetFolder = selectTargetWizardPage.getSelection();
		
		//The leading slash needs to be removed to get a string of format "project/folder"
		targetFolder = targetFolder.substring(1);
		
		//The project into which the file shall be exported
		String project = targetFolder.substring(0, targetFolder.indexOf("/") == -1 ? targetFolder.length() : targetFolder.indexOf("/"));
		
		//The folder into which the file shall be exported
		String folder = "";
		if (targetFolder.indexOf("/") != -1)
			folder = targetFolder.substring(targetFolder.indexOf("/") + 1, targetFolder.length());
		else
			folder = "";
		
		IContainer target;
		
		try {
			//Get the target folder as IFolder
			if (folder != "")
				target = ResourcesPlugin.getWorkspace().getRoot().getProject(project).getFolder(new Path(folder));
			else
				target = ResourcesPlugin.getWorkspace().getRoot().getProject(project);
			
			//Generate the metadepth file
			GenerateMetadepth generator = new GenerateMetadepth(sourceModel, target.getLocation().toFile(), arguments);
			generator.doGenerate(new BasicMonitor());
			
			//Refresh the whole workspace to show the generated file
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			//open the generated file
			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.getResource(sourceModel, true);
			Iterator<EObject> iterator = r.getAllContents();
			DeepModel rootDeepModel = null;
			while (iterator.hasNext()){
				EObject obj = iterator.next();
				
				if (obj instanceof DeepModel){
					rootDeepModel = (DeepModel)obj;
					break;
				}
			}
			
			//No ontology is found so no diagram is exported
			if (rootDeepModel == null)
				return true;
			
			IEditorInput input = null;
			if (target instanceof IProject)
				input = new FileEditorInput(((IProject)target).getFile(rootDeepModel.getName() + ".mdepth"));
			else if (target instanceof IFolder)
				input = new FileEditorInput(((IFolder)target).getFile(rootDeepModel.getName() + ".mdepth"));
			else
				return true;
			
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "org.eclipse.ui.DefaultTextEditor", true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		selectSourceWizardPage = new SelectSourceWizardPage("Select Source", selection);
		selectTargetWizardPage = new SelectTargetWizardPage("Select Target");
	}
}

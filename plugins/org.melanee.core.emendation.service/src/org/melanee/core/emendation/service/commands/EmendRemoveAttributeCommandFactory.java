/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.emendation.service.commands;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.emendation.service.BasicImpactAnalyzer;
import org.melanee.core.emendation.service.dialogs.EmendRemoveAttributeDialog;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;

public class EmendRemoveAttributeCommandFactory{
	
	Set<Feature> emendedElements;
	private final IImpactAnalyzer impactAnalyzer;
	private final Clabject changeOrigin;
	private final Feature featureToDelete;
	
	public Set<Feature> getEmendedObjects() {
		return (Set<Feature>)emendedElements;
	}
	
	public EmendRemoveAttributeCommandFactory(IImpactAnalyzer impactAnalyzer, Clabject changeOrigin, Feature featureToDelete){
		this.impactAnalyzer = impactAnalyzer;
		this.changeOrigin = changeOrigin;
		this.featureToDelete = featureToDelete;	
	}
	
	public CompoundCommand run(){
		return run(new HashSet<Clabject>());
	}
	
	public CompoundCommand run(Set<Clabject> exclude){
		try {
			EmendRemoveAttributeDialog dialog = showRemoveModelElementDialog();
			
			if (dialog == null)
				return null;
			
			return runEmendation(changeOrigin, featureToDelete, exclude);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected EmendRemoveAttributeDialog showRemoveModelElementDialog() throws ExecutionException{
		EmendRemoveAttributeDialog dialog = new EmendRemoveAttributeDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		
		if (dialog.open() == Window.OK)
			return dialog;
		else
			return null;
	}
	
	/**
	 * 
	 * @param changeOrigin The element on which the original change operation has been performed
	 * @param traitToChange The EAttribut in the meta-model to change
	 * @param newValue can bee needed because if emendation request comes from UI it can be already changed in 
	 * 					the feature
	 * @param newValue the new value to set
	 * @param changeOntologicalTypes change ontological types? 
	 * @param changeSubtypes change subtypes?
	 * @param changeSuperTypes change supertypes?
	 * @return
	 */
	protected CompoundCommand runEmendation(Clabject changeOrigin, Feature featureToDelete, Set<Clabject> exclude){
		emendedElements = impactAnalyzer.getAffectedModelElementsForDeleteFeatureOperation(featureToDelete, changeOrigin);//(Set<Feature>)new ImpactAnalyzer<Feature>().calculateImpactOfChange((Feature)featureToDelete, String.valueOf(featureToDelete.getDurability()), PLMPackage.eINSTANCE.getFeature_Durability(), changeOntologicalTypes, changeSubtypes, changeSuperTypes);
				
		//***************************************************************
		//Execute change operation
		//***************************************************************
		final CompoundCommand emendationCommand = new CompoundCommand("Emendation - Delete " + changeOrigin.getName());
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(changeOrigin);
		
		for (Feature element : emendedElements)
			if (!exclude.contains(element.getClabject()))
				emendationCommand.append(DeleteCommand.create(domain, element));
		
		//This is needed because if we place an empty compound command in a compound command
		//this makes problems during execution of following commands. e.g. EmmendMoveCommand
		if (emendationCommand.getCommandList().size() == 0)
			return null;
		
		return emendationCommand;
	}
}
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

import java.util.Set;

import javax.print.attribute.EnumSyntax;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.emendation.service.BasicImpactAnalyzer;
import org.melanee.core.emendation.service.dialogs.EmendChangeTraitDialog;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;

public class EmendChangeClabjectTraitCommand{
	
	Set<Clabject> emendedElements;
	private final IImpactAnalyzer impactAnalyzer;
	private final Clabject changeOrigin;
	private final EStructuralFeature traitToChange;
	private final String oldValue;
	private final String newValue;
	
	public Set<Clabject> getEmendedObjects() {
		return (Set<Clabject>)emendedElements;
	}
	
	public EmendChangeClabjectTraitCommand(IImpactAnalyzer impactAnalyzer, Clabject changeOrigin, EStructuralFeature traitToChange, String oldValue, String newValue){
		this.impactAnalyzer = impactAnalyzer;
		this.changeOrigin = changeOrigin;
		this.traitToChange = traitToChange;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	public CompoundCommand run(){
		try {
			EmendChangeTraitDialog dialog = showChangeValueDialog(newValue, oldValue, changeOrigin);
			
			if (dialog == null)
				return null;
						
			return runEmendation(dialog.getChangeNonShallowSubSupertypes());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected EmendChangeTraitDialog showChangeValueDialog(String valueToDisplayValue, String oldValue, Clabject changeOrigin) throws ExecutionException{
		EmendChangeTraitDialog dialog = new EmendChangeTraitDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), valueToDisplayValue, EmendChangeTraitDialog.CLABJECT);
		
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
	protected CompoundCommand runEmendation(boolean includeNonShallowInheritance){
		emendedElements = impactAnalyzer.getAffectedModelElementsForChangeTraitClabjectOperation(changeOrigin, oldValue, traitToChange, includeNonShallowInheritance); //(Set<Clabject>)new ImpactAnalyzer().calculateImpactOfChange((DomainElement)changeOrigin, oldValue, traitToChange, changeOntologicalTypes, changeSubtypes, changeSuperTypes);
		
		CompoundCommand emendationCommand = new CompoundCommand("Emendation - " + traitToChange.getName() + " - " + changeOrigin.getName());
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(changeOrigin);
		
		for (Clabject element : emendedElements)
			if (traitToChange.getEType().getName().equals("EInt"))
				emendationCommand.append(SetCommand.create(domain, element, traitToChange, (Integer) computeNewValue(changeOrigin, element, newValue, traitToChange)));
			else
				emendationCommand.append(SetCommand.create(domain, element, traitToChange, computeNewValue(changeOrigin, element, newValue, traitToChange)));
		
		//domain.getCommandStack().execute(emendationCommand);
		
		return emendationCommand;
	}
	
	protected Object computeNewValue(Clabject changeOrigin, Clabject machtingElement, String newValue, EStructuralFeature traitToChange){
		if (isPotencyValue(traitToChange) && Integer.parseInt(newValue) != -1)
		{
			int changeOriginLevel = changeOrigin.getLevelIndex();
			int matchingFeatureLevel = machtingElement.getLevelIndex();
			int levelDistance = changeOriginLevel - matchingFeatureLevel;
			return Integer.parseInt(newValue) + levelDistance;
		
		}
		else if (isPotencyValue(traitToChange) && Integer.parseInt(newValue) == -1)
			return Integer.parseInt(newValue);

		return newValue;
	}
	
	protected boolean isPotencyValue(EStructuralFeature attributeToChange){
		return attributeToChange == PLMPackage.eINSTANCE.getClabject_Potency();
	}
}
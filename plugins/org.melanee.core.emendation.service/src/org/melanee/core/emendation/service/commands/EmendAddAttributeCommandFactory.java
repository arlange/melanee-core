/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.emendation.service.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.emendation.service.BasicImpactAnalyzer;
import org.melanee.core.emendation.service.dialogs.EmendAddAttributeDialog;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;

public class EmendAddAttributeCommandFactory{
	
	private Set<Clabject> emendedElements;
	private final IImpactAnalyzer impactAnalyzer;
	private final Clabject changeOrigin;
	private final Feature addedFeature;
	
	public Set<Clabject> getEmendedObjects(){
		return emendedElements;
	}
	
	public EmendAddAttributeCommandFactory(IImpactAnalyzer impactAnalyzer, Clabject changeOrigin, Feature addedFeature){
		this.impactAnalyzer = impactAnalyzer;
		this.changeOrigin = changeOrigin;
		this.addedFeature = addedFeature;
	}
	
	public CompoundCommand run(){
		try {
			EmendAddAttributeDialog dialog = showAddModelElementDialog(addedFeature);
			
			if (dialog == null)
				return null;
			
			return runEmendation(dialog.getNewName(), dialog.getNewDataType(), dialog.getNewDurability(), dialog.getNewMutability(), dialog.getPreventDuplicates(), dialog.getAddToSupertypesOnly(), dialog.getAddToOntologicalTypes(), dialog.getAddToOntologicalInstances());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected EmendAddAttributeDialog showAddModelElementDialog(Feature addedFeature) throws ExecutionException{
		EmendAddAttributeDialog dialog = new EmendAddAttributeDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		
		dialog.setNewName(addedFeature.getName());
		
		//An empty selection is needed to specify no data type
		List<String> dataTypes = new ArrayList<>();
		dataTypes.add("");
		dataTypes.addAll(addedFeature.getClabject().getDeepModel().getAllDatatypes());
		dialog.setDataTypes(dataTypes.toArray(new String[]{}));
		
		dialog.setNewDurability(addedFeature.getClabject().getPotencyAsString());
		dialog.setNewMutability(addedFeature.getClabject().getPotencyAsString());
		
		if (dialog.open() == Window.OK)
			return dialog;
		else
			return null;
	}
	
	/**
	 * 
	 * @param changeOrigin The element on which the original change operation has been performed
	 * @param traitToChange The EAttribut in the meta-model to change
	 * @param addedFeature can bee needed because if emendation request comes from UI it can be already changed in 
	 * 					the feature
	 * @param addedFeature the new value to set
	 * @param changeOntologicalTypes change ontological types? 
	 * @param changeSubtypes change subtypes?
	 * @param changeSuperTypes change supertypes?
	 * @return
	 */
	protected CompoundCommand runEmendation(String name, String dataType, int durability, int mutability, boolean preventDuplicates, boolean addToSuperTypesOnly, boolean includeOntologicalTypes, boolean includeOntologicalInstances){
		 emendedElements = impactAnalyzer.getAffectedModelElementsForAddFeatureOperation(changeOrigin, addedFeature, name, !preventDuplicates, addToSuperTypesOnly, includeOntologicalTypes, includeOntologicalInstances); 

		CompoundCommand emendationCommand = new CompoundCommand("Emendation - Add Feature" + addedFeature.getName());
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(changeOrigin);
		
		//***********************************
		//Setup the via UI added element
		//***********************************
		Command setOriginName = SetCommand.create(domain, addedFeature, PLMPackage.eINSTANCE.getElement_Name(), name);
		emendationCommand.append(setOriginName);
		
		//If no datatype was selected no datatype is set
		if(!"".equals(dataType)){
			Command setOriginDataType = SetCommand.create(domain, addedFeature, PLMPackage.eINSTANCE.getAttribute_Datatype(), dataType);
			emendationCommand.append(setOriginDataType);
		}
		
		Command setOriginDurability = SetCommand.create(domain, addedFeature, PLMPackage.eINSTANCE.getFeature_Durability(), durability);
		emendationCommand.append(setOriginDurability);
		Command setOriginMutabilityCommand = SetCommand.create(domain, addedFeature, PLMPackage.eINSTANCE.getAttribute_Mutability(), mutability);
		emendationCommand.append(setOriginMutabilityCommand);
		
		//This is only used as template for the configure method of PLMFactory
		Feature template = addedFeature instanceof Attribute ? PLMFactory.eINSTANCE.createAttribute() : PLMFactory.eINSTANCE.createMethod();
		template.setName(name);
		template.setDurability(durability);
		if (template instanceof Attribute) {
			Attribute attribute = (Attribute)template;
			attribute.setDatatype(dataType);
			attribute.setMutability(mutability);
		}
		
		//***************************************************************
		//Execute change operation
		//***************************************************************
		for (Clabject element : emendedElements)
			if (element != changeOrigin)
			{
				Feature newFeature =  PLMFactory.eINSTANCE.createFeature(template, addedFeature.getClabject(), element, false);

				emendationCommand.append(AddCommand.create(domain, element, PLMPackage.eINSTANCE.getClabject_Feature(), newFeature));
			}
		
		return emendationCommand;
	}
}
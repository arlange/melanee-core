/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/

package org.melanee.core.modeleditor.custom.propertysheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.services.properties.extended.ExtendedComboboxPropertyDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipse.ui.views.properties.tabbed.AdvancedPropertySection;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.impl.PLMPackageImpl;

public class OntologicalPropertySectionAbstractPropertySection extends
	AdvancedPropertySection{

	/***
	 * Stores a clabject's ontological attribute's sorted by the ID in the EMF file
	 */
	private Map<String, Attribute> attributes;
	/***
	 * Stores the descriptors for the distinct property sheet entries
	 */
	private IPropertyDescriptor[] descriptors;
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		
		if (selection.isEmpty()
				|| false == selection instanceof StructuredSelection) {
			super.setInput(part, selection);
			return;
		}
		
		StructuredSelection structuredSelection = ((StructuredSelection) selection);
		
		ArrayList transformedSelection = new ArrayList(structuredSelection.size());
		
		for (Iterator it = structuredSelection.iterator(); it.hasNext();) {
			
			Object model = it.next();
			
			//Get the selected EditPart
			if (model instanceof EditPart) {
				model = ((EditPart) model).getModel();
			}
			
			//Get the view of the Edipart
			EObject r = model instanceof View ? ((View) model).getElement() : null;
			
			//We have an clabject => Attributes might be availables
			if (r != null && r instanceof Clabject) {
				
				attributes = new HashMap<String, Attribute>();
				
				Clabject c = (Clabject)r;
				
				//Go to all Features. If Feature is Attribute -> store it in HashMap
				for (Feature f : c.getFeature())
				{
					if (f instanceof Attribute)
					{
						attributes.put(EMFCoreUtil.getProxyID(f), (Attribute)f);
					}
				}
				
				//Initialize the descriptors with the size of the attributes
				descriptors = new IPropertyDescriptor[attributes.size()];
				
				//Create a descriptor for each attribute
				for (int i = 0; i < descriptors.length; i++){
					Attribute attribute = attributes.get(attributes.keySet().toArray()[i]); 
					if (attribute.isEnumeration()){
						List<String> allValues = new ArrayList<String>();
						allValues.add("");
						allValues.addAll(attribute.getEnumeration().getLiteral());
						descriptors[i] = new ComboBoxPropertyDescriptor(attributes.keySet().toArray()[i], attribute.getName(), allValues.toArray(new String[] {}));
					}
					else
						descriptors[i] =  new TextPropertyDescriptor(attributes.keySet().toArray()[i], attribute.getName());
				
				//Set the selcetion to the current property source
				transformedSelection.add(new OntologicalPropertySource());
				}
			}
		}
		super.setInput(part, new StructuredSelection(transformedSelection));
	}
	
	class OntologicalPropertySource implements IPropertySource{
		
		@Override
		public Object getEditableValue() {
			return null;
		}

		@Override
		public IPropertyDescriptor[] getPropertyDescriptors() {
			//Return the descriptors which represent the rows in the ProprtyPage
			return descriptors;
		}

		@Override
		public Object getPropertyValue(Object id) {
			//Get attribute out of the HashMap and Display it's values
			Attribute attribute = attributes.get(id); 
			

			//For some reason no attribute was found..
			if (attribute == null)
				return null;
			//An enumeration has to return integer as it is edited by a combo box
			else if(attribute.isEnumeration())
				//If empty string or null 0 is returned as index for the empty value
				if (attribute.getValue() == null || attribute.getValue().length() == 0)
					return 0;
				else
					return attribute.getEnumeration().getLiteral().indexOf(attribute.getValue()) + 1;
			//All other attributes return strings as they are edited by a text editor
			else
				return (attribute.getValue() == null) ? "" : attribute.getValue();
			
			
		}

		@Override
		public boolean isPropertySet(Object id) {
			return false;
		}

		@Override
		public void resetPropertyValue(Object id) {
		}

		@Override
		public void setPropertyValue(Object id, Object value) {
			//Get attribute out of the HashMap and Display it's values
			Attribute attribute = attributes.get(id); 

			//For some reason no attribute was found..
			if (attribute == null)
				return;

			EditingDomain domain =  TransactionUtil.getEditingDomain(attribute);
			
			SetCommand cmd = null;
			String translatedValue = null;
			
			if(attribute.isEnumeration())
				if ((Integer)value == 0)
					translatedValue = "";
				else
					translatedValue = attribute.getEnumeration().getLiteral().get((Integer)value - 1);
			else
				translatedValue = (String)value;
			
			cmd = new SetCommand(domain, attribute, PLMPackageImpl.eINSTANCE.getAttribute_Value(), translatedValue);
			domain.getCommandStack().execute(cmd);
		}
	}
}
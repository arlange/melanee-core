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
package org.melanee.core.modeleditor.custom.propertysheet;

import java.util.Arrays;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

public class EmendationFeaturePropertyDescriptor extends PropertyDescriptor {

	private final IItemPropertyDescriptor itemPropertyDescriptor;

	private final Object sourceObject;

	public EmendationFeaturePropertyDescriptor(Object sourceObject, IItemPropertyDescriptor itemPropertyDescriptor) {
		super(sourceObject, itemPropertyDescriptor);
		this.sourceObject = sourceObject;
		this.itemPropertyDescriptor = itemPropertyDescriptor;
	}

	/**
	 * This is used to get our editor which does not fire the a new transaction on
	 * focus lost which is needed for the emendation service. There the transaction
	 * is started a second time as soon as the emendation dialog shows up.
	 */
	@Override
	public CellEditor createPropertyEditor(final Composite composite) {
		
		
		final EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor.getFeature(sourceObject);
		
		//*******************************************
		// These are the features that can be emended
		//********************************************
		if (feature instanceof EStructuralFeature
				&& !itemPropertyDescriptor.isMany(feature)
				&& !itemPropertyDescriptor.isMultiLine(feature)
				&& !itemPropertyDescriptor.isSortChoices(feature)
				//With this we prevent to execute custom code for an enumeration
				&& itemPropertyDescriptor.getChoiceOfValues(feature) == null
			) {
			
			//For boolean values return the default implementation
			if (feature.getEType().getInstanceClass() == Boolean.class || feature.getEType().getInstanceClass() == Boolean.TYPE)
				return new ExtendedComboBoxCellEditor(
						composite,
						Arrays.asList(new Object []{ Boolean.FALSE, Boolean.TRUE }),
						getEditLabelProvider(),
						itemPropertyDescriptor.isSortChoices(object));
			//For everything self return fixed cell editor
			 else
				return new EDataTypeCellEditorEx((EDataType)feature.getEType(), composite);
		}

		return super.createPropertyEditor(composite);
	}
	
	/**
	 * Does not fire transaction of focus lost. Fix for emendation service.
	 * 
	 */
	public static class EDataTypeCellEditorEx extends EDataTypeCellEditor{

		public EDataTypeCellEditorEx(EDataType eDataType, Composite parent) {
			super(eDataType, parent);
		}
		
		/**
		 * Processes a focus lost event that occurred in this cell editor.
		 * <p>
		 * The default implementation of this framework method applies the current
		 * value and deactivates the cell editor. Subclasses should call this method
		 * at appropriate times. Subclasses may also extend or reimplement.
		 * </p>
		 */
		@Override
		protected void focusLost() {
			if (isActivated()) {
				//fireApplyEditorValue();
				deactivate();
			}
		}
		
		boolean valueApplyRunning = false;
	}
	
}

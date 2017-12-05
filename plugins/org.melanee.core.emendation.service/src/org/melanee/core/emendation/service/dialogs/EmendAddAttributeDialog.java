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
package org.melanee.core.emendation.service.dialogs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.melanee.core.workbench.Activator;
import org.melanee.core.workbench.preferences.PreferenceConstants;

public class EmendAddAttributeDialog extends TitleAreaDialog {

	public EmendAddAttributeDialog(Shell parentShell) {
		super(parentShell);
	}
	
	Button addToSupertypesOnlyButton;
	Button preventDuplicatesButton;
	Button changeOntologicalTypesButton;
	Button changeOntologicalInstancesButton;
	Button enableServiceButton;
	
	Text newNameText;
	Combo newDataTypeCombo;
	Text newMutabilityText;
	Text newDurabilityText;
	
	private String[] dataTypes;
	
	private boolean addToSupertypesOnly = false;
	private boolean preventDuplicates = true;
	boolean changeOntologicalTypes = true;
	boolean changeOntologicalInstances = true;
	
	private String newName = "";
	private String newDataType = "";
	private String newDurability = "-1";
	private String newMutability = "-1";
	
	public void setNewName(String name){
		newName = name;
	}
	
	public String getNewName(){
		return newName;
	}
	
	public void setDataTypes(String[] dataTypes) {
		this.dataTypes = dataTypes;
		newDataType = dataTypes[0];
	}
	
	public String getNewDataType() {
		return newDataType;
	}
	
	public void setNewDurability(String durability){
		newDurability = durability;
	}
	
	public int getNewDurability(){
		try{
			return Integer.parseInt(newDurability);
		} catch (Exception ex){}
		
		return -1;
	}
	
	public void setNewMutability(String mutability){
		newMutability = mutability;
	}
	
	public int getNewMutability(){
		try{
			return Integer.parseInt(newMutability);
		} catch (Exception ex){}
		
		return -1;
	}
	
	public boolean getAddToSupertypesOnly(){
		return addToSupertypesOnly;
	}
	
	public boolean getPreventDuplicates(){
		return preventDuplicates;
	}
	
	public boolean getAddToOntologicalTypes(){
		return changeOntologicalTypes;
	}
	
	public boolean getAddToOntologicalInstances(){
		return changeOntologicalInstances;
	}
	
	@Override
	protected Control createDialogArea(
			Composite parent) {
		
		setTitle("Emend After Add Level Element");
	 
	    parent.setLayout(new GridLayout(1, false));
	    
	    Composite composite = (Composite) super.createDialogArea(parent);
	    composite.setLayout(new GridLayout(1, false));
	    composite.setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)composite.getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)composite.getLayoutData()).grabExcessVerticalSpace = true;
	    
	    Composite dialogArea = new Composite(composite, SWT.None);
	    dialogArea.setLayout(new GridLayout(1, false));
	    dialogArea.setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)dialogArea.getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)dialogArea.getLayoutData()).grabExcessVerticalSpace = true;
	    
	    Composite emendationComposite = new Composite(dialogArea, SWT.None);
	    emendationComposite.setLayout(new GridLayout(2, false));
	    emendationComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)emendationComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)emendationComposite.getLayoutData()).grabExcessVerticalSpace = false;
	    ((GridData)emendationComposite.getLayoutData()).verticalAlignment = SWT.BEGINNING;
	    
	    GridData newTextGridData = new GridData(GridData.FILL_HORIZONTAL);
        newTextGridData.grabExcessHorizontalSpace = true;
	    
	    Label label = new Label(emendationComposite, SWT.NONE);
        label.setText("Name");
        
        newNameText = new Text(emendationComposite, SWT.SINGLE | SWT.BORDER);
        newNameText.setLayoutData(newTextGridData);
        newNameText.setText(newName != null ? newName : "");
        
        Label dataType = new Label(emendationComposite, SWT.NONE);
        dataType.setText("Datatype");
        
        newDataTypeCombo = new Combo(emendationComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
        newDataTypeCombo.setLayoutData(newTextGridData);
        newDataTypeCombo.setItems(dataTypes);
        newDataTypeCombo.select(0);
        
        Label durability = new Label(emendationComposite, SWT.NONE);
        durability.setText("Durability");
        
        newDurabilityText = new Text(emendationComposite, SWT.SINGLE | SWT.BORDER);
        newDurabilityText.setLayoutData(newTextGridData);
        newDurabilityText.setText(newDurability);
        
        Label mutability = new Label(emendationComposite, SWT.NONE);
        mutability.setText("Mutability");
        
        newMutabilityText = new Text(emendationComposite, SWT.SINGLE | SWT.BORDER);
        newMutabilityText.setLayoutData(newTextGridData);
        newMutabilityText.setText(newMutability);
	    
        GridData optionGridData = new GridData(GridData.FILL_HORIZONTAL);
        optionGridData.horizontalSpan = 2;
        
        addToSupertypesOnlyButton = new Button(emendationComposite, SWT.CHECK);
        addToSupertypesOnlyButton.setText("Add attribute to supertypes only");
        addToSupertypesOnlyButton.setLayoutData(optionGridData);
        addToSupertypesOnlyButton.setSelection(addToSupertypesOnly);
        
        preventDuplicatesButton = new Button(emendationComposite, SWT.CHECK);
        preventDuplicatesButton.setText("Prevent feature duplicates through emendation (Don't add if it already exists)");
        preventDuplicatesButton.setLayoutData(optionGridData);
        preventDuplicatesButton.setSelection(preventDuplicates);
        
        changeOntologicalTypesButton = new Button(emendationComposite, SWT.CHECK);
        changeOntologicalTypesButton.setText("Change Ontological Types");
        changeOntologicalTypesButton.setLayoutData(optionGridData);
        changeOntologicalTypesButton.setSelection(changeOntologicalTypes);

        changeOntologicalInstancesButton = new Button(emendationComposite, SWT.CHECK);
        changeOntologicalInstancesButton.setText("Change Ontological Instances");
        changeOntologicalInstancesButton.setLayoutData(optionGridData);
        changeOntologicalInstancesButton.setSelection(changeOntologicalInstances);
        
        Composite enableServiceComposite =  new Composite(dialogArea, SWT.None);
        enableServiceComposite.setLayout(new GridLayout(1, false));
        enableServiceComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)enableServiceComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)enableServiceComposite.getLayoutData()).grabExcessVerticalSpace = true;
	    ((GridData)enableServiceComposite.getLayoutData()).verticalAlignment = SWT.END;
	    
	    enableServiceButton = new Button(enableServiceComposite, SWT.CHECK);
	    enableServiceButton.setSelection(true);
	    enableServiceButton.setText("Enable emendation service");
	    enableServiceButton.setLayoutData(new GridData());
	    ((GridData)enableServiceButton.getLayoutData()).verticalAlignment = SWT.END;
	    
	    enableServiceButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if (enableServiceButton.getSelection() == false){
					MessageDialog.openInformation(getShell(), "Emendation Service Disabled", "You can enable the emendation service via Window -> Preferences -> Melanee -> Workbench.");
					Activator.getDefault().getPreferenceStore().setValue(PreferenceConstants.P_EMENDATION_ENGINE_ACTIVATED, false);
				}
				else
					Activator.getDefault().getPreferenceStore().setValue(PreferenceConstants.P_EMENDATION_ENGINE_ACTIVATED, true);
			}
		});
        
        return composite;
        
//      LocalResourceManager resources
//      	= new LocalResourceManager(JFaceResources.getResources(), getShell());
//		ImageDescriptor title = Activator.getImageDescriptor("/icons/imagetitle.png");
//		setTitleImage(resources.createImage(title));                    
//		setErrorMessage("Error message");
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add Level Element");
	}
	
	@Override
	protected void okPressed() {
		changeOntologicalTypes = changeOntologicalTypesButton.getSelection();
		changeOntologicalInstances = changeOntologicalInstancesButton.getSelection();
		preventDuplicates = preventDuplicatesButton.getSelection();
		addToSupertypesOnly = addToSupertypesOnlyButton.getSelection();
		
		newName = newNameText.getText();
		newDataType = newDataTypeCombo.getText();
		newDurability = newDurabilityText.getText();
		newMutability = newMutabilityText.getText();
		
		if (valuesOK())
			super.okPressed();
		else
			setErrorMessage("Mutability and Durability need to be numeric values. Enter -1 for * value");
	}

	private boolean valuesOK() {
		return newDurabilityText.getText().matches("\\-?\\d*") && newMutabilityText.getText().matches("\\-?\\d*");
	}
}
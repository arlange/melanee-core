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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.melanee.core.workbench.Activator;
import org.melanee.core.workbench.preferences.PreferenceConstants;

public class EmendChangeTraitDialog extends TitleAreaDialog {

	public static final String FEATURE = "feature";

	public static final String CLABJECT = "clabject";
	
	private String target;
	
	public EmendChangeTraitDialog(Shell parentShell, String oldName, String target) {
		super(parentShell);
		newValue = oldName;
		this.target = target;
	}
	
//	Button changeOntologicalTypesButton;
//	Button changeSupertypesButton;
	Button changeNonShallowSubSupertypesButton;
	Text newNameText;
	Button enableServiceButton;
	
	private boolean changeNonShallowSubSupertypes = false;
//	private boolean changeSupertypes = false;
//	private boolean changeOntologicalTypes = true;
	private String newValue = "";
	
	public void setValue(String value){
		newValue = value;
	}
	
	public String getNewValue(){
		return newValue;
	}
	
	public boolean getChangeNonShallowSubSupertypes(){
		return changeNonShallowSubSupertypes;
	}
	
//	public boolean getChangeSupertypes(){
//		return changeSupertypes;
//	}
//	
//	public boolean getChangeOntologicalTypes(){
//		return changeOntologicalTypes;
//	}
	
	@Override
	protected Control createDialogArea(
			Composite parent) {
		
		setTitle("Emend After Change Trait");
	 
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
	    
        Label label = new Label(emendationComposite, SWT.NONE);
        label.setText("New Value");
        
        newNameText = new Text(emendationComposite, SWT.SINGLE | SWT.BORDER);
        GridData newNameTextGridData = new GridData(GridData.FILL_HORIZONTAL);
        newNameTextGridData.grabExcessHorizontalSpace = true;
        newNameText.setLayoutData(newNameTextGridData);
        newNameText.setText(newValue);
        
        GridData optionGridData = new GridData();
        optionGridData.horizontalSpan = 2;
        
        if (target == CLABJECT){
	        changeNonShallowSubSupertypesButton = new Button(emendationComposite, SWT.CHECK);
	        changeNonShallowSubSupertypesButton.setText("Change non shallow sub-/supertypes");
	        changeNonShallowSubSupertypesButton.setLayoutData(optionGridData);
	        changeNonShallowSubSupertypesButton.setSelection(changeNonShallowSubSupertypes);
        }

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
		newShell.setText("Change Trait");
	}
	
	@Override
	protected void okPressed() {
//		changeOntologicalTypes = changeOntologicalTypesButton.getSelection();
//		changeSubtypes = changeSubtypesButton.getSelection();
//		changeSupertypes = changeSupertypesButton.getSelection();
		if (changeNonShallowSubSupertypesButton != null)
			changeNonShallowSubSupertypes = changeNonShallowSubSupertypesButton.getSelection();
		newValue = newNameText.getText();
		super.okPressed();
	}
}
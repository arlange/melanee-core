package org.melanee.core.melanee2metadepth.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup;

@SuppressWarnings("restriction")
public class SelectTargetWizardPage extends WizardPage {

	ContainerSelectionGroup csg;
	
	protected SelectTargetWizardPage(String pageName) {
		super(pageName);

		setTitle("Select container where exported file is created.");
	}

	
	@Override
	public void createControl(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);

		c.setLayout(new GridLayout(1, true));
		
		 csg = new ContainerSelectionGroup(c, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				getContainer().updateButtons();
			}
		}, true);
		
		setControl(c);
	}
	
	public String getSelection(){
		return csg.getContainerFullPath().toString();
	}
	
	@Override
	public boolean isPageComplete() {
		return csg.getContainerFullPath() != null;
	}
}
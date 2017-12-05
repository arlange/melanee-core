package org.melanee.core.modeleditor.editortoolbaritems;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IConstraintLanguageService;

public class ValidateDeepModelAction extends Action {

	private final Domain domain;
	
	public ValidateDeepModelAction(Domain domain) {
		super();
		this.domain = domain;
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		return AbstractUIPlugin.imageDescriptorFromPlugin(org.melanee.core.workbench.Activator.PLUGIN_ID, "/icons/tick.png");
	}
	
	@Override
	public String getToolTipText() {
		return "Validate Deep Model";
	}
	
	@Override
	public void run() {
		try {
			IConstraintLanguageService constraintLanguageService = ExtensionPointService.Instance().getActiveConstraintLanguageService();
			
			if(constraintLanguageService == null)
				return;
			
			DeepModel deepModel = domain.getDeepModel().size() > 0 ? (DeepModel)domain.getDeepModel().get(0) : null;
			if (deepModel == null)
					return;
			
			constraintLanguageService.validate(deepModel, true);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
package org.melanee.core.modeleditor.custom.propertysheet;

import org.eclipse.core.runtime.CoreException;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IApplicationVisualizationService;


public class LinguisticPropertiesSectionFilter extends AbstractPropertiesSectionFilter{

	@Override
	public boolean select(Object toTest) {
		IApplicationVisualizationService service = null;
		
		try {
			service = ExtensionPointService.Instance().getActiveApplicationVisualizationService();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		if (service != null)
			return super.select(toTest) && service.getFilterForLinguisticProperties().select(toTest);
		
		return super.select(toTest);
	}
}
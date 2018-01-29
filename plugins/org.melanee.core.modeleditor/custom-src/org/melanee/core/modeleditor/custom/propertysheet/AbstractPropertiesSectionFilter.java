package org.melanee.core.modeleditor.custom.propertysheet;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;

public class AbstractPropertiesSectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		return toTest instanceof View || toTest instanceof EditPart;
	}

}

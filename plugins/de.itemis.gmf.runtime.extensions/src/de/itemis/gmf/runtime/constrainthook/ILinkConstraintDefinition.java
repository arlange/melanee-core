package de.itemis.gmf.runtime.constrainthook;

import org.eclipse.emf.ecore.EObject;

public interface ILinkConstraintDefinition {

	
	public boolean canCreateLink(int childVisualID, EObject container, EObject source, EObject target);
}

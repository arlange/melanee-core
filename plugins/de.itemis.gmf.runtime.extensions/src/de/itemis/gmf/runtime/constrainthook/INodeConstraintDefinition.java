package de.itemis.gmf.runtime.constrainthook;

import org.eclipse.emf.ecore.EObject;

public interface INodeConstraintDefinition {

	
	public boolean canCreateNode(int childVisualID, EObject container);
}

package de.itemis.gmf.runtime.constrainthook;

import org.eclipse.emf.ecore.EObject;

public class LinkConstraintDefintionResolver {

	
	public static boolean canCreateLink(int childVisualID, EObject container, EObject source, EObject target){
		for(ILinkConstraintDefinition c : ConstraintHookRegistry.getLinkConstraintDefinitions(container)){
			if(!c.canCreateLink(childVisualID, container,source, target))
				return false;
		}
		return true;
	}
}

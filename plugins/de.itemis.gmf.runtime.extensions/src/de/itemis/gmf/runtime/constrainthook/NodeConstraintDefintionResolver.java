package de.itemis.gmf.runtime.constrainthook;

import org.eclipse.emf.ecore.EObject;

public class NodeConstraintDefintionResolver {

  public static boolean canCreateNode(int childVisualID, EObject semanticContainer) {
    for (INodeConstraintDefinition c : ConstraintHookRegistry
        .getNodeConstraintDefinitions(semanticContainer)) {
      if (!c.canCreateNode(childVisualID, semanticContainer))
        return false;
    }
    return true;
  }
}

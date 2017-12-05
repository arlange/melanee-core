package de.itemis.gmf.runtime.constrainthook;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;

public class ConstraintHookRegistry {

	public static ArrayList<ILinkConstraintDefinition> getLinkConstraintDefinitions(EObject container) {
		ArrayList<ILinkConstraintDefinition> result = new ArrayList<ILinkConstraintDefinition>();
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"de.itemis.gmf.runtime.extensions.linkConstraintHook");
		for (IConfigurationElement configurationElement : configurationElements) {
			String definedNsURI = configurationElement.getAttribute("nsURI");
			if (container.eClass().getEPackage().getNsURI().equals(definedNsURI)) {
				try {
					result.add((ILinkConstraintDefinition) configurationElement.createExecutableExtension("class"));
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static List<INodeConstraintDefinition> getNodeConstraintDefinitions(EObject container) {
		List<INodeConstraintDefinition> result = new ArrayList<INodeConstraintDefinition>();
		IConfigurationElement[] configurationElements = getConfigurationElements("de.itemis.gmf.runtime.extensions.nodeConstraintHook");
		for (IConfigurationElement configurationElement : configurationElements) {
			String definedNsURI = configurationElement.getAttribute("nsURI");
			if (container.eClass().getEPackage().getNsURI().equals(definedNsURI)) {
				try {
					result.add((INodeConstraintDefinition) configurationElement.createExecutableExtension("class"));
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static IConfigurationElement[] getConfigurationElements(String id) {
		return Platform.getExtensionRegistry().getConfigurationElementsFor("de.itemis.gmf.runtime.extensions.nodeConstraintHook");
	}
}

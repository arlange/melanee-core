
/*
* *******************************************************************************
* Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*     Ralph Gerbig - initial API and implementation and initial documentation
* *******************************************************************************
*/
package org.melanee.core.modeleditor.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.melanee.core.modeleditor.navigator.PLMNavigatorGroup;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Entity;

/**
 * @generated
 */
public class PLMSheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

	/**
	* @generated
	*/
	public String getText(Object element) {
		element = unwrap(element);
		if (element instanceof PLMNavigatorGroup) {
			return ((PLMNavigatorGroup) element).getGroupName();
		}

		EObject semanticElement = ((IGraphicalEditPart) element).resolveSemanticElement();

		//No Clabject -> Show linguistic type
		if (!(semanticElement instanceof Clabject)) {
			IElementType etype = getElementType(getView(element));
			return etype == null ? "" : etype.getDisplayName();
		}

		EList<Classification> classifications = ((Clabject) semanticElement).getClassificationsAsInstance();

		//No ontological type -> show linguistic type
		if (classifications.size() == 0) {
			IElementType etype = getElementType(getView(element));
			return etype == null ? "" : etype.getDisplayName();
		}

		String typesAsString = "";

		for (Classification i : classifications)
			if (i.getType() instanceof Entity)
				typesAsString += i.getType().getName()
						+ (classifications.indexOf(i) < classifications.size() - 1 ? ", " : "");
			else
				typesAsString += ((Connection) i.getType()).getHumanReadableName()
						+ (classifications.indexOf(i) < classifications.size() - 1 ? ", " : "");

		return typesAsString;
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		IElementType etype = getElementType(getView(unwrap(element)));
		return etype == null ? null : PLMElementTypes.getImage(etype);
	}

	/**
	* @generated
	*/
	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return ((IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

	/**
	* @generated
	*/
	private View getView(Object element) {
		if (element instanceof View) {
			return (View) element;
		}
		if (element instanceof IAdaptable) {
			return (View) ((IAdaptable) element).getAdapter(View.class);
		}
		return null;
	}

	/**
	* @generated
	*/
	private IElementType getElementType(View view) {
		// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
		while (view != null) {
			int vid = PLMVisualIDRegistry.getVisualID(view);
			IElementType etype = PLMElementTypes.getElementType(vid);
			if (etype != null) {
				return etype;
			}
			view = view.eContainer() instanceof View ? (View) view.eContainer() : null;
		}
		return null;
	}

}

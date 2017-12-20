/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * and others All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael GolubevRalph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.implicitconnection.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;


public class EObjectAndElementTypeAdapter extends EObjectAdapter implements
		IElementTypeAwareAdapter {

	private final IElementType myElementType;

	private final int myVisualId;

	public EObjectAndElementTypeAdapter(EObject subject,
			IElementType elementType, int visualId) {

		super(subject);
		myElementType = elementType;
		myVisualId = visualId;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter.isInstance(myElementType)) {
			return myElementType;
		}
		return super.getAdapter(adapter);
	}

	@Override
	public IElementType getElementType() {
		return myElementType;
	}

	@Override
	public int getVisualId() {
		return myVisualId;
	}

	@Override
	public String getSemanticHint() {
		return Integer.toString(myVisualId);
	}
}

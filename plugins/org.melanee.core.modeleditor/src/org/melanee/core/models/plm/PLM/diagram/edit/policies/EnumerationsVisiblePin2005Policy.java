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
package org.melanee.core.models.plm.PLM.diagram.edit.policies;

import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;
import org.melanee.core.modeleditor.edit.parts.DeepModelEditPart;

/**
 * @generated
 */
public class EnumerationsVisiblePin2005Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	* @generated
	*/
	public static final String KEY = "org.melanee.core.models.plm.PLM.diagram.edit.policies.EnumerationsVisiblePin2005Policy:KEY";

	/**
	* @generated
	*/
	public EnumerationsVisiblePin2005Policy() {
		super();
	}

	/**
	* @generated
	*/

	@Override

	protected void setVisualEffectValue(Object value) {
		getHostImpl().getPrimaryShape().getFigureDeepModelEnumerations().setVisible((Boolean) value);

	}

	/**
	* @generated
	*/
	@Override

	protected DeepModelEditPart getHostImpl() {
		return (DeepModelEditPart) super.getHostImpl();
	}

	/**
	* @generated
	*/
	@Override

	protected String getExpressionBody() {
		return "self.enumeration->size() > 0"; //$NON-NLS-1$
	}

}

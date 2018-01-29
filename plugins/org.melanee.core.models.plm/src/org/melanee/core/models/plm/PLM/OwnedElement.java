/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Owned Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getOwnedElement()
 * @model abstract="true"
 * @generated
 */
public interface OwnedElement extends Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns the model the clabject is contained in, recursing up the containment path if necessary.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let parent:ecore::EObject = \r\n\tself.oclAsType(ecore::EObject).eContainer()\r\nin\r\n\tif (parent.oclIsUndefined()) then\r\n\t\tnull\r\n\telse\r\n\t\tif (parent.oclIsTypeOf(Level)) then\r\n\t\t\tparent.oclAsType(Level)\r\n\t\telse\r\n\t\t\tif (parent.oclIsKindOf(Clabject)) then\r\n\t\t\t\tparent.oclAsType(Clabject).getLevel()\r\n\t\t\telse\r\n\t\t\t\tif (parent.oclIsKindOf(Package)) then\r\n\t\t\t\t\tparent.oclAsType(Package).getLevel()\r\n\t\t\t\telse\r\n\t\t\t\t\tnull\r\n\t\t\t\tendif\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif'"
	 * @generated
	 */
	Level getLevel();

} // OwnedElement

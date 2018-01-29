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
package org.melanee.core.models.links.links;

import org.eclipse.emf.ecore.EFactory;

import org.eclipse.emf.ecore.util.EcoreUtil;







/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.melanee.core.models.links.links.LinksPackage
 * @generated
 */
public interface LinksFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinksFactory eINSTANCE = org.melanee.core.models.links.links.impl.LinksFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Linking Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linking Model</em>'.
	 * @generated
	 */
	LinkingModel createLinkingModel();

	/**
	 * Returns a new object of class '<em>Remote Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remote Model</em>'.
	 * @generated
	 */
	RemoteModel createRemoteModel();

	/**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
	Link createLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LinksPackage getLinksPackage();


	
		
		
		  
	
		
		
		  
	
		
		
		  
} //LinksFactory
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.melanee.core.models.links.links.LinksFactory
 * @model kind="package"
 * @generated
 */
public interface LinksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "links";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://melanee.org/links";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "links";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LinksPackage eINSTANCE = org.melanee.core.models.links.links.impl.LinksPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.melanee.core.models.links.links.impl.LinkingModelImpl <em>Linking Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.melanee.core.models.links.links.impl.LinkingModelImpl
	 * @see org.melanee.core.models.links.links.impl.LinksPackageImpl#getLinkingModel()
	 * @generated
	 */
	int LINKING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Remote Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_MODEL__REMOTE_MODELS = 0;

	/**
	 * The number of structural features of the '<em>Linking Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Linking Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKING_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.melanee.core.models.links.links.impl.RemoteModelImpl <em>Remote Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.melanee.core.models.links.links.impl.RemoteModelImpl
	 * @see org.melanee.core.models.links.links.impl.LinksPackageImpl#getRemoteModel()
	 * @generated
	 */
	int REMOTE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_MODEL__LINKS = 0;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_MODEL__URL = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_MODEL__PATH = 2;

	/**
	 * The number of structural features of the '<em>Remote Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Remote Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.melanee.core.models.links.links.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.melanee.core.models.links.links.impl.LinkImpl
	 * @see org.melanee.core.models.links.links.impl.LinksPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 2;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__REVISION = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Source Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE_LOCATION = 3;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.melanee.core.models.links.links.LinkingModel <em>Linking Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linking Model</em>'.
	 * @see org.melanee.core.models.links.links.LinkingModel
	 * @generated
	 */
	EClass getLinkingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.melanee.core.models.links.links.LinkingModel#getRemoteModels <em>Remote Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Remote Models</em>'.
	 * @see org.melanee.core.models.links.links.LinkingModel#getRemoteModels()
	 * @see #getLinkingModel()
	 * @generated
	 */
	EReference getLinkingModel_RemoteModels();

	/**
	 * Returns the meta object for class '{@link org.melanee.core.models.links.links.RemoteModel <em>Remote Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Model</em>'.
	 * @see org.melanee.core.models.links.links.RemoteModel
	 * @generated
	 */
	EClass getRemoteModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.melanee.core.models.links.links.RemoteModel#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.melanee.core.models.links.links.RemoteModel#getLinks()
	 * @see #getRemoteModel()
	 * @generated
	 */
	EReference getRemoteModel_Links();

	/**
	 * Returns the meta object for the attribute '{@link org.melanee.core.models.links.links.RemoteModel#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.melanee.core.models.links.links.RemoteModel#getURL()
	 * @see #getRemoteModel()
	 * @generated
	 */
	EAttribute getRemoteModel_URL();

	/**
	 * Returns the meta object for the attribute '{@link org.melanee.core.models.links.links.RemoteModel#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.melanee.core.models.links.links.RemoteModel#getPath()
	 * @see #getRemoteModel()
	 * @generated
	 */
	EAttribute getRemoteModel_Path();

	/**
	 * Returns the meta object for class '{@link org.melanee.core.models.links.links.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.melanee.core.models.links.links.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute '{@link org.melanee.core.models.links.links.Link#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revision</em>'.
	 * @see org.melanee.core.models.links.links.Link#getRevision()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Revision();

	/**
	 * Returns the meta object for the reference '{@link org.melanee.core.models.links.links.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.melanee.core.models.links.links.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.melanee.core.models.links.links.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.melanee.core.models.links.links.Link#getSource()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.melanee.core.models.links.links.Link#getSourceLocation <em>Source Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Location</em>'.
	 * @see org.melanee.core.models.links.links.Link#getSourceLocation()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_SourceLocation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LinksFactory getLinksFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.melanee.core.models.links.links.impl.LinkingModelImpl <em>Linking Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.melanee.core.models.links.links.impl.LinkingModelImpl
		 * @see org.melanee.core.models.links.links.impl.LinksPackageImpl#getLinkingModel()
		 * @generated
		 */
		EClass LINKING_MODEL = eINSTANCE.getLinkingModel();

		/**
		 * The meta object literal for the '<em><b>Remote Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINKING_MODEL__REMOTE_MODELS = eINSTANCE.getLinkingModel_RemoteModels();

		/**
		 * The meta object literal for the '{@link org.melanee.core.models.links.links.impl.RemoteModelImpl <em>Remote Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.melanee.core.models.links.links.impl.RemoteModelImpl
		 * @see org.melanee.core.models.links.links.impl.LinksPackageImpl#getRemoteModel()
		 * @generated
		 */
		EClass REMOTE_MODEL = eINSTANCE.getRemoteModel();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_MODEL__LINKS = eINSTANCE.getRemoteModel_Links();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_MODEL__URL = eINSTANCE.getRemoteModel_URL();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_MODEL__PATH = eINSTANCE.getRemoteModel_Path();

		/**
		 * The meta object literal for the '{@link org.melanee.core.models.links.links.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.melanee.core.models.links.links.impl.LinkImpl
		 * @see org.melanee.core.models.links.links.impl.LinksPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__REVISION = eINSTANCE.getLink_Revision();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__SOURCE = eINSTANCE.getLink_Source();

		/**
		 * The meta object literal for the '<em><b>Source Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__SOURCE_LOCATION = eINSTANCE.getLink_SourceLocation();

	}

} //LinksPackage

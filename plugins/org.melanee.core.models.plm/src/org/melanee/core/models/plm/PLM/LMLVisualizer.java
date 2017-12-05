/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LML Visualizer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getDslVisualizer <em>Dsl Visualizer</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getName <em>Name</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getXLocation <em>XLocation</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getYLocation <em>YLocation</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getWidth <em>Width</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer()
 * @model
 * @generated
 */
public interface LMLVisualizer extends EObject {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' attribute list.
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_Attributes()
	 * @model
	 * @generated
	 */
	EList<String> getAttributes();

	/**
	 * Returns the value of the '<em><b>Dsl Visualizer</b></em>' containment reference list.
	 * The list contents are of type {@link org.melanee.core.models.plm.PLM.AbstractDSLVisualizer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dsl Visualizer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dsl Visualizer</em>' containment reference list.
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_DslVisualizer()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractDSLVisualizer> getDslVisualizer();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>XLocation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XLocation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XLocation</em>' attribute.
	 * @see #setXLocation(int)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_XLocation()
	 * @model default="-1"
	 * @generated
	 */
	int getXLocation();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getXLocation <em>XLocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XLocation</em>' attribute.
	 * @see #getXLocation()
	 * @generated
	 */
	void setXLocation(int value);

	/**
	 * Returns the value of the '<em><b>YLocation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YLocation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YLocation</em>' attribute.
	 * @see #setYLocation(int)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_YLocation()
	 * @model default="-1"
	 * @generated
	 */
	int getYLocation();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getYLocation <em>YLocation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YLocation</em>' attribute.
	 * @see #getYLocation()
	 * @generated
	 */
	void setYLocation(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_Width()
	 * @model default="-1"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getLMLVisualizer_Height()
	 * @model default="-1"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.LMLVisualizer#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the default visualization values depending on the containing model element.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='-- Trait-related default values for all meta-model elements\r\nlet default:OrderedSet(String) = self.oclAsType(ecore::EObject).eContainer().eClass().eAllAttributes->collect(a | if a.name <> \'levelIndex\' then a.name.concat(\'= default\') else a.name.concat(\'= noshow\') endif)->asOrderedSet()\r\nin\r\n-- Non trait-related default values for Entity\r\nif (self.getContainingElement().oclIsTypeOf(Entity)) then\r\n\tdefault->append(\'ProximityClassification= 1\') -- @deprecated - Do not use anymore\r\n\t\t->append(\'text= derived\')\r\n\t\t->append(\'graph= derived\')\r\n\t\t->append(\'form= derived\')\r\n\t\t->append(\'table= derived\')\r\n\t\t->append(\'app= derived\')\r\n\t\t->append(\'DSLRendering= false\') -- @deprecated - Do not use anymore\r\n\t\t->append(\'ProximityIndication= name:1\')\r\nelse\r\n\t-- Non trait-related default values for Connection\r\n\tif (self.getContainingElement().oclIsTypeOf(Connection)) then\r\n\t\tdefault->append(\'ProximityClassification= 1\') -- @deprecated - Do not use anymore\r\n\t\t\t->append(\'text= derived\')\r\n\t\t\t->append(\'graph= derived\')\r\n\t\t\t->append(\'form= derived\')\r\n\t\t\t->append(\'table= derived\')\r\n\t\t\t->append(\'app= derived\')\r\n\t\t\t->append(\'DSLRendering= false\') -- @deprecated - Do not use anymore\r\n\t\t\t->append(\'ProximityIndication= name:1\')\r\n\t\t\t->append(\'collapsed= false\')\r\n\telse\r\n\t\t-- Non trait-related default values for Inheritance\r\n\t\tif (self.getContainingElement().oclIsTypeOf(Inheritance)) then\r\n\t\t\t\tdefault->append(\'collapsed= false\')\r\n\t\telse\r\n\t\t\t-- Non trait-related default values for DeepModel\r\n\t\t\tif (self.getContainingElement().oclIsTypeOf(DeepModel)) then\r\n\t\t\t\tdefault->append(\'showClassificationConnectionEndNames = false\')\r\n\t\t\t\t->append(\'text= derived\')\r\n\t\t\t\t->append(\'graph= derived\')\r\n\t\t\t\t->append(\'form= derived\')\r\n\t\t\t\t->append(\'table= derived\')\r\n\t\t\t\t->append(\'app= derived\')\r\n\t\t\t-- Non trait-related default values for Level\r\n\t\t\telse\r\n\t\t\t\tif (self.getContainingElement().oclIsTypeOf(Level)) then\r\n\t\t\t\t\tdefault->append(\'text= derived\')\r\n\t\t\t\t\t->append(\'graph= derived\')\r\n\t\t\t\t\t->append(\'form= derived\')\r\n\t\t\t\t\t->append(\'table= derived\')\r\n\t\t\t\t\t->append(\'app= derived\')\r\n\t\t\t\telse\r\n\t\t\t\t\tif (self.getContainingElement().oclIsTypeOf(Package)) then\r\n\t\t\t\t\t\tdefault->append(\'text= derived\')\r\n\t\t\t\t\t\t->append(\'graph= derived\')\r\n\t\t\t\t\t\t->append(\'form= derived\')\r\n\t\t\t\t\t\t->append(\'table= derived\')\r\n\t\t\t\t\t\t->append(\'app= derived\')\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\tdefault\r\n\t\t\t\t\tendif\r\n\t\t\t\tendif\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif'"
	 * @generated
	 */
	EList<String> getDefaultVisualizationValues();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" keyRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let keyValueList : Sequence(String) =\r\n\tself.attributes->select(a | a.size() > key.size())->select(a | a.substring(1, key.size()) = key)->asSequence()\r\nin\r\nlet keyValue : String =\r\n\tif (keyValueList->size() > 0) then\r\n\t\tkeyValueList->first()\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\nlet indexOfEquals:Integer =\r\n\t--Key not found?\r\n\tif (keyValue <> \'\') then\r\n\t\tSequence{1 .. keyValue.size()}->iterate(i:Integer; index:Integer = -1 | \r\n\t\t\tif (index = -1 and keyValue.substring(i,i) = \'=\') then i else index endif)\r\n\telse\r\n\t\t-1\r\n\tendif\r\nin\r\nlet value:String =\r\n\t--No Equals found in keyValue\r\n\tif(indexOfEquals <> -1) then\r\n\t\tkeyValue.substring(indexOfEquals + 1, keyValue.size())\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\nlet valueWithoutLeadingSpace:String = \r\n\t--No value found\r\n\tif (value <> \'\') then\r\n\t\tif (value.substring(1,1) = \' \' and value.size() > 1) then\r\n\t\t\tvalue.substring(2, value.size())\r\n\t\telse\r\n\t\t\tvalue\r\n\t\tendif\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\tvalueWithoutLeadingSpace'"
	 * @generated
	 */
	String getValueForKey(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.oclAsType(ecore::EObject).eContainer().oclAsType(Element)'"
	 * @generated
	 */
	Element getContainingElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void EOperation0();

} // LMLVisualizer

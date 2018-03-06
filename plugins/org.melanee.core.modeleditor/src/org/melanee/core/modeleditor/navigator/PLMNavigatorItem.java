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
package org.melanee.core.modeleditor.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PLMNavigatorItem extends PLMAbstractNavigatorItem {

  /**
   * @generated
   */
  static {
    final Class[] supportedTypes = new Class[] { View.class, EObject.class };
    Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

      public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof org.melanee.core.modeleditor.navigator.PLMNavigatorItem
            && (adapterType == View.class || adapterType == EObject.class)) {
          return ((org.melanee.core.modeleditor.navigator.PLMNavigatorItem) adaptableObject)
              .getView();
        }
        return null;
      }

      public Class[] getAdapterList() {
        return supportedTypes;
      }
    }, org.melanee.core.modeleditor.navigator.PLMNavigatorItem.class);
  }

  /**
   * @generated
   */
  private View myView;

  /**
   * @generated
   */
  private boolean myLeaf = false;

  /**
   * @generated
   */
  public PLMNavigatorItem(View view, Object parent, boolean isLeaf) {
    super(parent);
    myView = view;
    myLeaf = isLeaf;
  }

  /**
   * @generated
   */
  public View getView() {
    return myView;
  }

  /**
   * @generated
   */
  public boolean isLeaf() {
    return myLeaf;
  }

  /**
   * @generated
   */
  public boolean equals(Object obj) {
    if (obj instanceof org.melanee.core.modeleditor.navigator.PLMNavigatorItem) {
      return EcoreUtil.getURI(getView()).equals(EcoreUtil
          .getURI(((org.melanee.core.modeleditor.navigator.PLMNavigatorItem) obj).getView()));
    }
    return super.equals(obj);
  }

  /**
   * @generated
   */
  public int hashCode() {
    return EcoreUtil.getURI(getView()).hashCode();
  }

}

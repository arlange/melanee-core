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
package org.melanee.core.modeleditor.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.ui.URIEditorInput;

/**
 * @generated
 */
public class PLMUriEditorInputTester extends PropertyTester {

  /**
   * @generated
   */
  public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
    if (false == receiver instanceof URIEditorInput) {
      return false;
    }
    URIEditorInput editorInput = (URIEditorInput) receiver;
    return "lml".equals(editorInput.getURI().fileExtension()); //$NON-NLS-1$
  }

}

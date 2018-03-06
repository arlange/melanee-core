/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * and others All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.implicitconnection.commands;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class ElementTypeOnlyAdapter implements IElementTypeAwareAdapter {

  private final IElementType myElementType;

  private final int myVisualId;

  public ElementTypeOnlyAdapter(IElementType elementType, int visualId) {
    myElementType = elementType;
    myVisualId = visualId;
  }

  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
    if (adapter.isInstance(myElementType)) {
      return myElementType;
    }
    return null;
  }

  @Override
  public int getVisualId() {
    return myVisualId;
  }

  @Override
  public IElementType getElementType() {
    return myElementType;
  }

  @Override
  public String getSemanticHint() {
    return Integer.toString(myVisualId);
  }

}

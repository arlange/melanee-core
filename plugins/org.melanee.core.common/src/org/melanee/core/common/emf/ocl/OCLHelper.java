/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.common.emf.ocl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;

public class OCLHelper {

  /**
   * Helper for convenient one line call of OCL expressions
   * 
   * @param context
   *          The eObject which is the context
   * @param expression
   *          expression to execute
   *
   * @return value of evaluated expression
   *
   * @throws ParserException
   */
  public static Object execute(Object context, String expression) throws ParserException {

    EObject eObject = (EObject) context;

    return execute(context, eObject.eClass(), expression);
  }

  /**
   * Helper for convenient one line call of OCL expressions
   * 
   * @param context
   *          The eObject which is the context
   * @param contextLiteral
   *          xxxPackage.Literals.xxx
   * @param expression
   *          expression to execute
   *
   * @return value of evaluated expression
   *
   * @throws ParserException
   */
  public static Object execute(Object context, EClassifier contextLiteral, String expression)
      throws ParserException {
    OCL ocl = OCL.newInstance();

    org.eclipse.ocl.helper.OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();
    helper.setContext(contextLiteral);

    OCLExpression<EClassifier> q = helper.createQuery(expression);
    return ocl.evaluate(context, q);
  }
}

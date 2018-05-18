/*******************************************************************************
 * Copyright (c) 2014 - 2016 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.workbench.interfaces;

import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.swt.widgets.Composite;
import org.melanee.core.models.plm.PLM.AbstractConstraint;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Element;

public interface IConstraintLanguageService {

  public static final String CONSTRAINT_KIND_PRE = "pre";
  public static final String CONSTRAINT_KIND_POST = "post";
  public static final String CONSTRAINT_KIND_BODY = "body";
  public static final String CONSTRAINT_KIND_DEF = "def";

  public static final String CONSTRAINT_KIND_INVARIANT = "inv";

  public static final String CONSTRAINT_KIND_INIT = "init";
  public static final String CONSTRAINT_KIND_DERIVE = "derive";

  /**
   * Evaluates an expression in a constraint language
   * 
   * @param context
   *          the object on which the expression is evaluated
   * @param expression
   *          the expression to evaluate
   * 
   * @return The result of the evaluation
   */
  public Object evaluate(Object context, String expression) throws Exception;

  /**
   * 
   * @param definitionContext
   *          the context on which the expression is defined (e.g. if an invariant
   *          is defined on a higher level )
   * @param context
   *          the object on which the expression is evaluated
   * @param expression
   *          the expression to evaluate
   * 
   * @return The result of the evaluation
   */
  public Object evaluate(Object definitionContext, Object context, String expression)
      throws Exception;

  /**
   * Returns the definition the constraints defined on definition context.
   * 
   * @param definitionContext
   *          Model element to retrieve constraints for.
   * @return Set of Strings which uniquely identify the constraints. This set of
   *         Strings is displayed on the UI. Null if feature is not supported by
   *         service.
   */
  public String[] getDefinedConstraintsFor(Element definitionContext);

  /**
   * Returns the possible kinds of constraints which can be defined on
   * definitionContext, e.g. around, pre, post.
   * 
   * @param definitionContext
   *          Model element for which the possible constraints are derived.
   * @return Returns a set of unique identifiers for the constraints which are
   *         definable on definitionContext. See static variables of this
   *         interface. Set of available constraints can be extended as needed.
   *         Returns null if feature is not supported by service. Strings are
   *         displayed on UI.
   */
  public String[] getPossibleConstraintKindsFor(Element definitionContext);

  /**
   * Adds a new constraint of a given kind to a definition context
   * 
   * @param definitionContext
   *          Model element to create the constraint for.
   * @param constraintKind
   *          Constraint kind of which to create a constraint. See e.g. static
   *          variables in this interface.
   * @return A newly created constraint. Null if not supported by service.
   */
  public AbstractConstraint addConstraint(Element definitionContext, String constraintKind);

  /**
   * Gets a constraint from a definition context.
   * 
   * @param definitionContext
   *          Model element to retrieve the constraint from
   * @param constraintName
   *          Unique name of the constraint to retrieve
   * @return The constraint with the given name. Null if not supported by service.
   */
  public AbstractConstraint getConstraint(Element definitionContext, String constraintName);

  /**
   * Deletes a given constraint from the definition context.
   * 
   * @param definitionContext
   *          Model element to delete the constraint from
   * @param constraintName
   *          Unique id of constraint to delete
   * @throws UnsupportedOperationException
   *           The service does not support the operation
   */
  public void deleteConstraint(Element definitionContext, String constraintName)
      throws UnsupportedOperationException;

  /**
   * Returns a composite containing all controls needed to edit a constraint.
   * 
   * @param constraint
   *          Constraint to edit.
   * @param widgetFactory
   *          TabbedPropertySheetWidgetFactory used to create widgets in the
   *          composite
   * @param editingArea
   *          the composite in the properties page into which the newly created
   *          composite is added
   * @return Composite which is placed in the properties sheet. Null if not
   *         supported by interface.
   */
  public ConstraintPropertySheetComposite getPropertySheetCompositeFor(
      AbstractConstraint constraint, Object widgetFactory, Composite editingArea,
      Element definitionContext);

  /**
   * Validates a model from the given element. The validate method used the
   * execute methods for execution of the constraints.
   * 
   * @param element
   *          the element to start validation from. The following is
   *          possible:<br />
   *          DeepModel: All constraints are validated.<br />
   *          Level: All constraints starting from the specified level are
   *          validated.<br />
   *          Clabject: The classification hierarchy of the clabject its supertype
   *          and content is validated.
   * @param createResourceMarkers
   *          whether to create resource markers
   * @return the validation results
   */
  public Set<IValidationResult> validate(Element element, boolean createResourceMarkers);

  /**
   * Sets the initial value of an attribute after creation,
   * 
   * @param attribute
   *          attribute which gets its initial value set
   * @return a EMF SetCommand for setting the initial value of the attribute; null
   *         if no initial value is set.
   */
  public Command initAttribute(Attribute attribute);

  /**
   * Recalculates all derived values when anything except a deep model or level
   * changes. Note: a level deletion invokes this operation for each deleted
   * clabject.
   * 
   * @param element
   *          the changed element (e.g. added, value changed, deleted etc.)
   * @param changeType
   *          type of change (e.g. add, delete). Types known by EMF's
   *          ENotificationImpl
   * @return a command which updates the values of all effected attributes; null
   *         if no attribute is effected.
   */
  public Command recalculateDerivedAttributes(Element element, int changeType);

  /**
   * Composite which is place in the property sheet for editing constraints
   *
   */
  public abstract class ConstraintPropertySheetComposite extends Composite {

    public ConstraintPropertySheetComposite(Composite parent, int style) {
      super(parent, style);
    }

    /**
     * Finishes editing of constraint. Write changes made in the composite to the
     * model. Does NOT save changes in the abstract model to hard disk.
     */
    public abstract void save();

    /**
     * Start editing of constraint.
     */
    public abstract void edit();

    /**
     * Aborts editing and resets composite.
     */
    public abstract void cancel();
  }

  /**
   * Interface for communication the results of a validation run
   */
  public interface IValidationResult {
    /**
     * The severity of the constraint result as known by Melanee
     */
    public enum ValidationResultSeverity {
      error, warning, information
    }

    ValidationResultSeverity getSeverity();

    String getMessage();

    Element getObject();
  }
}
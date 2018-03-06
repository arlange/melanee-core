/*******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.emendation.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IEmendationService;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;
import org.melanee.core.workbench.preferences.PreferenceConstants;

/**
 * The emendation obeserver is responsible for detecting the different classes
 * of changes made to a model (e.g. change trait, delete clabject). After
 * detecting these changes, a call to the active emendation service is made
 * which supports the user in doing changes to the model. The emendation
 * observer comes with a default emendation service in case that no emendation
 * service is provided.
 *
 */
public class EmendationObserver implements ResourceSetListener {

  public static String ID = "org.melanee.core.emendation.service";
  private boolean runService;

  private static EmendationObserver service = null;

  public static EmendationObserver getInstance() {
    if (service == null)
      service = new EmendationObserver();

    return service;
  }

  /**
   * This is stores the emended model elements. After emendation the service is
   * called a second time as all emended model elements are changes :). The
   * service then checks if called if the model element was changed by the service
   * (in the set) or user (not in the set). If the model element is changed by the
   * service no emendation is executed.
   */
  Set<EObject> emendedObjects = new HashSet<EObject>();

  /**
   * Starts listening for changes to the P_EMENDATION_ENGINE_ACTIVATED setting.
   */
  private void listenForActivateEmendationServicePropertyChange() {

    runService = org.melanee.core.workbench.Activator.getDefault().getPreferenceStore()
        .getBoolean(PreferenceConstants.P_EMENDATION_ENGINE_ACTIVATED);

    org.melanee.core.workbench.Activator.getDefault().getPreferenceStore()
        .addPropertyChangeListener(new IPropertyChangeListener() {

          @Override
          public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(PreferenceConstants.P_EMENDATION_ENGINE_ACTIVATED))
              runService = ((Boolean) event.getNewValue()).booleanValue();
          }
        });
  }

  /**
   * Start listening to the model which is passed over as parameter. This method
   * adds a new listener to each model. The previously listened models are still
   * listened aftre listening to a new model. Use stopListening(modelRoot) to stop
   * listening to changes of a model.
   * 
   * @param modelRoot
   *          Model to listen for changes.
   */
  public void startListening(EObject modelRoot) {
    // The user shall switch on/off the service
    listenForActivateEmendationServicePropertyChange();
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelRoot);
    domain.addResourceSetListener(this);
  }

  /**
   * Stops listening for changes to a model.
   * 
   * @param modelRoot
   *          Model to stop listen for changes.
   */
  public void stopListening(EObject modelRoot) {
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelRoot);
    domain.removeResourceSetListener(this);
  }

  @Override
  public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {

    IEmendationService service = null;
    try {
      service = ExtensionPointService.Instance().getActiveEmendationService();
    } catch (CoreException e) {
      e.printStackTrace();
    }

    // There is no service or the service is paused
    if (service == null || service.isPaused())
      return null;

    // The user switched off to run the service.
    if (!runService)
      return null;

    boolean entityAddedToModel = false;

    Notification addNotification = null;
    Notification removeNotification = null;

    // **************************************
    // Check if move operation
    // **************************************
    for (Notification notification : event.getNotifications()) {
      if (notification.getEventType() == Notification.REMOVE
          && notification.getNotifier() instanceof Element)
        removeNotification = notification;
      else if (notification.getEventType() == Notification.ADD
          && notification.getNotifier() instanceof Element)
        addNotification = notification;
    }

    // **************************************
    // Handle move operation
    // **************************************
    if (removeNotification != null && addNotification != null
        && removeNotification.getOldValue() == addNotification.getNewValue()) {

      if (emendedObjects.contains(addNotification.getNotifier())) {
        emendedObjects.remove(addNotification.getNotifier());
        emendedObjects.clear();
        return null;
      }

      // ImpactAnalyzer analyzer = new ImpactAnalyzer();
      // Collection<EObject> affectedModelElements =
      // analyzer.getAffectedModelElementsForMoveFeatureOperation((Clabject)removeNotification.getNotifier(),
      // (Clabject)addNotification.getNotifier(),
      // (Feature)addNotification.getNewValue());
      Command command = service.handleMoveAttributeOperation(
          (Clabject) removeNotification.getNotifier(), (Clabject) addNotification.getNotifier(),
          (Feature) addNotification.getNewValue());
      emendedObjects.clear();
      emendedObjects.addAll(service.getEmendedObjects(command));
      return command;
    }

    // Check if Entity is added to model
    for (Notification n : event.getNotifications()) {
      entityAddedToModel = n.getNotifier() instanceof Level;
      if (entityAddedToModel)
        return null;
    }

    // *********************************************
    // Level trait change
    // *********************************************
    for (Notification notification : event.getNotifications())

      // NO DELETE
      if ((notification.getNotifier() instanceof Clabject
          || notification.getNotifier() instanceof Feature) && notification.getNewValue() != null) {
        // *********************************************
        // Emend Feature Trait Change
        // *********************************************
        if (notification.getFeature() instanceof EStructuralFeature
            && notification.getNotifier() instanceof Feature
            && (((EStructuralFeature) notification.getFeature()).getName().equals("name")
                || ((EStructuralFeature) notification.getFeature()).getName().equals("durability")
                || ((EStructuralFeature) notification.getFeature()).getName().equals("mutability")
                // || ((EStructuralFeature)notification.getFeature()).getName().equals("value")
                || ((EStructuralFeature) notification.getFeature()).getName().equals("datatype"))) {
          // We got triggered after a modification to an clabject which is not relevant
          // for a trait change
          if ((emendedObjects.iterator().hasNext()
              && !(emendedObjects.iterator().next() instanceof Feature))) {
            emendedObjects.clear();
            break;
          }

          // We got triggered after an attribute trait change
          if (emendedObjects.contains(notification.getNotifier())) {
            emendedObjects.remove(notification.getNotifier());
            continue;
          }

          IImpactAnalyzer analyzer = service.getImpactAnalyzer();
          Collection<Feature> affectedModelElements = analyzer
              .getAffectedModelElementsForChangeTraitFeatureOperation(
                  (Feature) notification.getNotifier(), notification.getOldStringValue(),
                  (EStructuralFeature) notification.getFeature());
          if (affectedModelElements.size() > 0) {
            Command command = service.handleChangeFeatureTraitOperation(
                (Feature) notification.getNotifier(),
                (EStructuralFeature) notification.getFeature(), notification.getOldStringValue(),
                notification.getNewStringValue());
            emendedObjects.clear();
            // In case command is null no objects will be emended
            if (command != null)
              emendedObjects.addAll(service.getEmendedObjects(command));
            return command;
          }
        }
        // *********************************************
        // Emend Clabject Trait change
        // *********************************************
        else if (notification.getFeature() instanceof EStructuralFeature
            && ((EStructuralFeature) notification.getFeature()).getName().equals("potency")
            && notification.getOldIntValue() != notification.getNewIntValue()) {
          if (emendedObjects.contains(notification.getNotifier())) {
            emendedObjects.remove(notification.getNotifier());
            continue;
          }

          IImpactAnalyzer analyzer = service.getImpactAnalyzer();
          Collection<Clabject> affectedModelElements = analyzer
              .getAffectedModelElementsForChangeTraitClabjectOperation(
                  (Clabject) notification.getNotifier(), notification.getOldStringValue(),
                  (EStructuralFeature) notification.getFeature(), true);
          if (affectedModelElements.size() > 0) {
            Command command = service.handleChangeClabjectTraitOpertation(
                (Clabject) notification.getNotifier(),
                (EStructuralFeature) notification.getFeature(), notification.getOldStringValue(),
                notification.getNewStringValue());
            emendedObjects.clear();
            // In case command is null no objects will be emended
            if (command != null)
              emendedObjects.addAll(service.getEmendedObjects(command));
            return command;
          }
        }
        // *********************************************
        // Emend Clabject feature change (ADD)
        // *********************************************

        // Feature is added
        else if (notification.getFeature() instanceof EStructuralFeature
            && ((EStructuralFeature) notification.getFeature()).getName().equals("feature")
            && notification.getNewValue() instanceof Attribute) {
          if (emendedObjects.contains(notification.getNotifier())) {
            emendedObjects.remove(notification.getNotifier());
            continue;
          }

          IImpactAnalyzer analyzer = service.getImpactAnalyzer();
          Collection<Clabject> affectedModelElements = analyzer
              .getAffectedModelElementsForAddFeatureOperation((Clabject) notification.getNotifier(),
                  (Feature) notification.getNewValue());
          if (affectedModelElements.size() > 0) {
            Command command = service.handleAddAttributeOperation(
                (Clabject) notification.getNotifier(), (Feature) notification.getNewValue());
            // In case command is null no objects will be emended
            if (command != null)
              emendedObjects.addAll(service.getEmendedObjects(command));
            return command;
          }
        }
      }
      // *********************************************
      // DELETE OPERATIONS
      // *********************************************
      else if ((notification.getNotifier() instanceof Clabject
          || notification.getNotifier() instanceof Feature) && notification.getNewValue() == null) {

        // *********************************************
        // Emend Clabject feature change (DELETE)
        // *********************************************
        if (notification.getFeature() instanceof EStructuralFeature
            && ((EStructuralFeature) notification.getFeature()).getName().equals("feature")
            && notification.getNewValue() == null) {

          if (emendedObjects.contains(notification.getOldValue())) {
            emendedObjects.remove(notification.getNotifier());
            continue;
          }

          IImpactAnalyzer analyzer = service.getImpactAnalyzer();
          Collection<Feature> affectedModelElements = analyzer
              .getAffectedModelElementsForDeleteFeatureOperation(
                  (Feature) notification.getOldValue(), (Clabject) notification.getNotifier());

          if (affectedModelElements.size() > 0) {
            Command command = service.handleRemoveAttributeOperation(
                (Clabject) notification.getNotifier(), (Feature) notification.getOldValue());
            emendedObjects.clear();
            // In case command is null no objects will be emended
            if (command != null)
              emendedObjects.addAll(service.getEmendedObjects(command));
            return command;
          }
        }
      }

    return null;
  }

  @Override
  public NotificationFilter getFilter() {
    return null;
  }

  @Override
  public void resourceSetChanged(ResourceSetChangeEvent event) {

  }

  @Override
  public boolean isAggregatePrecommitListener() {
    return false;
  }

  @Override
  public boolean isPrecommitOnly() {
    return true;
  }

  @Override
  public boolean isPostcommitOnly() {
    return false;
  }
}
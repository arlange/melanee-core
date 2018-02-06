/*******************************************************************************
 * Copyright (c) 2016 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.propertysheet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.melanee.core.models.plm.PLM.AbstractConstraint;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IConstraintLanguageService;
import org.melanee.core.workbench.interfaces.IConstraintLanguageService.ConstraintPropertySheetComposite;

public class ConstraintPropertySectionAbstractPropertySection extends AbstractPropertySection {

	public ConstraintPropertySectionAbstractPropertySection() {
		// TODO Auto-generated constructor stub
	}

	private IGraphicalEditPart selectedElement = null;
	private Element selectedSemanticElement = null;

	private CCombo constraintSelectionCombo = null;

	private Composite editingAreaComposite = null;
	private ConstraintPropertySheetComposite constraintComposite = null;
	private Composite sectionComposite = null;

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		constraintSelectionCombo.removeAll();
		IConstraintLanguageService constraintLanguageService = getActiveConstraintLanguageService();

		if (constraintLanguageService == null)
			return;

		if (selection instanceof StructuredSelection
				&& ((StructuredSelection) selection).getFirstElement() instanceof IGraphicalEditPart
				&& ((IGraphicalEditPart) ((StructuredSelection) selection).getFirstElement())
						.resolveSemanticElement() instanceof Element) {
			selectedElement = (IGraphicalEditPart) ((StructuredSelection) selection).getFirstElement();
			selectedSemanticElement = (Element) selectedElement.resolveSemanticElement();

			String[] constraintList = constraintLanguageService.getDefinedConstraintsFor(selectedSemanticElement);
			if (constraintList != null) {
				constraintSelectionCombo.setItems(constraintList);
			}
		}

		if (constraintComposite != null) {
			constraintComposite.dispose();
			sectionComposite.requestLayout();
			editingAreaComposite.layout(true, true);
		}
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		sectionComposite = getWidgetFactory().createFlatFormComposite(parent);
		GridLayout gl = new GridLayout(4, false);

		sectionComposite.setLayout(gl);
		CLabel constraintSelectionLabel = getWidgetFactory().createCLabel(sectionComposite, "Constraint");
		constraintSelectionCombo = getWidgetFactory().createCCombo(sectionComposite);
		constraintSelectionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		createConstraintSelectionComboSelectionListener();

		final Button addButton = getWidgetFactory().createButton(sectionComposite, "Add", SWT.NONE);
		addButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				IConstraintLanguageService constraintLanguageService = getActiveConstraintLanguageService();

				if (constraintLanguageService == null)
					return;

				Menu addButtonMenu = createMenuForAddButton(
						constraintLanguageService.getPossibleConstraintKindsFor(selectedSemanticElement), addButton);
				if (addButtonMenu == null)
					return;

				Point location = new Point(addButton.getLocation().x,
						addButton.getLocation().y + addButton.getBounds().height);
				location = addButton.getShell().getDisplay().map(addButton.getParent(), null, location);
				addButtonMenu.setLocation(location);

				addButtonMenu.setVisible(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("add Button");
			}
		});

		Button removeButton = getWidgetFactory().createButton(sectionComposite, "Remove", SWT.NONE);
		removeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IConstraintLanguageService constraintLanguageService = getActiveConstraintLanguageService();
				if (constraintLanguageService == null)
					return;
				try {
					constraintLanguageService.deleteConstraint(selectedSemanticElement,
							constraintSelectionCombo.getText());
					constraintSelectionCombo
							.setData(constraintLanguageService.getDefinedConstraintsFor(selectedSemanticElement));
					constraintSelectionCombo.deselect(0);
					constraintComposite.dispose();
					sectionComposite.requestLayout();
					editingAreaComposite.layout(true, true);
				} catch (UnsupportedOperationException ex) {
					System.out.println("Operation not supported by active constraint service");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing
			}
		});

		editingAreaComposite = getWidgetFactory().createComposite(sectionComposite);
		editingAreaComposite.setLayout(new FillLayout());
		GridData editingAreaGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		editingAreaGridData.horizontalSpan = 4;
		editingAreaComposite.setLayoutData(editingAreaGridData);

		CLabel selectConstraintLanguageServiceLabel = getWidgetFactory().createCLabel(editingAreaComposite,
				"Select Constraint Language Service");

		final Button cancelButton = getWidgetFactory().createButton(sectionComposite, "Cancel", SWT.NONE);
		cancelButton.setEnabled(false);
		GridData cancelButtonGridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		cancelButtonGridData.horizontalSpan = 2;
		cancelButton.setLayoutData(cancelButtonGridData);

		final Button saveButton = getWidgetFactory().createButton(sectionComposite, "Save", SWT.NONE);
		saveButton.setEnabled(false);

		final Button editButton = getWidgetFactory().createButton(sectionComposite, "Edit", SWT.NONE);

		cancelButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (constraintComposite != null) {
					constraintComposite.cancel();
					cancelButton.setEnabled(false);
					saveButton.setEnabled(false);
					editButton.setEnabled(true);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing
			}
		});

		saveButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (constraintComposite != null) {
					constraintComposite.save();
					cancelButton.setEnabled(false);
					saveButton.setEnabled(false);
					editButton.setEnabled(true);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing
			}
		});

		editButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (constraintComposite != null) {
					constraintComposite.edit();
					cancelButton.setEnabled(true);
					saveButton.setEnabled(true);
					editButton.setEnabled(false);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing
			}
		});
	}

	private void createConstraintSelectionComboSelectionListener() {
		constraintSelectionCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				for (Control control : editingAreaComposite.getChildren())
					control.dispose();

				editingAreaComposite.layout(true);

				int selectionIndex = ((CCombo) e.getSource()).getSelectionIndex();

				IConstraintLanguageService constraintLanguageService = getActiveConstraintLanguageService();
				if (constraintLanguageService == null || selectionIndex < 0) {
					editingAreaComposite.redraw();
					constraintComposite.redraw();
					return;
				}

				String text = ((CCombo) e.getSource()).getItems()[selectionIndex];
				constraintComposite = constraintLanguageService.getPropertySheetCompositeFor(
						constraintLanguageService.getConstraint(selectedSemanticElement, text), getWidgetFactory(),
						editingAreaComposite, selectedSemanticElement);

				if (sectionComposite != null) {
					sectionComposite.requestLayout();
					editingAreaComposite.layout(true, true);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing

			}
		});
	}

	/**
	 * Creats a Menu for the add Button from the given possible constraints
	 * 
	 * @param possibleConstraintKinds
	 *            constraint kinds to create the menu for
	 * @param addButton
	 *            the button to create the menu for
	 * @return The menu for the button or null if possibleConstraintKinds is null
	 */
	private Menu createMenuForAddButton(String[] possibleConstraintKinds, Button addButton) {

		if (possibleConstraintKinds == null)
			return null;

		Menu addButtonMenu = new Menu(addButton);

		for (String constraintKind : possibleConstraintKinds) {

			MenuItem item = new MenuItem(addButtonMenu, SWT.PUSH);
			item.setText(constraintKind);
			item.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					IConstraintLanguageService constraintLanguageService = getActiveConstraintLanguageService();
					AbstractConstraint addedConstraint = constraintLanguageService
							.addConstraint(selectedSemanticElement, ((MenuItem) e.getSource()).getText());
					constraintSelectionCombo
							.setItems(constraintLanguageService.getDefinedConstraintsFor(selectedSemanticElement));

					if (addedConstraint != null)
						if (addedConstraint.getName() != null)
							constraintSelectionCombo
									.select(constraintSelectionCombo.indexOf(addedConstraint.getName()));
					constraintSelectionCombo.notifyListeners(SWT.Selection, new Event());

					if (constraintComposite != null) {
						constraintComposite.getShell().layout(true, true);
						// constraintComposite.dispose();
						sectionComposite.requestLayout();
						editingAreaComposite.layout(true, true);
					} else {
						editingAreaComposite.redraw();
						constraintComposite.redraw();
					}
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// Do nothing
				}
			});
		}
		return addButtonMenu;
	}

	/**
	 * Gets the currently active constraint language service
	 * 
	 * @return returns currently activated constraint language service. Null if no
	 *         constraint language service is installed or if something goes wrong
	 *         while loading.
	 */
	private IConstraintLanguageService getActiveConstraintLanguageService() {
		try {
			return ExtensionPointService.Instance().getActiveConstraintLanguageService();
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return null;
	}
}
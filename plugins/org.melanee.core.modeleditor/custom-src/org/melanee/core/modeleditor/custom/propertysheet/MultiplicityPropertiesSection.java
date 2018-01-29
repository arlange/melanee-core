/*******************************************************************************
 * Copyright (c) 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Aaron CHANG - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.propertysheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.Multiplicity;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * 
 * This class is the properties section which handles multiplicity
 *
 */
public class MultiplicityPropertiesSection extends AbstractPropertySection {

	private IGraphicalEditPart selectedElement = null;
	private ConnectionEnd selectedConnectionEnd = null;

	CCombo multiplicitySelectionCombo = null;
	List<Multiplicity> multiplicities = null;
	TableViewer viewer;
	int selectedIndex = 0;
	private ISelection selection;
	private IWorkbenchPart part;

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		this.part = part;
		this.selection = selection;

		if (selection instanceof StructuredSelection
				&& ((StructuredSelection) selection).getFirstElement() instanceof IGraphicalEditPart)
			selectedElement = (IGraphicalEditPart) ((StructuredSelection) selection).getFirstElement();

		multiplicitySelectionCombo.removeAll();

		if (multiplicitySelectionCombo == null || !(selectedElement.resolveSemanticElement() instanceof ConnectionEnd)){
			multiplicityPropertiesViewReset();
			return;
		}

		selectedConnectionEnd = (ConnectionEnd) selectedElement.resolveSemanticElement();

		for (Multiplicity m : selectedConnectionEnd.getMultiplicity())
			multiplicitySelectionCombo
					.add("Multiplicity: " + m.getLower() + ".." + m.getUpper() + "^" + m.getPotency());

		multiplicities = selectedConnectionEnd.getMultiplicity();

		if (multiplicitySelectionCombo.getItems().length > 0) {
			if (selectedIndex > multiplicities.size() - 1)
				selectedIndex = 0;

			multiplicitySelectionCombo.select(selectedIndex);

			List<String> multiplicitiesValues = new ArrayList<String>();
			multiplicitiesValues.add("Lower=" + String.valueOf(multiplicities.get(selectedIndex).getLower()));
			multiplicitiesValues.add("Upper=" + String.valueOf(multiplicities.get(selectedIndex).getUpper()));
			multiplicitiesValues.add("Potency=" + String.valueOf(multiplicities.get(selectedIndex).getPotency()));

			viewer.setInput(multiplicitiesValues);
			viewer.refresh();
		}else{
			multiplicityPropertiesViewReset();
		}
	}

	private void multiplicityPropertiesViewReset() {
		viewer.setInput(null);
		viewer.refresh();
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory().createFlatFormComposite(parent);

		GridLayout gl = new GridLayout(5, false);
		composite.setLayout(gl);

		CLabel visualizerSelectionLabel = getWidgetFactory().createCLabel(composite, "Multiplicity");

		multiplicitySelectionCombo = getWidgetFactory().createCCombo(composite);

		Button addButton = getWidgetFactory().createButton(composite, "Add", SWT.NONE);
		addButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if (multiplicitySelectionCombo != null
						|| (selectedElement.resolveSemanticElement() instanceof ConnectionEnd)) {

					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selectedConnectionEnd);
					Multiplicity newMultiplicity = PLMFactory.eINSTANCE.createMultiplicity();
					Command addMultiplicityCommand = AddCommand.create(domain, selectedConnectionEnd,
							PLMPackage.eINSTANCE.getConnectionEnd_Multiplicity(), newMultiplicity);
					domain.getCommandStack().execute(addMultiplicityCommand);

					List<String> multiplicitiesValues = new ArrayList<String>();
					multiplicitiesValues.add("Lower=" + 0);
					multiplicitiesValues.add("Upper=" + -1);
					multiplicitiesValues.add("Potency=" + 1);

					selectedIndex = multiplicities.size() - 1;

					viewer.refresh();
					setInput(part, selection);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}

		});

		Button removeButton = getWidgetFactory().createButton(composite, "Remove", SWT.NONE);
		removeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if (multiplicitySelectionCombo != null
						|| (selectedElement.resolveSemanticElement() instanceof ConnectionEnd)) {

					selectedIndex = multiplicitySelectionCombo.getSelectionIndex();

					Multiplicity multiplicity = multiplicities.get(selectedIndex);

					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selectedConnectionEnd);

					Command removeMultiplicityCommand = DeleteCommand.create(domain, multiplicity);

					domain.getCommandStack().execute(removeMultiplicityCommand);

					viewer.refresh();

					setInput(part, selection);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}

		});

		viewer = new TableViewer(composite, SWT.FULL_SELECTION);

		multiplicitySelectionCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				List<String> multiplicitiesValues = new ArrayList<String>();
				multiplicitiesValues.add("Lower="
						+ String.valueOf(multiplicities.get(multiplicitySelectionCombo.getSelectionIndex()).getLower())
								.toString());
				multiplicitiesValues.add("Upper="
						+ String.valueOf(multiplicities.get(multiplicitySelectionCombo.getSelectionIndex()).getUpper())
								.toString());
				multiplicitiesValues
						.add("Potency=" + String
								.valueOf(
										multiplicities.get(multiplicitySelectionCombo.getSelectionIndex()).getPotency())
								.toString());
				viewer.setInput(multiplicitiesValues);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

				List<String> multiplicitiesValues = getMultiplicityList();
				viewer.setInput(multiplicitiesValues);
			}
		});

		GridData visualizerComboData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		multiplicitySelectionCombo.setLayoutData(visualizerComboData);

		Table table = viewer.getTable();

		GridData tableGridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		tableGridData.horizontalSpan = 5;

		table.setLayoutData(tableGridData);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Add ContentProviders
		viewer.setContentProvider(new VisualizerContentProvider());

		TableViewerColumn keyColumn = new TableViewerColumn(viewer, SWT.NONE);
		keyColumn.getColumn().setText("Name");
		keyColumn.getColumn().setWidth(200);

		keyColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				String keyValuePair = (String) cell.getElement();
				String key = keyValuePair.substring(0, keyValuePair.indexOf("=")).trim();
				cell.setText(key);
			}
		});

		TableViewerColumn valueColumn = new TableViewerColumn(viewer, SWT.NONE);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setWidth(100);

		valueColumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				String keyValuePair = (String) cell.getElement();
				int equalIndex = keyValuePair.indexOf("=") + 1;
				String value = keyValuePair.substring(equalIndex, keyValuePair.length()).trim();
				cell.setText(value);
			}
		});

		valueColumn.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected void setValue(Object element, Object value) {

				selectedIndex = multiplicitySelectionCombo.getSelectionIndex();
				Multiplicity multiplicity = multiplicities.get(selectedIndex);

				String keyValuePair = (String) element;

				// String oldValue =
				// keyValuePair.substring(keyValuePair.indexOf("=") + 1).trim();
				String key = keyValuePair.substring(0, keyValuePair.indexOf("=")).trim();

				String newAttrValue = (String) value;

				Multiplicity newMultiplicity = PLMFactory.eINSTANCE.createMultiplicity();
				newMultiplicity.setLower(multiplicity.getLower());
				newMultiplicity.setUpper(multiplicity.getUpper());
				newMultiplicity.setPotency(multiplicity.getPotency());

				if (key.equals("Lower")) {
					newMultiplicity.setLower(Integer.valueOf(newAttrValue));
				} else if (key.equals("Upper")) {
					newMultiplicity.setUpper(Integer.valueOf(newAttrValue));
				} else if (key.equals("Potency")) {
					newMultiplicity.setPotency(Integer.valueOf(newAttrValue));
				}

				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selectedConnectionEnd);

				Command editMultiplicityCommand = new ReplaceCommand(domain, selectedConnectionEnd,
						PLMPackage.eINSTANCE.getConnectionEnd_Multiplicity(), multiplicity, newMultiplicity);

				domain.getCommandStack().execute(editMultiplicityCommand);

				viewer.refresh();

				setInput(part, selection);
			}

			@Override
			protected Object getValue(Object element) {
				String keyValuePair = (String) element;
				int equalIndex = keyValuePair.indexOf("=") + 1;
				String value = keyValuePair.substring(equalIndex, keyValuePair.length()).trim();
				return value;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {

				// String keyValuePair = (String) element;
				// int equalIndex = keyValuePair.indexOf("=") + 1;
				// String value = keyValuePair.substring(equalIndex,
				// keyValuePair.length()).trim();
				//
				// if ("false".equals(value) || "true".equals(value)) {
				// ComboBoxViewerCellEditor cb = new
				// ComboBoxViewerCellEditor(viewer.getTable());
				// cb.setContentProvider(ArrayContentProvider.getInstance());
				// cb.setInput(new String[] { "true", "false" });
				// return cb;
				// } else if ("default".equals(value) || "tvs".equals(value) ||
				// "noshow".equals(value)
				// || "max".equals(value)) {
				// ComboBoxViewerCellEditor cb = new
				// ComboBoxViewerCellEditor(viewer.getTable());
				// cb.setContentProvider(ArrayContentProvider.getInstance());
				// cb.setInput(new String[] { "default", "tvs", "noshow", "max",
				// "show" });
				// return cb;
				// }
				return new TextCellEditor(viewer.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
	}

	private class VisualizerContentProvider extends ArrayContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {

			// Durability needs to be added
			LinkedList<Object> elementsPlusTraits = new LinkedList<Object>();
			// Append the attributes list
			elementsPlusTraits.addAll(Arrays.asList(super.getElements(inputElement)));

			return elementsPlusTraits.toArray();
		}
	}

	private List<String> getMultiplicityList() {

		List<String> multiplicitiesValues = new ArrayList<String>();
		multiplicitiesValues.add("Lower=" + String
				.valueOf(multiplicities.get(multiplicitySelectionCombo.getSelectionIndex()).getLower()).toString());
		multiplicitiesValues.add("Upper=" + String
				.valueOf(multiplicities.get(multiplicitySelectionCombo.getSelectionIndex()).getUpper()).toString());
		multiplicitiesValues.add("Potency=" + String
				.valueOf(multiplicities.get(multiplicitySelectionCombo.getSelectionIndex()).getPotency()).toString());
		return multiplicitiesValues;
	}

}

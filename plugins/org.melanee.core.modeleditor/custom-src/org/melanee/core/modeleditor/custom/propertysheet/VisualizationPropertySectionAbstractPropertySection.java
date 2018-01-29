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

package org.melanee.core.modeleditor.custom.propertysheet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
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
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.impl.PLMPackageImpl;

public class VisualizationPropertySectionAbstractPropertySection extends
		AbstractPropertySection {

	public VisualizationPropertySectionAbstractPropertySection() {
		// TODO Auto-generated constructor stub
	}

	private IGraphicalEditPart selectedElement = null;
	
	
	CCombo visualizerSelectionCombo = null;
	List<LMLVisualizer> visualizers = null;
	TableViewer viewer;

	private ISelection selection;
	private IWorkbenchPart part;
	
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		
		this.part = part;
		this.selection = selection;
		
		if (selection instanceof StructuredSelection
				&& ((StructuredSelection) selection).getFirstElement() instanceof IGraphicalEditPart)
			selectedElement = (IGraphicalEditPart)((StructuredSelection) selection).getFirstElement();
		
		visualizerSelectionCombo.removeAll();
		
		if (visualizerSelectionCombo == null || ! (selectedElement.resolveSemanticElement() instanceof Element))
			return;
		
		
		Element e = (Element)selectedElement.resolveSemanticElement();
		
		for (LMLVisualizer v : e.getVisualizer())
			visualizerSelectionCombo.add("Visualizer: " + v.getName());
		
		visualizers = e.getVisualizer();
		
		if (visualizerSelectionCombo.getItems().length > 0)
		{
			visualizerSelectionCombo.select(0);
			viewer.setInput(visualizers.get(0).getAttributes());
			viewer.refresh();
		}
	}
	
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		
		GridLayout gl = new GridLayout(5, false);
		composite.setLayout(gl);
		
		CLabel visualizerSelectionLabel = getWidgetFactory().createCLabel(composite, "Visualizer");
		
		visualizerSelectionCombo = getWidgetFactory().createCCombo(composite);
		
		Button addButton = getWidgetFactory().createButton(composite, "Add", SWT.NONE);
		Button removeButton = getWidgetFactory().createButton(composite, "Remove", SWT.NONE);
		Button editButton = getWidgetFactory().createButton(composite, "Edit", SWT.NONE);
		
		viewer = new TableViewer(composite, SWT.FULL_SELECTION);
		
		visualizerSelectionCombo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				viewer.setInput(visualizers.get(visualizerSelectionCombo.getSelectionIndex()).getAttributes());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				viewer.setInput(visualizers.get(visualizerSelectionCombo.getSelectionIndex()).getAttributes());
			}
		});
		
		GridData visualizerComboData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		visualizerSelectionCombo.setLayoutData(visualizerComboData);
		
		Table table = viewer.getTable();
		
		GridData tableGridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		tableGridData.horizontalSpan = 5;
		
		table.setLayoutData(tableGridData);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//Add ContentProviders
		viewer.setContentProvider(new VisualizerContentProvider());
		
		TableViewerColumn keyColumn = new TableViewerColumn(viewer, SWT.NONE);
		keyColumn.getColumn().setText("Name");
		keyColumn.getColumn().setWidth(200);
		
		keyColumn.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				String keyValuePair = (String)cell.getElement();
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
				String keyValuePair = (String)cell.getElement();
				int equalIndex = keyValuePair.indexOf("=") + 1;
				String value = keyValuePair.substring(equalIndex, keyValuePair.length()).trim();
				cell.setText(value);
			}
		});
		
		valueColumn.setEditingSupport(new EditingSupport(viewer) {
			
			@Override
			protected void setValue(Object element, Object value) {
			
				LMLVisualizer visualizer = visualizers.get(visualizerSelectionCombo.getSelectionIndex());
				
				String keyValuePair = (String)element;
				String key = keyValuePair.substring(0, keyValuePair.indexOf("=")).trim();
				
				CommandParameter parameters = null;
				
				int oldIndex  = -1;
				for (String s : visualizer.getAttributes())
					if (s.equals(element))
					{
						oldIndex = visualizer.getAttributes().indexOf(s);
						break;
					}
				
				parameters = new CommandParameter(visualizer, PLMPackageImpl.eINSTANCE.getLMLVisualizer_Attributes(), key + "= " + value, oldIndex);
				
				Command cmd = selectedElement.getEditingDomain().createCommand(SetCommand.class, parameters);
				selectedElement.getEditingDomain().getCommandStack().execute(cmd);
				
				selectedElement.performRequest(new Request(RequestConstants.REQ_REFRESH));
				viewer.refresh();
				setInput(part, selection);
			}
			
			@Override
			protected Object getValue(Object element) {
				String keyValuePair = (String)element;
				int equalIndex = keyValuePair.indexOf("=") + 1;
				String value = keyValuePair.substring(equalIndex, keyValuePair.length()).trim();
				return value;
			}
			
			@Override
			protected CellEditor getCellEditor(Object element) {
				
				String keyValuePair = (String)element;
				int equalIndex = keyValuePair.indexOf("=") + 1;
				String value = keyValuePair.substring(equalIndex, keyValuePair.length()).trim();
				
				if ("false".equals(value) || "true".equals(value))
				{
					ComboBoxViewerCellEditor cb = new ComboBoxViewerCellEditor(viewer.getTable());
					cb.setContentProvider(ArrayContentProvider.getInstance());
					cb.setInput(new String[]{"true", "false"});
					return cb;
				}
				else if ("default".equals(value) || "tvs".equals(value)
						|| "noshow".equals(value) || "max".equals(value))
				{
					ComboBoxViewerCellEditor cb = new ComboBoxViewerCellEditor(viewer.getTable());
					cb.setContentProvider(ArrayContentProvider.getInstance());
					cb.setInput(new String[]{"default", "tvs", "noshow", "max", "show"});
					return cb;
				}
				return new TextCellEditor(viewer.getTable());
			}
			
			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});		
	}
	
	private class VisualizerContentProvider extends ArrayContentProvider{
		@Override
		public Object[] getElements(Object inputElement) {
			
			//Durability needs to be added
			LinkedList<Object> elementsPlusTraits = new LinkedList<Object>();
			//Append the attributes list
			elementsPlusTraits.addAll(Arrays.asList(super.getElements(inputElement)));
			
			return elementsPlusTraits.toArray();
		}
	}

}

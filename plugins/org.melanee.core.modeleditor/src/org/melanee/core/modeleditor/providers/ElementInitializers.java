/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.providers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.modeleditor.expressions.PLMAbstractExpression;
import org.melanee.core.modeleditor.expressions.PLMOCLFactory;
import org.melanee.core.modeleditor.part.PLMDiagramEditor;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.Method;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.Package;
import org.melanee.core.models.plm.PLM.impl.PLMFactoryImpl;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public void init_DeepModel_2005(DeepModel instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(0, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Level_3097(Level instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(1, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			Object value_1 = PLMOCLFactory.getExpression(2, PLMPackage.eINSTANCE.getLevel(), null).evaluate(instance);
			instance.setName((java.lang.String) value_1);

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Connection_3099(Connection instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(3, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			PaletteViewer viewer = editor.getPalette();

			//We create an instance of a DSL element
			if (viewer.getActiveTool().getId().startsWith("dsl.")) {
				String activeToolID = viewer.getActiveTool().getId();
				boolean instantiateContent = activeToolID.endsWith(ModelEditorConstants.INSTANTIATE_WITH_CONTENT);

				String typeName = null;

				if (instantiateContent)
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITH_CONTENT, "");
				else
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT, "");

				TreeIterator<EObject> iter = EcoreUtil.getRootContainer(instance).eAllContents();
				while (iter.hasNext()) {
					EObject current = iter.next();
					if (EMFCoreUtil.getProxyID(current).equals(typeName)) {
						PLMFactoryImpl.eINSTANCE.configureClabject((Clabject) current, instance, null, false, true);

						Map<EObject, EObject> type2Instance = new HashMap<EObject, EObject>();
						type2Instance.put(current, instance);

						if (!instantiateContent)
							break;

						//************************************
						//Instantiate the content
						//************************************
						TreeIterator<EObject> contentIterator = current.eAllContents();
						while (contentIterator.hasNext()) {
							EObject next = contentIterator.next();

							//Only Clabjects are instantiated
							if (!(next instanceof Clabject))
								continue;

							Clabject contentInstance;
							contentInstance = PLMFactory.eINSTANCE.createClabjectFromTemplate((Clabject) next,
									(Element) type2Instance.get(next.eContainer()), true, true);
							type2Instance.put(next, contentInstance);
						}

						break;
					}
				}
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Attribute_3100(Attribute instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(4, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			Object value_1 = PLMOCLFactory.getExpression(5, PLMPackage.eINSTANCE.getAttribute(), null)
					.evaluate(instance);

			value_1 = PLMAbstractExpression.performCast(value_1, EcorePackage.eINSTANCE.getEInt());
			instance.setDurability(((Integer) value_1).intValue());
			Object value_2 = PLMOCLFactory.getExpression(6, PLMPackage.eINSTANCE.getAttribute(), null)
					.evaluate(instance);

			value_2 = PLMAbstractExpression.performCast(value_2, EcorePackage.eINSTANCE.getEInt());
			instance.setMutability(((Integer) value_2).intValue());

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Method_3102(Method instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(11, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			Object value_1 = PLMOCLFactory.getExpression(12, PLMPackage.eINSTANCE.getMethod(), null).evaluate(instance);

			value_1 = PLMAbstractExpression.performCast(value_1, EcorePackage.eINSTANCE.getEInt());
			instance.setDurability(((Integer) value_1).intValue());

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Entity_3105(Entity instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(16, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			PaletteViewer viewer = editor.getPalette();

			//We create an instance of a DSL element
			if (viewer.getActiveTool().getId().startsWith("dsl.")) {
				String activeToolID = viewer.getActiveTool().getId();
				boolean instantiateContent = activeToolID.endsWith(ModelEditorConstants.INSTANTIATE_WITH_CONTENT);

				String typeName = null;

				if (instantiateContent)
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITH_CONTENT, "");
				else
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT, "");

				TreeIterator<EObject> iter = EcoreUtil.getRootContainer(instance).eAllContents();
				while (iter.hasNext()) {
					EObject current = iter.next();
					if (EMFCoreUtil.getProxyID(current).equals(typeName)) {
						PLMFactoryImpl.eINSTANCE.configureClabject((Clabject) current, instance, null, false, true);

						Map<EObject, EObject> type2Instance = new HashMap<EObject, EObject>();
						type2Instance.put(current, instance);

						if (!instantiateContent)
							break;

						//************************************
						//Instantiate the content
						//************************************
						TreeIterator<EObject> contentIterator = current.eAllContents();
						while (contentIterator.hasNext()) {
							EObject next = contentIterator.next();

							//Only Clabjects are instantiated
							if (!(next instanceof Clabject))
								continue;

							Clabject contentInstance;
							contentInstance = PLMFactory.eINSTANCE.createClabjectFromTemplate((Clabject) next,
									(Element) type2Instance.get(next.eContainer()), true, true);
							type2Instance.put(next, contentInstance);
						}

						break;
					}
				}
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Attribute_3106(Attribute instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(17, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			Object value_1 = PLMOCLFactory.getExpression(18, PLMPackage.eINSTANCE.getAttribute(), null)
					.evaluate(instance);

			value_1 = PLMAbstractExpression.performCast(value_1, EcorePackage.eINSTANCE.getEInt());
			instance.setDurability(((Integer) value_1).intValue());
			Object value_2 = PLMOCLFactory.getExpression(19, PLMPackage.eINSTANCE.getAttribute(), null)
					.evaluate(instance);

			value_2 = PLMAbstractExpression.performCast(value_2, EcorePackage.eINSTANCE.getEInt());
			instance.setMutability(((Integer) value_2).intValue());

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Method_3108(Method instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(24, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			Object value_1 = PLMOCLFactory.getExpression(25, PLMPackage.eINSTANCE.getMethod(), null).evaluate(instance);

			value_1 = PLMAbstractExpression.performCast(value_1, EcorePackage.eINSTANCE.getEInt());
			instance.setDurability(((Integer) value_1).intValue());

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Connection_3111(Connection instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(3, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			PaletteViewer viewer = editor.getPalette();

			//We create an instance of a DSL element
			if (viewer.getActiveTool().getId().startsWith("dsl.")) {
				String activeToolID = viewer.getActiveTool().getId();
				boolean instantiateContent = activeToolID.endsWith(ModelEditorConstants.INSTANTIATE_WITH_CONTENT);

				String typeName = null;

				if (instantiateContent)
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITH_CONTENT, "");
				else
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT, "");

				TreeIterator<EObject> iter = EcoreUtil.getRootContainer(instance).eAllContents();
				while (iter.hasNext()) {
					EObject current = iter.next();
					if (EMFCoreUtil.getProxyID(current).equals(typeName)) {
						PLMFactoryImpl.eINSTANCE.configureClabject((Clabject) current, instance, null, false, true);

						Map<EObject, EObject> type2Instance = new HashMap<EObject, EObject>();
						type2Instance.put(current, instance);

						if (!instantiateContent)
							break;

						//************************************
						//Instantiate the content
						//************************************
						TreeIterator<EObject> contentIterator = current.eAllContents();
						while (contentIterator.hasNext()) {
							EObject next = contentIterator.next();

							//Only Clabjects are instantiated
							if (!(next instanceof Clabject))
								continue;

							Clabject contentInstance;
							contentInstance = PLMFactory.eINSTANCE.createClabjectFromTemplate((Clabject) next,
									(Element) type2Instance.get(next.eContainer()), true, true);
							type2Instance.put(next, contentInstance);
						}

						break;
					}
				}
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Inheritance_3124(Inheritance instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(29, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Inheritance_3122(Inheritance instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(29, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Entity_3120(Entity instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(16, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			PaletteViewer viewer = editor.getPalette();

			//We create an instance of a DSL element
			if (viewer.getActiveTool().getId().startsWith("dsl.")) {
				String activeToolID = viewer.getActiveTool().getId();
				boolean instantiateContent = activeToolID.endsWith(ModelEditorConstants.INSTANTIATE_WITH_CONTENT);

				String typeName = null;

				if (instantiateContent)
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITH_CONTENT, "");
				else
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT, "");

				TreeIterator<EObject> iter = EcoreUtil.getRootContainer(instance).eAllContents();
				while (iter.hasNext()) {
					EObject current = iter.next();
					if (EMFCoreUtil.getProxyID(current).equals(typeName)) {
						PLMFactoryImpl.eINSTANCE.configureClabject((Clabject) current, instance, null, false, true);

						Map<EObject, EObject> type2Instance = new HashMap<EObject, EObject>();
						type2Instance.put(current, instance);

						if (!instantiateContent)
							break;

						//************************************
						//Instantiate the content
						//************************************
						TreeIterator<EObject> contentIterator = current.eAllContents();
						while (contentIterator.hasNext()) {
							EObject next = contentIterator.next();

							//Only Clabjects are instantiated
							if (!(next instanceof Clabject))
								continue;

							Clabject contentInstance;
							contentInstance = PLMFactory.eINSTANCE.createClabjectFromTemplate((Clabject) next,
									(Element) type2Instance.get(next.eContainer()), true, true);
							type2Instance.put(next, contentInstance);
						}

						break;
					}
				}
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Package_3125(Package instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(40, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Entity_3126(Entity instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(16, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			PaletteViewer viewer = editor.getPalette();

			//We create an instance of a DSL element
			if (viewer.getActiveTool().getId().startsWith("dsl.")) {
				String activeToolID = viewer.getActiveTool().getId();
				boolean instantiateContent = activeToolID.endsWith(ModelEditorConstants.INSTANTIATE_WITH_CONTENT);

				String typeName = null;

				if (instantiateContent)
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITH_CONTENT, "");
				else
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT, "");

				TreeIterator<EObject> iter = EcoreUtil.getRootContainer(instance).eAllContents();
				while (iter.hasNext()) {
					EObject current = iter.next();
					if (EMFCoreUtil.getProxyID(current).equals(typeName)) {
						PLMFactoryImpl.eINSTANCE.configureClabject((Clabject) current, instance, null, false, true);

						Map<EObject, EObject> type2Instance = new HashMap<EObject, EObject>();
						type2Instance.put(current, instance);

						if (!instantiateContent)
							break;

						//************************************
						//Instantiate the content
						//************************************
						TreeIterator<EObject> contentIterator = current.eAllContents();
						while (contentIterator.hasNext()) {
							EObject next = contentIterator.next();

							//Only Clabjects are instantiated
							if (!(next instanceof Clabject))
								continue;

							Clabject contentInstance;
							contentInstance = PLMFactory.eINSTANCE.createClabjectFromTemplate((Clabject) next,
									(Element) type2Instance.get(next.eContainer()), true, true);
							type2Instance.put(next, contentInstance);
						}

						break;
					}
				}
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Connection_3127(Connection instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(3, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

			PLMDiagramEditor editor = (PLMDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().getActiveEditor();
			PaletteViewer viewer = editor.getPalette();

			//We create an instance of a DSL element
			if (viewer.getActiveTool().getId().startsWith("dsl.")) {
				String activeToolID = viewer.getActiveTool().getId();
				boolean instantiateContent = activeToolID.endsWith(ModelEditorConstants.INSTANTIATE_WITH_CONTENT);

				String typeName = null;

				if (instantiateContent)
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITH_CONTENT, "");
				else
					typeName = activeToolID.substring(activeToolID.indexOf(".") + 1)
							.replace(ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT, "");

				TreeIterator<EObject> iter = EcoreUtil.getRootContainer(instance).eAllContents();
				while (iter.hasNext()) {
					EObject current = iter.next();
					if (EMFCoreUtil.getProxyID(current).equals(typeName)) {
						PLMFactoryImpl.eINSTANCE.configureClabject((Clabject) current, instance, null, false, true);

						Map<EObject, EObject> type2Instance = new HashMap<EObject, EObject>();
						type2Instance.put(current, instance);

						if (!instantiateContent)
							break;

						//************************************
						//Instantiate the content
						//************************************
						TreeIterator<EObject> contentIterator = current.eAllContents();
						while (contentIterator.hasNext()) {
							EObject next = contentIterator.next();

							//Only Clabjects are instantiated
							if (!(next instanceof Clabject))
								continue;

							Clabject contentInstance;
							contentInstance = PLMFactory.eINSTANCE.createClabjectFromTemplate((Clabject) next,
									(Element) type2Instance.get(next.eContainer()), true, true);
							type2Instance.put(next, contentInstance);
						}

						break;
					}
				}
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Inheritance_3128(Inheritance instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(29, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	* @generated
	*/
	public void init_Package_3129(Package instance) {

		try {
			LMLVisualizer newInstance_0_0 = PLMFactory.eINSTANCE.createLMLVisualizer();
			instance.getVisualizer().add(newInstance_0_0);
			Object value_0_0_0 = PLMOCLFactory.getExpression(40, PLMPackage.eINSTANCE.getLMLVisualizer(), null)
					.evaluate(newInstance_0_0);
			if (value_0_0_0 instanceof Collection) {
				newInstance_0_0.getAttributes().clear();
				newInstance_0_0.getAttributes().addAll(((Collection) value_0_0_0));
			} else {
				newInstance_0_0.getAttributes().add((java.lang.String) value_0_0_0);
			}

		} catch (RuntimeException e) {
			PLMDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	private static final String REASONING_SERVICE_ID = "org.melanee.core.reasoning.service";

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = PLMDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			PLMDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}

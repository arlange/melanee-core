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
package org.melanee.core.modeleditor.expressions;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.options.ParsingOptions;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;

/**
 * @generated
 */
public class PLMOCLFactory {
	//This is the parsingOrder initializer
	//"-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'parsingOrder\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\t 0 \r\n-- If set use the old value\r\nelse\r\n\tself.parsingOrder\r\nendif", //$NON-NLS-1$
    

  /**
   * @generated
   */
  private final PLMAbstractExpression[] expressions;

  /**
   * @generated
   */
  private final String[] expressionBodies;

  /**
   * @generated
   */
  protected PLMOCLFactory() {
    this.expressions = new PLMAbstractExpression[53];
    this.expressionBodies = new String[] { "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "let index:Integer = \r\n\tself.getDeepModel().content->indexOf(self) - 1\r\nin\r\nlet indexAsString:String = if (index > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(index.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (index = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\t\'O\'.concat(indexAsString)", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'durability\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\tself.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency\r\n-- If set use the old value\r\nelse\r\n\tself.durability\r\nendif", //$NON-NLS-1$
        "-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'mutability\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\tself.durability\r\n-- If set use the old value\r\nelse\r\n\tself.mutability\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\nlet durability:String = \r\n\tself.getDurabilityAsString()\r\nin\r\n\r\nlet renderDurability:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'durability\') = \'max\' \r\n\t\tor \r\n\t\t(visualizer.getValueForKey(\'durability\') = \'default\') and (self.durability <> self.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nif (renderDurability) then\r\n\tdurability\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "if (self.datatype.oclIsUndefined() or self.datatype = \'\') then\r\n\t\'\'\r\nelse\r\n\t\':\'.concat(self.datatype)\r\nendif", //$NON-NLS-1$
        "if (not self.value.oclIsUndefined() and self.value <> \'\') then\r\n\t\'=\'.concat(self.value)\r\nelse \r\n\tif (self.mutability <> self.durability) then\r\n\t\t\'=\'\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderValueVariability:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'mutability\') = \'max\' \r\n\t\tor \r\n\t\t(visualizer.getValueForKey(\'mutability\') = \'default\') and (self.mutability <> self.durability)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet mutability:String =\r\n\tself.getMutabilityAsString()\r\nin\r\n\r\nif (renderValueVariability) then\r\n\tmutability\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'durability\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\tself.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency\r\n-- If set use the old value\r\nelse\r\n\tself.durability\r\nendif", //$NON-NLS-1$
        "let input:OrderedSet(Parameter) = self.getInput()\r\nin\r\n\'(\'.concat(Sequence{1..input->size()}->iterate(i:Integer; str:String = \'\' | \r\n\tlet iAsString:String = \r\n\t\tOrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(denominator : Integer; s : String = \'\'|\r\n            \t\tlet numberAsString : String = OrderedSet{\r\n                    \t\t\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                \t}->at(i.div(denominator).mod(10) + 1)\r\n            \t\tin\r\n                \t\tif s=\'\' and numberAsString = \'0\' then\r\n                    \t\t\ts\r\n                \t\telse\r\n                    \t\t\ts.concat(numberAsString)\r\n                \t\tendif\r\n        \t)\r\n\tin\r\n\t\tif (i <> input->size()) then\r\n\t\t\tstr.concat(input->at(i).oclAsType(ecore::EObject).eClass().name).concat(\' \').concat(input->at(i).name).concat(\', \')\r\n\t\telse\r\n\t\t\tstr.concat(input->at(i).oclAsType(ecore::EObject).eClass().name).concat(\' \').concat(input->at(i).name)\r\n\t\tendif\r\n\t)\r\n).concat(\')\')", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderDurability:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'durability\') = \'max\' \r\n\t\tor \r\n\t\t(visualizer.getValueForKey(\'durability\') = \'default\') and (self.durability <>self.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet durability:String = \r\n\tself.getDurabilityAsString()\r\nin\r\n\r\nif (renderDurability) then\r\n\tdurability\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let output:OrderedSet(Parameter) = self.getInput()\r\nin\r\nif (output->size() > 0) then\r\n\t\':\'.concat(Sequence{1..output->size()}->iterate(i:Integer; str:String = \'\' | \r\n\t\tlet iAsString:String = \r\n\t\t\tOrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(denominator : Integer; s : String = \'\'|\r\n       \t     \t\tlet numberAsString : String = OrderedSet{\r\n\t                    \t\t\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                \t\t}->at(i.div(denominator).mod(10) + 1)\r\n            \t\t\tin\r\n       \t         \t\tif s=\'\' and numberAsString = \'0\' then\r\n\t                    \t\t\ts\r\n                \t\t\telse\r\n                    \t\t\t\ts.concat(numberAsString)\r\n              \t  \t\tendif\r\n       \t \t)\r\n\t\tin\r\n\t\t\tif (i <> output->size()) then\r\n\t\t\t\tstr.concat(output->at(i).name).concat(\', \')\r\n\t\t\telse\r\n\t\t\t\tstr.concat(output->at(i).name)\r\n\t\t\tendif\r\n\t\t)\r\n\t)\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'durability\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\tself.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency\r\n-- If set use the old value\r\nelse\r\n\tself.durability\r\nendif", //$NON-NLS-1$
        "-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'mutability\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\tself.durability\r\n-- If set use the old value\r\nelse\r\n\tself.mutability\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderDurability:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'durability\') = \'max\' \r\n\t\tor \r\n\t\t(visualizer.getValueForKey(\'durability\') = \'default\') and (self.durability <> self.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet durability:String = \r\n\tself.getDurabilityAsString()\r\nin\r\nif (renderDurability) then\r\n\tdurability\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "if (self.datatype.oclIsUndefined() or self.datatype = \'\') then\r\n\t\'\'\r\nelse\r\n\t\':\'.concat(self.datatype)\r\nendif", //$NON-NLS-1$
        "if (not self.value.oclIsUndefined() and self.value <> \'\') then\r\n\t\'=\'.concat(self.value)\r\nelse \r\n\tif (self.mutability <> self.durability) then\r\n\t\t\'=\'\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderValueVariability:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'mutability\') = \'max\' \r\n\t\tor \r\n\t\t(visualizer.getValueForKey(\'mutability\') = \'default\') and (self.mutability <> self.durability)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet mutability:String = \r\n\tself.getMutabilityAsString()\r\nin\r\nif (renderValueVariability) then\r\n\tmutability\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "-- This is needed to prevent setting a if one was already set at creation of the semantic model element\r\n-- This can happen when changing values through the refactoring service during creation\r\nlet attribute : ecore::EAttribute =\r\n\tself.oclAsType(ecore::EObject).eClass().eAllAttributes->select(a | a.name = \'durability\')->first().oclAsType(ecore::EAttribute)\r\nin\r\nlet isSet:Boolean = \r\n\tself.oclAsType(ecore::EObject).eIsSet(attribute)\r\nin\r\n\r\nif (not isSet) then\r\n\tself.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency\r\n-- If set use the old value\r\nelse\r\n\tself.durability\r\nendif", //$NON-NLS-1$
        "let input:OrderedSet(Parameter) = self.getInput()\r\nin\r\n\'(\'.concat(Sequence{1..input->size()}->iterate(i:Integer; str:String = \'\' | \r\n\tlet iAsString:String = \r\n\t\tOrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(denominator : Integer; s : String = \'\'|\r\n            \t\tlet numberAsString : String = OrderedSet{\r\n                    \t\t\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                \t}->at(i.div(denominator).mod(10) + 1)\r\n            \t\tin\r\n                \t\tif s=\'\' and numberAsString = \'0\' then\r\n                    \t\t\ts\r\n                \t\telse\r\n                    \t\t\ts.concat(numberAsString)\r\n                \t\tendif\r\n        \t)\r\n\tin\r\n\t\tif (i <> input->size()) then\r\n\t\t\tstr.concat(input->at(i).oclAsType(ecore::EObject).eClass().name).concat(\' \').concat(input->at(i).name).concat(\', \')\r\n\t\telse\r\n\t\t\tstr.concat(input->at(i).oclAsType(ecore::EObject).eClass().name).concat(\' \').concat(input->at(i).name)\r\n\t\tendif\r\n\t)\r\n).concat(\')\')", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderDurability:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'durability\') = \'max\' \r\n\t\tor \r\n\t\t(visualizer.getValueForKey(\'durability\') = \'default\') and (self.durability <> self.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject).potency)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet durability:String = \r\n\tself.getDurabilityAsString()\r\nin\r\n\r\nif (renderDurability) then\r\n\tdurability\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let output:OrderedSet(Parameter) = self.getInput()\r\nin\r\nif (output->size() > 0) then\r\n\t\':\'.concat(Sequence{1..output->size()}->iterate(i:Integer; str:String = \'\' | \r\n\t\tlet iAsString:String = \r\n\t\t\tOrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(denominator : Integer; s : String = \'\'|\r\n       \t     \t\tlet numberAsString : String = OrderedSet{\r\n\t                    \t\t\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                \t\t}->at(i.div(denominator).mod(10) + 1)\r\n            \t\t\tin\r\n       \t         \t\tif s=\'\' and numberAsString = \'0\' then\r\n\t                    \t\t\ts\r\n                \t\t\telse\r\n                    \t\t\t\ts.concat(numberAsString)\r\n              \t  \t\tendif\r\n       \t \t)\r\n\t\tin\r\n\t\t\tif (i <> output->size()) then\r\n\t\t\t\tstr.concat(output->at(i).name).concat(\', \')\r\n\t\t\telse\r\n\t\t\t\tstr.concat(output->at(i).name)\r\n\t\t\tendif\r\n\t\t)\r\n\t)\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "let disjoint:String = \r\n\tif (not self.disjoint.oclIsUndefined() and self.disjoint) then \r\n\t\t\'disjoint;\' \r\n\telse \r\n\t\t\'\' \r\n\tendif\r\nin\r\nlet complete:String = \r\n\tif (not self.complete.oclIsUndefined() and self.complete) then \r\n\t\t\'complete;\' \r\n\telse \r\n\t\t\'\' \r\n\tendif\r\nin\r\nif (disjoint <> \'\' or complete <> \'\') then\r\n\t\'{\'.concat(complete).concat(disjoint).concat(\'}\')\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderName:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'name\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'name\') = \'default\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nif (renderName and not self.name.oclIsUndefined()) then\r\n\tself.name\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderLevel:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'levelIndex\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'levelIndex\') = \'default\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nif (renderLevel) then\r\n\tself.levelIndex\r\nelse\r\n\t\' \'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderPotency:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'potency\') = \'max\' \r\n\t\t\tor \r\n\t\t(visualizer.getValueForKey(\'potency\') = \'default\') -- and (self.potency <> 1)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet potency:String = if (self.potency > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.potency.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.potency = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\nif (renderPotency) then\r\n\tpotency\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n--**********************************\r\n--Check if attributes are rendered in tvs\r\n--**********************************\r\nlet renderName:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'name\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'name\') = \'tvs\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\nlet renderPotency:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'potency\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'potency\') = \'tvs\' \r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\nlet renderLevel:Boolean =\r\n\tif (renderingInformationAvailable) then\t\t\r\n\t\tvisualizer.getValueForKey(\'level\') = \'max\'\r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'level\') = \'tvs\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the name\r\n--**********************************\r\nlet name : String =\r\n\tif (renderName) then\r\n\t\t\'name=\'.concat(self.name).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the potency\r\n--**********************************\r\nlet potencyString:String = \r\n\tif (renderPotency and self.potency > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.potency.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.potency = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet potency: String = \r\n\tif (renderPotency) then\r\n\t\t\'potency=\'.concat(potencyString).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the level\r\n--**********************************\r\nlet levelString:String = \r\n\tif (renderLevel and self.levelIndex > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.levelIndex.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.levelIndex = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet level: String = \r\n\tif (renderLevel) then\r\n\t\t\'level=\'.concat(levelString).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\nlet output:String = \r\n\t\'{\'.concat(name).concat(potency).concat(level).concat(\'}\')\r\nin\r\n--**********************************\r\n--Write the output\r\n--**********************************\r\nif (output <> \'{}\') then\r\n\toutput\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderClassification:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'ProximityClassification\') = \'1\' \r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\nif (renderClassification) then\r\n\tif (Classification.allInstances()->select(i | i.instance = self)->size() > 0) then\r\n\t\t\':\'.concat(Classification.allInstances()->select(i | i.instance = self)->asOrderedSet()->first().type.name)\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderName:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'name\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'name\') = \'default\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nif (renderName and not self.name.oclIsUndefined()) then\r\n\tself.name\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderPotency:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'potency\') = \'max\' \r\n\t\t\tor \r\n\t\t(visualizer.getValueForKey(\'potency\') = \'default\') -- and (self.potency <> 1)\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nlet potency:String =\r\n\tself.getPotencyAsString()\r\nin\r\nif (renderPotency) then\r\n\tpotency\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\nlet renderLevel:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'levelIndex\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'levelIndex\') = \'default\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\nif (renderLevel) then\r\n\tself.levelIndex\r\nelse\r\n\t\' \'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Check if attributes are rendered in tvs\r\n--**********************************\r\nlet renderName:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'name\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'name\') = \'tvs\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\nlet renderPotency:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'potency\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'potency\') = \'tvs\' \r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\nlet renderLevel:Boolean =\r\n\tif (renderingInformationAvailable) then\t\t\r\n\t\tvisualizer.getValueForKey(\'level\') = \'max\'\r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'level\') = \'tvs\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the name\r\n--**********************************\r\nlet name : String =\r\n\tif (renderName) then\r\n\t\t\'name=\'.concat(self.name).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the potency\r\n--**********************************\r\nlet potencyString:String = \r\n\tif (renderPotency and self.potency > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.potency.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.potency = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet potency: String = \r\n\tif (renderPotency) then\r\n\t\t\'potency=\'.concat(potencyString).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the level\r\n--**********************************\r\nlet levelString:String = \r\n\tif (renderLevel and self.levelIndex > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.levelIndex.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.levelIndex = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet level: String = \r\n\tif (renderLevel) then\r\n\t\t\'level=\'.concat(levelString).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\n\r\nlet output:String = \r\n\t\'{\'.concat(name).concat(potency).concat(level).concat(\'}\')\r\nin\r\n\r\n--**********************************\r\n--Write the output\r\n--**********************************\r\nif (output <> \'{}\') then\r\n\toutput\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "self.getDefaultVisualizationValues()", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n--**********************************\r\n--Check if attributes are rendered in tvs\r\n--**********************************\r\nlet renderName:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'name\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'name\') = \'tvs\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the name\r\n--**********************************\r\nlet name : String =\r\n\tif (renderName) then\r\n\t\t\'name=\'.concat(self.name).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\nlet output:String = \r\n\t\'{\'.concat(name).concat(\'}\')\r\nin\r\n--**********************************\r\n--Write the output\r\n--**********************************\r\nif (output <> \'{}\') then\r\n\toutput\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "if(self.oclAsType(ecore::EObject).eContainer().oclAsType(Domain).complianceKind = ComplianceKind::MetaDepth) then\r\n\t\'Please keep in mind that the feature sets of Melanee and MetaDepth diverge.\'\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderingInformationAvailable:Boolean = \r\n\tif (self.visualizer->size() > 0) then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nlet visualizer:LMLVisualizer =\r\n\tif (renderingInformationAvailable)\tthen\r\n\t\tself.visualizer->first()\r\n\telse\r\n\t\tnull\r\n\tendif\r\nin\r\n--**********************************\r\n--Check if attributes are rendered in tvs\r\n--**********************************\r\nlet renderName:Boolean =\r\n\tif (renderingInformationAvailable) then\r\n\t\tvisualizer.getValueForKey(\'name\') = \'max\' \r\n\t\tor \r\n\t\tvisualizer.getValueForKey(\'name\') = \'tvs\'\r\n\telse\r\n\t\ttrue\r\n\tendif\r\nin\r\n\r\n--**********************************\r\n--Get the name\r\n--**********************************\r\nlet name : String =\r\n\tif (renderName) then\r\n\t\t\'name=\'.concat(self.name).concat(\'; \')\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\r\n\r\nlet output:String = \r\n\t\'{\'.concat(name).concat(\'}\')\r\nin\r\n--**********************************\r\n--Write the output\r\n--**********************************\r\nif (output <> \'{}\') then\r\n\toutput\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "let renderConnectionEndName:Boolean=\r\n\tif (DeepModel.allInstances()->asSequence()->at(1).visualizer->asSequence()->at(1).getValueForKey(\'showClassificationConnectionEndNames\') = \'true\') then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nif (renderConnectionEndName and self.kind = ClassificationKind::instantiation) then\r\n\t\'blueprint\'\r\nelse\r\n\tif (renderConnectionEndName and self.kind = ClassificationKind::instance) then\r\n\t\t\'type\'\r\n\telse\r\n\t\tif (renderConnectionEndName and self.kind = ClassificationKind::isonym) then\r\n\t\t\t\'complete type\'\r\n\t\telse\r\n\t\t\tif (renderConnectionEndName and self.kind = ClassificationKind::hyponym) then\r\n\t\t\t\t\'incomplete type\'\r\n\t\t\telse\r\n\t\t\t\t\'\'\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif", //$NON-NLS-1$
        "let renderConnectionEndName:Boolean=\r\n\tif (DeepModel.allInstances()->asSequence()->at(1).visualizer->asSequence()->at(1).getValueForKey(\'showClassificationConnectionEndNames\') = \'true\') then\r\n\t\ttrue\r\n\telse\r\n\t\tfalse\r\n\tendif\r\nin\r\n\r\nif (renderConnectionEndName and self.kind = ClassificationKind::instantiation) then\r\n\t\'offspring\'\r\nelse\r\n\tif (renderConnectionEndName and self.kind = ClassificationKind::instance) then\r\n\t\t\'instance\'\r\n\telse\r\n\t\tif (renderConnectionEndName and self.kind = ClassificationKind::isonym) then\r\n\t\t\t\'isonym\'\r\n\t\telse\r\n\t\t\tif (renderConnectionEndName and self.kind = ClassificationKind::hyponym) then\r\n\t\t\t\t\'hyponym\'\r\n\t\t\telse\r\n\t\t\t\t\'\'\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif", //$NON-NLS-1$
        "self.potency <> 0 and self.levelIndex < oppositeEnd.levelIndex", //$NON-NLS-1$
        "oppositeEnd.getLevel() = self.getLevel()", //$NON-NLS-1$
        "oppositeEnd.getLevel() = self.getLevel()", //$NON-NLS-1$
        "if (self.moniker.oclIsUndefined()) then\r\n\t\'\'\r\nelse\r\n\tself.moniker\r\nendif", //$NON-NLS-1$
        "--A participation has no visualizer yet\r\n--let renderingInformationAvailable:Boolean = \r\n--\tif (self.visualizer->size() > 0) then\r\n--\t\ttrue\r\n--\telse\r\n--\t\tfalse\r\n--\tendif\r\n--in\r\n\r\n--is a visualizer present?\r\n--let visualizer:LMLVisualizer =\r\n--\tif (renderingInformationAvailable)\tthen\r\n--\t\tself.visualizer->first()\r\n--\telse\r\n--\t\tnull\r\n--\tendif\r\n--in\r\n\r\n--here for the DSL mode needs to be checked\r\nlet multiplicityPotency:Boolean = true\r\n--\tif (renderingInformationAvailable) then\r\n--\t\tvisualizer.getValueForKey(\'potency\') = \'max\' \r\n--\t\t\tor \r\n--\t\t(visualizer.getValueForKey(\'potency\') = \'default\') and (self.potency <> 1)\r\n--\telse\r\n--\t\ttrue\r\n--\tendif\r\nin\r\n\r\n--If lower is null we do not want to show anything in the label\r\nlet lowerIsNull:Boolean = self.lower.oclIsUndefined() in\r\n\r\nlet lowerString:String = if (self.lower > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.lower.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.lower = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet upperString:String = if (self.upper > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.upper.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.upper = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nif (not lowerIsNull) then\r\n\tif (self.lower = 0 and self.upper = -1) then\r\n\t\t\'*\'\r\n\telse\r\n\t\tif (self.lower = self.upper) then\r\n\t\t\tself.lower\r\n\t\telse\r\n\t\t\tlowerString.concat(\'..\').concat(upperString)\r\n\t\tendif\r\n\tendif\r\nelse\r\n\t\'\'\r\nendif", //$NON-NLS-1$
        "self.levelIndex = oppositeEnd.levelIndex", //$NON-NLS-1$
        "true", //$NON-NLS-1$
        
    };
  }

  /**
   * @generated
   */
  private static PLMOCLFactory getInstance() {
    PLMOCLFactory instance = PLMDiagramEditorPlugin.getInstance().getPLMOCLFactory();
    if (instance == null) {
      PLMDiagramEditorPlugin.getInstance().setPLMOCLFactory(instance = new PLMOCLFactory());
    }
    return instance;
  }

  /**
   * @generated
   */
  public static String getExpressionBody(int index) {
    return getInstance().expressionBodies[index];
  }

  /**
   * @generated
   */
  public static PLMAbstractExpression getExpression(int index, EClassifier context,
      Map<String, EClassifier> environment) {
    PLMOCLFactory cached = getInstance();
    if (index < 0 || index >= cached.expressions.length) {
      throw new IllegalArgumentException();
    }
    if (cached.expressions[index] == null) {
      cached.expressions[index] = getExpression(cached.expressionBodies[index], context,
          environment == null ? Collections.<String, EClassifier>emptyMap() : environment);
    }
    return cached.expressions[index];
  }

  /**
   * This is factory method, callers are responsible to keep reference to the
   * return value if they want to reuse parsed expression
   * 
   * @generated
   */
  public static PLMAbstractExpression getExpression(String body, EClassifier context,
      Map<String, EClassifier> environment) {
    return new Expression(body, context, environment);
  }

  /**
   * This method will become private in the next release
   * 
   * @generated
   */
  public static PLMAbstractExpression getExpression(String body, EClassifier context) {
    return getExpression(body, context, Collections.<String, EClassifier>emptyMap());
  }

  /**
   * @generated
   */
  private static class Expression extends PLMAbstractExpression {

    /**
     * @generated
     */
    private final org.eclipse.ocl.ecore.OCL oclInstance;

    /**
     * @generated
     */
    private OCLExpression oclExpression;

    /**
     * @generated
     */
    public Expression(String body, EClassifier context, Map<String, EClassifier> environment) {
      super(body, context);
      oclInstance = org.eclipse.ocl.ecore.OCL.newInstance();
      initCustomEnv(oclInstance.getEnvironment(), environment);
      Helper oclHelper = oclInstance.createOCLHelper();
      oclHelper.setContext(context());
      try {
        oclExpression = oclHelper.createQuery(body());
        setStatus(IStatus.OK, null, null);
      } catch (ParserException e) {
        setStatus(IStatus.ERROR, e.getMessage(), e);
      }
    }

    /**
     * @generated
     */
    @SuppressWarnings("rawtypes")
    protected Object doEvaluate(Object context, Map env) {
      if (oclExpression == null) {
        return null;
      }
      // on the first call, both evalEnvironment and extentMap are clear, for later we
      // have finally, below.
      EvaluationEnvironment<?, ?, ?, ?, ?> evalEnv = oclInstance.getEvaluationEnvironment();
      // initialize environment
      for (Object nextKey : env.keySet()) {
        evalEnv.replace((String) nextKey, env.get(nextKey));
      }
      try {
        Object result = oclInstance.evaluate(context, oclExpression);
        return oclInstance.isInvalid(result) ? null : result;
      } finally {
        evalEnv.clear();
        oclInstance.setExtentMap(null); // clear allInstances cache, and get the oclInstance ready
                                        // for the next call
      }
    }

    /**
     * @generated
     */
    private static void initCustomEnv(
        Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?> ecoreEnv,
        Map<String, EClassifier> environment) {
      // Use EObject as implicit root class for any object, to allow eContainer() and
      // other EObject operations from OCL expressions
      ParsingOptions.setOption(ecoreEnv, ParsingOptions.implicitRootClass(ecoreEnv),
          EcorePackage.eINSTANCE.getEObject());
      for (String varName : environment.keySet()) {
        EClassifier varType = environment.get(varName);
        ecoreEnv.addElement(varName, createVar(ecoreEnv, varName, varType), false);
      }
    }

    /**
     * @generated
     */
    private static Variable createVar(
        Environment<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> ecoreEnv, String name,
        EClassifier type) {
      Variable var = EcoreFactory.eINSTANCE.createVariable();
      var.setName(name);
      var.setType(ecoreEnv.getUMLReflection().getOCLType(type));
      return var;
    }
  }
}

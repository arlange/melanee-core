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
package org.melanee.core.modeleditor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.edit.parts.AttributeName2EditPart;
import org.melanee.core.modeleditor.edit.parts.AttributeNameEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionName2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionName3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionNameEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelNameEditPart;
import org.melanee.core.modeleditor.edit.parts.EnumerationLiteralEditPart;
import org.melanee.core.modeleditor.edit.parts.EnumerationNameEditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName2EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName3EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName4EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName5EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName6EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceNameEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelNameEditPart;
import org.melanee.core.modeleditor.edit.parts.MethodName2EditPart;
import org.melanee.core.modeleditor.edit.parts.MethodNameEditPart;
import org.melanee.core.modeleditor.edit.parts.PackageName2EditPart;
import org.melanee.core.modeleditor.edit.parts.PackageNameEditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel10EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel11EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel12EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel13EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel14EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel15EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel16EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel17EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel18EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel19EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel21EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel22EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel23EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel24EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel25EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel26EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel27EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel28EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel29EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel2EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel30EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel31EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel32EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel33EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel34EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel35EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel36EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel37EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel38EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel3EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel40EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel41EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel42EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel43EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel45EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel46EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel47EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel48EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel49EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel4EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel50EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel51EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel52EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel53EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel54EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel5EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel6EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel7EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel8EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel9EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabelEditPart;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5255;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5256;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5257;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5258;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5270;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5271;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5272;
import org.melanee.core.modeleditor.parsers.AttributeLabelExpressionLabelParser5273;
import org.melanee.core.modeleditor.parsers.ClassificationLabelExpressionLabelParser6016;
import org.melanee.core.modeleditor.parsers.ClassificationLabelExpressionLabelParser6017;
import org.melanee.core.modeleditor.parsers.ConnectionEndLabelExpressionLabelParser6024;
import org.melanee.core.modeleditor.parsers.ConnectionEndLabelExpressionLabelParser6025;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5282;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5284;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5285;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5286;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5287;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5294;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5296;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5297;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5298;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5299;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5343;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5345;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5346;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5347;
import org.melanee.core.modeleditor.parsers.ConnectionLabelExpressionLabelParser5348;
import org.melanee.core.modeleditor.parsers.DeepModelLabelExpressionLabelParser5332;
import org.melanee.core.modeleditor.parsers.DeepModelLabelExpressionLabelParser5353;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5288;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5289;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5290;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5291;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5314;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5315;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5316;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5317;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5337;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5338;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5339;
import org.melanee.core.modeleditor.parsers.EntityLabelExpressionLabelParser5340;
import org.melanee.core.modeleditor.parsers.InheritanceLabelExpressionLabelParser5328;
import org.melanee.core.modeleditor.parsers.InheritanceLabelExpressionLabelParser5335;
import org.melanee.core.modeleditor.parsers.InheritanceLabelExpressionLabelParser5351;
import org.melanee.core.modeleditor.parsers.LevelLabelExpressionLabelParser5321;
import org.melanee.core.modeleditor.parsers.MessageFormatParser;
import org.melanee.core.modeleditor.parsers.MethodLabelExpressionLabelParser5262;
import org.melanee.core.modeleditor.parsers.MethodLabelExpressionLabelParser5263;
import org.melanee.core.modeleditor.parsers.MethodLabelExpressionLabelParser5264;
import org.melanee.core.modeleditor.parsers.MethodLabelExpressionLabelParser5277;
import org.melanee.core.modeleditor.parsers.MethodLabelExpressionLabelParser5278;
import org.melanee.core.modeleditor.parsers.MethodLabelExpressionLabelParser5279;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * @generated
 */
public class PLMParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser deepModelName_5331Parser;

	/**
	* @generated
	*/
	private IParser getDeepModelName_5331Parser() {
		if (deepModelName_5331Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			deepModelName_5331Parser = parser;
		}
		return deepModelName_5331Parser;
	}

	/**
	* @generated
	*/
	private IParser getDeepModelLabel_5332Parser() {
		return new DeepModelLabelExpressionLabelParser5332();
	}

	/**
	* @generated
	*/
	private IParser getDeepModelLabel_5353Parser() {
		return new DeepModelLabelExpressionLabelParser5353();
	}

	/**
	* @generated
	*/
	private IParser enumerationName_5329Parser;

	/**
	* @generated
	*/
	private IParser getEnumerationName_5329Parser() {
		if (enumerationName_5329Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			enumerationName_5329Parser = parser;
		}
		return enumerationName_5329Parser;
	}

	/**
	* @generated
	*/
	private IParser enumerationLiteral_5330Parser;

	/**
	* @generated
	*/
	private IParser getEnumerationLiteral_5330Parser() {
		if (enumerationLiteral_5330Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getEnumeration_Literal() };
			EAttribute[] editableFeatures = new EAttribute[] { PLMPackage.eINSTANCE.getEnumeration_Literal() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			enumerationLiteral_5330Parser = parser;
		}
		return enumerationLiteral_5330Parser;
	}

	/**
	* @generated
	*/
	private IParser levelName_5320Parser;

	/**
	* @generated
	*/
	private IParser getLevelName_5320Parser() {
		if (levelName_5320Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			levelName_5320Parser = parser;
		}
		return levelName_5320Parser;
	}

	/**
	* @generated
	*/
	private IParser getLevelLabel_5321Parser() {
		return new LevelLabelExpressionLabelParser5321();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5294Parser() {
		return new ConnectionLabelExpressionLabelParser5294();
	}

	/**
	* @generated
	*/
	private IParser connectionName_5295Parser;

	/**
	* @generated
	*/
	private IParser getConnectionName_5295Parser() {
		if (connectionName_5295Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			connectionName_5295Parser = parser;
		}
		return connectionName_5295Parser;
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5296Parser() {
		return new ConnectionLabelExpressionLabelParser5296();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5297Parser() {
		return new ConnectionLabelExpressionLabelParser5297();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5298Parser() {
		return new ConnectionLabelExpressionLabelParser5298();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5299Parser() {
		return new ConnectionLabelExpressionLabelParser5299();
	}

	/**
	* @generated
	*/
	private IParser attributeName_5254Parser;

	/**
	* @generated
	*/
	private IParser getAttributeName_5254Parser() {
		if (attributeName_5254Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			attributeName_5254Parser = parser;
		}
		return attributeName_5254Parser;
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5255Parser() {
		return new AttributeLabelExpressionLabelParser5255();
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5256Parser() {
		return new AttributeLabelExpressionLabelParser5256();
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5257Parser() {
		return new AttributeLabelExpressionLabelParser5257();
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5258Parser() {
		return new AttributeLabelExpressionLabelParser5258();
	}

	/**
	* @generated
	*/
	private IParser methodName_5261Parser;

	/**
	* @generated
	*/
	private IParser getMethodName_5261Parser() {
		if (methodName_5261Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			methodName_5261Parser = parser;
		}
		return methodName_5261Parser;
	}

	/**
	* @generated
	*/
	private IParser getMethodLabel_5262Parser() {
		return new MethodLabelExpressionLabelParser5262();
	}

	/**
	* @generated
	*/
	private IParser getMethodLabel_5263Parser() {
		return new MethodLabelExpressionLabelParser5263();
	}

	/**
	* @generated
	*/
	private IParser getMethodLabel_5264Parser() {
		return new MethodLabelExpressionLabelParser5264();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5288Parser() {
		return new EntityLabelExpressionLabelParser5288();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5289Parser() {
		return new EntityLabelExpressionLabelParser5289();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5290Parser() {
		return new EntityLabelExpressionLabelParser5290();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5291Parser() {
		return new EntityLabelExpressionLabelParser5291();
	}

	/**
	* @generated
	*/
	private IParser attributeName_5269Parser;

	/**
	* @generated
	*/
	private IParser getAttributeName_5269Parser() {
		if (attributeName_5269Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			attributeName_5269Parser = parser;
		}
		return attributeName_5269Parser;
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5270Parser() {
		return new AttributeLabelExpressionLabelParser5270();
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5271Parser() {
		return new AttributeLabelExpressionLabelParser5271();
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5272Parser() {
		return new AttributeLabelExpressionLabelParser5272();
	}

	/**
	* @generated
	*/
	private IParser getAttributeLabel_5273Parser() {
		return new AttributeLabelExpressionLabelParser5273();
	}

	/**
	* @generated
	*/
	private IParser methodName_5276Parser;

	/**
	* @generated
	*/
	private IParser getMethodName_5276Parser() {
		if (methodName_5276Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			methodName_5276Parser = parser;
		}
		return methodName_5276Parser;
	}

	/**
	* @generated
	*/
	private IParser getMethodLabel_5277Parser() {
		return new MethodLabelExpressionLabelParser5277();
	}

	/**
	* @generated
	*/
	private IParser getMethodLabel_5278Parser() {
		return new MethodLabelExpressionLabelParser5278();
	}

	/**
	* @generated
	*/
	private IParser getMethodLabel_5279Parser() {
		return new MethodLabelExpressionLabelParser5279();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5282Parser() {
		return new ConnectionLabelExpressionLabelParser5282();
	}

	/**
	* @generated
	*/
	private IParser connectionName_5283Parser;

	/**
	* @generated
	*/
	private IParser getConnectionName_5283Parser() {
		if (connectionName_5283Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			connectionName_5283Parser = parser;
		}
		return connectionName_5283Parser;
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5284Parser() {
		return new ConnectionLabelExpressionLabelParser5284();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5285Parser() {
		return new ConnectionLabelExpressionLabelParser5285();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5286Parser() {
		return new ConnectionLabelExpressionLabelParser5286();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5287Parser() {
		return new ConnectionLabelExpressionLabelParser5287();
	}

	/**
	* @generated
	*/
	private IParser inheritanceName_5333Parser;

	/**
	* @generated
	*/
	private IParser getInheritanceName_5333Parser() {
		if (inheritanceName_5333Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inheritanceName_5333Parser = parser;
		}
		return inheritanceName_5333Parser;
	}

	/**
	* @generated
	*/
	private IParser inheritanceName_5334Parser;

	/**
	* @generated
	*/
	private IParser getInheritanceName_5334Parser() {
		if (inheritanceName_5334Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inheritanceName_5334Parser = parser;
		}
		return inheritanceName_5334Parser;
	}

	/**
	* @generated
	*/
	private IParser getInheritanceLabel_5335Parser() {
		return new InheritanceLabelExpressionLabelParser5335();
	}

	/**
	* @generated
	*/
	private IParser inheritanceName_5326Parser;

	/**
	* @generated
	*/
	private IParser getInheritanceName_5326Parser() {
		if (inheritanceName_5326Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inheritanceName_5326Parser = parser;
		}
		return inheritanceName_5326Parser;
	}

	/**
	* @generated
	*/
	private IParser inheritanceName_5327Parser;

	/**
	* @generated
	*/
	private IParser getInheritanceName_5327Parser() {
		if (inheritanceName_5327Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inheritanceName_5327Parser = parser;
		}
		return inheritanceName_5327Parser;
	}

	/**
	* @generated
	*/
	private IParser getInheritanceLabel_5328Parser() {
		return new InheritanceLabelExpressionLabelParser5328();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5314Parser() {
		return new EntityLabelExpressionLabelParser5314();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5315Parser() {
		return new EntityLabelExpressionLabelParser5315();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5316Parser() {
		return new EntityLabelExpressionLabelParser5316();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5317Parser() {
		return new EntityLabelExpressionLabelParser5317();
	}

	/**
	* @generated
	*/
	private IParser packageName_5336Parser;

	/**
	* @generated
	*/
	private IParser getPackageName_5336Parser() {
		if (packageName_5336Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5336Parser = parser;
		}
		return packageName_5336Parser;
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5337Parser() {
		return new EntityLabelExpressionLabelParser5337();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5338Parser() {
		return new EntityLabelExpressionLabelParser5338();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5339Parser() {
		return new EntityLabelExpressionLabelParser5339();
	}

	/**
	* @generated
	*/
	private IParser getEntityLabel_5340Parser() {
		return new EntityLabelExpressionLabelParser5340();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5343Parser() {
		return new ConnectionLabelExpressionLabelParser5343();
	}

	/**
	* @generated
	*/
	private IParser connectionName_5344Parser;

	/**
	* @generated
	*/
	private IParser getConnectionName_5344Parser() {
		if (connectionName_5344Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			connectionName_5344Parser = parser;
		}
		return connectionName_5344Parser;
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5345Parser() {
		return new ConnectionLabelExpressionLabelParser5345();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5346Parser() {
		return new ConnectionLabelExpressionLabelParser5346();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5347Parser() {
		return new ConnectionLabelExpressionLabelParser5347();
	}

	/**
	* @generated
	*/
	private IParser getConnectionLabel_5348Parser() {
		return new ConnectionLabelExpressionLabelParser5348();
	}

	/**
	* @generated
	*/
	private IParser inheritanceName_5349Parser;

	/**
	* @generated
	*/
	private IParser getInheritanceName_5349Parser() {
		if (inheritanceName_5349Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inheritanceName_5349Parser = parser;
		}
		return inheritanceName_5349Parser;
	}

	/**
	* @generated
	*/
	private IParser inheritanceName_5350Parser;

	/**
	* @generated
	*/
	private IParser getInheritanceName_5350Parser() {
		if (inheritanceName_5350Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			inheritanceName_5350Parser = parser;
		}
		return inheritanceName_5350Parser;
	}

	/**
	* @generated
	*/
	private IParser getInheritanceLabel_5351Parser() {
		return new InheritanceLabelExpressionLabelParser5351();
	}

	/**
	* @generated
	*/
	private IParser packageName_5352Parser;

	/**
	* @generated
	*/
	private IParser getPackageName_5352Parser() {
		if (packageName_5352Parser == null) {
			EAttribute[] features = new EAttribute[] { PLMPackage.eINSTANCE.getElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5352Parser = parser;
		}
		return packageName_5352Parser;
	}

	/**
	* @generated
	*/
	private IParser getClassificationLabel_6016Parser() {
		return new ClassificationLabelExpressionLabelParser6016();
	}

	/**
	* @generated
	*/
	private IParser getClassificationLabel_6017Parser() {
		return new ClassificationLabelExpressionLabelParser6017();
	}

	/**
	* @generated
	*/
	private IParser getConnectionEndLabel_6024Parser() {
		return new ConnectionEndLabelExpressionLabelParser6024();
	}

	/**
	* @generated
	*/
	private IParser getConnectionEndLabel_6025Parser() {
		return new ConnectionEndLabelExpressionLabelParser6025();
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case DeepModelNameEditPart.VISUAL_ID:
			return getDeepModelName_5331Parser();
		case WrappingLabelEditPart.VISUAL_ID:
			return getDeepModelLabel_5332Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getDeepModelLabel_5353Parser();
		case EnumerationNameEditPart.VISUAL_ID:
			return getEnumerationName_5329Parser();
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_5330Parser();
		case LevelNameEditPart.VISUAL_ID:
			return getLevelName_5320Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getLevelLabel_5321Parser();
		case WrappingLabel4EditPart.VISUAL_ID:
			return getConnectionLabel_5294Parser();
		case ConnectionNameEditPart.VISUAL_ID:
			return getConnectionName_5295Parser();
		case WrappingLabel5EditPart.VISUAL_ID:
			return getConnectionLabel_5296Parser();
		case WrappingLabel6EditPart.VISUAL_ID:
			return getConnectionLabel_5297Parser();
		case WrappingLabel7EditPart.VISUAL_ID:
			return getConnectionLabel_5298Parser();
		case WrappingLabel8EditPart.VISUAL_ID:
			return getConnectionLabel_5299Parser();
		case AttributeNameEditPart.VISUAL_ID:
			return getAttributeName_5254Parser();
		case WrappingLabel9EditPart.VISUAL_ID:
			return getAttributeLabel_5255Parser();
		case WrappingLabel10EditPart.VISUAL_ID:
			return getAttributeLabel_5256Parser();
		case WrappingLabel11EditPart.VISUAL_ID:
			return getAttributeLabel_5257Parser();
		case WrappingLabel12EditPart.VISUAL_ID:
			return getAttributeLabel_5258Parser();
		case MethodNameEditPart.VISUAL_ID:
			return getMethodName_5261Parser();
		case WrappingLabel13EditPart.VISUAL_ID:
			return getMethodLabel_5262Parser();
		case WrappingLabel14EditPart.VISUAL_ID:
			return getMethodLabel_5263Parser();
		case WrappingLabel15EditPart.VISUAL_ID:
			return getMethodLabel_5264Parser();
		case WrappingLabel16EditPart.VISUAL_ID:
			return getEntityLabel_5288Parser();
		case WrappingLabel17EditPart.VISUAL_ID:
			return getEntityLabel_5289Parser();
		case WrappingLabel18EditPart.VISUAL_ID:
			return getEntityLabel_5290Parser();
		case WrappingLabel19EditPart.VISUAL_ID:
			return getEntityLabel_5291Parser();
		case AttributeName2EditPart.VISUAL_ID:
			return getAttributeName_5269Parser();
		case WrappingLabel21EditPart.VISUAL_ID:
			return getAttributeLabel_5270Parser();
		case WrappingLabel22EditPart.VISUAL_ID:
			return getAttributeLabel_5271Parser();
		case WrappingLabel23EditPart.VISUAL_ID:
			return getAttributeLabel_5272Parser();
		case WrappingLabel24EditPart.VISUAL_ID:
			return getAttributeLabel_5273Parser();
		case MethodName2EditPart.VISUAL_ID:
			return getMethodName_5276Parser();
		case WrappingLabel25EditPart.VISUAL_ID:
			return getMethodLabel_5277Parser();
		case WrappingLabel26EditPart.VISUAL_ID:
			return getMethodLabel_5278Parser();
		case WrappingLabel27EditPart.VISUAL_ID:
			return getMethodLabel_5279Parser();
		case WrappingLabel28EditPart.VISUAL_ID:
			return getConnectionLabel_5282Parser();
		case ConnectionName2EditPart.VISUAL_ID:
			return getConnectionName_5283Parser();
		case WrappingLabel29EditPart.VISUAL_ID:
			return getConnectionLabel_5284Parser();
		case WrappingLabel30EditPart.VISUAL_ID:
			return getConnectionLabel_5285Parser();
		case WrappingLabel31EditPart.VISUAL_ID:
			return getConnectionLabel_5286Parser();
		case WrappingLabel32EditPart.VISUAL_ID:
			return getConnectionLabel_5287Parser();
		case InheritanceNameEditPart.VISUAL_ID:
			return getInheritanceName_5333Parser();
		case InheritanceName2EditPart.VISUAL_ID:
			return getInheritanceName_5334Parser();
		case WrappingLabel33EditPart.VISUAL_ID:
			return getInheritanceLabel_5335Parser();
		case InheritanceName3EditPart.VISUAL_ID:
			return getInheritanceName_5326Parser();
		case InheritanceName4EditPart.VISUAL_ID:
			return getInheritanceName_5327Parser();
		case WrappingLabel34EditPart.VISUAL_ID:
			return getInheritanceLabel_5328Parser();
		case WrappingLabel35EditPart.VISUAL_ID:
			return getEntityLabel_5314Parser();
		case WrappingLabel36EditPart.VISUAL_ID:
			return getEntityLabel_5315Parser();
		case WrappingLabel37EditPart.VISUAL_ID:
			return getEntityLabel_5316Parser();
		case WrappingLabel38EditPart.VISUAL_ID:
			return getEntityLabel_5317Parser();
		case PackageNameEditPart.VISUAL_ID:
			return getPackageName_5336Parser();
		case WrappingLabel40EditPart.VISUAL_ID:
			return getEntityLabel_5337Parser();
		case WrappingLabel41EditPart.VISUAL_ID:
			return getEntityLabel_5338Parser();
		case WrappingLabel42EditPart.VISUAL_ID:
			return getEntityLabel_5339Parser();
		case WrappingLabel43EditPart.VISUAL_ID:
			return getEntityLabel_5340Parser();
		case WrappingLabel45EditPart.VISUAL_ID:
			return getConnectionLabel_5343Parser();
		case ConnectionName3EditPart.VISUAL_ID:
			return getConnectionName_5344Parser();
		case WrappingLabel46EditPart.VISUAL_ID:
			return getConnectionLabel_5345Parser();
		case WrappingLabel47EditPart.VISUAL_ID:
			return getConnectionLabel_5346Parser();
		case WrappingLabel48EditPart.VISUAL_ID:
			return getConnectionLabel_5347Parser();
		case WrappingLabel49EditPart.VISUAL_ID:
			return getConnectionLabel_5348Parser();
		case InheritanceName5EditPart.VISUAL_ID:
			return getInheritanceName_5349Parser();
		case InheritanceName6EditPart.VISUAL_ID:
			return getInheritanceName_5350Parser();
		case WrappingLabel50EditPart.VISUAL_ID:
			return getInheritanceLabel_5351Parser();
		case PackageName2EditPart.VISUAL_ID:
			return getPackageName_5352Parser();
		case WrappingLabel51EditPart.VISUAL_ID:
			return getClassificationLabel_6016Parser();
		case WrappingLabel52EditPart.VISUAL_ID:
			return getClassificationLabel_6017Parser();
		case WrappingLabel53EditPart.VISUAL_ID:
			return getConnectionEndLabel_6024Parser();
		case WrappingLabel54EditPart.VISUAL_ID:
			return getConnectionEndLabel_6025Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(PLMVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PLMVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PLMElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}

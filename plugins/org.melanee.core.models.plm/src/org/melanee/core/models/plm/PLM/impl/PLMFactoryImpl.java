/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM.impl;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.ClabjectParameter;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.ClassificationKind;
import org.melanee.core.models.plm.PLM.ComplianceKind;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.ConnectionEndKind;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Enumeration;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.Method;
import org.melanee.core.models.plm.PLM.Multiplicity;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.PrimitiveParameter;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLMFactoryImpl extends EFactoryImpl implements PLMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PLMFactory init() {
		try {
			PLMFactory thePLMFactory = (PLMFactory)EPackage.Registry.INSTANCE.getEFactory("http://melanee.org/PLM"); 
			if (thePLMFactory != null) {
				return thePLMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PLMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PLMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PLMPackage.DOMAIN: return createDomain();
			case PLMPackage.LEVEL: return createLevel();
			case PLMPackage.DEEP_MODEL: return createDeepModel();
			case PLMPackage.INHERITANCE: return createInheritance();
			case PLMPackage.SUPERTYPE: return createSupertype();
			case PLMPackage.SUBTYPE: return createSubtype();
			case PLMPackage.CLASSIFICATION: return createClassification();
			case PLMPackage.ENTITY: return createEntity();
			case PLMPackage.CONNECTION: return createConnection();
			case PLMPackage.CONNECTION_END: return createConnectionEnd();
			case PLMPackage.LML_VISUALIZER: return createLMLVisualizer();
			case PLMPackage.ATTRIBUTE: return createAttribute();
			case PLMPackage.METHOD: return createMethod();
			case PLMPackage.ENUMERATION: return createEnumeration();
			case PLMPackage.CLABJECT_PARAMETER: return createClabjectParameter();
			case PLMPackage.PRIMITIVE_PARAMETER: return createPrimitiveParameter();
			case PLMPackage.MULTIPLICITY: return createMultiplicity();
			case PLMPackage.PACKAGE: return createPackage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PLMPackage.CONNECTION_END_KIND:
				return createConnectionEndKindFromString(eDataType, initialValue);
			case PLMPackage.CLASSIFICATION_KIND:
				return createClassificationKindFromString(eDataType, initialValue);
			case PLMPackage.COMPLIANCE_KIND:
				return createComplianceKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PLMPackage.CONNECTION_END_KIND:
				return convertConnectionEndKindToString(eDataType, instanceValue);
			case PLMPackage.CLASSIFICATION_KIND:
				return convertClassificationKindToString(eDataType, instanceValue);
			case PLMPackage.COMPLIANCE_KIND:
				return convertComplianceKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain createDomain() {
		DomainImpl domain = new DomainImpl();
		return domain;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level createLevel() {
		LevelImpl level = new LevelImpl();
		return level;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeepModel createDeepModel() {
		DeepModelImpl deepModel = new DeepModelImpl();
		return deepModel;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inheritance createInheritance() {
		InheritanceImpl inheritance = new InheritanceImpl();
		return inheritance;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supertype createSupertype() {
		SupertypeImpl supertype = new SupertypeImpl();
		return supertype;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subtype createSubtype() {
		SubtypeImpl subtype = new SubtypeImpl();
		return subtype;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classification createClassification() {
		ClassificationImpl classification = new ClassificationImpl();
		return classification;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity() {
		EntityImpl entity = new EntityImpl();
		return entity;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd createConnectionEnd() {
		ConnectionEndImpl connectionEnd = new ConnectionEndImpl();
		return connectionEnd;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LMLVisualizer createLMLVisualizer() {
		LMLVisualizerImpl lmlVisualizer = new LMLVisualizerImpl();
		return lmlVisualizer;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClabjectParameter createClabjectParameter() {
		ClabjectParameterImpl clabjectParameter = new ClabjectParameterImpl();
		return clabjectParameter;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveParameter createPrimitiveParameter() {
		PrimitiveParameterImpl primitiveParameter = new PrimitiveParameterImpl();
		return primitiveParameter;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiplicity createMultiplicity() {
		MultiplicityImpl multiplicity = new MultiplicityImpl();
		return multiplicity;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.melanee.core.models.plm.PLM.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEndKind createConnectionEndKindFromString(EDataType eDataType, String initialValue) {
		ConnectionEndKind result = ConnectionEndKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionEndKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassificationKind createClassificationKindFromString(EDataType eDataType, String initialValue) {
		ClassificationKind result = ClassificationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassificationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplianceKind createComplianceKindFromString(EDataType eDataType, String initialValue) {
		ComplianceKind result = ComplianceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComplianceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PLMPackage getPLMPackage() {
		return (PLMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PLMPackage getPackage() {
		return PLMPackage.eINSTANCE;
	}


	
	/**
	 * This methods creates a clabject from a template. All features and LMLVisualizers
	 * are copied to the new clabject and the potency is calculated base on the new
	 * clabjects parent. In case the newClabject is on the level below of template a
	 * Classification relationship is created. Does not copy bounds.
	 * 
	 * @param template the clabject which hold all values for creation
	 * @param newParent the parent in which the clabject is placed in 
	 * 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public Clabject createClabjectFromTemplate(Clabject template, Element newParent) {
		return createClabjectFromTemplate(template, newParent, false, true);	
	}
	
	
	/**
	 * This methods creates a clabject from a template. All features and LMLVisualizers
	 * are copied to the new clabject and the potency is calculated base on the new
	 * clabjects parent. In case the newClabject is on the level below of template a
	 * Classification relationship is created
	 * 
	 * @param template the clabject which hold all values for creation
	 * @param newParent the parent in which the clabject is placed in 
	 * @param copyLocation copy X/Y location
	 * @param copySize width and height
	 * 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public Clabject createClabjectFromTemplate(Clabject template, Element newParent, boolean copyLocation, boolean copySize) {
		if(template.getPotency() == 0 || newParent == null)
			return null;
			
		Clabject result = template instanceof Entity ? PLMFactory.eINSTANCE.createEntity() : PLMFactory.eINSTANCE.createConnection();
		configureClabject(template, result, newParent, copyLocation, copySize);
		return result;	
	}
	
	
	/**
	 * Does not copy location but size.<br />
	 * Does not initialize attributes with default values 
	 *
	 * @param template the template to "instantiate"
	 * @param newClabject the clabject which is the "instance"
	 *
	 * @generated
	 */
	 
	public void configureClabject(Clabject template, Clabject newClabject){
		configureClabject(template, newClabject, null, false);
	}
	
	
	/**
	 * Does not copy location but size.<br />
	 *
	 * @param template the template to "instantiate"
	 * @param newClabject the clabject which is the "instance"
	 * @param initializeAttributes initializes the ontological attributes of a clabject:
	 * 			<ul><li>string = [attribute.name]</li><li>numeric = 0</li><li>boolean = false</li><li>others are not initialized</li></ul>
	 *
	 * @generated
	 */
	 
	public void configureClabject(Clabject template, Clabject newClabject, boolean initializeAttributes){
		configureClabject(template, newClabject, null, initializeAttributes, false, true);
	}
	
	
	/**
	 * Does not copy location but size.<br />
	 * Does not initialize attributes with default values
	 * 
	 * @param template
	 * @param newClabject
	 * @param newParent null if newClabject has already a model set or no parent exists
	 * 			the method will ignore the parent or use one if it can find one to calculate
	 * 			values. Possible values are Models, Connections or Entities as they can 
	 * 			contain clabjects. Can be null to not set a new parent. This is needed in 
	 * 			cases where this could raise a read/write transaction exception. If the 
	 * 			new parten is null, the potency is calculated by substracting one from
	 * 			the type potency.
	 *
	 * @generated
	 */
	
	public void configureClabject(Clabject template, Clabject newClabject, Element newParent){
		configureClabject(template, newClabject, newParent, false, false, true);
	}
	
	
	/**
	 * Does not copy bounds 
	 * @param template
	 * @param newClabject
	 * @param newParent null if newClabject has already a model set or no parent exists
	 * 			the method will ignore the parent or use one if it can find one to calculate
	 * 			values. Possible values are Models, Connections or Entities as they can 
	 * 			contain clabjects. Can be null to not set a new parent. This is needed in 
	 * 			cases where this could raise a read/write transaction exception. If the 
	 * 			new parten is null, the potency is calculated by substracting one from
	 * 			the type potency.
	 * @param initializeAttributes initializes the ontological attributes of a clabject:
	 * 			<ul><li>string = [attribute.name]</li><li>numeric = 0</li><li>boolean = false</li><li>others are not initialized</li></ul>
	 *
	 *
	 * @generated
	 */
	
	public void configureClabject(Clabject template, Clabject newClabject, Element newParent, boolean initializeAttributes){
		configureClabject(template, newClabject, newParent, initializeAttributes, false, true);
	}
	
	
	/**
	 * 
	 * @param template
	 * @param newClabject
	 * @param newParent null if newClabject has already a model set or no parent exists
	 * 			the method will ignore the parent or use one if it can find one to calculate
	 * 			values. Possible values are Models, Connections or Entities as they can 
	 * 			contain clabjects. Can be null to not set a new parent. This is needed in 
	 * 			cases where this could raise a read/write transaction exception. If the 
	 * 			new parten is null, the potency is calculated by substracting one from
	 * 			the type potency.
	 * @param copyLocation copy X/Y location
	 * @param copySize width and height
	 *
	 * @generated
	 */
	
	public void configureClabject(Clabject template, Clabject newClabject, Element newParent, boolean copyLocation, boolean copySize){
		configureClabject(template, newClabject, newParent, false, copyLocation, copySize);
	}
	
		
	/**
	 * 
	 * @param template
	 * @param newClabject
	 * @param newParent null if newClabject has already a model set or no parent exists
	 * 			the method will ignore the parent or use one if it can find one to calculate
	 * 			values. Possible values are Models, Connections or Entities as they can 
	 * 			contain clabjects. Can be null to not set a new parent. This is needed in 
	 * 			cases where this could raise a read/write transaction exception. If the 
	 * 			new parten is null, the potency is calculated by substracting one from
	 * 			the type potency.
	 * @param copyLocation copy X/Y location
	 * @param copySize width and height
	 *
	 * @generated
	 */
	
	public void configureClabject(Clabject template, Clabject newClabject, Element newParent, boolean initializeAttributes, boolean copyLocation, boolean copySize){

		//No new Parent is provided for clabject and it has not been set yet.
		if (newParent == null && newClabject.eContainer() != null)
			newParent = (Element)newClabject.eContainer();
		
		//Add the Entity to the newParent if not already done
		if (newParent != null 
				&& newParent != newClabject.eContainer())
			if (newParent instanceof Level)
				((Level)newParent).getContent().add(newClabject);
			else if (newParent instanceof Clabject)
				((Clabject)newParent).getContent().add(newClabject);
		
		//******************************
		// Copy traits
		//******************************
		//Level is now derived
		//if (newParent != null)
		//	newClabject.setLevel(newParent.getLevel());
		
		//******************************
		// Copy LML Visualizers
		//******************************
		if (template.getVisualizer().size() > 0){
			//Quick hack to get a visualizer from type in
			LMLVisualizer instanceVisualizer = PLMFactory.eINSTANCE.createLMLVisualizer();
			LMLVisualizer typeVisualizer = template.getVisualizer().get(0);
					
			/*instanceVisualizer.setTemplate(typeVisualizer.getTemplate());
			instanceVisualizer.setDurability(
				//This check is to simple needs to be enhanced once the visualizer
				//durability is fully supported
				typeVisualizer.getDurability() == 0 
					|| typeVisualizer.getDurability() == -1 ?
							typeVisualizer.getDurability() 
								: typeVisualizer.getDurability() - 1
			);*/
				
			instanceVisualizer.getAttributes().addAll(typeVisualizer.getAttributes());
			
			if(copySize){
				instanceVisualizer.setWidth(typeVisualizer.getWidth());
				instanceVisualizer.setHeight(typeVisualizer.getHeight());
			}
			
			if(copyLocation){
				instanceVisualizer.setXLocation(typeVisualizer.getXLocation());
				instanceVisualizer.setYLocation(typeVisualizer.getYLocation());
			}
			
			newClabject.getVisualizer().clear();
			newClabject.getVisualizer().add(instanceVisualizer);
		}
		//There is no visualizer present at the moment. This can happen in case the
		// template element is created via GMF and not initialized yet. Happens in
		// emendation service
		else{
			LMLVisualizer visualizer = PLMFactory.eINSTANCE.createLMLVisualizer();
			newClabject.getVisualizer().add(visualizer);
			visualizer.getAttributes().addAll(visualizer.getDefaultVisualizationValues());
		}
					
					
		//****************************
		// Calculate the new potency
		//****************************
		if (template.getPotency() == -1)
			newClabject.setPotency(-1);
		else if (newParent == null)
			newClabject.setPotency(template.getPotency() - 1);
		else{
			int levelDifference = template.getLevelIndex() - newClabject.getLevelIndex();
			newClabject.setPotency(template.getPotency() + levelDifference);
		}
					
		if (newClabject.getPotency() < -1)
			throw new RuntimeException("Clabjects with a negative potency cannot exist.");
				
					
		//*****************************
		// Copy the features
		//*****************************
		List<Feature> features = new LinkedList<Feature>();
					
		for (Feature f : template.getAllFeatures()) {
			if (f.getDurability() == 0)
				continue;
					
			Feature newFeature = createFeature(f, newClabject, initializeAttributes);
					
			features.add(newFeature);
		}
		
		newClabject.getFeature().addAll(features);
				
				
		//******************************************************
		// Create a classification to the template if possible
		//******************************************************
		if (newParent != null &&
				template.getLevelIndex() == newClabject.getLevelIndex() - 1){
			Classification i = PLMFactoryImpl.eINSTANCE.createClassification();
			i.setType(template);
			i.setInstance(newClabject);
			if (newParent instanceof Level)
				((Level)newParent).getContent().add(i);
			else if(newParent instanceof Clabject)
				((Clabject)newParent).getLevel().getContent().add(i);
			
		}
		
		//******************************************************
		// Create a connection to the composite/aggregate
		//******************************************************
		if (newParent instanceof Clabject
				&& template.getLevelIndex() == newClabject.getLevelIndex() - 1
				&& (
						template.getComposite() != null
							|| template.getAggregates().size() > 0
					)
			){
			//Find the connection to instantiate
			List<Clabject> compositesAndAggregates = new ArrayList<Clabject>();
			if(template.getComposite() != null)
				compositesAndAggregates.add(template.getComposite());
			compositesAndAggregates.addAll(template.getAggregates());
			
			Connection typeConnection = null;
			
			for(Clabject c : compositesAndAggregates){
				
				//Found the type of the container
				if(c.getClassificationTreeAsType().contains(newParent)){
					
					//Find the connection pointing to the type of the content
					outer: for (Connection con : c.getConnections()){
						for(ConnectionEnd p : con.getConnectionEnd()){
							if(p.getDestination() == template
									|| p.getDestination().getSubtypes().contains(template)){
								typeConnection = con;
								break outer;
							}
						}
					}
				}
			}
			
			Connection c = createConnectionWithLMLVisualizer();
			configureClabject(typeConnection, c, newParent);
			
			((Clabject) newParent).getContent().add(c);
			ConnectionEnd toPart = createConnectionEnd();
			c.getConnectionEnd().add(toPart);
			toPart.setDestination(newClabject);
			ConnectionEnd toContainer = createConnectionEnd();
			toContainer.setDestination((Clabject)newParent);
			c.getConnectionEnd().add(toContainer);
			
			//instantiate the values for the connectionEnds
			//this code assumes two connectionEnds only
			outter: for(ConnectionEnd p : typeConnection.getConnectionEnd()){
				
				List<Clabject> destinations = new ArrayList<Clabject>();
				destinations.add(p.getDestination());
				destinations.addAll(p.getDestination().getSubtypes());
				
				for(Clabject d : destinations){
					//The connectionEnd to the part was found
					if(d.getClassificationTreeAsType().contains(newClabject)){
						toPart.setNavigable(p.isNavigable());
						toPart.setLower(p.getLower());
						toPart.setUpper(p.getUpper());
						toPart.setMoniker(p.getMoniker());
						toPart.setKind(p.getKind());
						toPart.setType(p);
						
						//continue with the next connectionEnd
						continue outter;
					}
				}
				
				//The connectionEnd to the part was not found -> connectionEnd to container
				toContainer.setNavigable(p.isNavigable());
				toContainer.setLower(p.getLower());
				toContainer.setUpper(p.getUpper());
				toContainer.setMoniker(p.getMoniker());
				toContainer.setKind(p.getKind());
				toContainer.setType(p);
			}
		}
	}
	
	
	/**
	 * Creates a new feature from the template.
	 * Does not initialize attributes.
	 * 
	 * @param template the template to create from
	 * @param newParent null if it shall not be added to a parent by this method
	 * @return
	 *
	 * @generated
	 */
	 
	public Feature createFeature(Feature template, Clabject newParent){
		return createFeature(template, template.getClabject() , newParent, false);
	}
	
	
	/**
	 * Creates a new feature from the template
	 * 
	 * @param template the template to create from
	 * @param newParent null if it shall not be added to a parent by this method
	 * @param initializeAttributes initialized the ontological attributes of a clabject:
	 * 			<ul><li>string = [attribute.name]</li><li>numeric = 0</li><li>boolean = false</li><li>others are not initialized</li></ul>
	 * @return
	 *
	 * @generated
	 */
	 
	public Feature createFeature(Feature template, Clabject newParent, boolean initializeAttribute){
		return createFeature(template, template.getClabject() , newParent, initializeAttribute, true);
	}
	

	/**
	 * Creates a new feature from the template
	 * Does not initialize attributes.
	 * 
	 * @param template
	 * @param newParent
	 * @param initializeAttributes initialized the ontological attributes of a clabject:
	 * 			<ul><li>string = [attribute.name]</li><li>numeric = 0</li><li>boolean = false</li><li>others are not initialized</li></ul>
	 * 
	 * @return
	 *
	 * @generated
	 */
	
	public Feature createFeature(Feature template, Clabject templateParent, Clabject newParent, boolean addNewElementToParent){
		return createFeature(template, templateParent, newParent, false, addNewElementToParent);
	}
	
	
	/**
	 * Creates a new feature from the template
	 * 
	 * @param template
	 * @param newParent
	 * @param initializeAttributes initialized the ontological attributes of a clabject:
	 * 			<ul><li>string = [attribute.name]</li><li>numeric = 0</li><li>boolean = false</li><li>others are not initialized</li></ul>
	 * 
	 * @return
	 *
	 * @generated
	 */
	
	public Feature createFeature(Feature template, Clabject templateParent, Clabject newParent, boolean initializeAttribute, boolean addNewElementToParent){
		Feature result = template instanceof Attribute ? PLMFactory.eINSTANCE.createAttribute() : PLMFactory.eINSTANCE.createMethod();
		
		if (addNewElementToParent)
			newParent.getFeature().add(result);
		
		result.setName(template.getName());
		
		
		if(result instanceof Attribute && template instanceof Attribute)
			((Attribute) result).setValue(((Attribute)template).getValue());
			
		//***************************************
		// Calculate the durability
		//***************************************
		if (template.getDurability() == -1)
			result.setDurability(-1);
		else{
			int levelDifference = newParent.getLevelIndex();
			//This happens if the clabject containing the feature does not belong to
			//to a level for this case it is intended to substract one, as if
			//the clabject is instantiated on the next level.
			if(levelDifference != -1)
			 levelDifference = templateParent.getLevelIndex() - newParent.getLevelIndex();

			result.setDurability(template.getDurability() + levelDifference);
		}
			
		if (result.getDurability() < -1)
			throw new RuntimeException("Clabjects with a negative potency cannot exist.");

			
		//********************
		// Copy LMLVisualizer
		//********************
		if (template.getVisualizer().size() > 0){
			//Quick hack to get a visualizer from type in
			LMLVisualizer instanceVisualizer = PLMFactory.eINSTANCE.createLMLVisualizer();
			LMLVisualizer typeVisualizer = template.getVisualizer().get(0);
			
			/*instanceVisualizer.setTemplate(typeVisualizer.getTemplate());
			instanceVisualizer.setDurability(
					//This check is to simple needs to be enhanced once the visualizer
					//durability is fully supported
					typeVisualizer.getDurability() == 0 
						|| typeVisualizer.getDurability() == -1 ?
								typeVisualizer.getDurability() 
								: typeVisualizer.getDurability() - 1
				);*/
			
			instanceVisualizer.getAttributes().addAll(typeVisualizer.getAttributes());
	
			result.getVisualizer().clear();
			result.getVisualizer().add(instanceVisualizer);
		}
		//There is no visualizer present at the moment. This can happen in case the
		// template element is created via GMF and not initialized yet. Happens in
		// emendation service
		else{
			LMLVisualizer visualizer = PLMFactory.eINSTANCE.createLMLVisualizer();
			result.getVisualizer().add(visualizer);
			visualizer.getAttributes().addAll(visualizer.getDefaultVisualizationValues());
		}
		
		
		return result instanceof Attribute ? configureAttribute((Attribute)template, templateParent, (Attribute)result, newParent, initializeAttribute) : configureMethod(template, result); 
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	
	private Feature configureMethod(Feature template, Feature result) {
		return result;
	}
	
	
	/**
	 * @param initializeAttributes initialized the ontological attributes of a clabject:
	 * 			<ul><li>string = [attribute.name]</li><li>numeric = 0</li><li>boolean = false</li><li>others are not initialized</li></ul>
	 *
	 * @generated
	 */
	
	private Feature configureAttribute(Attribute template, Clabject templateParent, Attribute result, Clabject resultParent, boolean initializeAttribute) {
		result.setDatatype(template.getDatatype());
		
		//***************************
		// Calculate mutability
		//***************************
		if (template.getMutability() == -1)
			result.setMutability(-1);
		else if (template.getMutability() == 0
					&& templateParent.getLevelIndex() <= resultParent.getLevelIndex()){
			result.setMutability(0); 
		}
		else{
			int levelDifference = resultParent.getLevelIndex();
			//This happens if the clabject containing the feature does not belong to
			//to a level for this case it is intended to substract one, as if
			//the clabject is instantiated on the next level.
			if(levelDifference != -1)
			 levelDifference = templateParent.getLevelIndex() - resultParent.getLevelIndex();

			result.setMutability(template.getMutability() + levelDifference);
		}
		
		//**********************************************************************************
		// If both template and result have mutability = 0 they need to have the same value
		//**********************************************************************************
		if (template.getMutability() == 0 && result.getMutability() == 0)
			result.setValue(template.getValue());
		
		//**********************************************************************************
		// Initialize attributes
		//**********************************************************************************
		if(initializeAttribute &&
				result.getValue() == null ){
			List<String> primitiveDataTypes = result.getPrimitiveDataTypes();

			if(!(primitiveDataTypes.contains("String")
					|| primitiveDataTypes.contains("Real")
					|| primitiveDataTypes.contains("Integer")
					|| primitiveDataTypes.contains("Natural")
					|| primitiveDataTypes.contains("Boolean")
					|| primitiveDataTypes.contains("Percent")
					|| primitiveDataTypes.contains("Probability")
					|| primitiveDataTypes.contains("Money")))
				throw new RuntimeException("Datatypes in factory not in synch with annotation in models");
			
			List<String> numericDatatypes = Arrays.asList("Real", "Integer", "Natural", "Percent", "Probability", "Money");
			
			if(numericDatatypes.contains(result.getDatatype()))
				result.setValue("0");
			else if("String".equals(result.getDatatype()))
				result.setValue(result.getName());
			else if("Boolean".equals(result.getDatatype()))
				result.setValue("false");
		}
		
		return result;
	}
	
	
		
		
		  
	  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Level createLevelWithLMLVisualizer(){
			
					//Execute the default factory code
					Level newObject = createLevel();
				
					//Add a visualizer
					LMLVisualizer LevelVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(LevelVisualizer);
					LevelVisualizer.getAttributes().addAll(LevelVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public DeepModel createDeepModelWithLMLVisualizer(){
			
					//Execute the default factory code
					DeepModel newObject = createDeepModel();
				
					//Add a visualizer
					LMLVisualizer DeepModelVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(DeepModelVisualizer);
					DeepModelVisualizer.getAttributes().addAll(DeepModelVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	  
	  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Inheritance createInheritanceWithLMLVisualizer(){
			
					//Execute the default factory code
					Inheritance newObject = createInheritance();
				
					//Add a visualizer
					LMLVisualizer InheritanceVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(InheritanceVisualizer);
					InheritanceVisualizer.getAttributes().addAll(InheritanceVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	
		
		
		  
	
		
		
		  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Classification createClassificationWithLMLVisualizer(){
			
					//Execute the default factory code
					Classification newObject = createClassification();
				
					//Add a visualizer
					LMLVisualizer ClassificationVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(ClassificationVisualizer);
					ClassificationVisualizer.getAttributes().addAll(ClassificationVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	  
	  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Entity createEntityWithLMLVisualizer(){
			
					//Execute the default factory code
					Entity newObject = createEntity();
				
					//Add a visualizer
					LMLVisualizer EntityVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(EntityVisualizer);
					EntityVisualizer.getAttributes().addAll(EntityVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Connection createConnectionWithLMLVisualizer(){
			
					//Execute the default factory code
					Connection newObject = createConnection();
				
					//Add a visualizer
					LMLVisualizer ConnectionVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(ConnectionVisualizer);
					ConnectionVisualizer.getAttributes().addAll(ConnectionVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	
		
		
		  
	
		
		
		  
	  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Attribute createAttributeWithLMLVisualizer(){
			
					//Execute the default factory code
					Attribute newObject = createAttribute();
				
					//Add a visualizer
					LMLVisualizer AttributeVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(AttributeVisualizer);
					AttributeVisualizer.getAttributes().addAll(AttributeVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Method createMethodWithLMLVisualizer(){
			
					//Execute the default factory code
					Method newObject = createMethod();
				
					//Add a visualizer
					LMLVisualizer MethodVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(MethodVisualizer);
					MethodVisualizer.getAttributes().addAll(MethodVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public Enumeration createEnumerationWithLMLVisualizer(){
			
					//Execute the default factory code
					Enumeration newObject = createEnumeration();
				
					//Add a visualizer
					LMLVisualizer EnumerationVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(EnumerationVisualizer);
					EnumerationVisualizer.getAttributes().addAll(EnumerationVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	  
	
		
		
		  
	
		
		
		  
	
		
		
		  
	
		
		
				
				/**
				 * <!-- begin-user-doc -->
				 * <!-- end-user-doc -->
			 	* @generated
			 	*/
				public org.melanee.core.models.plm.PLM.Package createPackageWithLMLVisualizer(){
			
					//Execute the default factory code
					org.melanee.core.models.plm.PLM.Package newObject = createPackage();
				
					//Add a visualizer
					LMLVisualizer PackageVisualizer = createLMLVisualizer();
					newObject.getVisualizer().add(PackageVisualizer);
					PackageVisualizer.getAttributes().addAll(PackageVisualizer.getDefaultVisualizationValues());
				
					return newObject;
				}
				
			
		  
	  
	  
	  
} //PLMFactoryImpl
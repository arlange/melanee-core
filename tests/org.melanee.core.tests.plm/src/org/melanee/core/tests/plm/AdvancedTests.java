package org.melanee.core.tests.plm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.ClassificationKind;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Enumeration;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMFactory;

public class AdvancedTests {

	@Test
	public void testAttributeEnumerationDataType() {

		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		Attribute att1 = PLMFactory.eINSTANCE.createAttribute();
		att1.setDatatype("Boolean");
		c.getFeature().add(att1);
		l.getContent().add(c);
		assertTrue("Result of att1.getDatatype() must be Boolean",
				att1.getDatatype() == "Boolean");

		Enumeration enum1 = PLMFactory.eINSTANCE.createEnumeration();
		enum1.getLiteral().add("test1");
		enum1.getLiteral().add("test2");
		enum1.getLiteral().add("test3");
		enum1.getLiteral().add("test4");
		enum1.setName("enum1");

		dm.getEnumeration().add(enum1);

		assertTrue("Result of att1.isEnumeration() must be false",
				att1.isEnumeration() == false);

		att1.setDatatype("enum1");
		assertTrue("Result of att1.isEnumeration() must be true",
				att1.isEnumeration() == true);
		assertTrue("Result of att1.getEnumeration() must be enum1",
				att1.getEnumeration() == enum1);
		assertTrue("Result of att1.getLiterals() must contain test1+2+3+4",
				att1.getLiterals().contains("test1")
						&& att1.getLiterals().contains("test2")
						&& att1.getLiterals().contains("test3")
						&& att1.getLiterals().contains("test4"));

	}

	@Test
	public void testConfigureClabject(){
		
		//Situation of the test:
		//DeepModel contains 2 Levels
		//first level contains a clabject with an attribute
		//second level is empty
		//the clabject of the first level should be cloned to the second level
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		//fist level
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		//type to instantiate with one attribute
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setPotency(1);
		Attribute att1 = PLMFactory.eINSTANCE.createAttribute();
		att1.setDatatype("Boolean");
		att1.setDurability(1);
		att1.setMutability(1);
		c.getFeature().add(att1);
		l.getContent().add(c);
		
		//second level
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		Clabject newClabject = PLMFactory.eINSTANCE.createEntity();
		newClabject.setName("NewClabject");
		
		//method under test
		//calls  createFeature(Feature template, Clabject templateParent, Clabject newParent, boolean addNewElementToParent)
		//which creates wrong durabilities
		PLMFactory.eINSTANCE.configureClabject(c, newClabject, null);
		
		assertTrue("The potency of NewClabject should be 0 but is " + newClabject.getPotency(), newClabject.getPotency() == 0);
		assertTrue("The durability of the attribute should be 0 but is " + newClabject.getFeature().get(0).getDurability(), newClabject.getFeature().get(0).getDurability() == 0);
		assertTrue("The mutability of the attribute should be 0 but is" + ((Attribute)newClabject.getFeature().get(0)).getMutability(), ((Attribute)newClabject.getFeature().get(0)).getMutability() == 0);
		
		l2.getContent().add(newClabject);

		Classification newClassification = PLMFactory.eINSTANCE.createClassification();
		newClassification.setType(c);
		newClassification.setInstance(newClabject);
		newClassification.setKind(ClassificationKind.INSTANTIATION);

		l2.getContent().add(newClassification);
	}
	
	@Test
	public void testCreateFromTemplate(){
		Clabject template = PLMFactory.eINSTANCE.createEntity();
		template.setPotency(0);
		Clabject result1 = PLMFactory.eINSTANCE.createClabjectFromTemplate(template, PLMFactory.eINSTANCE.createLevel());
		Clabject result2 = PLMFactory.eINSTANCE.createClabjectFromTemplate(template, null);
		template.setPotency(1);
		Clabject result3 = PLMFactory.eINSTANCE.createClabjectFromTemplate(template, null);
		assertTrue("If potency is zero or parent is null then result should be null", result1 == null && result2 == null && result3 == null);
	}

	
}

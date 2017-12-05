package org.melanee.core.tests.designation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.melanee.core.designation.service.DesignationService;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

public class HeritageTests {

	@Test
	public void testHeritage() {
		DeepModel model = PLMFactory.eINSTANCE.createDeepModel();
		model.setName("Heritage Test");
		
		Entity lastEntity = null;
		
		Entity[] entities = new Entity[5];
		Level l = PLMFactory.eINSTANCE.createLevel();
		l.setName("O0");
		model.getContent().add(l);
		
		for(int i = 0; i < 5; i++){
			Entity e = PLMFactory.eINSTANCE.createEntity();
			e.setName("E"+i);
			l.getContent().add(e);
			
			Attribute a = PLMFactory.eINSTANCE.createAttribute();
			a.setName("ontName");
			a.setValue("OntE" + i);
			e.getFeature().add(a);
			
			if(lastEntity != null){
				Inheritance in = PLMFactory.eINSTANCE.createInheritance();
				Supertype supT = PLMFactory.eINSTANCE.createSupertype();
				supT.setSupertype(lastEntity);
				in.getSupertype().add(supT);
				Subtype subT = PLMFactory.eINSTANCE.createSubtype();
				subT.setSubtype(e);
				in.getSubtype().add(subT);
				l.getContent().add(in);
			}
			
			entities[i] = e;
			lastEntity = e;
		}
		
		String designator = DesignationService.getInstance().evaluate(entities[3], "1>ontName");
		assertTrue("Direct heritage failed.", "E2>OntE3".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[3], "3>ontName");
		assertTrue("Direct heritage failed.", "E0>E1>E2>OntE3".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[3], "3>>ontName");
		assertTrue("Elided heritage failed", "E0>>OntE3".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[3], "3>>1>ontName");
		assertTrue("Ellision mix failed.", "E0>>E2>OntE3".equals(designator));
		
		//*****************************
		// Test double heritage
		//*****************************
		Entity secondSupertypeEntity = PLMFactory.eINSTANCE.createEntity();
		secondSupertypeEntity.setName("E3_2");
		l.getContent().add(secondSupertypeEntity);
		
		Attribute a = PLMFactory.eINSTANCE.createAttribute();
		a.setName("ontName");
		a.setValue("OntE3_2");
		secondSupertypeEntity.getFeature().add(a);
		
		Inheritance in = PLMFactory.eINSTANCE.createInheritance();
		Supertype supT = PLMFactory.eINSTANCE.createSupertype();
		supT.setSupertype(secondSupertypeEntity);
		in.getSupertype().add(supT);
		Subtype subT = PLMFactory.eINSTANCE.createSubtype();
		subT.setSubtype(entities[4]);
		in.getSubtype().add(subT);
		l.getContent().add(in);
		
		designator = DesignationService.getInstance().evaluate(entities[4], "1>ontName");
		assertTrue("Direct double heritage failed.", "E3,E3_2>OntE4".equals(designator) || "E3_2,E3>OntE4".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[4], "4>>1>ontName");
		assertTrue("Direct double heritage elision mix failed.", "E0>>E3_2,E3>OntE4".equals(designator) || "E0>>E3,E3_2>OntE4".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[4], "2>1>ontName");
		assertTrue("Direct double heritage distance 2.", "E2>E3_2,E3>OntE4".equals(designator) || "E2>E3,E3_2>OntE4".equals(designator));
	}

}

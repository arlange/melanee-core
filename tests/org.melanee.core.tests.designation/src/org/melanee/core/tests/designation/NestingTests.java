package org.melanee.core.tests.designation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.melanee.core.designation.service.DesignationService;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMFactory;

public class NestingTests {

	@Test
	public void testNesting() {
		DeepModel model = PLMFactory.eINSTANCE.createDeepModel();
		model.setName("Location_Test");
		
		Entity lastEntity = null;
		
		Entity[] entities = new Entity[5];
		Level l = PLMFactory.eINSTANCE.createLevel();
		l.setName("O0");
		model.getContent().add(l);
		
		for(int i = 0; i < 5; i++){
			Entity e = PLMFactory.eINSTANCE.createEntity();
			e.setName("E"+i);
			
			
			Attribute a = PLMFactory.eINSTANCE.createAttribute();
			a.setName("ontName");
			a.setValue("OntE" + i);
			e.getFeature().add(a);
			
			if(lastEntity != null){
				lastEntity.getContent().add(e);
			}
			else{
				l.getContent().add(e);
			}
			
			entities[i] = e;
			lastEntity = e;
		}
		
		String designator = DesignationService.getInstance().evaluate(entities[3], "1(ontName).ontName");
		assertTrue("Direct heritage failed.", "(OntE2).OntE3".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[3], "3(1.ontName).ontName");
		assertTrue("Direct heritage failed.", "(O0.OntE0).(E0.OntE1).(E1.OntE2).OntE3".equals(designator));
		
		designator = DesignationService.getInstance().evaluate(entities[3], "3(1.ontName)..ontName");
		assertTrue("Elided heritage failed", "(O0.OntE0)..OntE3".equals(designator));
		
		
		//TODO: These two tests must be fixed in final service
//		designator = DesignationService.getInstance().evaluate("4(ontName)..1.ontName", entities[3]);
//		assertTrue("Ellision mix model failed.", "(O0)..(OntE2)..E2.OntE3".equals(designator));
//		
//		designator = DesignationService.getInstance().evaluate("5(ontName)..1.ontName", entities[3]);
//		assertTrue("Ellision mix deep model failed.", "(Location_Test)..(OntE2)..E2.OntE3".equals(designator));
	}

}

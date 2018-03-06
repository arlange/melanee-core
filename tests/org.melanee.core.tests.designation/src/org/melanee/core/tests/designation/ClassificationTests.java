package org.melanee.core.tests.designation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.melanee.core.designation.service.DesignationService;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMFactory;

public class ClassificationTests {

  @Test
  public void testClassification() {
    DeepModel model = PLMFactory.eINSTANCE.createDeepModel();
    model.setName("Classification Test");

    Entity lastEntity = null;

    Entity[] entities = new Entity[5];
    Level[] levels = new Level[5];

    for (int i = 0; i < 5; i++) {
      Level l = PLMFactory.eINSTANCE.createLevel();
      l.setName("O" + i);
      model.getContent().add(l);
      Entity e = PLMFactory.eINSTANCE.createEntity();
      e.setName("C" + i);
      l.getContent().add(e);

      Attribute a = PLMFactory.eINSTANCE.createAttribute();
      a.setName("ontName");
      a.setValue("OntC" + i);
      e.getFeature().add(a);

      if (lastEntity != null) {
        Classification c = PLMFactory.eINSTANCE.createClassification();
        c.setType(lastEntity);
        c.setInstance(e);
        l.getContent().add(c);
      }

      levels[i] = l;
      entities[i] = e;
      lastEntity = e;
    }

    String designator = DesignationService.getInstance().evaluate(entities[3], "ontName:1");
    assertTrue("Direct Classification failed.", "OntC3:C2".equals(designator));

    designator = DesignationService.getInstance().evaluate(entities[3], "ontName:3");
    assertTrue("Direct Classification failed.", "OntC3:C2:C1:C0".equals(designator));

    designator = DesignationService.getInstance().evaluate(entities[3], "ontName::3");
    assertTrue("Elided Classification failed", "OntC3::C0".equals(designator));

    designator = DesignationService.getInstance().evaluate(entities[3], "ontName:1::3");
    assertTrue("Ellision mix failed.", "OntC3:C2::C0".equals(designator));

    // *****************************
    // Test double classification
    // *****************************
    Level classifyingLevel = levels[3];
    Entity secondClassifyingEntity = PLMFactory.eINSTANCE.createEntity();
    secondClassifyingEntity.setName("C3_2");
    classifyingLevel.getContent().add(secondClassifyingEntity);

    Attribute a = PLMFactory.eINSTANCE.createAttribute();
    a.setName("ontName");
    a.setValue("OntC3_2");
    secondClassifyingEntity.getFeature().add(a);

    Classification c = PLMFactory.eINSTANCE.createClassification();
    c.setType(secondClassifyingEntity);
    c.setInstance(entities[4]);
    levels[4].getContent().add(c);

    designator = DesignationService.getInstance().evaluate(entities[4], "ontName:1");
    assertTrue("Direct double classification failed.",
        "OntC4:C3_2,C3".equals(designator) || "OntC4:C3,C3_2".equals(designator));

    designator = DesignationService.getInstance().evaluate(entities[4], "ontName:1::4");
    assertTrue("Direct double classification elision mix failed.",
        "OntC4:C3_2,C3::C0".equals(designator) || "OntC4:C3,C3_2::C0".equals(designator));

    designator = DesignationService.getInstance().evaluate(entities[4], "ontName:1:2");
    assertTrue("Direct double classification distance 2.",
        "OntC4:C3_2,C3:C2".equals(designator) || "OntC4:C3,C3_2:C2".equals(designator));
  }
}
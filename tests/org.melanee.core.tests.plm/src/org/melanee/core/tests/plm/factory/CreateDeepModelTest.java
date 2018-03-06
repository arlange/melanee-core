/*******************************************************************************
 * Copyright (c) 2013 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.tests.plm.factory;

import org.junit.Test;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

/**
 * Important: Run as JUnit Plug-in Test
 */
public class CreateDeepModelTest {

  /**
   * This test creates the three level breed example with the plm
   */
  @Test
  public void test() {

    /**********************************************
     * Create first the domain which contains all Ontologies
     **********************************************/
    Domain domain = PLMFactory.eINSTANCE.createDomain();

    /**********************************************
     * Create the ontology which contains the ontological levels
     **********************************************/
    DeepModel ontology = PLMFactory.eINSTANCE.createDeepModelWithLMLVisualizer();
    ontology.setName("Breed DeepModel");
    domain.getDeepModel().add(ontology);

    /**********************************************
     * Create three ontological levels
     **********************************************/
    Level o0 = PLMFactory.eINSTANCE.createLevelWithLMLVisualizer();
    ontology.getContent().add(o0);

    Level o1 = PLMFactory.eINSTANCE.createLevelWithLMLVisualizer();
    ontology.getContent().add(o1);

    Level o2 = PLMFactory.eINSTANCE.createLevelWithLMLVisualizer();
    ontology.getContent().add(o2);

    /**********************************************
     * Create breed on the highest ontological level
     **********************************************/
    Clabject breed = PLMFactory.eINSTANCE.createEntityWithLMLVisualizer();
    breed.setName("Breed");
    breed.setPotency(2);
    o0.getContent().add(breed);

    /**********************************************
     * Add an FCINo to breed
     **********************************************/
    Attribute fciNo = PLMFactory.eINSTANCE.createAttributeWithLMLVisualizer();
    fciNo.setName("FCINo");
    fciNo.setDatatype("String");
    fciNo.setDurability(breed.getPotency());
    // We want to have this value only changed one level below
    fciNo.setMutability(1);
    breed.getFeature().add(fciNo);

    /**********************************************
     * Create an instance of collie which is a breed
     **********************************************/
    Clabject collie = PLMFactory.eINSTANCE.createClabjectFromTemplate(breed, o1);
    collie.setName("Collie");

    /**********************************************
     * Create an abstract Dog which is supertype of Collie
     **********************************************/
    Clabject dog = PLMFactory.eINSTANCE.createEntityWithLMLVisualizer();
    dog.setPotency(0);
    dog.setName("Dog");
    o1.getContent().add(dog);

    /**********************************************
     * Create a nickname attribute for dog
     **********************************************/
    Attribute nickname = PLMFactory.eINSTANCE.createAttributeWithLMLVisualizer();
    nickname.setDurability(1);
    nickname.setMutability(1);
    nickname.setName("Nickname");
    dog.getFeature().add(nickname);

    /**********************************************
     * Set the FCINo of Collie
     **********************************************/
    Attribute collieFCINo = collie.getDefinedAttributeByName("FCINo");
    collieFCINo.setValue("134");

    /**********************************************
     * Create a generalization between collie and dog
     **********************************************/
    Inheritance collieIsKindOfDog = PLMFactory.eINSTANCE.createInheritanceWithLMLVisualizer();
    Subtype subtype = PLMFactory.eINSTANCE.createSubtype();
    subtype.setSubtype(collie);
    collieIsKindOfDog.getSubtype().add(subtype);
    Supertype supertype = PLMFactory.eINSTANCE.createSupertype();
    supertype.setSupertype(dog);
    collieIsKindOfDog.getSupertype().add(supertype);
    o1.getContent().add(collieIsKindOfDog);

    /**********************************************
     * Instantiate a Lassie
     **********************************************/
    Clabject lassie = PLMFactory.eINSTANCE.createClabjectFromTemplate(collie, o2);
    lassie.getDefinedAttributeByName("Nickname").setName("Brutus");

    /**********************************************
     * Code for saving the model to a file
     **********************************************/
    /*
     * ResourceSet resourceSet = new ResourceSetImpl(); Resource resource =
     * resourceSet.createResource(URI.createFileURI("c:\\w\\m\\manual.lml"));
     * resource.getContents().add(domain);
     */

    /**********************************************
     * Create a GMF notation diagram package to enable the GMF editor to render the
     * diagram
     **********************************************/
    /*
     * Diagram diagram = ViewService.createDiagram( domain, DomainEditPart.MODEL_ID,
     * PLMDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
     * resource.getContents().add(diagram);
     */

    /*
     * try { resource.save(Collections.EMPTY_MAP); } catch (IOException e) {
     * e.printStackTrace(); }
     */
  }
}
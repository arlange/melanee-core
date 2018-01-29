package org.melanee.core.tests.plm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.ClassificationKind;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.Method;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

public class ClabjectTest {
	
	@Test
	public void testGetLevel(){
		Level l = PLMFactory.eINSTANCE.createLevel();
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		assertTrue("Result of c.getLevel() must be null", c.getLevel() == null);
		l.getContent().add(c);
		assertTrue("Result of c.getLevel() must be l", c.getLevel() == l);
	}
	
	@Test
	public void testGetDeepModel(){
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		assertTrue("", l.getDeepModel()== null);
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		assertTrue("Result of c.getDeepModel() must be null", c.getDeepModel() == null);
		dm.getContent().add(l);
		l.getContent().add(c);
		assertTrue("Result of c.getDeepModel() must be dm", c.getDeepModel() == dm);
	}

	@Test
	public void testGetSupertypes(){
		
		//also tested here: Clabject.getDirectSupertypes()
		
		//inheritance chain of the example:
		// supertype	supertype2
		//		|			|
		//			  c
		//			  |
		//			 c2
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("myname");
		Clabject supertype = PLMFactory.eINSTANCE.createEntity();
		supertype.setName("supertype");
		Clabject supertype2 = PLMFactory.eINSTANCE.createEntity();
		Clabject c2 = PLMFactory.eINSTANCE.createEntity();
		
		l.getContent().add(c);
		l.getContent().add(supertype);
		l.getContent().add(supertype2);
		l.getContent().add(c2);
		
		assertTrue("Result of c.getSupertypes() must be empty", c.getSupertypes().isEmpty());
		
		//Inheritance between supertype and c
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect = PLMFactory.eINSTANCE.createInheritance();
		connect.getSubtype().add(sub);
		connect.getSupertype().add(sup);
		sub.setSubtype(c);
		sup.setSupertype(supertype);		
		l.getContent().add(connect);
		
		assertTrue("Result of c.getSupertypes() must be supertype", c.getSupertypes().contains(supertype));
		
		//Inheritance between supertype2 and c
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect2 = PLMFactory.eINSTANCE.createInheritance();
		connect2.getSubtype().add(sub2);
		connect2.getSupertype().add(sup2);
		sub2.setSubtype(c);
		sup2.setSupertype(supertype2);
		l.getContent().add(connect2);
		
		assertTrue("Result of c.getSupertypes() must be supertype and supertype2", (c.getSupertypes().contains(supertype) 
				&& c.getSupertypes().contains(supertype2)));
		
		////Inheritance between c2 and c
		Subtype sub3 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup3 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect3 = PLMFactory.eINSTANCE.createInheritance();
		connect3.getSubtype().add(sub3);
		connect3.getSupertype().add(sup3);
		sub3.setSubtype(c2);
		sup3.setSupertype(c);
		l.getContent().add(connect3);
		
		assertTrue("Result of c2.getDirectSupertypes() must be c", (c2.getDirectSupertypes().contains(c)));
		assertTrue("Result of c2.getSupertypes() must be c, supertype and supertype2", (c2.getSupertypes().contains(supertype) 
				&& c2.getSupertypes().contains(supertype2) && c2.getSupertypes().contains(c)));
	}
	
	@Test
	public void testGetSubtypes(){
		//inheritance chain of the example:
		// supertype
		//		|
		//		c
		//		|
		//		c2
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("myname");
		Clabject supertype = PLMFactory.eINSTANCE.createEntity();
		supertype.setName("supertype");
		Clabject c2 = PLMFactory.eINSTANCE.createEntity();

		l.getContent().add(c);
		l.getContent().add(supertype);
		l.getContent().add(c2);
		
		assertTrue("Result of c.getSubtypes() must be empty", c.getSubtypes().isEmpty());

		//Inheritance between c and supertype
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect = PLMFactory.eINSTANCE.createInheritance();
		connect.getSubtype().add(sub);
		connect.getSupertype().add(sup);
		sub.setSubtype(c);
		sup.setSupertype(supertype);		
		l.getContent().add(connect);
		
		assertTrue("Result of supertype.getSubtypes() must be c", supertype.getSubtypes().contains(c));
		
		//Inheritance between c and c2
		Subtype sub3 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup3 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect3 = PLMFactory.eINSTANCE.createInheritance();
		connect3.getSubtype().add(sub3);
		connect3.getSupertype().add(sup3);
		sub3.setSubtype(c2);
		sup3.setSupertype(c);
		l.getContent().add(connect3);
		
		assertTrue("Result of supertype.getSubtypes() must be c and c2", (supertype.getSubtypes().contains(c) 
				&& supertype.getSubtypes().contains(c2)));
	}
	
	@Test
	public void testGetHollowTypes(){
		//situation of the example:
		// |person1|				|person2|
		// |-------|				|-------|
		// |name1  |				|id1    |
		//      |						|
		//      -------------------------
		//					|
		//   ----------------------------
		//	 |				|			|
		// |employee1| |employee2| |employee3|
		// |---------| |---------| |---------|
		// |		 | |name1    | |id1		 |
		
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		//person1
		Clabject person1 = PLMFactory.eINSTANCE.createEntity();
		person1.setName("person1");
		Attribute name1 = PLMFactory.eINSTANCE.createAttribute();
		name1.setName("name");
		person1.getFeature().add(name1);
		
		//person2
		Clabject person2 = PLMFactory.eINSTANCE.createEntity();
		person2.setName("person2");
		Attribute id1 = PLMFactory.eINSTANCE.createAttribute();
		id1.setName("id");
		person2.getFeature().add(id1);
		
		//employee1
		Clabject employee1 = PLMFactory.eINSTANCE.createEntity();
		employee1.setName("employee1");
		
		//employee2
		Clabject employee2 = PLMFactory.eINSTANCE.createEntity();
		employee2.setName("employee2");
		Attribute name2 = PLMFactory.eINSTANCE.createAttribute();
		name2.setName("name");
		employee2.getFeature().add(name2);
		
		//employee3
		Clabject employee3 = PLMFactory.eINSTANCE.createEntity();
		employee3.setName("employee3");
		Attribute id2 = PLMFactory.eINSTANCE.createAttribute();
		id2.setName("id");
		employee3.getFeature().add(id2);
		
		//building connections
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		sup.setSupertype(person1);
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		sup2.setSupertype(person2);
		
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		sub.setSubtype(employee1);
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		sub2.setSubtype(employee2);
		Subtype sub3 = PLMFactory.eINSTANCE.createSubtype();
		sub3.setSubtype(employee3);
		
		Inheritance connect = PLMFactory.eINSTANCE.createInheritance();
		connect.getSupertype().add(sup);
		connect.getSupertype().add(sup2);
		connect.getSubtype().add(sub);
		connect.getSubtype().add(sub2);
		connect.getSubtype().add(sub3);

		l.getContent().add(connect);
		l.getContent().add(person1);
		l.getContent().add(person2);
		l.getContent().add(employee1);
		l.getContent().add(employee2);
		l.getContent().add(employee3);
		
		//test
		assertTrue("Result of person1.getHollowSubtypes() must be employee1+2", (person1.getHollowSubtypes().contains(employee1) 
				&& person1.getHollowSubtypes().contains(employee2)));
		assertTrue("Result of employee3.getHollowSupertypes() must be person2", (employee3.getHollowSupertypes().contains(person2))); 
		assertTrue("Result of employee1.getHollowSupertypes() must be person1+2", (employee1.getHollowSupertypes().contains(person2) 
				&& employee1.getHollowSupertypes().contains(person1)));
	}

	@Test
	public void testGetClassifications(){
		
		//situation of the example after drawing the classification
		// Level l
		// --------
		// |   c   |
		// --------
		//
		// Level l2
		// --------
		// | d:c   |
		// --------
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		
		l.getContent().add(c);
		l2.getContent().add(d);
		
		assertTrue("The Result of c.getClassificationsAsInstance() should be empty", c.getClassificationsAsInstance().isEmpty());
		assertTrue("The Result of c.getClassificationsAsType() should be empty", c.getClassificationsAsType().isEmpty());
				
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		assertTrue("The Result of c.getClassificationsAsType() should be classi", c.getClassificationsAsType().contains(classi));
		assertTrue("The Result of c.getClassificationsAsInstance() should be empty", c.getClassificationsAsInstance().isEmpty());
		assertTrue("The Result of d.getClassificationsAsInstance() should be classi", d.getClassificationsAsInstance().contains(classi));
		assertTrue("The Result of d.getClassificationsAsType() should be empty", d.getClassificationsAsType().isEmpty());
		
	}

	@Test
	public void testGetInstances(){
		
		//To do: OCL von getDirectInstances() in getInstances() schreiben und getDirectInstances() l�schen
		//nur ein Level tief
		
		// situation of the example - instance-of-relationships:
		// level l		c
		//					-> classi
		// level l2		d
		//					-> classi2
		// level l3		e
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		
		l.getContent().add(c);
		l2.getContent().add(d);
		l3.getContent().add(e);
		
		assertTrue("The Result of c.getInstances() should be empty", c.getInstances().isEmpty());
		
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setInstance(e);
		classi2.setType(d);
		l3.getContent().add(classi2);
		
//		try {
//			OCLHelper.execute(c, "let allTypes:OrderedSet(Clabject) = " +
//	" self.getSubtypes()->including(self)->asOrderedSet()" +
//" in" +
//	" allTypes.getClassificationsAsType().instance");
//			
//		} catch (ParserException e1) {
//			e1.printStackTrace();
//		}
		
		assertTrue("The Result of c.getInstances() should be d", c.getInstances().contains(d));

	}

	@Test
	public void testGetTypes(){
		
		//To do: OCL von getDirectTypes() in getTypes() schreiben und getDirectTypes() l�schen
		
		// situation of the example - instance-of-relationships:
		// level l		c
		//					-> classi
		// level l2		d
		//					-> classi2
		// level l3		e
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		
		l.getContent().add(c);
		l2.getContent().add(d);
		l3.getContent().add(e);
		
		assertTrue("The Result of e.getTypes() should be empty", e.getTypes().isEmpty());
		
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setInstance(e);
		classi2.setType(d);
		l3.getContent().add(classi2);
		
		assertTrue("The Result of e.getTypes() should be d", e.getTypes().contains(d));
		
	}

	@Test
	public void testGetLevelTypes(){
		//OCL expression:
		//self.getClassificationsAsInstance().type->union(self.getClassificationsAsInstance().type.getSupertypes())->asOrderedSet()

		//Name f�r diese Funktion angepasst? Sie gibt alle Clabjects zur�ck, die �ber eine Classification mit self verbunden ist
		//auch solche, die selbst keine Classification zu self haben aber deren Subtypes --> mit Level hat das nichts zu tun meiner Meinung nach
		
		//situation of the example:
		//level l:
		//		c
		//		| inheritance
		//		d
		//level l2: 
		//		e classification to d
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		
		assertTrue("The Result of e.getLevelTypes() should be empty", e.getLevelTypes().isEmpty());
		
		//Inheritance between c and d
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		inheri.getSupertype().add(sup);
		inheri.getSubtype().add(sub);
		sup.setSupertype(c);
		sub.setSubtype(d);
		l.getContent().add(inheri);
		l.getContent().add(c);
		l.getContent().add(d);
		
		assertTrue("The Result of e.getLevelTypes() should be empty", e.getLevelTypes().isEmpty());
		
		//Classification between d and e
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setType(d);
		classi.setInstance(e);
		l2.getContent().add(e);
		l2.getContent().add(classi);
		
		assertTrue("The Result of e.getLevelTypes() should be d and c", e.getLevelTypes().contains(d) 
				&& e.getLevelTypes().contains(c));
	}

	@Test
	public void testGetDefinedClassificationTreeAsInstance(){
		//OCL expression:
		//let directResult:OrderedSet(Clabject) = self.getLevelTypes()->asOrderedSet()
		//in directResult->union(directResult.getTypes()->asOrderedSet())->asOrderedSet()
		
		//situation of the example:
		//level l:
		//		c
		//level l2	d is connected with classification to c
		//		d
		//		| inheritance
		//		e
		//level l3: f is connected with classification to e 
		//		f 
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		c.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		c.setName("e");
		Clabject f = PLMFactory.eINSTANCE.createEntity();
		c.setName("f");
		
		assertTrue("The Result of f.getEigenClassificationTreeAsInstance() should be empty", 
				f.getDefinedClassificationTreeAsInstance().isEmpty());
		
		//classification between c and d
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setType(c);
		classi.setInstance(d);
		l.getContent().add(c);
		l2.getContent().add(d);
		l2.getContent().add(classi);
		
		//inheritance between d and e
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		inheri.getSupertype().add(sup);
		inheri.getSubtype().add(sub);
		sup.setSupertype(d);
		sub.setSubtype(e);
		l2.getContent().add(inheri);
		l2.getContent().add(e);
		
		//classification between e and f
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setType(e);
		classi2.setInstance(f);
		l3.getContent().add(f);
		l3.getContent().add(classi2);
		
		assertTrue("The Result of f.getEigenClassificationTreeAsInstance() should be e, d and c", 
				f.getDefinedClassificationTreeAsInstance().contains(e) && 
				f.getDefinedClassificationTreeAsInstance().contains(d) && 
				f.getDefinedClassificationTreeAsInstance().contains(c));
	}

	@Test
	public void testGetClassificationTreeAsInstance(){
		// OCL expression:
		// let directResult:OrderedSet(Clabject) = self.getTypes()->asOrderedSet()
		// in directResult->union(directResult.getTypes()->asOrderedSet())->asOrderedSet()
		
		// im Gegensatz zu getTypes(), wo nur eine Ebene obendr�ber genommen wird, werden hier alle Ebenen obendr�ber genommen
		
		// situation of the example - instance-of-relationships:
		// level l		c
		//					-> classi
		// level l2		d
		//					-> classi2
		// level l3		e
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		
		l.getContent().add(c);
		l2.getContent().add(d);
		l3.getContent().add(e);
		
		assertTrue("The Result of e.getClassificationTreeAsInstance() should be empty", 
				e.getClassificationTreeAsInstance().isEmpty());
		
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setInstance(e);
		classi2.setType(d);
		l3.getContent().add(classi2);
		
		assertTrue("The Result of e.getClassificationTreeAsInstance() should be d and c",
				e.getClassificationTreeAsInstance().contains(d) && e.getClassificationTreeAsInstance().contains(c));
		
	}

	@Test
	public void testGetDefinedInstances(){
		//OCL expression:
		//self.getClassificationsAsType().instance->union(self.getClassificationsAsType().instance.getSubtypes())->asOrderedSet()
		
		//situation of the example:
		//level l:
		//		c
		//level l2: d and e are connected with classification to c
		//	d	   e
		//  |      | inheritances
		//  f	   g
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		c.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		c.setName("e");
		Clabject f = PLMFactory.eINSTANCE.createEntity();
		c.setName("f");
		Clabject g = PLMFactory.eINSTANCE.createEntity();
		c.setName("g");
		
		assertTrue("The Result of c.getEigenInstances() should be empty", c.getDefinedInstances().isEmpty());
		
		//classification between c and d
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setType(c);
		classi.setInstance(d);
		l.getContent().add(c);
		l2.getContent().add(d);
		l2.getContent().add(classi);
		
		//classification between c and e
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setType(c);
		classi2.setInstance(e);
		l2.getContent().add(e);
		l2.getContent().add(classi2);
		
		//inheritance between d and f
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		inheri.getSupertype().add(sup);
		inheri.getSubtype().add(sub);
		sup.setSupertype(d);
		sub.setSubtype(f);
		l2.getContent().add(inheri);
		l2.getContent().add(f);
		
		//inheritance between e and g
		Inheritance inheri2 = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		inheri2.getSupertype().add(sup2);
		inheri2.getSubtype().add(sub2);
		sup2.setSupertype(e);
		sub2.setSubtype(g);
		l2.getContent().add(inheri2);
		l2.getContent().add(g);
		
		assertTrue("The Result of c.getEigenInstances() should be d,e,f and g", 
				c.getDefinedInstances().contains(d) && c.getDefinedInstances().contains(e) && 
				c.getDefinedInstances().contains(f) && c.getDefinedInstances().contains(g));
		
	}

	@Test
	public void testGetEigenClassificationTreeAsType(){
		//OCL expression:
		//let directResult:OrderedSet(Clabject) = self.getEigenInstances()->asOrderedSet()
		//in directResult->union(directResult.getInstances()->asOrderedSet())->asOrderedSet()
		
		//situation of the example:
		//level l:
		//		c
		//level l2: d and e are connected with classification to c
		//	d	   e
		//  |      | inheritances
		//  f	   g
		//level l3: h and i are connected with classifications to f and g
		//  h	   i
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		c.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		c.setName("e");
		Clabject f = PLMFactory.eINSTANCE.createEntity();
		c.setName("f");
		Clabject g = PLMFactory.eINSTANCE.createEntity();
		c.setName("g");
		Clabject h = PLMFactory.eINSTANCE.createEntity();
		c.setName("h");
		Clabject i = PLMFactory.eINSTANCE.createEntity();
		c.setName("i");
		
		assertTrue("The Result of c.getEigenClassificationTreeAsType() should be empty", 
				c.getDefinedClassificationTreeAsType().isEmpty());
		
		//classification between c and d
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setType(c);
		classi.setInstance(d);
		l.getContent().add(c);
		l2.getContent().add(d);
		l2.getContent().add(classi);
		
		//classification between c and e
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setType(c);
		classi2.setInstance(e);
		l2.getContent().add(e);
		l2.getContent().add(classi2);
		
		//inheritance between d and f
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		inheri.getSupertype().add(sup);
		inheri.getSubtype().add(sub);
		sup.setSupertype(d);
		sub.setSubtype(f);
		l2.getContent().add(inheri);
		l2.getContent().add(f);
		
		//inheritance between e and g
		Inheritance inheri2 = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		inheri2.getSupertype().add(sup2);
		inheri2.getSubtype().add(sub2);
		sup2.setSupertype(e);
		sub2.setSubtype(g);
		l2.getContent().add(inheri2);
		l2.getContent().add(g);
		
		//classification between f and h
		Classification classi3 = PLMFactory.eINSTANCE.createClassification();
		classi3.setType(f);
		classi3.setInstance(h);
		l3.getContent().add(h);
		l3.getContent().add(classi3);
		
		//classification between g and i
		Classification classi4 = PLMFactory.eINSTANCE.createClassification();
		classi4.setType(g);
		classi4.setInstance(i);
		l3.getContent().add(i);
		l3.getContent().add(classi4);
		
		assertTrue("The Result of c.getEigenClassificationTreeAsType() should be d,e,f,g,h and i", 
				c.getDefinedClassificationTreeAsType().contains(d) && c.getDefinedClassificationTreeAsType().contains(e) 
				&& c.getDefinedClassificationTreeAsType().contains(f) && c.getDefinedClassificationTreeAsType().contains(g) 
				&& c.getDefinedClassificationTreeAsType().contains(h) && c.getDefinedClassificationTreeAsType().contains(i));
	}
	
	@Test
	public void testGetClassificationTreeAsType(){
		//OCL expression:
		//let directResult:OrderedSet(Clabject) = self.getInstances()->asOrderedSet()
		//in directResult->union(directResult.getInstances()->asOrderedSet())->asOrderedSet()
		
		//to do: dem namen zu folge hatte ich erwartet, dass ich alle nachfolgenden clabjects bekomme, 
		//mit dieser Funktion werden aber nur zwei levels unter self beachtet weil getInstances() immer nur ein Level tiefer geht!!!
		
		// situation of the example - instance-of-relationships:
		// level l		c
		//					-> classi
		// level l2		d
		//					-> classi2
		// level l3		e
		//					-> classi3
		// level l4		f
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		Level l4 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l4);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		Clabject f = PLMFactory.eINSTANCE.createEntity();
		e.setName("f");
		
		l.getContent().add(c);
		l2.getContent().add(d);
		l3.getContent().add(e);
		l4.getContent().add(f);
		
		assertTrue("The Result of c.getClassificationTreeAsType() should be empty", 
				c.getClassificationTreeAsType().isEmpty());
		
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setInstance(e);
		classi2.setType(d);
		l3.getContent().add(classi2);
		
		Classification classi3 = PLMFactory.eINSTANCE.createClassification();
		classi3.setInstance(f);
		classi3.setType(e);
		l4.getContent().add(classi3);
		
		assertTrue("The Result of c.getClassificationTreeAsType() should be d and e", 
				c.getClassificationTreeAsType().contains(d) && 
				c.getClassificationTreeAsType().contains(e));
		// & c.getClassificationTreeAsType().contains(f));
		
	}

	//toDo: getClassificationTreeAsType(EInt) and getClassificationTreeAsType(EInt, EInt)
	
	@Test
	public void testGetAllFeatures(){
		//OCL expression:
		//let features:OrderedSet(Feature) =  self.getSupertypes()->including(self).feature->asOrderedSet()
		//in features->select(f | features->excluding(f)->forAll(f2 | f.name = f2.name implies not f.getClabject().getSubtypes()->includes(f2.getClabject())))->asOrderedSet()
	
		//also tested here: Clabject.getAllAttributes(), Clabject.getAllMethods(), Clabject.getEigenAttributes() and
		//Clabject.getEigenMethods(), Clabject.getEigenAttributeByName(EString)
		
		//situation of the example:
		// |person1  |			
		// |---------|				
		// |name     |
		// |---------|
		// |getName()|
		//		|
		// |person2  |
		// |---------|
		// |id       |
		// |---------|
		// |getID()  |
		//		|
		// |person3  |
		// |---------|
		// |id       |
		// |---------|
		// |getID()  |
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		//person1
		Clabject person1 = PLMFactory.eINSTANCE.createEntity();
		person1.setName("person1");
		Attribute name = PLMFactory.eINSTANCE.createAttribute();
		name.setName("name");
		person1.getFeature().add(name);
		Method getName = PLMFactory.eINSTANCE.createMethod();
		getName.setName("getName");
		person1.getFeature().add(getName);
		l.getContent().add(person1);
		
		//person2
		Clabject person2 = PLMFactory.eINSTANCE.createEntity();
		person2.setName("person2");
		Attribute id = PLMFactory.eINSTANCE.createAttribute();
		id.setName("id");
		person2.getFeature().add(id);
		Method getID = PLMFactory.eINSTANCE.createMethod();
		getID.setName("getID");
		person2.getFeature().add(getID);
		l.getContent().add(person2);
		
		//person3
		Clabject person3 = PLMFactory.eINSTANCE.createEntity();
		person3.setName("person3");
		Attribute id2 = PLMFactory.eINSTANCE.createAttribute();
		id2.setName("id");
		person3.getFeature().add(id2);
		Method getID2 = PLMFactory.eINSTANCE.createMethod();
		getID2.setName("getID");
		person3.getFeature().add(getID2);
		l.getContent().add(person3);
		
		//inheritance between person1 and person2
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		inheri.getSupertype().add(sup);
		inheri.getSubtype().add(sub);
		sup.setSupertype(person1);
		sub.setSubtype(person2);
		l.getContent().add(inheri);
		
		//inheritance between person2 and person3
		Inheritance inheri2 = PLMFactory.eINSTANCE.createInheritance();
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		inheri2.getSupertype().add(sup2);
		inheri2.getSubtype().add(sub2);
		sup2.setSupertype(person2);
		sub2.setSubtype(person3);
		l.getContent().add(inheri2);
		
		assertTrue("The Result of person2.getAllFeatures() should be attribute name and id / method getName() and getID()", 
				person2.getAllFeatures().contains(id) && person2.getAllFeatures().contains(getID) && 
				person2.getAllFeatures().contains(name) && person2.getAllFeatures().contains(getName)); 
		
		assertTrue("The Result of person2.getAllAttributes() should be attribute name and id", 
				person2.getAllAttributes().contains(id) && person2.getAllAttributes().contains(name));
		
		assertTrue("The Result of person2.getAllMethods() should be method getName and getID",
				person2.getAllMethods().contains(getID) && person2.getAllMethods().contains(getName));
		
		assertTrue("The Result of person2.getDefinedAttributes() should be attribute id", 
				person2.getDefinedAttributes().contains(id) && !person2.getDefinedAttributes().contains(name));
		
		assertTrue("The Result of person2.getDefinedAttributeByName(id) should be attribute id", 
				person2.getDefinedAttributeByName("id") == id);
		
		assertTrue("The Result of person2.getEigenMethods() should be method getID", 
				person2.getDefinedMethods().contains(getID) && !person2.getDefinedMethods().contains(getName));
		
		//with person3 having also id as attribute and getID as method
		assertTrue("The Result of person3.getAllAttributes() should be attribute name and id2", 
				person3.getAllAttributes().contains(name) && person3.getAllAttributes().contains(id2) && !person3.getAllAttributes().contains(id));
		
		assertTrue("The Result of person3.getAllMethods() should be method getName and getID2",
				person3.getAllMethods().contains(getID2) && person3.getAllMethods().contains(getName) && !person3.getAllMethods().contains(getID));
 
	}

	@Test
	public void testIsInstanceOf(){
		//OCL expression: isInstanceOf(Clabject)       type.getInstances()->includes(self)
		//OCL expression: isTypeOf(Clabject)           instance.getTypes()->includes(self)
		
		// situation of the example - instance-of-relationships:
		// level l		c
		//					-> classi
		// level l2		d
		//					-> classi2
		// level l3		e
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		Level l3 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l3);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		
		l.getContent().add(c);
		l2.getContent().add(d);
		l3.getContent().add(e);
		
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setInstance(e);
		classi2.setType(d);
		l3.getContent().add(classi2);

		assertTrue("The Result of d.isInstanceOf(c) should be true", d.isInstanceOf(c));
		assertTrue("The Result of e.isInstanceOf(d) should be true", e.isInstanceOf(d));
		assertTrue("The Result of e.isInstanceOf(c) should be false", !e.isInstanceOf(c));
		assertTrue("The Result of d.isTypeOf(c) should be true", d.isTypeOf(c));
		assertTrue("The Result of e.isTypeOf(d) should be true", e.isTypeOf(d));
		assertTrue("The Result of e.isTypeOf(c) should be false", !e.isTypeOf(c));
	}

	// to do: Clabject.isContainerOf(Clabject) and Clabject.getContainer() and Clabject.getOwner()
	
	@Test
	public void testGetEigenConnections(){
		//OCL expression:
		//ConnectionEnd.allInstances()->select(r | r.destination = self).connection->asOrderedSet()
		
		//situation of the example:
		//Level l:
		// -------                   --------                    --------
		// |  c  | -----connect----- |  d   | -----connect2----- |  e   |
		// -------                   --------                    --------
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject e = PLMFactory.eINSTANCE.createEntity();
		e.setName("e");
		
		l.getContent().add(c);
		l.getContent().add(d);
		l.getContent().add(e);
		
		//connection between c and d
		Connection connect = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti2 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti.setConnection(connect);
		parti.setDestination(c);
		parti2.setDestination(d);
		parti2.setConnection(connect);
		l.getContent().add(connect);
		
		//connection between d and e
		Connection connect2 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti3 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti4 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti3.setConnection(connect2);
		parti3.setDestination(d);
		parti4.setDestination(e);
		parti4.setConnection(connect2);
		l.getContent().add(connect2);

		assertTrue("The Result of d.getEigenConnections() should be connect and connect2", 
				d.getDefinedConnections().contains(connect) && d.getDefinedConnections().contains(connect2));
		
	}

	@Test
	public void testGetConnections(){
		//OCL expression for getConnections():
		//self.getInheritedConnections()->union(self.getEigenConnections())->asOrderedSet()
		//OCL expression for getInheritedConnections():
		//self.getSupertypes().getEigenConnections()->asOrderedSet()
		
		//situation of the example:
		//Level l:
		// -------                   --------
		// |  c  | -----connect----- |  d   |
		// -------                   --------
		//    |							  |
		// --------                    ---------
		// |  c2  | -----connect2----- |  d2   |
		// --------                    ---------
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject c2 = PLMFactory.eINSTANCE.createEntity();
		c2.setName("c2");
		Clabject d2 = PLMFactory.eINSTANCE.createEntity();
		d2.setName("d2");
		
		l.getContent().add(c);
		l.getContent().add(d);
		l.getContent().add(c2);
		l.getContent().add(d2);
		
		//inheritance between c and c2
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		inheri.getSubtype().add(sub);
		inheri.getSupertype().add(sup);
		sub.setSubtype(c2);
		sup.setSupertype(c);		
		l.getContent().add(inheri);
		
		//inheritance between d and d2
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance inheri2 = PLMFactory.eINSTANCE.createInheritance();
		inheri2.getSubtype().add(sub2);
		inheri2.getSupertype().add(sup2);
		sub2.setSubtype(d2);
		sup2.setSupertype(d);		
		l.getContent().add(inheri2);
		
		//connection between c and d
		Connection connect = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti2 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti.setConnection(connect);
		parti.setDestination(c);
		parti2.setDestination(d);
		parti2.setConnection(connect);
		l.getContent().add(connect);
		
		//connection between c2 and d2
		Connection connect2 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti3 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti4 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti3.setConnection(connect2);
		parti3.setDestination(c2);
		parti4.setDestination(d2);
		parti4.setConnection(connect2);
		l.getContent().add(connect2);
		
		assertTrue("The Result of d.getConnections() should be connect and connect2", 
				d2.getConnections().contains(connect) && d2.getConnections().contains(connect2));
	}

	@Test
	public void testGetIsonymHyponymBlueprintOffspring(){
		//situation of the example:
		// Level l
		// --------
		// |   c   |
		// --------
		//
		// Level l2
		// --------
		// | d:c   |
		// --------
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l2);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		
		l.getContent().add(c);
		l2.getContent().add(d);
		
		//classification between c and d
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(d);
		classi.setType(c);
		l2.getContent().add(classi);
		
		//ClassificationKind isonym
		classi.setKind(ClassificationKind.ISONYM);
		//OCL expression for getIsonyms(): 
		//self.getClassificationsAsType()->select(c | c.kind = ClassificationKind::isonym).instance->asOrderedSet()
		assertTrue("The Result of c.getIsonyms() should be d", c.getIsonyms().contains(d));
		//OCL expression for getLevelCompleteTypes():
		//self.getClassificationsAsInstance()->select((kind= ClassificationKind::isonym) or (kind= ClassificationKind::instantiation)).type->asSet()
		assertTrue("The Result of d.getLevelCompleteTypes() should be c", d.getLevelCompleteTypes().contains(c));
		
		
		//ClassificationKind hyponym
		classi.setKind(ClassificationKind.HYPONYM);
		//OCL expression for getHyponyms():
		//self.getClassificationsAsType()->select(c | c.kind = ClassificationKind::hyponym).instance->asOrderedSet()
		assertTrue("The Result of c.getHyponyms() should be d", c.getHyponyms().contains(d));
		//OCL expression for getLevelIncompleteTypes()
		//self.getClassificationsAsInstance()->select(kind= ClassificationKind::hyponym).type->asSet()
		assertTrue("The Result of d.getLevelIncompleteTypes() should be c", d.getLevelIncompleteTypes().contains(c));
		
		
		//ClassificationKind  instantiation
		classi.setKind(ClassificationKind.INSTANTIATION);
		//OCL expression for getOffspring(): 
		//self.getClassificationsAsType()->select(c | c.kind = ClassificationKind::instantiation).instance->asOrderedSet()
		assertTrue("The Result of c.getOffspring() should be d", c.getOffspring().contains(d));
		//OCl expression for getBlueprint():
		//let blueprints:OrderedSet(Clabject) = self.getClassificationsAsInstance()->select(c | c.kind= ClassificationKind::instantiation).type->asOrderedSet()
		//in if blueprints->size() > 0 then blueprints->first() else null endif
		assertTrue("The Result of d.getBlueprint() should be c", d.getBlueprint().equals(c));
		//OCL expression for getLevelCompleteTypes():
		//self.getClassificationsAsInstance()->select((kind= ClassificationKind::isonym) or (kind= ClassificationKind::instantiation)).type->asSet()
		assertTrue("The Result of d.getLevelCompleteTypes() should be c", d.getLevelCompleteTypes().contains(c));
			
	}
	
	@Test
	public void testGetDomainForConnection(){
		//OCL expression: connection.getDomain(self)
		
		//situation of the example:
		//Level l:
		// -------                   -------- 
		// |  c  | -----connect----- |  d   | 
		// -------                   -------- 
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		
		l.getContent().add(c);
		l.getContent().add(d);
		
		//connection between c and d
		Connection connect = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti2 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti.setConnection(connect);
		parti.setDestination(c);
		parti2.setDestination(d);
		parti2.setConnection(connect);
		l.getContent().add(connect);
		
		assertTrue("The Result of c.getDomainForConnection(connect) should be d", 
				c.getDomainForConnection(connect).contains(d));
	}

	//toDo: getPossibleDomainSpecificVisualizers()
	
	@Test
	public void testGetInheritancesAsSubtype(){
		//OCL expression for getInheritancesAsSubtype():
		//Inheritance.allInstances()->select(g|g.subtype.subtype->includes(self))
		//OCL expression for getInheritancesAsSupertype():
		//Inheritance.allInstances()->select(g|g.supertype.supertype->includes(self))
		
		//inheritance chain of the example:
		// supertype	supertype2
		//		|			|
		//		-------------
		//  		  |
		//			  c
		//  		  |
		//		-------------
		//	    |           |
		//	subtype		  subtype2
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject supertype = PLMFactory.eINSTANCE.createEntity();
		supertype.setName("supertype");
		Clabject supertype2 = PLMFactory.eINSTANCE.createEntity();
		supertype2.setName("supertype2");
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("myname");
		Clabject subtype = PLMFactory.eINSTANCE.createEntity();
		subtype.setName("subtype");
		Clabject subtype2 = PLMFactory.eINSTANCE.createEntity();
		subtype2.setName("subtype2");
		
		l.getContent().add(c);
		l.getContent().add(supertype);
		l.getContent().add(supertype2);
		l.getContent().add(subtype);
		l.getContent().add(subtype2);		
		
		//inheritance between supertype and c
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect = PLMFactory.eINSTANCE.createInheritance();
		connect.setName("connect");
		connect.getSubtype().add(sub);
		connect.getSupertype().add(sup);
		sup.setSupertype(supertype);
		sub.setSubtype(c);
		l.getContent().add(connect);
		
		//inheritance between supertype2 and c
		Subtype sub2 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup2 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect2 = PLMFactory.eINSTANCE.createInheritance();
		connect2.setName("connect2");
		connect2.getSubtype().add(sub2);
		connect2.getSupertype().add(sup2);
		sup2.setSupertype(supertype2);
		sub2.setSubtype(c);
		l.getContent().add(connect2);
		
		//inheritance between c and subtype
		Subtype sub3 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup3 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect3 = PLMFactory.eINSTANCE.createInheritance();
		connect3.setName("connect3");
		connect3.getSubtype().add(sub3);
		connect3.getSupertype().add(sup3);
		sup3.setSupertype(c);
		sub3.setSubtype(subtype);
		l.getContent().add(connect3);
		
		//inheritance between c and subtype2
		Subtype sub4 = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup4 = PLMFactory.eINSTANCE.createSupertype();
		Inheritance connect4 = PLMFactory.eINSTANCE.createInheritance();
		connect4.setName("connect4");
		connect4.getSubtype().add(sub4);
		connect4.getSupertype().add(sup4);
		sup4.setSupertype(c);
		sub4.setSubtype(subtype2);
		l.getContent().add(connect4);
		
//		try {OCLHelper.execute(c, "Inheritance.allInstances()->select(g|g.subtype->includes(self))");
//			} catch (ParserException e1) {
//				e1.printStackTrace();
//					}
		
		assertTrue("Result of c.getInheritancesAsSubtype() must be connect and connect2", 
				c.getInheritancesAsSubtype().contains(connect) && c.getInheritancesAsSubtype().contains(connect2));
		assertTrue("Result of c.getInheritancesAsSupertype() must be connect3 and connect4", 
				c.getInheritancesAsSupertype().contains(connect3) && c.getInheritancesAsSupertype().contains(connect4));
	}
	
	@Test
	public void testGetNavigations(){
		//getEigenNavigations(), getInheritedNavigations() and getAllNavigations() - they depend on each other
		
		//situation of the example:
		//Level l:
		// --------                    --------
		// |  c	  | -----connect0----- |  d0  |
		// |	  |                    --------
		// |	  |                    --------
		// |      | -----connect-----> |  d   |
		// --------                    --------
		//    |inheri							  
		// --------                     ---------
		// |  c2  | -----connect2-----> |  d2   |
		// |      |						---------
		// |	  |                     ---------
		// |      | -----connect3------ |  d3   |
		// -------- 					---------                    

		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject c2 = PLMFactory.eINSTANCE.createEntity();
		c2.setName("c2");
		Clabject d2 = PLMFactory.eINSTANCE.createEntity();
		d2.setName("d2");
		Clabject d0 = PLMFactory.eINSTANCE.createEntity();
		d0.setName("d0");
		Clabject d3 = PLMFactory.eINSTANCE.createEntity();
		d3.setName("d3");
		
		l.getContent().add(c);
		l.getContent().add(d);
		l.getContent().add(c2);
		l.getContent().add(d2);
		l.getContent().add(d0);
		l.getContent().add(d3);
		
		//inheritance between c and c2
		Subtype sub = PLMFactory.eINSTANCE.createSubtype();
		Supertype sup = PLMFactory.eINSTANCE.createSupertype();
		Inheritance inheri = PLMFactory.eINSTANCE.createInheritance();
		inheri.getSubtype().add(sub);
		inheri.getSupertype().add(sup);
		sub.setSubtype(c2);
		sup.setSupertype(c);		
		l.getContent().add(inheri);
		
		//connection between c and d
		Connection connect = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti2 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti.setConnection(connect);
		parti.setDestination(c);
		parti2.setDestination(d);
		parti2.setConnection(connect);
		parti2.setNavigable(true);
		l.getContent().add(connect);
		
		//connection between c2 and d2
		Connection connect2 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti3 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti4 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti3.setConnection(connect2);
		parti3.setDestination(c2);
		parti4.setDestination(d2);
		parti4.setConnection(connect2);
		parti4.setNavigable(true);
		l.getContent().add(connect2);
		
		
		//connection between c and d0 - not navigable and therefore not element of the result
		Connection connect0 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti0 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti01 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti0.setConnection(connect0);
		parti0.setDestination(c);
		parti01.setDestination(d0);
		parti01.setConnection(connect0);
		parti01.setNavigable(false);
		l.getContent().add(connect0);
		
		//connection between c2 and d3 - not navigable and therefore not element of the result
		Connection connect3 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti03 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti04 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti03.setConnection(connect3);
		parti03.setDestination(c2);
		parti04.setDestination(d3);
		parti04.setConnection(connect3);
		parti04.setNavigable(false);
		l.getContent().add(connect3);
		
		assertTrue("The Result of c2.getEigenNavigations() should be parti4", 
				c2.getDefinedNavigations().contains(parti4) && !c2.getDefinedNavigations().contains(parti04) );
		
		assertTrue("The Result of c2.getInheritedNavigations() should be parti2", 
				c2.getInheritedNavigations().contains(parti2) && !c2.getInheritedNavigations().contains(parti01));
		
		assertTrue("The Result of c2.getAllNavigations() should be parti2", 
				c2.getAllNavigations().contains(parti2) && c2.getAllNavigations().contains(parti4)
				&& !c2.getDefinedNavigations().contains(parti04) && !c2.getInheritedNavigations().contains(parti01));
		
	}
	
	
	//to do: getDomainMonikers(), getDomainForMoniker(EString) and getAllNavigationsForMoniker(EString)
	// getAllNavigationsAsDestination(), getEigenNavigationsAsDestination(), getInheritedNavigationsAsDestination - they depend on each other
	
	@Test
	public void testRepresent(){
		//OCL expression:
		//if self.oclIsTypeOf(Connection) then self.oclAsType(Connection).represent() 
		//else self.oclAsType(Entity).represent() endif
		
		//OCL expression aus Entity.represent(): if self.name.oclIsUndefined() then '' else self.name endif
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("myname");
		
		assertTrue("The result for c.represent() must be myname", c.represent() == "myname");
	}
	
	@Test
	public void testGetFeatureForName(){
		//OCL expression:
		//if self.getAllFeatures()->select(f|f.name = name)->size() = 0 then null
		//else self.getAllFeatures()->select(f|f.name = name)->asOrderedSet()->first() endif
		
		//OCL expression for getAttributeByName():
		//let foundAttributes:OrderedSet(Attribute) = self.getAllAttributes()->select(a | a.name = name) 
		//in if (foundAttributes->size() > 0) then foundAttributes->first()
		//else null endif
		
		//situation of the example:
		// |person1  |			
		// |---------|				
		// |name     |
		// |---------|
		// |getName()|
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject person1 = PLMFactory.eINSTANCE.createEntity();
		person1.setName("person1");
		Attribute name = PLMFactory.eINSTANCE.createAttribute();
		name.setName("name");
		person1.getFeature().add(name);
		Method getName = PLMFactory.eINSTANCE.createMethod();
		getName.setName("getName");
		person1.getFeature().add(getName);
		l.getContent().add(person1);
		
		assertTrue("The result of person1.getFeatureForName(name) must be the attribute name", person1.getFeatureForName("name").equals(name));
		assertTrue("The result of person1.getAttributeByName(name) must be the attribute name", person1.getAttributeByName("name").equals(name));
		assertTrue("The result of person1.getFeatureForName(getName) must be the attribute name", person1.getFeatureForName("getName").equals(getName));
	}

	@Test
	public void testGetPotencyAsString(){
		
		//to do: insert 100.000 into iteratorset
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("myname");
		c.setPotency(11);
		
		assertTrue("The result for c.getPotencyAsString() must be 11", c.getPotencyAsString().equals("11"));
		
	}

	//to do: getDisjointSiblings()
	
	@Test
	public void testViolatesMultiplicityConstraints(){
		
		//situation of the example:
		//Level l:
		// -------                   --------
		// |  c  | -----connect----- |  d   |
		// ------- 1           2...3 --------
		// 
		//Level 2:
		// --------                    ---------
		// |  c2  | -----connect2----- |  d2   |
		// |      | 1                1 ---------
		// |      |                    ---------
		// |      | -----connect3----- |  d3   |
		// -------- 1                1 ---------
		
		DeepModel dm = PLMFactory.eINSTANCE.createDeepModel();
		Level l = PLMFactory.eINSTANCE.createLevel();
		Level l2 = PLMFactory.eINSTANCE.createLevel();
		dm.getContent().add(l);
		dm.getContent().add(l2);
		
		Clabject c = PLMFactory.eINSTANCE.createEntity();
		c.setName("c");
		Clabject d = PLMFactory.eINSTANCE.createEntity();
		d.setName("d");
		Clabject c2 = PLMFactory.eINSTANCE.createEntity();
		c2.setName("c2");
		Clabject d2 = PLMFactory.eINSTANCE.createEntity();
		d2.setName("d2");
		Clabject d3 = PLMFactory.eINSTANCE.createEntity();
		d3.setName("d3");
		
		l.getContent().add(c);
		l.getContent().add(d);
		l2.getContent().add(c2);
		l2.getContent().add(d2);
		l2.getContent().add(d3);
		
		//Classification between c and c2
		Classification classi = PLMFactory.eINSTANCE.createClassification();
		classi.setInstance(c2);
		classi.setType(c);
		l2.getContent().add(classi);
		
		//Classification between d and d2
		Classification classi2 = PLMFactory.eINSTANCE.createClassification();
		classi2.setInstance(d2);
		classi2.setType(d);
		l2.getContent().add(classi2);
		
		//Classification between d and d3
		Classification classi3 = PLMFactory.eINSTANCE.createClassification();
		classi3.setInstance(d3);
		classi3.setType(d);
		l2.getContent().add(classi3);
		
		//connection between c and d
		Connection connect = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti2 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti.setConnection(connect);
		parti.setDestination(c);
		parti.setLower(1);
		parti.setUpper(1);
		parti2.setDestination(d);
		parti2.setConnection(connect);
		parti2.setLower(2);
		parti2.setUpper(3);
		l.getContent().add(connect);
		
		//c2 has no destinations: 0 <= 2 -> violates
		assertTrue("The result of c2.violatesMultiplicityConstraints() must state that it violates the multiplicity constraints", 
				c2.violatesMultiplicityConstraints());
		
		//connection between c2 and d2
		Connection connect2 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti3 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti4 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti3.setConnection(connect2);
		parti3.setDestination(c2);
		parti3.setLower(1);
		parti3.setUpper(1);
		parti4.setDestination(d2);
		parti4.setConnection(connect2);
		parti4.setLower(1);
		parti4.setUpper(1);
		l2.getContent().add(connect2);
		
		//Classification between connect and connect2
//		Classification classi4 = PLMFactory.eINSTANCE.createClassification();
//		classi4.setInstance(connect2);
//		classi4.setType(connect);
//		l2.getContent().add(classi4);
				
		//c2 has one destination: 1 <= 2 -> violates
		assertTrue("The result of c2.violatesMultiplicityConstraints() must state that it violates the multiplicity constraints", 
				c2.violatesMultiplicityConstraints());
		
		//connection between c2 and d3
		Connection connect3 = PLMFactory.eINSTANCE.createConnection();
		ConnectionEnd parti5 = PLMFactory.eINSTANCE.createConnectionEnd();
		ConnectionEnd parti6 = PLMFactory.eINSTANCE.createConnectionEnd();
		parti5.setConnection(connect3);
		parti5.setDestination(c2);
		parti5.setLower(1);
		parti5.setUpper(1);
		parti6.setDestination(d3);
		parti6.setConnection(connect3);
		parti6.setLower(1);
		parti6.setUpper(1);
		l2.getContent().add(connect3);
		
		//Classification between connect and connect3
		Classification classi5 = PLMFactory.eINSTANCE.createClassification();
		classi5.setInstance(connect3);
		classi5.setType(connect);
		l2.getContent().add(classi5);
		
		//c2 has two destinations: 2 <= 2 -> not violates
		assertFalse("The result of c2.violatesMultiplicityConstraints() must state that it doesn't violate the multiplicity constraints", 
				c2.violatesMultiplicityConstraints());
		
	}
}

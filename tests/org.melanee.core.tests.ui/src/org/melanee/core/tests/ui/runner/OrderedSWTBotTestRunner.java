/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.tests.ui.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;

public class OrderedSWTBotTestRunner extends SWTBotJunit4ClassRunner {

	public OrderedSWTBotTestRunner(Class<?> klass) throws Exception {
		super(klass);
	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		List<FrameworkMethod> result = new ArrayList<FrameworkMethod>(super.computeTestMethods());
		
		//Sort the list of returned methods as these are not necessary
		//sorted according to the Java specification
		Collections.sort(result, new Comparator<FrameworkMethod>() {
			
			@Override
			public int compare(FrameworkMethod m1, FrameworkMethod m2) {
				
				//Not ordered elements shall be executed last
                if (m1.getAnnotation(TestOrder.class) == null)
                	return 1;

                //Order by number specified in annotation
                int order1 = m1.getAnnotation(TestOrder.class).no(); 
                int order2 = m2.getAnnotation(TestOrder.class).no();
                
                if (order1 < order2)
                	return -1;
                else if (order1 > order2)
                	return 1;
                else
                	return 0;
			}
		});
		
		return result;
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface TestOrder {
		public int no();
	}
}
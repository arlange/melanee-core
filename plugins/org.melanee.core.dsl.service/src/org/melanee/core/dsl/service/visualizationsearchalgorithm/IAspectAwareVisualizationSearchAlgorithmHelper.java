package org.melanee.core.dsl.service.visualizationsearchalgorithm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;


/**
 * Interface used for configuring the {@link AspectAwareVisualizationSearchAlgorithm}.
 */
public interface IAspectAwareVisualizationSearchAlgorithmHelper {
	
	/**
	 * Checks if the current visualizer is of the right type e.g.
	 * when searching for a graphical dsl visualizer, all textual
	 * one shall be ignored. The implementation is usually an
	 * instance of check.
	 * 
	 * @param visualizer the visualizer to check
	 * @return true -> right visualizer type; false -> else
	 */
	public boolean isRightFormat(AbstractDSLVisualizer visualizer);
	
	/**
	 * Is obj an Aspect?
	 * 
	 * @param obj EObject to test.
	 * @return true => obj is treated as aspect; false => obj is not treated as aspect
	 */
	public boolean isAspect(EObject obj);
	
	/**
	 * Retrievs the clabject which contains the aspect.
	 * 
	 * @param aspect The aspect to get the visualizer for.
	 * @return
	 */
	public EObject getAspectContainingClabject(EObject aspect);
	
	/**
	 * Retrieves the condition of the aspect. The visualizer is
	 * only applied if the condition is true.
	 * 
	 * @param aspect The obj containing the condition.
	 * @return Condition for applying the visualizer
	 */
	public String getCondition(EObject aspect);
	
	/**
	 * Retrieves the name of the aspect or joinpoint. An aspect is merged into a
	 * join point if both names match. If eObj is neither an aspect nor an
	 * joinpoint null is expected as result.
	 * 
	 * @param eObj The aspect to get the name for
	 * @return
	 */
	public String getAspectOrJoinPointName(EObject eObj);
	
	/**
	 * Is the aspect of kind AROUND?
	 * 
	 * @param aspect The aspect to test
	 * @return true => AROUND aspect; false => not
	 */
	public boolean isAround(EObject aspect);
	
	/**
	 * Is the aspect of kind BEFORE?
	 * 
	 * @param aspect The aspect to test
	 * @return true => BEFORE aspect; false => not
	 */
	public boolean isBefore(EObject aspect);
	
	/**
	 * Is the aspect of kind AFTER?
	 * 
	 * @param aspect The aspect to test
	 * @return true => AFTER aspect; false => not
	 */
	public boolean isAfter(EObject aspect);
	
	/**
	 * Merge a copy of the aspect in the the copy of the join point.
	 * 
	 * <b>Do not create any copy of the parameters. All copies and
	 * the resolution to their origin is handled by the visualization
	 * search algorithm.</b> 
	 * 
	 * @param aspect a copy of the aspect
	 * @param joinPoint a copy of the join point
	 */
	public void merge(EObject aspect, EObject joinPoint);

	/**
	 * Checks whether the dslVisualizer is defined for the
	 * notation which is to be applied
	 * 
	 * @param dslVisualizer AbstractDSLVisualizer to check
	 * @return true -> right notation; false -> else
	 */
	public boolean isRightNotation(AbstractDSLVisualizer dslVisualizer);
	
}

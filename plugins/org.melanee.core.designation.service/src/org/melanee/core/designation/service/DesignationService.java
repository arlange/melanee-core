package org.melanee.core.designation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.workbench.interfaces.IDesignationService;

public class DesignationService implements IDesignationService {

	private static final int HERITAGE = 0;
	private static final int LOCATION = 1;
	private static final int CLASSIFICATION = 2;
	
	private static final String HERITAGE_OPERATOR = ">";
	private static final String CLASSIFICATION_OPERATOR = ":";
	private static final String LOCATION_OPERATOR = ".";
	
	private static final String ANONYMOUS_IDENTIFIER = "~";
	
	private static DesignationService service;
	
	public static DesignationService getInstance(){
		if (service == null)
			service = new DesignationService();
		
		return service;
	}
	
	@Override
	public String createHeritageDesignationString(Clabject context, String query) {
		return evaluate(query, context, true, false, false, false);
	}
	
	@Override
	public String createLocationDesignationString(Clabject context, String query) {
		return evaluate(query, context, false, true, false, false);
	}

	@Override
	public String createIdenficationDesignationString(Clabject context,
			String query) {
		return evaluate(query, context, false, false, true, false);
	}
	
	@Override
	public String createClassificationDesignationString(Clabject context, String query) {
		return evaluate(query, context, false, false, false, true);
	}
	
	/**
	 * Evaluates the query for heritage, location and classification.
	 * @param context
	 * @param query
	 * 
	 * @return
	 */
	public String evaluate(Clabject context, String query){
		return evaluate(query, context, true, true, true, true);
	}
	
	public String evaluate(String query, Clabject context, boolean heritage, boolean location, boolean identifier, boolean classification){
		
		String result = "";
		
		StringBuilder builder = new StringBuilder(query);
		Map<Integer, String> subDesignators = cleanControlLanguageFromSubDesignators(builder, context, new HashMap<Integer, String>(), 0);
		
		query = builder.toString();
		
		if(heritage)
			result += createHeritage(query, context, subDesignators);
		if(location)
			result += createLocation(query, context, subDesignators);
		if(identifier)
			result += getIdentifier(query, context, subDesignators);
		if(classification)
			result += createClassification(query, context, subDesignators);
		
		return result;
	}
	
	private Map<Integer, String> cleanControlLanguageFromSubDesignators(StringBuilder builder, Clabject context, Map<Integer, String> subDesignators, int subDesignatorID){
		int startIndex = -1;
		int endIndex = -1;
		int level = 0;
		
		for(int i = 0; i < builder.length(); i ++)
			if(builder.charAt(i) == '(' && startIndex == -1)
				startIndex = i;
			else if(startIndex != -1 && builder.charAt(i) == '(')
				level++;
			else if(startIndex != -1 && builder.charAt(i) == ')' && level != 0)
				level--;
			else if(startIndex != -1 && builder.charAt(i) == ')' && level == 0){
				
				endIndex = i + 1;
				
				String subDesignator = builder.substring(startIndex + 1, endIndex - 1);
				subDesignators.put(new Integer(subDesignatorID), subDesignator);
				builder.replace(startIndex, endIndex, "$"+subDesignatorID+"$");
				subDesignatorID++;
				cleanControlLanguageFromSubDesignators(builder, context, subDesignators, subDesignatorID);
				
				startIndex = -1;
				endIndex = -1;
				
				return subDesignators;
			}
		
		return subDesignators;
	}
	
	private String createHeritage(String query, Clabject context, Map<Integer, String> subDesignators){
		String result = "";
		
		//Keep right group in sync with variable
		String regex = "(?<left>\\d+)(?<subdesignator>\\$.*?\\$)?(?<operator>\\" + HERITAGE_OPERATOR + "(\\"+ HERITAGE_OPERATOR +")?)(?<right>[\\d+([a-zA-Z_]+)])";
		final int rightGroup = 5;
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(query);
	
		int start = 0;
		while(m.find(start)){
			
			ParseResult parseResult = parseExpression(m, HERITAGE_OPERATOR, HERITAGE_OPERATOR + HERITAGE_OPERATOR, 3, true, subDesignators);
			
			//the next search shall start after the operator
			start = parseResult.getOperatorPosition();
			
			//Right is location
			Pattern rightIsLocation = Pattern.compile("(?<location>\\d+[\\" + LOCATION_OPERATOR + "(\\" + LOCATION_OPERATOR + ")\\d+])");
			Matcher rightIsLocationMatcher = rightIsLocation.matcher(query.substring(m.start(rightGroup)));
			
			int right = parseResult.getRightAsInteger();
			if(rightIsLocationMatcher.find()
					&& rightIsLocationMatcher.start() == 0)
				right = 0;
			
			if(parseResult.getLeftAsInteger() < right){
				throw new IllegalArgumentException("Left must be bigger than Right");
			}
			
			Map<Integer, Set<Element>> distanceGroups = getIdentifiersInRange(right, parseResult.getLeftAsInteger(), 0, parseResult.isEllision, context, new HashMap<Integer, Set<Element>>(), DesignationService.HERITAGE); 
			result = getDesignatorSubString(distanceGroups, parseResult, result, true);
		}
		
		return result;
	}
	
	private String createLocation(String query, Clabject context, Map<Integer, String> subDesignators){
		String result = "";
		
		String regex = "(?<left>\\d+)(?<subdesignator>\\$.*?\\$)?(?<operator>\\" + LOCATION_OPERATOR + "(\\" + LOCATION_OPERATOR + ")?)(?<right>[\\d+([a-zA-Z_]+)])";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(query);
	
		int start = 0;
		while(m.find(start)){
			
			ParseResult parseResult = parseExpression(m, LOCATION_OPERATOR, LOCATION_OPERATOR + LOCATION_OPERATOR, 3, true, subDesignators);
			
			//the next search shall start after the operator
			start = parseResult.getOperatorPosition();
			
			if(parseResult.getLeftAsInteger() < parseResult.getRightAsInteger()){
				throw new IllegalArgumentException("Left must be bigger than Right");
			}
			
			Map<Integer, Set<Element>> distanceGroups = getIdentifiersInRange(parseResult.getRightAsInteger(), parseResult.getLeftAsInteger(), 0, parseResult.isEllision, context, new HashMap<Integer, Set<Element>>(), DesignationService.LOCATION);
			result = getDesignatorSubString(distanceGroups, parseResult, result, true);
		}
		
		return result;
	}
	
	private String createClassification(String query, Clabject context, Map<Integer, String> subDesignators){
		String result = "";
		
		//Keep right group in sync with variable
		String regex = "(?<left>[\\d+([a-zA-Z_]+)])(?<operator>" + CLASSIFICATION_OPERATOR + "("+ CLASSIFICATION_OPERATOR +")?)(?<right>\\d+)(?<subdesignator>\\$.*?\\$)?";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(query);
	
		int start = 0;
		while(m.find(start)){
			
			ParseResult parseResult = parseExpression(m, CLASSIFICATION_OPERATOR, CLASSIFICATION_OPERATOR + CLASSIFICATION_OPERATOR, 2, false, subDesignators);
			
			//the next search shall start after the operator
			start = parseResult.getOperatorPosition();
			
			if(parseResult.getLeftAsInteger() > parseResult.getRightAsInteger()){
				throw new IllegalArgumentException("Left must be bigger than Right");
			}
			
			Map<Integer, Set<Element>> distanceGroups = getIdentifiersInRange(parseResult.getLeftAsInteger(), parseResult.getRightAsInteger(), 0, parseResult.isEllision, context, new HashMap<Integer, Set<Element>>(), DesignationService.CLASSIFICATION);
			result = getDesignatorSubString(distanceGroups, parseResult, result, false);
		}
		
		return result;
	}
	
	private String getDesignatorSubString(Map<Integer, Set<Element>> distanceGroup, ParseResult parseResult, String result, boolean leftOfDesignator){
		
		Integer[] distances = distanceGroup.keySet().toArray(new Integer[0]);
		Arrays.sort(distances);
		
		int start = distances.length - 1;
		
		//For classification we need to itearte forwards
		if(parseResult.getOperator().contains(CLASSIFICATION_OPERATOR))
			start = 0;
		
		for(int i = start; ; ){
			
			//Abort condition no classification
			if(!parseResult.getOperator().contains(CLASSIFICATION_OPERATOR)
					&& (i < 0))
				break;
			//Abort conditon classification
			else if(parseResult.getOperator().contains(CLASSIFICATION_OPERATOR)
						&& i >= distances.length)
						break;
			
			Set<Element> list = distanceGroup.get(distances[i]);
			String tmp = "";
			for(Element e : list){
				if(!parseResult.hasSubDesignator())
					tmp += e.getName() + ",";
				else if (e instanceof Clabject)
					tmp += "(" + DesignationService.getInstance().evaluate((Clabject)e, parseResult.getSubDesignator()) + "),";
				else if (e instanceof Element)
					tmp += "(" + e.getName() + "),";
			}
			
			//remove the last ,
			if(list.size() > 0)
				tmp = tmp.substring(0, tmp.length() - 1);
			
			//Check if already in the list
			boolean added = false;
			String[] results = result.split(parseResult.getOperatorEscaped() + "(" + parseResult.getOperatorEscaped() + ")?");
			
			for (String s : results)
				if(s.equals(tmp))
					added = true;
			
			//Add if not already in the list
			if(!added){
				if (!leftOfDesignator)
					result += parseResult.isEllision ? parseResult.getEllisionOperator() : parseResult.getOperator();
				result += tmp;
				if (leftOfDesignator)
					result += parseResult.isEllision ? parseResult.getEllisionOperator() : parseResult.getOperator();
			}
			//This is a string where the begining of the current
			//processing was already done with the start of the 
			//last processing. We need to fix this to have the 
			//last sign correct.
			else if (leftOfDesignator &&
						result.endsWith(parseResult.getOperator())){
				if (result.endsWith(parseResult.getEllisionOperator()))
					result = result.substring(0, result.length() - 2);
				else
					result = result.substring(0, result.length() - 1);
				
				result = result.substring(0, result.lastIndexOf(parseResult.getOperator()) + 1);
				result += tmp;
				result += parseResult.isEllision ? parseResult.getEllisionOperator() : parseResult.getOperator();
			}
			
			//counter decrement no classification
			if(!parseResult.getOperator().contains(CLASSIFICATION_OPERATOR)
					&& (i >= 0))
					i--;
			//counter increment classification
			else if(parseResult.getOperator().contains(CLASSIFICATION_OPERATOR)
						&& (i < distances.length))
					i++;
		}
		
		return result;
	}
	
	private String getIdentifier(String query, Clabject context, Map<Integer, String> subDesignators){
		
		String regex = "(?<identifier>[a-zA-Z_]\\w+)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(query);
	
		while(m.find()){
			String identifier = m.group("identifier");
			if (identifier == null)
				return context.getName();
			
			Attribute a = context.getAttributeByName(identifier);
			
			if(a == null)
				return context.getName() == null || context.getName().equals("") ? ANONYMOUS_IDENTIFIER : context.getName();
			
			return a.getValue() == null || a.getValue().equals("") ? ANONYMOUS_IDENTIFIER : a.getValue();
		}
		
		return context.getName();
	}
	
	private Map<Integer, Set<Element>> getIdentifiersInRange(int startDistance, int endDistance, int currentDistance, boolean elide, Element context, Map<Integer, Set<Element>> distanceGroups, int searchFor){
		currentDistance++;
		
		//Everything between start and end needs to be shown
		if(currentDistance >= startDistance
				&& currentDistance <= endDistance
				&& !elide){
			Set<Element> queryResult = new HashSet<Element>();
			if (searchFor == DesignationService.HERITAGE)
				queryResult.addAll(((Clabject)context).getDirectSupertypes());
			else if (searchFor == DesignationService.LOCATION)
				queryResult.add((Element)context.eContainer());
			else if (searchFor == DesignationService.CLASSIFICATION)
				queryResult.addAll(((Clabject)context).getDirectTypes());
			Set<Element> currentGroup = distanceGroups.get(currentDistance);
			
			if(currentGroup == null)
				distanceGroups.put(currentDistance, queryResult);
			else
				currentGroup.addAll(queryResult);
			
			for(Element e : queryResult)
				getIdentifiersInRange(startDistance, endDistance, currentDistance, elide, e, distanceGroups, searchFor);
		}
		//only start and end need to be shown
		else if((currentDistance == startDistance
				|| currentDistance == endDistance)
				&& elide){
			Set<Element> queryResult = new HashSet<Element>();
			if (searchFor == DesignationService.HERITAGE)
				queryResult.addAll(((Clabject)context).getDirectSupertypes());
			else if (searchFor == DesignationService.LOCATION)
				queryResult.add((Element)context.eContainer());
			else if (searchFor == DesignationService.CLASSIFICATION)
				queryResult.addAll(((Clabject)context).getDirectTypes());
			Set<Element> currentGroup = distanceGroups.get(currentDistance);
			
			if(currentGroup == null)
				distanceGroups.put(currentDistance, queryResult);
			else
				currentGroup.addAll(queryResult);
			
			for(Element e : queryResult)
				getIdentifiersInRange(startDistance, endDistance, currentDistance, elide, e, distanceGroups, searchFor);
		}
		//This happens for the ellison case we need to go deeper without collecting
		else if(currentDistance < endDistance){
			List<Element> queryResult = new ArrayList<Element>();
			if (searchFor == DesignationService.HERITAGE)
				queryResult.addAll(((Clabject)context).getDirectSupertypes());
			else if (searchFor == DesignationService.LOCATION)
				queryResult.add((Element)context.eContainer());
			else if (searchFor == DesignationService.CLASSIFICATION)
				queryResult.addAll(((Clabject)context).getDirectTypes());
			for(Element e : queryResult)
				getIdentifiersInRange(startDistance, endDistance, currentDistance, elide, e, distanceGroups, searchFor);
		}
		
		return distanceGroups;
	}
	
	/**
	 * This contains the common code for parsing
	 * query in the form <left><operator><right>
	 *  
	 * @param m the matcher to use
	 * @param operator the operator that is used
	 * @param ellisionOperator the ellisionOperator that is used
	 * @param operatorGroupNumber the group number of the operator in the matcher
	 * @param identifierRight is the query left of the operator?
	 * 
	 * @return returns a parse result containing the obtained information
	 */
	private ParseResult parseExpression(Matcher m, String operator, String ellisionOperator, int operatorGroupNumber, boolean identifierRight, Map<Integer, String> subDesignators){
		String left = m.group("left");
		String right = m.group("right");
		boolean isEllision = ellisionOperator.equals(m.group("operator"));
		boolean isIdentifier = true;
		int operatorPosition = m.end(operatorGroupNumber);
		boolean hasSubDesignator = m.group("subdesignator") != null;
		String subDesignator = null;
		
		if (hasSubDesignator){
			int subDesignatorIndex = Integer.parseInt(m.group("subdesignator").replace("$", ""));
			subDesignator = subDesignators.get(subDesignatorIndex);
		}
		
		//Right is identifier
		Pattern isIdentifierPattern = Pattern.compile("(?<identifier>[a-zA-Z_])");
		Matcher isIdentifierMatcher;
		if (identifierRight){
			isIdentifierMatcher = isIdentifierPattern.matcher(right);
		}
		else
			isIdentifierMatcher = isIdentifierPattern.matcher(left);
		
		isIdentifier = isIdentifierMatcher.find();
		
		ParseResult p = new ParseResult(left, right, operator, isEllision, isIdentifier, operatorPosition, identifierRight, ellisionOperator, hasSubDesignator, subDesignator);
		
		return p;
		
	}
	
	protected class ParseResult{
		private String left;
		private String right;
		private String operator;
		private String ellisionOperator;
		private int operatorPosition;
		private boolean isEllision;
		private boolean isIdentifier;
		private boolean isIdentifierRight;
		private boolean hasSubDesignator;
		private String subDesignator;
		
		public String getLeft(){
			return left;
		}
		
		/**
		 * 
		 * @return the string as integer; if the identifier is
		 * 				on this side 0 is returned
		 */
		public int getLeftAsInteger(){
			if (!isIdentifierRight
					&& isIdentifier)
				return 0;
			
			return Integer.parseInt(left);
		}
		
		public String getRight(){
			return right;
		}
		
		/**
		 * 
		 * @return the string as integer; if the identifier is
		 * 				on this side 0 is returned
		 */
		public int getRightAsInteger(){
			if (isIdentifierRight
					&& isIdentifier)
				return 0;
			
			return Integer.parseInt(right);
		}
		
		public String getOperator(){
			return operator;
		}
		
		public String getOperatorEscaped(){
			if(HERITAGE_OPERATOR.equals(operator))
				return "\\" + HERITAGE_OPERATOR;
			else if (LOCATION_OPERATOR.equals(operator))
				return "\\" + LOCATION_OPERATOR;
			else
				return CLASSIFICATION_OPERATOR;
		}
		
		public String getEllisionOperator(){
			return ellisionOperator;
		}
		
		public int getOperatorPosition(){
			return operatorPosition;
		}
		
		public boolean isEllision(){
			return isEllision;
		}
		
		public boolean isIdentifier(){
			return isIdentifier;
		}
		
		public boolean hasSubDesignator(){
			return hasSubDesignator;
		}
		
		public String getSubDesignator(){
			return subDesignator;
		}
		
		public ParseResult(String left, String right, String operator, boolean isEllision, boolean isIdentifier, int operatorPosition, boolean isIdentifierRight, String ellisionOperator, boolean hasSubDesignator, String subDesignator){
			this.left = left;
			this.right = right;
			this.operator = operator;
			this.isEllision = isEllision;
			this.isIdentifier = isIdentifier;
			this.operatorPosition = operatorPosition;
			this.isIdentifierRight = isIdentifierRight;
			this.ellisionOperator = ellisionOperator;
			this.hasSubDesignator = hasSubDesignator;
			this.subDesignator = subDesignator;
		}
	}
}
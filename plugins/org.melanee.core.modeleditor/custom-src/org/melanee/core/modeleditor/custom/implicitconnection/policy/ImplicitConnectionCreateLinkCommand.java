/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * and others All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael GolubevRalph Gerbig - initial API and implementation and initial documentation
 *        - extension
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.implicitconnection.policy;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;


@SuppressWarnings("restriction")
public class ImplicitConnectionCreateLinkCommand extends CompositeCommand {

	private static final String REQUEST_PARAMETER_KEY = ImplicitConnectionCreateLinkCommand.class.getCanonicalName() + ":request:parameter:key"; //$NON-NLS-1$

	private ICommand mySemanticCreation;

	private ICommand myEdgeCreation;

	private SetConnectionEndsCommand mySetConnectionEndsCommand;

	private SetConnectionAnchorsCommand mySetConnectionAnchorsCommand;

	private SetConnectionBendpointsCommand mySetConnectionBendpointsCommand;

	private ImplicitConnectionCreateParameters mySourceParameters;

	private ImplicitConnectionCreateParameters myTargetParameters;

	private final PreferencesHint myPreferencesHint;

	public ImplicitConnectionCreateLinkCommand(TransactionalEditingDomain domain, PreferencesHint preferencesHint) {
		super(DiagramUIMessages.Commands_CreateCommand_Connection_Label);
		myPreferencesHint = preferencesHint;

		mySemanticCreation = null;
		mySetConnectionEndsCommand = new SetConnectionEndsCommand(domain, StringStatics.BLANK);
		mySetConnectionAnchorsCommand = new SetConnectionAnchorsCommand(domain, StringStatics.BLANK);
		mySetConnectionBendpointsCommand = new SetConnectionBendpointsCommand(domain);
	}

	public PreferencesHint getPreferencesHint() {
		return myPreferencesHint;
	}

	@Override
	public void add(IUndoableOperation operation) {
		assertNotExecuted();
		super.add(operation);
	}

	@Override
	public boolean canExecute() {
		if (mySemanticCreation != null && !mySemanticCreation.canExecute()) {
			return false;
		}
		if (myEdgeCreation != null && !myEdgeCreation.canExecute()) {
			return false;
		}
		if (mySetConnectionEndsCommand != null && !mySetConnectionEndsCommand.canExecute()) {
			return false;
		}
		if (mySetConnectionAnchorsCommand != null && !mySetConnectionAnchorsCommand.canExecute()) {
			return false;
		}
		if (mySetConnectionBendpointsCommand != null && !mySetConnectionBendpointsCommand.canExecute()) {
			return false;
		}
		if (isEmpty()) {
			//we are not actually empty, we do have 5 commands before
			return true;
		}
		return super.canExecute();
	}

	@Override
	public IStatus execute(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		addNotNull(mySemanticCreation);
		addNotNull(myEdgeCreation);
		addNotNull(mySetConnectionEndsCommand);
		addNotNull(mySetConnectionAnchorsCommand);
		addNotNull(mySetConnectionBendpointsCommand);

		IStatus result = super.execute(progressMonitor, info);
		if (result != null && result.getSeverity() == IStatus.CANCEL && !isExecuted()) {
			removeNotNull(mySemanticCreation);
			removeNotNull(myEdgeCreation);
			removeNotNull(mySetConnectionEndsCommand);
			removeNotNull(mySetConnectionAnchorsCommand);
			removeNotNull(mySetConnectionBendpointsCommand);
		}

		return result;
	}

	/**
	 * Intentionally package local, only U2TGraphicalNodeEditPolicy can call this. 
	 */
	void setSemanticCreation(ICommand semanticCreation) {
		assertNotExecuted();
		mySemanticCreation = semanticCreation;
	}

	/**
	 * Intentionally package local, only U2TGraphicalNodeEditPolicy can call this. 
	 */
	void setSourceParameters(ImplicitConnectionCreateParameters sourceParameters) {
		mySourceParameters = sourceParameters;
	}

	/**
	 * Intentionally package local, only U2TGraphicalNodeEditPolicy can call this. 
	 */
	void setTargetParameters(ImplicitConnectionCreateParameters targetParameters) {
		myTargetParameters = targetParameters;
	}

	public void setEdgeCreation(ICommand edgeAndSemantic) {
		assertNotExecuted();
		myEdgeCreation = edgeAndSemantic;
	}

	public void setEdgeAdapter(IAdaptable edgeAdaptor) {
		assertNotExecuted();
		mySetConnectionEndsCommand.setEdgeAdaptor(edgeAdaptor);
		mySetConnectionAnchorsCommand.setEdgeAdaptor(edgeAdaptor);
		mySetConnectionBendpointsCommand.setEdgeAdapter(edgeAdaptor);
	}

	public void setSetConnectionAnchorsCommand(SetConnectionAnchorsCommand setConnectionAnchorsCommand) {
		assertNotExecuted();
		mySetConnectionAnchorsCommand = setConnectionAnchorsCommand;
	}

	public void setSetConnectionEndsCommand(SetConnectionEndsCommand setConnectionEndsCommand) {
		assertNotExecuted();
		mySetConnectionEndsCommand = setConnectionEndsCommand;
	}

	public void setSetConnectionBendpointsCommand(SetConnectionBendpointsCommand setConnectionBendpointsCommand) {
		assertNotExecuted();
		mySetConnectionBendpointsCommand = setConnectionBendpointsCommand;
	}

	public ICommand getSemanticCreation() {
		return mySemanticCreation;
	}

	public ICommand getEdgeCreation() {
		return myEdgeCreation;
	}

	public SetConnectionAnchorsCommand getSetConnectionAnchorsCommand() {
		return mySetConnectionAnchorsCommand;
	}

	public SetConnectionEndsCommand getSetConnectionEndsCommand() {
		return mySetConnectionEndsCommand;
	}

	public SetConnectionBendpointsCommand getSetConnectionBendpointsCommand() {
		return mySetConnectionBendpointsCommand;
	}

	public ImplicitConnectionCreateParameters getSourceParameters() {
		return mySourceParameters;
	}

	public ImplicitConnectionCreateParameters getTargetParameters() {
		return myTargetParameters;
	}

	private void addNotNull(IUndoableOperation operation) {
		if (operation != null) {
			add(operation);
		}
	}

	private void removeNotNull(IUndoableOperation operation) {
		if (operation != null) {
			remove(operation);
		}
	}

	@SuppressWarnings("unchecked")
	public void registerInRequest(Request request) {
		request.getExtendedData().put(REQUEST_PARAMETER_KEY, this);
	}

	public static ImplicitConnectionCreateLinkCommand getFromRequest(Request request) {
		return (ImplicitConnectionCreateLinkCommand) request.getExtendedData().get(REQUEST_PARAMETER_KEY);
	}

	public static ImplicitConnectionCreateLinkCommand getFromRequest(IEditCommandRequest request) {
		return (ImplicitConnectionCreateLinkCommand) request.getParameter(REQUEST_PARAMETER_KEY);
	}
	
	
	//TODO: implement undo
//	@Override
//	public boolean canUndo() {
//		return true;
//	}
//	
//	@Override
//	public boolean canRedo(){
//		return true;
//	}
	
	
	//TODO: implement undo
	/**
	 * Needs to be overriden because the defaul GraphicalNodeEditPolicy goes through the commands
	 * by using an interator instead of get/set. Just filling the array will break the 
	 * one-click connection + 2 roles creation
	 */
//	@Override
//	public Iterator iterator() {
//		return new ITMIterator();
//	}
	
	private class ITMIterator implements ListIterator{

		int index = -1;
		
		@Override
		public void add(Object e) {
			throw new UnsupportedOperationException("Addition of Commands from this Command is not supported. Use getters and setters instead.");
		}

		@Override
		public boolean hasNext() {
			return index <= 4;
		}

		@Override
		public boolean hasPrevious() {
			return index > 1;
		}

		@Override
		public Object next() {
			//Returns in the same order as the array would be
			switch (++index){
				case 0:
					return mySemanticCreation;
				case 1:
					return mySetConnectionEndsCommand;
				case 2:
					return mySetConnectionAnchorsCommand;
				case 3:
					return mySetConnectionBendpointsCommand;
				default:
					return null;
			}
		}

		@Override
		public int nextIndex() {
			return index + 1;
		}

		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Removal of Commands from this Command is not supported. Use getters and setters instead.");
			
		}
		
		@Override
		public void set(Object e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

package org.melanee.core.emendation.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.melanee.core.emendation.service.commands.EmendAddAttributeCommandFactory;
import org.melanee.core.emendation.service.commands.EmendChangeClabjectTraitCommand;
import org.melanee.core.emendation.service.commands.EmendChangeFeatureTraitCommandFactory;
import org.melanee.core.emendation.service.commands.EmendMoveAttributeCommandFactory;
import org.melanee.core.emendation.service.commands.EmendRemoveAttributeCommandFactory;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.workbench.interfaces.IEmendationService;

/**
 * This is a very basic emendation service which is used as
 * fallback when no emendation service is found.
 *
 */
public class BasicEmendationService implements IEmendationService {

	private IImpactAnalyzer analyzer = null;

	private boolean paused = false;
	
	public IImpactAnalyzer getImpactAnalyzer(){
		if (analyzer == null)
			analyzer = new BasicImpactAnalyzer();
		
		return analyzer;
	}
	
	Map<Command, Set<EObject>> command2emendedObjects = new HashMap<Command, Set<EObject>>();
	
	@Override
	public Command handleMoveAttributeOperation(Clabject source, Clabject target, Feature movedFeature) {
		EmendMoveAttributeCommandFactory emendCommand = new EmendMoveAttributeCommandFactory(getImpactAnalyzer(), source, target, movedFeature);
		Command command = emendCommand.run();
		
		//The cancel button was pressed
		if (command == null)
			return null;
		
		command2emendedObjects.put(command, emendCommand.getEmendedObjects());
		return command;
	}

	@Override
	public Command handleRemoveAttributeOperation(Clabject changeOrigin, Feature featureToDelete) {
		EmendRemoveAttributeCommandFactory emendCommand = new EmendRemoveAttributeCommandFactory(getImpactAnalyzer(), changeOrigin, featureToDelete);
		Command command = emendCommand.run();
		
		//The cancel button was pressed
		if (command == null)
			return null;
		
		command2emendedObjects.put(command, new HashSet<EObject>(emendCommand.getEmendedObjects()));
		return command;
	}

	@Override
	public Command handleAddAttributeOperation(Clabject changeOrigin, Feature addedFeature) {
		EmendAddAttributeCommandFactory emendCommand = new EmendAddAttributeCommandFactory(getImpactAnalyzer(), changeOrigin, addedFeature);
		Command command = emendCommand.run();
		command2emendedObjects.put(command, new HashSet<EObject>(emendCommand.getEmendedObjects()));
		return command;
	}

	@Override
	public Command handleChangeFeatureTraitOperation(Feature changeOrigin, EStructuralFeature traitToChange,
			String oldValue, String newValue) {
		EmendChangeFeatureTraitCommandFactory emendCommand = new EmendChangeFeatureTraitCommandFactory(getImpactAnalyzer(), changeOrigin, traitToChange, oldValue, newValue);
		Command command = emendCommand.run();
		
		//The cancel button was pressed
		if (command == null)
			return null;
		
		command2emendedObjects.put(command, new HashSet<EObject>(emendCommand.getEmendedObjects()));
		return command;
	}

	@Override
	public Command handleChangeClabjectTraitOpertation(Clabject changeOrigin, EStructuralFeature traitToChange,
			String oldValue, String newValue) {
		EmendChangeClabjectTraitCommand emendCommand = new EmendChangeClabjectTraitCommand(getImpactAnalyzer(), changeOrigin, traitToChange, oldValue, newValue);
		Command command = emendCommand.run();
		
		//The cancel button was pressed
		if (command == null)
			return null;
		
		command2emendedObjects.put(command, new HashSet<EObject>(emendCommand.getEmendedObjects()));
		return command;
	}

	@Override
	public Set<EObject> getEmendedObjects(Command command) {
		return command2emendedObjects.get(command);
	}
	
	@Override
	public void pause() {
		paused = true;
	}

	@Override
	public void resume() {
		paused = false;
	}

	@Override
	public boolean isPaused() {
		return paused;
	}
}

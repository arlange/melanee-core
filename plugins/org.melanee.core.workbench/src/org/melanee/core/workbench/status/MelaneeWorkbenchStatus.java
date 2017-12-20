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
package org.melanee.core.workbench.status;

import org.eclipse.core.runtime.IStatus;

public class MelaneeWorkbenchStatus implements IStatus {

	
	public final static String CANNOT_FIND_PLUGIN_MESSAGE = "Check Melanee Preferences. Cannot find plugin with id:";
	
	public static int CANNOT_FIND_PLUGIN = -77;

	final private int severity;
	final private int code;
	final private String message;
	final private Throwable exception;
	final private String plugin;
	
	public MelaneeWorkbenchStatus(int severity, int code, String message, Throwable exception, String plugin){
		this.severity = severity;
		this.code = code;
		this.message = message;
		this.exception = exception;
		this.plugin = plugin;
	}
	
	@Override
	public IStatus[] getChildren() {
		return null;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public Throwable getException() {
		return exception;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getPlugin() {
		return plugin;
	}

	@Override
	public int getSeverity() {
		return severity;
	}

	@Override
	public boolean isMultiStatus() {
		return false;
	}

	@Override
	public boolean isOK() {
		return code == IStatus.OK;
	}

	@Override
	public boolean matches(int severityMask) {
		return false;
	}
}

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
package org.melanee.core.tests.ui;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.ArrayResult;
import org.eclipse.swtbot.swt.finder.results.BoolResult;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.utils.MessageFormat;
import org.eclipse.swtbot.swt.finder.utils.SWTBotEvents;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;

/**
 * This class is the SWTUtils class extended by the click feature
 * copied from AbstractSWTBotControl.
 */
public abstract class SWTUtilsEx extends SWTUtils {
	
	/** The logger. */
	private static Logger log = Logger.getLogger(SWTUtils.class);
	/** With great power comes great responsibility, use carefully. */
	private static Widget widget;
	/** With great power comes great responsibility, use carefully. */
	private static Display display;
	
	
	/**
	 * Click on the table at given coordinates
	 * 
	 * @param x the x co-ordinate of the click
	 * @param y the y co-ordinate of the click
	 * @since 2.0
	 */
	public static void clickXY(int x, int y, Widget w) {
		
		widget = w;
		display = w.getDisplay();
		
		log.debug(MessageFormat.format("Clicking on {0}", widget.toString())); //$NON-NLS-1$
		notify(SWT.MouseEnter);
		notify(SWT.MouseMove);
		notify(SWT.Activate);
		notify(SWT.FocusIn);
		notify(SWT.MouseDown, createMouseEvent(x, y, 1, SWT.NONE, 1));
		notify(SWT.MouseUp, createMouseEvent(x, y, 1, SWT.BUTTON1, 1));
		notify(SWT.Selection, createSelectionEvent(SWT.BUTTON1));
		notify(SWT.MouseHover);
		notify(SWT.MouseMove);
		notify(SWT.MouseExit);
		notify(SWT.Deactivate);
		notify(SWT.FocusOut);
		log.debug(MessageFormat.format("Clicked on {0}", widget.toString())); //$NON-NLS-1$
	}
	
	/**
	 * Sends a non-blocking notification of the specified type to the widget.
	 * 
	 * @param eventType the event type.
	 * @see Widget#notifyListeners(int, Event)
	 */
	private static void notify(final int eventType) {
		notify(eventType, createEvent());
	}

	/**
	 * Sends a non-blocking notification of the specified type to the {@link #widget}.
	 * 
	 * @param eventType the type of event.
	 * @param createEvent the event to be sent to the {@link #widget}.
	 */
	private static void notify(final int eventType, final Event createEvent) {
		notify(eventType, createEvent, widget);
	}

	/**
	 * Sends a non-blocking notification of the specified type to the widget.
	 * 
	 * @param eventType the type of event.
	 * @param createEvent the event to be sent to the {@link #widget}.
	 * @param widget the widget to send the event to.
	 */
	private static void notify(final int eventType, final Event createEvent, final Widget widget) {
		createEvent.type = eventType;
		final Object[] result = syncExec(new ArrayResult<Object>() {
			public Object[] run() {
				return new Object[] { SWTBotEvents.toString(createEvent), widget.toString() };
			}
		});

		log.trace(MessageFormat.format("Enquing event {0} on {1}", result)); //$NON-NLS-1$
		asyncExec(new VoidResult() {
			public void run() {
				if ((widget == null) || widget.isDisposed()) {
					log.trace(MessageFormat.format("Not notifying {0} is null or has been disposed", widget.toString())); //$NON-NLS-1$
					return;
				}
				if (!isEnabledInternal()) {
					log.warn(MessageFormat.format("Widget is not enabled: {0}", widget.toString())); //$NON-NLS-1$
					return;
				}
				log.trace(MessageFormat.format("Sending event {0} to {1}", result)); //$NON-NLS-1$
				widget.notifyListeners(eventType, createEvent);
				log.debug(MessageFormat.format("Sent event {0} to {1}", result)); //$NON-NLS-1$
			}
		});

		UIThreadRunnable.syncExec(new VoidResult() {
			public void run() {
				// do nothing, just wait for sync.
			}
		});

		long playbackDelay = SWTBotPreferences.PLAYBACK_DELAY;
		if (playbackDelay > 0)
			sleep(playbackDelay);
	}
	
	/**
	 * Create a mouse event
	 * 
	 * @param x the x co-ordinate of the mouse event.
	 * @param y the y co-ordinate of the mouse event.
	 * @param button the mouse button that was clicked.
	 * @param stateMask the state of the keyboard modifier keys.
	 * @param count the number of times the mouse was clicked.
	 * @return an event that encapsulates {@link #widget} and {@link #display}
	 * @since 1.2
	 */
	private static Event createMouseEvent(int x, int y, int button, int stateMask, int count) {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = widget;
		event.display = display;
		event.x = x;
		event.y = y;
		event.button = button;
		event.stateMask = stateMask;
		event.count = count;
		return event;
	}
	
	/**
	 * Create a selection event with a particular state mask
	 * 
	 * @param stateMask the state of the keyboard modifier keys.
	 */
	private static Event createSelectionEvent(int stateMask) {
		Event event = createEvent();
		event.stateMask = stateMask;
		return event;
	}
	
	/**
	 * Creates an event.
	 * 
	 * @return an event that encapsulates {@link #widget} and {@link #display}. Subclasses may override to set other
	 *         event properties.
	 */
	private static Event createEvent() {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = widget;
		event.display = display;
		return event;
	}
	
	/**
	 * Invokes {@link ArrayResult#run()} on the UI thread.
	 * 
	 * @param toExecute the object to be invoked in the UI thread.
	 * @return the array returned by toExecute.
	 */
	private static <T> T[] syncExec(ArrayResult<T> toExecute) {
		return UIThreadRunnable.syncExec(display, toExecute);
	}
	
	/**
	 * Invokes {@link BoolResult#run()} asynchronously on the UI thread.
	 * 
	 * @param toExecute the object to be invoked in the UI thread.
	 */
	private static void asyncExec(VoidResult toExecute) {
		UIThreadRunnable.asyncExec(display, toExecute);
	}
	
	/**
	 * Gets if the widget is enabled.
	 * <p>
	 * This method is not thread safe, and must be called from the UI thread.
	 * </p>
	 * 
	 * @return <code>true</code> if the widget is enabled.
	 * @since 1.0
	 */
	private static boolean isEnabledInternal() {
		try {
			return ((Boolean) SWTUtils.invokeMethod(widget, "isEnabled")).booleanValue(); //$NON-NLS-1$
		} catch (Exception e) {
			return true;
		}
	}
}

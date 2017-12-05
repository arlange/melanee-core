package org.melanee.core.designation.console;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

public class DesignationConsoleFactory implements IConsoleFactory {

	private static IConsole console;
	
	@Override
	public void openConsole() {
		IConsole console = getConsole();
		
		if (console != null) {
			IConsoleManager manager = ConsolePlugin.getDefault().getConsoleManager();
			IConsole[] existing = manager.getConsoles();
			boolean exists = false;
			for (int i = 0; i < existing.length; i++) {
				if(console == existing[i])
					exists = true;
			}
			if(! exists)
				manager.addConsoles(new IConsole[] {console});
			manager.showConsoleView(console);
		}
	}

    public static IConsole getConsole() {
        return (console == null) ? new DesignationConsole("Designation Console",null) : console;
    }
}

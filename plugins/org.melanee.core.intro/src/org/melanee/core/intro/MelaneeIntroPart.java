package org.melanee.core.intro;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.IntroPart;
import org.osgi.framework.Bundle;


public class MelaneeIntroPart extends IntroPart {

	private static String GO_TO_WORKBENCH = "action:gotoworkbench";
	private static String ADD_FEATURES = "action:addfeatures";
	
	private static String WELCOME_PAGE_ID = "org.eclipse.ui.internal.introview";
	
	private static String OPEN_INSTALL_NEW_SOFTWARE_COMMAND_ID = "org.eclipse.equinox.p2.ui.sdk.install";
	
	@Override
	public void standbyStateChanged(boolean standby) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPartControl(Composite parent) {
		
		Browser b = new Browser(parent, SWT.NONE);
		
		Bundle bundle = Platform.getBundle("org.melanee.core.intro");
		URL fileURL = bundle.getEntry("WelcomePage/index.html");
		
		try {
			b.setUrl(FileLocator.resolve(fileURL).toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		b.addLocationListener(new LocationListener() {
			
			@Override
			public void changing(LocationEvent event) {
				if (event.location.equals(GO_TO_WORKBENCH)){
					try {
						IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(WELCOME_PAGE_ID);
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(part);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
					
					event.doit = false;	
				}
				else if(event.location.equals(ADD_FEATURES)){
					IHandlerService handlerService = (IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
					try {
						handlerService.executeCommand(OPEN_INSTALL_NEW_SOFTWARE_COMMAND_ID, null);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
//					Command cmd = cmdService.getCommand("org.eclipse.equinox.p2.ui.sdk.install");
//					cmd.executeWithChecks(new ExecutionEvent());
					event.doit = false;
				}
			}
			
			@Override
			public void changed(LocationEvent event) {
				//Do nothing
			}
		});
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}

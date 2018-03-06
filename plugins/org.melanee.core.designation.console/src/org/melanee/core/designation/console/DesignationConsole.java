package org.melanee.core.designation.console;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;

public class DesignationConsole extends AbstractConsole {

  public DesignationConsole(String name, ImageDescriptor imageDescriptor) {
    super(name, imageDescriptor);
  }

  @Override
  public IPageBookViewPage createPage(IConsoleView view) {

    return new DesignationConsolePage();
  }

}

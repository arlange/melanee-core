/*******************************************************************************
 * Copyright (c) 2016 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig    - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.editortoolbaritems;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.ui.action.AbstractContributionItem;
import org.eclipse.gmf.runtime.diagram.ui.internal.util.IUIConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbenchPage;
import org.melanee.core.models.plm.PLM.ComplianceKind;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.PLMPackage;

public class SelectComplianceModeContributionItem extends AbstractContributionItem
    implements Listener {

  private static final String id = "org.melanee.core.modeleditor.editortoolbaritems";

  private final Domain domain;
  private final String[] compatibilityModes;
  private Combo complianceCombo;

  public SelectComplianceModeContributionItem(IWorkbenchPage workbenchPage, Domain domain) {
    super(workbenchPage, id);
    this.domain = domain;
    compatibilityModes = getCompatibilityModesAsText();
  }

  /**
   * @see org.eclipse.gmf.runtime.common.ui.action.AbstractContributionItem#createControl(org.eclipse.swt.widgets.Composite)
   */
  protected Control createControl(Composite parent) {
    complianceCombo = new Combo(parent, SWT.DROP_DOWN);
    complianceCombo.addListener(SWT.Selection, this);
    complianceCombo.addListener(SWT.KeyDown, this);
    complianceCombo.setItems(compatibilityModes);
    complianceCombo.select(complianceCombo.indexOf(domain.getComplianceKind().getName()));
    complianceCombo.setVisibleItemCount(IUIConstants.DEFAULT_DROP_DOWN_SIZE);

    return complianceCombo;
  }

  private String[] getCompatibilityModesAsText() {
    String[] result = new String[ComplianceKind.VALUES.size()];
    int i = 0;
    for (ComplianceKind c : ComplianceKind.VALUES)
      result[i++] = c.getLiteral();

    return result;
  }

  @Override
  public void handleEvent(Event event) {
    // Enter is commonly known as ascii 13 on all platforms. To prevent
    // casting, this is the same as \r.
    if (event.type == SWT.KeyDown && event.character != '\r')
      return;

    EditingDomain editingDomain = TransactionUtil.getEditingDomain(domain);
    Command setComplianceModeCommand = SetCommand.create(editingDomain, domain,
        PLMPackage.eINSTANCE.getDomain_ComplianceKind(),
        ComplianceKind.get(complianceCombo.getSelectionIndex()));
    editingDomain.getCommandStack().execute(setComplianceModeCommand);

  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }

  @Override
  protected void doRun(IProgressMonitor progressMonitor) {
    // TODO Auto-generated method stub

  }
}
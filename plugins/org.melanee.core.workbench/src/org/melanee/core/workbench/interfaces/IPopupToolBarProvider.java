/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.workbench.interfaces;

import java.util.List;

public interface IPopupToolBarProvider {

  public static final String ExtensionPointID = "org.melanee.core.autolayout.service";

  /**
   * 
   * Lists all PopUpBarToolButtons that are available for an diagram editor
   * element (IGraphicalEditPart)
   * 
   * @param object
   * @return the available PopUpBarToolButtons
   *         (org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool)
   */
  public List<PopupToolBarToolWrapper> getPopUpToolbarButtonsForDiagramElement(Object host);

  public class PopupToolBarToolWrapper {

    private Object image = null;
    private Object tool = null;
    private String text;
    private String groupId;

    /**
     * 
     * @param image
     *          the image to display
     * @param tool
     *          the tool to execute (can be null)
     * @param text
     *          the tooltip to display
     * @param groupId
     *          the group to sort the drowp down into
     */
    public PopupToolBarToolWrapper(Object image, Object tool, String text, String groupId) {
      this.image = image;
      this.tool = tool;
      this.text = text;
      this.groupId = groupId;
    }

    public void setImage(Object image) {
      this.image = image;
    }

    public Object getImage() {
      return image;
    }

    public void setTool(Object tool) {
      this.tool = tool;
    }

    public Object getTool() {
      return tool;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }

    public String getGroupId() {
      return groupId;
    }
  }

  public class PopupToolBarMenuWrapper extends PopupToolBarToolWrapper {

    private List<PopupToolBarToolWrapper> children;

    public PopupToolBarMenuWrapper(Object image, Object tool, String text,
        List<PopupToolBarToolWrapper> children, String groupId) {
      super(image, tool, text, groupId);
      this.children = children;
    }

    public List<PopupToolBarToolWrapper> getChildren() {
      return children;
    }
  }
}
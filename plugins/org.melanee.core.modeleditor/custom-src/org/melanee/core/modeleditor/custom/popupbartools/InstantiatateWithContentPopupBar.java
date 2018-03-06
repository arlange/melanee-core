/*******************************************************************************
 * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.popupbartools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteListener;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;

public class InstantiatateWithContentPopupBar extends AbstractPopupBarTool {

  public InstantiatateWithContentPopupBar(EditPart epHost, CreateRequest theRequest) {
    super(epHost, theRequest);
  }

  @Override
  protected Request createTargetRequest() {
    ChangePropertyValueRequest req = new ChangePropertyValueRequest("instantiate", "instantiate");
    return req;
  }

  @Override
  protected Command getCommand() {

    return new Command() {

      @Override
      public boolean canExecute() {
        return true;
      }

      @Override
      public void execute() {
        IGraphicalEditPart host = (IGraphicalEditPart) getHost();
        final PaletteDrawer instantiateDrawer = new PaletteDrawer("Instantiate");

        final PaletteViewer palette = ((EditDomain) host.getDiagramEditDomain()).getPaletteViewer();
        palette.getPaletteRoot().add(instantiateDrawer);

        List<IElementType> types = new ArrayList<IElementType>(2);
        types.add(org.melanee.core.modeleditor.providers.PLMElementTypes.Entity_3120);
        types.add(org.melanee.core.modeleditor.providers.PLMElementTypes.Entity_3105);

        Element type = ((Element) host.resolveSemanticElement());

        // *******************************************************
        // This tool synchronizes notation and semantic model
        // on execution
        // *******************************************************
        NodeToolEntry entry = new NodeToolEntry(type.getName(), "Creates a new " + type.getName(),
            types, instantiateDrawer);

        entry.setId(
            "dsl." + EMFCoreUtil.getProxyID(type) + ModelEditorConstants.INSTANTIATE_WITH_CONTENT);
        entry.setSmallIcon(org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin
            .findImageDescriptor("/org.melanee.core.modeleditor/icons/clabject16.gif")); //$NON-NLS-1$
        entry.setLargeIcon(org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin
            .findImageDescriptor("/org.melanee.core.modeleditor/icons/clabject16.gif"));

        instantiateDrawer.add(entry);

        // instantiateDrawer.setVisible(false);

        palette.setActiveTool(entry);

        // instantiateDrawer.setVisible(false);
        //

        palette.addPaletteListener(new PaletteListener() {

          @Override
          public void activeToolChanged(PaletteViewer palette, ToolEntry tool) {
            palette.getPaletteRoot().remove(instantiateDrawer);
            palette.removePaletteListener(this);
          }
        });
      }
    };
  }

  private static class NodeToolEntry extends ToolEntry {

    /**
     * @generated
     */
    private final List<IElementType> elementTypes;
    private final PaletteDrawer containingDrawer;

    /**
     * @generated
     */
    private NodeToolEntry(String title, String description, List<IElementType> elementTypes,
        PaletteDrawer containingDrawer) {
      super(title, description, null, null);
      this.elementTypes = elementTypes;
      this.containingDrawer = containingDrawer;
    }

    /**
     * @generated
     */
    public Tool createTool() {
      Tool tool = new UnspecifiedTypeCreationToolEx(elementTypes, containingDrawer);
      tool.setProperties(getToolProperties());
      return tool;
    }
  }

  private static class UnspecifiedTypeCreationToolEx extends UnspecifiedTypeCreationTool {

    private PaletteDrawer containingDrawer = null;

    @Override
    protected Command getCommand() {
      final org.eclipse.gef.commands.CompoundCommand result = (org.eclipse.gef.commands.CompoundCommand) super.getCommand();

      if (result == null)
        return result;

      Command synchronizeCommand = new Command("Synchronize Visualizers and Notation model") {
        @Override
        public void execute() {
          org.eclipse.gef.commands.CompoundCommand elementAndViewCompoundCommand = (org.eclipse.gef.commands.CompoundCommand) result
              .getCommands().get(1);
          SetBoundsCommand sbc = (SetBoundsCommand) ((ICommandProxy) elementAndViewCompoundCommand
              .getCommands().get(1)).getICommand();
          try {
            Field f = sbc.getClass().getDeclaredField("adapter");
            f.setAccessible(true);
            ViewAndElementDescriptor v = (ViewAndElementDescriptor) f.get(sbc);
            Node rootNode = (Node) v.getAdapter(View.class);

            InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain) TransactionUtil
                .getEditingDomain(rootNode);
            domain.startTransaction(false, java.util.Collections.EMPTY_MAP);

            // For the rootNode we set width and height only, position is determined by
            // mouse click
            Bounds bounds = (Bounds) rootNode.getLayoutConstraint();
            LMLVisualizer visualizer = ((Element) rootNode.getElement()).getVisualizer().get(0);
            bounds.setHeight(visualizer.getHeight());
            bounds.setWidth(visualizer.getWidth());

            // Set the layout for the content
            TreeIterator<EObject> iter = rootNode.eAllContents();

            while (iter.hasNext()) {
              EObject next = iter.next();

              // Only nodes are of interest
              if (!(next instanceof Node))
                continue;

              Node nextNode = (Node) next;

              // Only nodes with bounds are of interes
              if (nextNode.getLayoutConstraint() == null
                  || !(nextNode.getLayoutConstraint() instanceof Bounds))
                continue;

              Bounds nextBounds = (Bounds) nextNode.getLayoutConstraint();
              LMLVisualizer nextVisualizer = ((Element) nextNode.getElement()).getVisualizer()
                  .get(0);

              // Copy everything over
              nextBounds.setHeight(nextVisualizer.getHeight());
              nextBounds.setWidth(nextVisualizer.getWidth());
              nextBounds.setX(nextVisualizer.getXLocation());
              nextBounds.setY(nextVisualizer.getYLocation());
            }

            domain.getActiveTransaction().commit();

          } catch (NoSuchFieldException e) {
            e.printStackTrace();
          } catch (SecurityException e) {
            e.printStackTrace();
          } catch (IllegalArgumentException e) {
            e.printStackTrace();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (RollbackException e) {
            e.printStackTrace();
          }

          // result.getCommands().get(1)
          // EObject newModelElement = result.getCommands().get(1);
        }
      };

      result.add(synchronizeCommand);

      return result;
    }

    public UnspecifiedTypeCreationToolEx(List elementTypes) {
      super(elementTypes);
    }

    public UnspecifiedTypeCreationToolEx(List elementTypes, PaletteDrawer containingDrawer) {
      this(elementTypes);
      this.containingDrawer = containingDrawer;
    }

    @Override
    protected void handleFinished() {
      containingDrawer.setVisible(true);
      super.handleFinished();
    }
  }
}
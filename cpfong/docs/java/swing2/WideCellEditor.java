/* ( swing1.1beta3 ) swing#1007 */
 
package jp.gr.java_conf.tame.swing.tree;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
 * @version 1.0 11/09/98
 */
public class WideCellEditor extends DefaultTreeCellEditor {

  public WideCellEditor(JTree tree,
  			DefaultTreeCellRenderer renderer) {
    this(tree, renderer, null);
  }

  public WideCellEditor(final JTree tree, final DefaultTreeCellRenderer renderer,
			TreeCellEditor editor) {
    super(tree,renderer,editor);
    editingContainer = new WideEditorContainer();
  }
  
  public Component getTreeCellEditorComponent(JTree tree, Object value,
	  boolean isSelected, boolean expanded, boolean leaf, int row) {
    Component c = super.getTreeCellEditorComponent(tree, value,
	             isSelected, expanded, leaf, row);
    ((WideEditorContainer)editingContainer).setLocalCopy(
                     tree,lastPath,offset,editingComponent);	
    return c;					
  }   
  
  class WideEditorContainer extends DefaultTreeCellEditor.EditorContainer {
    JTree     tree;
    TreePath  lastPath;
    int       offset;
    Component editingComponent;
      
    public void doLayout() {
      if (editingComponent != null) {
        Dimension  cSize = getSize();
        Dimension  eSize = editingComponent.getPreferredSize();
        int n = lastPath.getPathCount(); 
        Rectangle r = new Rectangle();
        r = tree.getBounds(r);
        eSize.width = r.width -(offset *n);
        editingComponent.setSize(eSize);
        editingComponent.setLocation(offset, 0);
        editingComponent.setBounds(offset, 0, eSize.width, cSize.height);
        setSize(new Dimension(eSize.width + offset, cSize.height));
      }
    }
        
    void setLocalCopy(JTree tree, TreePath lastPath,
                        int offset,Component editingComponent) {
      this.tree     = tree;
      this.lastPath = lastPath;
      this.offset   = offset;
      this.editingComponent = editingComponent;
    }
  }
}
  
  
  

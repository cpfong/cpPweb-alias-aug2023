// DisabledRenderer.java
/* (swing1.1.1beta2) */ 
package jp.gr.java_conf.tame.swing.tree;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import jp.gr.java_conf.tame.swing.icon.*;


/**
 * @version 1.1 04/30/99
 */
public class DisabledRenderer extends DefaultTreeCellRenderer {
  protected Icon disabledLeafIcon;
  protected Icon disabledOpenIcon;
  protected Icon disabledClosedIcon;
    
  public DisabledRenderer() {
    this( new GraydIcon(UIManager.getIcon("Tree.leafIcon")),
          new GraydIcon(UIManager.getIcon("Tree.openIcon")),
          new GraydIcon(UIManager.getIcon("Tree.closedIcon")) );
  }
  
  public DisabledRenderer(Icon leafIcon, Icon openIcon, Icon closedIcon) {
    setDisabledLeafIcon(leafIcon);
    setDisabledOpenIcon(openIcon);
    setDisabledClosedIcon(closedIcon);
  }
    
  public Component getTreeCellRendererComponent(JTree tree,
                   Object value, boolean sel, boolean expanded,
                   boolean leaf, int row, boolean hasFocus) {     
    String stringValue = tree.convertValueToText(value, sel,
			    expanded, leaf, row, hasFocus);
    setText(stringValue);
    if (sel) {
      setForeground(getTextSelectionColor());
    } else {
      setForeground(getTextNonSelectionColor());
    }
    
    boolean treeIsEnabled = tree.isEnabled(); 
    boolean nodeIsEnabled = ((DisabledNode)value).isEnabled(); 
    boolean isEnabled = (treeIsEnabled && nodeIsEnabled);
    setEnabled(isEnabled);
    
    if (isEnabled) {
      selected = sel;
      if (leaf) {
        setIcon(getLeafIcon());
      } else if (expanded) {
        setIcon(getOpenIcon());
      } else {
        setIcon(getClosedIcon());
      }   
    } else {
      selected = false;
      if (leaf) {
        if (nodeIsEnabled) {
          setDisabledIcon(getLeafIcon());
        } else {
          setDisabledIcon(disabledLeafIcon);
        }
      } else if (expanded) {
        if (nodeIsEnabled) {
          setDisabledIcon(getOpenIcon());
        } else {
          setDisabledIcon(disabledOpenIcon);
        }
      } else {
        if (nodeIsEnabled) {
          setDisabledIcon(getClosedIcon());
        } else {
          setDisabledIcon(disabledClosedIcon);
        }
      }
    }
    return this;
  }  
  
  public void setDisabledLeafIcon(Icon icon) {
    disabledLeafIcon = icon;
  }
  
  public void setDisabledOpenIcon(Icon icon) {
    disabledOpenIcon = icon;
  }
  
  public void setDisabledClosedIcon(Icon icon) {
    disabledClosedIcon = icon;
  }
}


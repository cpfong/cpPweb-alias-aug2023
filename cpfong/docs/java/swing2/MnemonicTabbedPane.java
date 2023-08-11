/* (swing1.1.1beta2) */
package jp.gr.java_conf.tame.swing.panel;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.basic.*;


/**
 * @version 1.1 06/02/99
 */
public class MnemonicTabbedPane extends JTabbedPane {
  Hashtable mnemonics = null;
  int condition;
  
  public MnemonicTabbedPane() {
    setUI(new MnemonicTabbedPaneUI());
    mnemonics = new Hashtable();
    
    // I don't know which one is more suitable for mnemonic action.
    //setMnemonicCondition(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    setMnemonicCondition(WHEN_IN_FOCUSED_WINDOW);
  }
  
  public void setMnemonicAt(int index, char c) {
    int key = (int)c;
    if ('a' <= key && key <='z') {
      key -= ('a' - 'A');
    }
    setMnemonicAt(index, key);
  }
  
  public void setMnemonicAt(int index, int keyCode) {
    ActionListener action = new MnemonicAction(index);
    KeyStroke stroke = KeyStroke.getKeyStroke(keyCode, ActionEvent.ALT_MASK);
    registerKeyboardAction(action, stroke, condition);
    mnemonics.put(new Integer(index), new Integer(keyCode));
  }
  
  public int getMnemonicAt(int index) {
    int keyCode = 0;
    Integer m = (Integer)mnemonics.get(new Integer(index));
    if (m != null) {
      keyCode = m.intValue();
    }
    return keyCode;
  }
  
  public void setMnemonicCondition(int condition) {
    this.condition = condition;
  }
  
  public int getMnemonicCondition() {
    return condition;
  }
  
  class MnemonicAction implements ActionListener {
    int index;
    
    public MnemonicAction(int index) {
      this.index = index;
    }
    
    public void actionPerformed(ActionEvent e) {
      MnemonicTabbedPane tabbedPane = (MnemonicTabbedPane)e.getSource();
      tabbedPane.setSelectedIndex(index);
      tabbedPane.requestFocus();
    }
  }
  
  class MnemonicTabbedPaneUI extends MetalTabbedPaneUI {
    protected void paintText(Graphics g, int tabPlacement,
                             Font font, FontMetrics metrics, int tabIndex,
                             String title, Rectangle textRect, 
                             boolean isSelected) {
      g.setFont(font);
      MnemonicTabbedPane mtabPane = (MnemonicTabbedPane)tabPane;      
      if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
        g.setColor(tabPane.getForegroundAt(tabIndex));
	BasicGraphicsUtils.drawString(g,title, mtabPane.getMnemonicAt(tabIndex),
			  textRect.x,
			  textRect.y + metrics.getAscent());
      } else {
        g.setColor(tabPane.getBackgroundAt(tabIndex).brighter());
	BasicGraphicsUtils.drawString(g,title, mtabPane.getMnemonicAt(tabIndex),
			  textRect.x,
			  textRect.y + metrics.getAscent());
        g.setColor(tabPane.getBackgroundAt(tabIndex).darker());
	BasicGraphicsUtils.drawString(g,title, mtabPane.getMnemonicAt(tabIndex),
			  textRect.x - 1,
			  textRect.y + metrics.getAscent() - 1);
      }	
    } 
  } 
}


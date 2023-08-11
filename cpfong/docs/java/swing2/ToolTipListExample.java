// File:ToolTipListExample.java
/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @version 1.0 08/26/99
 */
public class ToolTipListExample extends JFrame {
  
  public ToolTipListExample() {
    super("ToolTip Example");
    
    String[][] strs = {{"Acinonyx jutatus","Cheetah"},
                       {"Panthera leo"    ,"Lion"   },
                       {"Canis lupus"     ,"Wolf"   },
                       {"Lycaon pictus"   ,"Llycaon"},
                       {"Vulpes Vulpes"   ,"Fox"    }};    
                                            
    JList list = new JList( createItems(strs) ) {
      public String getToolTipText(MouseEvent e) {
        int index = locationToIndex(e.getPoint());
        if (-1 < index) {
          ToolTipItem item = (ToolTipItem)getModel().getElementAt(index);
          return item.getToolTipText();
        } else {
          //return super.getToolTipText();
          return null;
        }
      }
    };
    list.setToolTipText("");
    
    getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);
  }
  
  Object[] createItems(String[][] strs) {
    ToolTipItem[] items = new ToolTipItem[strs.length];
    for (int i=0;i<strs.length;i++) {
      items[i] = new ToolTipItem(strs[i][0], strs[i][1]);
    }
    return items;
  }
  
  class ToolTipItem {
    String  obj;
    String  toolTipText;
    
    public ToolTipItem(String obj, String text) {
      this.obj = obj;
      this.toolTipText = text;
    }
    
    public String getToolTipText() {
      return toolTipText;
    }
    
    public String toString() {
      return obj;
    }
  }

  public static void main(String args[]) {
    ToolTipListExample frame = new ToolTipListExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    frame.setSize(140, 150);
    frame.setVisible(true);
  } 
}

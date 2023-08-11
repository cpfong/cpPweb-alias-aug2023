/* (swing1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import jp.gr.java_conf.tame.swing.combobox.*;

/**
 * @version 1.0 12/12/98
 */  
public class SteppedComboBoxExample extends JFrame {
  public SteppedComboBoxExample() {
    super("SteppedComboBox Example");  
    
    String[] str = {
      "A",
      "abcdefghijklmnopqrstuvwxyz",
      "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
      "0123456789" 
    };
                  
    SteppedComboBox combo = new SteppedComboBox(str);
    Dimension d = combo.getPreferredSize();
    combo.setPreferredSize(new Dimension(50, d.height));
    combo.setPopupWidth(d.width);
    
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(combo);
  }

  public static void main (String args[]) {
    SteppedComboBoxExample f = new SteppedComboBoxExample();
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    f.setSize (300, 100);
    f.show();
  }
}

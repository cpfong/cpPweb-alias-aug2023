/* (swing1.1beta3) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jp.gr.java_conf.tame.swing.tooltip.*;


/**
 * @version 1.0 11/09/98
 */
public class MultiLineToolTipExample extends JFrame {
  public MultiLineToolTipExample() {
    super("Multi-Line ToolTip Example");   
    JButton button = new JButton ("Hello, world") {
      public JToolTip createToolTip() {
        MultiLineToolTip tip = new MultiLineToolTip();
        tip.setComponent(this);
        return tip;
      }
    };
    button.setToolTipText("Hello\nworld");
    getContentPane().add(button);
  }

  public static void main (String args[]) {
    MultiLineToolTipExample f = new MultiLineToolTipExample();
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    f.setSize (300, 100);
    f.show();
  }
}

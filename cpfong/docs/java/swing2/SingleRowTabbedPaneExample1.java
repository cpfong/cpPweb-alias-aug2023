/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jp.gr.java_conf.tame.swing.panel.*;

/**
 * @version 1.0 07/09/99
 */
public class SingleRowTabbedPaneExample1 extends JPanel {                     
  public SingleRowTabbedPaneExample1() {
    setLayout(new BorderLayout());
        
    SingleRowTabbedPane tabbedPane = new SingleRowTabbedPane(
      SingleRowTabbedPane.ONE_BUTTON, SwingConstants.RIGHT);
    
    String tabs[] = {"One", "Two", "Three", "Four", "Five",
                     "Six", "Seven","Eight","Nine", "Ten" };
    for (int i=0;i<tabs.length;i++) {
      tabbedPane.addTab(tabs[i], createPane(tabs[i]));
    }
    tabbedPane.setSelectedIndex(0);
    add(tabbedPane, BorderLayout.CENTER);
  }
  
  private JPanel createPane(String s) {
    JPanel p = new JPanel();
    p.add(new JLabel(s));
    return p;
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("One button Example");
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
    frame.getContentPane().add( new SingleRowTabbedPaneExample1() );
    frame.setSize( 250, 100 );
    frame.setVisible(true);
  }
}

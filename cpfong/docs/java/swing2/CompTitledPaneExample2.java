/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jp.gr.java_conf.tame.swing.panel.*;

/**
 * @version 1.0 08/12/99
 */  
public class CompTitledPaneExample2 extends JFrame {

  public CompTitledPaneExample2() {
    super("CompTitledPaneExample2");
    JCheckBox title = new JCheckBox("Title");
    title.setSelected(true);
    final CompTitledPane p1 = new CompTitledPane(title);
    title.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        p1.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
      }
    });
    APanel p2 = new APanel();
    p1.setTransmittingAllowed(true);
    p1.setTransmitter(p2);
    p1.getContentPane().add(p2);
    getContentPane().add(p1, BorderLayout.CENTER);
  }
  
  class APanel extends JPanel implements StateTransmitter { 
    JButton    button;
    JTextField textField;  
     
    APanel() {
      button = new JButton("abc");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Ouch!");
        }
      });
      textField = new JTextField(10);
      textField.setText("text");
      add(button   , BorderLayout.NORTH);
      add(textField, BorderLayout.SOUTH);
    }
    
    public void setChildrenEnabled(boolean enable) {
      button.setEnabled(enable);
      textField.setEnabled(enable);
    }    
  }
  

  public static void main (String args[]) {
    CompTitledPaneExample2 frame = new CompTitledPaneExample2();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    frame.setSize(280, 110);
    frame.setVisible(true);
  }
}

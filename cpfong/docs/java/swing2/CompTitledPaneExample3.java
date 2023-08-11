/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jp.gr.java_conf.tame.swing.panel.*;

/**
 * @version 1.0 08/13/99
 */  
public class CompTitledPaneExample3 extends JFrame {

  public CompTitledPaneExample3() {
    super("CompTitledPaneExample3");
    
    Container c = getContentPane();    
    c.setLayout(new GridLayout(2,2));
    ButtonGroup group = new ButtonGroup();
    APanel p = new APanel(group, "Metal");
    c.add(p);
    c.add(new APanel(group, "Motif"));
    c.add(new APanel(group, "Mac"));
    c.add(new APanel(group, "Windows"));
    p.getRadioButton().setSelected(true);
  }
  
  class APanel extends CompTitledPane {
    JRadioButton titleComp;
    
    APanel(ButtonGroup group, final String text) {
      titleComp = new JRadioButton(text);
      final JButton button = new JButton(text);
      setTitleComponent(titleComp);
      this.titleComp = titleComp;
      group.add(titleComp);
      titleComp.setSelected(true);
      titleComp.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
          button.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
        }
      });
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println(text);
        }
      });
      getContentPane().add(button);
    }
    
    public JRadioButton getRadioButton() {
      return titleComp;
    }
  }
  
  
  public static void main (String args[]) {
    CompTitledPaneExample3 frame = new CompTitledPaneExample3();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    frame.setSize(280, 200);
    frame.setVisible(true);
  }
}

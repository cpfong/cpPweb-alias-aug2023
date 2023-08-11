/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import jp.gr.java_conf.tame.swing.panel.*;

/**
 * @version 1.0 08/12/99
 */  
public class CompTitledPaneExample1 extends JFrame {

  String title = "<html>Title (" 
               + "<font color=\"#ffffff\"><i>JLabel</i></font>"
               + ")";

  public CompTitledPaneExample1() {
    super("CompTitledPaneExample1");
    JLabel titleLabel = new JLabel(title);
    CompTitledPane p1 = new CompTitledPane(titleLabel);
    JPanel p = p1.getContentPane();
    p.setLayout(new BorderLayout());
    p.add(new SwitchPanel(p1), BorderLayout.CENTER);
    getContentPane().add(p1, BorderLayout.CENTER);
  }
  
  class SwitchPanel extends JPanel implements ActionListener {
    String[] posStr = {"", "ABOVE_TOP"   , "TOP"   , "BELOW_TOP"
                         , "ABOVE_BOTTOM", "BOTTOM", "BELOW_BOTTOM"};
    String[] jusStr = {"", "LEFT"        , "CENTER", "RIGHT"};
    TitledBorder border;
    CompTitledPane panel;
    
    SwitchPanel(CompTitledPane panel) {
      this.panel = panel;
      this.border = (TitledBorder)panel.getBorder();
      add(createPanel("Position"     ,posStr, 2));
      add(createPanel("Justification",jusStr, 1));
    }
    
    JPanel createPanel(String str, String[] strs, int selectPos) {
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(strs.length, 1));
      p.add(new JLabel(str));
      ButtonGroup g = new ButtonGroup();
      for (int i=1;i<strs.length;i++) {
        JRadioButton b = new JRadioButton(strs[i]);
        if (i == selectPos) {
          b.setSelected(true);
        }
        p.add( b );
        g.add( b );
        b.addActionListener(this);
      }
      return p;
    }
    
    public void actionPerformed(ActionEvent e) {
      JRadioButton b = (JRadioButton)e.getSource();
      String label = b.getText();
      for (int i=1; i<posStr.length; i++) {
        if (label.equals(posStr[i])) {
          border.setTitlePosition(i);
          panel.revalidate();
          panel.repaint();
          return;
        }    
      }
      for (int i=1; i<jusStr.length; i++) {
        if (label.equals(jusStr[i])) {
          border.setTitleJustification(i);
          panel.revalidate();
          panel.repaint();
          return;
        }    
      }
    }   
  }
  

  public static void main (String args[]) {
    CompTitledPaneExample1 frame = new CompTitledPaneExample1();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    frame.setSize(280, 230);
    frame.setVisible(true);
  }
}

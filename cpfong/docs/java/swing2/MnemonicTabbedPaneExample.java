/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jp.gr.java_conf.tame.swing.panel.*;

/**
 * @version 1.1 06/02/99
 */
public class MnemonicTabbedPaneExample extends JPanel {
                      
  public MnemonicTabbedPaneExample() {
    setLayout (new BorderLayout());
        
    MnemonicTabbedPane tabbedPane = new MnemonicTabbedPane();
    String[] tabs = {"Zero","One", "Two", "Three", "Four"};
    char[]   ms   = {'Z','O', 'T','h','F'};
    int[]    keys = {KeyEvent.VK_0,
                     KeyEvent.VK_1,
                     KeyEvent.VK_2,
                     KeyEvent.VK_3,
                     KeyEvent.VK_4,
                     };
    
    for (int i=0;i<tabs.length;i++) {
      tabbedPane.addTab(tabs[i], createPane (tabs[i]));
      tabbedPane.setMnemonicAt(i, ms[i]);
      //tabbedPane.setMnemonicAt(i, keys[i]);
    }
    tabbedPane.setSelectedIndex(0);
    add(tabbedPane, BorderLayout.CENTER);
    add(new JButton("button"), BorderLayout.SOUTH);
  }
  
  JPanel createPane(final String s) {
    JButton abcButton = new JButton("Abc");
    abcButton.setMnemonic('A');
    JButton xyzButton = new JButton("Xyz");
    xyzButton.setMnemonic('X');
    
    JPanel p = new JPanel();
    p.add(new JLabel(s));
    p.add(abcButton);
    p.add(xyzButton);
    return p;
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("TabbedPane Test");
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
    frame.getContentPane().add(new MnemonicTabbedPaneExample());
    frame.setSize( 250, 130 );
    frame.setVisible(true);
  } 
}

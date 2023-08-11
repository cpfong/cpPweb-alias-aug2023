/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.basic.*;
import jp.gr.java_conf.tame.swing.menu.*;


/**
 * @version 1.0 05/10/99
 */  
public class ComboBoxMenuExample extends JFrame {

  public ComboBoxMenuExample() {
    super("ComboBoxMenu Example"); 
    
    String[] itemStr = {
      "name"   ,"Red"     ,"Blue",
      "number" ,"255,0,0" ,"0,0,255",
      // separator
      "system" ,"control" ,"controlHighlight" ,"controlShadow",
                "text" 
    };
                          
    JMenuItem[] menuItems = new JMenuItem[7];
    menuItems[0] = new JMenuItem(itemStr[ 1]);
    menuItems[1] = new JMenuItem(itemStr[ 2]);
    menuItems[2] = new JMenuItem(itemStr[ 4]);
    menuItems[3] = new JMenuItem(itemStr[ 5]);
    menuItems[4] = new JMenuItem(itemStr[ 8]);
    menuItems[5] = new JMenuItem(itemStr[ 9]);
    menuItems[6] = new JMenuItem(itemStr[10]);
    
    JMenu[] menus = new JMenu[4];
    menus[0] = new JMenu(itemStr[0]);
    menus[1] = new JMenu(itemStr[3]);
    menus[2] = new JMenu(itemStr[6]);
    menus[3] = new JMenu(itemStr[7]);
    
    menus[0].add(menuItems[0]);
    menus[0].add(menuItems[1]);
    menus[1].add(menuItems[2]);
    menus[1].add(menuItems[3]);
    menus[3].add(menuItems[4]);
    menus[3].add(menuItems[5]);
    menus[2].add(menus[3]);
    menus[2].add(menuItems[6]);
    
    JMenu menu = ComboMenuBar.createMenu(menuItems[0].getText());
    menu.add(menus[0]);
    menu.add(menus[1]);
    menu.addSeparator();
    menu.add(menus[2]);
    
    ComboMenuBar comboMenu = new ComboMenuBar(menu);
    
        
    JComboBox combo = new JComboBox();
    combo.addItem(itemStr[ 1]);
    combo.addItem(itemStr[ 2]);
    combo.addItem(itemStr[ 4]);
    combo.addItem(itemStr[ 5]);
    combo.addItem(itemStr[ 8]);
    combo.addItem(itemStr[ 9]);
    combo.addItem(itemStr[10]);
    
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(new ComboPanel("Fake ComboBox", comboMenu));
    getContentPane().add(new ComboPanel("ComboBox"     , combo));
  }
  
  class ComboPanel extends JPanel {
    ComboPanel(String title, JComponent c) {
      setLayout(new FlowLayout());
      setBorder(new TitledBorder(title));
      add(c);
    }
  }

  public static void main (String args[]) {
    ComboBoxMenuExample frame = new ComboBoxMenuExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    frame.setSize(370, 100);
    frame.setVisible(true);    
  }     
}

/* (swing1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.plaf.metal.*;

import jp.gr.java_conf.tame.swing.tree.*;
import jp.gr.java_conf.tame.swing.icon.*;

/**
 * @version 1.0 01/12/99
 */
public class IconNodeTreeExample extends JFrame {
  public IconNodeTreeExample() {
    super("IconNode TreeExample");
    
    String[] strs = {"swing home",  // 0
		     "platf",       // 1
		     "basic.txt",   // 2
		     "metal.c",     // 3
		     "metal.java",  // 4
		     "metal.html",  // 5
		     "Computer",    // 6
		     "A:",          // 7
		     "C:",          // 8
		     "D:"};         // 9
                                             
    IconNode[] nodes = new IconNode[strs.length];
    for (int i=0;i<strs.length;i++)
      nodes[i] = new IconNode(strs[i]); 
    nodes[0].add(nodes[1]);
    for (int i=2;i<=5;i++) nodes[1].add(nodes[i]);
    nodes[0].add(nodes[6]);
    for (int i=7;i<=9;i++) nodes[6].add(nodes[i]);
    
    //
    // set Icon directly
    //
    nodes[0].setIcon(MetalIconFactory.getFileChooserHomeFolderIcon());
     
    //
    // use JTree default Icon
    //
    // nodes[1]
    // nodes[2]
   
    //
    // set Icon by user Object
    //
    // nodes[3]
    // nodes[4]
    // nodes[5]
    
    //
    // set Icon by name
    //
    nodes[6].setIconName("computer");
    nodes[7].setIconName("floppyDrive");
    nodes[8].setIconName("hardDrive");
    nodes[9].setIconName("hardDrive");
    
    JTree tree = new JTree( nodes[0] );
    tree.putClientProperty("JTree.icons", makeIcons());
    tree.setCellRenderer(new IconNodeRenderer());
    JScrollPane sp = new JScrollPane(tree);
    getContentPane().add(sp, BorderLayout.CENTER);
  }
  
  private Hashtable makeIcons() {
    Hashtable icons = new Hashtable();
    icons.put("floppyDrive",MetalIconFactory.getTreeFloppyDriveIcon());
    icons.put("hardDrive"  ,MetalIconFactory.getTreeHardDriveIcon());
    icons.put("computer"   ,MetalIconFactory.getTreeComputerIcon()); 
    icons.put("c"    ,TextIcons.getIcon("c"));
    icons.put("java" ,TextIcons.getIcon("java"));
    icons.put("html" ,TextIcons.getIcon("html"));    
    return icons;
  }

  public static void main(String args[]) {
    IconNodeTreeExample frame = new IconNodeTreeExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}

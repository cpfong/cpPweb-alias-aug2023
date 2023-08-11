/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.tree.*;
import jp.gr.java_conf.tame.swing.tree.*;

/**
 * @version 1.0 06/20/99
 */
public class AnimatedIconTreeExample2 extends JFrame {
  final static String CAT = "cat";
  final static String DOG = "dog";
  
  public AnimatedIconTreeExample2() {
    super("AnimatedIconTreeExample2");
    String[] strs = {"CARNIVORA",                       // 0
		      "Felidae",                        // 1
		        "Acinonyx jutatus  (cheetah)",  // 2  
		        "Panthera leo  (lion)",         // 3  		          
		      "Canidae",                        // 4
		        "Canis lupus  (wolf)",          // 5  
		        "Lycaon pictus  (lycaon)",      // 6  		          
		        "Vulpes Vulpes  (fox)"};        // 7  
                                             
    IconNode[] nodes = new IconNode[strs.length];
    for (int i=0;i<strs.length;i++) {
      nodes[i] = new IconNode(strs[i]); 
    }
    nodes[0].add(nodes[1]);
    nodes[0].add(nodes[4]);
    nodes[1].add(nodes[2]);
    nodes[1].add(nodes[3]);
    nodes[4].add(nodes[5]);
    nodes[4].add(nodes[6]);
    nodes[4].add(nodes[7]);
    
    // If you want to share the ImageIcon with a node.
        
    nodes[2].setIconName(CAT);
    nodes[3].setIconName(CAT);
    nodes[5].setIconName(DOG);
    nodes[6].setIconName(DOG);
    nodes[7].setIconName(DOG);
    
    Hashtable icons = new Hashtable();
    icons.put(CAT ,new ImageIcon("images/3-119.gif"));
    icons.put(DOG ,new ImageIcon("images/3-6.gif"));
    
    JTree tree = new JTree( nodes[0] );
    tree.putClientProperty("JTree.icons", icons);
    tree.setCellRenderer(new IconNodeRenderer());
    setImageObserver(tree, nodes, icons);
        
    JScrollPane sp = new JScrollPane(tree);
    getContentPane().add(sp, BorderLayout.CENTER);
  }
  
  private void setImageObserver(JTree tree,IconNode[] nodes,Hashtable icons) {
    Hashtable observers = new Hashtable();
    
    for (int i=0;i<nodes.length;i++) {
      ImageIcon icon = (ImageIcon)nodes[i].getIcon();
      if (icon != null) {
        Vector repaintNodes = new Vector();
        repaintNodes.addElement(nodes[i]);
        icon.setImageObserver(new NodeImageObserver(tree, repaintNodes));
      } else {
        String iconName = nodes[i].getIconName(); 
        if (iconName != null) {
          Vector repaintNodes = (Vector)observers.get(iconName);
          if (repaintNodes == null) {
            repaintNodes = new Vector();
            observers.put(iconName, repaintNodes);
          }
          repaintNodes.addElement(nodes[i]);
        }
      }
    } 
    
    Enumeration enum = observers.keys();  
    while (enum.hasMoreElements()) {
      String iconName = (String)enum.nextElement();
      Vector repaintNodes = (Vector)observers.get(iconName);
      ImageIcon icon = (ImageIcon)icons.get(iconName);
      icon.setImageObserver(new NodeImageObserver(tree, repaintNodes));
    }
  }
    
  class NodeImageObserver implements ImageObserver {
    JTree            tree;
    DefaultTreeModel model;
    Vector           nodes;
      
    NodeImageObserver(JTree tree,Vector nodes) {
      this.tree  = tree;
      this.model = (DefaultTreeModel)tree.getModel();
      this.nodes = nodes;
    }
    
    public boolean imageUpdate(Image img, int flags,
			       int x, int y, int w, int h) {
      if ((flags & (FRAMEBITS|ALLBITS)) != 0) {
        Enumeration enum = nodes.elements();  
        while (enum.hasMoreElements()) {
          TreeNode node = (TreeNode)enum.nextElement();
          TreePath path = new TreePath(model.getPathToRoot(node));        
          Rectangle rect = tree.getPathBounds(path);
          if (rect != null) {
            tree.repaint(rect);
          }
        }
      }
      return (flags & (ALLBITS|ABORT)) == 0;
    }
  }    

  public static void main(String args[]) {
    AnimatedIconTreeExample2 frame = new AnimatedIconTreeExample2();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    frame.setSize(280, 200);
    frame.setVisible(true);
  }
}

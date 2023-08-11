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
public class AnimatedIconTreeExample extends JFrame {
  
  public AnimatedIconTreeExample() {
    super("AnimatedIconTreeExample");
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
    
    nodes[2].setIcon(new ImageIcon("images/3-119.gif"));
    nodes[3].setIcon(new ImageIcon("images/3-119.gif"));
    nodes[5].setIcon(new ImageIcon("images/3-6.gif"));
    nodes[6].setIcon(new ImageIcon("images/3-6.gif"));
    nodes[7].setIcon(new ImageIcon("images/3-6.gif"));
    
    JTree tree = new JTree( nodes[0] );
    tree.setCellRenderer(new IconNodeRenderer());
    setImageObserver(tree, nodes);
        
    JScrollPane sp = new JScrollPane(tree);
    getContentPane().add(sp, BorderLayout.CENTER);
  }
  
  private void setImageObserver(JTree tree,IconNode[] nodes) {
    for (int i=0;i<nodes.length;i++) {
      ImageIcon icon = (ImageIcon)nodes[i].getIcon();
      if (icon != null) {
        icon.setImageObserver(new NodeImageObserver(tree, nodes[i]));
      }
    }    
  }
    
  class NodeImageObserver implements ImageObserver {
    JTree            tree;
    DefaultTreeModel model;
    TreeNode         node;
      
    NodeImageObserver(JTree tree,TreeNode node) {
      this.tree  = tree;
      this.model = (DefaultTreeModel)tree.getModel();
      this.node  = node;
    }
    
    public boolean imageUpdate(Image img, int flags,
			       int x, int y, int w, int h) {
      if ((flags & (FRAMEBITS|ALLBITS)) != 0) {
        TreePath path = new TreePath(model.getPathToRoot(node));        
        Rectangle rect = tree.getPathBounds(path);
        if (rect != null) {
          tree.repaint(rect);
        }
      }
      return (flags & (ALLBITS|ABORT)) == 0;
    }
  }    

  public static void main(String args[]) {
    AnimatedIconTreeExample frame = new AnimatedIconTreeExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    frame.setSize(280, 200);
    frame.setVisible(true);
  }
}

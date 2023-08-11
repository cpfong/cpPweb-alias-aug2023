// DisabledNodeTreeExample.java
/* (swing1.1.1beta2) swing#1331 */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;
import jp.gr.java_conf.tame.swing.icon.*;
import jp.gr.java_conf.tame.swing.tree.*;

/**
 * @version 1.1 04/30/99
 */
public class DisabledNodeTreeExample extends JFrame {
  public DisabledNodeTreeExample() {
    super("DisabledNode TreeExample");
    
    String[] strs = {"swing",     // 0
		     "plaf",      // 1
		     "basic",     // 2
		     "metal",     // 3
		     "JTree",     // 4
		     "plaf",      // 5
		     "motif"};    // 6
                                             
    DisabledNode[] nodes = new DisabledNode[strs.length];
    for (int i=0;i<strs.length;i++) {
      nodes[i] = new DisabledNode(strs[i]); 
    }
    nodes[0].add(nodes[1]);
    nodes[1].add(nodes[2]);
    nodes[1].add(nodes[3]);
    nodes[0].add(nodes[4]);
    nodes[0].add(nodes[5]);
    nodes[5].add(nodes[6]);
    nodes[3].setEnabled(false);
    nodes[5].setEnabled(false);
    
    final JTree tree = new JTree( nodes[0] ) {
      public boolean isPathEditable(TreePath path) {
        DisabledNode node = (DisabledNode)path.getLastPathComponent();
        if (node.isEnabled()) {
          return isEditable();
        } else {
          return false;
        }
      }     
    };
    
    DisabledRenderer renderer = new DisabledRenderer();
    renderer.setDisabledLeafIcon(new DisabledLeafIcon());
    renderer.setDisabledOpenIcon(new DisabledFolderIcon());
    renderer.setDisabledClosedIcon(new DisabledFolderIcon());
    tree.setCellRenderer(renderer);
    tree.setEditable(true);
    
    JScrollPane sp = new JScrollPane(tree);    
    ButtonPanel bp = new ButtonPanel(tree);
    getContentPane().add(sp, BorderLayout.CENTER);
    getContentPane().add(bp, BorderLayout.EAST);
  }
   
  class ButtonPanel extends JPanel {
    JTree tree;
    DefaultTreeModel model;
    
    ButtonPanel(JTree tree) {
      this.tree = tree;
      model = (DefaultTreeModel)tree.getModel();
      setLayout(new GridLayout(2,1));
      setBorder(new TitledBorder("Change Node"));
      JButton enabledButton  = new JButton("Enabled");
      JButton disabledButton = new JButton("Disabled");
      add(enabledButton);
      add(disabledButton);
      enabledButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setNodeEnabled( true  );
        }
      });
      disabledButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setNodeEnabled( false );
        }
      });
    }
    
    private void setNodeEnabled(boolean enabled) {
      TreePath[] path = tree.getSelectionPaths();
      if (path == null) return;
      DisabledNode node = null;
      for (int i=0;i<path.length;i++) {
        node = (DisabledNode)path[i].getLastPathComponent();
        //if (node.isRoot()) {
        //  System.out.println("refused: root node");
        //} else {
          int beforeChildCount = node.getChildCount();
          node.setEnabled(enabled);
          int afterChildCount  = node.getChildCount();
          if (beforeChildCount == afterChildCount) {
            model.nodeChanged(node);
          } else {
            model.reload();
          }
        //}
      }
    }
  }

  public static void main(String args[]) {
    DisabledNodeTreeExample frame = new DisabledNodeTreeExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    frame.setSize(300, 180);
    frame.setVisible(true);
  }
}

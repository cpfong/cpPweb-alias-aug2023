/*  
 * 
 * This example works only each Icon has same width.
 *
 * editing JTextField has minimum 100. (swing1.1beta3) swing#1007
 *
 */
// example ( /* swing1.0.3 */    swing1.1beta3 )  
//package jp.gr.java_conf.tame.swing.examples;

  import java.awt.*;
  import java.awt.event.*;

  /* swing1.0.3
  import com.sun.java.swing.*;
  import com.sun.java.swing.tree.*;
  import com.sun.java.swing.plaf.basic.*;
  */

  // swing1.1beta3
  import javax.swing.*;
  import javax.swing.tree.*;
  //
  
  import jp.gr.java_conf.tame.swing.tree.*;

/**
 * @version 1.0 11/09/98
 */

  public class WideEditorTreeExample extends JFrame {
    public WideEditorTreeExample() {
      super("Wide Editor JTree Example");
      String[] strs = { "swing",         // 0
                        "plaf",          // 1
                        "basic",         // 2
                        "metal",         // 3
                        "JTree"};        // 4                                           
      DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[strs.length];
      for (int i=0;i<strs.length;i++)
        nodes[i] = new DefaultMutableTreeNode(strs[i]); 
      nodes[0].add(nodes[1]);
      nodes[1].add(nodes[2]);
      nodes[1].add(nodes[3]);
      nodes[0].add(nodes[4]);
      JTree tree = new JTree( nodes[0] );
      tree.setEditable(true);
    
      /* swing1.0.3
      tree.setCellEditor(new BasicTreeCellEditor(
        (BasicTreeCellRenderer)tree.getCellRenderer()) {   
          public void doLayout() {
            if (editor != null) {
              Dimension  cSize = getSize();
              Dimension  eSize = editor.getPreferredSize();
              int n = lastPath.getPathCount(); 
              Rectangle r = new Rectangle();
              r = changeTree.getBounds(r);
              eSize.width = r.width -(editingOffset *n);
              editor.setSize(eSize);
              editor.setLocation(editingOffset, 0);
              editor.setBounds(editingOffset, 0, eSize.width, cSize.height);
              setSize(new Dimension(eSize.width + editingOffset,
                                    cSize.height));
            }
          }
        }
      );
      */
    
      // swing1.1beta3
      tree.setCellEditor(new WideCellEditor(tree,
        (DefaultTreeCellRenderer)tree.getCellRenderer()));
      //
    
      JScrollPane sp = new JScrollPane(tree);
      getContentPane().add(sp, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
      WideEditorTreeExample frame = new WideEditorTreeExample();
      frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {System.exit(0);}
      });
      frame.setSize(300, 150);
      frame.setVisible(true);
    }
  }
  
  
  

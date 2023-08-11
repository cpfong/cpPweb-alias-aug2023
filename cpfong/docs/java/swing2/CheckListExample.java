// File:CheckListExample.java
/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.metal.*;

import jp.gr.java_conf.tame.swing.tree.*;

/**
 * @version 1.0 04/24/99
 */
public class CheckListExample extends JFrame {
  
  public CheckListExample() {
    super("CheckList Example");
    String[] strs = {"swing", "home", "basic", "metal", "JList"};    
                                            
    final JList list = new JList( createData(strs) );
    
    // set "home" icon
    Icon icon = MetalIconFactory.getFileChooserHomeFolderIcon();
    ((CheckableItem)list.getModel().getElementAt(1)).setIcon(icon);
    
    list.setCellRenderer(new CheckListRenderer());
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setBorder(new EmptyBorder(0,4,0,0));
    list.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        int index = list.locationToIndex(e.getPoint());
        CheckableItem item = (CheckableItem)list.getModel().getElementAt(index);
        item.setSelected(! item.isSelected());
        Rectangle rect = list.getCellBounds(index, index);
        list.repaint(rect);
      }
    });   
    JScrollPane sp = new JScrollPane(list);  
     
    final JTextArea textArea = new JTextArea(3,10);
    JScrollPane textPanel = new JScrollPane(textArea);
    JButton printButton = new JButton("print");
    printButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ListModel model = list.getModel();
        int n = model.getSize();
        for (int i=0;i<n;i++) {
          CheckableItem item = (CheckableItem)model.getElementAt(i);
          if (item.isSelected()) {
            textArea.append(item.toString());
            textArea.append(System.getProperty("line.separator"));
          }
        }
      }
    });
    JButton clearButton = new JButton("clear");
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textArea.setText("");
      }
    });
    JPanel panel = new JPanel(new GridLayout(2,1));
    panel.add(printButton);
    panel.add(clearButton);
    
    getContentPane().add(sp,    BorderLayout.CENTER);
    getContentPane().add(panel, BorderLayout.EAST);
    getContentPane().add(textPanel, BorderLayout.SOUTH);
  }
  
  private CheckableItem[] createData(String[] strs) {
    int n = strs.length;
    CheckableItem[] items = new CheckableItem[n];
    for (int i=0;i<n;i++) {
      items[i] = new CheckableItem(strs[i]);
    }
    return items;
  }
  
  class CheckableItem {
    private String  str;
    private boolean isSelected;
    private Icon icon;
    
    public CheckableItem(String str) {
      this.str = str;
      isSelected = false;
    }
    
    public void setSelected(boolean b) {
      isSelected = b;
    }
    
    public boolean isSelected() {
      return isSelected;
    }
    
    public String toString() {
      return str;
    }
    
    public void setIcon(Icon icon) {
      this.icon = icon;
    }
    
    public Icon getIcon() {
      return icon;
    }
  }
  
  class CheckListRenderer extends CheckRenderer implements ListCellRenderer {
    Icon commonIcon;
    
    public CheckListRenderer() {
      check.setBackground(UIManager.getColor("List.textBackground"));
      label.setForeground(UIManager.getColor("List.textForeground"));
      commonIcon = UIManager.getIcon("Tree.leafIcon");
    }

    public Component getListCellRendererComponent(JList list, Object value,
               int index, boolean isSelected, boolean hasFocus) {
      setEnabled(list.isEnabled());
      check.setSelected(((CheckableItem)value).isSelected());
      label.setFont(list.getFont());
      label.setText(value.toString());
      label.setSelected(isSelected);
      label.setFocus(hasFocus);
      Icon icon = ((CheckableItem)value).getIcon();
      if (icon == null) {
        icon = commonIcon;
      }
      label.setIcon(icon);
      return this;
    }
  } 

  public static void main(String args[]) {
    CheckListExample frame = new CheckListExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
    frame.setSize(300, 200);
    frame.setVisible(true);
  } 
}

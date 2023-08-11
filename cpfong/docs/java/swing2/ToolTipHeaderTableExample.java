/* (swing1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import jp.gr.java_conf.tame.swing.table.*;

/**
 * @version 1.0 02/25/99
 */
public class ToolTipHeaderTableExample extends JPanel {

  public ToolTipHeaderTableExample(){
    setLayout(new BorderLayout());
    String[] headerStr  = {"default","jw"      ,"ja"      ,"la"   ,"unknown"};
    String[] toolTipStr = {""       ,"Javanese","Japanese","Latin"};
    
    DefaultTableModel dm = new DefaultTableModel(headerStr, 4);
    JTable table = new JTable(dm);
    
    ToolTipHeader header = new ToolTipHeader(table.getColumnModel());
    header.setToolTipStrings(toolTipStr);
    header.setToolTipText("Default ToolTip TEXT");
    table.setTableHeader(header);
    
    JScrollPane pane = new JScrollPane(table);
    add(pane, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    JFrame f= new JFrame("ToolTipHeaderTable Example");
    f.getContentPane().add(new ToolTipHeaderTableExample(), BorderLayout.CENTER);
    f.setSize(400, 100);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {System.exit(0);}
    });
  }
    
  class ToolTipHeader extends JTableHeader {
    String[] toolTips;
  
    public ToolTipHeader(TableColumnModel model) {
      super(model);
    }
    
    public String getToolTipText(MouseEvent e) {
      int col  = columnAtPoint(e.getPoint());
      int modelCol = getTable().convertColumnIndexToModel(col);
      String retStr;
      try {
        retStr = toolTips[modelCol];
      } catch (NullPointerException ex) {
        retStr = "";
      } catch (ArrayIndexOutOfBoundsException ex) {
        retStr = "";
      }
      if (retStr.length() < 1) {
        retStr = super.getToolTipText(e);
      }
      return retStr;
    }   
    
    public void setToolTipStrings(String[] toolTips) {
      this.toolTips = toolTips;
    } 
  }
}



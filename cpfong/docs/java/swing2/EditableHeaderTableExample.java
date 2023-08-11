/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import jp.gr.java_conf.tame.swing.table.*;


/**
 * @version 1.0 08/22/99
 */
public class EditableHeaderTableExample extends JFrame {

  public EditableHeaderTableExample(){
    super( "EditableHeader Example" );
    
    JTable table = new JTable(7, 5);
    TableColumnModel columnModel = table.getColumnModel();
    table.setTableHeader(new EditableHeader(columnModel));
    
    JScrollPane pane = new JScrollPane(table);
    getContentPane().add(pane);
  }

  public static void main(String[] args) {
    EditableHeaderTableExample frame = new EditableHeaderTableExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize( 300, 100 );
    frame.setVisible(true);
  }
}

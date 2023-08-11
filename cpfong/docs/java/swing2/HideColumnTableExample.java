/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import jp.gr.java_conf.tame.swing.panel.*;


/**
 * @version 1.0 05/31/99
 */
public class HideColumnTableExample extends JFrame {

  public HideColumnTableExample(){
    super( "HideColumnTable Example" );
    
    JTable table = new JTable(5, 7);
    ColumnButtonScrollPane pane = new ColumnButtonScrollPane(table);
    getContentPane().add(pane);
  }

  public static void main(String[] args) {
    HideColumnTableExample frame = new HideColumnTableExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize( 400, 100 );
    frame.setVisible(true);
  }
}

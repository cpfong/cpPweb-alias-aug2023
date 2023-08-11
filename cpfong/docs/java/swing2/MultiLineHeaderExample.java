/* (swing1.1beta3) */
//package jp.gr.java_conf.tame.swing.examples;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import jp.gr.java_conf.tame.swing.table.*;


/**
 * @version 1.0 11/09/98
 */
public class MultiLineHeaderExample extends JFrame {
  MultiLineHeaderExample() {
    super( "Multi-Line Header Example" );

    DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(new Object[][]{{"a","b","c"},
                                    {"A","B","C"}},
                     new Object[]{"1st\nalpha","2nd\nbeta","3rd\ngamma"});

    JTable table = new JTable( dm );
    MultiLineHeaderRenderer renderer = new MultiLineHeaderRenderer();
    Enumeration enum = table.getColumnModel().getColumns();
    while (enum.hasMoreElements()) {
      ((TableColumn)enum.nextElement()).setHeaderRenderer(renderer);
    }   
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    setSize( 400, 110 );
    setVisible(true);
  }

  public static void main(String[] args) {
    MultiLineHeaderExample frame = new MultiLineHeaderExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
  }
}
/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import jp.gr.java_conf.tame.swing.table.*;

/**
 * @version 1.1 09/09/99
 */
public class EachRowEditorExample extends JFrame {
  public EachRowEditorExample(){
    super("EachRow Editor Example");
       
    DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(
      new Object[][]{{"Name"  ,"MyName"},
                     {"Gender","Male"}},
      new Object[]{"Column1","Column2"});

    JTable table = new JTable(dm);
    JComboBox comboBox = new JComboBox();
    comboBox.addItem("Male");
    comboBox.addItem("Female");
    comboBox.addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent e) {
        final JComponent c = (JComponent)e.getSource();
        SwingUtilities.invokeLater(new Runnable() {
          public void run () {
            c.requestFocus();
            System.out.println(c);
            if (c instanceof JComboBox) {
              System.out.println("a");
            }
          }
        });
      }
    });

    EachRowEditor rowEditor = new EachRowEditor(table);
    rowEditor.setEditorAt(1, new DefaultCellEditor(comboBox));
    table.getColumn("Column2").setCellEditor(rowEditor);

    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add( scroll , BorderLayout.CENTER);
    setSize( 400, 100 );
    setVisible(true);
  }

  public static void main(String[] args) {
    EachRowEditorExample frame = new EachRowEditorExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
  }
}
  


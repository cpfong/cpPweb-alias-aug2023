/* (swing1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import jp.gr.java_conf.tame.swing.table.*;
import jp.gr.java_conf.tame.swing.border.*;

/**
 * @version 1.0  3/06/99
 */
public class ColumnBorderTableExample extends JFrame {

  public ColumnBorderTableExample() {
    super( "Column Border Example" );
        
    DefaultTableModel dm = new DefaultTableModel(4,10);
    JTable table = new JTable( dm );
    table.setIntercellSpacing(new Dimension(0,0));
    
    Color color = table.getGridColor();
    BorderCellRenderer[] renderers = new BorderCellRenderer[6];
    renderers[0] = createRenderer(color, new Insets(0,0,0,1));
    renderers[1] = createRenderer(color, new Insets(0,1,0,1));
    renderers[2] = createRenderer(color, new Insets(0,1,0,2));
    renderers[3] = createRenderer(color, new Insets(0,2,0,2));
    renderers[4] = createRenderer(color, new Insets(0,2,0,0));
    renderers[5] = createRenderer(Color.red, new Insets(0,1,1,1));
    
    TableColumnModel model = table.getColumnModel();
    model.getColumn(1).setCellRenderer(renderers[0]);
    model.getColumn(2).setCellRenderer(renderers[0]);
    model.getColumn(3).setCellRenderer(renderers[0]);
    model.getColumn(4).setCellRenderer(renderers[1]);
    model.getColumn(5).setCellRenderer(renderers[2]);
    model.getColumn(6).setCellRenderer(renderers[3]);
    model.getColumn(7).setCellRenderer(renderers[4]);
    model.getColumn(8).setCellRenderer(renderers[5]);
    
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add(scroll, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    ColumnBorderTableExample frame = new ColumnBorderTableExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
	System.exit(0);
      }
    });
    frame.setSize( 300, 120 );
    frame.setVisible(true);
  }
  
  private static BorderCellRenderer createRenderer(Color color, Insets insets) {
    BorderCellRenderer renderer = new BorderCellRenderer();
    renderer.setColumnBorder(new LinesBorder(color, insets));    
    return renderer;
  }  
}


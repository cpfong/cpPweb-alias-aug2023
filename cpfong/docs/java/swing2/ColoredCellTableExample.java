/*
 * (swing1.1beta3)
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

import jp.gr.java_conf.tame.swing.table.*;
import jp.gr.java_conf.tame.swing.colorchooser.*;



/**
 * @version 1.0 11/22/98
 */
public class ColoredCellTableExample extends JFrame {
  private JTable table;
  private ColoredCell cellAtt;

  public ColoredCellTableExample() {
    super( "Colored Cell Example" );    
    
    AttributiveCellTableModel ml = new AttributiveCellTableModel(10,6);
    cellAtt =(ColoredCell)ml.getCellAttribute();
    table = new JTable( ml );
    table.setCellSelectionEnabled(true);
    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    table.setDefaultRenderer(Object.class ,new AttributiveCellRenderer());
    JScrollPane scroll = new JScrollPane( table );

    JButton b_fore   = new JButton("Foreground");
    b_fore.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        changeColor(true);
      }
    });
    JButton b_back   = new JButton("Background");
    b_back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        changeColor(false);
      }
    });
    JPanel p_buttons = new JPanel();
    p_buttons.setLayout(new GridLayout(2,1));
    p_buttons.add(b_fore);
    p_buttons.add(b_back);
    Box box = new Box(BoxLayout.X_AXIS);
    box.add(scroll);
    box.add(new JSeparator(SwingConstants.HORIZONTAL));
    box.add(p_buttons);
    getContentPane().add( box );
    setSize( 400, 200 );
    setVisible(true);
  }
  
  private final void changeColor(boolean isForeground) {
    int[] columns = table.getSelectedColumns();
    int[] rows    = table.getSelectedRows();
    if ((rows == null) || (columns == null)) return;
    if ((rows.length<1)||(columns.length<1)) return;
    Color target    = cellAtt.getForeground(rows[0], columns[0]);
    Color reference = cellAtt.getBackground(rows[0], columns[0]);
    for (int i=0;i<rows.length;i++) {
      int row = rows[i];
      for (int j=0;j<columns.length;j++) {
	int column = columns[j];
	target    = (target    != cellAtt.getForeground(row, column)) ?
	  null : target;
	reference = (reference != cellAtt.getBackground(row, column)) ?
	  null : reference;
      }
    }
    String title;
    if (isForeground) {
      target    = (target   !=null) ? target    : table.getForeground();
      reference = (reference!=null) ? reference : table.getBackground();
      title = "Foreground Color";
    } else {
      target    = (reference!=null) ? reference : table.getBackground();
      reference = (target   !=null) ? target    : table.getForeground();
      title = "Foreground Color";
    }	
    TextColorChooser chooser =
      new TextColorChooser(target, reference, isForeground);
    Color color = chooser.showDialog(ColoredCellTableExample.this,title);
    if (color != null) {	
      if (isForeground) {
	cellAtt.setForeground(color, rows, columns);
      } else {
	cellAtt.setBackground(color, rows, columns);
      }
      table.clearSelection();
      table.revalidate();
      table.repaint();	  
    }
  }

  public static void main(String[] args) {
    ColoredCellTableExample frame = new ColoredCellTableExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
  }
}


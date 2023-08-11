/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @version 1.0 06/19/99
 */
public class AnimatedIconHeaderExample extends JFrame {

  public AnimatedIconHeaderExample(){
    super( "AnimatedIconHeader Example" );
    
    final Object[][] data =  new Object[][]{
      {"Leopard","Lycaon"},
      {"Jagur"  ,"Jackal"},
      {"Cheetah","Coyote"},
      {"Puma"   ,"Dingo" },
      {"Lynx"   ,"Fox"   },
      {"Tom"    ,"Hot"  }};
    final String[] column = new String[]{"Cat","Dog"};
    
    ImageIcon[] icons = {new ImageIcon("images/3-119.gif"),
                         new ImageIcon("images/3-6.gif")};
        
    AbstractTableModel model = new AbstractTableModel() {
      public int getColumnCount() { return column.length; }
      public int getRowCount()    { return data.length; }
      public String getColumnName(int col) {
       return column[col]; 
      }
      public Object getValueAt(int row, int col) { 
        return data[row][col]; 
      }
    };
        
    JTable table = new JTable( model );
    JTableHeader header = table.getTableHeader();
    JLabel renderer;
    for (int i=0;i<model.getColumnCount();i++) {
      renderer = (JLabel)table.getColumn(column[i]).getHeaderRenderer();
      renderer.setIcon(icons[i]);
      
      // If you have only one column.
      // icons[i].setImageObserver(header);
      
      icons[i].setImageObserver(new HeaderImageObserver(header, i));
    }
    JScrollPane pane = new JScrollPane(table);
    getContentPane().add(pane);
  }
    
  class HeaderImageObserver implements ImageObserver {
    JTableHeader header;
    int col;
      
    HeaderImageObserver(JTableHeader header, int col) {
      this.header = header;
      this.col    = col;
    }
    
    public boolean imageUpdate(Image img, int flags,
			       int x, int y, int w, int h) {
      if ((flags & (FRAMEBITS|ALLBITS)) != 0) {
        Rectangle rect = header.getHeaderRect(col);
        header.repaint(rect);
      }
      return (flags & (ALLBITS|ABORT)) == 0;
    }
  }    
  
  public static void main(String[] args) {
    AnimatedIconHeaderExample frame = new AnimatedIconHeaderExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setSize( 300, 140 );
    frame.setVisible(true);
  }
}

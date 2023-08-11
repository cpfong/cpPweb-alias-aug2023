/* (swing1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.border.*;
import jp.gr.java_conf.tame.swing.table.*;
import jp.gr.java_conf.tame.swing.border.*;

/**
 * @version 1.0  3/06/99
 */
public class CellBorderTableExample extends JFrame {

  public CellBorderTableExample() {
    super( "Cell Border Example" );
    
    final Color color = UIManager.getColor("Table.gridColor");
        
    DefaultTableModel dm = new DefaultTableModel(12,6) {
      public void setValueAt(Object obj, int row, int col) {
        if (obj instanceof MyData) {
          super.setValueAt(obj, row, col);
        } else {
          MyData myData=null;
          Object oldObject = getValueAt(row, col);
          if (oldObject == null) {
            myData = new MyData(obj, new LinesBorder(color,0));
          } else if (oldObject instanceof MyData) {
            myData = (MyData)oldObject;
          } else {
            System.out.println("error");
            return;
          }
          myData.setObject(obj);
          super.setValueAt(myData, row, col);
        }
      }
    };
    
    JTable table = new JTable( dm );
    table.setIntercellSpacing(new Dimension(0,0));
    table.setCellSelectionEnabled(true);
    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    table.setDefaultRenderer(Object.class, new BorderCellRenderer());

    JScrollPane scroll = new JScrollPane( table );
    ThicknessPanel thicknessPanel = new ThicknessPanel();
    Box box = new Box(BoxLayout.Y_AXIS);    
    box.add(thicknessPanel);
    box.add(new ButtonPanel(table, thicknessPanel));
    getContentPane().add(scroll, BorderLayout.CENTER);
    getContentPane().add(box,    BorderLayout.EAST);
  }

  public static void main(String[] args) {
    CellBorderTableExample frame = new CellBorderTableExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
	System.exit(0);
      }
    });
    frame.setSize( 400, 240 );
    frame.setVisible(true);
  }

  
  class ThicknessPanel extends JPanel {    
    JComboBox[] combos;
    
    ThicknessPanel() {
      String[] str = {"top","left","bottom","right"};
      int n = str.length;
      setLayout(new GridLayout(n,2));
      setBorder(new TitledBorder("Thickness"));
      combos = new JComboBox[n];
      for (int i=0;i<n;i++) {
        combos[i] = new JComboBox(new Object[]{"0","1","2","3"});
        add(new JLabel(str[i]));
        add(combos[i]);
      }
    }
     
    public Insets getThickness() {
      Insets insets = new Insets(0,0,0,0);
      insets.top    = combos[0].getSelectedIndex();      
      insets.left   = combos[1].getSelectedIndex();      
      insets.bottom = combos[2].getSelectedIndex();      
      insets.right  = combos[3].getSelectedIndex();      
      return insets;      
    }
  }

  
  class ButtonPanel extends JPanel {
    JTable table;
    ThicknessPanel thicknessPanel;
    Color color = UIManager.getColor("Table.gridColor");
    
    ButtonPanel(JTable table, ThicknessPanel thicknessPanel) {
      this.table = table;
      this.thicknessPanel = thicknessPanel;
      setLayout(new GridLayout(3,1));
      setBorder(new TitledBorder("Append Lines"));
      final JCheckBox oneBlock = new JCheckBox("Block");
      JButton b_and = new JButton("REPLACE");
      JButton b_or  = new JButton("OR");
      add(oneBlock);
      add(b_and);
      add(b_or);
      b_and.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setCellBorder(true, oneBlock.isSelected());
        }
      });
      b_or.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setCellBorder(false, oneBlock.isSelected());
        }
      });
    }  
    
    private void setCellBorder(boolean isReplace, boolean isBlock) {
      boolean isTop,isLeft,isBottom,isRight;
      Insets insets = thicknessPanel.getThickness();
      int[] columns = table.getSelectedColumns();
      int[] rows    = table.getSelectedRows();
      int rowMax    = rows.length;
      int columnMax = columns.length;
      
      for (int i=0;i<rowMax;i++) {
        int row = rows[i];
        isTop    = (i == 0       )? true: false;
        isBottom = (i == rowMax-1)? true: false;
        
        for (int j=0;j<columnMax;j++) {
	  int column = columns[j];
          isLeft  = (j == 0          )? true: false;
          isRight = (j == columnMax-1)? true: false;
          
	  MyData myData = (MyData)table.getValueAt(row, column);
	  if (myData == null) {
	    myData = new MyData("", new LinesBorder(color,0));
	  }
	  LinesBorder border = (LinesBorder)myData.getBorder();
	  
	  if (isBlock) {
	    Insets tmp = new Insets(0,0,0,0);
	    if (isTop)    tmp.top    = Math.max(tmp.top    ,insets.top);
	    if (isLeft)   tmp.left   = Math.max(tmp.left   ,insets.left);
	    if (isBottom) tmp.bottom = Math.max(tmp.bottom ,insets.bottom);
	    if (isRight)  tmp.right  = Math.max(tmp.right  ,insets.right);
	    border.append(tmp, isReplace);
	  } else {
	    border.append(insets, isReplace);
	  }
	  
	  table.setValueAt(myData, row, column);
	}
      }
      table.clearSelection();
      table.revalidate();
      table.repaint();
    }  
  }

  
  class MyData implements CellBorder {
    private Border border;
    private Object obj;
    
    public MyData(Object obj, Border border) {
      this.obj    = obj;
      this.border = border;
    }
    
    public void setObject(Object obj) {
      this.obj = obj;
    }    
    public String toString() {
      return obj.toString();
    }
    
    // CellBorder   
    public void setBorder(Border border) {
      this.border = border;
    }   
    public Border getBorder() {
      return border;
    }
    public void setBorder(Border border, int row, int col) {}
    public Border getBorder(int row, int col) { return null; }
  }
}


/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @version 1.0 08/27/98
 */
public class ToolTipLocationExample extends JFrame {
  public ToolTipLocationExample() {
    super("ToolTip Location Example");
      
    // above position
    JButton buttonAbove = new JButton ("Above") {
      public Point getToolTipLocation(MouseEvent e) {
        return new Point(20, -30);        
      }
    };
    buttonAbove.setToolTipText("Hello world");
    
    // blow (default) position
    JButton buttonBelow = new JButton ("Below");
    buttonBelow.setToolTipText("Hello world");
    
    // whatever
    final RelocatableToolTipButton buttonRelocate =
            new RelocatableToolTipButton ("Relocate");
    buttonRelocate.setToolTipText("Hello world");
    buttonRelocate.addActionListener(new ActionListener() {  
      JPanel messagePanel = createPanel();   
      JTextField locationX, locationY; 
      
      public void actionPerformed(ActionEvent e) {
        Point p = buttonRelocate.getToolTipLocation(null);
        if (p == null) {
          locationX.setText("default");
          locationY.setText("default");
        } else {
          locationX.setText(Integer.toString(p.x));
          locationY.setText(Integer.toString(p.y));
        }
        int result = JOptionPane.showOptionDialog(ToolTipLocationExample.this,
                                   messagePanel,
                                   "Location", 
                                   JOptionPane.OK_CANCEL_OPTION,
                                   JOptionPane.QUESTION_MESSAGE,
                                   null,null,null);
        if (result == JOptionPane.OK_OPTION) {
          try {
            int x = Integer.parseInt(locationX.getText());
            int y = Integer.parseInt(locationY.getText());
            buttonRelocate.setToolTipLocation(new Point(x,y));
          } catch (NumberFormatException ex) {
            ex.printStackTrace();
          }
        }
      }
      
      private JPanel createPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        p.add(new JLabel("  X: "));
        p.add(locationX = new JTextField());
        p.add(new JLabel("  Y: "));
        p.add(locationY = new JTextField());
        return p;
      }
    });
    
    JPanel panel = new JPanel();
    panel.add(buttonAbove);
    panel.add(buttonBelow);
    panel.add(buttonRelocate);
    Container c = getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS)); 
    c.add(Box.createVerticalStrut(30));
    c.add(panel);
  }
  
  class RelocatableToolTipButton extends JButton {
    Point toolTipLocation;
    
    RelocatableToolTipButton(String label) {
      super(label);
      toolTipLocation = null;
    }
    
    public Point getToolTipLocation(MouseEvent e) {
      return toolTipLocation;        
    }
    
    public void setToolTipLocation(Point location) {
      toolTipLocation = location;        
    }
  }

  public static void main (String args[]) {
    ToolTipLocationExample frame = new ToolTipLocationExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    frame.setSize (300, 130);
    frame.setVisible(true);
  }
}

/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @version 1.0 10/4/99
 */  
public class SliderWithToolTipExample extends JFrame {
  public SliderWithToolTipExample() {
    super("Mad Level");  
    
    JSlider s = new JSlider(JSlider.VERTICAL, 0, 120, 60) {
      String[] tooltips = {"Call 911",
                           "Seeing red",
                           "Really mad",
                           "Ticked off",
                           "Slightly peeved",
                           "Oh bother",
                           "Feel good"};
            
      public String getToolTipText(MouseEvent e) {
        Point p = e.getPoint();
        Rectangle rect = new Rectangle();
        rect = getBounds(rect);
        int n = getLabelTable().size();
        int index = n * p.y / rect.height;
        return tooltips[index];
      }
    };
    
    s.setPaintTicks(true);
    s.setMajorTickSpacing(20);
    s.setPaintLabels( true );
    s.putClientProperty( "JSlider.isFilled", Boolean.TRUE ); 
        
    s.setToolTipText("");
    
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(s);
  }

  public static void main (String args[]) {
    SliderWithToolTipExample f = new SliderWithToolTipExample();
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    f.setSize (120, 250);
    f.show();
  }
}

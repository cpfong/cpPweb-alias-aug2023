/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jp.gr.java_conf.tame.swing.slider.*;

/**
 * @version 1.0 9/3/99
 */  
public class MThumbSliderExample1 extends JFrame {
  public MThumbSliderExample1() {
    super("MThumbSlider Example");  
    
    JSlider slider = new JSlider();
    
    int n = 2;
    MThumbSlider mSlider = new MThumbSlider(n);
    mSlider.setValueAt(25, 0);                        
    mSlider.setValueAt(75, 1); 
    
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(slider);
    getContentPane().add(mSlider);
  }

  public static void main (String args[]) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    } catch (Exception ex) {
      System.err.println("Error loading L&F: " + ex);
    }

    MThumbSliderExample1 f = new MThumbSliderExample1();
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	System.exit(0);
      }
    });
    f.setSize (300, 80);
    f.show();
  }
}

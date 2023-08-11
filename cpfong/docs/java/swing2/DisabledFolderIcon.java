// DisabledLeafIcon.java
// (swing1.1.1beta2)
package jp.gr.java_conf.tame.swing.icon;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;


/**
 * @@version 1.0 04/28/99
 */
public class DisabledFolderIcon implements Icon {
  int width  = 16;
  int height = 16;
  int additionalHeight = 2;
 
  public void paintIcon(Component c, Graphics g, int x, int y) {
    int right  = width  - 1;
    int bottom = height - 2;

    g.setColor(c.getBackground());
    g.fillRect(0,0, width, getIconHeight());
    
    // Draw tab
    g.setColor( MetalLookAndFeel.getControlDisabled() );
    g.drawLine( right -5, 2, right   , 2 );
    g.drawLine( right -6, 3, right -6, 4 );
    g.drawLine( right   , 3, right   , 4 );

    // Draw outline
    g.setColor( MetalLookAndFeel.getControlDisabled() );
    g.drawLine(        0,      5,        0, bottom );  // left side
    g.drawLine(        1,      4, right -7,      4 );  // first part of top
    g.drawLine( right -6,      5, right -1,      5 );  // second part of top
    g.drawLine( right   ,      4, right   , bottom );  // right side
    g.drawLine(        0, bottom, right   , bottom );  // bottom
  }
  
  public int getIconWidth()  { return width; }
  public int getIconHeight() { return height + additionalHeight; } 
}

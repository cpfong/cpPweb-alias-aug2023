/* (swing1.1beta3) */
package jp.gr.java_conf.tame.swing.tooltip;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.0 11/09/98
 */

public class MultiLineToolTip extends JToolTip {
  public MultiLineToolTip() {  
    setUI(new MultiLineToolTipUI());
  }
}


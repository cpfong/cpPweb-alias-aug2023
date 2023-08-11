import java.awt.Graphics;
import javax.swing.JApplet;

public class fig5_1 extends JApplet {
	public void paint (Graphics g) {
		int c = 1;
		
		while (c <= 10) {
			g.drawLine(10,10,250,c * 10);
			c++;
		}
	}
}

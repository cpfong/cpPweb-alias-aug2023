import java.awt.Graphics;
import javax.swing.JApplet;

public class fig5_2 extends JApplet{
	public void paint (Graphics g) {
		int i;

		for (i = 0; i < 10; i++){
			g.drawLine(10,10,250, i * 10);
		}
	}
}

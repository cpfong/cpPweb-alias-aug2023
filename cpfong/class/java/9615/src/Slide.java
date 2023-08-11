import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*; 

public class Slide extends JFrame implements ChangeListener {

	private JSlider sliderH, sliderV;
	private JButton b;
	private int x, y;

	public static void main (String[] args) {
		Slide frame = new Slide();
		frame.setSize(300, 200);
		frame.createGUI();
		frame.setVisible(true);
	}

	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout() );

		sliderH = new JSlider(JSlider.HORIZONTAL, 0, 200, 0);window.add(sliderH);
		sliderH.addChangeListener(this);

		sliderV = new JSlider(JSlider.VERTICAL  , 0, 100, 0);window.add(sliderV);
		sliderV.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
			x = sliderH.getValue();
			y = sliderV.getValue();
			repaint();
	}

        public void paint( Graphics g ){
		super.paint(g);
		g.drawOval( x, y, 50, 50);
        }
}

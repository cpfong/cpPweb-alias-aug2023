import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*; 

public class Slide2 extends JFrame implements ChangeListener {

	private JSlider sliderH, sliderV;
	private JPanel panel;

	public static void main (String[] args) {
		Slide2 frame = new Slide2();
		frame.setSize(400, 300);
		frame.createGUI();
		frame.setVisible(true);
	}

	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout() );

		sliderV = new JSlider(JSlider.VERTICAL  , 0, 100, 0);
		window.add(sliderV);sliderV.addChangeListener(this);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,150)); 
		panel.setBackground(Color.white);window.add(panel);

		sliderH = new JSlider(JSlider.HORIZONTAL, 0, 200, 0);
		window.add(sliderH);sliderH.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		int x, y;

		x = sliderH.getValue();
		y = sliderV.getValue();
		
		Graphics p = panel.getGraphics();
		p.setColor(Color.white);p.fillRect(0,0,200,150);
		p.setColor(Color.black);p.drawOval(x,y,20,20);
	}
}

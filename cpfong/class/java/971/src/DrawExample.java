import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawExample extends JFrame implements ActionListener {
	private JButton but;
	private JPanel  pan;
	
	public static void main(String[] args){
		DrawExample frame = new DrawExample();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}
	
	private void createGUI(DrawExample mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		pan =new JPanel();  pan.setPreferredSize(new Dimension(120,80));
		pan.setBackground(Color.white); mw.add(pan );

		but =new JButton("Draw Line");mw.add(but ); but.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e){
		Graphics paper  =  pan.getGraphics();
		paper.drawLine  (0 ,  0, 50, 50);
	}
}

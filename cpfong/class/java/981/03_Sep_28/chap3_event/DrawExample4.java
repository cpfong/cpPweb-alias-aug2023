import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawExample4 extends JFrame implements ActionListener {
	private JButton but,but2,but3;
	private JPanel  pan,pan2,pan3,pan4,pan5;
	
	public static void main(String[] args){
		DrawExample4 frame = new DrawExample4();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}
	
	private void createGUI(DrawExample4 mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		pan =new JPanel();  pan.setPreferredSize(new Dimension(120,80));
		pan2=new JPanel(); pan2.setPreferredSize(new Dimension(120,80));
		pan3=new JPanel(); pan3.setPreferredSize(new Dimension(120,80));
		pan4=new JPanel(); pan4.setPreferredSize(new Dimension(120,80));
		pan5=new JPanel(); pan5.setPreferredSize(new Dimension(120,80));

		 pan.setBackground(Color.white); mw.add(pan );
		pan2.setBackground(Color.white); mw.add(pan2);
		pan3.setBackground(Color.white); mw.add(pan3);
		pan4.setBackground(Color.white); mw.add(pan4);
		pan5.setBackground(Color.white); mw.add(pan5);

		but =new JButton("Draw Line");mw.add(but ); but.addActionListener(this);
		but2=new JButton("Draw Oval");mw.add(but2);but2.addActionListener(this);
		but3=new JButton("Draw Rect");mw.add(but3);but3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == but) {
			Graphics paper  =  pan.getGraphics();
			Graphics paper4 = pan4.getGraphics();
			 paper.drawLine  (0 ,  0, 50, 50);
			paper4.drawString("Strg", 50, 50);
		}
		if (e.getSource() == but2) {
			Graphics paper2 = pan2.getGraphics();
			Graphics paper3 = pan3.getGraphics();
			paper2.drawOval  (40, 40, 40, 30);
			paper3.drawRect  (20, 20, 40, 30);
		}
		if (e.getSource() == but3) {
			Graphics paper5 = pan5.getGraphics();
			paper5.drawRect  (10, 10, 50, 40);
		}
	}
}

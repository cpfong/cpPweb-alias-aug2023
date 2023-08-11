import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawExample4 extends JFrame implements ActionListener {
	private JButton house, well;
	private JPanel  pan,pan2;
	
	public static void main(String[] args){
		DrawExample4 frame = new DrawExample4();
		frame.setSize(300,200);
		frame.createGUI(frame);
		frame.setVisible(true);
	}
	
	private void createGUI(DrawExample4 mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		pan =new JPanel();  pan.setPreferredSize(new Dimension(120,80));
		pan2=new JPanel(); pan2.setPreferredSize(new Dimension(120,80));

		 pan.setBackground(Color.white); mw.add(pan );
		pan2.setBackground(Color.white); mw.add(pan2);

		house =new JButton("House"  );mw.add(house); house.addActionListener(this);
		well  =new JButton("4 lines");mw.add(well );  well.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == house) {
			Graphics paper  =  pan.getGraphics();
			 paper.drawLine(60, 0,  0, 30);
			 paper.drawLine(60, 0,120, 30);
			 paper.drawLine( 0,30,120, 30);
			 paper.drawRect( 0,30,119, 40);
		}
		else {
			Graphics paper2 = pan2.getGraphics();
			 paper2.drawLine(10, 20, 70, 20);
			 paper2.drawLine(10, 40, 70, 40);
			 paper2.drawLine(30, 10, 30, 60);
			 paper2.drawLine(50, 10, 50, 60);
		}
	}
}

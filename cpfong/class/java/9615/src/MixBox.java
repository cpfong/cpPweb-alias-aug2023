import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MixBox extends JFrame implements ActionListener {
	private JButton house, well;
	private JPanel  pan,pan2;
	
	public static void main(String[] args){
		MixBox frame = new MixBox();
		frame.setSize(300,200);
		frame.createGUI(frame);
		frame.setVisible(true);
	}
	
	private void createGUI(MixBox mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		pan =new JPanel();  pan.setPreferredSize(new Dimension(220,180));
		pan.setBackground(Color.white); mw.add(pan );
		house =new JButton("µe½Õ¦â½L"); mw.add(house); house.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
			Graphics paper  =  pan.getGraphics();
			paper.setColor(Color.red	);paper.fillRect( 30,100,30,20);
			paper.setColor(Color.cyan	);paper.fillRect( 60,100,30,20);
			paper.setColor(Color.gray	);paper.fillRect( 90,100,30,20);
			paper.setColor(Color.lightGray	);paper.fillRect(120,100,30,20);
			paper.setColor(Color.orange	);paper.fillRect(150,100,30,20);
	}
}

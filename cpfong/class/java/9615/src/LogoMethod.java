import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogoMethod extends JFrame implements ActionListener {
	private JButton but;
	private JPanel pan;

	public static void main(String[] args){
		LogoMethod frame = new LogoMethod();
		frame.setSize(350, 300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(LogoMethod mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());
		pan = new JPanel();
		pan.setPreferredSize(new Dimension(300,200));
		pan.setBackground(Color.white);
		mw.add(pan);

		but = new JButton("Press me");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		Graphics paper = pan.getGraphics();
		drawLogo(paper, 10, 20);
		drawLogo(paper, 100, 100);
		drawLogo(paper, 200,20);
	}
	
	private void drawLogo(Graphics da, int x, int y){
		da.drawRect(x,y,60,60);
		da.drawRect(x,y,40,40);
		da.drawRect(x,y,20,20);
	}
}

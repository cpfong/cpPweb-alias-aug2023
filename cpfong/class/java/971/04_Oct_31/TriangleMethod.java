import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TriangleMethod extends JFrame implements ActionListener {
	private JButton but;
	private JPanel pan;

	public static void main(String[] args){
		TriangleMethod frame = new TriangleMethod();
		frame.setSize(350, 300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(TriangleMethod mw){
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
		drawTriangle(paper, 100, 10, 40, 40);
		drawTriangle(paper,  10,100, 20, 60);
	}
	
	private void drawLogo(Graphics da, int x, int y){
		da.drawRect(x,y,60,60);
		da.drawRect(x,y,40,40);
		da.drawRect(x,y,20,20);
	}

	private void drawTriangle(Graphics da, int x, int y, int w, int h){
		int x2=x+w, y2=y+h;

		da.drawLine(x,  y, x, y2);
		da.drawLine(x, y2,x2, y2);
		da.drawLine(x,  y,x2, y2);
	}
}


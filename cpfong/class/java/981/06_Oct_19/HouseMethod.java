import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HouseMethod extends JFrame implements ActionListener {
	private JButton but;
	private JPanel pan;

	public static void main(String[] args){
		HouseMethod frame = new HouseMethod();
		frame.setSize(350, 300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(HouseMethod mw){
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
		drawHouse(paper, 10,20, 70, 20);
	}
	
	private void drawLogo(Graphics da, int x, int y){
		da.drawRect(x,y,60,60);
		da.drawRect(x,y,40,40);
		da.drawRect(x,y,20,20);
	}
	private void drawHouse(Graphics da, int topRoofx, int topRoofy, int width, int height){
	  	drawTriangle(da, topRoofx, topRoofy, height, width, height);
		da.drawRect(topRoofx, topRoofy+height, width, height);
	}

	private void drawTriangle(Graphics da, int x, int y, int w, int h){
		int x2=x+w, y2=y+h;

		da.drawLine(x,  y, x, y2);
		da.drawLine(x, y2,x2, y2);
		da.drawLine(x,  y,x2, y2);
	}
}

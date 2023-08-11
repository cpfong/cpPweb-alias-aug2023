import java.awt.*;
import javax.swing.*;

public class BBall{
	private JPanel panel;
	private int x = 7, xChange = 7;
	private int y = 0, yChange = 2;
	private int diameter = 10;
	private int width=100, height=100;

	public void BBall(JPanel thePanel){
		panel=thePanel;
	}

	public void animate(){
		ddelete();
		move();
		bounce();
		draw();
	}

	private void move(){
		x = x+xChange;
		y = y+yChange;
	}

	private void bounce(){
		if (x <=0 || x >= width){
			xChange = -xChange;
		}
		if (y <=0 || y >= height){
			yChange= -yChange; 
		}
	}

	private void draw(){
		Graphics paper = panel.getGraphics();
		paper.setColor(Color.red);
		paper.fillOval(x,y,diameter,diameter);
	}
		
	private void ddelete(){
		Graphics paper=panel.getGraphics();
		paper.setColor(Color.white);
		paper.fillOval(x,y,diameter,diameter);
	}
}

import java.awt.Graphics;
import java.awt.*;

public class Balloon implements BalloonInterface{
	private int diameter, x, y;

	public void changeSize(int newDiameter){ diameter=newDiameter; }
	public int getX(){ return x; }
	public void setX(int newX){ x=newX; }
	public void display(Graphics paper){
		paper.setColor(Color.black);
		paper.fillOval(x,y,diameter,diameter);
	}
}

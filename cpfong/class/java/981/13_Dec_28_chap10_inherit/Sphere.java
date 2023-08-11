import java.awt.*;

public class Sphere {
	protected int x=100, y=100;
	public void setX(int newX){ x=newX; }
	public void setY(int newY){ y=newY; }
	public void display(Graphics paper){ paper.drawOval(x,y,20,20); }
}

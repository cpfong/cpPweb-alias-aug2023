import java.awt.*;

public class Balloon{
	private int x;
	private int y;
	private int diameter;

	public void moveRight(int xStep){ x=x+xStep; }
	public void changeSize(int change) { diameter+=change; }
	public void display(Graphics paper){
		paper.setColor(Color.black);
		paper.drawOval(x,y,diameter,diameter);
	}
	public Balloon(int initX, int initY, int initD){ x=initX; y=initY; diameter=initD; } 
	public Balloon(int initX, int initY           ){ x=initX; y=initY; diameter=20;    } 
	public Balloon(                               ){ x=50   ; y=50   ; diameter=20;    }
}

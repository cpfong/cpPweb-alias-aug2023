import java.awt.*;

public class Bubble extends Sphere{
  protected int radius=10;
  public void setSize(int size){ radius=size; }
  public void display(Graphics p){p.drawOval(x,y,2*radius, 2*radius);}
}

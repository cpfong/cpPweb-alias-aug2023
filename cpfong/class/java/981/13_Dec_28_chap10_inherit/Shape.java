import java.awt.*;
public abstract class Shape{
  protected int x,y;
  protected int size;
  public void moveRight(){ x+=10; }
  public abstract void display(Graphics p);
}

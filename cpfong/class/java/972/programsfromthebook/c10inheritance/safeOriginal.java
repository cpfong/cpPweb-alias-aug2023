import java.awt.*;

public class Sphere {

    protected int x = 100, y = 100;

    public int setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void display(Graphics paper) {
        paper.drawOval(x, y, 20, 20);
    }

}


class Bubble extends Sphere {

    protected int radius = 10;

    public void setSize(int size) {
            radius = size;
        }

    public void display(Graphics paper) {
        paper.drawOval(x, y,
                             2 * radius, 2 * radius);
    }

    public void moveLeft(int amount) {
        x = x - amount;
    }

    public void moveRight(int amount) {
        x = x + amount;
    }

}

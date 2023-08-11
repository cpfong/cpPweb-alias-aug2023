import java.awt.*;

public class Balloon {

    private int x = 50;
    private int y = 50;
    private int diameter = 20;

    public void moveRight(int xStep) {
        x = x + xStep;
    }

    public void changeSize(int change) {
        diameter = diameter + change;
    }

    public void display(Graphics paper) {
        paper.setColor(Color.black);
        paper.drawOval(x, y, diameter, diameter);
    }
}

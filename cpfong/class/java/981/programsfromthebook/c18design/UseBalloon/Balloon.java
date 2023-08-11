import java.awt.*;
import javax.swing.*;

public class Balloon {

    private int x = 10;
    private int y = 10;
    private int radius = 20;
    private int yStep = 20;

    public void moveUp() {
        y = y - yStep;
    }

    public void moveDown() {
        y = y + yStep;
    }

    public void display(JPanel panel) {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.white);
        paper.fillRect(0, 0, 150, 150);
        paper.setColor(Color.black);
        paper.drawOval(x, y, radius * 2, radius * 2);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }
}


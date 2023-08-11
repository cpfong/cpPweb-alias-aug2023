import java.awt.*;

public class Balloon {

    protected int x, y, radius; 

    public Balloon() {
        x = 10;
        y = 10;
        radius = 20;
    }

    public Balloon(int initialX, int initialY,
                       int initialRadius) {
        x = initialX;
        y = initialY;
        radius = initialRadius;
    }

    // remainder of class

}

class ModifiedBalloon extends Balloon {

    public ModifiedBalloon(int initialX, int initialY,
                            int initialRadius) {
        super(initialX, initialY, initialRadius);
    }

	// remainder of class

}

class ColoredSphere extends Sphere {

    private Color color; 

    public ColoredSphere(Color initialColor) {
        color = initialColor;
    }
}

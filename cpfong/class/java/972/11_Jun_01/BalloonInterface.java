//
// note: no class keyword has been showed
// method (changSize) not declared as public since it is be default
//
import java.awt.*;

public interface BalloonInterface {
	void changeSize(int newDiameter);
	//void changSize(int newDiameter);

	int getX();
	//same as public int getX();
	void setX(int x);
	void display(Graphics paper);
}

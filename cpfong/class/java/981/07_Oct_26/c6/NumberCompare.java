import java.util.*;

public class NumberCompare{
	public static void main(String args[]){
		Random r = new Random();
		int i, x, y;

		for (i=0; i<10; i++){
			x = r.nextInt(2);y = r.nextInt(2);
			if (x>y)     { System.out.println("x=" + x + ",y=" + y + " 1st one is bigger"); }
			else if (x<y){ System.out.println("x=" + x + ",y=" + y + " 2nd one is bigger"); }
			else         { System.out.println("x=" + x + ",y=" + y + " equal"); }
		}
	}
}

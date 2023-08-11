import java.awt.*;
import java.text.*;

public class Hello2{
	public static void main(String[] args){
		// for the detail, pls check text book p11-6
		double a=1.23, b=22.1, c=123.111;

		DecimalFormat f = new DecimalFormat("000.00"); // filled with 0
		System.out.println("$" + f.format(a));
		System.out.println("$" + f.format(b));
		System.out.println("$" + f.format(c));

		System.exit(0);
	}
}

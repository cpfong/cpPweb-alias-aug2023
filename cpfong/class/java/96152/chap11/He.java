import java.awt.*;
import java.text.*;

public class He{
	public static void main(String[] args){
		int i=123;
		double ff=12.345;
		String xx="this is a test";

		DecimalFormat f1 = new DecimalFormat("##.##");
		DecimalFormat f2 = new DecimalFormat("$00.00");
		if (f1.equals(f2)){
			System.out.println("f1 = f2");
		}
		else {
			System.out.println("f1,f2 are different");
		}

		System.out.println(f1.format(ff));
		System.out.println(f2.format(ff));
		System.exit(0);
	}
}

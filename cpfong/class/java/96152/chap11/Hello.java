import java.awt.*;
import java.text.*;

public class Hello{
	public static void main(String[] args){
		// for the detail, pls check text book p11-6
		double fx=12.34;
		int i=1234;
		DecimalFormat f = new DecimalFormat("00000"); // filled with 0
		System.out.println(f.format(i));

		DecimalFormat ff = new DecimalFormat("###"); // digit, no filling
		System.out.println(ff.format(i));

		DecimalFormat ff2 = new DecimalFormat("###,###"); // with grp separator
		System.out.println(ff2.format(i));

		DecimalFormat ff3 = new DecimalFormat("##.#"); // with grp separator
		System.out.println(ff3.format(fx));

		System.exit(0);
	}
}

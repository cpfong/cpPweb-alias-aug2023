import java.util.*;
import java.awt.*;

public class Hello2 {
	public static void main(String[] args){
		Random  r =new Random();
		double d1 =r.nextDouble();
		double d2 =r.nextDouble();
		if (d1 >= d2){
			System.out.println(""+d1 + ">=" + d2);
		}
		else {
			System.out.println(""+d1 + "<"  + d2);
		}
		System.exit(0);
	}
}

import java.awt.*;
import java.util.*;

public class Ex11_7{
	public static void main(String[] args){
	  	Random random = new Random();

		int i, c0=0, c1=0;
		for (i=0; i<100; i++){
		  	int number=random.nextInt(2);
			if (number == 0){
			  	c0++;
			}
			else c1++;
		}
		System.out.println("0=" + c0 + " 1=" + c1);
		System.exit(0);
	}
}


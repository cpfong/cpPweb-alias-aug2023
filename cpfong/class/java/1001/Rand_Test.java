import java.awt.*;
import java.io.*;
import java.util.*;

public class Rand_Test {
	public static void main(String[] args){
		Rand_Test o = new Rand_Test();    
		Random r = new Random();
		int i, x;

		for (i=0; i<5; i++){
		  x=r.nextInt(3);
		  System.out.println(x);
		}
		System.exit(0);
	}
} // end class

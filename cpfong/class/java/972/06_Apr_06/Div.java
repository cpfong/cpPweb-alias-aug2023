import java.io.*;

public class Div{
	public static void main(String args[]){
		int i, j;
		
		for (i=0; i<2; i++){
			try {
				j=i/(i-1);
				System.out.println("" + j);
			}
			catch (ArithmeticException e){
				System.out.println("div by zero");
			}
		}
	}
}

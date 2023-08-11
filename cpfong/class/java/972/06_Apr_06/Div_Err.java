import java.io.*;

public class Div_Err{
	public static void main(String args[]){
		int i, j;
		
		for (i=0; i<2; i++){
				j=i/(i-1);
				System.out.println("" + j);
		}
	}
}

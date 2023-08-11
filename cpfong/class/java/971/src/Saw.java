import java.awt.*;
import java.io.*;

public class Saw{
	public static void main(String[] args){

		int i,j,k;

		for (i=0; i<3; i++){ 
			for (j=0; j<4; j++){
				for (k=0; k<=j; k++){
					System.out.print("s");
				}
				System.out.print("\n"); 
			}
			System.out.print("\n");
		}
		System.exit(0);
	}
}

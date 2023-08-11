import java.awt.*;
import java.io.*;

public class Read_From_STD_IO_Sub {
	public static void main(String[] args){
		int in=0, in2=0;
		Read_From_STD_IO_Sub o = new Read_From_STD_IO_Sub();    

		System.out.println("Width: ");
		in=o.r_in();

		System.out.println("Height: ");
		in2=o.r_in();

		System.out.println("Area=" + in * in2);
		System.exit(0);
	}

	private int r_in(){
	  	int in=0;
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		return(in);
	}
} // end class

import java.awt.*;
import java.io.*;

public class Read_From_STD_IO_Test {
	public static void main(String[] args){
		int in=0;

		System.out.println("由 STDIO 輸入整數:  ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		System.out.println("ok, 您輸入了: " + in);
		System.exit(0);
	}
}


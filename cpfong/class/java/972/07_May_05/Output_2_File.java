import java.util.*;
import java.io.*;

public class Output_2_File{
	public static void main(String args[]){
		Output_2_File t = new Output_2_File();
		t.r();
	}

	private void r(){
		String line ="";	
		Output_2_File t = new Output_2_File();

      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			while ((line = br.readLine())!= null){
				r.w(line);
			} // end while
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
	} // end r

	private void w(String l){
		PrintWriter o = new PrintWriter();;
		o = new PrintWriter("xxx");
		o.print(l);
		o.close();
	}
	
} // end class

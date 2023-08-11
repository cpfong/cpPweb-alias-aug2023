import java.awt.*;
import java.io.*;

public class Bool_Testing{
	public static void main(String[] args){
		boolean again=false;
		String thisline="";

		System.out.println("你還想再玩乙次否:  ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			thisline=br.readLine(); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read in!"); 
			System.exit(1); 
		} 

		if (thisline.equals("yes") || thisline.equals("y") || thisline.equals("Yes") || thisline.equals("Y")){
			again=true;
		}

		System.out.println("again is " + again);
		System.exit(0);
	}
}


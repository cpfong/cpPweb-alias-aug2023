import java.awt.*;
import java.io.*;

public class While_1_to_10{
	private static String thisline="";
	public static void main(String[] args){
		While_1_to_10 o = new While_1_to_10();
		boolean again=false;

		System.out.println("你還想再玩乙次否:  ");
		o.read_in_ans();

		while (thisline.equals("y")){
			System.out.println("again...");
			System.out.println("你還想再玩乙次否:  ");
			o.read_in_ans();
		}

		System.out.println("The End");
		System.exit(0);
	}

	private void read_in_ans(){
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			thisline=br.readLine(); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read in!"); 
			System.exit(1); 
		} 
	}
}

import java.io.*;
import javax.swing.*;
import java.util.*;

public class Mid2 {
	static String names[] = new String[20];
	static String ids[]   = new String[20];

	public static void main(String args[]){
		Mid2 m = new Mid2();

		for (int i=0; i<3; i++){
			System.out.println("name pls");names[i]=m.readStuffIn();
			System.out.println("id   pls");ids  [i]=m.readStuffIn();
		}
		ids[3]="END";
		m.find();
	} // end main

	private String readStuffIn(){
		String in="";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			in = br.readLine();
		} catch (IOException ioe) {
                                System.out.println("IO error trying to read your name!");
		}
		return in;
	} // end readStuffIn

	private void find(){
		int index;
		String wanted;

		System.out.println("finding id is ");
		wanted=readStuffIn();
		index=0;
		for (index=0; !(ids[index].equals(wanted)) && !(ids[index].equals("END")); index++){
		}

		if (ids[index].equals(wanted)){
			System.out.println("names is " + names[index]);
		}
		else {
			System.out.println("id not found");
		}
	}
}

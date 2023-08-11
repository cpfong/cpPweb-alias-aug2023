import java.io.*;
import javax.swing.*;
import java.util.*;

public class Mid5 {
	public static void main(String args[]){
		Mid5 m = new Mid5();
		String st = "";

		System.out.println("please input a number:");
		st = m.readStuffIn();
		int n = st.indexOf(".");
		if (n != -1){
			System.out.println("float");
		}
		else {
			System.out.println("integer");
		}
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
}

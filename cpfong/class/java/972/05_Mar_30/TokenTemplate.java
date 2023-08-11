import java.io.*;
import java.util.*;

public class TokenTemplate{
	public static void main(String args[]){
                System.out.println("input Date: ");

		TokenTemplate t = new TokenTemplate();
		String s = t.readin();
		StringTokenizer arr = new StringTokenizer(s, "/");
		int yr=Integer.parseInt(arr.nextToken());
		int mo=Integer.parseInt(arr.nextToken());
		int dy=Integer.parseInt(arr.nextToken());
		System.out.println("year=" + yr + " month=" + mo);

		StringTokenizer arr2 = new StringTokenizer(s, "/");
		while (arr2.hasMoreTokens()){
			System.out.print(arr2.nextToken());
		}
	}

	private String readin(){
		String in = "";

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
                try { 
                        in = br.readLine(); 
                } catch (IOException ioe) { 
                        System.out.println("IO error trying to read"); 
                        System.exit(1); 
                } 
		return(in);
	}
}

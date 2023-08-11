import java.io.*;
import java.util.*;

public class SumSomeInteger{
	public static void main(String args[]){
                System.out.println("input Integers: ");

		SumSomeInteger t = new SumSomeInteger();
		String s = t.readin();

		int a[]= new int[100];
		int i=0;
		StringTokenizer arr = new StringTokenizer(s, " ");
		while (arr.hasMoreTokens()){
			a[i++]=Integer.parseInt(arr.nextToken());
		}

		int sum=0;
		for (int j=0; j < i; j++){
			sum += a[j];
		}

		System.out.println("sum = " + sum );
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


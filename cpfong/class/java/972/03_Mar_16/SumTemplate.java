import java.io.*;

public class SumTemplate{
	public static void main(String[] args){
		int sale[]=new int[7];

		SumTemplate s=new SumTemplate();
		for (int i=0; i<sale.length; i++){
			sale[i]=s.ReadInInt();
		}

		int sum=sale[0]+sale[1]+sale[2]+sale[3]+sale[4]+sale[5]+sale[6];
		System.out.println("sum=" + sum);
		System.exit(0);
	}

	private int ReadInInt(){
		int in=0;
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		return in;
	}
}

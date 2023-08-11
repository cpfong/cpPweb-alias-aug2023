import java.io.*;

public class m44 {
	public static void main(String args[]){
		String s="";
		m44 m= new m44();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("pls input string");
			s=br.readLine();
		}
		catch (IOException e){
			System.out.println("Buffer Reader error");
			System.exit(1);
		}
		if (s.indexOf(".") == -1){
			System.out.println("integer");
		}
		else{
			System.out.println("floating");
		}
	}
}

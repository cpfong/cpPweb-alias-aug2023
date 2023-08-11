import java.io.*;

public class Write_abc {
	public static void main(String args[]){
		PrintWriter o;
		try {
			o = new PrintWriter(new FileWriter("xxx.txt"), true);
			o.print("abc");
			o.close();
		} catch (IOException e){
			System.out.println("File error:" + e.toString());
		}
	}
}

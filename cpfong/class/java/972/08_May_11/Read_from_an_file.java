import java.io.*;

public class Read_from_an_file{
	public static void main(String args[]){
		String l;
		BufferedReader f;

		try {
			f = new BufferedReader(new FileReader(args[0]));
			while ((l=f.readLine()) != null){
				System.out.println(l);
			}
			f.close();
		} catch (IOException e){
			System.out.println("error");
		}
	}
}

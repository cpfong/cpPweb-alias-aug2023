import java.io.*;

public class Read_Write{
	public static void main(String args[]){
		Read_Write t= new Read_Write();
		String l,tot="";
		BufferedReader f;

		try {
			f = new BufferedReader(new FileReader("xxx.txt"));
			while ((l=f.readLine()) != null){
				tot += l;
			}
			f.close();
		} catch (IOException e){
			System.out.println("error");
		}
		t.w(tot);
	}

	private void w(String s){
		PrintWriter o;
		try {
			o = new PrintWriter(new FileWriter("new.txt"), true);
			o.print(s);
			o.close();
		} catch (IOException e){
			System.out.println("File error:" + e.toString());
		}
	}
}

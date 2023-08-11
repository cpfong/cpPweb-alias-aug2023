import java.io.*;

public class File_Template{
	public static void main(String args[]){
		File f;

		f = new File("/tmp/xxx.txt");
		System.out.println(f.getParent());
	}
}


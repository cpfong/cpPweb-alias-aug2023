import java.io.*;

public class Checked_Excp_Template{
	public static void main(String[] args){
		// will complain here! must use try and catch
		BufferedReader inFile = new BufferedReader(new FileReader("c:\\myfile.txt"));
	}
}


import java.io.*;

public class Checked_Excp_Template2{
        public static void main(String[] args){
                try { 
				  BufferedReader inFile = new BufferedReader(new FileReader("c:\\myfile.txt"));
                  System.out.println("file open ok");
				}
                catch (FileNotFoundException e){
                        System.out.println("xxxx cannot find file");
                        System.exit(1);
                }

        }
}

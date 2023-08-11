import javax.swing.JOptionPane;

public class average {
 public static void main(String args[]){
	double sum = 0, avg;
	String t;
	int eof = -1, in = 0, c = 0;

	while (in != eof) {
		t    = JOptionPane.showInputDialog("input number, -1 to quit");
		in   = Integer.parseInt(t);
		sum += in; c++;
	}
	c--; sum += 1;
	avg = sum/c;
	JOptionPane.showMessageDialog(null, "Welcome to Java Programming! count = " + c +  ", avg = " + avg);
	System.exit(0);
 }
}

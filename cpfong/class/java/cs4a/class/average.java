import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class average {
	public static void main(String args[]){
		String t;
		double sum = 0, avg;
		int eof = -1, in=0, c=0;
		DecimalFormat r = new DecimalFormat("0.00");

		while (in != eof) {
			t    = JOptionPane.showInputDialog("input number, -1 to quit");
			in   = Integer.parseInt(t);
			sum += in; c++;
		}
		c--; sum += 1;
		avg = sum/c;
		t   = r.format(avg);
		JOptionPane.showMessageDialog(null, "Welcome to Java Programming! count = " + c +  ", avg = " + t );
		System.exit(0);
	}
}

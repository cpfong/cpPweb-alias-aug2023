import javax.swing.JOptionPane;

public class pass {
	public static void main(String args[]){
		String in, out;
		int i, p=0, f=0, t;

		for (i = 0; i < 10; i++){
			in = JOptionPane.showInputDialog("Enter result: (1=pass, other=fail)");
			t  = Integer.parseInt(in);
			if (t == 1) { p++; }
			else { f++; }
		}
		out = "Passed = " + p + " and Failed = " + f;
		JOptionPane.showMessageDialog(null, out, "Examination result", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}

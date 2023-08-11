import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DiceDemo extends JFrame 
    implements ActionListener {

    private JButton button;
    private JPanel panel, panel2;
    private JTextField fileField;

    public static void main (String[] args) {
        DiceDemo frame = new DiceDemo();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
   }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 100));
        panel.setBackground(Color.white);
        window.add(panel);

        panel2= new JPanel();
        panel2.setPreferredSize(new Dimension(150, 100));
        panel2.setBackground(Color.white);
        window.add(panel2);

	fileField = new JTextField(30);
	window.add(fileField);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        Graphics paper2= panel2.getGraphics();

	Random random = new Random();
	int i,j;
	i = random.nextInt(6)+1;
	j = random.nextInt(6)+1;

	String si=""+i+".gif";
	String sj=""+j+".gif";

        ImageIcon myImage = new ImageIcon(si);
        ImageIcon myImage2= new ImageIcon(sj);

        myImage.paintIcon (this, paper , 10,10);
        myImage2.paintIcon(this, paper2, 10,10);

	if (i == j){
    		fileField.setText(""+i+" = "+j);
	}
	else if (i>j) {
    		fileField.setText(""+i+" > "+j);
	}
	else {
    		fileField.setText(""+i+" < "+j);
	}
    }
}


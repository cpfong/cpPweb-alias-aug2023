import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// modify from P6-30 ImageDemo.java
public class Board extends JFrame implements ActionListener {

	private JButton button,button2;
	private JPanel panel;

	public static void main (String[] args) {
		Board frame = new Board();
		frame.setSize(400, 300);
		frame.createGUI();
		frame.setVisible(true);
	}

	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout() );

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 200));
		panel.setBackground(Color.white);
		window.add(panel);

		button = new JButton("Draw board" );window.add(button ); button.addActionListener(this);
		button2= new JButton("Clear"      );window.add(button2);button2.addActionListener(this);
		
	}
    
	public void actionPerformed(ActionEvent event) {
		Object src = event.getSource();
		Graphics paper = panel.getGraphics();
		int i=0,j=0;
		if (src == button){
			while (i<9){
				i++;
				paper.setColor(Color.red);
				paper.drawLine(10*i, 0, 10*i, 200);
				paper.setColor(Color.green);
				paper.drawLine(0, 10*i, 300, 10*i);
			}
		}
		else {
			paper.setColor(Color.white);
			paper.fillRect(0,0,300,200);
		}
    }
}

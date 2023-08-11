import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Quiz2 extends JFrame{
	private JTextField textField;

	public static void main(String[] args){
		Quiz2 frame = new Quiz2();
		frame.setSize(300,200);
		frame.createGUI();
		frame.setVisible(true);
	}
	private void createGUI(){
		Random r=new Random();
		int i;
		String s="";
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		for (i=0; i<10; i++){
			s += r.nextInt(10);
		}
		
		textField = new JTextField(" " + s  + " ");
		window.add(textField);
	}
}

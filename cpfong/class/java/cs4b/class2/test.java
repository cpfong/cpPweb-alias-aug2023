import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JFrame {

	public test(){
		setSize(200,100); show();
	}

	public static void main(String args[]){
		test t = new test();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
} 

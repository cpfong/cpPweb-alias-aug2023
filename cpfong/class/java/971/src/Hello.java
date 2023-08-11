// 輸入一些 java 的程式庫
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 Hello 是一個類別, 它延伸自 JFram 這個類別
 一個類別可以有許多的方法, 如果這個程式是
 一個應用程式, 則它必須有一個名為 main 的方法
*/

public class Hello extends JFrame {
	public static void main(String[] args){
		JOptionPane.showMessageDialog(null, "Hello World!");
		JOptionPane.showMessageDialog(null, "Goodbye");
		System.exit(0);
	}
}

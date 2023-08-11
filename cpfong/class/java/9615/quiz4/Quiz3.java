import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Quiz3 extends JFrame implements ActionListener {

    private JButton scissor, stone, paper;
    private JPanel panel;

    public static void main(String[] args) {
        Quiz3 demo = new Quiz3();
        demo.setSize(200,220);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        scissor = new JButton("刀");window.add(scissor);scissor.addActionListener(this);
        stone   = new JButton("石");window.add(stone  );stone.addActionListener(this);
        paper   = new JButton("布");window.add(paper  );paper.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
	Random random = new Random();
	String mes="",cs="";
	int me, c;

	c = 1 + random.nextInt(3);
	switch (c){
		case 1: cs = "刀"; break;
		case 2: cs = "石"; break;
		case 3: cs = "布"; break;
	}

        if (event.getSource() == scissor)    {	me = 1; mes = "刀"; }
        else if (event.getSource() == stone) {	me = 2; mes = "石"; }
	else 				     {	me = 3; mes = "布"; }

	paper.setColor(Color.white);paper.fillRect(0,0,150,150);
	paper.setColor(Color.black);

	if (me == c){		paper.drawString("我" + mes  + "電腦" + cs + " --> 平"   , 20, 20); }
	else if (Math.abs(me-c) == 1){
		if (me>c){	paper.drawString("我" + mes  + "電腦" + cs + " -->我贏"  , 20, 20); }
		else{		paper.drawString("我" + mes  + "電腦" + cs + " -->電腦贏", 20, 20); }
	}
	else {
		if (me>c){	paper.drawString("我" + mes  + "電腦" + cs + " -->電腦贏", 20, 20); }
		else{		paper.drawString("我" + mes  + "電腦" + cs + " -->我贏"  , 20, 20); }
	}
    }
}

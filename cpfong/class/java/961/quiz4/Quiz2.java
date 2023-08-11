import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz2 extends JFrame implements ActionListener {

private JButton RightButton, LeftButton,UpButton,DownButton;
private JPanel panel;
private Quiz2_1 Quiz2_1 ;

public static void main(String[] args) {
Quiz2 demo = new Quiz2();
demo.setSize(400,300);
demo.createGUI();
demo.setVisible(true);
}

private void createGUI() {
setDefaultCloseOperation(EXIT_ON_CLOSE);
Container window = getContentPane();
window.setLayout(new FlowLayout());

panel = new JPanel();
panel.setPreferredSize(new Dimension(300, 200));
panel.setBackground(Color.white);
window.add(panel);
RightButton = new JButton("往右");
window.add(RightButton);
RightButton.addActionListener(this);

LeftButton = new JButton("往左");
window.add(LeftButton);
LeftButton.addActionListener(this);

UpButton = new JButton("往上");
window.add(UpButton);
UpButton.addActionListener(this);

DownButton = new JButton("往下");
window.add(DownButton);
DownButton.addActionListener(this);

Quiz2_1 = new Quiz2_1();
}

public void actionPerformed(ActionEvent event) {
Graphics paper = panel.getGraphics();
if (event.getSource() == RightButton) {
Quiz2_1.moveRight(20);
}
else if (event.getSource()==LeftButton) {
Quiz2_1.moveLeft(20);
}
else if(event.getSource()==UpButton){
Quiz2_1.moveUp(20);
}
else{
Quiz2_1.moveDown(20);
}
paper.setColor(Color.white);
paper.fillRect(0, 0, 300, 200);
Quiz2_1.display(paper);
}
}

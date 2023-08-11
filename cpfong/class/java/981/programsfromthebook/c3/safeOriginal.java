import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class C3Inserts extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main (String[] args) {
        C3Inserts frame = new C3Inserts();
        frame.setSize(400,300);
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

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }


    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
//-----------------STARTEXTRACT=colourdemo.xtr
        paper.setColor(Color.red);
        paper.drawLine(0, 0, 100, 50);
        paper.setColor(Color.green);
        paper.drawOval(100, 100, 50, 50);
//----------------ENDEXTRACT=colourdemo.xtr



//----------------STARTEXTRACT=trianglenocomment.xtr
        paper.drawLine (20,80,70,10);
        paper.drawLine (70,10,120,80);
        paper.drawLine (20,80,120,80);
//---------------ENDEXTRACT=trianglenocomment.xtr

//-------------------------------STARTEXTRACT=trianglewithcomments.xtr
        // draw a triangle
        paper.drawLine(20,80,70,10);
        paper.drawLine(70,10,120,80);
        paper.drawLine(20,80,120,80); 
//-------------------------------ENDEXTRACT=trianglewithcomments.xtr

//-------------------------------STARTEXTRACT=triangleeolcomment.xtr
        // draw a triangle
        paper.drawLine(20,80,70,10);
        paper.drawLine(70,10,120,80);
        paper.drawLine(20,80,120,80);   // draw base
//-------------------------------ENDEXTRACT=triangleeolcomment.xtr


//  T

 //-------------STARTEXTRACT=drawbigt.xtr
       paper.drawLine(20,20,120,20);
        paper.drawLine(70,20,70,120);
//------------------ENDEXTRACT=drawbigt.xtr



    }

}



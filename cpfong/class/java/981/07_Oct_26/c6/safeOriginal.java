import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;    // for Random class

public class C6Inserts extends JFrame implements ActionListener {
    //------------STARTEXTRACT=randomconstructors.xtr
    private Random random = new Random();
    private Random randomSame = new Random(1000);
    //----------------ENDEXTRACT=randomconstructors.xtr

private 
//------------STARTEXTRACT=dectimershortway.xtr
private Timer timer;
//------------ENDEXTRACT=dectimershortway.xtr

//------------STARTEXTRACT=dectimerlongway.xtr
private javax.swing.Timer timer1;
//------------ENDEXTRACT=dectimerslongway.xtr




    private JTextField textField1,textField2;
    private JButton button;
    private JPanel panel;
    private JTextField textField;
    public static void main (String[] args) {
        C6Inserts frame = new C6Inserts();
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

        //-----------------------STARTEXTRACT=tfconstructors.xtr
        textField1 = new JTextField(15);
        textField2 = new JTextField("Hello!", 15);
        //-----------------------ENDEXTRACT=tfconstructors.xtr

//------------STARTEXTRACT=setdelay.xtr
timer.set(500);
//------------ENDEXTRACT=setdelay.xtr




    }

    public void actionPerformed(ActionEvent event) {
        int number;
        Graphics paper = panel.getGraphics();
        int max=10, min = 7;
        //-----------STARTEXTRACT=dicethrow.xtr
        int lucky;
        lucky = randomInRange(1, 6);
        //------------------ENDEXTRACT=dicethrow.xtr
        number = min + random.nextInt(max-min+1);
        textField.setText("r 7 to 10 " + number);

//---------------------STARTEXTRACTtfmethods.xtr
String s;
s = textField1.getText();
textField1.setText(s);
//---------------------ENDEXTRACT=tfmethods.xtr



    }

    //-----------STARTEXTRACT=randomminmax.xtr
    private int randomInRange(int min, int max) {
        return min+random.nextInt(max-min+1);
    }
    //--------------ENDEXTRACT=randomminmax.xtr
}


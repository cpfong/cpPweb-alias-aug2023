import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class C16Inserts extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;
    private JTextField errorField, resultField;
    private BufferedReader inFile;

    public static void main(String[] args) {
        C16Inserts frame = new C16Inserts();
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
        paper.drawLine(0,0,111,113);
    }


    private void fileError(){
        //---------------STARTEXTRACT=filereaderexcep.xtr
        try {
            inFile = new BufferedReader(new
                FileReader("c:\\myfile.txt"));
        }
        catch (FileNotFoundException errorObject) {
            JOptionPane.showMessageDialog(null,
                "Error: missing file-try again!");
        }
        //---------------ENDEXTRACT=filereaderexcep.xtr
    }


    //------------------------STARTEXTRACT=throwioexcep.xtr
    private void openFile() throws IOException {
        inFile = new BufferedReader(new 
            FileReader("c:\\myfile.txt"));
    }
    //------------------------ENDEXTRACT=throwioexcep.xtr



    private void wrongLoop() {
        //-------------------STARTEXTRACT=wrongloop.xtr
        int a[] = new int[10];       // 0 to 9 inclusive
        for(int n = 0; n <= 10; n++) {
            a[n] = 0;
        }  
  //-------------------ENDEXTRACT=wrongloop.xtr

   }





    private void demo1anothercatch(){
        try {
        }
        //----------------------STARTEXTRACT=demo1anothercatch.xtr
        catch (NumberFormatException errorObject) {
           JOptionPane.showMessageDialog(null,
               "Error: " + errorObject.toString());
        }
        //----------------------ENDEXTRACT=demo1anothercatch.xtr
    }

}






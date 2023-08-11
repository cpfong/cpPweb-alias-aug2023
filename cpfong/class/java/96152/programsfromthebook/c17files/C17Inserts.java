import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.io.*;

public class C17Inserts extends JFrame
implements  ActionListener {
    private JTextArea inputTextArea; 
    private JButton openButton;
    private PrintWriter outFile;

    private JButton loadButton;

    private BufferedReader inFile;
    private JTextField nameField, personField;

    public static void main (String [] args) {
        C17Inserts frame = new C17Inserts();

        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        openButton = new JButton("open");
        window.add(loadButton);
        loadButton.addActionListener(this);
        nameField = new JTextField(20);
        window.add(nameField);
        nameField.addActionListener(this);

        inputTextArea = new JTextArea("",10,50);
        window.add("Center", inputTextArea);

        personField = new JTextField("");
    }

    private void stq (){ 
        String nameInFile = "";
        boolean found = true;
        if (nameInFile.equalsIgnoreCase(personField.getText())) {
            found = true;
        }
    }

    private void generalRead(){
        BufferedReader inStream = null;
        String line;
        while((line = inStream.readLine()) != null) {
            // process line
        } 
    }


    private String prompt(String mess){
        return "22";

    }


    private String keys(){
        try{
            BufferedReader keyboard;
            keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
            //-------------STARTEXTRACT=readkeyboard.xtr
            String line = keyboard.readLine();
            //---------------ENDEXTRACT=readkeyboard.xtr
        }
        catch (Exception e) {
        }


        //-------------STARTEXTRACT=screenprint.xtr
        String demo = "some data";
        // display: some data being printed
        System.out.println(demo + " being printed");
        //----------------ENDEXTRACT=screenprint.xtr

        //---------------STARTEXTRACT=prompt.xtr
        String reply = prompt("type your name:");
        //-------------ENDEXTRACT=prompt.xtr


        //-----------STARTEXTRACT=flush.xtr
        System.out.flush();
        //------------ENDEXTRACT=flush.xtr

        //-------------------STARTEXTRACT=systemerror.xtr
        System.err.println("Error... program terminating.");
        //------------------ENDEXTRACT=systemerror.xtr
int age = 9;
        //------------------STARTEXTRACT=exit.xtr
        if(age >= 0 ) {
            System.exit(0);           // normal exit
        }
        else {
            System.err.println("Error in program");
            System.exit(3);          // error exit
        }
        //--------------ENDEXTRACT=exit.xtr

        return "22";
    }



    public void actionPerformed(ActionEvent evt) {
        String line;

        if (evt.getSource() == loadButton) {
            String fileName;
            fileName = nameField.getText();
            try {
                outFile = new PrintWriter(new FileWriter("testout.txt"), true);


                //-------------STARTEXTRACT=bettererror.xtr
                outFile.print(inputTextArea.getText());
                if(outFile.checkError() )     //true if error 
                    JOptionPane.showMessageDialog(null,
                        "Error during writing to file.");
                //-------------ENDEXTRACT=bettererror.xtr


                //---------------------STARTEXTRACT=altreadloop.xtr
                line = inFile.readLine();
                while(line != null) {
                    inputTextArea.append(line + "\n");
                    line = inFile.readLine();
                }
                inFile.close();
                //---------------------ENDEXTRACT=altreadloop.xtr


                inFile = new BufferedReader(
                new FileReader(fileName));

                inputTextArea.setText( "");    // clear the input area


                while( ( line = inFile.readLine() ) != null) {
                    inputTextArea.append(line + "\n");
                }
                inFile.close();



            }
            catch (IOException e) {
                System.err.println("Error in file "
                    + fileName + ": " + e.toString() );
                System.exit(1);
            }
        }
    }
}




//--------------STARTEXTRACT=frasier.xtr
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 

public class AskFrasier extends JFrame 
    implements ActionListener {

    private JTextField questionField, replyField;
    private JLabel psychiatristLabel, questionLabel;
    private Psychiatrist frasier;

    public static void main(String[] args) {
        AskFrasier frame = new AskFrasier();
        frame.setSize(400, 150);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

      questionLabel = new JLabel("Type here.... ");
      window.add(questionLabel);

     questionField = new JTextField(30);
       window. add(questionField);
        questionField.addActionListener(this);

        psychiatristLabel = new JLabel("Frasier says: ");
        window.add(psychiatristLabel);

   
       
        replyField = new JTextField("Go ahead please...  I'm listening.", 30);
    //    replyField.setEditable(false);
        window.add(replyField);

        frasier = new Psychiatrist();

    }



   public void actionPerformed(ActionEvent event) {
//--------------STARTEXTRACT=askquestion.xtr
        if (event.getSource() == questionField) {
            String itsValue = questionField.getText();
            frasier.putQuestion(itsValue);
            replyField.setText(frasier.getReply() );
        }
//----------ENDEXTRACT=askquestion.xtr
    }
}


class Psychiatrist {
    private String question;
    private String reply;
    private Random randomValue = new Random();
    public void putQuestion(String q) {
        question = " " + q + " ";
    }
    public String getReply() {
//------STARTEXTRACT=randomquestion.xtr
        int variation = randomValue.nextInt(3);
        switch (variation) {
            case 0: reply = transformQuestion(); break;


            case 1: reply = "Why do you feel that?"; break;
            case 2: reply = "please be frank!"; break;
        }
//--------ENDEXTRACT=randomquestion.xtr
        return reply;
    }

    private String transformQuestion() {
        if (question.indexOf(" I ") >= 0) {
            String tempReply = replace (question," I ", " you ");
            tempReply = replace(tempReply, " am ", " are ");
            return replace(tempReply, " my "," your ") + "-why?";
        }
        else
            if (question.indexOf(" no ") >= 0)
                return "no? that is negative! Please explain....";
            else
                return "\"" + question + "\"-Please re-phrase..";
    }

//----------STARTEXTRACT=replacemethod.xtr
    private String replace(String original, String from, String to) {
        String leftBit, rightBit;
        int startSearch = 0;
        int place = original.indexOf(from);
        if (from.length() != 0) {
            while (place >= startSearch) {
                leftBit = original.substring(0, place);
                rightBit = original.substring(place + from.length(),
                                        original.length());
                original = leftBit + to + rightBit;
                startSearch = leftBit.length() + to.length();
                place = original.indexOf(from);
            }
        }
        return original;
    }
//---------ENDEXTRACT=replacemethod.xtr
}
//-----------------ENDEXTRACT=frasier.xtr


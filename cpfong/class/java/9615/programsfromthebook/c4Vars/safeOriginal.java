//----------------STARTEXTRACT=prog2.xtr
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class C4Inserts   extends JFrame implements ActionListener{

    private JTextField textField;
    private JButton button;
    private int privateInt;   //  set to 0
    private String privateString;// set to null  - "null" when printed
    public static void main (String[] args) {
        C4Inserts frame = new C4Inserts();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );
        textField = new JTextField("Hello!");
        window.add(textField);

        button = new JButton("click");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        testInit();
    }


    private void button1_Click()
    {

        //-----------STARTEXTRACT=bigvalue.xtr
        double bigValue = 12.3E+23;
        //-----------ENDEXTRACT=bigvalue.xtr

        //--------STARTEXTRACT=egincrem.xtr
        int n = 10;
        n = n + 1;
        //---------ENDEXTRACT=egincrem.xtr

        //-------STARTEXTRACT=plusplus.xtr
        n = 3;
        n++;    // n is now 4
        //---------ENDEXTRACT=plusplus.xtr

        //---------STARTEXTRACT=stqstringplus.xtr
        JOptionPane.showMessageDialog(null, "5"+"5"+5+5);
        JOptionPane.showMessageDialog(null, "5"+"5"+(5+5));
        //----------ENDEXTRACT=stqstringplus.xtr



        //STARTEXTRACT=testassign.xtr
        int a, b, c, d;
        d = -8;
        a = 1 * 2 + 3;
        b = 1 + 2 * 3;
        c = (1 + 2) * 3;
        c = a + b;
        d = -d;
        //ENDEXTRACT=testassign.xtr

        //STARTEXTRACT=altdim.xtr
        int length, width, area;
        //ENDEXTRACT=altdim.xtr

        //STARTEXTRACT=mixeddims.xtr




        double personHeight;
        int examMark;
        double salary;
        //ENDEXTRACT=mixeddims.xtr

        //----------STARTEXTRACT=modcents.xtr
        int cents = 234;
        int dollars, centsRemaining;
        dollars = cents / 100;          // set to 2
        centsRemaining = cents % 100;   // set to 34
        //---------ENDEXTRACT=modcents.xtr

        personHeight=1;
        length=1;
        examMark=1;
        width=1;
        salary=0;
        area=0; 

    }

    private void button2_Click()
    {

        //STARTEXTRACT=eg1cstr.xtr
        String s1, s2;
        int num = 44;
        double d=1.234;
        s1 = Integer.toString(num);  // s1 is "44"
        s2 = Double.toString(d);     // s2 is "1.234"
        //ENDEXTRACT=eg1cstr.xtr

        //-----STARTEXTRACT=apples.xtr
        int apples = 9;    // or fetch value from a text box
        int people = 4;    // or fetch value from a text box
        JOptionPane.showMessageDialog(null, "A person gets:  " + 
            Double.toString((double)apples / (double)people));
        //------------ENDEXTRACT=apples.xtr
    }

    private void button7_Click()
    {
        //STARTEXTRACT=dbltostr.xtr
        double d;
        int i;
        String s1 = "12.3";
        String s2 = "567";
        d = Double.parseDouble(s1);
        i = Integer.parseInt(s2);
        //ENDEXTRACT=dbltostr.xtr

    }

    private void button6_Click()
    {
        Graphics paper=getGraphics();
        //STARTEXTRACT=numconvert.xtr
        int i = 33;
        double d = 3.9;
        double d1;
        d1 = i;              // set to 33.0
        // or, explicitly:
        d1 = (double)i;      // set to 33.0             
        i = (int)d;          // set to 3
        //ENDEXTRACT=numconvert.xtr

        //STARTEXTRACT=egexpr.xtr
        int x  = 100;
        int y  = 200;
        paper.drawLine(100, 100, 110, 110);
        paper.drawLine(x, y, x + 50, y + 50);
        paper.drawLine(x * 2, y - 8, x * 30 - 1, y * 3 + 6);
        //ENDEXTRACT=egexpr.xtr

    }

    private void button5_Click()
    {

        //STARTEXTRACT=streg1.xtr
        String firstName = "Mike ";
        String lastName, wholeName;
        String greeting;
        lastName = "Parr";
        //STARTEXTRACT=concat1.xtr
        wholeName = firstName + lastName;
        //ENDEXTRACT=concat1.xtr
        greeting = "Hi from " + wholeName;  // set to "Hi from Mike Parr"
        //ENDEXTRACT=streg1.xtr

        //STARTEXTRACT=intandstr.xtr
        String s = "12";
        int  i = 12;
        String s1;
        s = "12345678";
        i = 12345678;
        s1 = "abcdefgh";
        //ENDEXTRACT=intandstr.xtr

        int area  = 20;
        int length;
        //STARTEXTRACT=eg2cstr.xtr
        JOptionPane.showMessageDialog(null, "Area is " + area);
        // or simply the value:
        JOptionPane.showMessageDialog(null, Integer.toString(area));
        //ENDEXTRACT=eg2cstr.xtr


        //STARTEXTRACT=label.xtr
        //  *********** not needed
        //ENDEXTRACT=label.xtr

        //STARTEXTRACT=nostr.xtr
        s = "Jaws" + 2 ;         // set to "Jaws2"
        //    s = 11 + 22;       // ??? use??? set to "1122"
        //ENDEXTRACT=nostr.xtr

        // make it compile:
    }

    private void button4_Click()
    {
        //STARTEXTRACT=emptyassign.xtr
        String greeting = "";
        //ENDEXTRACT=emptyassign.xtr


        //STARTEXTRACT=testops.xtr
        int a, b, c, d;
        a = 7 / 3;
        b = a * 4;
        c = (a + 1) / 2;
        d = c / 3;
        //ENDEXTRACT=testops.xtr
    }

    private void button3_Click()
    {
        //STARTEXTRACT=egmod.xtr
        int i;
        double d;
        i = 12 % 4;          // set to 0
        i = 13 % 4;          // set to 1
        i = 15 % 4;          // set to 3
        d = 14.9 % 3.9;      // set to 3.2 (divides 3 times)
        //ENDEXTRACT=egmod.xtr
    }

    private void button8_Click()
    {
        //----STARTEXTRACT=testscstr.xtr
        int m, n;
        String s;
        String  v = "3";
        m = Integer.parseInt(v + v + "4");
        n = Integer.parseInt(v + v) + 4;
        s = Integer.toString(Integer.parseInt(v) 
            + Integer.parseInt(v)) + "4";
        //----------ENDEXTRACT=testscstr.xtr 
    }

    private void button9_Click()
    {
        //----STARTEXTRACT=testscint.xtr
        int i, j, k;
        double a, b, c;
        int n = 3;
        double y = 2.7;
        i = (int)y;
        j = (int)(y + 0.6);
        k = (int)((double)n + 0.2);
        a = n;
        b = (int)n;
        c = (int)y;
        //-------ENDEXTRACT=testscint.xtr

    }

    private void button10_Click()
    {
        //-----STARTEXTRACT=minsecstest.xtr
        int totalSeconds = 307;
        int seconds, minutes;
        minutes = totalSeconds / 60;
        seconds = totalSeconds % 60;
        //---ENDEXTRACT=minsecstest.xtr

        //STARTEXTRACT=egdivdouble.xtr
        // double division
        double d;
        d = 7.61 / 2.1;        // set to 3.7
        d = 10.6 / 2;          // set to 5.3
        //ENDEXTRACT=egdivdouble.xtr


        //STARTEXTRACT=egdivint.xtr
        //integer division
        int i;
        i = 10 / 5;            // set to 2
        i = 13 / 5;            // set to 2 
        i = 33 / 44;           // set to 0
        //ENDEXTRACT=egdivint.xtr
    }

    private void button12_Click()
    {
        //STARTEXTRACT=diminit.xtr
        double personHeight = 1.68;
        int a = 3, b = 4;
        int examMark = 65;
        int betterMark = examMark + 10;
        //ENDEXTRACT=diminit.xtr

        //STARTEXTRACT=egcalcs.xtr
        int i;
        int n = 3;
        double d;
        i = n + 3;             // set to 6
        i = n * 4;             // set to 12
        i = 7 + 2 * 4;         // set to 15
        n = n * (n + 2) * 4;   // set to 60
        d = 3.5 / 2;           // set to 1.75
        n = 7 / 4;             // set to 1
        //ENDEXTRACT=egcalcs.xtr
    }

    private void button14_Click()
    {
        //------STARTEXTRACT=intstringadd.xtr
        int i = 7;
        String name = "th Avenue";
        String s = i + name;
        //-----ENDEXTRACT=intstringadd.xtr

    }

    private void button15_Click()
    {
        //----------STARTEXTRACT=intstringprob.xtr
        int i = 2, j = 3;
        String s, note = "Answer is: ";
        s = note + i + j;
        //------------ENDEXTRACT=intstringprob.xtr
        //----------STARTEXTRACT=intstringprob2.xtr
        s = note + (i + j);
        //------------ENDEXTRACT=intstringprob2.xtr

        //----------STARTEXTRACT=intstringself.xtr
        String s1, s2;
        s1 = "A" + "B" + 5 + 5 + 5;
        s2 = "A" + "B" + 5 +(5 + 5);
        //------------ENDEXTRACT=intstringself.xtr

        s2="";
    }

    private void paneExamples() {
        //-------------STARTEXTRACT=parseExamples.xtr
        int i;
        double d;
        String s1 = "1234";
        String s2 = "1.23";
        i = Integer.parseInt(s1);
        d = Double.parseDouble(s2);
        //-------------------ENDEXTRACT=parseExamples.xtr 

        //-------------STARTEXTRACT=panetostring.xtr
        int n = 33;
        JOptionPane.showMessageDialog(null, "n is: " + Integer.toString(n));
        //-------------------ENDEXTRACT=panetostring.xtr 

        //-------------STARTEXTRACT=inputdialogegs.xtr
String firstName, lastName;        
firstName = JOptionPane.showInputDialog("Enter your first name");
lastName = JOptionPane.showInputDialog("Enter your last name");
        //-------------------ENDEXTRACT=inputdialogegs.xtr 

    }


    private void testInit() {
        String s;
        int i;   //local - this does not give 0 to i
        double d;
        int n;
        //      n=i;
        i=privateInt;
        privateString = privateString+"a";

        JOptionPane.showMessageDialog(null, "privateS is "+privateString);

        s = JOptionPane.showInputDialog("prompt  aaaaaaaaa \n bbbbbbbbbb bbbbbbbbbb"); 
        JOptionPane.showMessageDialog(null, "s is "+s); 
    }
}

//----------------ENDEXTRACT=prog2.xtr


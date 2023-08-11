import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chap14ex1 extends JFrame implements ActionListener {

    private JButton button, button2, button3;
    private JTextField newData;
    private JTextArea data;
    private JTextField stats;

    int[][] rainData =
    {
        {10, 7, 3, 28, 5, 6, 3},
        {12, 3, 5, 7, 12, 5, 8},
        { 8, 5, 2, 1,  1, 4, 7},
        { 1, 2, 3, 4,  5, 6, 7}
    };


    public static void main(String[] args) {
        Chap14ex1 frame = new Chap14ex1();
        frame.setSize(300,175);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("sums")   ;window.add(button ); button.addActionListener(this);
        button2= new JButton("largest");window.add(button2);button2.addActionListener(this);
        button3= new JButton("scale")  ;window.add(button3);button3.addActionListener(this);

        newData = new JTextField(2);
        window.add(newData);

        data = new JTextArea(4, 20);
        window.add(data);

        stats = new JTextField(10);
        window.add(stats);

        display();
    }

    public void actionPerformed(ActionEvent event) {
        changeValue();
    }

    private void changeValue() {

        display();
        calculateTotal();
    }


    private void display() {
        data.setText("");
        data.setTabSize(3);
        String newLine = "\r\n";
        String tab = "\t";

        for (int location = 0; location < rainData.length; location++) {

            for (int dayNumber = 0; dayNumber < rainData[0].length; dayNumber++) {
                data.append(Integer.toString
                    (rainData[location][dayNumber])
                    + tab);
            }
//or

            for (int rainfall : rainData[location]) {
                data.append(Integer.toString(rainfall) + tab);
            }

            data.append(newLine);
        }
    }

    private void calculateTotal() {
        int total = 0; 

        for (int location = 0; location < rainData.length; location++) {
            for (int dayNumber = 0; dayNumber < rainData[0].length; dayNumber++) {
                total = total + rainData[location][dayNumber];
            }
        }
        stats.setText("total rainfall is " + Integer.toString(total));
    }
}

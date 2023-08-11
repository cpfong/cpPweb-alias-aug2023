
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rainfall extends JFrame implements ActionListener {

    private JButton button;
    private JLabel placeLabel;
    private JTextField place;
    private JLabel dayLabel;
    private JTextField day;
    private JLabel toLabel;
    private JTextField newData;
    private JTextArea data;
    private JTextField stats;

    int[][] rainData =
    {
        {
            10, 7, 3, 28, 5, 6, 3                                                                        }
        ,
        {
            12, 3, 5, 7, 12, 5, 8                                                                        }
        ,
        { 
            8, 5, 2, 1, 1, 4, 7                                                                        }
    };


    public static void main(String[] args) {
        Rainfall frame = new Rainfall();
        frame.setSize(300,175);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("change value at");
        window.add(button);
        button.addActionListener(this);

        placeLabel = new JLabel("location");
        window.add(placeLabel);

        place = new JTextField(1);
        window.add(place);

        dayLabel = new JLabel("day");
        window.add(dayLabel);

        day = new JTextField(1);
        window.add(day);

        toLabel = new JLabel("to");
        window.add(toLabel);

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
        int dataValue; 
        int dayNumber;
        int location;

        dayNumber = Integer.parseInt(day.getText());
        location = Integer.parseInt(place.getText());
        dataValue = Integer.parseInt(newData.getText());
        rainData[location][dayNumber] = dataValue;

        display();
        calculateTotal();
    }


    private void display() {
        data.setText("");
        data.setTabSize(3);
        String newLine = "\r\n";
        String tab = "\t";

        for (int location = 0; location <=  2; location++) {

            for (int dayNumber = 0; dayNumber <= 6; dayNumber++) {
                data.append(Integer.toString
                    (rainData[location][dayNumber])
                    + tab);
            }
            data.append(newLine);
        }
    }

    private void calculateTotal() {
        int total = 0; 

        for (int location = 0; location <= 2; location++) {
            for (int dayNumber = 0; dayNumber <= 6; dayNumber++) {
                total = total + rainData[location][dayNumber];
            }
        }
        stats.setText("total rainfall is " + Integer.toString(total));
    }
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Telephone extends JFrame implements ActionListener {

    private JButton button;
    private JTextField name, number;

    private String[] names = new String[20];
    private String[] numbers = new String[20];


    public static void main(String[] args) {
        Telephone frame = new Telephone();
        frame.setSize(200,100);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());


        button = new JButton("find");
        window.add(button);
        button.addActionListener(this);

        name = new JTextField(6);
        window.add(name);

        number = new JTextField(14);
        window.add(number);

        names[0] = "Alex";
        numbers[0] = "2720774";

        names[1] = "Megan";
        numbers[1] = "5678554";

        names[2] = "END";

    }

    public void actionPerformed(ActionEvent event) {
        find();
    }

    private void find() {
        int index;
        String wanted;

        wanted = name.getText();
        index = 0;
        for (index = 0;
          !(names[index].equals(wanted)) && !(names[index].equals("END"));
          index++) {
        }

        if (names[index].equals(wanted)) {
            number.setText("number is " + numbers[index]);
        }
        else {
            number.setText("name not found");
        }
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JApplet implements ActionListener {

        int             arr[] ={ 1,3,5,7,9};
        final String    str[] ={ "Enter integer search key ", "Result"  };
        JLabel          lab[] ={ new JLabel(str[0]), new JLabel(str[1]) };
        JTextField      edi[] ={ new JTextField(5), new JTextField(10)  };

        public void init() {
                Container c = getContentPane();
                c.setLayout( new FlowLayout());

                for (int i=0; i < 2; i++){
                        c.add(lab[i]);
                        c.add(edi[i]);
                }

                edi[0].addActionListener(this);
                edi[1].setEditable(false);
        }

        public void actionPerformed(ActionEvent act){
                String str = act.getActionCommand();
                edi[1].setText("you input: " + str);
        }
}


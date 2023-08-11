import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EntryDemo extends JFrame implements ActionListener{
	Entry[] directory = new Entry[1000];
	private JTextField t1,t2;
	private JButton find, input;
	private int index=0;

	public static void main(String args[]){
		EntryDemo e=new EntryDemo();
		e.setSize(150,300); e.createGUI(); e.setVisible(true);
	}

        private void createGUI() {

                setDefaultCloseOperation(EXIT_ON_CLOSE);
                Container window = getContentPane();
                window.setLayout(new FlowLayout());

		JLabel l1,l2;
		l1=new JLabel("name:"  ); window.add(l1); t1=new JTextField(5);window.add(t1);
		l2=new JLabel("number:"); window.add(l2); t2=new JTextField(5);window.add(t2);

		find =new JButton("Find" ); window.add(find) ; find.addActionListener(this);
		input=new JButton("Input"); window.add(input);input.addActionListener(this);
        }

	public void actionPerformed(ActionEvent e) {
		String s="";

		if (e.getSource() == input){
			directory[index] = new Entry();
			directory[index].setName(t1.getText());
			directory[index].setNumber(t2.getText());
			index++;
		}
		else{
			s=t1.getText();
			for (int i=0; i < index; i++){
				if (s.equals(directory[i].getName())){
					t2.setText(directory[i].getNumber());
					break;
				}
			}
		}
   }
}

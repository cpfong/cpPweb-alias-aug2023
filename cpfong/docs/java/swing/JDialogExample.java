import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JDialogExample: An example of how to use a Dialog
 */
public class JDialogExample extends JFrame
    implements ActionListener {

    JButton dialogButton = new JButton("Modify Student Information");
    JTextField idField = new JTextField("99999999");
    JTextField nameField = new JTextField("ABCDEFGHIJKLMNOPQRST");
    FlowLayout layout = new FlowLayout();

    Student student = new Student("1234","John Doe");
/***********************************************************
Default constructor;
     adds the componets to the JFrame
     sets the ActionListeners for the buttons
     sets the WindowListener
************************************************************/
public JDialogExample(){
    // add the components to the container
   this.getContentPane().setLayout(layout);
   this.getContentPane().add(dialogButton);

   this.getContentPane().add(idField);
   this.getContentPane().add(nameField);
    // set the ActionListeners for the buttons
   dialogButton.addActionListener(this);

   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setTitle("JDialog Example - Main Frame");
   this.pack();
   this.setVisible(true);
}

public void actionPerformed (ActionEvent e)
    {

	JButton currentButton = (JButton) e.getSource();
	// Create the dialog when the dialogButton is pressed
	if (currentButton == dialogButton){
	    MyDialog myDialog = new MyDialog(this,student);
	    // Display the dialog
	    myDialog.show();
	    // Check if the user wants to keep the changes made
	    if (myDialog.exitType.equals("OK")) 
	    {
		    idField.setText(student.getId() );
		    nameField.setText(student.getName() );

	    }

	}
    }

    public static void main(String args[])
    {
	JDialogExample jde = new JDialogExample();
    }
}

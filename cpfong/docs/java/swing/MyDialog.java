import javax.swing.*;
import javax.swing.JDialog;
import java.awt.*;
import java.awt.event.*;
public class MyDialog extends JDialog
    implements ActionListener 
{
    Student student;
    JLabel idLabel = new JLabel("Student Id.: ");
    JLabel nameLabel = new JLabel("Student Name: ");
    JTextField idField = new JTextField("        ");
    JTextField nameField = new JTextField("              ");    
    JButton acceptButton = new JButton("Save Changes");
    FlowLayout layout = new FlowLayout();
    public String exitType = "Cancel";


    public MyDialog(JFrame parent,Student pstudent)
    {
	// Required
	// Call the constructor for JDialog
	// The second parameter, true, indicates this is a modal dialog
	super(parent,true);
	setTitle("Dialog to capture student data");
	student = pstudent;

	this.getContentPane().setLayout(layout);

	this.getContentPane().add(idLabel);
	this.idField.setText(student.getId());
	this.getContentPane().add(idField);
	this.getContentPane().add(nameLabel);
	this.nameField.setText(student.getName());
	this.getContentPane().add(nameField);
	this.getContentPane().add(acceptButton);	
	acceptButton.addActionListener(this);

	this.pack();
	// this.setVisible(true);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// Set the Window Listener (action to be taken when the window is closed
	/*	TheWindowListener twl = new TheWindowListener(this);
	addWindowListener(twl);
	*/
    }

    public void actionPerformed (ActionEvent e)
    {

	JButton currentButton = (JButton) e.getSource();
	// Check if the user wants to keep the changes made
	if (currentButton == acceptButton){
	    student.setId(idField.getText());
	    student.setName(nameField.getText());
	    exitType = "OK";
	    dispose();
	}

    }
}




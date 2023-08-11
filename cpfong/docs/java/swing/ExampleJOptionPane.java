import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

/**
 * ExampleJOptionPane: An example of different ways to use JOptionPane
 */
public class ExampleJOptionPane extends JFrame
    implements ActionListener {

    JButton confirmButton = new JButton("ConfirmDialog");
    JButton inputButton = new JButton("InputDialog");
    JButton messageButton = new JButton("MessageDialog");
    JButton optionButton = new JButton("OptionDialog");
    JTextField valueField = new JTextField("Initial Text: ABCDEFGHIJKLMNOPQRST");
    FlowLayout layout = new FlowLayout();

/***********************************************************
Default constructor;
     adds the componets to the JFrame
     sets the ActionListeners for the button
     sets the WindowListener
************************************************************/
public ExampleJOptionPane(){
    // add the components to the container
   this.getContentPane().setLayout(layout);
   this.getContentPane().add(confirmButton);
   this.getContentPane().add(inputButton);
   this.getContentPane().add(messageButton);
   this.getContentPane().add(optionButton);

   this.getContentPane().add(valueField);

    // set the ActionListeners for the buttons
   confirmButton.addActionListener(this);
   inputButton.addActionListener(this);
   messageButton.addActionListener(this);
   optionButton.addActionListener(this);

   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.pack();
   this.setVisible(true);
}

/***********************************************************
This method is required if you plan to respond to button
clicks.  
************************************************************/
public void actionPerformed (ActionEvent e){

    JButton currentButton = (JButton) e.getSource();
    // This style of usage of JOptionPane is useful for situations
    // where the user should confirm a particular decision
   if (currentButton == confirmButton){
       int choice = JOptionPane.showConfirmDialog(this,"Are you old?",
						  "Are you old?",
						  JOptionPane.YES_NO_OPTION);
       if (choice == JOptionPane.YES_OPTION) {
	   valueField.setText("You are old.");
       }
       if (choice == JOptionPane.NO_OPTION) {
	   valueField.setText("You are young.");
       }
   }
    // This style of usage of JOptionPane is useful for situations
    // where the user should provide some input
   if (currentButton == inputButton){
       String userInput = JOptionPane.showInputDialog("Please enter your name:");
       valueField.setText("Your name is "+userInput);
   }
    // This style of usage of JOptionPane is useful for situations
    // where the user needs to be informed about a situation before he/she
   //  can continue.
   if (currentButton == messageButton){
       JOptionPane.showMessageDialog(this,"The chips you selected do not match the dice.","Chips do not match dice",JOptionPane.ERROR_MESSAGE);
   }
    // This style of usage of JOptionPane is useful for situations
    // where the user needs to make a choice among several options
   if (currentButton == optionButton){
       Object options[] = {"OK","Cancel"};
       int choice = JOptionPane.showOptionDialog(null,"Click OK to continue.","Warning",
				    JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
				    null,options,options[0]);
       if (choice == 0) {
	   valueField.setText("OK to continue.");
       }
       if (choice == 1) {
	   valueField.setText("Canceled.");
       }
   }

}
    /**
     * main
     */
    public static void main(String[] args) {
	JFrame frame = new ExampleJOptionPane();
    }
}

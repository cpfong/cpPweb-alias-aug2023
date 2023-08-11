import javax.swing.*;
// Based on the example HelloWorldSwing available at SUN's web site:
// http://java.sun.com/docs/books/tutorial/uiswing/mini/firstexample.html
// Import all the classes in the javax.swing package 

public class HelloCS262 
{
    // Just the main method
    public static void main(String args[])
    {
	// A frame is required to place the components
	// The version of the constructor used here takes 
	// a string as a parameter. That string becomes the title of the frame.
	JFrame frame = new JFrame("Hello CS262!");
	// On this frame, a label (text) will be placed
	// Again, the string passed as a parameter will be the 
	// initial (and only) value of the label (because it is final).
	final JLabel label = new JLabel("Hello CS262!");

	// Now we add the label to the frame.
	// This cannot be done directly in Swing. One has to obtain
	// the ContentPane of the frame, and then add the label.
	frame.getContentPane().add(label);


	// Tell the run time environment that if the user chooses
	// to close the frame, then the application should exit
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Use the pack method (inherited from the Window class)
	// so that the frame has a size that fits the preferred size
	// and layouts of its subcomponents
	frame.pack();

	// Make the frame visible
	frame.setVisible(true);
    }
}

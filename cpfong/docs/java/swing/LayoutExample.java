import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  An example of how to combine different layouts in a single GUI:
 *  Three different panels will be created inside the window:
 *  Two of them will use the BoxLayout
 *  The third one will use the FlowLayout
 *  The those panels will be added to the window using the BorderLayout
 *  This example is just an example of layouts, therefore there is no
 *  actionListener to capture the user clicking on the buttons
 */

public class LayoutExample extends JFrame 
{

    /* GUI Components */
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");

    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");

    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");

    public LayoutExample() {
	// This is the pane for the entire window
	Container pane = getContentPane();
	// Use the BorderLayout for the entire window
	pane.setLayout(new BorderLayout());

	// Create a first panel to place the + and - buttons
	JPanel leftPanel = new JPanel();
	// In this left panel, use the BoxLayout in the vertical (Y) axis
	leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
	// Now add the first two buttons
	leftPanel.add(buttonPlus);
	leftPanel.add(buttonMinus);

	// Now create a second panel to place the 0,1,2,3,4 buttons
	JPanel centralPanel = new JPanel();
	// In this central panel, use the FlowLayout 
	centralPanel.setLayout(new FlowLayout());
	// Now add the number buttons
	centralPanel.add(button0);
	centralPanel.add(button1);
	centralPanel.add(button2);
	centralPanel.add(button3);
	centralPanel.add(button4);

	// Create another panel to place the A and B buttons
	JPanel rightPanel = new JPanel();
	// In this left panel, use the BoxLayout in the horizontal (X) axis
	rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.X_AXIS));
	// Now add the last two buttons
	rightPanel.add(buttonA);
	rightPanel.add(buttonB);

	// Now add the three (sub)panels to the main panel
	pane.add(leftPanel,"West");
	pane.add(centralPanel,"Center");
	pane.add(rightPanel,"East");

	setTitle("Example of Layouts");
	// Instead of using pack, it is possible to set the size directly
	setSize(260,120);
	setVisible(true);

	// Set the Window Listener (action to be taken when the window is closed
	addWindowListener(new TheWindowListener());
    }

    public static void main(String args[])
    {
	JFrame f = new LayoutExample();
    }
}

// TheWindowListener class
// The method windowClosing will be invoked when the user decides
// to close the application
class TheWindowListener extends WindowAdapter
{
    public void windowClosing (WindowEvent e)
    {
        System.exit(0);
    }
}

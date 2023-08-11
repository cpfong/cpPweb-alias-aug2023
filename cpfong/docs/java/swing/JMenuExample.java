import javax.swing.*;
import javax.swing.JMenuItem;
import java.awt.*;
import java.awt.event.*;
/**
 * JMenuExample: An example of how to use JMenu
 */
public class JMenuExample extends JFrame
				  implements ActionListener
{
    // One will always need a menuBar, when using menus
    JMenuBar menuBar;
    // Individual JMenus are added to the menuBar
    JMenu menu;
    // Then individual menuItems are added to each JMenu
    JMenuItem menuItemNewGame;
    JMenuItem menuItemQuit;

    // This text field will be used to show how to capture an action 
    // on a JMenuItem
    JTextField textField = new JTextField("x----------------x");
    FlowLayout layout = new FlowLayout();

    public JMenuExample()
    {
	// The usual actions on Frames
	this.getContentPane().setLayout(layout);
	this.getContentPane().add(textField);
	// Create the menu bar first.
	menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	// Create the first menu and add it to the menuBar
	menu = new JMenu("File");
	menuBar.add(menu);

	// Now create a group of JMenuItems and add them to the
	// menu created above
	menuItemNewGame = new JMenuItem("New Game");
	menu.add(menuItemNewGame);
	menuItemQuit = new JMenuItem("Quit");
	menu.add(menuItemQuit);

	// The menuItems will require an actionListener
	menuItemNewGame.addActionListener(this);
	menuItemQuit.addActionListener(this);

	// The usual operations on JFrame
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("JMenu Example");
	this.pack();
	this.setVisible(true);
    }

    /**
     * Capture the actions by the user when selecting a JMenuItem
     */
    public void actionPerformed (ActionEvent e)
    {
	Object source = e.getSource();
	Class sourceClass = source.getClass();
	// Check if the source of the event is a JMenuItem
	if (sourceClass.getName().equals("javax.swing.JMenuItem"))
	{
	    // Now check which JMenuItem was selected by the user
	    JMenuItem item = (JMenuItem) source;
	    if (item == menuItemNewGame) 
		{
		    textField.setText("New Game!");
		}
	    if (item == menuItemQuit) 
		{
		    System.exit(0);
		}
	}
    }
    // The main method of the program
    public static void main(String args[])
    {
	JFrame frame = new JMenuExample();
    }
}

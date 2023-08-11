import javax.swing.*;
import javax.swing.JFileChooser;
import java.awt.*;
import java.awt.event.*;

/**
 * ExampleJFileChooser: An example of different ways to use JFileChooser
 */
public class ExampleJFileChooser extends JFrame
    implements ActionListener {

    JButton javaButton = new JButton("Open Java Files");
    JButton textButton = new JButton("Open Text Files");
    JButton javaOrTextButton = new JButton("Open Text or Java Files");
    JTextField valueField = new JTextField("Initial Text: ABCDEFGHIJKLMNOPQRST");
    FlowLayout layout = new FlowLayout();

/***********************************************************
Default constructor;
     adds the componets to the JFrame
     sets the ActionListeners for the buttons
     sets the WindowListener
************************************************************/
public ExampleJFileChooser(){
    // add the components to the container
   this.getContentPane().setLayout(layout);
   this.getContentPane().add(javaButton);
   this.getContentPane().add(textButton);
   this.getContentPane().add(javaOrTextButton);

   this.getContentPane().add(valueField);

    // set the ActionListeners for the buttons
   javaButton.addActionListener(this);
   textButton.addActionListener(this);
   javaOrTextButton.addActionListener(this);

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
    // This style of usage of JFileChooser is useful for situations
    // where the user should select among files with a particular extension
    // In this first example, the user will be able to choose one file
    // with the java extension
   if (currentButton == javaButton){
       JFileChooser chooser = new JFileChooser();
       ExampleFileFilter filter = new ExampleFileFilter();
       filter.addExtension("java");
       filter.setDescription("Java files");
       chooser.setFileFilter(filter);
       int returnVal=chooser.showOpenDialog(this);
       if  (returnVal == JFileChooser.APPROVE_OPTION) 
	   {
	       valueField.setText("You chose the file: "+
				  chooser.getSelectedFile().getName());
	   }
       if  (returnVal == JFileChooser.CANCEL_OPTION) 
	   {
	       valueField.setText("You chose not to open any file.");
	   }

   }
    // In this second example, the user will be able to choose one file
    // with the txt extension

   if (currentButton == textButton){
       JFileChooser chooser = new JFileChooser();
       ExampleFileFilter filter = new ExampleFileFilter();
       filter.addExtension("txt");
       filter.setDescription("Text files");
       chooser.setFileFilter(filter);
       int returnVal=chooser.showOpenDialog(this);
       if  (returnVal == JFileChooser.APPROVE_OPTION) 
	   {
	       valueField.setText("You chose the file: "+
				  chooser.getSelectedFile().getName());
	   }
       if  (returnVal == JFileChooser.CANCEL_OPTION) 
	   {
	       valueField.setText("You chose not to open any file.");
	   }

   }
    // In this third example, the user will be able to choose one file
    // with the txt or java extension.

   if (currentButton == javaOrTextButton){
       JFileChooser chooser = new JFileChooser();
       ExampleFileFilter filter = new ExampleFileFilter();
       filter.addExtension("text");
       filter.addExtension("java");
       filter.setDescription("Java or Text files");
       chooser.setFileFilter(filter);
       int returnVal=chooser.showOpenDialog(this);
       if  (returnVal == JFileChooser.APPROVE_OPTION) 
	   {
	       valueField.setText("You chose the file: "+
				  chooser.getSelectedFile().getName());
	   }
       if  (returnVal == JFileChooser.CANCEL_OPTION) 
	   {
	       valueField.setText("You chose not to open any file.");
	   }

   }

}
    /**
     * main
     */
    public static void main(String[] args) {
	JFrame frame = new ExampleJFileChooser();
    }
}

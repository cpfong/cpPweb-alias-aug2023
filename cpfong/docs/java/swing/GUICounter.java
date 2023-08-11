// must always import these packages for GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    
/***********************************************************
Sample application using Swing.  

@author Scott Grissom
@version August 30, 2002
************************************************************/
public class GUICounter extends JFrame 
    implements ActionListener {

   /** this instance variable is an example of separating Model and View */
   private Counter myCount;

   /** create GUI compoenents */
   JTextField display = new JTextField("   ");
   JButton bPlus = new JButton("+");
   JButton bMinus = new JButton("-");
   JButton bClear = new JButton("C");
   FlowLayout layout = new FlowLayout();

/***********************************************************
Default constructor;
     adds the componets to the JFrame
     sets the ActionListeners for the buttons
     sets the WindowListener
************************************************************/
public GUICounter(){
    // Instantiate a separate model object to keep track of the counter
   myCount = new Counter();
    // add the components to the container
   this.getContentPane().setLayout(layout);
   this.getContentPane().add(display);
   this.getContentPane().add(bPlus);
   this.getContentPane().add(bMinus);
   this.getContentPane().add(bClear);
    // set the ActionListeners for the buttons
   bPlus.addActionListener(this);
   bMinus.addActionListener(this);
   bClear.addActionListener(this);
    // Set the Window Listener (action to be taken when the window is closed
   addWindowListener(new TheWindowListener());

}



/***********************************************************
The main method will look similar for every application
that you create.

@param the String array of command line arguments
************************************************************/
public static void main (String [] args){
   JFrame f = new GUICounter();
   // f.setSize(250, 250);
   f.pack();
   f.setTitle ("My Counter Example");
   f.setVisible (true);
}

/***********************************************************
This method is required if you plan to respond to button
clicks.  
************************************************************/
public void actionPerformed (ActionEvent e){

    JButton currentButton = (JButton) e.getSource();
   // the user clicked on the Plus button
   if (currentButton == bPlus){
      myCount.increment();
      display.setText((new Integer(myCount.getCount())).toString());
   }

   // the user clicked on the Minus button
   if (currentButton == bMinus){
      myCount.decrement();
      display.setText((new Integer(myCount.getCount())).toString());
   }

   // the user clicked on the Clear button
   if (currentButton == bClear){
      myCount.reset();
      display.setText((new Integer(myCount.getCount())).toString());
   }


   // Disable the plus button if appropriate
   if (myCount.atMax())
      bPlus.setEnabled(false);
   else
      bPlus.setEnabled(true);


   // Make minus button disappear if appropriate
   if (myCount.atMin())
      bMinus.setVisible(false);
   else
      bMinus.setVisible(true);

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


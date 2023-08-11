
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
  import java.net.*;
          class AWTBrowser extends Frame { 
              private BufferedReader inStream;

              public static void main (String [] args) {
                  AWTBrowser demo = new AWTBrowser();
                

       frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());



      questionLabel = new JLabel("Type here.... ");
      window.add(questionLabel);

     questionField = new JTextField(30);
       window. add(questionField);
        questionField.addActionListener(this);

       
    }



    public void actionPerformed((actionEvent evt) {
                  if (evt.getSource() == loadButton) {
                      String urlString = nameField.getText();
                      String line;
                      try {
                          // create a link to a URL
                          URL urlAddress = new URL(urlString);
                          URLConnection link = 
                          urlAddress.openConnection();
                          inStream = new
                              BufferedReader(link.getInputStream());
                          while ((line = inStream.readLine()) != null) {
                              inputTextArea.append(line+ "\n"); 
                          }
                  }
                  // catch as in TinyBrowser...
                  }
              }
              return true;
          }
      // window shutdown and empty methods, as FileDemo2



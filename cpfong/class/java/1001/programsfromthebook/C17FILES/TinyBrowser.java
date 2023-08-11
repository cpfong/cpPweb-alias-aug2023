import java.io.*;
import java.net.*;
class TinyBrowser { 
    private BufferedReader inStream, keyboard;
    public static void main (String [] args) {
        TinyBrowser aBrowser = new TinyBrowser();
        aBrowser.fetch();
    }

    private void fetch() {
        String urlString = "";
        String line;
        keyboard = new BufferedReader(new 
            InputStreamReader(System.in));
        try {
            urlString = prompt("Type a URL " +
                             "(e.g. http://java.sun.com/): ");
            // create a connection to a URL
            URL urlAddress = new URL(urlString);
            URLConnection connection =
                                urlAddress.openConnection();
            inStream = new BufferedReader(new
                InputStreamReader(connection.getInputStream()));
            while ((line = inStream.readLine()) != null) {
                System.out.print(line); 
            }
        }
        catch (MalformedURLException e) {
            System.err.println(urlString + e.toString());
            System.exit(2);
        }
        catch (IOException e) {
            System.err.println("Error in accessing URL: "+
                               e.toString());
            System.exit(1);
        }
    } 

    private String prompt(String message) {
        String reply = "";
        try {
            System.out.print(message);
            System.out.flush();
            reply = keyboard.readLine();
        }
        catch (IOException e) {
            System.err.println("Keyboard "+ e.toString());
            System.exit(2);
        }
        return reply;
    }
}



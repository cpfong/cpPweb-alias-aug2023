package COMM.NBA;

import java.io.*;
import java.util.*;
import javax.comm.*;
import java.net.*;

/**
 * Class declaration
 *
 *
 * @author
 * @version 1.10, 08/04/00
 */
public class NBADialer {
     native void RasCallback();
     static Enumeration portList;
     static CommPortIdentifier portId;
     static String messageString = "ATDT9W150\r";
     static SerialPort serialPort;
     static OutputStream outputStream;
     static InputStream inputStream;
     static boolean outputBufferEmptyFlag = false;
     static boolean portFound = false;
     static String  defaultPort = "COM1";
     /**
      * Method declaration
      *
      *
      * @param args
      *
      * @see
      */
     public static void main(String[] args) {
        
        if (args.length > 0) {
           defaultPort = args[0];
        }
        portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(defaultPort)) {
                    System.out.println("Found port " + defaultPort);
                    portFound = true;
                    try {
                        serialPort = (SerialPort) portId.open("NBADialer", 2000);
                    } catch (PortInUseException e) {
                        System.out.println("Port in use.");
                        System.out.println(e.getMessage());
                    }
                    NBADialer nbaDialer = new NBADialer();
                }
            }
        } // end while
        if (!portFound) {
            System.out.println("port " + defaultPort + " not found.");
        }
    } // end main
    
    public void run() {
        try {
            Thread.sleep(120000);
        } catch (Exception e) {System.out.println(e.getMessage());}
    } // end run

    
    public NBADialer() {
        streamWriter writer = new streamWriter();
        streamReader reader = new streamReader();
    } // end NBADialer
    
    public class streamWriter implements Runnable{
        Thread writeThread;
        public streamWriter() {
            try {
                outputStream = serialPort.getOutputStream();
            } catch (IOException e) {System.out.println(e.getMessage());}
            try {
                serialPort.setSerialPortParams(9600,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
            } catch (UnsupportedCommOperationException e) {
                System.out.println(e.getMessage());
                System.out.println("Parameters are set to their default values: ");
                System.out.println("Baud Rate: " + serialPort.getBaudRate());
                System.out.println("Data Bits: " + serialPort.getDataBits());
                System.out.println("Stop Bits: " + serialPort.getStopBits());
                System.out.println("Parity: " + serialPort.getParity());
            }
            
            try {
                serialPort.notifyOnOutputEmpty(true);
            } catch (Exception e) {
                System.out.println("Error setting event notification");
                System.out.println(e.getMessage());
                System.exit(-1);
            }
            
        

            System.out.println("Writing " + messageString + " to " +serialPort.getName());
            try {
                outputStream.write(messageString.getBytes());
            } catch (IOException e) {System.out.println(e.getMessage());}
            writeThread = new Thread(this);
            writeThread.start();
        } // end stramWriter
        
        public void run() {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {System.out.println(e.getMessage());}
        } // end run
    } // end streamWriter
    
    public class streamReader implements Runnable, SerialPortEventListener {
        Thread readThread;
        public streamReader() {
            try {
                inputStream = serialPort.getInputStream();
            } catch (IOException e) {System.out.println(e.getMessage());}
            try {
                serialPort.addEventListener(this);
            } catch (TooManyListenersException e) {System.out.println(e.getMessage());}
            serialPort.notifyOnDataAvailable(true);
            
            readThread = new Thread(this);
            readThread.start();
        } // end streamReader
        
        public void serialEvent(SerialPortEvent event) {
            switch(event.getEventType()) {
                case SerialPortEvent.BI:
                case SerialPortEvent.OE:
                case SerialPortEvent.FE:
                case SerialPortEvent.PE:
                case SerialPortEvent.CD:
                case SerialPortEvent.CTS:
                case SerialPortEvent.DSR:
                case SerialPortEvent.RI:
                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                    break;
                case SerialPortEvent.DATA_AVAILABLE:
                    byte[] readBuffer = new byte[20];
                    
                    try {
                        while (inputStream.available() > 0) {
                            int numBytes = inputStream.read(readBuffer);
                        }
                        System.out.print(new String(readBuffer));
                    } catch (IOException e) {System.out.println(e.getMessage());}
                    break;
            }
        } // end serialEvent
        
        public void run() {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {System.out.println(e.getMessage());}
        } // end run
    } // end streamReader
} // end NBADialer

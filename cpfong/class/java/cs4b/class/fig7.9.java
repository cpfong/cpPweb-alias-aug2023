import javax.swing.*;
import java.awt.*;

public class test extends JApplet {
        public void start(){
                JTextArea o = new JTextArea();
                Container c = getContentPane();
                c.add(o);

                int arr[]={0,1,2};
                String st="before ";
                st += arr[0] + "\n";
                methodA(arr);
                st += "after " + arr[0] + "\n";
                o.setText(st);
        }       
        public void methodA(int parr[]){
                parr[0]=100;
        }
}

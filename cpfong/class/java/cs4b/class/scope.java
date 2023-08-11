import java.awt.Container;
import javax.swing.*;

public class test extends JApplet {

        JTextArea o;
        int gx = 1000;

        public void init(){
                Container c = getContentPane();
                o = new JTextArea();
                c.add(o);
        }

        public void start(){
                o.append("in start gx = " + gx + "\n");
                methodA();
                methodB();
                o.append("after method B gx = " + gx + "\n");
        }

        public void methodA(){
                int gx=1;
                o.append("in start gx = " + gx + "\n");
        }

        public void methodB(){
                gx=2;
        }

}
~                                                

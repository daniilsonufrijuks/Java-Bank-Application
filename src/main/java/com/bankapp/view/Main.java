package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Point;
import java.awt.GraphicsEnvironment;

// Main class
public class Main {
    public static GUILogReg frame;
    public static void main(String[] args) throws InterruptedException {
        // gui start -----------------------
        //StartWindow m = new StartWindow();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        JFrame stw = new JFrame();  
        stw.setTitle("MONOLITH Bank"); // set title
        JLabel label = new JLabel(new ImageIcon("resources/monolithbg.jpg")); // set background image
        stw.getContentPane().add(label); // add label to the frame
        // gui start -----------------------

        
        //stw.add(m);
        stw.setVisible(true);
        stw.setBounds(center.x - 400 / 2, center.y - 550 / 2, 400, 550); // to centre window
        stw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stw.setResizable(false);

        // -------------------------------------------------------------------------------------

        Thread.sleep(3000); // time sleep for 3 seconds
        stw.dispose(); // close the start window
        // log window
        frame = new GUILogReg(); // create a new frame
        frame.setTitle("MONOLITH Bank");
        frame.setVisible(true);
        //frame.setBounds(10, 10, 1200, 750);
        frame.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750); // to centre window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cleaner.FileCleaner;

import java.awt.Color;

import java.awt.Point;
import java.io.File;
import java.awt.GraphicsEnvironment;

// Main class
public class Main {
    public static GUILogReg frame;
    public static void main(String[] args) throws InterruptedException {
        //FileCleaner.CleanFile("resources/graphic.txt"); // clean the file
        //FileCleaner.CleanFile("resources/graphic2.txt"); // clean the file
        //FileCleaner.CleanFile("resources/graphic3.txt"); // clean the file
        // gui start -----------------------
        //StartWindow m = new StartWindow();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        JFrame stw = new JFrame();
        ImageIcon imgIcon = new ImageIcon("resources/program_logo.jpg");    // logo
        stw.setTitle("MONOLITH Bank"); // set title
        stw.setIconImage(imgIcon.getImage());   // set icon
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
        frame.setIconImage(imgIcon.getImage());     // set icon
        frame.setVisible(true);
        Color backgroundColor = new Color(211, 233, 252);   // for background color
        frame.getContentPane().setBackground(backgroundColor);
        //frame.setBounds(10, 10, 1200, 750);
        frame.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750); // to centre window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
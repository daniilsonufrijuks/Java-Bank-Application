package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class example {
    public static void main(String[]args)
    {
        //Create array containing shapes
        String[] shapes ={"(no shape selected)","Circle","Equilateral Triangle","Square"};
    
        //Use combobox to create drop down menu
        JComboBox comboBox=new JComboBox(shapes);
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("Select shape:");
        panel1.add(label1);
        panel1.add(comboBox);
    
        JButton button = new JButton("GO");
        JTextField text = new JTextField(20);
        //Create a JFrame that will be use to put JComboBox into it
        JFrame frame=new JFrame("Area Calculator Window");
        frame.setLayout(new FlowLayout()); //set layout
        frame.add(panel1);
        frame.add(text);
        frame.add(button);
        //set default close operation for JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        //set JFrame ssize
        frame.setSize(250,250);
    
        //make JFrame visible. So we can see it
        frame.setVisible(true);
    }
}

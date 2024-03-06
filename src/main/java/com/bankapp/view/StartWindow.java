package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;   

public class StartWindow extends Canvas {  
    //Container container = getContentPane();
    //ImageIcon icon = new ImageIcon("download.jpg");

    // StartWindow() {
    //     //setLayoutManager();
    //     addComponentsToContainer();
    // }

    // // public void setLayoutManager() {
    // //     container.setLayout(null);
    // // }

    // public void addComponentsToContainer() {
    //     container.add(new JLabel("download.jpg"));
    // }

    public void paint(Graphics g) {  
  
        Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("monolithbg.jpg");  
        g.drawImage(i, 400,550,this);  
          
    }  

}  
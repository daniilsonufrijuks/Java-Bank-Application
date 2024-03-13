package view;

import javax.swing.*;

import model.Person;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;   

// Remove the unnecessary import statement
// import view.GUILogReg.person;


public class GUIMainProgram extends JFrame implements ActionListener{  
    Container container = getContentPane();
    JTabbedPane tabPanel = new JTabbedPane(); 
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel usernameLabel;
    JLabel userlastnameLabel;
    //JButton addmButton = new JButton("ADD MONEY");

    public GUIMainProgram(String userText, String userlnameText) {
        usernameLabel = new JLabel(userText);
        userlastnameLabel = new JLabel(userlnameText);
        setLayoutManager();
        setLocationAndSize();
        panel1.add(new JLabel("Content for Tab 1"));
        panel2.add(new JLabel("Content for Tab 2"));
        panel3.add(new JLabel("Content for Tab 3"));
        tabPanel.addTab("Tab 1", panel1); 
        tabPanel.addTab("Tab 2", panel2); 
        tabPanel.addTab("Tab 3", panel3); 
        addComponentsToContainer();
        addActionEvent();


    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        usernameLabel.setBounds(1000, 20, 100, 30);
        userlastnameLabel.setBounds(1050, 20, 100, 30); 
        tabPanel.setBounds(0, 0, 1200, 750);
        //addmButton.setBounds(0, 0, 70, 20);
    }

    public void addComponentsToContainer() {
        container.add(usernameLabel);
        container.add(userlastnameLabel);
        // Add components to the panels
        container.add(tabPanel);
        // container.add(page1);
        // container.add(page2);
        // container.add(page3);
        //container.add(addmButton);
    }

    public void addActionEvent() {
        //addmButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == addmButton) {

        // }
    }



}  

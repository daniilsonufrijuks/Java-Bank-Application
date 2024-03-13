package view;

import javax.swing.*;

import controller.Login;
import controller.REGEXManager;
import controller.Registration;

import model.Person;
import controller.PersCode_Email_Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;   

public class GUILogReg extends JFrame implements ActionListener {  
    Container container = getContentPane();
    JLabel usernameLabel = new JLabel("NAME");
    JLabel userlastnameLabel = new JLabel("LAST NAME");
    JLabel userpcodeLabel = new JLabel("PERSONAL CODE");
    JLabel useremailLabel = new JLabel("EMAIL");
    JLabel userLabel = new JLabel("USERNAME");
    JTextField usernameField = new JTextField();
    JTextField userlastnameField = new JTextField();
    JTextField userpcodetField = new JTextField();
    JTextField useremailField = new JTextField();
    JTextField userLabelField = new JTextField();
    JButton loginButton = new JButton("LOGIN");
    JButton regButton = new JButton("REGISTER");
    JCheckBox showPCode = new JCheckBox("Show PCode");


    public GUILogReg() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        usernameLabel.setBounds(450, 20, 100, 30);
        userlastnameLabel.setBounds(450, 60, 100, 30);
        userpcodeLabel.setBounds(450, 100, 100, 30);
        useremailLabel.setBounds(450, 140, 100, 30);
        userLabel.setBounds(450, 180, 100, 30);
        usernameField.setBounds(610, 20, 100, 30);
        userlastnameField.setBounds(610, 60, 100, 30);
        userpcodetField.setBounds(610, 100, 100, 30);
        useremailField.setBounds(610, 140, 100, 30);
        userLabelField.setBounds(610, 180, 100, 30);
        showPCode.setBounds(500, 250, 150, 30);
        loginButton.setBounds(450, 300, 100, 30);
        regButton.setBounds(600, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(usernameLabel);
        container.add(userlastnameLabel);
        container.add(userpcodeLabel);
        container.add(useremailLabel);
        container.add(userLabel);
        container.add(usernameField);
        container.add(userlastnameField);
        container.add(userpcodetField);
        container.add(useremailField);
        container.add(userLabelField);
        container.add(showPCode);
        container.add(loginButton);
        container.add(regButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        regButton.addActionListener(this);
        showPCode.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regButton) { // to registrate person
            String userText;
            String userlnameText;
            String userpcodetText;
            String useremailText;
            String userlabelText;
            userText = usernameField.getText();
            userlnameText = userlastnameField.getText();
            userpcodetText = userpcodetField.getText();
            useremailText = useremailField.getText();
            userlabelText = userLabelField.getText();

            Person person = new Person(userText, userlnameText, userpcodetText, useremailText, userlabelText);

            if (PersCode_Email_Controller.PersCodeCheckIfInCSVFile(person) == false){   // if check for personal code didn't pass (pc already exists in csv file)
                JOptionPane.showMessageDialog(this, "This personal code already exists.");
            } else if (PersCode_Email_Controller.EmailCheckIfInCSVFile(person) == false){
                JOptionPane.showMessageDialog(this, "This email already exists.");  // if check for email didn' pass (email already exists in csv file)
            } else {
                Registration reg = new Registration();
                reg.WriteToAFile(person);
            }

            // if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
            //     JOptionPane.showMessageDialog(this, "Login Successful");
            // } else {
            //     JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            // }

        }
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        if (e.getSource() == loginButton) { // to login person
            String userText;
            String userlnameText;
            String userpcodetText;
            String useremailText;
            String userlabelText;
            userText = usernameField.getText();
            userlnameText = userlastnameField.getText();
            userpcodetText = userpcodetField.getText();
            useremailText = useremailField.getText();
            userlabelText = userLabelField.getText();

            boolean logb = false;
            REGEXManager regMan = new REGEXManager();
            if (regMan.NameRegex(userText) && regMan.NameRegex(userlnameText) && regMan.PersoncodeRegex(userpcodetText) && regMan.EmailRegex(useremailText)) {
                Login login = new Login();
                logb = login.login(userText, userlnameText, userpcodetText, useremailText, userlabelText);
                System.out.println(logb);
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            if (logb == true) {
                GUIMainProgram frame2 = new GUIMainProgram(userText, userlnameText);
                frame2.setTitle("MONOLITH Bank");
                frame2.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750); // to centre window
                //frame2.setBounds(10, 10, 1200, 750);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setResizable(false);

                // JTabbedPane tabPanel = new JTabbedPane(); 
  
                // // Create the first tab (page1) and add a JLabel to it 
                // JPanel page1 = new JPanel(); 
                // page1.add(new JLabel("This is Tab 1")); 
  
                // // Create the second tab (page2) and add a JLabel to it 
                // JPanel page2 = new JPanel(); 
                // page2.add(new JLabel("This is Tab 2")); 
  
                // // Create the third tab (page3) and add a JLabel to it 
                // JPanel page3 = new JPanel(); 
                // page3.add(new JLabel("This is Tab 3")); 
  
                // Add the three tabs to the JTabbedPane 
                // tabPanel.addTab("Tab 1", page1); 
                // tabPanel.addTab("Tab 2", page2); 
                // tabPanel.addTab("Tab 3", page3); 
  
                // Add the JTabbedPane to the JFrame's content 
                //frame2.add(tabPanel); 
  
                // Make the JFrame visible 
                frame2.setVisible(true); 


            }
            
        }
        // if (e.getSource() == userpcodetText) {
        //     if (userpcodetText.isSelected()) {
        //         userlastnameField.setEchoChar((char) 0);
        //     } else {
        //         userlastnameField.setEchoChar('*');
        //     }
        // }
    }  
}  // +

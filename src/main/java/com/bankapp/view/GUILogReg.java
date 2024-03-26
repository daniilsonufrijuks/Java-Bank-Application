package view;

import javax.swing.*;

import logreg.Login;
import logreg.Registration;
import model.Person;
import regex.REGEXManager;
// Remove the unnecessary import statement
// import Main;
import controller.PersCode_Email_Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;   
//import main.java.com.bankapp.Main;

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
    JTextField userNicknameField = new JTextField();
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
        userNicknameField.setBounds(610, 180, 100, 30);
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
        container.add(userNicknameField);
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
            String usernicknameText;
            userText = usernameField.getText();
            userlnameText = userlastnameField.getText();
            userpcodetText = userpcodetField.getText();
            useremailText = useremailField.getText();
            usernicknameText = userNicknameField.getText();

            Person person = new Person(userText, userlnameText, userpcodetText, useremailText, usernicknameText);

            if (PersCode_Email_Controller.PersCodeCheckIfInCSVFile(person) == false){   // if check for personal code didn't pass (pc already exists in csv file)
                JOptionPane.showMessageDialog(this, "This personal code already exists.");
            } else if (PersCode_Email_Controller.EmailCheckIfInCSVFile(person) == false){
                JOptionPane.showMessageDialog(this, "This email already exists.");  // if check for email didn' pass (email already exists in csv file)
            } else {
                Registration reg = new Registration();
                reg.WriteToAFile(person);
                JOptionPane.showMessageDialog(this, "Registration Successful");
            }

        }
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        if (e.getSource() == loginButton) { // to login person
            String userText;
            String userlnameText;
            String userpcodetText;
            String useremailText;
            String userNicknameText;
            userText = usernameField.getText();
            userlnameText = userlastnameField.getText();
            userpcodetText = userpcodetField.getText();
            useremailText = useremailField.getText();
            userNicknameText = userNicknameField.getText();

            boolean logb = false;
            if (REGEXManager.NameRegex(userText) && REGEXManager.NameRegex(userlnameText) && REGEXManager.PersoncodeRegex(userpcodetText) && REGEXManager.EmailRegex(useremailText)) {  // REGEX check
                if (Login.login(userText, userlnameText, userpcodetText, useremailText, userNicknameText)){       // if this user was found in csv file
                    logb = true;
                    JOptionPane.showMessageDialog(this, "Login Successful");
                } else {    // user wasnt found
                    JOptionPane.showMessageDialog(this, "This user does not exist.");
                }
            } else {    // REGEX didnt pass
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            if (logb == true) {
                GUIMainProgram frame2 = new GUIMainProgram(userText, userlnameText, userpcodetText, useremailText);
                Main.frame.dispose();
                //Point center2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
                JFrame stwm = new JFrame();  
                stwm.setTitle("MONOLITH Bank"); // set title
                JLabel label = new JLabel(new ImageIcon("resources/hamster.jpg")); // set background image
                stwm.getContentPane().add(label); // add label to the frame
                // gui start -----------------------
                //stw.add(m);
                stwm.setVisible(true);
                stwm.setBounds(center.x - 400 / 2, center.y - 550 / 2, 400, 550); // to centre window
                stwm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                stwm.setResizable(false);
                // -------------------------------------------------------------------------------------

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } // time sleep for 3 seconds

                // Timer timer = new Timer(3000, new ActionListener() {
                //     @Override
                //     public void actionPerformed(ActionEvent e) {
                //         stwm.setVisible(true);
                //     }
                // });
                // timer.setRepeats(false);
                // timer.start();
                stwm.dispose(); // close the start window

                //GUIMainProgram frame2 = new GUIMainProgram(userText, userlnameText);
                frame2.setTitle("MONOLITH Bank");
                frame2.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750); // to centre window
                //frame2.setBounds(10, 10, 1200, 750);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setResizable(false);
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

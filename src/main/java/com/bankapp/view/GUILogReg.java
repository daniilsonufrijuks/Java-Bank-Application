package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import logreg.Login;
import logreg.Registration;
import managers.BankAccountManager;
import managers.CreditManager;
import model.Numbers;
import model.Person;
import regex.REGEXManager;
// Remove the unnecessary import statement
// import Main;
import controller.PersCode_Email_Controller;
import generator.PinKontGen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;   
//import main.java.com.bankapp.Main;
import java.io.File;
import java.io.IOException;
import view.RoundJTextField;

public class GUILogReg extends JFrame implements ActionListener {  
    Container container = getContentPane();
    JLabel welcomeLabel = new JLabel("Welcome to Monolith!");
    JLabel usernameLabel = new JLabel("Name");
    JLabel userlastnameLabel = new JLabel("Last name");
    JLabel userpcodeLabel = new JLabel("Personal code");
    JLabel useremailLabel = new JLabel("Email address");
    JLabel userLabel = new JLabel("Username");
    RoundJTextField usernameField = new RoundJTextField(20);
    RoundJTextField userlastnameField = new RoundJTextField(20);
    RoundJTextField userpcodetField = new RoundJTextField(20);
    RoundJTextField useremailField = new RoundJTextField(20);
    RoundJTextField userNicknameField = new RoundJTextField(20);
    JButton loginButton = new JButton("Login");
    JButton regButton = new JButton("Register");

    Color titleColor = new Color(203, 0, 0);
    Color defaultBackgroundColor = new Color(211, 233, 252);

    Font textFont = new Font("Arial", Font.BOLD, 15); // set font for text area
    Font titleFont = new Font("Arial", Font.BOLD, 40);
    ImageIcon imgIcon = new ImageIcon("resources/program_logo.jpg");    // logo
    ImageIcon imgForFrame = new ImageIcon("resources/logo_small_forGUIlogreg.jpg");   // to put on frame
    JLabel imageLabel = new JLabel(imgForFrame);

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
        welcomeLabel.setBounds(395, 25, 500, 100);
        usernameLabel.setBounds(435, 340, 100, 30);
        userlastnameLabel.setBounds(435, 380, 100, 30);
        userpcodeLabel.setBounds(435, 420, 170, 30);
        useremailLabel.setBounds(435, 460, 100, 30);
        userLabel.setBounds(435, 500, 100, 30);
        usernameField.setBounds(575, 340, 200, 30);
        userlastnameField.setBounds(575, 380, 200, 30);
        userpcodetField.setBounds(575, 420, 200, 30);
        useremailField.setBounds(575, 460, 200, 30);
        userNicknameField.setBounds(575, 500, 200, 30);
        loginButton.setBounds(435, 570, 150, 30);
        regButton.setBounds(625, 570, 150, 30);
        imageLabel.setBounds(529, 120, 142, 194);        
        //fonts and colors
        welcomeLabel.setFont(titleFont);
        welcomeLabel.setForeground(titleColor);

        usernameLabel.setFont(textFont);
        userlastnameLabel.setFont(textFont);
        userpcodeLabel.setFont(textFont);
        useremailLabel.setFont(textFont);
        userLabel.setFont(textFont);
        loginButton.setBackground(titleColor);
        loginButton.setForeground(Color.WHITE);     
        loginButton.setFont(textFont);
        regButton.setBackground(titleColor);
        regButton.setForeground(Color.WHITE);     
        regButton.setFont(textFont);   
    }

    public void addComponentsToContainer() {
        container.add(welcomeLabel);
        container.add(imageLabel);
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
        container.add(loginButton);
        container.add(regButton);
        
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        regButton.addActionListener(this);
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
            } else if (!REGEXManager.NameRegex(userText) || !REGEXManager.NameRegex(userlnameText) || !REGEXManager.PersoncodeRegex(userpcodetText) || !REGEXManager.EmailRegex(useremailText)) {   // if input is invalid or blank
                JOptionPane.showMessageDialog(this, "Invalid data.");
            } else {
                Registration reg = new Registration();
                Numbers num = new Numbers(0.00f, 3500.59f); // create a new object of Numbers to gen balance <<<<<<<<<<
                reg.WriteToAFile(person, PinKontGen.generateRandomNumber(num.getNumber1(), num.getNumber2())); // write to file
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
                GUIMainProgram frame2 = new GUIMainProgram(userText, userlnameText, userpcodetText, useremailText, userNicknameText);
                

                // to destroy the login frame
                if (Main.frame != null) {
                    Main.frame.dispose();
                }
                //Main.frame.dispose();
                if (GUIMainProgram.framelogreg != null) { // if the login frame is not null (it is opened)
                    GUIMainProgram.framelogreg.dispose(); // close the login frame
                }
                //GUIMainProgram.framelogreg.dispose();
                //Point center2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();


                JFrame stwm = new JFrame();  
                stwm.setTitle("MONOLITH Bank"); // set title
                stwm.setIconImage(imgIcon.getImage());  // set icon
                // JLabel label = new JLabel(new ImageIcon("resources/hamster.jpg")); // set background image
                // stwm.getContentPane().add(label); // add label to the frame
                // // gui start -----------------------
                // //stw.add(m);
                // stwm.setVisible(true);
                // stwm.setBounds(center.x - 400 / 2, center.y - 550 / 2, 400, 550); // to centre window
                // stwm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //try {
                    // Load the image
                    //Image image = ImageIO.read(new File("resources/hamster.jpg"));
                // ImageIcon loadingIcon = new ImageIcon("resources/loading.gif");
                // // Create a label with the image
                // JLabel label = new JLabel(loadingIcon);
                // stwm.getContentPane().add(label); // add label to the frame
                    
                // // Rest of your code...
                // // } catch (IOException ex) {
                // //     ex.printStackTrace();
                // // }
                // stwm.setBounds(center.x - 400 / 2, center.y - 550 / 2, 400, 550); // to centre window
                // stwm.setVisible(true);
                // //stwm.setResizable(false);
                // stwm.setVisible(true);
                // -------------------------------------------------------------------------------------

                // try {
                //     Thread.sleep(3000);
                // } catch (InterruptedException e1) {
                //     e1.printStackTrace();
                // } // time sleep for 3 seconds

                // Create a Timer that executes the following code after 3 seconds


                // Load the loading animation
                ImageIcon loadingIcon = new ImageIcon("resources/loading.gif");

                // Create a label with the loading animation
                JLabel loadingLabel = new JLabel(loadingIcon);

                // Add the label to the frame
                stwm.getContentPane().add(loadingLabel);

                // Make the frame visible
                stwm.setVisible(true);
                stwm.setBounds(center.x - 400 / 2, center.y - 550 / 2, 400, 550); // to centre window

                // Create a Timer that executes the following code after 3 seconds
                new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Remove the loading animation
                        stwm.getContentPane().remove(loadingLabel);

                        // Add the main content to the frame
                        // For example, add a label with an image
                        try {
                            Image image = ImageIO.read(new File("resources/loading.gif"));
                            JLabel label = new JLabel(new ImageIcon(image));
                            stwm.getContentPane().add(label);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        // Repaint the frame to reflect the changes
                        stwm.revalidate();
                        stwm.repaint();
                        stwm.dispose(); // close the start window
                    }
                }).start();

                //GUIMainProgram frame2 = new GUIMainProgram(userText, userlnameText);

                int res = 0;
                if (BankAccountManager.IfSomebodySentMoney(userpcodetText)) {
                    BankAccountManager.DeleteMessage(userpcodetText);
                    //JOptionPane.showMessageDialog(this, "You have received money!");

                    System.out.println("-----------------------------------------------------");

                    JPanel panel = new JPanel();
                    panel.setLayout(null);
                    panel.setPreferredSize(new Dimension(400, 550)); // Set the size of the panel
                    JLabel label = new JLabel("You have received money!");
                    label.setBounds(15, 153, 350, 30);
                    label.setFont(new Font("Arial", Font.BOLD, 20));
                    panel.add(label);
                    res = JOptionPane.showOptionDialog(null, panel, "Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                }
                
                if (res == -1) {
                   CreditManager.DeleteMessage(userpcodetText);
                }

                frame2.setTitle("MONOLITH Bank");
                frame2.setIconImage(imgIcon.getImage());    // set icon
                frame2.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750); // to centre window
                //frame2.setBounds(10, 10, 1200, 750);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setResizable(false);
                // Make the JFrame visible 
                frame2.setVisible(true);
                frame2.setBackground(defaultBackgroundColor);
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

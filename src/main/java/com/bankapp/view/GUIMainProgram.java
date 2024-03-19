package view;

import javax.swing.*;

import controller.BankAccountManager;
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
    ImageIcon imageIcon = new ImageIcon("resources/hamster.jpg"); 
    ImageIcon imageIcon2 = new ImageIcon("resources/monolithad.jpg"); 
    JLabel imageLabel = new JLabel(imageIcon);
    JLabel imageLabel2 = new JLabel(imageIcon2);
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel usernameLabel;
    JLabel userlastnameLabel;
    JLabel userbalanceLabel;

    // For Panel Send

    JTextField recUsernameField;
    JTextField recBankAccountFIeld;
    JTextField moneyToSendField;
    JLabel recUsernameLabel = new JLabel("Receiver username");
    JLabel recBankAccountLabel = new JLabel("Receiver bank account");
    JLabel moneyToSendLabel = new JLabel("Money");

    JButton sendButton = new JButton("SUBMIT");

    public GUIMainProgram(String userText, String userlnameText) {
        usernameLabel = new JLabel(userText);
        userlastnameLabel = new JLabel(userlnameText);

        // For panel Send
        recUsernameField = new JTextField();
        recBankAccountFIeld = new JTextField();
        moneyToSendField = new JTextField();

        userbalanceLabel = new JLabel(String.valueOf(BankAccountManager.GetBalance(userText, userlnameText)));
        setLayoutManager();
        setLocationAndSize();
        // panel1.add(new JLabel("Content for Tab 1"));
        // panel2.add(new JLabel("Content for Tab 2"));
        // panel3.add(new JLabel("Content for Tab 3"));
        // panel1.add(usernameLabel);
        // panel1.add(userlastnameLabel);
        // //ImageIcon imageIcon = new ImageIcon("resources/hamster.jpg"); // replace with your image file path
        // //JLabel imageLabel = new JLabel(imageIcon);
        // //panel1.setLayout(null);
        // panel1.add(imageLabel);
        // tabPanel.addTab("Main", panel1); 
        // tabPanel.addTab("Add", panel2); 
        // tabPanel.addTab("Send", panel3); 
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        //container.setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
    }

    public void setLocationAndSize() {
        usernameLabel.setBounds(1000, 20, 100, 30);
        userlastnameLabel.setBounds(1050, 20, 100, 30); 
        userbalanceLabel.setBounds(30, 20, 100, 30);
        tabPanel.setBounds(0, 0, 1200, 750);
        imageLabel.setBounds(100, 30, 50, 50);
        imageLabel2.setBounds(0, 0, 1200, 750);
        //addmButton.setBounds(0, 0, 70, 20);

        //For panel Send
        recUsernameField.setBounds(100, 40, 100, 30);
        recBankAccountFIeld.setBounds(100, 90, 100, 30);
        moneyToSendField.setBounds(100, 140, 100, 30);
        sendButton.setBounds(110, 190, 100, 30);

        recUsernameLabel.setBounds(5, 40, 100, 30);
        recBankAccountLabel.setBounds(5, 90, 100, 30);
        moneyToSendLabel.setBounds(5, 140, 100, 30);
    }

    public void addComponentsToContainer() {
        //container.add(usernameLabel);
        //container.add(userlastnameLabel);
        // Add components to the panels
        container.add(tabPanel);
        panel1.add(usernameLabel);
        panel1.add(userlastnameLabel);
        panel1.add(userbalanceLabel);
        //ImageIcon imageIcon = new ImageIcon("resources/hamster.jpg"); // replace with your image file path
        //JLabel imageLabel = new JLabel(imageIcon);
        //panel1.setLayout(null);

        // For panel Send
        panel2.add(recUsernameField);
        panel2.add(recBankAccountFIeld);
        panel2.add(moneyToSendField);
        panel2.add(recUsernameLabel);
        panel2.add(recBankAccountLabel);
        panel2.add(moneyToSendLabel);
        panel5.add(imageLabel2);

        panel2.add(sendButton);

        panel1.add(imageLabel);
        tabPanel.addTab("Main", panel1); 
        tabPanel.addTab("Send", panel2); 
        tabPanel.addTab("Credits", panel3); 
        tabPanel.addTab("Stock exchange", panel4);
        tabPanel.addTab("About us", panel5);
        //container.add(addmButton);

    }

    public void addActionEvent() {
        //addmButton.addActionListener(this);
        sendButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            String recUsername = recUsernameField.getText();
            String recBankAccount = recBankAccountFIeld.getText();
            String moneyToSend = moneyToSendField.getText();
            BankAccountManager.SendMoney(recUsername, recBankAccount, moneyToSend);
            //userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(usernameLabel.getText(), userlastnameLabel.getText())));
        }
    }



}  

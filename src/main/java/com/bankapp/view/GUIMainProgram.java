package view;

import javax.swing.*;

import controller.AutoSendonYourEmail;
import controller.BankAccountManager;
import controller.Login;
import controller.REGEXManager;
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
    ImageIcon imageIcon3 = new ImageIcon("resources/monolithenjoyer.jpg");
    JLabel imageLabel = new JLabel(imageIcon);
    JLabel imageLabel2 = new JLabel(imageIcon2);
    JLabel imageLabel3 = new JLabel(imageIcon3);
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel usernameLabel;
    JLabel userlastnameLabel;
    JLabel userbalanceLabel;
    JTextArea textaboutusB;

    // For Panel Send

    JTextField recUsernameField;
    JTextField recBankAccountField;
    JTextField moneyToSendField;

    // For Panel Send lables
    JLabel recUsernameLabel = new JLabel("Receiver username");
    JLabel recBankAccountLabel = new JLabel("Receiver bank account");
    JLabel moneyToSendLabel = new JLabel("Money");
    JLabel moneyLabel = new JLabel("YOUR BALANCE: ");

    JLabel credit = new JLabel("CREDIT OPTION 1");
    JLabel credit2 = new JLabel("CREDIT OPTION 2");
    JLabel credit3 = new JLabel("CREDIT OPTION 3");
    JLabel credit4 = new JLabel("CREDIT OPTION 4");
    JLabel credit5 = new JLabel("CREDIT OPTION 5");


    // For Panel about us
    String textaboutus = "Finanšu pasaules miglainajās vietās pastāv banka, kas pazīstama kā Monolīts. \n" +
    "Tās dīvainības un mistikas reputācija piesaista uzmanību. Daži saka, ka šai bankai \n" +
    "ir tiesības parastos ieguldījumus pārveidot par kaut ko vērtīgāku, piemēram, \n" +
    "artefaktus no citas dimensijas. Ne visi uzdrošinās ienākt tās durvīm, baidoties \n" +
    "no negaidītiem pārbaudījumiem un sarežģītiem apstākļiem. Tomēr tie, kas ir drosmīgi \n" +
    "iegājuši iekšā, saka, ka atlīdzība par risku var būt ievērojama. Nav skaidrs, \n" +
    "vai Monolīts ir mīts vai realitāte, taču daudzi finanšu piedzīvojumu meklētāji \n" +
    "turpina pētīt tā noslēpumainās iespējas.";
    
    JButton sendButton = new JButton("SUBMIT"); // button for send panel
    // For Panel Credits
    JButton TAKEButton = new JButton("TAKE"); // button for take panel
    JButton TAKE2Button = new JButton("TAKE"); // button for take panel
    JButton TAKE3Button = new JButton("TAKE"); // button for take panel
    JButton TAKE4Button = new JButton("TAKE"); // button for take panel
    JButton TAKE5Button = new JButton("TAKE"); // button for take panel

    Font newFont = new Font("default", Font.PLAIN, 17); // set font for text area

    public GUIMainProgram(String userText, String userlnameText) {
        usernameLabel = new JLabel(userText);
        userlastnameLabel = new JLabel(userlnameText);
        //textaboutusB = new JLabel(textaboutus);

        textaboutusB = new JTextArea(textaboutus); // added textaboutus to text area
        textaboutusB.setLineWrap(true);
        textaboutusB.setWrapStyleWord(true);
        textaboutusB.setEditable(false);

        // For panel Send
        recUsernameField = new JTextField();
        recBankAccountField = new JTextField();
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
        addComponentsToContainer(); // add components to the container
        addActionEvent(); // add action event
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
        // Setting location and Size of each components using setBounds() method.
        usernameLabel.setBounds(1000, 20, 100, 30);
        userlastnameLabel.setBounds(1050, 20, 100, 30); 
        moneyLabel.setBounds(10, 20, 150, 30);
        userbalanceLabel.setBounds(150, 20, 100, 30);
        // Set font for the labels
        userbalanceLabel.setFont(newFont);
        moneyLabel.setFont(newFont);
        usernameLabel.setFont(newFont);
        userlastnameLabel.setFont(newFont);

        tabPanel.setBounds(0, 0, 1200, 750); // tab position

        imageLabel.setBounds(920, 17, 50, 50); // image position
        imageLabel2.setBounds(370, 5, 400, 250);
        //imageLabel3.setBounds(500, 5, 400, 250);

        textaboutusB.setBounds(290, 290, 600, 450); // text area position
        textaboutusB.setFont(newFont);

        //For panel Send text fields
        recUsernameField.setBounds(180, 40, 200, 30);
        recBankAccountField.setBounds(180, 90, 200, 30);
        moneyToSendField.setBounds(180, 140, 200, 30);

        // Buttons   
        sendButton.setBounds(215, 190, 100, 30);

        TAKEButton.setBounds(50, 50, 100, 30);
        TAKE2Button.setBounds(50, 100, 100, 30);
        TAKE3Button.setBounds(50, 150, 100, 30);
        TAKE4Button.setBounds(50, 200, 100, 30);
        TAKE5Button.setBounds(50, 250, 100, 30);

        // For panel Credits lables
        credit.setBounds(120, 50, 200, 30);
        credit2.setBounds(120, 100, 200, 30);
        credit3.setBounds(120, 150, 200, 30);
        credit4.setBounds(120, 200, 200, 30);
        credit5.setBounds(120, 250, 200, 30);


        // For panel Send lables
        recUsernameLabel.setBounds(5, 40, 150, 30);
        recBankAccountLabel.setBounds(5, 90, 150, 30);
        moneyToSendLabel.setBounds(5, 140, 150, 30);
        // Set font for the labels
        recUsernameLabel.setFont(newFont);
        recBankAccountLabel.setFont(newFont);
        moneyToSendLabel.setFont(newFont); // set font 
    }

    public void addComponentsToContainer() {
        //container.add(usernameLabel);
        //container.add(userlastnameLabel);
        // Add components to the panels
        container.add(tabPanel);
        panel1.add(usernameLabel);
        panel1.add(userlastnameLabel);
        panel1.add(userbalanceLabel);
        panel1.add(moneyLabel);
        //ImageIcon imageIcon = new ImageIcon("resources/hamster.jpg"); // replace with your image file path
        //JLabel imageLabel = new JLabel(imageIcon);
        //panel1.setLayout(null);

        // For panel Send
        panel2.add(recUsernameField);
        panel2.add(recBankAccountField);
        panel2.add(moneyToSendField);
        panel2.add(recUsernameLabel);
        panel2.add(recBankAccountLabel);
        panel2.add(moneyToSendLabel);

        panel5.add(imageLabel2);
        //panel5.add(imageLabel3);

        panel2.add(sendButton);

        panel5.add(textaboutusB);

        panel1.add(imageLabel); // add image to the panel

        // For panel Credits
        panel3.add(TAKEButton);
        panel3.add(TAKE2Button);
        panel3.add(TAKE3Button);
        panel3.add(TAKE4Button);

        // For panel Credits lables
        panel3.add(credit);
        panel3.add(credit2);
        panel3.add(credit3);
        panel3.add(credit4);
        panel3.add(credit5);

        // Panels   
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
            //AutoSendonYourEmail.SendEmail();
            String recUsername = recUsernameField.getText();
            String recBankAccount = recBankAccountField.getText();
            float moneyToSend = Float.valueOf(moneyToSendField.getText());
            if (BankAccountManager.CheckSendData(recUsername, recBankAccount, moneyToSend) && REGEXManager.isValidFloat(String.valueOf(moneyToSend))){
                BankAccountManager.SendMoney(recUsername, recBankAccount, moneyToSend);
                JOptionPane.showMessageDialog(this, "Success transaction!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(usernameLabel.getText(), userlastnameLabel.getText()))); // update balance
        }
    }
    
}

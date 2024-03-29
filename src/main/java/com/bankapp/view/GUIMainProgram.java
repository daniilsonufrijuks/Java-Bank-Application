package view;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;

import controller.AutoSendonYourEmail;
import logreg.Login;
import managers.BankAccountManager;
import managers.CreditManager;
import model.Person;
import model.Transaction;
import regex.REGEXManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.math.BigDecimal; 

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
    // for SendMoney
    JLabel userPCodeLabel;
    JLabel userEmailLabel;
    //
    JLabel userbalanceLabel;
    JTextArea textaboutusB;

    // For Panel Send
    JTextField creditoptionfiled1;
    JTextField creditoptionfiled2;
    JTextField creditoptionfiled3;
    JTextField creditoptionfiled4;
    JTextField creditoptionfiled5;

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

    JLabel credityear = new JLabel("1 YEAR");
    JLabel credityear2 = new JLabel("2 YEAR");
    JLabel credityear3 = new JLabel("3 YEAR");
    JLabel credityear4 = new JLabel("4 YEAR");
    JLabel credityear5 = new JLabel("5 YEAR");

    JLabel percentsy = new JLabel("25%");
    JLabel percentsy2 = new JLabel("20%");
    JLabel percentsy3 = new JLabel("15%");
    JLabel percentsy4 = new JLabel("14%");
    JLabel percentsy5 = new JLabel("5%");

    JLabel creditsum1 = new JLabel("CREDIT SUM: ");
    JLabel creditsum2 = new JLabel("CREDIT SUM: ");
    JLabel creditsum3 = new JLabel("CREDIT SUM: ");
    JLabel creditsum4 = new JLabel("CREDIT SUM: ");
    JLabel creditsum5 = new JLabel("CREDIT SUM: ");

    JLabel creditsumtotal = new JLabel();
    JLabel creditsumtotal2 = new JLabel();
    JLabel creditsumtotal3 = new JLabel();
    JLabel creditsumtotal4 = new JLabel();
    JLabel creditsumtotal5 = new JLabel();

    JLabel creditsum;

    String userpCode;
    // color change
    JCheckBox darkModeChBox = new JCheckBox("Dark Mode");
    Color defaultBackgroundColor = new Color(211, 233, 252);
    Color defaultColorForFrame = new Color(119, 203, 233);
    //

    //For Panel about us
    String textaboutus = "Finanšu pasaules miglainajās vietās pastāv banka, kas pazīstama kā Monolīts. \n" +
    "Tās dīvainības un mistikas reputācija piesaista uzmanību. Daži saka, ka šai bankai \n" +
    "ir tiesības parastos ieguldījumus pārveidot par kaut ko vērtīgāku, piemēram, \n" +
    "artefaktus no citas dimensijas. Ne visi uzdrošinās ienākt tās durvīm, baidoties \n" +
    "no negaidītiem pārbaudījumiem un sarežģītiem apstākļiem. Tomēr tie, kas ir drosmīgi \n" +
    "iegājuši iekšā, saka, ka atlīdzība par risku var būt ievērojama. Nav skaidrs, \n" +
    "vai Monolīts ir mīts vai realitāte, taču daudzi finanšu piedzīvojumu meklētāji \n" +
    "turpina pētīt tā noslēpumainās iespējas. \n\n" +
    "Link to us - https://daniilsonufrijuks.github.io/MONOLITH.github.io/";


    // JEditorPane textaboutus = new JEditorPane();
    // textaboutus.setContentType("text/html");
    // textaboutus.setEditable(false);
    // textaboutus.setOpaque(false);
    // textaboutus.setText("<html>" +
    //     "Finanšu pasaules miglainajās vietās pastāv banka, kas pazīstama kā Monolīts. <br>" +
    //     "Tās dīvainības un mistikas reputācija piesaista uzmanību. Daži saka, ka šai bankai <br>" +
    //     "ir tiesības parastos ieguldījumus pārveidot par kaut ko vērtīgāku, piemēram, <br>" +
    //     "artefaktus no citas dimensijas. Ne visi uzdrošinās ienākt tās durvīm, baidoties <br>" +
    //     "no negaidītiem pārbaudījumiem un sarežģītiem apstākļiem. Tomēr tie, kas ir drosmīgi <br>" +
    //     "iegājuši iekšā, saka, ka atlīdzība par risku var būt ievērojama. Nav skaidrs, <br>" +
    //     "vai Monolīts ir mīts vai realitāte, taču daudzi finanšu piedzīvojumu meklētāji <br>" +
    //     "turpina pētīt tā noslēpumainās iespējas. <br><br>" +
    //     "<a href='https://daniilsonufrijuks.github.io/MONOLITH.github.io/'>Link to us</a>" +
    //     "</html>");
    // textaboutus.addHyperlinkListener(new HyperlinkListener() {
    //     public void hyperlinkUpdate(HyperlinkEvent hle) {
    //         if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
    //             Desktop desktop = Desktop.getDesktop();
    //             try {
    //                 desktop.browse(hle.getURL().toURI());
    //             } catch (Exception ex) {
    //                 ex.printStackTrace();
    //             }
    //         }
    //     }
    // });
    
    JButton sendButton = new JButton("SUBMIT"); // button for send panel
    // For Panel Credits
    JButton TAKEButton = new JButton("TAKE"); // button for take panel
    JButton TAKE2Button = new JButton("TAKE"); // button for take panel
    JButton TAKE3Button = new JButton("TAKE"); // button for take panel
    JButton TAKE4Button = new JButton("TAKE"); // button for take panel
    JButton TAKE5Button = new JButton("TAKE"); // button for take panel

    Graphic slidingGraph = new Graphic();

    String username;
    Font newFont = new Font("default", Font.PLAIN, 17); // set font for text area
    // Constructor
    public GUIMainProgram(String userText, String userlnameText, String userPCode, String userEmail) {
        getContentPane().setBackground(defaultColorForFrame);
        panel1.setBackground(defaultBackgroundColor);
        panel2.setBackground(defaultBackgroundColor);
        panel3.setBackground(defaultBackgroundColor);
        panel4.setBackground(defaultBackgroundColor);
        panel5.setBackground(defaultBackgroundColor);

        usernameLabel = new JLabel(userText);
        userlastnameLabel = new JLabel(userlnameText);
        userPCodeLabel = new JLabel(userPCode);     // for SendMoney, doesnt show up on screen
        userEmailLabel = new JLabel(userEmail);     // for SendMoney, doesnt show up on screen
        //textaboutusB = new JLabel(textaboutus);

        userpCode = userPCode;
        username = userText;
        textaboutusB = new JTextArea(textaboutus); // added textaboutus to text area
        textaboutusB.setBackground(defaultColorForFrame);
        textaboutusB.setLineWrap(true);
        textaboutusB.setWrapStyleWord(true);
        textaboutusB.setEditable(false);

        // For panel Send
        recUsernameField = new JTextField();
        recBankAccountField = new JTextField();
        moneyToSendField = new JTextField();

        userbalanceLabel = new JLabel(String.valueOf(BankAccountManager.GetBalance(userPCode)));
        BankAccountManager bankAccountManager = new BankAccountManager();
        CreditManager genCredit = new CreditManager();

        //genCredit.GenCredit(bankAccountManager.GetBalance(userText), 25, 1);
        //creditsum = new JLabel(String.valueOf(genCredit.GenCredit(bankAccountManager.GetBalance(userText), 25, 1)));
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

    // Set layout manager
    public void setLayoutManager() {
        //container.setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(new BorderLayout());
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
        imageLabel2.setBounds(389, 5, 400, 250);
        //imageLabel3.setBounds(500, 5, 400, 250);

        textaboutusB.setBounds(290, 290, 600, 450); // text area position
        textaboutusB.setFont(newFont);

        //For panel Send text fields
        recUsernameField.setBounds(180, 40, 200, 30);
        recBankAccountField.setBounds(180, 90, 200, 30);
        moneyToSendField.setBounds(180, 140, 200, 30);

        // color switch
        darkModeChBox.setBounds(1000, 50, 150, 30);

        // Buttons   
        sendButton.setBounds(215, 190, 100, 30);

        TAKEButton.setBounds(50, 50, 100, 30);
        TAKE2Button.setBounds(50, 100, 100, 30);
        TAKE3Button.setBounds(50, 150, 100, 30);
        TAKE4Button.setBounds(50, 200, 100, 30);
        TAKE5Button.setBounds(50, 250, 100, 30);

        // For panel Credits lables
        credit.setBounds(160, 50, 200, 30);
        credit2.setBounds(160, 100, 200, 30);
        credit3.setBounds(160, 150, 200, 30);
        credit4.setBounds(160, 200, 200, 30);
        credit5.setBounds(160, 250, 200, 30);

        // for credit
        credityear.setBounds(350, 50, 200, 30);
        credityear2.setBounds(350, 100, 200, 30);
        credityear3.setBounds(350, 150, 200, 30);
        credityear4.setBounds(350, 200, 200, 30);
        credityear5.setBounds(350, 250, 200, 30);


        percentsy.setBounds(430, 50, 200, 30);
        percentsy2.setBounds(430, 100, 200, 30);
        percentsy3.setBounds(430, 150, 200, 30);
        percentsy4.setBounds(430, 200, 200, 30);
        percentsy5.setBounds(430, 250, 200, 30);

        creditoptionfiled1 = new JTextField();
        creditoptionfiled1.setBounds(490, 50, 200, 30);
        creditoptionfiled2 = new JTextField();
        creditoptionfiled2.setBounds(490, 100, 200, 30);

        creditoptionfiled3 = new JTextField();
        creditoptionfiled3.setBounds(490, 150, 200, 30);

        creditoptionfiled4 = new JTextField();
        creditoptionfiled4.setBounds(490, 200, 200, 30);

        creditoptionfiled5 = new JTextField();
        creditoptionfiled5.setBounds(490, 250, 200, 30);

        creditsum1.setBounds(700, 50, 200, 30);
        creditsum2.setBounds(700, 100, 200, 30);
        creditsum3.setBounds(700, 150, 200, 30);
        creditsum4.setBounds(700, 200, 200, 30);
        creditsum5.setBounds(700, 250, 200, 30);


        creditsumtotal.setBounds(830, 50, 200, 30);
        creditsumtotal2.setBounds(830, 100, 200, 30);
        creditsumtotal3.setBounds(830, 150, 200, 30);
        creditsumtotal4.setBounds(830, 200, 200, 30);
        creditsumtotal5.setBounds(830, 250, 200, 30);


        creditsum1.setFont(newFont);
        creditsum2.setFont(newFont);
        creditsum3.setFont(newFont);
        creditsum4.setFont(newFont);
        creditsum5.setFont(newFont);


        // Set font for the labels
        credit.setFont(newFont);
        credit2.setFont(newFont);
        credit3.setFont(newFont);
        credit4.setFont(newFont);
        credit5.setFont(newFont);

        credityear.setFont(newFont);
        credityear2.setFont(newFont);
        credityear3.setFont(newFont);
        credityear4.setFont(newFont);
        credityear5.setFont(newFont);

        percentsy.setFont(newFont);
        percentsy2.setFont(newFont);
        percentsy3.setFont(newFont);
        percentsy4.setFont(newFont);
        percentsy5.setFont(newFont);
        
        creditsumtotal.setFont(newFont);
        creditsumtotal2.setFont(newFont);
        creditsumtotal3.setFont(newFont);
        creditsumtotal4.setFont(newFont);
        creditsumtotal5.setFont(newFont);

        slidingGraph.setBorder(BorderFactory.createEmptyBorder(10, 50, 300, 50)); // set bounds for the graph
        slidingGraph.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        // For panel Send lables
        recUsernameLabel.setBounds(5, 40, 150, 30);
        recBankAccountLabel.setBounds(5, 90, 150, 30);
        moneyToSendLabel.setBounds(5, 140, 150, 30);
        // Set font for the labels
        recUsernameLabel.setFont(newFont);
        recBankAccountLabel.setFont(newFont);
        moneyToSendLabel.setFont(newFont); // set font 
    }

    // Add components to the container
    public void addComponentsToContainer() {
        //container.add(usernameLabel);
        //container.add(userlastnameLabel);
        // Add components to the panels
        container.add(tabPanel);
        panel1.add(usernameLabel);
        panel1.add(userlastnameLabel);
        panel1.add(userbalanceLabel);
        panel1.add(moneyLabel);
        panel1.add(darkModeChBox);
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

        panel5.add(textaboutusB); // add text area to the panel

        panel1.add(imageLabel); // add image to the panel

        // For panel Credits
        panel3.add(TAKEButton);
        panel3.add(TAKE2Button);
        panel3.add(TAKE3Button);
        panel3.add(TAKE4Button);
        panel3.add(TAKE5Button);

        // For panel Credits lables
        panel3.add(credit);
        panel3.add(credit2);
        panel3.add(credit3);
        panel3.add(credit4);
        panel3.add(credit5);

        panel3.add(credityear);
        panel3.add(credityear2);
        panel3.add(credityear3);
        panel3.add(credityear4);
        panel3.add(credityear5);

        panel3.add(percentsy);
        panel3.add(percentsy2);
        panel3.add(percentsy3);
        panel3.add(percentsy4);
        panel3.add(percentsy5);


        panel3.add(creditoptionfiled1);
        panel3.add(creditoptionfiled2);
        panel3.add(creditoptionfiled3);
        panel3.add(creditoptionfiled4);
        panel3.add(creditoptionfiled5);

        panel3.add(creditsum1);
        panel3.add(creditsum2);
        panel3.add(creditsum3);
        panel3.add(creditsum4);
        panel3.add(creditsum5);

        panel3.add(creditsumtotal);
        panel3.add(creditsumtotal2);
        panel3.add(creditsumtotal3);
        panel3.add(creditsumtotal4);
        panel3.add(creditsumtotal5);

        //panel4.setSize(800, 400);
        panel4.add(slidingGraph, BorderLayout.CENTER);
        //.setVisible(true);
        //panel4.add(slidingGraph, BorderLayout.CENTER);


        // Panels   
        tabPanel.addTab("Main", panel1); 
        tabPanel.addTab("Send", panel2); 
        tabPanel.addTab("Credits", panel3); 
        tabPanel.addTab("Stock exchange", panel4);
        tabPanel.addTab("About us", panel5);
        //container.add(addmButton);

    }

    public void addActionEvent() { // add action events
        //addmButton.addActionListener(this);
        sendButton.addActionListener(this);
        darkModeChBox.addActionListener(this);
        TAKEButton.addActionListener(this);
        TAKE2Button.addActionListener(this);
        TAKE3Button.addActionListener(this);
        TAKE4Button.addActionListener(this);
        TAKE5Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // if the button is clicked
        if (e.getSource() == sendButton) {
            //AutoSendonYourEmail.SendEmail();
            String recUsername = recUsernameField.getText(); // get receiver username
            String recBankAccount = recBankAccountField.getText(); // get receiver bank account
            float moneyToSend = Float.valueOf(moneyToSendField.getText()); // get money to send

            Transaction transaction = new Transaction(moneyToSend, recBankAccount, recUsername); // create a new transaction object

            //if (BankAccountManager.CheckSendData(recUsername, recBankAccount, moneyToSend) && REGEXManager.isValidFloat(String.valueOf(moneyToSend))){
            if (BankAccountManager.CheckSendData(recUsername, recBankAccount, moneyToSend, userpCode)){
                if (REGEXManager.isValidFloat(String.valueOf(moneyToSend)) && moneyToSend != 0){
                    BankAccountManager.SendMoney(transaction); // send money to another account
                    BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney(userPCodeLabel.getText(), userEmailLabel.getText(), moneyToSend);   // take money from sender account after sending money
                    JOptionPane.showMessageDialog(this, "Success transaction!"); // show success message
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid money input!"); // show error message
                }
                // BankAccountManager.SendMoney(recUsername, recBankAccount, moneyToSend);
                // BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney(userPCodeLabel.getText(), userEmailLabel.getText(), moneyToSend);   // take money from sender account after sending money
                // JOptionPane.showMessageDialog(this, "Success transaction!");


            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data"); // show error message
            }
            userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
        }

        if (e.getSource() == TAKEButton) {
            Float filedcredit1;
            filedcredit1 = Float.parseFloat(creditoptionfiled1.getText());
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit1);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(filedcredit1, BankAccountManager.FindBankAccount(userpCode), username); // create a new transaction object

                //genCredit.GenCredit(Float.valueOf(creditoptionfiled1.getText()), 25, 1);
                creditsumtotal.setText(String.valueOf(genCredit.GenCredit(Float.valueOf(creditoptionfiled1.getText()), 25, 1)));
                BankAccountManager.SendMoney(transaction); // send money to another account
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
        }
        if (e.getSource() == TAKE2Button) {
            Float filedcredit2;
            filedcredit2 = Float.parseFloat(creditoptionfiled2.getText());
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit2);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(filedcredit2, BankAccountManager.FindBankAccount(userpCode), username); // create a new transaction object

                //genCredit.GenCredit(Float.valueOf(creditoptionfiled2.getText()), 20, 2);
                creditsumtotal2.setText(String.valueOf(genCredit.GenCredit(Float.valueOf(creditoptionfiled2.getText()), 20, 2)));
                BankAccountManager.SendMoney(transaction); // send money to another account
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
        }
        if (e.getSource() == TAKE3Button) {
            Float filedcredit3;
            filedcredit3 = Float.parseFloat(creditoptionfiled3.getText());
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit3);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(filedcredit3, BankAccountManager.FindBankAccount(userpCode), username); // create a new transaction object

                //genCredit.GenCredit(Float.valueOf(creditoptionfiled3.getText()), 15, 3);
                creditsumtotal3.setText(String.valueOf(genCredit.GenCredit(Float.valueOf(creditoptionfiled3.getText()), 15, 3)));
                BankAccountManager.SendMoney(transaction); // send money to another account
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
        }
        if (e.getSource() == TAKE4Button) {
            Float filedcredit4;
            filedcredit4 = Float.parseFloat(creditoptionfiled4.getText());
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit4);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(filedcredit4, BankAccountManager.FindBankAccount(userpCode), username); // create a new transaction object

                //genCredit.GenCredit(Float.valueOf(creditoptionfiled4.getText()), 14, 4);
                creditsumtotal4.setText(String.valueOf(genCredit.GenCredit(Float.valueOf(creditoptionfiled4.getText()), 14, 4)));
                BankAccountManager.SendMoney(transaction); // send money to another account
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
        }
        if (e.getSource() == TAKE5Button) {
            Float filedcredit5;
            filedcredit5 = Float.parseFloat(creditoptionfiled5.getText());
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit5);
            
            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0) {                
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(filedcredit5, BankAccountManager.FindBankAccount(userpCode), username); // create a new transaction object

                //genCredit.GenCredit(Float.valueOf(creditoptionfiled5.getText()), 5, 5);
                creditsumtotal5.setText(String.valueOf(genCredit.GenCredit(Float.valueOf(creditoptionfiled5.getText()), 5, 5)));
                BankAccountManager.SendMoney(transaction); // send money to another account
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
        }

        if (e.getSource() == darkModeChBox){    // turn on/off dark mode
            if (darkModeChBox.isSelected()){
                getContentPane().setBackground(Color.DARK_GRAY);
                panel1.setBackground(Color.GRAY);
                panel2.setBackground(Color.GRAY);
                panel3.setBackground(Color.GRAY);
                panel4.setBackground(Color.GRAY);
                panel5.setBackground(Color.GRAY);
                textaboutusB.setBackground(Color.DARK_GRAY);
            } else {
                getContentPane().setBackground(defaultColorForFrame);
                panel1.setBackground(defaultBackgroundColor);
                panel2.setBackground(defaultBackgroundColor);
                panel3.setBackground(defaultBackgroundColor);
                panel4.setBackground(defaultBackgroundColor);
                panel5.setBackground(defaultBackgroundColor);
                textaboutusB.setBackground(defaultColorForFrame);
            }
        }
    }
    
}

package view;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import date.DateGen;
import managers.BankAccountManager;
import managers.CreditManager;
import managers.FundsManager;
import managers.SendMoneyTransactionsManager;
import model.Credits;
import model.Transaction;
import regex.REGEXManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.ArrayList; 


public class GUIMainProgram extends JFrame implements ActionListener{ 
    public static GUILogReg framelogreg;
    Container container = getContentPane();
    JTabbedPane tabPanel = new JTabbedPane(); 

    // =================================================== Images for panels ===================================================
    ImageIcon imageIcon = new ImageIcon("resources/hamster.jpg"); 
    ImageIcon imageIcon2 = new ImageIcon("resources/monolithad.jpg"); 

    JLabel imageLabel = new JLabel(imageIcon);
    JLabel imageLabel2 = new JLabel(imageIcon2);
    // =================================================== Images for panels ===================================================


    // =================================================== Panels ===================================================
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    // =================================================== Panels ===================================================


    // =================================================== Text area for about us info ===================================================
    // Pane for Panel5
    JTextPane textAboutUsPane = new JTextPane();
    // =================================================== Text area for about us info ===================================================
    
    
    // =================================================== Labels ===================================================
    // for SendMoney
    JLabel userPCodeLabel;
    JLabel userEmailLabel;
    // =================================================== Labels ===================================================


    // =================================================== Text fields for credit options ===================================================
    // For Panel Send
    RoundJTextField creditoptionfiled1;
    RoundJTextField creditoptionfiled2;
    RoundJTextField creditoptionfiled3;
    RoundJTextField creditoptionfiled4;
    RoundJTextField creditoptionfiled5;
    // =================================================== Text fields for credit options ===================================================


    // =================================================== Text fields for send panel =================================================== 
    // For Panel Send text fields
    RoundJTextField recUsernameField;
    RoundJTextField recBankAccountField;
    RoundJTextField moneyToSendField;
    // =================================================== Text fields for send panel ===================================================


    // =================================================== Labels for send money ===================================================
    // For Panel Send lables
    JLabel recUsernameLabel = new JLabel("Receiver username:");
    JLabel recBankAccountLabel = new JLabel("Receiver bank account:");
    JLabel moneyToSendLabel = new JLabel("Amount:");
    JLabel newPaymentLabel = new JLabel("New Payment");
    // =================================================== Labels for send money ===================================================


    // =================================================== Info about user lables =================================================== 
    // For Main Panel
    JLabel overviewLabel = new JLabel("Overview");
    JLabel accountLabel = new JLabel("Your account:");
    JLabel bankAccLabel;
    JLabel availableBalanceLabel = new JLabel("Available balance:");
    JLabel amountOfCreditLabel = new JLabel("Amount of credit:");
    JLabel usernameLabel;
    JLabel userlastnameLabel;
    JLabel userbalanceLabel;
    JLabel userCreditsLabel = new JLabel("placeholder for usercredits");
    // =================================================== Info about user lables ===================================================


    // ===================================================  R Buttons and goup for funds ===================================================
    // For Panel Stock exchange
    JRadioButton fond1 = new JRadioButton("MONOLITH"); // create a radio button
    JRadioButton fond2 = new JRadioButton("CLEAR SKY"); // create a radio button
    JRadioButton fond3 = new JRadioButton("DUTY"); // create a radio button

    ButtonGroup group = new ButtonGroup(); // create a button group
    // =================================================== R Buttons and group for funds ===================================================


    // =================================================== Credit options Lables ===================================================
    // For Panel Credits
    JLabel newLoanLable = new JLabel("Take a New Loan or Repay It");
    JLabel credit = new JLabel("Credit option 1");
    JLabel credit2 = new JLabel("Credit option 2");
    JLabel credit3 = new JLabel("Credit option 3");
    JLabel credit4 = new JLabel("Credit option 4");
    JLabel credit5 = new JLabel("Credit option 5");

    JLabel credityear = new JLabel("For 1 year");
    JLabel credityear2 = new JLabel("For 2 years");
    JLabel credityear3 = new JLabel("For 3 years");
    JLabel credityear4 = new JLabel("For 4 years");
    JLabel credityear5 = new JLabel("For 5 years");

    JLabel percentsy = new JLabel("25%");
    JLabel percentsy2 = new JLabel("20%");
    JLabel percentsy3 = new JLabel("15%");
    JLabel percentsy4 = new JLabel("14%");
    JLabel percentsy5 = new JLabel("5%");

    JLabel creditsum1 = new JLabel("Credit sum: ");
    JLabel creditsum2 = new JLabel("Credit sum: ");
    JLabel creditsum3 = new JLabel("Credit sum: ");
    JLabel creditsum4 = new JLabel("Credit sum: ");
    JLabel creditsum5 = new JLabel("Credit sum: ");

    // For Panel Credits
    JButton TAKEButton = new JButton("Take"); // button for take panel
    JButton TAKE2Button = new JButton("Take");
    JButton TAKE3Button = new JButton("Take");
    JButton TAKE4Button = new JButton("Take");
    JButton TAKE5Button = new JButton("Take");

    JButton repaycredit = new JButton("Repay"); // button for repay panel
    RoundJTextField repaycreditfield = new RoundJTextField(20); // text field for repay panel
    // credits end

    JLabel creditsumtotal = new JLabel();
    JLabel creditsumtotal2 = new JLabel();
    JLabel creditsumtotal3 = new JLabel();
    JLabel creditsumtotal4 = new JLabel();
    JLabel creditsumtotal5 = new JLabel();

    JLabel creditsum; // for credits
    // =================================================== Credit options Lables ===================================================


    String userpCode; // for SendMoney


    // =================================================== Color changer ===================================================
    // Colors
    JCheckBox darkModeChBox = new JCheckBox("Dark Mode");   // check box for dark mode
    Color defaultBackgroundColor = new Color(211, 233, 252);
    Color secondaryMainColor = new Color(172, 217, 255);
    Color defaultColorForFrame = new Color(119, 203, 233);
    Color darkModeBackgroundColor = new Color(85, 77, 86);
    Color defaultTitleColor = new Color(203, 0, 0);
    Color titleColorDarkMode = new Color(211, 233, 252);
    Color radioButtonsColor = new Color(153, 204, 255);
    Color calendarBGColorDarkM = new Color(104, 104, 104);
    // =================================================== Color changer ===================================================



    // =================================================== Editor panes ===================================================
    JEditorPane editorPane = new JEditorPane(); // for about us
    // Create a JEditorPane
    JEditorPane editorPaneT = new JEditorPane(); // create a new editor pane for transactions
    // =================================================== Editor panes ===================================================


    // =================================================== Text for about us ===================================================
    //For Panel about us
    String textaboutus = "Finanšu pasaules miglainajās vietās pastāv banka, kas pazīstama kā Monolīts." +
    "Tās dīvainības un mistikas reputācija piesaista uzmanību. Daži saka, ka šai bankai " +
    "ir tiesības parastos ieguldījumus pārveidot par kaut ko vērtīgāku, piemēram, " +
    "artefaktus no citas dimensijas. Ne visi uzdrošinās ienākt tās durvīm, baidoties " +
    "no negaidītiem pārbaudījumiem un sarežģītiem apstākļiem. Tomēr tie, kas ir drosmīgi " +
    "iegājuši iekšā, saka, ka atlīdzība par risku var būt ievērojama. Nav skaidrs, " +
    "vai Monolīts ir mīts vai realitāte, taču daudzi finanšu piedzīvojumu meklētāji " +
    "turpina pētīt tā noslēpumainās iespējas.";
    // =================================================== Text for about us ===================================================


    // =================================================== Button for sending money panel send ===================================================
    JButton sendButton = new JButton("Submit"); // button for send panel
    // =================================================== Button for sending money panel send ===================================================


    // =================================================== buttons for stock exchange buy,sell =================================================== 
    // ------------
    JButton buyfond = new JButton("Buy stocks"); // button for buy panel stock exchange
    JButton sellfond = new JButton("Sell stocks"); // button for sell panel stock exchange
    // ------------
    // =================================================== buttons for stock exchange buy,sell ===================================================


    // =================================================== Labels, graphics for funds ===================================================
    JLabel fondLabelM = new JLabel(" MONOLITH fund price:"); // label for fonds
    JLabel fondLabelC = new JLabel(" CLEAR SKY fund price:"); // label for fonds
    JLabel fondLabelD = new JLabel(" DUTY fund price:"); // label for fonds

    Graphic slidingGraph = new Graphic(Color.BLUE); // create a new graph object
    Graphic slidingGraph2 = new Graphic(Color.BLACK);
    Graphic slidingGraph3 = new Graphic(Color.RED);

    // =================================================== Labels, graphics for funds ===================================================

    
    // =================================================== Exit button ===================================================
    JButton exitButton = new JButton("Exit"); // create a new exit button
    // =================================================== Exit button ===================================================



    CalendarApp calendarApp = new CalendarApp(); // create a new calendar object


    String username; // person name
    String nickname; // person nickname
    String useremail; // person email
    String pinkcode; // person pin code


    // =================================================== Drop down menu about user ===================================================
    JComboBox comboBox; // drop down menu for panel 1 about user
    // =================================================== Drop down menu about user ===================================================


    static int fundscost = 0; // fonds cost
    String fundname; // fonds name

    public static int receivedata; // received data from graphic
    static JLabel fundcostM = new JLabel(); // label for fund cost
    static JLabel fundcostC = new JLabel(); // label for fund cost
    static JLabel fundcostD = new JLabel(); // label for fund cost
    
    Font defaultTextFont = new Font("Arial", Font.BOLD, 17); // set font for text area
    Font titleFont = new Font("Arial", Font.BOLD, 30);


    // Create a new JTextArea for transactions visualisation
    JTextArea textArea = new JTextArea();
    ArrayList<String[]> transactions;
    

    
    // =================================================== MAIN PROGRAMM START ===================================================
    // Constructor
    public GUIMainProgram(String userText, String userlnameText, String userPCode, String userEmail, String Nnickname) {
        // find data fro transaction visualisation
        transactions = SendMoneyTransactionsManager.FindMoneyTransaction("resources/sendmoneyTransactions.csv", userPCode);
        if (transactions != null) {
            for (String[] elem : transactions) {
                System.out.println(elem);
            }
        }

        getContentPane().setBackground(defaultColorForFrame);
        panel1.setBackground(defaultBackgroundColor);
        panel2.setBackground(defaultBackgroundColor);
        panel3.setBackground(defaultBackgroundColor);
        panel4.setBackground(defaultBackgroundColor);
        panel5.setBackground(defaultBackgroundColor);


        usernameLabel = new JLabel(userText);
        userlastnameLabel = new JLabel(userlnameText);
        bankAccLabel = new JLabel(BankAccountManager.FindBankAccount(userPCode));
        userPCodeLabel = new JLabel(userPCode);     // for SendMoney, doesnt show up on screen
        userEmailLabel = new JLabel(userEmail);     // for SendMoney, doesnt show up on screen
        
        userpCode = userPCode;
        username = userText;
        nickname = Nnickname;
        useremail = userEmail;

        String bankacc = BankAccountManager.FindBankAccount(userpCode); // find bank account by personal code
        pinkcode = BankAccountManager.FindPinCodes(userpCode); // ------------->
        String pinkcode2 = BankAccountManager.FindPinCodesSecond(userpCode); // ------------->
        String[] data = {nickname, useremail, bankacc, pinkcode, pinkcode2}; // create a new string array
        comboBox = new JComboBox(data); // create a new combo box

        // JTextPane with textaboutus for Panel5
        textAboutUsPane.setEditable(false);
        StyledDocument docForTAUPane = textAboutUsPane.getStyledDocument();
        Style tStyle = textAboutUsPane.addStyle("Style", null);     // Create a style for the text
        StyleConstants.setFontFamily(tStyle, "Arial");              // set text font
        StyleConstants.setFontSize(tStyle, 17);                     // set text size
        StyleConstants.setBold(tStyle, true);                       // set bold text
        StyleConstants.setLineSpacing(tStyle, 0.4f);                // set line spacing 1.4
        StyleConstants.setAlignment(tStyle, StyleConstants.ALIGN_JUSTIFIED);    // line alignment Justify
        docForTAUPane.setParagraphAttributes(0, docForTAUPane.getLength(), tStyle, false);
        textAboutUsPane.setBackground(defaultColorForFrame);

        // Add text using the created style
        try {
            docForTAUPane.insertString(docForTAUPane.getLength(), textaboutus, tStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        //

        // For panel Send
        recUsernameField = new RoundJTextField(20);
        recBankAccountField = new RoundJTextField(20);
        moneyToSendField = new RoundJTextField(20);

        userbalanceLabel = new JLabel(String.valueOf(BankAccountManager.GetBalance(userPCode)));
        if (CreditManager.FindCredit("resources/credits.csv", userPCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
            userCreditsLabel.setText("none");
        } else {
            userCreditsLabel = new JLabel(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userPCode)));
        }
        // BankAccountManager bankAccountManager = new BankAccountManager();
        // CreditManager genCredit = new CreditManager();


        //genCredit.GenCredit(bankAccountManager.GetBalance(userText), 25, 1);
        //creditsum = new JLabel(String.valueOf(genCredit.GenCredit(bankAccountManager.GetBalance(userText), 25, 1)));
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer(); // add components to the container
        addActionEvent(); // add action event
    }

    // Set layout manager
    public void setLayoutManager() {
        //container.setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        //panel4.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
    }

    public void setLocationAndSize() {
        // Setting location and Size of each components using setBounds() method.
        // Main panel
        overviewLabel.setBounds(40, 30, 150, 30);
        accountLabel.setBounds(40, 80, 150, 30);
        bankAccLabel.setBounds(200, 80, 320, 30);
        availableBalanceLabel.setBounds(40, 120, 170, 30);
        userbalanceLabel.setBounds(200, 120, 450, 30);
        amountOfCreditLabel.setBounds(40, 160, 170, 30);
        userCreditsLabel.setBounds(200, 160, 450, 30);
        usernameLabel.setBounds(920, 20, 100, 30);
        userlastnameLabel.setBounds(920, 60, 100, 30);
        imageLabel.setBounds(850, 17, 50, 50); // image position
        darkModeChBox.setBounds(1000, 100, 150, 30); // color switch
        darkModeChBox.setBackground(secondaryMainColor);
        exitButton.setBounds(1000, 140, 150, 30); // set bounds for the exit button
        comboBox.setBounds(900, 180, 250, 30); // set bounds for the combo box
        comboBox.setBackground(secondaryMainColor);
        calendarApp.setBounds(760, 370, 400, 300); // set bounds for the calendar
        calendarApp.changeColors(Color.WHITE, new Color(153, 204, 255), new Color(51, 153, 255), Color.BLACK);

        // Set font for the labels
        overviewLabel.setFont(titleFont);
        overviewLabel.setForeground(defaultTitleColor);
        accountLabel.setFont(defaultTextFont);
        bankAccLabel.setFont(defaultTextFont);
        availableBalanceLabel.setFont(defaultTextFont);
        amountOfCreditLabel.setFont(defaultTextFont);
        userbalanceLabel.setFont(defaultTextFont);
        usernameLabel.setFont(defaultTextFont);
        userlastnameLabel.setFont(defaultTextFont);
        userCreditsLabel.setFont(defaultTextFont);
        exitButton.setBackground(defaultTitleColor);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(defaultTextFont);
        //
        
        tabPanel.setBounds(0, 0, 1200, 750); // tab position

        imageLabel2.setBounds(375, 5, 450, 300);

        textAboutUsPane.setBounds(285, 320, 630, 450);

        // For panel Credits lables
        newLoanLable.setBounds(375, 50, 450, 30);
        newLoanLable.setFont(titleFont);
        newLoanLable.setForeground(defaultTitleColor);
        credit.setBounds(350, 150, 200, 30);
        credit2.setBounds(350, 200, 200, 30);
        credit3.setBounds(350, 250, 200, 30);
        credit4.setBounds(350, 300, 200, 30);
        credit5.setBounds(350, 350, 200, 30);

        // Buttons   
        TAKEButton.setBounds(190, 150, 150, 30);
        TAKE2Button.setBounds(190, 200, 150, 30);
        TAKE3Button.setBounds(190, 250, 150, 30);
        TAKE4Button.setBounds(190, 300, 150, 30);
        TAKE5Button.setBounds(190, 350, 150, 30);
        JButton[] arrPanel3Buttons = {TAKEButton, TAKE2Button, TAKE3Button, TAKE4Button, TAKE5Button, repaycredit}; // array with all buttons on Panel2
        for (JButton button : arrPanel3Buttons){      // loop for all TAKE buttons and Repay button
            button.setBackground(defaultTitleColor);
            button.setForeground(Color.WHITE);     
            button.setFont(defaultTextFont);
        }
        arrPanel3Buttons = null;  // set to null (delete) variable

        // for credit
        credityear.setBounds(490, 150, 200, 30);
        credityear2.setBounds(490, 200, 200, 30);
        credityear3.setBounds(490, 250, 200, 30);
        credityear4.setBounds(490, 300, 200, 30);
        credityear5.setBounds(490, 350, 200, 30);
        // percents
        percentsy.setBounds(590, 150, 200, 30); // set bounds for the labels
        percentsy2.setBounds(590, 200, 200, 30);
        percentsy3.setBounds(590, 250, 200, 30);
        percentsy4.setBounds(590, 300, 200, 30);
        percentsy5.setBounds(590, 350, 200, 30);
        // credit options
        creditoptionfiled1 = new RoundJTextField(20); // create a text field
        creditoptionfiled1.setBounds(650, 150, 200, 30);
        creditoptionfiled2 = new RoundJTextField(20);
        creditoptionfiled2.setBounds(650, 200, 200, 30);
        creditoptionfiled3 = new RoundJTextField(20);
        creditoptionfiled3.setBounds(650, 250, 200, 30);
        creditoptionfiled4 = new RoundJTextField(20);
        creditoptionfiled4.setBounds(650, 300, 200, 30);
        creditoptionfiled5 = new RoundJTextField(20);
        creditoptionfiled5.setBounds(650, 350, 200, 30);
        // credit sum
        creditsum1.setBounds(860, 150, 200, 30); // set bounds for the labels
        creditsum2.setBounds(860, 200, 200, 30);
        creditsum3.setBounds(860, 250, 200, 30);
        creditsum4.setBounds(860, 300, 200, 30);
        creditsum5.setBounds(860, 350, 200, 30);
        // credit sum total
        creditsumtotal.setBounds(960, 150, 200, 30);
        creditsumtotal2.setBounds(960, 200, 200, 30);
        creditsumtotal3.setBounds(960, 250, 200, 30);
        creditsumtotal4.setBounds(960, 300, 200, 30); // set bounds for the labels
        creditsumtotal5.setBounds(960, 350, 200, 30);

        repaycredit.setBounds(425, 450, 150, 30);    // set bounds for the button  
        repaycredit.setFont(defaultTextFont);
        repaycreditfield.setBounds(625, 450, 150, 30); // set bounds for the text field

        // fonts
        JLabel[] arrPanel3Labels = {credit, credit2, credit3, credit4, credit5, credityear, credityear2, credityear3, credityear4, credityear5,
        percentsy, percentsy2, percentsy3, percentsy4, percentsy5, creditsum1, creditsum2, creditsum3, creditsum4, creditsum5,
        creditsumtotal, creditsumtotal2, creditsumtotal3, creditsumtotal4, creditsumtotal5};        // array with all labels on Panel3
        for (JLabel label : arrPanel3Labels){      // loop for all labels on Panel3    
            label.setFont(defaultTextFont);
        }
        arrPanel3Labels = null;  // set to null (delete) variable

        editorPane.setBounds(557, 560, 86, 30); // set bounds for the link on Panel5
        editorPane.setFont(defaultTextFont);
        editorPane.setBackground(secondaryMainColor);

        // =================================================== Send money ===================================================
        // For Panel2 lables
        newPaymentLabel.setBounds(500, 50, 200, 30);
        recUsernameLabel.setBounds(360, 150, 200, 30);
        recBankAccountLabel.setBounds(360, 200, 200, 30);
        moneyToSendLabel.setBounds(360, 250, 200, 30);

        //For Panel2 text fields
        recUsernameField.setBounds(610, 150, 250, 30);
        recBankAccountField.setBounds(610, 200, 250, 30);
        moneyToSendField.setBounds(610, 250, 250, 30);
        // For Panel2 buttons
        sendButton.setBounds(525, 350, 150, 30);
        sendButton.setBackground(defaultTitleColor);
        sendButton.setForeground(Color.WHITE);     
        sendButton.setFont(defaultTextFont);

        // Set font for the labels
        recUsernameLabel.setFont(defaultTextFont);
        recBankAccountLabel.setFont(defaultTextFont);
        moneyToSendLabel.setFont(defaultTextFont);
        newPaymentLabel.setForeground(defaultTitleColor);
        newPaymentLabel.setFont(titleFont);
        // =================================================== Send money ===================================================


        // =================================================== Stock exchange ===================================================
        slidingGraph.setBounds(45, 70, 1100, 300); // set bounds for the graph
        slidingGraph2.setBounds(45, 70, 1100, 300);
        slidingGraph3.setBounds(45, 70, 1100, 300);

        group.add(fond1); // add radio buttons to the group
        group.add(fond2);
        group.add(fond3);

        fond1.setBounds(450, 10, 100, 30); // set bounds for the radio buttons
        fond2.setBounds(550, 10, 100, 30);
        fond3.setBounds(650, 10, 100, 30);
        fond1.setBackground(radioButtonsColor);
        fond2.setBackground(radioButtonsColor);
        fond3.setBackground(radioButtonsColor);

        buyfond.setBounds(525, 495, 150, 30); // set bounds for the button for buying fonds
        sellfond.setBounds(525, 575, 150, 30); // set bounds for the button for selling fonds
        buyfond.setBackground(defaultTitleColor);
        buyfond.setForeground(Color.WHITE);     
        buyfond.setFont(defaultTextFont);
        sellfond.setBackground(defaultTitleColor);
        sellfond.setForeground(Color.WHITE);     
        sellfond.setFont(defaultTextFont);

        fondLabelM.setBounds(470, 440, 200, 30); // set bounds for the label for fonds names (next to But button)
        fondLabelC.setBounds(470, 440, 200, 30);
        fondLabelD.setBounds(495, 440, 150, 30);

        fundcostM.setBounds(670, 440, 60, 30); // set bounds for the label fonds cost
        fundcostC.setBounds(670, 440, 60, 30);
        fundcostD.setBounds(645, 440, 60, 30);

        JLabel[] arrayPanel4Labels = {fondLabelM, fondLabelC, fondLabelD, fundcostM, fundcostC, fundcostD};  // array with all JLabels on Panel4
        for (JLabel labelP4 : arrayPanel4Labels){
            labelP4.setOpaque(true);    // set Label background opaque
            labelP4.setFont(defaultTextFont);
            labelP4.setBackground(radioButtonsColor);
        }
        arrayPanel4Labels = null;  // set to null (delete) variable
        // =================================================== Stock exchange ===================================================


        editorPaneT.setBounds(40, 200, 650, 490); // set bounds for the editor pane for Transactions
        editorPaneT.setBackground(secondaryMainColor);
 
    }

    // Add components to the container
    public void addComponentsToContainer() {
        //container.add(usernameLabel);
        //container.add(userlastnameLabel);
        // Add components to the panels
        container.add(tabPanel);

        // ------------
        // =================================================== About us link ===================================================
        // Set the content type to HTML
        editorPane.setContentType("text/html");

        // Make it non-editable
        editorPane.setEditable(false);

        // Add the text with the link
        editorPane.setText("<html><a href='https://daniilsonufrijuks.github.io/MONOLITH.github.io/'>LINK TO US</a></html>");

        // Add a hyperlink listener to handle click events
        editorPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                // Open the link in the default browser
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
                }
            }
        });

        // ------------
        
        panel5.add(editorPane);

        // =================================================== About us link ===================================================

        // for panel 1 main panel
        JLabel[] arrPanel1LabelsAdd = {overviewLabel, accountLabel, bankAccLabel, availableBalanceLabel, userbalanceLabel,
            amountOfCreditLabel, userCreditsLabel, usernameLabel, userlastnameLabel, };   // array for all labels on Panel1 except for imageLabel
        for (JLabel label : arrPanel1LabelsAdd){   // add all Labels on Panel1
            panel1.add(label);
        }
        arrPanel1LabelsAdd = null;  // set to null (delete) variable
        panel1.add(darkModeChBox);
        panel1.add(imageLabel); // add image to the panel1
        panel1.add(calendarApp); // add calendar to the panel
        panel1.add(comboBox); // add combo box to the panel
        panel1.add(exitButton); // add exit button to the panel


        // =================================================== Editor pane transactions viz ===================================================
        editorPaneT.setFont(new Font("Arial", Font.BOLD, 16));
        // Set the content type to text
        editorPaneT.setContentType("text/plain");
        // Make the JEditorPane uneditable
        editorPaneT.setEditable(false);

        // Iterate over transactions and append them to the JEditorPane
        if (transactions != null) {
            for (String[] elem : transactions) {
                for (String line : elem) {
                    editorPaneT.setText(editorPaneT.getText() + line + "....");
                }
                editorPaneT.setText(editorPaneT.getText() + "\n");
            }
        }
        // Add the JEditorPaneT to panel1
        panel1.add(editorPaneT);

        // =================================================== Editor pane transactions viz ===================================================
        
        // For panel Send
        panel2.add(recUsernameField);
        panel2.add(recBankAccountField);
        panel2.add(moneyToSendField);
        panel2.add(recUsernameLabel);
        panel2.add(recBankAccountLabel);
        panel2.add(moneyToSendLabel);
        panel2.add(newPaymentLabel);

        panel5.add(imageLabel2);
        //panel5.add(imageLabel3);

        panel2.add(sendButton);

        panel5.add(textAboutUsPane, BorderLayout.CENTER);

        // For panel Credits
        panel3.add(TAKEButton);
        panel3.add(TAKE2Button);
        panel3.add(TAKE3Button);
        panel3.add(TAKE4Button);
        panel3.add(TAKE5Button);

        // For panel Credits lables
        JLabel[] arrPanel3LabelsAdd = {newLoanLable, credit, credit2, credit3, credit4, credit5, credityear, credityear2, credityear3, credityear4, credityear5,
        percentsy, percentsy2, percentsy3, percentsy4, percentsy5, creditsum1, creditsum2, creditsum3, creditsum4, creditsum5,
        creditsumtotal, creditsumtotal2, creditsumtotal3, creditsumtotal4, creditsumtotal5};        // array with all labels on Panel3
        for (JLabel label : arrPanel3LabelsAdd){      // add all Labels on Panel3  
            panel3.add(label);
        }
        arrPanel3LabelsAdd = null;  // set to null (delete) variable

        panel3.add(creditoptionfiled1);
        panel3.add(creditoptionfiled2);
        panel3.add(creditoptionfiled3);
        panel3.add(creditoptionfiled4);
        panel3.add(creditoptionfiled5);

        panel3.add(repaycredit);
        panel3.add(repaycreditfield);

        panel4.add(fond1); // add radio button to the panel
        panel4.add(fond2); // add radio button to the panel
        panel4.add(fond3); // add radio button to the panel  

        panel4.add(slidingGraph); // add graph to the panel
        panel4.add(slidingGraph2);
        panel4.add(slidingGraph3);

        slidingGraph.setVisible(false); // set graph invisible
        slidingGraph2.setVisible(false);
        slidingGraph3.setVisible(false);

        // ------------
        // For panel Stock exchange btn and lables 
        panel4.add(buyfond); // add button to the panel 4 
        panel4.add(sellfond); // add button to the panel 4

        buyfond.setVisible(false); // set button invisible
        sellfond.setVisible(false);

        panel4.add(fondLabelM); // add label to the panel 4
        panel4.add(fondLabelC); // add label to the panel 4
        panel4.add(fondLabelD); // add label to the panel 4

        fondLabelM.setVisible(false); // set label invisible
        fondLabelC.setVisible(false);
        fondLabelD.setVisible(false);
        // ------------

        panel4.add(fundcostM); // add label to the panel 4
        fundcostM.setVisible(false); // set label invisible

        panel4.add(fundcostC); // add label to the panel 4
        fundcostC.setVisible(false); // set label invisible

        panel4.add(fundcostD); // add label to the panel 4
        fundcostD.setVisible(false); // set label invisible

        // ------------
        // Panels   
        tabPanel.addTab("Main", panel1); 
        tabPanel.addTab("Send", panel2); 
        tabPanel.addTab("Credits", panel3); 
        tabPanel.addTab("Stock exchange", panel4);
        tabPanel.addTab("About us", panel5);
        // ------------

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
        buyfond.addActionListener(this);
        sellfond.addActionListener(this);
        fond1.addActionListener(this);
        fond2.addActionListener(this);
        fond3.addActionListener(this); // action listener for radio buttons
        repaycredit.addActionListener(this);
        exitButton.addActionListener(this);
    }

    // to recieve data from graphic and work with it
    public static void receiveData(int data) {
        //System.out.println(data);
        receivedata = data;
        fundscost = receivedata;
        fundcostM.setText(" " + String.valueOf(receivedata/10*90)); // update balance
        fundcostC.setText(" " + String.valueOf(receivedata/10*100)); // update balance
        fundcostD.setText(" " + String.valueOf(receivedata/10*120)); // update balance
        //System.out.println(data);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // if the button is clicked
        // for send money / to send money to another account
        if (e.getSource() == sendButton) {
            //AutoSendonYourEmail.SendEmail();
            String recUsername = recUsernameField.getText(); // get receiver username
            String recBankAccount = recBankAccountField.getText(); // get receiver bank account
            if (!REGEXManager.isNumber(moneyToSendField.getText())){    // check if input is a number
                JOptionPane.showMessageDialog(this, "Invalid money input!");
            } else{
                float moneyToSend = Float.valueOf(moneyToSendField.getText()); // get money to send            
                Transaction transaction = new Transaction(moneyToSend, recBankAccount, recUsername); // create a new transaction object
                
                if (BankAccountManager.CheckSendData(recUsername, recBankAccount, moneyToSend, userpCode)){
                    float balanceuser = BankAccountManager.GetBalance(userpCode).floatValue();
                    if (REGEXManager.isValidFloat(String.valueOf(moneyToSend)) && moneyToSend > 0){ // check if money input is correct
                        if (moneyToSend <= balanceuser){    // check if sender has enough money
                        BankAccountManager.SendMoney(transaction); // send money to another account
                        System.out.println(username + " - " + " - " + useremail + " - " + moneyToSend);
                        BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney(userpCode, useremail, moneyToSend);   // take money from sender account after sending money
                        BankAccountManager.ShowMessagewhenMoneysent(userpCode, moneyToSend, BankAccountManager.FindPersonPcode(recBankAccount));
                        SendMoneyTransactionsManager.WriteMoneyTransactionsToafile(BankAccountManager.FindPersonPcode(recBankAccount), username, BankAccountManager.FindBankAccount(userpCode), moneyToSend, DateGen.GetDate()); // write credit to files
                        JOptionPane.showMessageDialog(this, "Successful transaction!"); // show success message
                        } else {
                            JOptionPane.showMessageDialog(this, "Insufficient funds!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid money input!"); // show error message
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Data"); // show error message
                }
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
        }
        }

        // =================================================== Take credits ===================================================
        // for credits / to take credits and then repay
        if (e.getSource() == TAKEButton) {
            Float filedcredit1;
            filedcredit1 = Float.parseFloat(creditoptionfiled1.getText()); // get credit option 1
            Credits credits = new Credits(filedcredit1); // create a new credits object to wrok through it
            BigDecimal balance = BankAccountManager.GetBalance(userpCode); // get balance in big decimal  
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit1); // get credit option 1 field in big decimal

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0 && credits.getTotal() <= 100) { // if balance > 0 and balance <= 100
                // creating and initializing
                CreditManager genCredit = new CreditManager(); // create a new credit manager object to use methods from this class
                Transaction transaction = new Transaction(Float.valueOf(credits.getTotal()), BankAccountManager.FindBankAccount(userpCode), nickname); // create a new transaction object
                System.out.println(BankAccountManager.FindBankAccount(userpCode) + " ," +username); // to see what happens
                BigDecimal finalCreditToPay = new BigDecimal(genCredit.GenCredit(credits.getTotal(), 25, 1));   // generate final credit that user should repay
                //
                // maths and sending
                finalCreditToPay.setScale(2, RoundingMode.HALF_UP); // round value to 2 decimal positions
                creditsumtotal.setText(String.valueOf(finalCreditToPay)); // set credit sum
                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney("000000-00000", "monolith@gmail.com", credits.getTotal());  // take money from acc of the bank
                BankAccountManager.SendMoney(transaction); // send money to user's acc
                CreditManager.WriteCredittoFile(userpCode, finalCreditToPay.floatValue()); // write credit to file
                System.out.println("   balance ---> " + String.valueOf(BankAccountManager.GetBalance(userpCode))); // to see what happens
                // work with credits
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance in the main panel 1
                CreditManager.CheckForSimilarUserPcodeinFileandSumValues(userpCode); // to check for similar user pcode in file and sum values and delete similar entries
                JOptionPane.showMessageDialog(this, "Success credit!"); // show if succes transaction
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data"); // if not valid data
            }
            // check credits to display it on panel1
            if (CreditManager.FindCredit("resources/credits.csv", userpCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
                userCreditsLabel.setText("none"); // to prevent from writing 'null', will write 'none' <---------
            } else {
                userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode))); // update credit label panel 1
            }
        }
        if (e.getSource() == TAKE2Button) {
            Float filedcredit2;
            filedcredit2 = Float.parseFloat(creditoptionfiled2.getText());
            BigDecimal bd = new BigDecimal(Float.toString(filedcredit2));
            bd = bd.setScale(2, RoundingMode.HALF_UP); // 2 is the number of decimal places
            filedcredit2 = bd.floatValue();

            System.out.println(filedcredit2);

            Credits credits = new Credits(filedcredit2);
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit2);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0 && credits.getTotal() <= 1000) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(Float.valueOf(credits.getTotal()), BankAccountManager.FindBankAccount(userpCode), nickname); // create a new transaction object

                Float gencreditsum;
                gencreditsum = genCredit.GenCredit(credits.getTotal(), 20, 2);
                System.out.println(gencreditsum);
                BigDecimal bd2 = new BigDecimal(Float.toString(gencreditsum));
                bd2 = bd2.setScale(2, RoundingMode.HALF_UP); // 2 is the number of decimal places
                gencreditsum = bd2.floatValue();
                creditsumtotal2.setText(gencreditsum.toString());

                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney("000000-00000", "monolith@gmail.com", credits.getTotal());
                BankAccountManager.SendMoney(transaction); // send money to another account

                // to write credit to file credits.csv  
                CreditManager.WriteCredittoFile(userpCode, gencreditsum); // write credit to file
                
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                CreditManager.CheckForSimilarUserPcodeinFileandSumValues(userpCode);
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            // check credits to display it on panel1
            if (CreditManager.FindCredit("resources/credits.csv", userpCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
                userCreditsLabel.setText("none");
            } else {
                userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode)));
            }
        }
        if (e.getSource() == TAKE3Button) {
            Float filedcredit3;
            filedcredit3 = Float.parseFloat(creditoptionfiled3.getText());
            Credits credits = new Credits(filedcredit3);
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit3);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0 && credits.getTotal() <= 10000) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(credits.getTotal(), BankAccountManager.FindBankAccount(userpCode), nickname); // create a new transaction object

                Float gencreditsum;
                gencreditsum = genCredit.GenCredit(credits.getTotal(), 15, 3);
                System.out.println(gencreditsum);
                BigDecimal bd2 = new BigDecimal(Float.toString(gencreditsum));
                bd2 = bd2.setScale(2, RoundingMode.HALF_UP); // 2 is the number of decimal places
                gencreditsum = bd2.floatValue();
                creditsumtotal3.setText(gencreditsum.toString());

                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney("000000-00000", "monolith@gmail.com", credits.getTotal());
                BankAccountManager.SendMoney(transaction); // send money to another account
                
                // to write credit to file credits.csv  
                CreditManager.WriteCredittoFile(userpCode, gencreditsum); // write credit to file
                
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                CreditManager.CheckForSimilarUserPcodeinFileandSumValues(userpCode);
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            // check credits to display it on panel1
            if (CreditManager.FindCredit("resources/credits.csv", userpCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
                userCreditsLabel.setText("none");
            } else {
                userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode)));
            }
        }
        if (e.getSource() == TAKE4Button) {
            Float filedcredit4;
            filedcredit4 = Float.parseFloat(creditoptionfiled4.getText());
            Credits credits = new Credits(filedcredit4);
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit4);

            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0 && credits.getTotal() <= 100000) {
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(credits.getTotal(), BankAccountManager.FindBankAccount(userpCode), nickname); // create a new transaction object

                Float gencreditsum;
                gencreditsum = genCredit.GenCredit(credits.getTotal(), 14, 3);
                System.out.println(gencreditsum);
                BigDecimal bd2 = new BigDecimal(Float.toString(gencreditsum));
                bd2 = bd2.setScale(2, RoundingMode.HALF_UP); // 2 is the number of decimal places
                gencreditsum = bd2.floatValue();
                creditsumtotal4.setText(gencreditsum.toString());

                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney("000000-00000", "monolith@gmail.com", credits.getTotal());
                BankAccountManager.SendMoney(transaction); // send money to another account
                
                // to write credit to file credits.csv  
                CreditManager.WriteCredittoFile(userpCode, gencreditsum); // write credit to file
                
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                CreditManager.CheckForSimilarUserPcodeinFileandSumValues(userpCode);
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            // check credits to display it on panel1
            if (CreditManager.FindCredit("resources/credits.csv", userpCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
                userCreditsLabel.setText("none");
            } else {
                userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode)));
            }
        }
        if (e.getSource() == TAKE5Button) {
            Float filedcredit5;
            filedcredit5 = Float.parseFloat(creditoptionfiled5.getText());
            Credits credits = new Credits(filedcredit5);
            BigDecimal balance = BankAccountManager.GetBalance(userpCode);
            BigDecimal filedcredit1BigDecimal = BigDecimal.valueOf(filedcredit5);
            
            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(filedcredit1BigDecimal) >= 0 && credits.getTotal() <= 1000000){                
                CreditManager genCredit = new CreditManager();
                Transaction transaction = new Transaction(credits.getTotal(), BankAccountManager.FindBankAccount(userpCode), nickname); // create a new transaction object
                Float gencreditsum;
                gencreditsum = genCredit.GenCredit(credits.getTotal(), 5, 5);
                System.out.println(gencreditsum);
                BigDecimal bd2 = new BigDecimal(Float.toString(gencreditsum));
                bd2 = bd2.setScale(2, RoundingMode.HALF_UP); // 2 is the number of decimal places
                gencreditsum = bd2.floatValue();
                creditsumtotal5.setText(gencreditsum.toString());

                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney("000000-00000", "monolith@gmail.com", credits.getTotal());
                BankAccountManager.SendMoney(transaction); // send money to another account
                
                // to write credit to file credits.csv  
                CreditManager.WriteCredittoFile(userpCode, gencreditsum); // write credit to file
                
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                CreditManager.CheckForSimilarUserPcodeinFileandSumValues(userpCode);
                JOptionPane.showMessageDialog(this, "Success credit!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
            // check credits to display it on panel1
            if (CreditManager.FindCredit("resources/credits.csv", userpCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
                userCreditsLabel.setText("none");
            } else {
                userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode)));
            }
        }

        // repay your credit
        if (e.getSource() == repaycredit) {
            String recUsername = "MONOLITH"; // get receiver username MONOLITH account
            String recBankAccount = "7m493791o0684f1nof5fl8it80626123"; // get receiver bank account MONOLITH account 
            float moneyToSend = Float.valueOf(repaycreditfield.getText()); // get money to send

            Transaction transaction = new Transaction(moneyToSend, recBankAccount, recUsername); // create a new transaction object

            if (REGEXManager.isValidFloat(String.valueOf(moneyToSend)) && moneyToSend != 0 && moneyToSend == CreditManager.FindCredit("resources/credits.csv", userpCode)) { // find credit by personal code   
                BankAccountManager.SendMoney(transaction); // send money to another account
                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney(userpCode, useremail, moneyToSend);   // take money from sender account after sending money
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                CreditManager.DeleteMessage(userpCode);
                JOptionPane.showMessageDialog(this, "Successful transaction!"); // show success message
            } else {
                JOptionPane.showMessageDialog(this, "Invalid money input! You can not pay fewer or more than your loan! :)"); // show error message
            }
            //userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode)));
            // check credits to display it on panel1
            if (CreditManager.FindCredit("resources/credits.csv", userpCode) == null){  // if user doesnt have credits (to prevent from writing 'null')
                userCreditsLabel.setText("none");
            } else {
                userCreditsLabel.setText(String.valueOf(CreditManager.FindCredit("resources/credits.csv", userpCode)));
            }
        }

        // =================================================== Take credits ===================================================

        // turn on/off dark mode of application
        if (e.getSource() == darkModeChBox){    // turn on/off dark mode
            JLabel[] arrPanel1LabelsDMode = {accountLabel, bankAccLabel, availableBalanceLabel, userbalanceLabel,
                amountOfCreditLabel, userCreditsLabel, usernameLabel, userlastnameLabel};   // array for all labels on Panel1 except for imageLabel
            JButton[] arrPanel3ButtonsDMode = {TAKEButton, TAKE2Button, TAKE3Button, TAKE4Button, TAKE5Button, repaycredit};    // array of all buttons on Panel3

            JLabel[] arrPanel3LabelsDMode = {credit, credit2, credit3, credit4, credit5, credityear, credityear2, credityear3, credityear4, credityear5,
                percentsy, percentsy2, percentsy3, percentsy4, percentsy5, creditsum1, creditsum2, creditsum3, creditsum4, creditsum5,
                creditsumtotal, creditsumtotal2, creditsumtotal3, creditsumtotal4, creditsumtotal5};        // array with all labels on Panel3

            JLabel[] arrayPanel4LabelsDMode = {fondLabelM, fondLabelC, fondLabelD, fundcostM, fundcostC, fundcostD};  // array with all JLabels on Panel4

            if (darkModeChBox.isSelected()){
                getContentPane().setBackground(Color.DARK_GRAY);
                panel1.setBackground(darkModeBackgroundColor);
                panel2.setBackground(darkModeBackgroundColor);
                panel3.setBackground(darkModeBackgroundColor);
                panel4.setBackground(darkModeBackgroundColor);
                panel5.setBackground(darkModeBackgroundColor);

                // Panel 1
                overviewLabel.setForeground(titleColorDarkMode);
                for (JLabel label : arrPanel1LabelsDMode){   // change all labels colors to white
                    label.setForeground(Color.WHITE);
                }
                exitButton.setBackground(titleColorDarkMode);
                exitButton.setForeground(Color.BLACK);
                darkModeChBox.setBackground(titleColorDarkMode);
                comboBox.setBackground(titleColorDarkMode);
                editorPaneT.setBackground(Color.DARK_GRAY);
                editorPaneT.setForeground(Color.WHITE);
                calendarApp.changeColors(calendarBGColorDarkM, Color.GRAY, titleColorDarkMode, Color.WHITE);

                // Panel 2
                newPaymentLabel.setForeground(titleColorDarkMode);
                recUsernameLabel.setForeground(Color.WHITE);
                recBankAccountLabel.setForeground(Color.WHITE);
                moneyToSendLabel.setForeground(Color.WHITE);
                sendButton.setBackground(titleColorDarkMode);
                sendButton.setForeground(Color.BLACK);   

                // Panel3
                newLoanLable.setForeground(titleColorDarkMode);
                for (JButton button : arrPanel3ButtonsDMode){      // loop for all TAKE buttons
                    button.setBackground(titleColorDarkMode);
                    button.setForeground(Color.BLACK);   
                }

                for (JLabel label : arrPanel3LabelsDMode){      // loop for all labels on Panel3    
                    label.setForeground(Color.WHITE);
                }

                // Panel4
                fond1.setBackground(titleColorDarkMode);
                fond2.setBackground(titleColorDarkMode);
                fond3.setBackground(titleColorDarkMode);
                buyfond.setBackground(titleColorDarkMode);
                buyfond.setForeground(Color.BLACK);
                sellfond.setBackground(titleColorDarkMode);
                sellfond.setForeground(Color.BLACK);
                for (JLabel labelP4 : arrayPanel4LabelsDMode){  // loop for all labels on Panel4
                    labelP4.setBackground(titleColorDarkMode);
                }

                //Panel 5
                StyledDocument docForTAUPaneDM = textAboutUsPane.getStyledDocument();
                Style tStyleDM = textAboutUsPane.addStyle("Style", null);
                StyleConstants.setForeground(tStyleDM, Color.WHITE);
                docForTAUPaneDM.setCharacterAttributes(0, docForTAUPaneDM.getLength(), tStyleDM, false);
                textAboutUsPane.setBackground(Color.DARK_GRAY);
                editorPane.setBackground(titleColorDarkMode);

            } else {
                getContentPane().setBackground(defaultColorForFrame);
                panel1.setBackground(defaultBackgroundColor);
                panel2.setBackground(defaultBackgroundColor);
                panel3.setBackground(defaultBackgroundColor);
                panel4.setBackground(defaultBackgroundColor);
                panel5.setBackground(defaultBackgroundColor);

                // Panel 1
                overviewLabel.setForeground(defaultTitleColor);
                for (JLabel label : arrPanel1LabelsDMode){   // change all labels colors to white
                    label.setForeground(Color.BLACK);
                }
                exitButton.setBackground(defaultTitleColor);
                exitButton.setForeground(Color.WHITE);
                darkModeChBox.setBackground(secondaryMainColor);
                comboBox.setBackground(secondaryMainColor);
                editorPaneT.setBackground(secondaryMainColor);
                editorPaneT.setForeground(Color.BLACK);
                calendarApp.changeColors(Color.WHITE, new Color(153, 204, 255), new Color(51, 153, 255), Color.BLACK);

                // Panel 2
                newPaymentLabel.setForeground(defaultTitleColor);
                recUsernameLabel.setForeground(Color.BLACK);
                recBankAccountLabel.setForeground(Color.BLACK);
                moneyToSendLabel.setForeground(Color.BLACK);
                sendButton.setBackground(defaultTitleColor);
                sendButton.setForeground(Color.WHITE);   

                // Panel3
                newLoanLable.setForeground(defaultTitleColor);
                for (JButton button : arrPanel3ButtonsDMode){      // loop for all TAKE buttons
                    button.setBackground(defaultTitleColor);
                    button.setForeground(Color.WHITE);   
                }

                for (JLabel label : arrPanel3LabelsDMode){      // loop for all labels on Panel3    
                    label.setForeground(Color.BLACK);
                }

                // Panel4
                fond1.setBackground(radioButtonsColor);
                fond2.setBackground(radioButtonsColor);
                fond3.setBackground(radioButtonsColor);
                buyfond.setBackground(defaultTitleColor);
                buyfond.setForeground(Color.WHITE);
                sellfond.setBackground(defaultTitleColor);
                sellfond.setForeground(Color.WHITE);
                for (JLabel labelP4 : arrayPanel4LabelsDMode){  // loop for all labels on Panel4
                    labelP4.setBackground(radioButtonsColor);
                }

                // Panel 5
                StyledDocument docForTAUPaneDM = textAboutUsPane.getStyledDocument();
                Style tStyleDM = textAboutUsPane.addStyle("Style", null);
                StyleConstants.setForeground(tStyleDM, Color.BLACK);
                docForTAUPaneDM.setCharacterAttributes(0, docForTAUPaneDM.getLength(), tStyleDM, false);
                textAboutUsPane.setBackground(defaultColorForFrame);
                editorPane.setBackground(radioButtonsColor);
                
            }
        }


        // =================================================== Stock exchange (which fund selected)  ===================================================
        // to show the graph of the stock exchange and buttons lables / for radio btns
        if (fond1.isSelected()) {
            // Code for when radioButton1 is selected
            //panel4.add(slidingGraph);
            buyfond.setVisible(true);
            sellfond.setVisible(true);

            slidingGraph2.setVisible(false);
            slidingGraph3.setVisible(false);
            slidingGraph.setVisible(true);
            fondLabelM.setVisible(true);
            fondLabelC.setVisible(false);
            fondLabelD.setVisible(false);
            fundcostM.setVisible(true);
            fundcostC.setVisible(false);
            fundcostD.setVisible(false);
            fundscost = receivedata/10*90;
            fundname = "MONOLITH";
        } else if (fond2.isSelected()) {
            // Code for when radioButton2 is selected
            //panel4.add(slidingGraph2);
            buyfond.setVisible(true);
            sellfond.setVisible(true);

            slidingGraph.setVisible(false);
            slidingGraph3.setVisible(false);
            slidingGraph2.setVisible(true);
            fondLabelM.setVisible(false);
            fondLabelC.setVisible(true);
            fondLabelD.setVisible(false);
            fundcostM.setVisible(false);
            fundcostC.setVisible(true);
            fundcostD.setVisible(false);
            fundscost = receivedata/10*100;
            fundname = "CLEAR SKY";
        } else if (fond3.isSelected()) {
            // Code for when radioButton3 is selected
            //panel4.add(slidingGraph3);
            buyfond.setVisible(true);
            sellfond.setVisible(true);
            slidingGraph2.setVisible(false);
            slidingGraph.setVisible(false);
            slidingGraph3.setVisible(true);
            fondLabelM.setVisible(false);
            fondLabelC.setVisible(false);
            fondLabelD.setVisible(true);
            fundcostM.setVisible(false);
            fundcostC.setVisible(false);
            fundcostD.setVisible(true);
            fundscost = receivedata/10*120;
            fundname = "DUTY";
        }

        // =================================================== Stock exchange (whick funds selected)  ===================================================




        // =================================================== Stock exchange (buy, sell)  ===================================================
        // sell and buy action for btn in stock exchange
        if (e.getSource() == buyfond) {
            // nothing yet
            BigDecimal balance = BankAccountManager.GetBalance(userpCode); // get balance in big decimal
            
            String recUsername = "MONOLITH"; // get receiver username MONOLITH account
            String recBankAccount = "7m493791o0684f1nof5fl8it80626123"; // get receiver bank account MONOLITH account            

            BigDecimal fundscostBigDecimal = BigDecimal.valueOf(fundscost);
            
            if (balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(fundscostBigDecimal) >= 0){
                Transaction transaction = new Transaction(fundscost, recBankAccount, recUsername); // create a new transaction object
                BankAccountManager.SendMoney(transaction); // send money to another account
                BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney(userpCode, useremail, fundscost);   // take money from sender account after sending money
                FundsManager.WriteBoughtFunds(userpCode, fundscost, fundname); // write bought funds to file 
                userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                JOptionPane.showMessageDialog(this, "Successful transaction!"); // show success message
            } else {
                JOptionPane.showMessageDialog(this, "Invalid money input!"); // show error message
            }
        }

        // sell funds button
        if (e.getSource() == sellfond) {
            BigDecimal balance = BankAccountManager.GetBalance(userpCode); // get balance in big decimal
            
            //String recUsername = "MONOLITH"; // get receiver username MONOLITH account
            String bankpcode = "000000-00000";
            String bankemail = "monolith@gmail.com";
            //String recBankAccount = "7m493791o0684f1nof5fl8it80626123"; // get receiver bank account MONOLITH account            

            
            System.out.println("----------------------------> " + FundsManager.FindFund(userpCode, fundname) + " ---- " + BankAccountManager.FindBankAccount(userpCode) + " -------- " + username);
            
            if (FundsManager.CheckBoughtFunds(userpCode, fundname)) {
                if (balance.compareTo(BigDecimal.ZERO) > 0) {
                    Transaction transaction = new Transaction(FundsManager.CheckForSimilarFundsAndJoinSimilar(userpCode, fundname), BankAccountManager.FindBankAccount(userpCode), nickname); // create a new transaction object

                    BankAccountManager.SendMoney(transaction); // send money to another account
                    BankAccountManager.RemoveMoneyFromSenderInCSVAfterSendMoney(bankpcode, bankemail, FundsManager.CheckForSimilarFundsAndJoinSimilar(userpCode, fundname));   // take money from sender account after sending money


                    // ----------------
                    System.out.println(FundsManager.CheckForSimilarFundsAndJoinSimilar(userpCode, fundname)); // to check the sum of the funds
                    // ----------------

                    FundsManager.DeleteSimilarUserpcodeAndFundnamesinFile(userpCode, fundname);
                    userbalanceLabel.setText(String.valueOf(BankAccountManager.GetBalance(userpCode))); // update balance
                    JOptionPane.showMessageDialog(this, "Successful transaction!"); // show success message
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid money input!"); // show error message
                }
            } else {
                JOptionPane.showMessageDialog(this, "You do not have any funds to sell!"); // show error message
            }
        }
        // =================================================== Stock exchange (buy, sell)  ===================================================


        // =================================================== Exit ===================================================
        // exit button to log in window
        if (e.getSource() == exitButton) {
            //System.exit(0);
            this.setVisible(false); // Hide the current window

            Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

            ImageIcon imgIcon = new ImageIcon("resources/program_logo.jpg");    // logo

            GUIMainProgram.framelogreg = new GUILogReg(); // create a new frame
            framelogreg.setTitle("MONOLITH Bank v1.0");
            framelogreg.setIconImage(imgIcon.getImage());     // set icon
            framelogreg.setVisible(true);
            Color backgroundColor = new Color(211, 233, 252);   // for background color
            framelogreg.getContentPane().setBackground(backgroundColor);
            //frame.setBounds(10, 10, 1200, 750);
            framelogreg.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750); // to centre window
            framelogreg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framelogreg.setResizable(false);
        }
    }
    // =================================================== Exit ===================================================
}

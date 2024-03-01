
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   

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


    GUILogReg() {
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
        if (e.getSource() == regButton) {
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
            Registration reg = new Registration();
            reg.WriteToAFile(person);

            // if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
            //     JOptionPane.showMessageDialog(this, "Login Successful");
            // } else {
            //     JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            // }

        }
        if (e.getSource() == loginButton) {
            usernameField.setText("");
            userlastnameField.setText("");
        }
        // if (e.getSource() == showPassword) {
        //     if (showPassword.isSelected()) {
        //         userlastnameField.setEchoChar((char) 0);
        //     } else {
        //         userlastnameField.setEchoChar('*');
        //     }
        // }
    }  
}  // +
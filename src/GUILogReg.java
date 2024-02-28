
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
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


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
        usernameLabel.setBounds(50, 20, 100, 30);
        userlastnameLabel.setBounds(50, 60, 100, 30);
        userpcodeLabel.setBounds(50, 100, 100, 30);
        useremailLabel.setBounds(50, 140, 100, 30);
        userLabel.setBounds(50, 180, 100, 30);
        usernameField.setBounds(90, 20, 100, 30);
        userlastnameField.setBounds(90, 20, 100, 30);
        usernameField.setBounds(90, 20, 100, 30);
        usernameField.setBounds(90, 20, 100, 30);
        usernameField.setBounds(90, 20, 100, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(usernameLabel);
        container.add(userlastnameLabel);
        container.add(userpcodeLabel);
        container.add(useremailLabel);
        container.add(userLabel);
        container.add(usernameField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = usernameField.getText();
            pwdText = userlastnameField.getText();
            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == resetButton) {
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
    // public static void main(String s[]) {  
    //     JFrame frame = new JFrame();
    //     frame.setSize(150,150);
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setTitle("Test Frame");
    //     frame.setVisible(true); 
    // }   
}  // +
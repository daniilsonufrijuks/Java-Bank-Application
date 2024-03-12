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
    JLabel usernameLabel;
    JLabel userlastnameLabel;
    JButton addmButton = new JButton("ADD MONEY");

    public GUIMainProgram(String userText, String userlnameText) {
        usernameLabel = new JLabel(userText);
        userlastnameLabel = new JLabel(userlnameText);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        usernameLabel.setBounds(1000, 20, 100, 30);
        userlastnameLabel.setBounds(1050, 20, 100, 30); 
        addmButton.setBounds(0, 0, 70, 20);
    }

    public void addComponentsToContainer() {
        container.add(usernameLabel);
        container.add(userlastnameLabel);
        container.add(addmButton);
    }

    public void addActionEvent() {
        addmButton.addActionListener(this);
    }

    //@Override
    public void ActionPerformed(ActionEvent e) {
        if (e.getSource() == addmButton) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}  

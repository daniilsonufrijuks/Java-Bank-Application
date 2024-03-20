package controller;

import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import java.util.Properties;

// import javax.mail.*;
// import javax.mail.internet.*;
// import java.util.*;
// import javax.mail.*;
// import javax.mail.internet.*;
// import javax.activation.*;
// import java.util.Properties;
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 

import javax.mail.Session;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// public class AutoSendonYourEmail {
//     public static void main(String[] args) throws InterruptedException {

//         String host = "smtp.elasticemail.com";
//         String port = "25"; 
//         String fromAddress = "monolithabout@gmail.com"; 
//         String toAddress = "kroshthebestfriend@gmail.com";

//         Properties props = new Properties();
//         props.put("mail.smtp.host", host);
//         props.put("mail.smtp.port", port);
//         props.put("mail.smtp.auth", "true"); // Enable authentication

//         String username = "Mark";
//         String password = "1Aa2Bb3Cc456Yjkp0=";

//         Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//             protected PasswordAuthentication getPasswordAuthentication() {
//                 return new PasswordAuthentication(username, password);
//             }
//         });

//         try {
//             // Создание сообщения
//             Message message = new MimeMessage(session);
//             message.setFrom(new InternetAddress(fromAddress));
//             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
//             message.setSubject("Message");
//             message.setText("Hello, we are MONOLITH");

//             // Отправка сообщения
//             Transport.send(message);

//             System.out.println("Succes.");
//         } catch (AuthenticationFailedException e) {
//             System.out.println("Authentication failed: " + e.getMessage());
//         } catch (MessagingException e) {
//             throw new RuntimeException(e);
//         }
//     }
//}
public class AutoSendonYourEmail {

    public static void main(String [] args) {          
        // email ID of Recipient. 
        String recipient = "kroshthebestfriend@gmail.com"; 
    
        // email ID of  Sender. 
        String sender = "monolithabout@gmail.com"; 
    
        // using host as localhost 
        String host = "127.0.0.1"; 
    
        // Getting system properties 
        Properties properties = System.getProperties(); 
    
        // Setting up mail server 
        properties.setProperty("mail.smtp.host", host); 
    
        // creating session object to get properties 
        Session session = Session.getDefaultInstance(properties); 
    
        try 
        { 
            // MimeMessage object. 
            MimeMessage message = new MimeMessage(session); 
    
            // Set From Field: adding senders email to from field. 
            message.setFrom(new InternetAddress(sender)); 
    
            // Set To Field: adding recipient's email to from field. 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
    
            // Set Subject: subject of the email 
            message.setSubject("This is Subject"); 
    
            // set body of the email. 
            message.setText("This is a test mail"); 
    
            // Send email. 
            Transport.send(message); 
            System.out.println("Mail successfully sent"); 
        } 
        catch (MessagingException mex)  
        { 
            mex.printStackTrace(); 
        } 
    }
}


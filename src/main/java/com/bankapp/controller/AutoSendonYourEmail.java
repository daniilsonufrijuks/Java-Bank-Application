package controller;

import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class AutoSendonYourEmail {
    public static void main(String[] args) throws InterruptedException {

        String host = "smtp.elasticemail.com";
        String port = "25"; 
        String fromAddress = "daniils.onufrijuksdp11@inbox.lv"; 
        String toAddress = "kroshthebestfriend@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true"); // Enable authentication

        String username = "daniils.onufrijuksdp11";
        String password = "";

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject("Message");
            message.setText("Hello, we are MONOLITH");

            // Отправка сообщения
            Transport.send(message);

            System.out.println("Succes.");
        } catch (AuthenticationFailedException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

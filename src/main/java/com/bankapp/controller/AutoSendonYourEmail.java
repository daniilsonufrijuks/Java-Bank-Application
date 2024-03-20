package controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class AutoSendonYourEmail {
    public static void SendEmail() {

        String host = "smtp.elasticemail.com";
        String port = "25"; 
        String fromAddress = "freemen1094@gmail.com"; 
        String toAddress = "kroshthebestfriend@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, null);

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

        } catch (MessagingException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}

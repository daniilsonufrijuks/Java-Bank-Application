package controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class AutoSendonYourEmail {
    public static void SendEmail() {

        // Параметры подключения к почтовому серверу
        String host = "smtp.example.com"; // укажите ваш SMTP сервер
        String port = "587"; // порт для отправки почты
        String username = "your-email@example.com"; // ваш адрес электронной почты
        String password = "your-password"; // ваш пароль

        // Адрес получателя
        String toAddress = "recipient@example.com";

        // Настройка свойств
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Создание сессии с аутентификацией
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject("Тестовое письмо");
            message.setText("Привет,\n\nЭто тестовое письмо из Java.");

            // Отправка сообщения
            Transport.send(message);

            System.out.println("Succes.");

        } catch (MessagingException e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class AutoSendonYourEmail {
    public static void SendEmail() {

        String host = "smtp.elasticemail.com"; // укажите ваш SMTP сервер
        String port = "25"; // порт для отправки почты (обычно 25)
        String fromAddress = "your-email@example.com"; // ваш адрес электронной почты
        String toAddress = "recipient@example.com"; // адрес получателя

        // Настройка свойств
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Создание сессии
        Session session = Session.getInstance(props, null);

        try {
            // Создание сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject("Тестовое письмо без аутентификации");
            message.setText("Привет,\n\nЭто тестовое письмо без аутентификации из Java.");

            // Отправка сообщения
            Transport.send(message);

            System.out.println("Письмо успешно отправлено.");

        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке письма: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

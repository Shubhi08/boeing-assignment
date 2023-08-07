package com.boeing.flight.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Component
public class EmailService {

    @Scheduled(cron = "*/10 * * * * *")
    public void sendMail() {
        String to = "surabhiy8@gmail.com";

        String from = "web@gmail.com";

        String host = "localhost";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Update on your flight status");

            message.setContent("<h1>Your flight is delayed</h1>", "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

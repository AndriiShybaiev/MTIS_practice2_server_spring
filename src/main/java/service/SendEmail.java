package service;// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public static boolean send(String to) {
        String from = "ashibayev@gmail.com";
        String host = "smtp.gmail.com";
        String username = "ashibayev@gmail.com";
        String password = "huetrjtytaetyvgy";
        Properties props = new Properties();
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.host", host);
        Session session = Session.getInstance(props);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message, username, password);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    return false;
    }
}
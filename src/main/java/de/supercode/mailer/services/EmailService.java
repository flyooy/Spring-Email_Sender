package de.supercode.mailer.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("us@us.us");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    public void sendHtmlEmail()  {

        try {
            MimeMessage message = mailSender.createMimeMessage();

            message.setRecipients(MimeMessage.RecipientType.TO, "hogan@hulkster.biceps");
            message.setSubject("Bewerbung als urnenträger");
            message.setFrom("me@me.me");
            String htmlContent = """
                    <h1>Ich Liebe Urnen</h1>
                    <div>Das ist meine Bewerbung</div>
                    """;

            message.setContent(htmlContent, "text/html; charset=utf-8");
            mailSender.send(message);
        }catch(MessagingException ex){
            ex.getCause();
        }
    }
}

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
        <div style="font-family: Arial, sans-serif; padding: 20px; background-color: #f4f4f4;">
            <div style="max-width: 600px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
                <div style="background-color: #008080; color: white; text-align: center; padding: 20px; border-radius: 8px 8px 0 0;">
                    <h1 style="margin: 0; font-size: 24px;">✨ Willkommen in der Welt der Urnen ✨</h1>
                </div>
                <div style="padding: 20px;">
                    <p>Sehr geehrter Herr Hogan,</p>
                    <p>Ich habe mit größtem Enthusiasmus Ihre Ausschreibung für die Stelle als Urnenträger gesehen und möchte Ihnen meine Dienste anbieten. Hier sind einige Gründe, warum ich der perfekte Kandidat bin:</p>
                    <ul style="list-style-type: none; padding-left: 0;">
                        <li style="margin-bottom: 10px;">
                            <strong>💪 Starke Arme:</strong> Ich kann problemlos schwere Lasten tragen, auch mit Stil!
                        </li>
                        <li style="margin-bottom: 10px;">
                            <strong>📦 Vorsichtig:</strong> Ich behandle jede Urne, als wäre sie aus Gold (sogar wenn она керамическая).
                        </li>
                        <li style="margin-bottom: 10px;">
                            <strong>🕴️ Stil und Eleganz:</strong> Mein schwarzer Anzug sitzt immer perfekt..
                        </li>
                    </ul>
                    <p>Ich bin bereit, schon morgen mit der Arbeit zu beginnen!</p>
                    <div style="text-align: center; margin-top: 20px;">
                        <a href="mailto:me@me.me" style="background-color: #008080; color: white; text-decoration: none; padding: 10px 20px; border-radius: 5px; font-size: 16px;">Antwort auf mein Schreiben</a>
                    </div>
                </div>
                <div style="background-color: #f4f4f4; color: #888; text-align: center; padding: 10px; border-radius: 0 0 8px 8px;">
                    <p style="margin: 0;">Mit freundlichen Grüßen,<br>Ihr zukünftiger Urnenträger</p>
                </div>
            </div>
        </div>
        """;

            message.setContent(htmlContent, "text/html; charset=utf-8");
            mailSender.send(message);
        }catch(MessagingException ex){
            ex.getCause();
        }
    }
}

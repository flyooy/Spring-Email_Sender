package de.supercode.mailer.controller;

import de.supercode.mailer.services.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public void sendMail() throws MessagingException {
        emailService.sendHtmlEmail();
    }
}

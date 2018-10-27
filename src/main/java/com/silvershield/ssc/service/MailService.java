package com.silvershield.ssc.service;

import com.silvershield.ssc.auth.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class MailService {

    private final Logger _logger = LoggerFactory.getLogger(MailService.class);

    @Value("${app.url}")
    private String appUrl;

    @Value("${app.email.from}")
    private String fromEmail;

    @Value("${app.email.support}")
    private String supportEmail;

    private JavaMailSender emailSender;
    private MailContentBuilder mailContentBuilder;

    @Autowired
    public MailService(JavaMailSender emailSender, MailContentBuilder mailContentBuilder){
        this.emailSender = emailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    private void sendMail(String recipient, String subject, String message, String url) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("sample@dolszewski.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setFrom(fromEmail);
            String content = mailContentBuilder.build(message, url);
            messageHelper.setText(content, true);
        };
        try {
            emailSender.send(messagePreparator);
            _logger.info("Email to [{}] sent successfully", recipient);
        } catch (MailException e) {
            System.err.println(e.getMessage());
        }
    }

    public void sendResetPassword(String to, String token) {
        String url = appUrl + "/api/v1/users/reset-password-change?token=" + token;
        String subject = "Reset Password";
        String text = "Please click the following link to reset your password: ";
        sendMail(to, subject, text, url);
    }

    private void sendNewRegistration(String to, String token) {
        _logger.info("Sending email to [{}] with registration token", to);
        String url = appUrl + "/api/v1/users/confirm-registration/" + token;
        String subject = "Please activate your account";
        String text = "Please click the following link to activate your account: ";
        sendMail(to, subject, text, url);
    }

    public void sendNewActivationRequest(String to, String token) {
        sendNewRegistration(to, token);
    }

    public void sendErrorEmail(Exception e, HttpServletRequest req, User user) {
        String subject = "Application Error: " + req.getRequestURL();
        String text = "An error occured in your application: " + e + "\r\nFor User:  " + user.getEmail();
        sendMail(supportEmail, subject, text, null);
    }
}

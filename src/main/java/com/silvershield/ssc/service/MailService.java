package com.silvershield.ssc.service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.silvershield.ssc.auth.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    private SendGrid sendGrid;
    private MailContentBuilder mailContentBuilder;

    @Autowired
    public MailService(SendGrid sendGrid, MailContentBuilder mailContentBuilder) {
        this.sendGrid = sendGrid;
        this.mailContentBuilder = mailContentBuilder;
    }

    private void sendMail(String recipient, String subject, String message, String url) {
        Email to = new Email(recipient);
        Email from = new Email(supportEmail, "SSC_SUPPORT_DONOTREPLY");
        Content content = new Content("text/html", mailContentBuilder.build(message, url));
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            _logger.debug("Request: [{}]", request);
            response = sendGrid.api(request);
            _logger.info("Response: [{}]::[{}]", response.getStatusCode(), response.getBody());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void sendResetPassword(String to, String token) {
        String url = appUrl + "/reset-password-change?token=" + token;
        String subject = "Reset Password";
        String text = "Please click the following link to reset your password: ";
        sendMail(to, subject, text, url);
    }

    private void sendNewRegistration(String to, String token) {
        _logger.info("Sending email to [{}] with registration token", to);
        String url = appUrl + "/confirm-registration?token=" + token;
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

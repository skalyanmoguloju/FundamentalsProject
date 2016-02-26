package com.fundamental.proj.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import java.util.UUID;

/**
 * Created by sai on 2/25/16.
 */
public class EmailVerification {
    private String username = "emailver.FSE.Group4@gmail.com";
    private String password = "UIowaGroup4";

    protected void setupAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public EmailVerification() {
        setupAccount(username, password);
    }

    public String generateKey() {
        UUID id = UUID.randomUUID(); // Generate a random ID
        return id.toString();
    }

    protected void sendEmail(String acctname, String desEmail, String subject, String msg) {

        HtmlEmail email = new HtmlEmail();

        try {
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(username, password));
            email.setSSLOnConnect(true);

            email.setFrom(this.username, acctname);
            email.addTo(desEmail);
            email.setSubject(subject);
            email.setMsg(msg);

            email.send();
            System.out.println("Successfully sent verification key to: " + desEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String sendEmailVerificationLink(String email, Long userId) {

        String key = generateKey();

        try {

            // send email to user
            String subject = "New user, Welcome to FSE-Group4!";
            String acturl = "http://localhost:8080/reg_activation/"+userId;
            String msg = "<html>" + "<body>" +
                    "Thank you for your interest in our services!\n\n" +
                    "Your username:  " + email + "\n" +
                    "<p>Please open this link to activate your account:" + "<a href=" + acturl + " target=\"_blank\">" + acturl + "</a>" + "</p>" +
                    "\n\n</body>" + "</html>";

            sendEmail("FSE-Group4 Email Verification", email, subject, msg);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return key;
    }

    public void sendEmailPasswordReset(String email, Long id ) {

        String subject = "Password Reset Verification!";
        String url = "http://localhost:8080/password_reset/"+id.toString();
        String msg = "<html>" + "<body>" +
                "Thank you for your interest in our services!\n" +
                "Your username:  " + email + "\n" +
                "<p>Please open this link to reset your password:\n" + "<a href=" + url + " target=\"_blank\">" + url + "</a>" + "</p>" +
                "</body>" + "</html>";

        sendEmail("FSE-Group4 Password Reset", email, subject, msg);

    }

    public static void main(String[] args) {

        EmailVerification rev = new EmailVerification();
    }

}

package com.fundamental.proj.util;

import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.controller.bean.MaterialIndentBean;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import java.util.*;

/**
 * Created by sai on 2/25/16.
 */
public class EmailNotification {
    private String username = "emailver.FSE.Group4@gmail.com";
    private String password = "UIowaGroup4";

    protected void setupAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public EmailNotification() {
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
            System.out.println("Successfully sent email to: " + desEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String sendEmailVerificationLink(String email, Long userId) {

        String key = generateKey();

            // send email to user
            String subject = "New user, Welcome to FSE-Group4!";
            String acturl = "http://localhost:8080/reg_activation/"+userId;
            String msg = "<html>" + "<body>" +
                    "Thank you for your interest in our services!\n\n" +
                    "Your username:  " + email + "\n" +
                    "<p>Please open this link to activate your account:" + "<a href=" + acturl + " target=\"_blank\">" + acturl + "</a>" + "</p>" +
                    "\n\n</body>" + "</html>";

            sendEmail("FSE-Group4 Email Verification", email, subject, msg);

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

    public String[] getArrivalDates (Date purchasedDate, ItemsBean itemsBean) {
        String[] arrivalDates = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(purchasedDate);

        int arrivalDay;
        int arrivalMonth;
        int arrivalYear;

        if (itemsBean.getSize().equals("Small")) {
            cal.add(Calendar.DATE, 1);
            arrivalDay = cal.get(Calendar.DATE);
            arrivalMonth = cal.get(Calendar.MONTH);
            arrivalYear = cal.get(Calendar.YEAR);
            arrivalDates[0] = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
            cal.add(Calendar.DATE, 3);
            arrivalDay = cal.get(Calendar.DATE);
            arrivalMonth = cal.get(Calendar.MONTH);
            arrivalYear = cal.get(Calendar.YEAR);
            arrivalDates[1] = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
        } else if (itemsBean.getSize().equals("Medium")) {
            cal.add(Calendar.DATE, 3);
            arrivalDay = cal.get(Calendar.DATE);
            arrivalMonth = cal.get(Calendar.MONTH);
            arrivalYear = cal.get(Calendar.YEAR);
            arrivalDates[0] = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
            cal.add(Calendar.DATE, 5);
            arrivalDay = cal.get(Calendar.DATE);
            arrivalMonth = cal.get(Calendar.MONTH);
            arrivalYear = cal.get(Calendar.YEAR);
            arrivalDates[1] = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
        } else {
            cal.add(Calendar.DATE, 5);
            arrivalDay = cal.get(Calendar.DATE);
            arrivalMonth = cal.get(Calendar.MONTH);
            arrivalYear = cal.get(Calendar.YEAR);
            arrivalDates[0] = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
            cal.add(Calendar.DATE, 7);
            arrivalDay = cal.get(Calendar.DATE);
            arrivalMonth = cal.get(Calendar.MONTH);
            arrivalYear = cal.get(Calendar.YEAR);
            arrivalDates[1] = (arrivalMonth + 1) + "/" + arrivalDay + "/" + arrivalYear;
        }

        return  arrivalDates;
    }

    public void sendEmailOrderConfirmation(String email, MaterialIndentBean materialIndentBean, List<CartBean> cartbeans) {

        Date purchasedDate = materialIndentBean.getIndent_date();

        String subject = "Order#" + materialIndentBean.getIndent_id() + " Confirmation!";
        String carts = "";
        for (CartBean cartbean : cartbeans) {
            String[] arrivalDates = getArrivalDates(purchasedDate, cartbean.getItemsBean());
            carts +=  "<tr> <td>" + cartbean.getItemsBean().getItem_name() + "</td> <td>" + cartbean.getItemsBean().getItem_description() + cartbean.getItemsBean().getSize() + "</td> <td>" + cartbean.getQuantity() + "</td> <td>" + cartbean.getPrice() + "</td> <td>" + "</td> <td>" + arrivalDates[0] + " - " + arrivalDates[1] + "</td> </tr>";
        }
        String msg = "<html>" + "<head>" + "<style>" + "table, th, td {border: 1px solid black; border-collapse: collapse;}" + "</style> </head>" +
                "<body>" +
                "Thank you for your purchase!" +
                "<p style=\"font-size:14px\">Your order number is <b style=\"font-size:20px\">" + materialIndentBean.getIndent_id() + "</b> </p>" +
                "<p>Below is the information of your order: </p>" +
                "<table style=\"width:100%\">" +
                "<tr>" + "<td>Item Name</td>" + "<td>Description</td>" + "<td>Size</td>" + "<td>Quantity</td>" + "<td>Price</td>"  + "<td>Estimated Arrival Date</td>" + "</tr>" +
                carts + "</table>" +
                "<table style=\"width:100%\">" +
                "<tr>" + "<td align=\"center\">Total </td>" + "<td align=\"center\">" + materialIndentBean.getPrice() + "</td>" + "</tr>" +
                "</table>" +
                "</body>" + "</html>";

        sendEmail("FSE-Group4 Order Confirmation", email, subject, msg);

    }

}

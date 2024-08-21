package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTask extends AsyncTask<Void, Void, Boolean> {

    private final String email;
    private final String subject;
    private final String message;

    public SendMailTask(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        final String username = "abramwel3@gmail.com";
        final String password = "22778866";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(this.subject);
            message.setText(this.message);

            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            Log.e("SendMailTask", "Error sending email", e);
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        // Handle post email send result if needed
    }
}

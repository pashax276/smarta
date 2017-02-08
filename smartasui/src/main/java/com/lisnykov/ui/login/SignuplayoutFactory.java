package com.lisnykov.ui.login;

import com.lisnykov.service.security.RegisterUserService;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by pasha on 2/7/17.
 */
@org.springframework.stereotype.Component
public class SignuplayoutFactory {


    @Autowired
    private RegisterUserService registerUserService;


    private class SignupForm {

        private VerticalLayout root;
        private Panel panel;
        private TextField username;
        private PasswordField passwordField;
        private PasswordField passwordAgainField;
        private Button saveButton;
        private TextField email;


        static final String FROM = "contact@opsmag.com";
        private String TO;


        private String BODY;
        static final String SUBJECT = "Smart As ... registration confirmation)";

        static final String SMTP_USERNAME = "AKIAJETR73E7JNZ4JKJA";
        static final String SMTP_PASSWORD = "ArBkmdXqTDQTXQfEbMJmJMO5iCZjislY88PsVrO+da8g";

        static final String HOST = "email-smtp.us-west-2.amazonaws.com";

        static final int PORT = 25;

        public SignupForm init() {

            root = new VerticalLayout();
            root.setMargin(true);
            root.setHeight("100%");

            panel = new Panel("Signup");
            panel.setSizeUndefined();

            saveButton = new Button("Save");
            saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

            username = new TextField("Username");
            username.setRequired(true);
            passwordField = new PasswordField("Password");
            passwordField.setRequired(true);

            passwordAgainField = new PasswordField("Password again");
            passwordAgainField.setRequired(true);

            email = new TextField("Email");
            email.setRequired(true);

            saveButton.addClickListener(new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {

                    if (!passwordAgainField.getValue().equals(passwordField.getValue())) {
                        Notification.show("Error", "Passwords do not match!", Notification.Type.ERROR_MESSAGE);

                    }
                    try {
                        sendEmail();
                        Notification.show("email sent to: " + email.getValue().toString());

                    } catch (MessagingException e) {
                        e.getMessage();

                        return;
                    }

                    registerUserService.save(username.getValue(), passwordField.getValue(), email.getValue());
                    UI.getCurrent().getPage().setLocation("/login");
                }

            });

            return this;
        }

        private void sendEmail() throws MessagingException {
            TO = email.getValue().toString();
            BODY = "Welcome to Smart As... game!  Thank you for requesting access to the system. \n" +
                    "\n" +
                    "Email: " + email.getValue().toString() + " \n" +
                    "User name: " + username.getValue().toString() + " \n" +
                    "\n" +
                    "If you have any questions, please contact the game administrator for assistance.\n" +
                    "\n" +
                    "PLEASE DO NOT REPLY TO THIS MESSAGE";

            Properties props = System.getProperties();
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtp.port", PORT);

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FROM));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));

            msg.setSubject(SUBJECT);

            msg.setContent(BODY, "text/plain");

            Transport transport = session.getTransport();
            try {
                transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

                transport.sendMessage(msg, msg.getAllRecipients());
                System.out.println("Email sent!");
            } catch (Exception ex) {
                System.out.println("The email was not sent.");
                System.out.println("Error message: " + ex.getMessage());
            } finally {
                transport.close();
            }
        }


        public Component layout() {

            root.addComponent(panel);
            root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

            FormLayout signupLayout = new FormLayout();
            signupLayout.addComponent(username);
            signupLayout.addComponent(passwordField);
            signupLayout.addComponent(passwordAgainField);
            signupLayout.addComponent(email);

            signupLayout.addComponent(saveButton);
            signupLayout.setSizeUndefined();
            signupLayout.setMargin(true);

            panel.setContent(signupLayout);

            return root;
        }

    }

    public Component createComponent() {
        return new SignupForm().init().layout();
    }
}

package com.lisnykov.ui.login;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by pasha on 2/7/17.
 */
@org.springframework.stereotype.Component
public class LoginLayoutFactory {
    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    private class LoginForm {

        private VerticalLayout root;
        private Panel panel;
        private TextField username;
        private PasswordField passwordField;
        private Button loginButton;
        private Button signupButton;

        public LoginForm init() {

            root = new VerticalLayout();
            root.setMargin(true);
            root.setHeight("100%");

            panel = new Panel("Login");
            panel.setSizeUndefined();

            loginButton = new Button("Login");
            loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            loginButton.setIcon(FontAwesome.ENVELOPE_O);
            signupButton = new Button("Sign up");
            signupButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
            signupButton.setIcon(FontAwesome.SIGN_IN);

            username = new TextField("Username");
            passwordField = new PasswordField("Password");

            return this;
        }

        public Component layout() {

            root.addComponent(panel);
            root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

            FormLayout loginLayout = new FormLayout();
            loginLayout.addComponent(username);
            loginLayout.addComponent(passwordField);

            loginLayout.addComponent(new HorizontalLayout(loginButton, signupButton));
            loginLayout.setSizeUndefined();
            loginLayout.setMargin(true);

            loginButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {

                    try {

                        Authentication auth = new UsernamePasswordAuthenticationToken(username.getValue(), passwordField.getValue());
                        Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
                        SecurityContextHolder.getContext().setAuthentication(authenticated);

                        UI.getCurrent().getPage().setLocation("/ui");


                    }catch (AuthenticationException e){
                        Notification.show("ERROR", "Login failed!", Notification.Type.ERROR_MESSAGE);
                    }

                    username.clear();
                    passwordField.clear();

                }
            });

            signupButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {

                 UI.getCurrent().getPage().setLocation("/signup");

                }
            });

            panel.setContent(loginLayout);

            return root;
        }
    }

    public Component createComponent() {
        return new LoginForm().init().layout();
    }
}

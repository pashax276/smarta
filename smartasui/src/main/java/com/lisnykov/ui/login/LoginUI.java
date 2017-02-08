package com.lisnykov.ui.login;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pasha on 2/7/17.
 */
@SpringUI(path = LoginUI.PATH)
@Theme("valo")
public class LoginUI extends UI {

    public static final String PATH = "/login";

    @Autowired
    private LoginLayoutFactory loginLayoutFactory;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(loginLayoutFactory.createComponent());
    }
}

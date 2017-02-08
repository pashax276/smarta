package com.lisnykov.ui.login;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pasha on 2/7/17.
 */

@SpringUI(path = SignupUI.PATH)
@Theme("valo")
public class SignupUI extends UI {

    public static final String PATH = "/signup";

    @Autowired
    private SignuplayoutFactory signuplayoutFactory;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(signuplayoutFactory.createComponent());

    }
}

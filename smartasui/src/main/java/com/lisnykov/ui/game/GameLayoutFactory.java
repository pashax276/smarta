package com.lisnykov.ui.game;

import com.lisnykov.ui.commons.MainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by pasha on 2/1/17.
 */
@SpringView(name = GameLayoutFactory.NAME, ui = MainUI.class)
public class GameLayoutFactory extends VerticalLayout implements View {

    public static final String NAME= "setupgame";


    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("Game"));
    }
}

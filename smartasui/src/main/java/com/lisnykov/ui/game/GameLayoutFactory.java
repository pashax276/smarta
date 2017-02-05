package com.lisnykov.ui.game;

import com.lisnykov.ui.commons.MainUI;
import com.lisnykov.utils.GameDataUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pasha on 2/1/17.
 */
@SpringView(name = GameLayoutFactory.NAME, ui = MainUI.class)
public class GameLayoutFactory extends VerticalLayout implements View, GameDataSavedListener {

    public static final String NAME = "setupgame";

    private TabSheet tabSheet;


    @Autowired
    private AddGameDataLayoutFactory addGameDataLayoutFactory;

    @Autowired
    private ShowAllGameDataLayoutFactory showAllGameDataLayoutFactory;


    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        removeAllComponents();
        addLayout();
    }

    private void addLayout() {
        setMargin(true);

        tabSheet = new TabSheet();
        tabSheet.setWidth("100%");

        Component addGameSetupData = addGameDataLayoutFactory.createComponent(this);
        Component showAllQuestions = showAllGameDataLayoutFactory.createComponent();

        tabSheet.addTab(showAllQuestions, GameDataUtils.SHOW_ALL_QUESTIONS.getString());
        tabSheet.addTab(addGameSetupData, GameDataUtils.SETUP_GAME_MENU.getString());

        addComponent(tabSheet);

    }

    @Override
    public void gameDataSaved() {
        showAllGameDataLayoutFactory.refreshTable();
    }
}

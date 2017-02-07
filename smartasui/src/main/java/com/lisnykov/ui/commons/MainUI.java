package com.lisnykov.ui.commons;


import com.lisnykov.ui.game.GameLayoutFactory;
import com.lisnykov.ui.navigator.SmartAsNavigator;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by pasha on 2/1/17.
 */
@SpringUI(path = MainUI.NAME)
@Title("Smart as...")
@Theme("valo")
public class MainUI extends UI {

    public static final String NAME = "/ui";

    @Autowired
    private MenuFactory menuFactory;

    @Autowired
    private MainboardFactory mainboardFactory;

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private SpringViewProvider viewProvider;

    private Panel changeTab = new Panel();

    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout rootLayout = new VerticalLayout();

        setSizeFull();
        //changeTab.setHeight("100%");

        HorizontalLayout uiLayout = new HorizontalLayout();

        setHeight("100%");

        Component menu = menuFactory.createComponent();
        Component main = mainboardFactory.createComponent();

        uiLayout.setSizeFull();
        uiLayout.setMargin(true);
        uiLayout.addComponent(menu);
        uiLayout.addComponent(changeTab);

        uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
        uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);

        uiLayout.setExpandRatio(menu, 0.6f);
        uiLayout.setExpandRatio(changeTab, 2.4f);


        rootLayout.addComponent(uiLayout);
        rootLayout.setComponentAlignment(uiLayout, Alignment.MIDDLE_CENTER);

        initNavigator();

        setContent(rootLayout);
    }

    private void initNavigator() {
        SmartAsNavigator navigator = new SmartAsNavigator(this, changeTab);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
        navigator.addProvider(viewProvider);
        navigator.navigateTo(GameLayoutFactory.NAME);
    }


}

package com.lisnykov.ui.commons;

import com.lisnykov.ui.navigator.SmartAsNavigator;
import com.lisnykov.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

@org.springframework.stereotype.Component
public class MenuFactory {


    private class Menu extends VerticalLayout implements Property.ValueChangeListener {

        private Button logout;

        private Tree mainMenu;

        public Menu init() {

            mainMenu = new Tree();
            mainMenu.addValueChangeListener(this);

            return this;

        }

        public Menu menuLayout() {

            setWidth("100%");
            setHeightUndefined();

            mainMenu.addItem(StringUtils.MENU_GAME.getString());
            mainMenu.addItem(StringUtils.MENU_RESUME.getString());

            mainMenu.expandItem(StringUtils.MENU_GAME.getString());
            mainMenu.expandItem(StringUtils.MENU_RESUME.getString());

            mainMenu.addItem(StringUtils.MENU_MY_RESUME.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_MY_RESUME.getString(), false);
            mainMenu.setParent(StringUtils.MENU_MY_RESUME.getString(), StringUtils.MENU_RESUME.getString());

            mainMenu.addItem(StringUtils.MENU_GAME_SETUP.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_GAME_SETUP.getString(), false);
            mainMenu.setParent(StringUtils.MENU_GAME_SETUP.getString(), StringUtils.MENU_GAME.getString());

            addComponent(buildTitle());
            addComponent(mainMenu);

            return this;


        }

        private Component buildTitle() {
            Label logo = new Label("<strong>" + StringUtils.MENU_NAME.getString() + "</strong>", ContentMode.HTML);
            logo.setSizeUndefined();
            HorizontalLayout logoWrapper = new HorizontalLayout(logo);
            logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
            logoWrapper.addStyleName("valo-menu-title");
            return logoWrapper;
        }

        public void valueChange(Property.ValueChangeEvent event) {

            String selectItemPath = (String) event.getProperty().getValue();

            if (selectItemPath == null) return;

            String path = selectItemPath.toLowerCase().replaceAll("\\s+", "");
            SmartAsNavigator.navigate(path);

        }
    }

    public Component createComponent() {
        return new Menu().init().menuLayout();
    }
}
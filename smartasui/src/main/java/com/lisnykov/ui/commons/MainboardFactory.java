package com.lisnykov.ui.commons;

import com.lisnykov.ui.views.UIComponentBuilder;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by pasha on 2/1/17.
 */
@org.springframework.stereotype.Component
public class MainboardFactory implements UIComponentBuilder {


    private class Mainboard extends VerticalLayout {
        private Label label;

        public Mainboard init() {

            label = new Label("Hi!!!");

            return this;

        }

        public Mainboard mainboardLayout() {

            setHeight("100%");
            addComponent(label);
            return this;
        }
    }

    public Component createComponent() {
        return new Mainboard().init().mainboardLayout();
    }

}

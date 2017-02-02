package com.lisnykov.ui.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;


/**
 * Created by pasha on 2/1/17.
 */
public class SmartAsNavigator extends Navigator {

    public SmartAsNavigator(UI ui, SingleComponentContainer container) {
        super(ui, container);
    }

    private static SmartAsNavigator getNavigator() {
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        return (SmartAsNavigator) navigator;
    }

    public static void navigate(String path) {
        try {
            SmartAsNavigator.getNavigator().navigateTo(path);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void navigateTo(String viewName) {
        super.navigateTo(Strings.nullToEmpty(viewName));
    }


}

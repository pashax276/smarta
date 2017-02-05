package com.lisnykov.ui.resume;

import com.lisnykov.ui.commons.MainUI;
import com.lisnykov.utils.ResumeStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pasha on 2/1/17.
 */
@SpringView(name = ResumeLayoutFactory.NAME, ui = MainUI.class)
public class ResumeLayoutFactory extends VerticalLayout implements View {


    public static final String NAME = "resume";

    @Autowired
    private AddResumeMainLayoutFactory addResumeMainLayoutFactory;
    @Autowired
    private AddResumeExperienceFactory addResumeExperienceFactory;

    private TabSheet tabSheet;

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        removeAllComponents();
        addLayout();
    }


    private void addLayout() {

        setMargin(true);
        tabSheet = new TabSheet();
        tabSheet.setWidth("100%");

        Component addResumeMainTab = addResumeMainLayoutFactory.createComponent();
        Component addResumeExperienceTab = addResumeExperienceFactory.createComponent();
        Component addResumeEducationTab = new Label("Education");
        Component addResumeSkillsTab = new Label("Skills");
        Component addResumeInterestsTab = new Label("Interests");
        tabSheet.addTab(addResumeMainTab, ResumeStringUtils.MAIN_MENU.getString());
        tabSheet.addTab(addResumeEducationTab, ResumeStringUtils.EDUCATION_MENU.getString());
        tabSheet.addTab(addResumeExperienceTab, ResumeStringUtils.EXPERIENCE_MENU.getString());
        tabSheet.addTab(addResumeSkillsTab, ResumeStringUtils.SKILLS_MENU.getString());
        tabSheet.addTab(addResumeInterestsTab, ResumeStringUtils.INTERESTS_MENU.getString());

        addComponent(tabSheet);

    }


}

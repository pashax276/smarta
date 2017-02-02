package com.lisnykov.ui.resume;

import com.lisnykov.model.entity.ResumeData;
import com.lisnykov.utils.Gender;
import com.lisnykov.utils.ResumeStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by pasha on 2/2/17.
 */
@org.springframework.stereotype.Component
public class AddResumeMainLayoutFactory {

    private class AddResumeMainLayout extends VerticalLayout {

        private TextField firstName;
        private TextField lastName;
        private TextField email;
        private TextField address;
        private TextField zipCode;
        private ComboBox country;
        private TextField phoneNumber;
        private ComboBox phoneType;
        private TextField website;
        private ComboBox contactedVia;
        private ComboBox gender;
        private TextField age;

        private Button saveButton;
        private Button clearButton;

        private BeanFieldGroup<ResumeData> fieldGroup;

        private ResumeData resumeData;

        public AddResumeMainLayout init() {

            fieldGroup = new BeanFieldGroup<ResumeData>(ResumeData.class);
            resumeData = new ResumeData();

            firstName = new TextField(ResumeStringUtils.FIRST_NAME.getString());
            lastName = new TextField(ResumeStringUtils.LAST_NAME.getString());
            gender = new ComboBox(ResumeStringUtils.GENDER.getString());
            age = new TextField(ResumeStringUtils.AGE.getString());
            email = new TextField(ResumeStringUtils.EMAIL.getString());
            address = new TextField(ResumeStringUtils.ADDRESS.getString());
            zipCode = new TextField(ResumeStringUtils.ZIP_CODE.getString());
            country = new ComboBox(ResumeStringUtils.COUNTRY.getString());
            phoneNumber = new TextField(ResumeStringUtils.PHONE_NUMBER.getString());
            phoneType = new ComboBox("");
            website = new TextField(ResumeStringUtils.WEBSITE.getString());
            contactedVia = new ComboBox(ResumeStringUtils.CONTACTED_VIA.getString());

            saveButton = new Button(ResumeStringUtils.SAVE_BUTTON.getString());
            clearButton = new Button(ResumeStringUtils.CLEARE_BUTTON.getString());

            saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

            gender.addItem(Gender.MALE.getString());
            gender.addItem(Gender.FEMALE.getString());

            firstName.setNullRepresentation("");
            lastName.setNullRepresentation("");
            email.setNullRepresentation("");
            address.setNullRepresentation("");
            zipCode.setNullRepresentation("");

            return this;
        }

        public AddResumeMainLayout bind() {
            fieldGroup.bindMemberFields(this);

            fieldGroup.setItemDataSource(resumeData);

            return this;
        }

        public Component layout() {

            setMargin(true);

            address.setWidth("100%");

            GridLayout gridLayout = new GridLayout(2, 6);
            gridLayout.setSpacing(true);
            gridLayout.setSizeUndefined();

            gridLayout.addComponent(firstName, 0, 0);
            gridLayout.addComponent(lastName, 1, 0);

            gridLayout.addComponent(gender, 0, 1);
            gridLayout.addComponent(age, 1, 1);

            gridLayout.addComponent(email, 0, 2);

            gridLayout.addComponent(address, 0, 3, 1, 3);
            gridLayout.addComponent(zipCode, 0, 4);
            gridLayout.addComponent(country, 1, 4);

            gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 5);

            return gridLayout;
        }


    }

    public Component createComponent() {
        return new AddResumeMainLayout().init().bind().layout();
    }

}

package com.lisnykov.ui.resume;

import com.lisnykov.model.entity.ResumeData;
import com.lisnykov.utils.Gender;
import com.lisnykov.utils.ResumeStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.*;

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

            gender.addItem(Gender.MALE.getString());
            gender.addItem(Gender.FEMALE.getString());

            return this;
        }

        public AddResumeMainLayout layout() {
            return this;
        }
    }

    public Component createComponent() {
        return new AddResumeMainLayout().init().layout();
    }

}

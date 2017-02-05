package com.lisnykov.ui.resume;

import com.lisnykov.model.entity.ResumeData;
import com.lisnykov.service.addresume.AddResumeService;
import com.lisnykov.utils.Gender;
import com.lisnykov.utils.NotificationMessages;
import com.lisnykov.utils.ResumeStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by pasha on 2/2/17.
 */
@org.springframework.stereotype.Component
public class AddResumeMainLayoutFactory {

    private class AddResumeMainLayout extends VerticalLayout implements Button.ClickListener {

        private TextField firstName;
        private TextField lastName;
        private TextField email;
        private TextField address;
        private TextField zipCode;
        private ComboBox country;
        private TextField phone;
        private ComboBox phoneType;
        private TextField website;
        private ComboBox contactedVia;
        private ComboBox gender;
        private TextField age;
        private TextField education;
        private TextArea experience;

        private Button saveButton;
        private Button clearButton;

        private BeanFieldGroup<ResumeData> fieldGroup;

        private ResumeData resumeData;

        public AddResumeMainLayout init() {

            fieldGroup = new BeanFieldGroup<>(ResumeData.class);
            resumeData = new ResumeData();

            firstName = new TextField(ResumeStringUtils.FIRST_NAME.getString());
            lastName = new TextField(ResumeStringUtils.LAST_NAME.getString());
            gender = new ComboBox(ResumeStringUtils.GENDER.getString());
            age = new TextField(ResumeStringUtils.AGE.getString());
            email = new TextField(ResumeStringUtils.EMAIL.getString());
            address = new TextField(ResumeStringUtils.ADDRESS.getString());
            zipCode = new TextField(ResumeStringUtils.ZIP_CODE.getString());
            country = new ComboBox(ResumeStringUtils.COUNTRY.getString());
            phone = new TextField(ResumeStringUtils.PHONE_NUMBER.getString());
            phoneType = new ComboBox("");
            website = new TextField(ResumeStringUtils.WEBSITE.getString());
            contactedVia = new ComboBox(ResumeStringUtils.CONTACTED_VIA.getString());
            education = new TextField("Education");
            experience = new TextArea("Experience");


            saveButton = new Button(ResumeStringUtils.SAVE_BUTTON.getString());
            clearButton = new Button(ResumeStringUtils.CLEAR_BUTTON.getString());

            saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);


            saveButton.addClickListener(this);
            clearButton.addClickListener(this);

            country.addItem("USA");

            gender.addItem(Gender.MALE.getString());
            gender.addItem(Gender.FEMALE.getString());

            phoneType.addItem("Mobile");
            phoneType.addItem("Home");
            phoneType.addItem("Work");

            firstName.setNullRepresentation("");
            lastName.setNullRepresentation("");
            email.setNullRepresentation("");
            address.setNullRepresentation("");
            zipCode.setNullRepresentation("");
            age.setNullRepresentation("");

            return this;
        }

        public AddResumeMainLayout bind() {
            fieldGroup.bindMemberFields(this);

            fieldGroup.setItemDataSource(resumeData);

            return this;
        }

        public Component layout() {

            setMargin(true);
            country.setTextInputAllowed(true);

            address.setWidth("100%");
            experience.setWidth("100%");

            GridLayout gridLayout = new GridLayout(2, 10);
            gridLayout.setSpacing(true);
            gridLayout.setSizeUndefined();

            gridLayout.addComponent(firstName, 0, 0);
            gridLayout.addComponent(lastName, 1, 0);

            gridLayout.addComponent(gender, 0, 1);
            gridLayout.addComponent(age, 1, 1);

            gridLayout.addComponent(email, 0, 2);
            gridLayout.addComponent(education, 1,2);

            gridLayout.addComponent(address, 0, 3, 1, 3);
            gridLayout.addComponent(zipCode, 0, 4);
            gridLayout.addComponent(country, 1, 4);
            gridLayout.addComponent(experience,0,5,1,5);

            gridLayout.addComponent(phone,0,6);
            gridLayout.addComponent(phoneType, 1,6);

            gridLayout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 9);

            return gridLayout;
        }


        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {

            if (clickEvent.getSource() == this.saveButton) {
                save();
            } else {
                clearField();
            }

        }

        private void clearField() {

            firstName.setValue(null);
            lastName.setValue(null);
            email.setValue(null);
            address.setValue(null);
            zipCode.setValue(null);
            country.setValue(null);
            phone.setValue(null);
            phoneType.setValue(null);
            contactedVia.setValue(null);
            gender.setValue(null);
            age.setValue(null);

        }

        private void save() {
            try {
                fieldGroup.commit();

            } catch (FieldGroup.CommitException e) {

                Notification.show(NotificationMessages.RESUME_SAVE_VALIDATION_ERROR_TITLE.getString(),
                        NotificationMessages.RESUME_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(),
                        Notification.Type.ERROR_MESSAGE);

                return;

            }
            Notification notification = new Notification(NotificationMessages.RESUME_SAVE_VALIDATION_SUCCES.getString());
            notification
                    .setDescription("<span>This application is not real, it only demonstrates an application built with the <a href=\"https://vaadin.com\">Vaadin framework</a>.</span> <span>No username or password is required, just click the <b>Sign In</b> button to continue.</span>");
            notification.setHtmlContentAllowed(true);
            notification.setStyleName("tray dark small closable login-help");
            notification.setPosition(Position.BOTTOM_CENTER);
            notification.setDelayMsec(20000);
            notification.show(Page.getCurrent());
            notification.setStyleName(ValoTheme.NOTIFICATION_SUCCESS);

            System.out.println(resumeData);

            addResumeService.saveResume(resumeData);

            clearField();
        }
    }

    @Autowired
    private AddResumeService addResumeService;

    public Component createComponent() {
        return new AddResumeMainLayout().init().bind().layout();
    }

}

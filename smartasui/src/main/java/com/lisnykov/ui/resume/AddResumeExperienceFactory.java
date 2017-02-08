package com.lisnykov.ui.resume;

import com.vaadin.ui.*;

/**
 * Created by pasha on 2/3/17.
 */
@org.springframework.stereotype.Component
public class AddResumeExperienceFactory {

    private class AddResumeExperience extends VerticalLayout {

        private TextField employer;
        private TextField jobTitle;
        private ComboBox country;
        private TextField location;
        private TextArea description;
        private TextField skills;
        private CheckBox currentStatus;
        private Calendar dateFrom;
        private Calendar dateTo;


    }


    public Component createComponent() {
        return null;
    }
}

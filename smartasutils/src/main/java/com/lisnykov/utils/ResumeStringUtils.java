package com.lisnykov.utils;

/**
 * Created by pasha on 2/2/17.
 */
public enum  ResumeStringUtils {
    MAIN_MENU("Contact information"),
    EXPERIENCE_MENU("Experience"),
    EDUCATION_MENU("Education"),
    SKILLS_MENU("Skills"),
    INTERESTS_MENU("Interests"),

    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    GENDER("Gender"),
    AGE("Age"),
    ADDRESS("Address"),
    ZIP_CODE("Zip Code"),
    COUNTRY("Country"),
    PHONE_NUMBER("Phone number"),
    PHONE_TYPE(""),
    CONTACTED_VIA("I prefer to be contacted via"),
    SAVE_BUTTON("Save"),
    CLEAR_BUTTON("Clear"),
    WEBSITE("Website"),
    EMAIL("Email"),
    ;

    private final String string;

    ResumeStringUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

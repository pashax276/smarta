package com.lisnykov.utils;

/**
 * Created by pasha on 2/2/17.
 */
public enum NotificationMessages {

    RESUME_SAVE_VALIDATION_ERROR_TITLE("ERROR"),
    RESUME_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be fields"),
    RESUME_SAVE_VALIDATION_SUCCES("Save successfully")
    ;

    private final String string;

    NotificationMessages(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

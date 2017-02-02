package com.lisnykov.utils;

/**
 * Created by pasha on 2/1/17.
 */
public enum StringUtils {

    MENU_NAME("Smart As . . ."),

    MENU_RESUME("RESUME"),
    MENU_MY_RESUME("Resume"),
    MENU_LOGOUT("Logout"),
    MENU_GAME("GAME"),
    MENU_GAME_SETUP("Setup Game")

    ;

    private final String string;

    StringUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

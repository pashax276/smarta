package com.lisnykov.utils;

/**
 * Created by pasha on 2/4/17.
 */
public enum GameDataUtils {
    SHOW_ALL_QUESTIONS("All questions"),
    SETUP_GAME_MENU("Setup game"),

    QUESTION_NAME("Name"),
    QUESTION("Question"),
    QUESTION_TYPE("Type"),
    QUESTION_POINTS("Points"),
    QUESTION_ANSWER("Answer"),

    SAVE_BUTTON("Save"),
    CLEAR_BUTTON("Clear");

    private final String string;

    GameDataUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}

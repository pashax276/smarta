package com.lisnykov.utils;

/**
 * Created by pasha on 2/2/17.
 */
public enum Gender {

    MALE("male"),
    FEMALE("female");

    private String string;

    Gender(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

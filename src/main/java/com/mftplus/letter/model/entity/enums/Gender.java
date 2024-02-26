package com.mftplus.letter.model.entity.enums;

public enum Gender {
    male("مرد"),
    female("زن");

    private String title;
    Gender(String title) {
        this.title = title;
    }
}

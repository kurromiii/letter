package com.mftplus.letter.model.entity.enums;

import lombok.Getter;

@Getter
public enum LetterAccessLevel {
    normal("عادی"),
    secret("محرمانه");

    public final String title;

    LetterAccessLevel(String title) {
        this.title = title;
    }

}

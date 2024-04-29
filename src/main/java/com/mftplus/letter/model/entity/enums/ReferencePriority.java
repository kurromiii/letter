package com.mftplus.letter.model.entity.enums;

import lombok.Getter;

@Getter
public enum ReferencePriority {
    normal("عادی"),
    urgent("فوری");

    public final String title;

    ReferencePriority(String title) {
        this.title = title;
    }
}

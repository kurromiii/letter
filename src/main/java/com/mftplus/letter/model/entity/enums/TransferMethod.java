package com.mftplus.letter.model.entity.enums;

import lombok.Getter;

@Getter
public enum TransferMethod {
    post("پست"),
    deliverLetter("حضوری"),
    fax("فکس"),
    inSystem("داخلی"),
    email("ایمیل");

    private final String title;

    TransferMethod(String title) {
        this.title = title;
    }
}

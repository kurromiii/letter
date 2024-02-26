package com.mftplus.letter.model.entity.enums;

public enum Role {
    admin("ادمین"),
    manager("مدیر"),
    employee("کارمند"),
    customer("ارباب رجوع");

    private final String title;

    Role(String title) {
        this.title = title;
    }

}

package com.mftplus.letter.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompositeKey implements Serializable {
    private String roleName;

    private User user;

    public CompositeKey(String roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }
}

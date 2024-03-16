package com.mftplus.letter.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
@SuperBuilder
public class CompositeKey implements Serializable {
    @Column(name = "role_name")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "u_username")
    private User user;
}

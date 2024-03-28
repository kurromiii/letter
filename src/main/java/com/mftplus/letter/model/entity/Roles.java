package com.mftplus.letter.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "userRolesEntity")
@Table(name = "user_roles")

public class Roles extends Base implements Serializable {
    @EmbeddedId
    private CompositeKey compositeKey;
}

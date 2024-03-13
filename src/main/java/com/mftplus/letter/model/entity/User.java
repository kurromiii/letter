package com.mftplus.letter.model.entity;

import com.mftplus.letter.model.entity.enums.Role;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "userEntity")
@Table(name = "user_tbl")
@RequestScoped
public class User extends Base implements Serializable {
    //id is set as username because username must be unique like id
    @Id
//    @Pattern(regexp = "^[a-zA-Z\\s]{5,15}$", message = "Invalid Username")
    @Column(name = "u_username", length = 15)
    private String username;

//    @Pattern(regexp = "^[a-zA-Z\\s]{8,20}$", message = "Invalid Password")
    @Column(name = "u_password", length = 20)
    private String password;

    @OneToOne
    private Person person;

    @ManyToOne
    private Section section;

    @Column(name="u_active")
    private boolean active;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Roles> roles;
}

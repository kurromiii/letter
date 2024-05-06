package com.mftplus.letter.model.entity;

import com.google.gson.Gson;
import com.mftplus.letter.model.entity.enums.Role;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "userEntity")
@Table(name = "user_tbl")
@RequestScoped
public class User extends Base implements Serializable {
    @Id
    @Pattern(regexp = "^[a-zA-Z\\s]{4,15}$", message = "Invalid Username")
    @Column(name = "u_username", length = 15, nullable = false)
    private String username;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,20}$",message = "Minimum five characters, at least one letter and one number!")
    @Column(name = "u_password", length = 20, nullable = false)
    private String password;

    @OneToOne
    private Person person;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @ManyToOne (fetch = FetchType.LAZY)
    @ToString.Exclude
    private Section section;

    @Column(name="u_active")
    private boolean active;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Roles> roleList;

    public void addRole(Roles role){
        if (roleList==null){
            roleList=new ArrayList<>();
        }
        roleList.add(role);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}

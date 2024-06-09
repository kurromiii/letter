package com.mftplus.letter.model.entity;

import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@ToString
public class User extends Base implements Serializable {
    @Id
    @Column(name = "u_username", columnDefinition = "NVARCHAR2(15)", nullable = false)
    @Pattern(regexp = "^[a-zA-Z\\s]{4,15}$", message = "Invalid Username")
    @Size(min = 4, max = 15, message = "Username must be between 4 and 15 characters")
    @NotBlank(message = "Should Not Be Null")
    private String username;

    @JsonbTransient
    @Column(name = "u_password", columnDefinition = "NVARCHAR2(20)", nullable = false)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,20}$",message = "Minimum five characters, at least one letter and one number!")
    @Size(min = 5, max = 20, message = "Password must be between 3 and 20 characters")
    @NotBlank(message = "Should Not Be Null")
    private String password;

    @Column(name="u_active")
    private boolean active;

    //realm roles
    @JsonbTransient
    @OneToMany(mappedBy = "user")
    private List<Roles> roleList;

    public void addRole(Roles role){
        if (roleList==null){
            roleList=new ArrayList<>();
        }
        roleList.add(role);
    }

    @JsonbTransient
    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
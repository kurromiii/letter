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
//    @Id
//    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq",allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
//    @Column (name = "r_Id")
//    private long id;
//    @Id
//    @Column(name = "role_name")
//    private String roleName;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "u_username")
//    private User user;
    @EmbeddedId
    private CompositeKey compositeKey;
}

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

@Entity(name = "rolesEntity")
@Table(name = "roles_tbl", uniqueConstraints = {@UniqueConstraint(columnNames = {"u_username","role_name"})})
public class Roles extends Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "u_username")
    private User user;

    @Column(name = "role_name")
    private String role;

}

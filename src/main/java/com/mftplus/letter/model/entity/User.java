package com.mftplus.letter.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity(name = "userEntity")
@Table(name = "user_tbl")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "u_Id")
    private long id;

}

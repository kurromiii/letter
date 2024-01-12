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

@Entity (name = "secretariatEntity")
@Table (name = "secretariat_tbl")
//todo we need some instances
public class Secretariat implements Serializable{
    @Id
    @SequenceGenerator(name = "secretariatSeq", sequenceName = "secretariat_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secretariatSeq")
    @Column(name = "s_Id")
    private long id;

    //todo this has to be defined
    @Column(name = "s_indicatorCode")
    private String indicatorCode;
}

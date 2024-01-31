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

@Entity(name = "letterRegisterEntity")
@Table(name = "letterRegister_tbl")
public class LetterRegister implements Serializable {
    @Id
    @SequenceGenerator(name = "letterRegisterSeq", sequenceName = "letterRegister_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letterRegisterSeq")
    @Column(name = "l_r_Id")
    //register number
    private long id;




}

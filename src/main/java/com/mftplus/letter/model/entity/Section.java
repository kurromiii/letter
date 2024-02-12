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

@Entity(name = "sectionEntity")
@Table(name = "section_tbl")
public class Section implements Serializable {
    @Id
    @SequenceGenerator(name = "letterSeq", sequenceName = "letter_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letterSeq")
    @Column (name = "s_Id")
    private long id;
}

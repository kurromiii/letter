package com.mftplus.letter.model.entity;

import com.mftplus.letter.model.entity.enums.Gender;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "personEntity")
@Table(name = "person_tbl")
@RequestScoped
public class Person extends Base implements Serializable {

    //todo : nullable false has not been set yet
    //todo : validation commented for production
    //todo : attachment

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSeq")
    @Column(name = "id")
    private Long id;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Name")
    @Column(name = "p_name", length = 30)
    private String name;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Family")
    @Column(name = "p_family", length = 30)
    private String family;

//    @Pattern(regexp = "^[0-9\\s]{10}$", message = "Invalid NationalCode")
    @Column(name = "p_nationalCode", length = 10)
    private String nationalCode;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "p_username", nullable = false,unique = true)
    private User user;

    @Column(name = "p_birthdate")
    private LocalDate birthdate;

    @Column(name = "p_image")
    private String image;

}

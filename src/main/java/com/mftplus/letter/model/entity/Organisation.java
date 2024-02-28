package com.mftplus.letter.model.entity;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "organisationEntity")
@Table(name = "organisation_tbl")
@RequestScoped
public class Organisation extends Base implements Serializable {
    @Id
    @SequenceGenerator(name = "organisationSeq", sequenceName = "organisation_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organisationSeq")
    @Column(name = "O_id")
    private Long id;


    @Column(name = "o_title" , length = 40)
    private String title;

    @Column(name = "o_name" , length = 30)
    private String name;

    @OneToOne
    private Attach logo;

    @Column(name = "o_address" , length = 100)
    private String address;


    @Column(name = "o_phoneNumber" , length = 11)
    private String phoneNumber;

    @Column(name = "o_description")
    private String description;


    @OneToMany
    private List<Section> sectionList;

    public void addSection(Section section){
        if (sectionList==null){
            sectionList=new ArrayList<>();
        }
        sectionList.add(section);
    }

}

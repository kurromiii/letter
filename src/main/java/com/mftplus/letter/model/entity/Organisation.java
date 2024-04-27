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

    //todo : nullable false has not been set yet
    //todo : validation commented for production
    //todo : attachment
    //todo : validation for address

    @Id
    @SequenceGenerator(name = "organisationSeq", sequenceName = "organisation_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organisationSeq")
    @Column(name = "id")
    private Long id;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Organization Title")
    @Column(name = "o_title" , length = 30)
    private String title;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Organization Name")
    @Column(name = "o_name" , length = 30)
    private String name;

    @OneToOne
    private Attach logo;

    @Column(name = "o_address" , length = 100)
    private String address;

//    @Pattern(regexp = "^[0-9\\s]{10}$", message = "Invalid Organization PhoneNumber")
    @Column(name = "o_phoneNumber" , length = 11)
    private String phoneNumber;

//    @Pattern(regexp = "^[a-zA-Z\\s]{10,}$", message = "Invalid Organization Description")
    @Column(name = "o_description")
    private String description;

    @OneToMany (fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Section> sectionList;

    public void addSection(Section section){
        if (sectionList==null){
            sectionList=new ArrayList<>();
        }
        sectionList.add(section);
    }

}

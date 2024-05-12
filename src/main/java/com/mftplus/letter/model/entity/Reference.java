package com.mftplus.letter.model.entity;

import com.github.mfathi91.time.PersianDateTime;
import com.mftplus.letter.model.entity.enums.ReferencePriority;
import com.mftplus.letter.model.entity.enums.ReferenceType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "referenceEntity")
@Table(name = "reference_tbl")
public class Reference extends Base implements Serializable {
    //todo : for all entities validation msg is in eng, we need to decide for the persian msg

    @Id
    @SequenceGenerator(name = "referenceSeq", sequenceName = "reference_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referenceSeq")
    @Column (name = "r_id")
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @ToString.Exclude
    private Letter letterId;

    @Enumerated (EnumType.ORDINAL)
    private ReferenceType refType;

    @Enumerated (EnumType.ORDINAL)
    private ReferencePriority priority;

    @ManyToOne
    @JoinColumn(name = "reference_sender",nullable = false)
    private User referenceSenderId;

    @ManyToOne
    @JoinColumn(name = "reference_receiver",nullable = false)
    private User referenceReceiverId;

    //todo : does this need @futureOrPresent? I set is as localDateTime.now in servlet
    @Column (name = "r_date_and_time")
    private LocalDateTime refDateAndTime;

    //todo : does not work
    @Transient
    private LocalDateTime faRefDateAndTime;

    public String getFaRefDateAndTime() {
        return PersianDateTime.fromGregorian(refDateAndTime).toString();
    }

    public void setFaRefDateAndTime(String faRefDateAndTime) {
        this.refDateAndTime = PersianDateTime.parse(faRefDateAndTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toGregorian();
    }

    @Column (name = "r_expiration")
    @Future(message = "Invalid reference expiration date")
    private LocalDateTime expiration;

    @Transient
    private String faExpiration;

    public String getFaExpiration() {
       return PersianDateTime.fromGregorian(expiration).toString();
    }

    public void setFaExpiration(String faExpiration) {
        this.expiration = PersianDateTime.parse(faExpiration, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toGregorian();
    }

    @Column (name = "r_paraph" , columnDefinition = "NVARCHAR2(50)")
    @Pattern(regexp = "^[a-zA-Zآ-ی\\s]{3,50}$", message = "Invalid paraph")
    @Size(min = 3, max = 50, message = "Paraph must be between 3 and 50 characters")
    @NotBlank(message = "Should Not Be Null")
    private String paraph;

    @Column (name = "r_explanation" , columnDefinition = "NVARCHAR2(50)")
    @Pattern(regexp = "^[a-zA-Zآ-ی\\s]{3,50}$", message = "Invalid Explanation")
    @Size(min = 3, max = 50, message = "Explanation must be between 3 and 50 characters")
    @NotBlank(message = "Should Not Be Null")
    private String explanation;

    //todo : how should i set this?
    @Column(name = "r_status")
    private boolean status;

    //todo : how should i set this?
    @Column(name = "r_validate")
    private boolean validate;

}

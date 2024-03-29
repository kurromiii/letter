package com.mftplus.letter.model.entity;

import com.github.mfathi91.time.PersianDate;
import com.mftplus.letter.model.entity.enums.LetterAccessLevel;
import com.mftplus.letter.model.entity.enums.LetterType;
import com.mftplus.letter.model.entity.enums.TransferMethod;
import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity (name = "letterEntity")
@Table (name = "letter_tbl")
@RequestScoped
public class Letter extends Base implements Serializable {
    @Id
    @SequenceGenerator(name = "letterSeq", sequenceName = "letter_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letterSeq")
    @Column (name = "l_Id")
    private long id;

    @Column (name = "l_title" , length = 20)
    private String title;

    @Column (name = "l_letter_number" , length = 30)
    private String letterNumber;

    @Column (name = "l_date")
    private LocalDate date;

    @Transient
    private String faDate;

    public String getFaDate() {
        return String.valueOf(PersianDate.fromGregorian(date));
    }

    public void setFaDate(String faDate) {
        this.date =PersianDate.parse(faDate).toGregorian();
    }

    @Column (name = "l_context")
    private String context;

    @Column (name = "l_receiver_name" , length = 25)
    private String receiverName;

    @Column (name = "l_receiver_title" , length = 25)
    private String receiverTitle;

    @Column (name = "l_sender_name" , length = 25)
    private String senderName;

    @Column (name = "l_sender_title", length = 25)
    private String senderTitle;

    @Column (name = "l_file")
    private String image;

    @Enumerated (EnumType.ORDINAL)
    private LetterAccessLevel accessLevel;

  //todo rethink
    @ManyToMany (cascade = {CascadeType.MERGE , CascadeType.PERSIST} , fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> carbonCopies;

    @ManyToOne (cascade = {CascadeType.MERGE} , fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @Enumerated (EnumType.ORDINAL)
    private TransferMethod transferMethod;

    @Enumerated (EnumType.ORDINAL)
    private LetterType letterType;

    //todo
//    @OneToOne
//    private LetterRegister registerNumber;
//
//    @ManyToOne
//    private Secretariat indicatorCode;

    @Column (name = "l_register_date_and_time")
    private LocalDateTime registerDateAndTime;

//    @Transient
//    private LocalDateTime faRegisterDateAndTime;
//
//    public String getFaRegisterDateAndTime() {
//        return PersianDate.fromGregorian(LocalDate.from(registerDateAndTime)).toString();
//    }
//
//    public void setFaRegisterDateAndTime(String faRegisterDateAndTime) {
//        this.registerDateAndTime = LocalDateTime.from(PersianDate.parse(faRegisterDateAndTime).toGregorian());
//    }
//
    @ManyToMany (cascade = {CascadeType.MERGE , CascadeType.PERSIST} , fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> refReceivers;

}

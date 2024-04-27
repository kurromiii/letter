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
import java.util.ArrayList;
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

    //todo : nullable false has not been set yet
    //todo : validation commented for production
    //todo : attachment

    @Id
    @SequenceGenerator(name = "letterSeq", sequenceName = "letter_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letterSeq")
    @Column (name = "id")
    private long id;

    @Column (name = "l_title" , length = 20)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Invalid Letter Title")
    private String title;

    @Column (name = "l_letter_number" , length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Letter Number")
    private String letterNumber;

    @ManyToOne (cascade = {CascadeType.MERGE} , fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    //ref receivers
    @ManyToMany (cascade = {CascadeType.MERGE , CascadeType.PERSIST} , fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> userList;

    public void addUser(User user){
        if (userList==null){
            userList=new ArrayList<>();
        }
        userList.add(user);
    }

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Sender Name")
    @Column (name = "l_sender_name" , length = 30)
    private String senderName;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Sender Title")
    @Column (name = "l_sender_title", length = 30)
    private String senderTitle;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Receiver Name")
    @Column (name = "l_receiver_name" , length = 30)
    private String receiverName;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$", message = "Invalid Receiver Title")
    @Column (name = "l_receiver_title" , length = 30)
    private String receiverTitle;

    @Column (name = "l_file")
    private String image;

    @Enumerated (EnumType.ORDINAL)
    private LetterAccessLevel accessLevel;

    @Enumerated (EnumType.ORDINAL)
    private TransferMethod transferMethod;

    @Enumerated (EnumType.ORDINAL)
    private LetterType letterType;

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

    //    @Pattern(regexp = "^[a-zA-Z\\s]{10,}$", message = "Invalid Context Name")
    @Column (name = "l_context")
    private String context;
}

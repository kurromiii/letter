package com.mftplus.letter.model.entity;

import com.github.mfathi91.time.PersianDate;
import com.mftplus.letter.model.entity.enums.LetterAccessLevel;
import com.mftplus.letter.model.entity.enums.LetterType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.TermVector;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity (name = "letterEntity")
@Table (name = "letter_tbl")

@NamedQueries({
        @NamedQuery(name = "Letter.FindByTitle",query = "select oo from letterEntity oo where oo.title=:title"),
        @NamedQuery(name = "Letter.FindByContext",query = "select oo from letterEntity oo where oo.context=:context"),
        @NamedQuery(name = "Letter.FindByDate",query = "select oo from letterEntity oo where oo.date=:date")
})
public class Letter implements Serializable {
    @Id
    @SequenceGenerator(name = "letterSeq", sequenceName = "letter_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letterSeq")
    @Column (name = "l_Id")
    private long id;

    @Column (name = "l_title" , length = 20)
    private String title;

    @Column (name = "l_letter_number" , length = 30 , unique = true)
    private String letterNumber;

    @Column (name = "l_date")
    private LocalDate date;

    @Transient
    private LocalDate faDate;

    public String getFaDate() {
        return PersianDate.fromGregorian(date).toString();
    }

    public void setFaDate(String faDate) {
        this.date = PersianDate.parse(faDate).toGregorian();
    }

    @Column (name = "l_subject", length = 25)
    private String subject;

    @Column (name = "l_context")
    //for search
    @Field(termVector = TermVector.YES)
    private String context;

    @Column (name = "l_receiver_name" , length = 25)
    private String receiverName;

    @Column (name = "l_receiver_title" , length = 25)
    private String receiverTitle;

    @Column (name = "l_sender_name" , length = 25)
    private String senderName;

    @Column (name = "l_sender_title", length = 25)
    private String senderTitle;

    @Column (name = "l_image")
    private String image;

    @Enumerated (EnumType.ORDINAL)
    private LetterAccessLevel accessLevel;

    //todo rethink
    @ManyToMany
    private List<User> carbonCopies;

    @ManyToOne
    private User user;

    @ManyToOne
    private TransferMethod transferMethod;

    @Enumerated (EnumType.ORDINAL)
    private LetterType letterType;











}

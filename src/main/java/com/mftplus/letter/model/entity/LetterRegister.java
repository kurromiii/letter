package com.mftplus.letter.model.entity;

import com.github.mfathi91.time.PersianDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @ManyToOne
    private Letter letter;

    @ManyToOne
    private Secretariat secretariat;

    @Column (name = "l_register_date_and_time")
    private LocalDateTime registerDateAndTime;

    @Transient
    private LocalDateTime faRegisterDateAndTime;

    public String getFaRegisterDateAndTime() {
        return PersianDate.fromGregorian(LocalDate.from(registerDateAndTime)).toString();
    }

    public void setFaRegisterDateAndTime(String faRegisterDateAndTime) {
        this.registerDateAndTime = LocalDateTime.from(PersianDate.parse(faRegisterDateAndTime).toGregorian());
    }

}

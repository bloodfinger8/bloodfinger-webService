package com.bloodfinger.project.springboot.domain.reservation;


import com.bloodfinger.project.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Reservation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false)
    private String phnNo;

    @Column
    private String sex;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column
    private String type;

    @Column(columnDefinition = "", nullable = false)
    private int personNo;

    @Column( nullable = false)
    private String realSender;

    @Column
    private String comment;

    @Column(nullable = false)
    private String privacyPermission;


    @Builder
    public Reservation(String name ,String phnNo, String sex , String date , String time , String type,
                       int personNo , String realSender , String comment , String privacyPermission){
        this.name = name;
        this.phnNo = phnNo;
        this.sex = sex;
        this.date = date;
        this.time = time;
        this.type = type;
        this.personNo = personNo;
        this.realSender = realSender;
        this.comment = comment;
        this.privacyPermission = privacyPermission;
    }
}

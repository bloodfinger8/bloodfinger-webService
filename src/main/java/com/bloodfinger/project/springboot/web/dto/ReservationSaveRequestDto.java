package com.bloodfinger.project.springboot.web.dto;

import com.bloodfinger.project.springboot.domain.reservation.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class ReservationSaveRequestDto {
    private String name;
    private String phnNo;
    private String sex;
    private String date;
    private String time;
    private String type;
    private String personNo;
    private String realSender;
    private String comment;
    private String privacyPermission;


    @Builder
    public ReservationSaveRequestDto(String name , String phnNo, String sex , String date , String time , String type,
                                     String personNo , String realSender , String comment , String privacyPermission){
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

    public Reservation toEntity(){
        return Reservation.builder()
                .name(name)
                .phnNo(phnNo)
                .sex(sex)
                .date(date)
                .time(time)
                .type(type)
                .personNo(personNo)
                .realSender(realSender)
                .comment(comment)
                .privacyPermission(privacyPermission)
                .build();
    }

}

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
    private String date;
    private String time;
    private String type;
    private String comment;
    private String privacyPermission;


    @Builder
    public ReservationSaveRequestDto(String name , String phnNo, String date , String time , String type,
                                     String comment , String privacyPermission){
        this.name = name;
        this.phnNo = phnNo;
        this.date = date;
        this.time = time;
        this.type = type;
        this.comment = comment;
        this.privacyPermission = privacyPermission;
    }

    public Reservation toEntity(){
        return Reservation.builder()
                .name(name)
                .phnNo(phnNo)
                .date(date)
                .time(time)
                .type(type)
                .comment(comment)
                .privacyPermission(privacyPermission)
                .build();
    }

}

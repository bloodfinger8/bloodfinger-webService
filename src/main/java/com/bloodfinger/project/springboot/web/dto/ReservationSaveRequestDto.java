package com.bloodfinger.project.springboot.web.dto;

import com.bloodfinger.project.springboot.domain.reservation.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ReservationSaveRequestDto {
    @NotEmpty(message = "예약자 이름은 필수 입니다.")
    private String name;

//    @NotEmpty(message = "연락처는 필수 입니다.")
    private String phnNo;

//    @NotEmpty(message = "예약 날짜는 필수 입니다.")
    private String date;

//    @NotEmpty(message = "예약 시간은 필수 입니다.")
    private String time;

    private String type;
    private String comment;
    private String privacyPermission;


//    @Builder
//    public ReservationSaveRequestDto(String name , String phnNo, String date , String time , String type,
//                                     String comment , String privacyPermission){
//        this.name = name;
//        this.phnNo = phnNo;
//        this.date = date;
//        this.time = time;
//        this.type = type;
//        this.comment = comment;
//        this.privacyPermission = privacyPermission;
//    }
//
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

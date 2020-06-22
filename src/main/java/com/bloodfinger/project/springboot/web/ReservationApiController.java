package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.service.reservation.ReservationService;
import com.bloodfinger.project.springboot.web.dto.PostsSaveRequestDto;
import com.bloodfinger.project.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReservationApiController {

    private ReservationService reservationService;


    @PostMapping("/api/v1/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto reservationSaveRequestDto){

        System.out.println("나와랏 :: " + reservationSaveRequestDto);
        //return reservationService.save(reservationSaveRequestDto);
        return null;
    }


}

package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.service.reservation.ReservationService;
import com.bloodfinger.project.springboot.web.dto.PostsSaveRequestDto;
import com.bloodfinger.project.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReservationApiController {

    private final ReservationService reservationService;


    @PostMapping("/api/v1/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto reservationSaveRequestDto){
          return reservationService.save(reservationSaveRequestDto);
    }


}

package com.bloodfinger.project.springboot.service.reservation;

import com.bloodfinger.project.springboot.domain.reservation.ReservationRepository;
import com.bloodfinger.project.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional
    public Long save(ReservationSaveRequestDto reservationSaveRequestDto){
         return reservationRepository.save(reservationSaveRequestDto.toEntity()).getNo();
    }
}

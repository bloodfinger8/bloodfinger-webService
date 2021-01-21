package com.bloodfinger.project.springboot.service.reservation;

import com.bloodfinger.project.springboot.domain.reservation.ReservationRepository;
import com.bloodfinger.project.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public Long save(ReservationSaveRequestDto reservationSaveRequestDto){
        return reservationRepository.save(reservationSaveRequestDto.toEntity()).getNo();
    }

    @Transactional
    public void sendEmail(ReservationSaveRequestDto reservationSaveRequestDto) throws MessagingException , IOException {
        StringBuilder text = new StringBuilder();
        text.append("예약자명 : " + reservationSaveRequestDto.getName() + "\r\n");
        text.append("연락처 : " + reservationSaveRequestDto.getPhnNo()+ "\r\n");
        text.append("예약날짜 : " + reservationSaveRequestDto.getDate()+ "\r\n");
        text.append("예약자명 : " + reservationSaveRequestDto.getTime()+ "\r\n");
        text.append("요청사항 : " + reservationSaveRequestDto.getComment());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("didwodn8822@gmail.com");
        message.setFrom("didwodn8822@gmail.com");
        message.setSubject(reservationSaveRequestDto.getDate() + " / 예약 신청");
        message.setText(text.toString());

        mailSender.send(message);
    }
}

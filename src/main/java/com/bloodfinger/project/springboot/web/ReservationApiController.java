package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.config.auth.LoginUser;
import com.bloodfinger.project.springboot.config.auth.dto.SessionUser;
import com.bloodfinger.project.springboot.service.reservation.ReservationService;
import com.bloodfinger.project.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class ReservationApiController {

    private final ReservationService reservationService;


    @PostMapping("/api/v1/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto reservationSaveRequestDto){
          return reservationService.save(reservationSaveRequestDto);
    }

    @GetMapping("/reservation/save")
    public String reservationSave( Model model ,@LoginUser SessionUser user){
        ReservationSaveRequestDto reservationSaveRequestDto = new ReservationSaveRequestDto();
        model.addAttribute("reservationSaveRequestDto" , reservationSaveRequestDto);
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "reservation/reservationForm";
    }

    @PostMapping("/reservation/save")
    public String reservationCreated(@Valid ReservationSaveRequestDto reservationSaveRequestDto , BindingResult result){
        if(result.hasErrors()) {
            return "reservation/reservationForm";
        }

        reservationService.save(reservationSaveRequestDto);

        //이메일 전송
//        try {
//            reservationService.sendEmail(reservationSaveRequestDto);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "redirect:/";
    }
}

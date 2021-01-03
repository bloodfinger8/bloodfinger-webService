package com.bloodfinger.project.springboot.web;

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
    public String reservationSave( Model model){
        ReservationSaveRequestDto dto = new ReservationSaveRequestDto();
        model.addAttribute("dto" , dto);
        return "reservation/reservation-save";
    }

    @PostMapping("/reservation/save")
    public String reservationCreated(@Valid ReservationSaveRequestDto dto , BindingResult result){
        if(result.hasErrors()) {
            return "reservation/reservation-save";
        }
        return "redirect:/";
    }
}

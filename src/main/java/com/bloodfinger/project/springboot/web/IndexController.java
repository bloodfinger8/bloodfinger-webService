package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.config.auth.LoginUser;
import com.bloodfinger.project.springboot.config.auth.dto.SessionUser;
import com.bloodfinger.project.springboot.service.posts.PostsService;
import com.bloodfinger.project.springboot.web.dto.PostsResponseDto;
import com.bloodfinger.project.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;


//    @GetMapping("/")
//    public String index(Model model , @LoginUser SessionUser user){
//        if(user != null){
//            model.addAttribute("userName" , user.getName());
//        }
//        return "index";
//    }
    @GetMapping("/")
    public String index(Model model ){
        return "index";
    }

    /**
     * 게시판
     */
    @GetMapping("/notice")
    public String notice(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts" , postsService.findAllDesc());

        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "notice";
    }

    //예약
    @GetMapping("/reservation/kind")
    public String reservation(){
        return "reservation/reservation-kind";
    }

//    //lesson
//    @GetMapping("/lesson")
//    public String lesson(){
//        return "lesson";
//    }

    @GetMapping("/posts/save")
    public String postsSave(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id , Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post" , dto);
        return "posts-update";
    }

    @GetMapping("/loginForm")
    public String loginForm(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }

        return "loginForm";
    }


}
package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.config.auth.LoginUser;
import com.bloodfinger.project.springboot.config.auth.dto.SessionUser;
import com.bloodfinger.project.springboot.service.posts.PostsService;
import com.bloodfinger.project.springboot.web.dto.PostsResponseDto;
import com.bloodfinger.project.springboot.web.dto.PostsSaveRequestDto;
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
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    /**
     * 메인화면
     */
    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "index";
    }

    /**
     * 예약
     */
    @GetMapping("/reservation/kind")
    public String reservation(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "reservation/reservation-kind";
    }

    /**
     * 소개 - 이력
     */
    @GetMapping("/about/me")
    public String aboutMe(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "about/aboutMe";
    }

    /**
     * 위치
     */
    @GetMapping("/location")
    public String location(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "location/locationAtTheJ";
    }


    /**
     * 게시판 - qna 목록
     */
    @GetMapping("/notice/qna")
    public String qna(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts" , postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "notice/qna";
    }

    /**
     * 게시판 - qna 목록
     */
    @GetMapping("/notice/faq")
    public String faq(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "notice/faq";
    }

    /**
     * 게시판 - 글 작성
     */
    @GetMapping("/posts/save")
    public String postsSave(Model model , @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }
        return "notice/qna-save";
    }

    /**
     * 게시판 - 글 상세보기
     */
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id , Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post" , dto);
        return "notice/qna-update";
    }

    /**
     * 로그인
     */
    @GetMapping("/login/lo")
    public String login(Model model){
//        SessionUser user = (SessionUser)httpSession.getAttribute("user");
//
//        if(user != null){
//            model.addAttribute("userName" , user.getName());
//        }
        return "login";
    }


    /**
     * 회원가입
     */
    @GetMapping("/join")
    public String joinForm(Model model , @LoginUser SessionUser user){
        return "join";
    }


}
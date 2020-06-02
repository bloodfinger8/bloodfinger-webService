package com.bloodfinger.project.springboot.web;

import com.bloodfinger.project.springboot.config.auth.LoginUser;
import com.bloodfinger.project.springboot.config.auth.dto.SessionUser;
import com.bloodfinger.project.springboot.service.posts.PostsService;
import com.bloodfinger.project.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts" , postsService.findAllDesc());

//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName" , user.getName());
        }

//          model.addAttribute("display", "layout/container");

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id , Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post" , dto);
        return "posts-update";
    }


}
package com.example.gongu.controller;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/join")
    public String showJoinPage(){
        return "user/join";
    }



    @PostMapping("/userIdChk/{userId}")
    @ResponseBody
    public boolean userIdChk(@PathVariable String userId) throws Exception{
        // log.info("userIdChk() 진입");
        boolean falseOrTrue;
        log.info("request UserId : "+userId);
        log.info(userId);
        String result = userService.idCheck(userId);

        log.info("결과값 : " + result );


        if(result != null){
            falseOrTrue = true;
            return falseOrTrue;
        }else {
            falseOrTrue = false;
            return falseOrTrue;
        }
    }


    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    //로그인하는 부분?
    @PostMapping("/login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req){
      UserDto userDto = userService.find(userId, userPassword);
      req.getSession().setAttribute("userNumber", userDto.getUserNumber());

      return new RedirectView("/user/index");

    }





}


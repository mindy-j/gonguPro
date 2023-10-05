package com.example.gongu.controller;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    //로그인 화면전환
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    //아이디와 비번을 받아서 로그인 처리후 메인으로 화면전환
    @PostMapping("login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req){
        UserDto userDto = userService.find(userId, userPassword);
        req.getSession().setAttribute("userNumber", userDto.getUserNumber());
        req.getSession().setAttribute("userLevel", userDto.getUserLevel());
        return new RedirectView("index");
    }

    //메인화면으로가는 컨트롤러
    @GetMapping("/index")
    public String index(){
        return "index";
    }


    //회원가입 부분 화면전달
    @GetMapping("/join")
    public String join(){ return "user/join"; }


    @PostMapping("/join")
    public String join(UserDto userDto){
        userService.register(userDto);
        return "user/joinOk";
    }

    //아이디 중복체크
    @PostMapping("/userIdChk")
    @ResponseBody
    public String userIdChkPOST(String userId) throws Exception{
        // log.info("userIdChk 진입!!!!!");
        int result = userService.idCheck(userId);
        log.info("결과 : " + result);

        if(result !=0){
            return "fail"; //중복아이디
        } else {
            return "success"; //중복 아이디 없음
        }

    }

    @GetMapping("/joinOk")
    public String joinOk(){
        return "user/login";
    }


    //단순 페이지 이동-아이디찾기
    @GetMapping("/findId")
    public String findId(){
        return "user/findId";
    }

    //단순 페이지 이동 - 비밀번호 찾기
    @GetMapping("/findPassword")
    public String findPassword(){
        return "user/findPassword";
    }





    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "user/login";
    }

}


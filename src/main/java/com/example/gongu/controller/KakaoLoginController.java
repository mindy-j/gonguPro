package com.example.gongu.controller;


import com.example.gongu.service.KakaoLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@RestController
@RequestMapping("/auth")
public class KakaoLoginController {

    KakaoLoginService kakaoLoginService;

    @Autowired
    KakaoLoginController(KakaoLoginService kakaoLoginService){
        this.kakaoLoginService = kakaoLoginService;
    }

    @ResponseBody
    @GetMapping("/kakao")
    public ResponseEntity<String> kakaoCallBack(@RequestParam String code) throws Exception{
        log.info("call /auth/kakao");
        return kakaoLoginService.kakaoLoginProcess(code);
    }


}

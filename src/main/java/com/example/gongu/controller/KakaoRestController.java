package com.example.gongu.controller;

import com.example.gongu.service.KaKaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/kakaos")
@RequiredArgsConstructor
public class KakaoRestController {
    private final KaKaoService kaKaoService;

    @GetMapping("/code")
    public String getCode(String code){
        String accessToken = kaKaoService.getToken(code);
        Map<String, Object> userInfo = kaKaoService.getUserInfo(accessToken);
        Map<String, Object> kakaoAccount = (Map<String, Object>)userInfo.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>)kakaoAccount.get("profile");
        String nickName = (String)profile.get("nickname");
        String email =(String) kakaoAccount.get("email");

        return nickName + " " + email;
    }
}

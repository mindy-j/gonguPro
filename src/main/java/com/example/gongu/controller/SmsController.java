package com.example.gongu.controller;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.service.SmsService;
import com.example.gongu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.DesktopPaneUI;
import java.util.Map;

@RestController
@RequestMapping("/sms/v1")
@RequiredArgsConstructor
@Log4j2
public class SmsController {
    private final SmsService smsService;
    private final UserService userService;


    @PostMapping("/send")
    public Mono<Map> sendMsg(@RequestBody Map<String, String> body, HttpServletRequest req) {
        String userPhone = body.get("userPhone");
        Map<String, Object> result = smsService.sendMessage(userPhone);
        String authNumber = (String) result.get("authNumber");
        req.getSession().setAttribute("authNumber", authNumber);
        Mono<Map> mono = (Mono<Map>) result.get("mono");

        return mono;
    }

    @PostMapping("/check")
    public String checkNumber(@RequestBody Map<String, String> body, HttpServletRequest req) {

        //HTTP요청 본문에서 "checkNumber"라는 키로 전달된 값을 가져옴
        String checkNumber = body.get("checkNumber");
        //세션에서 "authNumber"라는 속성을 가지와 문자열로 변환
        String authNumber = (String) req.getSession().getAttribute("authNumber");
        String userPhone = body.get("userPhone");

        if (authNumber != null && authNumber.equals(checkNumber)) {
            //만약 인증번호가 null이 아니고 사용자가 입력한 인증번호와 일치하는 경우
            String userId = userService.verifyPhoneNumber(userPhone);
            if (userId != null) {
                //인증번호가 일치하고 아이디를 찾은 경우
                return userId;
            } else {
                //인증번호는 일치하지만 아이디를 찾을 수 없는경우
                return "아이디를 찾을 수 없습니다.";
            }
        } else {
            //인증번호가 일치하지 않는경우
            return "인증번호가 일치하지 않습니다.";
        }
    }
    @PostMapping("/check-id-phone")
    public String checkIdPhone(@RequestBody Map<String,String> body, HttpServletRequest req){

        String checkNumber = body.get("checkNumber");
        String authNumber = (String) req.getSession().getAttribute("authNumber");
        String userId = body.get("userId");
        String userPhone = body.get("userPhone");

        log.info("checkNum : "+checkNumber);
        log.info("authNumber : "+authNumber);

        if (authNumber != null && authNumber.equals(checkNumber)) {
            String foundPassword = userService.verifyPhoneNumberPw(userId, userPhone);
            if(foundPassword !=null){
            //비밀번호를 찾은 경우
                return foundPassword;
            }else {
                //아이디와 휴대번호가 일치하지 않거나,
                //비번을 찾을 수 없는경우
                return "비밀번호를 찾을 수 없습니다.";
            }
            }else {
            return "인증번호가 일치하지 않습니다.";
        }
    }
}




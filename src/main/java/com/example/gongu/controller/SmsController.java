package com.example.gongu.controller;

import com.example.gongu.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.DesktopPaneUI;
import java.util.Map;

@RestController
@RequestMapping("/sms/v1")
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;


    @PostMapping("/send")
    public Mono<Map> sendMsg(@RequestBody Map<String,String> body, HttpServletRequest req){
        String userPhone = body.get("userPhone");
        Map<String, Object> result = smsService.sendMessage(userPhone);
        String authNumber = (String)result.get("authNumber");
        Mono<Map> mono = (Mono<Map>)result.get("mono");

        req.getSession().setAttribute("authNumber", authNumber);
        return mono;
    }

    @PostMapping("/check")
    public boolean checkNumber(@RequestBody String checkNumber, HttpServletRequest req){
        String authNumber = (String)req.getSession().getAttribute("authNumber");
        return authNumber.equals(checkNumber);
    }


}


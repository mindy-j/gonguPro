package com.example.gongu.controller;

import com.example.gongu.domain.dto.PaymentDto;
import com.example.gongu.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/process-payment") // * 안붙힌다
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("")
    public RedirectView processPayment(@RequestParam("buyer_name") String buyer_name,
                                       @RequestParam("merchant_uid") String merchantUid,
                                       @RequestParam("paid_amount") int paidAmount,
                                       HttpServletRequest req) {


        log.info("$$$$$$$$$$$$$$$$$$$"+buyer_name);
        log.info("$$$$$$$$$$$$$$$$$$$"+merchantUid);
        log.info("$$$$$$$$$$$$$$$$$$$"+paidAmount);
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentAmount(paidAmount);
        paymentDto.setPaymentMerchantUid(merchantUid);
        Long classNumber = Long.parseLong(buyer_name);
        paymentDto.setClassNumber(classNumber);
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        paymentDto.setUserNumber(userNumber);

        // 결제 정보를 서비스로 전달하여 데이터베이스에 저장
        paymentService.registerPay(paymentDto);
        return new RedirectView("/user/paymentBoard");
    }
}
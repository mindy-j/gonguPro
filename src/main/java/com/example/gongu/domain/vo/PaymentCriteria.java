package com.example.gongu.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PaymentCriteria {
    private int page;   // 현재 페이지
    private int amount; // 한 페이지 당 게시물 수

    private Long userNumber;


    public PaymentCriteria() {
        this.page = 1;
        this.amount = 9;
    }
}

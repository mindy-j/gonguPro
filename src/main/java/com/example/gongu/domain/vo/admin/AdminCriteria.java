package com.example.gongu.domain.vo.admin;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminCriteria {
    private int page;   // 현재 페이지
    private int amount; // 한 페이지 당 게시물 수

    String cate;
    String keyword;

    public AdminCriteria() {
        this.page = 1;
        this.amount = 20;
    }
}

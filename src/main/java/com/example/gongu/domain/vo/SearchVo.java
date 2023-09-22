package com.example.gongu.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
//@NoArgsConstructor
public class SearchVo {
    String cate;
    String keyword;

//    첫번째 방법
//    public SearchVo() {
//        this.cate = "";
//        this.keyword = "";
//    }
}

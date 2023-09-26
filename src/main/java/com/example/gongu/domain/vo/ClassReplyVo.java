package com.example.gongu.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class ClassReplyVo {
    private Long classReplyNumber;
    private String classReplyContent;
    private Date classReplyRegisterDate;
    private Date classReplyUpdateDate;
    private Long userNumber;
    private Long classNumber;
    private String userNickname;
}

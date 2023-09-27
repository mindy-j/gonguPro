package com.example.gongu.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class StudyReplyVo {
    private Long studyReplyNumber;
    private String studyReplyContent;
    private Date studyReplyRegisterDate;
    private Date studyReplyUpdateDate;
    private Long userNumber;
    private Long studyNumber;
    private String userNickname;

}

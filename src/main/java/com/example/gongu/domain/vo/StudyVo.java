package com.example.gongu.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class StudyVo {
    private Long studyNumber;
    private String studyTitle;
    private String studyProcess;
    private String studyStartDate; //시작날짜 Date => String 으로 변경 DB도 변경
    private String studyDate; //기간
    private String studyStudentCount; //모집인원 Long => String으로 변경 DB도 변경
    private String studyMajor;
    private String studyAddress;
    private String studyContent;
    private Long userNumber;
    private String  studyRegisterDate;
    private Date  studyUpdateDate;
    private String userId;
    private String userNickname;
    private int likeCount;
}

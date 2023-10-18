package com.example.gongu.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class ClassVo {
    private Long classNumber;
    private String classTitle;
    private String classStartDate;
    private String classEndDate;
    private String classProcess;
    private int classPrice;
    private String classAddress;
    private String classMajor;
    private String classIntroduce;
    private String classPlan;
    private String classRegisterDate;
    private String classLevel;
    private String classUpdateDate;
    private Long userNumber;
    private String userNickname;
    private String applyEducation; //학력
    private String userName; //유저 아이디
    private String userLevel; //유저 등급
}

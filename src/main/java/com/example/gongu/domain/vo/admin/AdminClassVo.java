package com.example.gongu.domain.vo.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Clob;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class AdminClassVo {
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

    private String userId; //유저 아이디
    private Long rnum; //

//    신청때 사용
    private String userName; // 유저이름
    private String userPhone; //유저 전화번호
    private String userBirth; //유저 생년월일
    private String userMajor;

    private String applyEducation; //학력
}

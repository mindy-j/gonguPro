package com.example.gongu.domain.vo.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class AminUserVo {
    private Long userNumber; //유저번호
    private String userId; //유저 아이디
    private String userPassword; // 유저 패스워드
    private String userName; // 유저이름
    private String userNickname; //유저 닉네임
    private String userEmail; //유저 이메일
    private String userPhone; //유저 전화번호
    private String userMajor; //관심분야?
    private String userBirth; //유저 생년월일
    private String userLevel; //유저 등급

    private Long rnum; //
}

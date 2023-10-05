package com.example.gongu.domain.vo.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminMentoApplyVo {
   private Long applyNumber;
   private String applyEducation; //학력
   private String applyCareer; //경력
   private String applyCerti; //자격증
   private Long userNumber;

   private String rnum;
   private String userId; //유저 아이디
   private String userName; // 유저이름
   private String userPhone; //유저 전화번호
   private String userBirth; //유저 생년월일
   private String userLevel; //유저 등급
   private String userMajor; //유저 전공
}

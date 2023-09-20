package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class ClassReplyDto {
   private Long classReplyNumber;
   private String classReplyContent;
   private Date classReplyRegisterDate;
   private Long userNumber;
   private Long classNumber;
}

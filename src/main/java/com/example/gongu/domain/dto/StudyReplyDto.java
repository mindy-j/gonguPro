package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class StudyReplyDto {
  private Long studyReplyNumber;
  private String studyReplyContent;
  private Date studyReplyRegisterDate;
  private Date studyReplyUpdateDate;
  private Long userNumber;
  private Long studyNumber;
}

package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MentoApplyDto {
   private Long applyNumber;
   private String applyEducation;
   private String applyCareer;
   private String applyCerti;
   private Long userNumber;
}

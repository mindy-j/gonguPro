package com.example.gongu.domain.vo.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminFileVo {
   private Long applyNumber;
//   private String applyEducation; //학력
//   private String applyCareer; //경력
//   private String applyCerti; //자격증

   private Long fileNumber;
   private String fileName;
   private String fileUploadPath;
   private String fileUuid;

}

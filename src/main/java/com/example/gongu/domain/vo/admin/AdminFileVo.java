package com.example.gongu.domain.vo.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminFileVo {
   private Long applyNumber;
   private Long fileNumber;
   private String fileName;
   private String fileUploadPath;
   private String fileUuid;

}

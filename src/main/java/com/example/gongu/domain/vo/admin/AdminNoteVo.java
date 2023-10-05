package com.example.gongu.domain.vo.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class AdminNoteVo {
   private Long noteNumber;
   private String noteTitle;
   private String noteContent;
   private String noteRegisterDate;
   private Long recieverNumber;
   private Long senderNumber;

   private String userId;
   private Long rnum;
}

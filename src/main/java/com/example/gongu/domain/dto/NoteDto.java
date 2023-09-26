package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class NoteDto {
   private Long noteNumber;
   private String noteTitle;
   private String noteContent;
   private Date noteRegisterDate;
   private Long recieverNumber;
   private Long senderNumber;
   private String noteLevel;
}

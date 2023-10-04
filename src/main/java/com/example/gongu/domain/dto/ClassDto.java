package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Clob;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class ClassDto {
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
   private Date classRegisterDate;
   private String classLevel;
   private Date classUpdateDate;
   private Long userNumber;
}

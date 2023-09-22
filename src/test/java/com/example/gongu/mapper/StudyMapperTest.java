package com.example.gongu.mapper;

import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.domain.vo.StudyVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudyMapperTest {

    @Autowired
    StudyMapper mapper;

    StudyDto dto;
    StudyVo vo;

    UserDto userDto;

    @BeforeEach
    void setUp(){
        dto = new StudyDto();
        dto.setStudyTitle("제목333");
        dto.setStudyMajor("카테고리");
        dto.setStudyAddress("서울시");
        dto.setStudyDate("4개월");
        dto.setStudyProcess("뭐시당까");
        dto.setStudyStartDate("2023-09-21");
        dto.setStudyStudentCount("4");
        dto.setStudyContent("내용");
        dto.setUserNumber(5L);
    }

    @Test
    void insert() {
        mapper.insert(dto);
    }

    @Test
    void selectList() {
        List<StudyVo> list =mapper.selectList();
      
    }


    @Test
    void select(){
       vo = mapper.select(28L);
       log.info(vo.toString());
    }


//    @Test
//    void update() {
//        dto.setStudyTitle("바뀐제"); // 얘 왜 안됨?
//        mapper.update(dto,25L);
//    }
}
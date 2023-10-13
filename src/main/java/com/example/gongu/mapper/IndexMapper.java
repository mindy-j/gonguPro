package com.example.gongu.mapper;

import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.StudyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexMapper {
//    인기
    List<StudyVo> selectLikeList();

//    스터디모집
    List<StudyVo> selectStudyList();

//    멘티모집
    List<ClassVo> selectClassList();
}

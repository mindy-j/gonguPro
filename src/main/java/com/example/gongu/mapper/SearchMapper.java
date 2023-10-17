package com.example.gongu.mapper;

import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
//    스터티검색
    List<StudyVo> selectStudy(Criteria criteria);
    int selectStudyTotal(String searchValue);

//    멘티모집검색
    List<ClassVo> selectClass(Criteria criteria);
    int selectClassTotal(String searchValue);
}

package com.example.gongu.mapper;

import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.StudyVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface StudyMapper {
    public void insert(StudyDto studyDto);

    public List<StudyVo> selectList();

    public StudyVo select(Long studyNumber);

    public void update(StudyDto studyDto);

    public void delete(Long studyNumber);



}

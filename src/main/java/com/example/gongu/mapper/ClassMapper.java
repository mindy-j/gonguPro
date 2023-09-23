package com.example.gongu.mapper;

import com.example.gongu.domain.dto.ClassDto;
import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.ClassVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    public void insert(ClassDto classDto);

    public List<ClassVo> selectList();
}

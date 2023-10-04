package com.example.gongu.mapper;

import com.example.gongu.domain.dto.ClassDto;
import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    public void insert(ClassDto classDto);

    public List<ClassVo> selectList(Criteria criteria);

    public ClassVo select(Long classNumber);

    public void update(ClassDto classDto);

    public void delete(Long classNumber);

    public int selectTotal();
}

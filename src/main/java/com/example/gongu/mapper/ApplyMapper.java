package com.example.gongu.mapper;

import com.example.gongu.domain.dto.MentoApplyDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper {
    public void insert(MentoApplyDto mentoApplyDto);
}

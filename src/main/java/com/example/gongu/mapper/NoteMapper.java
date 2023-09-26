package com.example.gongu.mapper;

import com.example.gongu.domain.vo.NoteVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {

    List<NoteVo> selectSendNote();
}

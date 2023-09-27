package com.example.gongu.mapper;

import com.example.gongu.domain.vo.NoteCriteria;
import com.example.gongu.domain.vo.NoteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoteMapper {

    List<NoteVo> selectSendAll(NoteCriteria noteCriteria);

    int selectSendTotal();
}

package com.example.gongu.mapper;

import com.example.gongu.domain.vo.NoteCriteria;
import com.example.gongu.domain.vo.NoteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoteMapper {

//    보낸쪽지함
    List<NoteVo> selectSendAll(NoteCriteria noteCriteria);

    int selectSendTotal(Long senderNumber);

    void updateSendLevel(Long senderNumber);

//    받은쪽지함
    List<NoteVo> selectReceiveAll(NoteCriteria noteCriteria);

    int selectReceiveTotal(Long recieverNumber);

    void updateReceiveLevel(Long recieverNumber);
}

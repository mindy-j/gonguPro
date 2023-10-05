package com.example.gongu.service;

import com.example.gongu.domain.vo.NoteCriteria;
import com.example.gongu.domain.vo.NoteVo;
import com.example.gongu.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteMapper noteMapper;

//    보낸쪽지함
    public List<NoteVo> findSendAll(NoteCriteria noteCriteria) {
        return noteMapper.selectSendAll(noteCriteria);
    }

    public int getSendTotal(Long senderNumber) {
        return noteMapper.selectSendTotal(senderNumber);
    }

    public void modifySendLevel(Long senderNumber) {
        noteMapper.updateSendLevel(senderNumber);
    }

//    받은쪽지함
    public List<NoteVo> findReceiveAll(NoteCriteria noteCriteria) {
        return noteMapper.selectReceiveAll(noteCriteria);
    }

    public int getReceiveTotal(Long recieverNumber) {
        return noteMapper.selectReceiveTotal(recieverNumber);
    }

    public void modifyReceiveLevel(Long recieverNumber) {
        noteMapper.updateReceiveLevel(recieverNumber);
    }
}

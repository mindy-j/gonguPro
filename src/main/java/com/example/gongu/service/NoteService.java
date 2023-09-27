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

    public List<NoteVo> findSendAll(NoteCriteria noteCriteria) {
        return noteMapper.selectSendAll(noteCriteria);
    }

    public int getSendTotal() {
        return noteMapper.selectSendTotal();
    }
}

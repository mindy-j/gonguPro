package com.example.gongu.service;

import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.mapper.IndexMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexService {
    private final IndexMapper indexMapper;

    //    인기
    public List<StudyVo> findLikeList() {
        return indexMapper.selectLikeList();
    }

    //    스터디모집
    public List<StudyVo> findStudyList() {
        return indexMapper.selectStudyList();
    }

    //    멘티모집
    public List<ClassVo> findClassList() {
        return indexMapper.selectClassList();
    }
}

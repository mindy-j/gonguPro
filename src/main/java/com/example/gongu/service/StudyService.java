package com.example.gongu.service;

import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyMapper studyMapper;

    public void register(StudyDto studyDto){
        studyMapper.insert(studyDto);
    }

    public List<StudyVo> findList(){
        List<StudyVo> findAll = studyMapper.selectList();
        return findAll;
    }

    public StudyVo find(Long studyNumber){
        StudyVo selectStudy = studyMapper.select(30L);
        return selectStudy;
    }

    public void modify(StudyDto studyDto){
        studyMapper.update(studyDto);
    }

    public void remove(Long studyNumber){
        studyMapper.delete(studyNumber);
    }

}


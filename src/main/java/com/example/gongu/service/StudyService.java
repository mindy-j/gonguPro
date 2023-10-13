package com.example.gongu.service;

import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.Criteria;
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

    public List<StudyVo> findList(Criteria criteria){
        List<StudyVo> findAll = studyMapper.selectList(criteria);
        return findAll;
    }

    public int getTotal(){
        return studyMapper.selectTotal();
    }

    public StudyVo find(Long studyNumber){
        StudyVo selectStudy = studyMapper.select(studyNumber);
        return selectStudy;
    }

    public void modify(StudyDto studyDto){
        studyMapper.update(studyDto);
    }

    public void remove(Long studyNumber){
        studyMapper.delete(studyNumber);
    }

    public List<StudyVo> myWriteList(Long userNumber,Criteria criteria){
        List<StudyVo> writeList = studyMapper.myWriteList(userNumber,criteria);
        return writeList;
    }

}


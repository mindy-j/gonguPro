package com.example.gongu.service;

import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchMapper searchMapper;

//    스터디검색
    public List<StudyVo> findStudy(Criteria criteria) {
        return searchMapper.selectStudy(criteria);
    }
    public int getStudyTotal(String searchValue) {
        return searchMapper.selectStudyTotal(searchValue);
    }

//    멘티모집검색
    public List<ClassVo> findClass(Criteria criteria) {
        return searchMapper.selectClass(criteria);
    }
    public int getClassTotal(String searchValue) {
        return searchMapper.selectClassTotal(searchValue);
    }
}

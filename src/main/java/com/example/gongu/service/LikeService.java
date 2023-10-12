package com.example.gongu.service;

import com.example.gongu.domain.dto.LikeDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikeService {
private final LikeMapper likeMapper;

    public void register(LikeDto likeDto){
        likeMapper.insert(likeDto);
    }

    public Long likeTotal(Long studyNumber, Long userNumber){
        Long total = likeMapper.likeTotal(studyNumber,userNumber);
        return total;
    }

    public List selectUser(){
       List<Long> userList = likeMapper.selectUser();
        return userList;
    }

    public void likeDown(Long userNumber){
        likeMapper.delete(userNumber);
    }

    public List<StudyVo> findList(Long userNumber, Criteria criteria){
        List<StudyVo> vo = likeMapper.selectList(userNumber,criteria);
        return vo;
    }

    public int getTotal(Long userNumber){
        return likeMapper.selectTotal(userNumber);
    }
}

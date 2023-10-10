package com.example.gongu.service;

import com.example.gongu.domain.dto.LikeDto;
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

    public Long likeTotal(Long studyNumber){
        Long total = likeMapper.likeTotal(studyNumber);
        return total;
    }

    public List selectUser(){
       List<Long> userList = likeMapper.selectUser();
        return userList;
    }

    public void likeDown(Long userNumber){
        likeMapper.delete(userNumber);
    }

    public StudyVo findList(Long userNumber){
        StudyVo vo = likeMapper.selectList(userNumber);
        return vo;
    }
}

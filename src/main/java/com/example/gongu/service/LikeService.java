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

//    public void register(LikeDto likeDto){
//        likeMapper.insert(likeDto);
//    }

//    추가
    public void regist(Long userNumber, Long studyNumber){likeMapper.insert(userNumber, studyNumber);}
    public void rmove(Long userNumber, Long studyNumber){likeMapper.del(userNumber,studyNumber);}
    public List<LikeDto> findLike(Long studyNumber){return likeMapper.seletLike(studyNumber);}
    public List<StudyVo> findLikeList(Long userNumber, Criteria criteria){
        return likeMapper.selectLikeList(userNumber, criteria);
    }
    public int getLikeTotal(Long userNumber){return likeMapper.selectLikeTotal(userNumber);}
//    여기까지
//    public Long likeTotal(Long studyNumber, Long userNumber){
//        Long total = likeMapper.likeTotal(studyNumber,userNumber);
//        return total;
//    }

//    public List selectUser(){
//       List<Long> userList = likeMapper.selectUser();
//        return userList;
//    }
//
//    public void likeDown(Long userNumber){
//        likeMapper.delete(userNumber);
//    }
//
//    public List<StudyVo> findList(Long userNumber, Criteria criteria){
//        List<StudyVo> vo = likeMapper.selectList(userNumber,criteria);
//        return vo;
//    }
//
//    public int getTotal(Long userNumber){
//        return likeMapper.selectTotal(userNumber);
//    }
}

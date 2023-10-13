package com.example.gongu.mapper;

import com.example.gongu.domain.dto.LikeDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeMapper {
//    public void insert(LikeDto likeDto);

//    추가
    public void insert(Long userNumber,Long studyNumber);
    public void del(Long userNumber, Long studyNumber);
    public List<LikeDto> seletLike(Long studyNumber);
    public List<StudyVo> selectLikeList(@Param("userNumber") Long userNumber,@Param("criteria") Criteria criteria);
    public int selectLikeTotal(Long userNumber);

//  여기까지
//    public Long likeTotal(Long studyNumber,Long userNumber);
//
//    public List selectUser();
//
//    public void delete(Long userNumber);
//
//    public List<StudyVo> selectList(@Param("userNumber") Long userNumber,@Param("criteria") Criteria criteria);
//
//    public int selectTotal(Long userNumber);
}



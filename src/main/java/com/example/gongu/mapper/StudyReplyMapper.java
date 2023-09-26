package com.example.gongu.mapper;

import com.example.gongu.domain.dto.StudyReplyDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyReplyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyReplyMapper {
    //    삽입
    public void insert(StudyReplyDto studyReplyDto);
    //    리스트 조회
    public List<StudyReplyVo> selectList(Long studyNumber);
    //    단건 조회
    public StudyReplyVo select(Long studyReplyNumber);
    //    수정
    public void update(StudyReplyDto studyReplyDto);
    //    삭제
    public void delete(Long studyReplyNumber);
    //    리스트 조회(페이징 처리)
    public List<StudyReplyVo> selectListPage(@Param("criteria") Criteria criteria, @Param("studyNumber") Long studyNumber);
    //    리플 수 조회
    public int selectTotal(Long studyNumber);
}

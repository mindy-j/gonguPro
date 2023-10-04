package com.example.gongu.mapper;

import com.example.gongu.domain.dto.ClassReplyDto;
import com.example.gongu.domain.dto.StudyReplyDto;
import com.example.gongu.domain.vo.ClassReplyVo;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyReplyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassReplyMapper {
    //    삽입
    public void insert(ClassReplyDto classReplyDto);
    //    리스트 조회
    public List<ClassReplyVo> selectList(Long classNumber);
    //    단건 조회
    public ClassReplyVo select(Long classReplyNumber);
    //    수정
    public void update(ClassReplyDto classReplyDto);
    //    삭제
    public void delete(Long classReplyNumber);
    //    리스트 조회(페이징 처리)
    public List<ClassReplyVo> selectListPage(@Param("criteria") Criteria criteria, @Param("classNumber") Long classNumber);
    //    리플 수 조회
    public int selectTotal(Long classNumber);

}

package com.example.gongu.service;

import com.example.gongu.domain.dto.StudyReplyDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyReplyVo;
import com.example.gongu.mapper.StudyReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyReplyService {
    private final StudyReplyMapper studyReplyMapper;

    //    삽입
    public void register(StudyReplyDto studyReplyDto){
        studyReplyMapper.insert(studyReplyDto);
    }

    //    리스트 조회
    public List<StudyReplyVo> findList(Long studyNumber){
        if (studyNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return studyReplyMapper.selectList(studyNumber);
    }
    //    단건 조회
    public StudyReplyVo find(Long studyReplyNumber){
        if (studyReplyNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락!!!");
        }
        return Optional.ofNullable(studyReplyMapper.select(studyReplyNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 댓글!!"); });
    }
    //    수정
    public void modify(StudyReplyDto studyReplyDto){
        studyReplyMapper.update(studyReplyDto);
    }
    //    삭제
    public void remove(Long studyReplyNumber){
        if (studyReplyNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락!!");
        }

        studyReplyMapper.delete(studyReplyNumber);
    }

    //    리스트 조회(페이징 처리)
    public List<StudyReplyVo> findListPage(Criteria criteria, Long studyNumber){
        if (studyNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!!");
        }

        return studyReplyMapper.selectListPage(criteria, studyNumber);
    }

    //    리플 수 조회
    public int getTotal(Long studyNumber){
        if (studyNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!!");
        }

        return studyReplyMapper.selectTotal(studyNumber);
    }
}

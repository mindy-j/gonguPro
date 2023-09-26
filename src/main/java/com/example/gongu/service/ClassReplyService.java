package com.example.gongu.service;

import com.example.gongu.domain.dto.ClassReplyDto;
import com.example.gongu.domain.dto.StudyReplyDto;
import com.example.gongu.domain.vo.ClassReplyVo;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.StudyReplyVo;
import com.example.gongu.mapper.ClassReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassReplyService {
    private final ClassReplyMapper classReplyMapper;

    //    삽입
    public void register(ClassReplyDto classReplyDto){
        classReplyMapper.insert(classReplyDto);
    }

    //    리스트 조회
    public List<ClassReplyVo> findList(Long classNumber){
        if (classNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!");
        }
        return classReplyMapper.selectList(classNumber);
    }
    //    단건 조회
    public ClassReplyVo find(Long classReplyNumber){
        if (classReplyNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락!!!");
        }
        return Optional.ofNullable(classReplyMapper.select(classReplyNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 댓글!!"); });
    }
    //    수정
    public void modify(ClassReplyDto classReplyDto){
        classReplyMapper.update(classReplyDto);
    }
    //    삭제
    public void remove(Long classReplyNumber){
        if (classReplyNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락!!");
        }

        classReplyMapper.delete(classReplyNumber);
    }

    //    리스트 조회(페이징 처리)
    public List<ClassReplyVo> findListPage(Criteria criteria, Long classNumber){
        if (classNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!!");
        }

        return classReplyMapper.selectListPage(criteria, classNumber);
    }

    //    리플 수 조회
    public int getTotal(Long classNumber){
        if (classNumber == null) {
            throw new IllegalArgumentException("게시물 번호 누락!!!");
        }

        return classReplyMapper.selectTotal(classNumber);
    }
}

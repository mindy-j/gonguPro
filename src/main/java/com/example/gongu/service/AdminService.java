package com.example.gongu.service;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.domain.vo.admin.*;
import com.example.gongu.domain.vo.SearchVo;
import com.example.gongu.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;

    //    관리자 로그인
    public Long findLogin(String userId, String userPassword) {
        return Optional.ofNullable(adminMapper.selectLogin(userId, userPassword))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("회원번호가 일치하지 않습니다");
                });
    }

    //일반 회원 리스트
    public List<AminUserVo> findUser(AdminCriteria adminCriteria) {
        return adminMapper.selectUser(adminCriteria);
    }

    //일반 회원 총인원
    public int getUserTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectUserTotal(adminCriteria);
    }

    //    멘토 유저 조회
    public List<AminUserVo> findMento(AdminCriteria adminCriteria) {
        return adminMapper.selectMento(adminCriteria);
    }

    //    멘토 유저 인원 조회
    public int getMentoTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectMentoTotal(adminCriteria);
    }

    //유저 삭제
    public void removeUser(Long userNumber) {
        adminMapper.deleteUser(userNumber);
    }

    ;

    //    스터디게시 조회
    public List<AdminStudyVo> findStudy(AdminCriteria adminCriteria) {
        return adminMapper.selectStudy(adminCriteria);
    }
    //    스터디게시수 조회
    public int getStudyTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectStudyTotal(adminCriteria);
    }
//    스터디 삭제
    public void removeStudy(Long studyNumber){
        adminMapper.deleteStudy(studyNumber);
    }



    //   수업게시 상세
    public AdminStudyVo findStudyDetail(Long studyNumber){
        return adminMapper.selectStudyDetail(studyNumber);
    }

    //    수업게시 조회
    public List<AdminClassVo> findClass(AdminCriteria adminCriteria) {
        return adminMapper.selectClass(adminCriteria);
    }
    //    수업게시수 조회
    public int getClassTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectClassTotal(adminCriteria);
    }
//    수업 상세게시
    public AdminClassVo findClassDetail(Long classNumber){return adminMapper.selectClassDetail(classNumber);}




//    멘토신청 조회
    public List<AdminMentoApplyVo> findMentoApply(AdminCriteria adminCriteria) {
        return adminMapper.selectMentoApply(adminCriteria);
    }
//    멘토신청 상세
    public AdminMentoApplyVo findMentoApplyDetail(Long applyNumber){
        return adminMapper.selectMentoApplyDetail(applyNumber);
    }
//    멘토신청수 조회
    public int getMentoApplyTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectMentoApplyTotal(adminCriteria);
    }
//    멘토승인
    public void modifyMento(Long applyNumber){
        adminMapper.updateMento(applyNumber);
    }
//    멘토 거절
    public void removeMento(Long applyNumber){
        adminMapper.deleteMento(applyNumber);
    }



    //    수업신청 조회
    public List<AdminClassVo> findClassApply(AdminCriteria adminCriteria) {
        return adminMapper.selectClassApply(adminCriteria);
    }
    //    수업신청수 조회
    public int getClassApplyTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectClassApplyTotal(adminCriteria);
    }
    //    수업승인
    public void modifyClass(Long classNumber){
        adminMapper.updateClass(classNumber);
    }
    //    수업 거절
    public void removeClass(Long classNumber){
        adminMapper.deleteClass(classNumber);
    }

//    =============
//    쪽지보내기
    public void registerNote(AdminNoteVo adminNoteVo){
        adminMapper.insertNote(adminNoteVo);
    }
//    보낸쪽지
    public List<AdminNoteVo> findSender(AdminCriteria adminCriteria){
        return adminMapper.selectSender(adminCriteria);
    }
//    보낸쪽지수
    public int getSendNotTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectSendNoteTotal(adminCriteria);
    }
//   보낸쪽지 상세
    public AdminNoteVo findSend(Long noteNumber){
        return adminMapper.selectSend(noteNumber);
    }


    //    받은 쪽지
    public List<AdminNoteVo> findReceived(AdminCriteria adminCriteria){
        return adminMapper.selectReceived(adminCriteria);
    }
    //    받은 쪽지수
    public int getReceivedTotal(AdminCriteria adminCriteria) {
        return adminMapper.selectReceivedTotal(adminCriteria);
    }
    //   받은 쪽지 상세
    public AdminNoteVo findRece(Long noteNumber){
        return adminMapper.selectRece(noteNumber);
    }
}

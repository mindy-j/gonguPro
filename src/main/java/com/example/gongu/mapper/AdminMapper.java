package com.example.gongu.mapper;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.domain.vo.admin.*;
import com.example.gongu.domain.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
//    관리자 로그인
    public Long selectLogin(@Param("userId") String userId, @Param("userPassword") String userPassword);
//    일반 유저 조회
    public List<AminUserVo> selectUser(AdminCriteria adminCriteria);
//    일반 유저 인원 조회
    public int selectUserTotal(AdminCriteria adminCriteria);
//    멘토 유저 조회
    public List<AminUserVo> selectMento(AdminCriteria adminCriteria);
//    멘토 유저 인원 조회
    public int selectMentoTotal(AdminCriteria adminCriteria);

    //유저 삭제
    public void deleteUser(Long userNumber);

//    스터디게시 조회
    public List<AdminStudyVo> selectStudy(AdminCriteria adminCriteria);
//    스터디게시수 조회
    public int selectStudyTotal(AdminCriteria adminCriteria);
//    스터디게시 삭제
    public void deleteStudy(Long studyNumber);


//    스터디 상세
    public AdminStudyVo selectStudyDetail(Long studyNumber);

    //    수업게시 조회
    public List<AdminClassVo> selectClass(AdminCriteria adminCriteria);
    //    수업게시수 조회
    public int selectClassTotal(AdminCriteria adminCriteria);
//    수업 상세 게시
    public AdminClassVo selectClassDetail(Long classNumber);

//    멘토신청 조회
    public List<AdminMentoApplyVo> selectMentoApply(AdminCriteria adminCriteria);
    //    멘토신청 상세
    public AdminMentoApplyVo selectMentoApplyDetail(Long applyNumber);
//        멘토신청수 조회
    public int selectMentoApplyTotal(AdminCriteria adminCriteria);
//    멘토승인
    public void updateMento(Long applyNumber);
//    멘토거부
    public void deleteMento(Long applyNumber);


    //    수업신청 조회
    public List<AdminClassVo> selectClassApply(AdminCriteria adminCriteria);
    //        수업신청수 조회
    public int selectClassApplyTotal(AdminCriteria adminCriteria);
    //    수업승인
    public void updateClass(Long classNumber);
    //    수업거부
    public void deleteClass(Long classNumber);

//    ==========
//    쪽지 보내기
    public void insertNote(AdminNoteVo adminNoteVo);
//    보낸 쪽지함
    public List<AdminNoteVo> selectSender(@Param("senderNumber") Long senderNumber,
                                          @Param("adminCriteria") AdminCriteria adminCriteria);
//    보낸 쪽지수
    public int selectSendNoteTotal(@Param("senderNumber") Long senderNumber,
                                   @Param("adminCriteria") AdminCriteria adminCriteria);
//    보낸 쪽지상세
    public AdminNoteVo selectSend(Long noteNumber);
//    보낸 쪽지 레벨 수정
    public void updateSend(Long noteNumber);


    //    받은 쪽지함
    public List<AdminNoteVo> selectReceived(@Param("recieverNumber") Long recieverNumber, @Param("adminCriteria") AdminCriteria adminCriteria);
    //    받은 쪽지수
    public int selectReceivedTotal(@Param("recieverNumber") Long recieverNumber, @Param("adminCriteria") AdminCriteria adminCriteria);
    //    받은 쪽지상세
    public AdminNoteVo selectRece(Long noteNumber);
//    받은 쪽지 레벨 수정
    public void updateReceive(Long noteNumber);


//    이미지 불러오기
    public List<AdminFileVo> selectFile(Long applyNumber);
}

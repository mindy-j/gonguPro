package com.example.gongu.mapper;

import com.example.gongu.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.swing.plaf.PanelUI;


@Mapper
public interface UserMapper {


    // 회원가입 아이디 중복검사
    public int idCheck(String userId) throws Exception;

    //회원 삽입 : 회원가입할때 쓰임
    public void insert(UserDto userDto);

    //조회 : 로그인할때 쓰임
    public UserDto select(@Param("userId")String userId, @Param("userPassword")String userPassword);

    //회원정보 업데이트 : 정보 수정시 사용
    public void update(UserDto userDto);

    //번호로 아이디 찾기
    public String verifyPhoneNumber(String userPhone);

    //아이디와 번호로 비밀번호 찾기
    public String verifyPhoneNumberPw(String userId, String userPhone);


    //아이디로 회원 삭제
    public void deleteId(String userId);


}

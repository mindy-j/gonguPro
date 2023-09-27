package com.example.gongu.service;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserMapper userMapper;


    //아이디 중복검사 : 성공
    public int idCheck(String userId) throws Exception{
        return userMapper.idCheck(userId);
    }


    //등록
    public void register(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("회원정보가 누락되었습니다");
        }

        userMapper.insert(userDto);
        //log.info("가입완료오오오오오오오******************");

    }

    //아이디 비밀번호 로그인 : 성공
    public UserDto find(String userId, String userPassword){
        return Optional.ofNullable(userMapper.select(userId, userPassword))
                .orElseThrow(()->{throw new IllegalArgumentException("조회결과 없음");
                });
    }


    //회원정보수정
    public void modify(UserDto userDto) {
        userMapper.update(userDto);
    }


    //아이디로 회원 삭제
    public void remove(String userId) {
        userMapper.deleteId(userId);
    }


    //번호로 아이디 찾기
    public String verifyPhoneNumber(String userPhone){
        String user = userMapper.verifyPhoneNumber(userPhone);
        if(user != null && !user.isEmpty()){
            return "번호 일치";
        }else {
            return "번호 불일치";
        }
    }
}


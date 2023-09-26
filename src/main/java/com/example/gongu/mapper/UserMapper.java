package com.example.gongu.mapper;

import com.example.gongu.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {


    //삽입
    public void insert(UserDto userDto);

    //중복검사
    public String idCheck(String userId);


    //로그인
    public UserDto select(@Param("userId") String userId, @Param("userPassword")String userPassword);



}

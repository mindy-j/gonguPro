package com.example.gongu.mapper;

import com.example.gongu.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    UserDto userDto;

    @BeforeEach
    void setUp() {
    userDto = new UserDto();
    userDto.setUserId("GGG");
    userDto.setUserPassword("5858");
    userDto.setUserName("홍홍옹");
    userDto.setUserNickname("hoho");
    userDto.setUserEmail("ggg@naver.com");
    userDto.setUserPhone("010-8975-4747");
    userDto.setUserMajor("영어");
    userDto.setUserBirth("1995-08-05");
    userDto.setUserLevel("1");


    }

    @Test
    void idCheck() {
        String id = "GGG";
        String id2 ="sds";
        userMapper.idCheck(id);
        userMapper.idCheck(id2);
    }

    @Test
    void insert() {
        userMapper.insert(userDto);
    }
}
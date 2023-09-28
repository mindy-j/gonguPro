package com.example.gongu.mapper;

import com.example.gongu.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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
        userDto.setUserId("DDD");
        userDto.setUserPassword("1531");
        userDto.setUserName("이인");
        userDto.setUserNickname("intl");
        userDto.setUserEmail("DDD@naver.com");
        userDto.setUserPhone("010-4584-4452");
        userDto.setUserMajor("수학");
        userDto.setUserBirth("1995-11-09");
        userDto.setUserLevel("1");
    }

//    @Test
//    public void userIdChk(){
//        String id = "AAA";
//        String id2 = "sdgsdg";
//        userMapper.idCheck(id);
//        userMapper.idCheck(id2);
//    }


    @Test
    void insert() {
        userMapper.insert(userDto);
    }

    @Test
    void update() {
        userDto.setUserId("DDD");
        userDto.setUserPassword("1531");
        userDto.setUserNickname("인텔리하지");
        userDto.setUserEmail("ddd@naver.com");
        userDto.setUserPhone("010-1245-9875");
        userDto.setUserMajor("생명과학");

        userMapper.update(userDto);

    }

    @Test
    void deleteId() {
        userMapper.deleteId("DDD");
    }




}
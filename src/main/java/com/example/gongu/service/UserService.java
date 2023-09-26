package com.example.gongu.service;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public String idCheck(String userId){
        return userMapper.idCheck(userId);
    }

    public UserDto find(String userId, String userPassword){
       return Optional.ofNullable(userMapper.select(userId, userPassword))
        .orElseThrow(()->{throw new IllegalArgumentException("조회 결과 없음");
        });
    }



}

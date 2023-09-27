package com.example.gongu.service;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.domain.vo.SearchVo;
import com.example.gongu.mapper.AdminMapper;
import com.example.gongu.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;

    public Long findLogin(String userId, String userPassword){
        return Optional.ofNullable( adminMapper.selectLogin(userId, userPassword))
                .orElseThrow(()-> {
                    throw new IllegalArgumentException("회원번호가 일치하지 않습니다");
                });
    }
    public List<UserDto> findUser(SearchVo searchVo){
        return adminMapper.selectUser(searchVo);
    }
    public List<UserDto> findMento(SearchVo searchVo){
        return adminMapper.selectMento(searchVo);
    }

}

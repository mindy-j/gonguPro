package com.example.gongu.mapper;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.domain.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    public Long selectLogin(@Param("userId") String userId, @Param("userPassword") String userPassword);

    public List<UserDto> selectUser(@Param("searchVo") SearchVo searchVo, @Param("criteria") Criteria criteria);
    public List<UserDto> selectMento(SearchVo searchVo);
}

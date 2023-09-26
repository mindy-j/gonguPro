package com.example.gongu.mapper;

import com.example.gongu.domain.dto.FileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    //    삽입
    public void insert(FileDto fileDto);
    //    삭제
    public void delete(Long applyNumber);
    //    파일 리스트 조회
    public List<FileDto> selectList(Long applyNumber);
}

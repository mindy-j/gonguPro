package com.example.gongu.service;

import com.example.gongu.domain.dto.ClassDto;
import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.mapper.ClassMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassService {
    private final ClassMapper classMapper;

    public void register(ClassDto classDto){
        classMapper.insert(classDto);
        log.info(classDto.toString());
    }

    public List<ClassVo> findAll(Criteria criteria){
        List<ClassVo> findList = classMapper.selectList(criteria);
        return findList;
    }

    public ClassVo find(Long classNumber){
        ClassVo findOne = classMapper.select(classNumber);
        return findOne;
    }

    public void modify(ClassDto classDto){
        classMapper.update(classDto);
    }

    public void remove(Long classNumber){
        classMapper.delete(classNumber);
    }

    public int getTotal(){
        return classMapper.selectTotal();
    }

    public List<String> testImg(){
        List<String> list = new ArrayList<>();
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher025.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher026.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher075.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher009.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher010.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher011.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher012.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher013.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher014.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher015.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher016.png");
        list.add("http://코리아정보보안it.com/renewal2021/img/tch/teacher017.png");
        return list;
    }
}

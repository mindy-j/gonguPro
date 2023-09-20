package com.example.gongu.service;

import com.example.gongu.mapper.ClassMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassMapper classMapper;
}

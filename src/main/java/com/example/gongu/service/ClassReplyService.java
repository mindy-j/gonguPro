package com.example.gongu.service;

import com.example.gongu.mapper.ClassReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassReplyService {
    private final ClassReplyMapper classReplyMapper;
}

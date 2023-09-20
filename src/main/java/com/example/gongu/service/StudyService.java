package com.example.gongu.service;

import com.example.gongu.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyMapper studyMapper;

}


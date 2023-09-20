package com.example.gongu.service;

import com.example.gongu.mapper.StudyReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyReplyService {
    private final StudyReplyMapper studyReplyMapper;
}

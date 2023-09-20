package com.example.gongu.controller;

import com.example.gongu.service.StudyReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/studyReply/*")
public class StudyReplyController {
    private final StudyReplyService studyReplyService;
}

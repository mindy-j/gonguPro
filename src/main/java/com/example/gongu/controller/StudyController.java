package com.example.gongu.controller;

import com.example.gongu.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/study/*")
public class StudyController {
    private final StudyService studyService;
}

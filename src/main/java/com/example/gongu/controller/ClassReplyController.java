package com.example.gongu.controller;

import com.example.gongu.service.ClassReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classReply/*")
public class ClassReplyController {
    private final ClassReplyService classReplyService;
}

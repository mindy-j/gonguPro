package com.example.gongu.controller;

import com.example.gongu.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note/*")
public class NoteController {
    private final NoteService noteService;
}

package com.example.gongu.controller;

import com.example.gongu.domain.vo.NoteCriteria;
import com.example.gongu.domain.vo.NotePageVo;
import com.example.gongu.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note/*")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/sendList")
    public String showSendListPage(NoteCriteria noteCriteria, Model model) {
        model.addAttribute("sendNote", noteService.findSendAll(noteCriteria));
        model.addAttribute("pageInfo", new NotePageVo(noteService.getSendTotal(), noteCriteria));
        return "note/sendNote";
    }
}

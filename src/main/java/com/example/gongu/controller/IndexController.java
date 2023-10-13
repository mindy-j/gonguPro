package com.example.gongu.controller;

import com.example.gongu.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index/*")
public class IndexController {
    private final IndexService indexService;

    @GetMapping("/main")
    public String indexList(Model model) {
        model.addAttribute("indexLikeList", indexService.findLikeList());
        model.addAttribute("indexStudyList", indexService.findStudyList());
        model.addAttribute("indexClassList", indexService.findClassList());
        return "index";
    }
}

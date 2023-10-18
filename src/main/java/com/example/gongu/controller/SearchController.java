package com.example.gongu.controller;

import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.PageVo;
import com.example.gongu.domain.vo.SearchVo;
import com.example.gongu.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search/*")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/study")
    public String searchStudy(Criteria criteria, Model model) {
        model.addAttribute("studyList", searchService.findStudy(criteria));
        model.addAttribute("pageInfo", new PageVo(searchService.getStudyTotal(criteria.getSearchValue()), criteria));
        return "studyBoard/studyList";
    }

    @GetMapping("/class")
    public String searchClass(Criteria criteria, Model model) {
        model.addAttribute("classList", searchService.findClass(criteria));
        model.addAttribute("pageInfo", new PageVo(searchService.getClassTotal(criteria.getSearchValue()), criteria));
        return "classBoard/mentiBoardList";
    }
}

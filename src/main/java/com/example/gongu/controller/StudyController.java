package com.example.gongu.controller;

import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/study/*")
public class StudyController {
    private final StudyService studyService;

    @GetMapping("/list")
    public String showListPage(Model model){
        model.addAttribute("studyList",studyService.findList());
        return "studyBoard/studyList";
    }

    @GetMapping("/write")
    public String writePage(){
        return "studyBoard/studywrite";
    }

    @PostMapping("/writeOk")
    public RedirectView writeOk(StudyDto studyDto){
        studyService.register(studyDto);
        return new RedirectView("/study/list");
    }

    @GetMapping("/detail")
    public String detailPage(Long boardNumber,Model model){
        StudyVo studyVo =studyService.find(30L);
        model.addAttribute("study",studyVo);
        return "studyBoard/studyDetail";
    }

    @GetMapping("/update")
    public String updatePage(Long boardNumber,Model model){
        StudyVo studyVo = studyService.find(30L);
        model.addAttribute("study",studyVo);
        return "studyBoard/studyUpdate";
    }

    @PostMapping("/update")
    public RedirectView updateOk(RedirectAttributes redirectAttributes, StudyDto studyDto){
        studyService.modify(studyDto);
        redirectAttributes.addAttribute("studyNumber",studyDto.getStudyNumber());
        return new RedirectView("/study/detail");
    }
    @GetMapping("/remove")
    public RedirectView remove(Long studyNumber){
        studyService.remove(studyNumber);
        return new RedirectView("/study/list");
    }

}

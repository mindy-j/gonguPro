package com.example.gongu.controller;

import com.example.gongu.domain.dto.ClassDto;
import com.example.gongu.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/class/*")
public class ClassController {
    private final ClassService classService;

    @GetMapping("/list")
    public String listPage(Model model){
        model.addAttribute("classList",classService.findAll());
        return "classBoard/mentiBoardList";
    }



    @GetMapping("write")
    public String writePage(){
        return "classBoard/mentorStudyPlan";
    }

    @PostMapping("/writeOk")
    public RedirectView writeOkPage(ClassDto classDto){
        classService.register(classDto);
        return new RedirectView("/class/list");
    }


}

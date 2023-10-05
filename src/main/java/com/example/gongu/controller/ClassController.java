package com.example.gongu.controller;

import com.example.gongu.domain.dto.ClassDto;
import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.ClassVo;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.PageVo;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/class/*")
public class ClassController {
    private final ClassService classService;

    @GetMapping("/list")
    public String listPage(Criteria criteria,Model model){
        model.addAttribute("classList",classService.findAll(criteria));
        model.addAttribute("pageInfo",new PageVo(classService.getTotal(),criteria));
        return "classBoard/mentiBoardList";
    }



    @GetMapping("write")
    public String writePage(){
        return "classBoard/mentorStudyPlan";
    }

    @PostMapping("/writeOk")
    public RedirectView writeOkPage(ClassDto classDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        classDto.setUserNumber(userNumber);
        classService.register(classDto);
        return new RedirectView("/class/list");
    }

    @GetMapping("/detail")
    public String detailPage(Long classNumber,Model model){
        model.addAttribute("class",classService.find(classNumber));
        return "classBoard/mentiBoardDetail";
    }

    @GetMapping("/update")
    public String updatePage(Long classNumber, Model model){
        ClassVo classVo = classService.find(classNumber);
        model.addAttribute("class",classVo);
        return "classBoard/studyPlanModify";
    }
    @PostMapping("/update")
    public RedirectView updateOk(RedirectAttributes redirectAttributes, ClassDto classDto){
        classService.modify(classDto);
        redirectAttributes.addAttribute("classNumber",classDto.getClassNumber());
        return new RedirectView("/class/detail");
    }

    @GetMapping("/delete")
    public RedirectView deleteOk(Long classNumber){
        classService.remove(classNumber);
        return new RedirectView("/class/list");
    }



}

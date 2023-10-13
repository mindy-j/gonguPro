package com.example.gongu.controller;

import com.example.gongu.domain.dto.LikeDto;
import com.example.gongu.domain.dto.StudyDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.PageVo;
import com.example.gongu.domain.vo.StudyVo;
import com.example.gongu.service.LikeService;
import com.example.gongu.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/study/*")
@Slf4j
public class StudyController {
    private final StudyService studyService;

    private final LikeService likeService;

    private Long likeStudyNum;
    @GetMapping("/list")
    public String showListPage(Criteria criteria,Model model, HttpServletRequest req){
        model.addAttribute("session",req.getSession().getAttribute("userNumber"));
        model.addAttribute("studyList",studyService.findList(criteria));
        model.addAttribute("pageInfo", new PageVo(studyService.getTotal(),criteria));
        return "studyBoard/studyList";
    }

    @GetMapping("/myWriteList")
    public String showMyWriteList(HttpServletRequest req,Criteria criteria,Model model){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        model.addAttribute("writeList", studyService.myWriteList(userNumber,criteria));
        model.addAttribute("pageInfo", new PageVo(studyService.getTotal(),criteria));
        return "user/writeList";
    }

    @GetMapping("/write")
    public String writePage(){
        return "studyBoard/studywrite";
    }

    @PostMapping("/writeOk")
    public RedirectView writeOk(StudyDto studyDto,HttpServletRequest req){
        studyDto.setUserNumber((Long)req.getSession().getAttribute("userNumber"));
        studyService.register(studyDto);
        return new RedirectView("/study/list");
    }

    @GetMapping("/detail")
    public String detailPage(Long studyNumber,Model model){
//        likeStudyNum = studyNumber;
        StudyVo studyVo =studyService.find(studyNumber);

        model.addAttribute("selectUser",likeService.selectUser());
        model.addAttribute("study",studyVo);
        return "studyBoard/studyDetail";
    }

    @GetMapping("/down")
    public String likeDown(HttpServletRequest req,LikeDto likeDto,@RequestParam("studyNumber") String studyNumber, Model model){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        likeDto.setUserNumber(userNumber);

        StudyVo studyVo =studyService.find(Long.parseLong(studyNumber));
        Long likeCount = likeService.likeTotal(Long.parseLong(studyNumber),userNumber);
        model.addAttribute("loginUser",(Long)req.getSession().getAttribute("userNumber"));
        model.addAttribute("selectUser",likeService.selectUser());
        model.addAttribute("likeCount",likeCount);
        model.addAttribute("study",studyVo);
        likeService.likeDown(userNumber);
        return "studyBoard/studyDetail";
    }


    @GetMapping("/update")
    public String updatePage(Long studyNumber,Model model){
        StudyVo studyVo = studyService.find(studyNumber);
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

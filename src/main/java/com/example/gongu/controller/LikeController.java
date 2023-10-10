package com.example.gongu.controller;

import com.example.gongu.domain.dto.LikeDto;
import com.example.gongu.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/like/*")
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/up")
    public RedirectView likeUp(HttpServletRequest req, LikeDto likeDto){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        likeDto.setUserNumber(userNumber);

        likeService.register(likeDto);
        return new RedirectView("/study/list");
    }

    @GetMapping("/list")
    public String likeList(Long userNumber, Model model){
        model.addAttribute("likeList",likeService.findList(userNumber));
        return "user/favoriteBoard";
    }
}

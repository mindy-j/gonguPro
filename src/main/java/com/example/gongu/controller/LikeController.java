package com.example.gongu.controller;

import com.example.gongu.domain.dto.LikeDto;
import com.example.gongu.domain.vo.Criteria;
import com.example.gongu.domain.vo.PageVo;
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


//    @GetMapping("/list")
//    public String likeList(HttpServletRequest req,Long userNumber, Model model,Criteria criteria){
//        model.addAttribute("likeList",likeService.findList((Long)req.getSession().getAttribute("userNumber"),criteria));
//        model.addAttribute("pageInfo", new PageVo(likeService.getTotal((Long)req.getSession().getAttribute("userNumber")),criteria));
//        return "user/favoriteBoard";
//    }
    @GetMapping("/list")
    public String likeList(HttpServletRequest req, Model model, Criteria criteria){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        model.addAttribute("likeList",likeService.findLikeList(userNumber, criteria));
        model.addAttribute("pageInfo", new PageVo(likeService.getLikeTotal(userNumber), criteria));
        return "user/favoriteBoard";
    }


}

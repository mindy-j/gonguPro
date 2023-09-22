package com.example.gongu.controller;

import com.example.gongu.domain.vo.SearchVo;
import com.example.gongu.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping("/login")
    public String adminLogin(){
        return "/admin/adminLogin";
    }
    @PostMapping("/login")
    public RedirectView adminLogin(String userId, String userPassword, HttpServletRequest req){
        Long adminNumber = adminService.findLogin(userId, userPassword);
        req.getSession().setAttribute("adminNumber",  adminNumber);
        return new RedirectView("/admin/main");
    }
// =====헤더 부분 매핑=========
    @GetMapping("/main")
    public String adminMain(Model model, SearchVo searchVo, Criteria criteria){
        model.addAttribute("userList", adminService.findUser(searchVo, criteria));
        return "/admin/adminMain";
    }
    @GetMapping("/board")
    public String adminBoard(){return "/admin/adminStudy";}
    @GetMapping("/application")
    public String adminApplication(){return "/admin/adminMentoApplication";}
    @GetMapping("/note")
    public String adminNote(){return "/admin/adminNote";}
    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "/admin/adminLogin";
    }
//    ======헤더부분 매핑 끝=======
//    ======사이드부분 매핑========
    @GetMapping("/mento")
    public String mento(Model model, SearchVo searchVo){
        model.addAttribute("mentoList", adminService.findMento(searchVo));
        return "/admin/adminMento";}
    @GetMapping("/classPlan")
    public String classPlan(){return "/admin/adminClassPlan";}
    @GetMapping("/classApplication")
    public String classApplication(){return "/admin/adminClassApplication";}
    @GetMapping("/sendNote")
    public String sendNote(){return "/admin/adminSendNote";}
    @GetMapping("/receivedNote")
    public String receviedNote(){return "/admin/adminReceivedNote";}


}

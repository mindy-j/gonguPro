package com.example.gongu.controller;

import com.example.gongu.domain.vo.admin.*;
import com.example.gongu.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
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
        if (adminNumber != null) {
            // 로그인 성공
            req.getSession().setAttribute("adminNumber", adminNumber);
            return new RedirectView("/admin/main");
        } else {
            // 로그인 실패
            return new RedirectView("/admin/login?loginError");
        }
    }


// =====헤더 부분 매핑=========
    @GetMapping("/main")
    public String adminMain(Model model, AdminCriteria adminCriteria){
        model.addAttribute("userList", adminService.findUser(adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getUserTotal(adminCriteria), adminCriteria));
        return "/admin/adminMain";
    }

    @GetMapping("/board")
    public String adminBoard(Model model, AdminCriteria adminCriteria){
        model.addAttribute("studyList", adminService.findStudy(adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getStudyTotal(adminCriteria), adminCriteria));
        return "admin/adminStudy";}
//    스터디 상세
    @GetMapping("/studyDetail")
    public String studyDetail(Long studyNumber, AdminCriteria adminCriteria,Model model){
        AdminStudyVo adminStudyVo = adminService.findStudyDetail(studyNumber);
        model.addAttribute("study", adminStudyVo);
        return "admin/adminStudyDetail";
    }
    //    스터디 삭제
    @GetMapping("/removeStudy")
    public RedirectView removeStudy(Long studyNumber){
        adminService.removeStudy(studyNumber);
        return new RedirectView("/admin/board");
    }



    @GetMapping("/application")
    public String adminApplication(Model model, AdminCriteria adminCriteria){
        model.addAttribute("mentoList", adminService.findMentoApply(adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getMentoApplyTotal(adminCriteria), adminCriteria));
        return "/admin/adminMentoApplication";}

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "/admin/adminLogin";
    }
//    ======헤더부분 매핑 끝=======
//    ======사이드부분 매핑========
    @GetMapping("/mento")
    public String adminMento(Model model, AdminCriteria adminCriteria){
        model.addAttribute("userList", adminService.findMento(adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getMentoTotal(adminCriteria), adminCriteria));
        return "/admin/adminMento";
    }
    @GetMapping("/classPlan")
    public String classPlan(Model model, AdminCriteria adminCriteria){
        model.addAttribute("classList", adminService.findClass(adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getClassTotal(adminCriteria), adminCriteria));
        return "/admin/adminClassPlan";}
//    수업상세
    @GetMapping("/classDetail")
    public String classDetail(Long classNumber, AdminCriteria adminCriteria,Model model){
        AdminClassVo adminClassVo = adminService.findClassDetail(classNumber);
        model.addAttribute("class", adminClassVo);
        return "/admin/adminClassPlanDetail";
    }

    @GetMapping("/classApplication")
    public String classApplication(Model model, AdminCriteria adminCriteria){
        model.addAttribute("classList", adminService.findClassApply(adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getClassApplyTotal(adminCriteria), adminCriteria));
        return "/admin/adminClassApplication";}



//    승인 거절 삭제============================================================
//   유저 삭제
    @GetMapping("/removeUser")
    public RedirectView removeUser(Long userNumber){
    adminService.removeUser(userNumber);
    return new RedirectView("/admin/main");
    }
//    멘토 승인
    @GetMapping("/approvalMento")
    public RedirectView modifyMento(Long applyNumber){
        adminService.modifyMento(applyNumber);
        return new RedirectView("/admin/application");
    }
//    멘토 거절
    @GetMapping("/refusalMento")
    public RedirectView removeMento(Long applyNumber){
        adminService.removeMento(applyNumber);
        return new RedirectView("/admin/application");
    }
    //    수업 승인
    @GetMapping("/approvalClass")
    public RedirectView modifyClass(Long classNumber){
        adminService.modifyClass(classNumber);
        return new RedirectView("/admin/classApplication");
    }
    //    수업 거절
    @GetMapping("/refusalClass")
    public RedirectView refusalClass(Long classNumber){
        adminService.removeClass(classNumber);
        return new RedirectView("/admin/classApplication");
    }
//    수업 삭제
    @GetMapping("/removeClass")
    public RedirectView removeClass(Long classNumber){
        adminService.removeClass(classNumber);
        return new RedirectView("/admin/classPlan");
    }

//    =============
//    쪽지보내기
@GetMapping("/note")
public String adminNote(){return "/admin/adminNote";}
    @GetMapping("/noteWrite")
    public RedirectView noteWrite(AdminNoteVo adminNoteVo, HttpServletRequest req){
        Long adminNumber = (Long)req.getSession().getAttribute("adminNumber");
        adminNoteVo.setSenderNumber(adminNumber);
        adminService.registerNote(adminNoteVo);

        return new RedirectView("/admin/note");
    }
//    보낸쪽지
    @GetMapping("/sendNote")
    public String senderNote(AdminCriteria adminCriteria, Model model, HttpServletRequest req){
        Long senderNumber = (Long)req.getSession().getAttribute("adminNumber");
        model.addAttribute("senderList", adminService.findSender(senderNumber, adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getSendNotTotal(senderNumber, adminCriteria), adminCriteria));
        return "admin/adminSendNote";
    }
    @GetMapping("/sendNoteDetail")
    public String sendNoteDetail(Long noteNumber,Model model){
        AdminNoteVo adminNoteVo = adminService.findSend(noteNumber);
        model.addAttribute("send", adminNoteVo);
        return "admin/adminSendNoteDetail";
    }
    @GetMapping("/sendNoteModify")
    public RedirectView sendNoteModify(Long noteNumber){
        adminService.modifySend(noteNumber);
        return new RedirectView("/admin/sendNote");
    }
    @GetMapping("/receiveNoteModify")
    public RedirectView receiveNoteModify(Long noteNumber){
        adminService.modifyReceive(noteNumber);
        return new RedirectView("/admin/receivedNote");
    }

    @GetMapping("/receivedNote")
    public String receivedNote(AdminCriteria adminCriteria, Model model, HttpServletRequest req){
        Long recieverNumber = (Long)req.getSession().getAttribute("adminNumber");
        model.addAttribute("receivedList", adminService.findReceived(recieverNumber, adminCriteria));
        model.addAttribute("pageInfo", new AdminPageVo(adminService.getReceivedTotal(recieverNumber, adminCriteria), adminCriteria));
        return "admin/adminReceivedNote";}

    @GetMapping("/receivedNoteDetail")
    public String receivedNoteDetail(Long noteNumber,Model model){
        AdminNoteVo adminNoteVo = adminService.findRece(noteNumber);
        model.addAttribute("received", adminNoteVo);
        return "admin/adminReceivedNoteDetail";
    }

    @GetMapping("classApplyDetail")
    public String classApplyDetail(Long classNumber,Model model){
        AdminClassVo adminClassVo = adminService.findClassDetail(classNumber);
        model.addAttribute("class", adminClassVo);
        return "admin/adminClassApplicationDetail";
    }

    @GetMapping("mentoApplyDetail")
    public String mentoApplyDetail(Long applyNumber, Model model){
        AdminMentoApplyVo adminMentoApplyVo = adminService.findMentoApplyDetail(applyNumber);
        model.addAttribute("mento", adminMentoApplyVo);
        return "admin/adminMentoApplicationDetail";
    }


}

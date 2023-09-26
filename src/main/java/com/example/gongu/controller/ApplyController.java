package com.example.gongu.controller;

import com.example.gongu.domain.dto.MentoApplyDto;
import com.example.gongu.service.ApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/apply/*")
@RequiredArgsConstructor
@Slf4j
public class ApplyController {
    private final ApplyService applyService;
    //여기서 부터 작성
    @GetMapping("/write")
    public String showApplyPage(){
        return "mentoApply/mentorRegisterForm";
    }

    @PostMapping("/write")
    public RedirectView applyOk(MentoApplyDto mentoApplyDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                @RequestParam("applyFile") List<MultipartFile> files){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        mentoApplyDto.setUserNumber(6L); //userNumber로 변경
        applyService.registerAndFileProc(mentoApplyDto, files);

        Long applyNumber = mentoApplyDto.getApplyNumber();


//        쿼리스트링으로 데이터를 전송한다. -> 다시 요청을 보내는 메소드에서 데이터를 사용할 때
//        redirectAttributes.addAttribute("boardNumber", boardNumber);

//        플래쉬로 데이터를 전송 -> 화면에 데이터를 전송할 때 주로 사용
        redirectAttributes.addFlashAttribute("applyNumber", applyNumber);

        return new RedirectView("/study/list");
    }

}

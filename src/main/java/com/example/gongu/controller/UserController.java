package com.example.gongu.controller;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.domain.vo.PaymentCriteria;
import com.example.gongu.domain.vo.PaymentPageVo;
import com.example.gongu.domain.vo.admin.AdminCriteria;
import com.example.gongu.domain.vo.admin.AdminPageVo;
import com.example.gongu.service.PaymentService;
import com.example.gongu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final PaymentService paymentService;

    //로그인 화면전환
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    //아이디와 비밀번호를 입력받아서 로그인
    @PostMapping("login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req){
        UserDto userDto = userService.find(userId, userPassword);
        if(userDto != null) {
            //로그인이 성공하면 사용자번호, 레벨을 세션에 저장한다.
            req.getSession().setAttribute("userNumber", userDto.getUserNumber());
            //req.getSession() : 현재 http요청에 대한 세션을 얻기 위한 부분
            //setAttribute : 세션객체에 속성 설정 - userNumber라는 이름의 세션속성에
            // userDto.getUserNumber() 메서드에서 반환한 사용자 번호를 저장
            req.getSession().setAttribute("userLevel", userDto.getUserLevel());
            return new RedirectView("index");
        } else{//로그인 실패시 로그인페이지로 리다이렉트하며, 로그인 에러 파라미터를 추가한다.
            return new RedirectView("/user/login?loginError");
        }
    }

    //메인화면으로가는 컨트롤러
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //회원가입 화면전달
    @GetMapping("/join")
    public String join(){ return "user/join"; }

    @PostMapping("/join")
    public String join(UserDto userDto){
        userService.register(userDto);
        return "user/joinOk";
    }

    //아이디 중복체크
    @PostMapping("/userIdChk")
    @ResponseBody
    public String userIdChkPOST(String userId){
        // log.info("userIdChk 진입!!!!!");
        int result = userService.idCheck(userId);
        log.info("결과 : " + result);

        if(result !=0){
            return "fail"; //중복아이디
        } else {
            return "success"; //중복 아이디 없음
        }

    }

    @GetMapping("/joinOk")
    public String joinOk(){
        return "user/login";
    }


    //단순 페이지 이동-아이디찾기
    @GetMapping("/findId")
    public String findId(){
        return "user/findId";
    }

    //단순 페이지 이동 - 비밀번호 찾기
    @GetMapping("/findPassword")
    public String findPassword(){
        return "user/findPassword";
    }



    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "user/login";
    }





    //내정보 페이지
    @GetMapping("/myPage")
    public String myPage(Model model, HttpServletRequest req){
        log.info("=======================userNumber"+req.getSession().getAttribute("userName"));
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        log.info("=======================userNumber"+userNumber);
        model.addAttribute("user", userService.findMyPage(userNumber));
        log.info("=======================userNumber"+userNumber);
        return "user/myPage";
    }

//    유저 삭제
    @GetMapping("/removeUser")
    public RedirectView removeUser(Long userNumber){
        userService.remove(userNumber);
        return new RedirectView("/user/index");
    }
    //    유저 정보수정
    @GetMapping("/modifyUser")
    public RedirectView modifyUser(String userNickname, String userPhone, String userEmail, Long userNumber){
        userService.modifyUser(userNickname, userPhone, userEmail, userNumber);
        return new RedirectView("/user/myPage");
    }

    @GetMapping("/paymentBoard")
    public String paymentBoard(HttpServletRequest req, Model model, PaymentCriteria paymentCriteria){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        paymentCriteria.setUserNumber(userNumber);
        model.addAttribute("payList",  paymentService.findPay(paymentCriteria));
        model.addAttribute("pageInfo", new PaymentPageVo(paymentService.findPayTotal(userNumber),paymentCriteria));
        return "user/paymentBoard";
    }

    @GetMapping("modifyLevel")
    public void modifyLevel(@RequestParam("buyer_name") String buyer_name){
        Long classNumber = Long.parseLong(buyer_name);
        paymentService.modifyClass(classNumber);
    }


}


package com.example.gongu.controller;


import com.example.gongu.domain.vo.admin.AdminFileVo;
import com.example.gongu.service.AdminService;
import com.example.gongu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController //비동기통신컨트롤러를 만들때  사용
@RequiredArgsConstructor
@RequestMapping("/files/*")
public class FileController {
    private final AdminService adminService;
    private final UserService userService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<AdminFileVo> fileList(Long applyNumber){
        return adminService.findFile(applyNumber);

    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, fileName));
    }


    //    아이디 중복검사
    @GetMapping("checkId")
    public Long checkId(String userId){
        return adminService.findId(userId);
    }
    // 핸드폰 중복
    @GetMapping("checkPhone")
    public Long checkPhone(String userPhone){
        return userService.findPhone(userPhone);
    }
    // 이메일 중복
    @PostMapping("checkEmail")
    @ResponseBody
    public Long checkEmail(String userEmail){
        return userService.findEmail(userEmail);
    }

}

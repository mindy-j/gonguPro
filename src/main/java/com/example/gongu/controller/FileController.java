package com.example.gongu.controller;

import com.example.gongu.domain.vo.admin.AdminFileVo;
import com.example.gongu.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController //비동기통신컨트롤러를 만들때  사용
@RequiredArgsConstructor
@RequestMapping("/files/*")
public class FileController {
    private final AdminService adminService;

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



}
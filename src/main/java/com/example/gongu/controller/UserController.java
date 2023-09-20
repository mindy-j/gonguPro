package com.example.gongu.controller;

import com.example.gongu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}

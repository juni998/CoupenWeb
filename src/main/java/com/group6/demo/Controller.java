package com.group6.demo;

import com.group6.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {
    
    @Autowired
    private MemberService memberService;
    
    @GetMapping("/login")
    public String loginview(){
        log.info("");
        return "login";
    }


}

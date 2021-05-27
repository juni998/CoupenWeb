package com.group6.demo.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group6.demo.service.MemberService;




@RestController
public class MemberController {
	//private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberService ms;
	
	//로그인 버튼 -> 로그인폼 페이지로
	@GetMapping("/login")
	public String loginForm(String error, String logout, Model model) {
//		if (error != null) {
//			model.addAttribute("error", "Login Error!!!");
//		}
//		if (logout != null) {
//			model.addAttribute("logout", "Logout!!!");
//		}
		return "";
	}
	
	//로그인 성공 실패 여부 -> 홈
	@PostMapping("/loginProcess")
	public String loginProcess() {
		
		return "";
	}
	
	//로그아웃 버튼 -> 홈
	@GetMapping("/logout")
	public String logout() {
		
		return "";
	}
	
	//수정 -> 수정폼인데 (아직x)
	@PostMapping("/modify")
	public String modify() {
		
		return "";
	}
	
	//회원가입 버튼 -> 회원가입폼 페이지로
	@GetMapping("/register_form")
	public String register() {
		
		return "redirect:login";
	}
	
	
	//회원가입 완료 -> 로그인 페이지로
	@PostMapping("/register")
	public String register_form() {
		return "register";
	}
	
	
}
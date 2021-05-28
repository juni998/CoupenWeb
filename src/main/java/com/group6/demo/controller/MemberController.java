package com.group6.demo.controller;


import com.group6.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Slf4j
public class MemberController {
	@Autowired
	MemberService ms;

	//로그인 버튼 -> 로그인폼 페이지로
	@GetMapping("/login")
	public void loginForm() {

	}

	//로그아웃 버튼 -> 홈
	@GetMapping("/logout")
	public String logout() {
		return "/logout";
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

package com.group6.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	// private static final Logger logger =
	// LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService ms;
	@GetMapping("/home")
	public String home() {
		return "/index";
	}
	// 로그인 버튼 -> 로그인폼 페이지로
	@GetMapping("/login")
	public String login(String error, String logout, Model model) {
//		if (error != null) {
//			model.addAttribute("error", "Login Error!!!");
//		}
//		if (logout != null) {
//			model.addAttribute("logout", "Logout!!!");
//		}
		return "/popup";
	}

	// 로그인 성공 실패 여부 -> 홈
	@PostMapping("/loginProcess")
	public String loginProcess() {
		return "/home";
	}

	// 로그아웃 버튼 -> 홈
	@GetMapping("/logout")
	public String logout() {

		return "";
	}

	@GetMapping("modifyForm")
	public String modify_form() {
		return "";
	}

	// 비밀번호 수정 -> 수정폼인데 (아직x)
	@PostMapping("/modify")
	public String modify(HttpSession session, MemberDTO dto,
			RedirectAttributes ra) {
		
		
		return "";
	}

	// 회원가입 버튼 -> 회원가입폼 페이지로
	@GetMapping("/registerForm")
	public String register_Form(Model model) {
		return "/saveView";
	}

	// 회원가입 완료 -> 로그인 페이지로
	@PostMapping("/register")
	public String register(MemberDTO dto) {
		
		ms.save(dto);
		
		return "redirect:/home";
	}

//마이페이지
//   @GetMapping("items/{account}/mypage")
//   public String updateItemForm(@PathVariable("account") Long account,
//   		Model model) {
//   	
//   }
}

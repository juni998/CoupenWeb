package com.group6.demo.controller;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import com.group6.demo.entity.login.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public void login() {
	}

	@GetMapping("modifyForm")
	public String modify_form() {
		return "";
	}

	// 비밀번호 수정 -> 수정폼인데 (아직x)
	@PostMapping("/modify")
	public String modify(MemberDTO newMemberDTO, Authentication authentication) throws Exception{
		MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Member member = Member.builder()
				.name(memberDTO.getName())
				.account(memberDTO.getAccount())
				.password(passwordEncoder.encode(newMemberDTO.getPassword()))
				.email(newMemberDTO.getEmail())
				.build();

		return "redirect:/home";
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

	@GetMapping("/checkValid")
	public void checkValid(Authentication authentication){
	    Member member = (Member) authentication.getPrincipal();

	    log.info("member : " + member.toString());
	}


//마이페이지
//   @GetMapping("items/{account}/mypage")
//   public String updateItemForm(@PathVariable("account") Long account,
//   		Model model) {
//
//   }
}

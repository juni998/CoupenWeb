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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	//private static final Logger logger =
	//LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService ms;
	
	// 홈
	@GetMapping("/home")
	public String home() {
		return "/index";
	}
	
	// 로그인폼
	@GetMapping("/loginProcess")
	public String login() {
		return "popup";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout() {
		return "/logout";
	}
	
	/*
	@GetMapping("modifyForm")
	public String modify_form() {
		return "/modify";
	}
	*/
	
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
	
	// 마이페이지 비밀번호 변경
	@PostMapping("/changePw")
	public String changePw(@RequestParam String account, String newPassword) {
		log.info("ACCOUNT : " + account + ", NEWPASSWORD : " + newPassword);
		ms.changePasswordByAccount(account, newPassword);
		return "";
	}
	
	// 이름으로 찾기
	@PostMapping("findMemberByName")
	public String findMemberByName(@RequestParam String name) {
		log.info("NAME : " + name);
		ms.findMemberByName(name);
		return "";
	}
	
	// 이름으로 찾기에서 유저 정보 불러오기
	@PostMapping("loadUserByUsername")
	public String loadUserByUsername(@RequestParam String name) {
		log.info("NAME : " + name);
		ms.loadUserByUsername(name);
		return "";
	}
	
	// 회원가입
	@GetMapping("/registerForm")
	public String register_Form(Model model) {
		return "/saveView";
	}

	// 회원가입 완료
	@PostMapping("/register")
	public String register(MemberDTO dto) {
		Long result = ms.save(dto);
		log.info("register : " + dto);
		
		if(result == null) {
			return "redirect:/registerForm";
		}
		return "redirect:/loginProcess";
	}
	
	// 로그인 유효성 검사
	@GetMapping("/checkValid")
	public void checkValid(Authentication authentication){
	    Member member = (Member) authentication.getPrincipal();

	    log.info("member : " + member.toString());
	}

	// 마이페이지 수정폼
	@GetMapping("/mypage")
	public String mypage() {
		
		return "/modify";
	}
	

//마이페이지
//   @GetMapping("items/{account}/mypage")
//   public String updateItemForm(@PathVariable("account") Long account,
//   		Model model) {
//
//   }
}

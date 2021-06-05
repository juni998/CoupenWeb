package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.security.SignUpFormValidator;
import com.group6.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	@Autowired
	private final MemberService memberService;

	@Autowired
	private final MemberRepository memberRepository;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	// 홈
	@GetMapping("/home")
	public String home(Principal principal, Model model) throws Exception {
		if (principal != null) {
			model.addAttribute("account", principal.getName());
		}
		return "/home/index";
	}

	// 로그인
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);

		return "/home/login/login";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout() {

		return "/logout";
	}
	
	// 문의하기
	@GetMapping("question")
	public String question() {

		return "/home/question";
	}
	
	// 상품게시판
	@GetMapping("shop")
	public String shop() {

		return "home/shop";
	}

	// 장바구니
	@GetMapping("shoppingcart")
	public String shoppingcart() {

		return "home/shoppingcart";
	}
	/*
	 * 참고용
	 * 
	 * @GetMapping("/username1") public String currentUserName(Authentication
	 * authentication, Model model) {
	 * 
	 * UserDetails userDetails = (UserDetails) authentication.getPrincipal(); String
	 * name = userDetails.getUsername();
	 * 
	 * model.addAttribute("name", name); return "username1"; }
	 * 
	 * @GetMapping("asdf")
	 * 
	 * @ResponseBody public Long asdf(Member member){
	 * 
	 * return member.getId(); }
	 * 
	 * @PostMapping("/modify") public String modify(MemberDTO newMemberDTO,
	 * Authentication authentication) throws Exception { MemberDTO memberDTO =
	 * (MemberDTO) authentication.getPrincipal(); BCryptPasswordEncoder
	 * passwordEncoder = new BCryptPasswordEncoder();
	 * 
	 * Member member = new Member(); member.setAccount(memberDTO.getAccount());
	 * member.setPassword(passwordEncoder.encode(newMemberDTO.getPassword()));
	 * member.setName(newMemberDTO.getName());
	 * member.setEmail(newMemberDTO.getEmail());
	 * 
	 * return "redirect:/home"; }
	 * 
	 */
}

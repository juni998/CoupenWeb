package com.group6.demo.controller;

import com.group6.demo.repository.MemberRepository;
import com.group6.demo.security.SignUpFormValidator;
import com.group6.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/")
	public String welcome(){
	    log.info("welcome Page");
	    return "/welcome";
	}
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

}

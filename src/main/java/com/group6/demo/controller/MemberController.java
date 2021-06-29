package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.security.SignUpFormValidator;
import com.group6.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	@Autowired
	private final MemberService memberService;

	@Autowired
	private final MemberRepository memberRepository;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	// 마이페이지 회원정보
	@GetMapping("/mypage")
	public String mypage(Principal principal, Model model) {
		try {
			Member member = memberRepository.findMemberByAccount(principal.getName());
			log.info("memeber : " + member);
			model.addAttribute("member", member);
			return "/home/login/MyPage";
		} catch (NullPointerException e){
			return "redirect:/login";
		}
	}

	// 마이페이지 회원정보 변경 GET
	@GetMapping("memberUpdate")
	public String memberUpdate(Principal principal, Model model) {
		try {
			Member member = memberRepository.findMemberByAccount(principal.getName());
			model.addAttribute("member", member);
			return "/home/login/modify";
		} catch (NullPointerException e){
			return "redirect:/login";
		}

	}

	// 마이페이지 패스워드 변경
	@PostMapping("/memberUpdate/password")
	public String memberInfoUpdate(@RequestParam String newPassword, Principal principal) {
		try{
			memberService.changePasswordByAccount(principal.getName(),newPassword);

			return "redirect:/mypage";
		} catch (NullPointerException e){
			return "redirect:/login";
		}
	}

	// 마이페이지 이메일 변경
	@PostMapping("/memberUpdate/email")
	public String memberUpdateEmail(@RequestParam String newEmail, Principal principal){
		try{
			memberService.changeEmailByAccount(principal.getName(), newEmail);

			return "redirect:/mypage";
		} catch (NullPointerException e){
			return "redirect:/login";
		}
	}

	// 마이페이지 이름 변경
	@PostMapping("/memberUpdate/name")
	public String memberUpdateName(@RequestParam String newName, Principal principal){
		try{
			memberService.changeNameByAccount(principal.getName(), newName);

			return "redirect:/mypage";
		} catch (NullPointerException e){
			return "redirect:/login";
		}
	}
}

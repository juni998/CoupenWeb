package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

	@Autowired
	private final MemberService memberService;

	@Autowired
	private final MemberRepository memberRepository;


	// 아이디 찾기 GET
	@GetMapping("/idRefefer")
	public String find() {
		return "/home/login/findId";
	}

	// 아이디 찾기 POST
	@PostMapping("/idRefefer")
	public String findId(@RequestParam String email, Model model) throws Exception {

		Member member = memberRepository.findMemberByEmail(email);

		model.addAttribute("memberId", member.getAccount());

		log.info("member : " + member);

		return "/home/login/find_id_change";
	}

	// 비밀번호 찾기 GET
	@GetMapping("/pwRefefer")
	public String findPwByAccount() {

		return "/home/login/findPw";
	}

	// 비밀번호 찾기 POST
	@PostMapping("/pwRefefer")
	public String findPw(@RequestParam String account, Model model) throws Exception {

		Member member = memberRepository.findMemberByAccount(account);
		log.info("ACCOUNT : " + account);
		model.addAttribute("memberId", member.getAccount());
		return "/home/login/findPwChange";
	}
	// 비밀번호 변경
	@PostMapping("/pwChange")
	public String changePwd(@RequestParam String newPassword, String account) {


		memberService.changePasswordByAccount(account, newPassword);
		return "redirect:/login";
	}

	// 회원가입 GET
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "/home/saveView";
	}

	// 회원가입 POST
	@PostMapping("/register")
	public String register(@Valid MemberDTO dto) {

		Long result = memberService.save(dto);

		log.info("register : " + dto);
		return "redirect:/home";

	}

}

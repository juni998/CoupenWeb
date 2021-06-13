package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.security.SignUpFormValidator;
import com.group6.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

	@Autowired
	private final MemberService memberService;

	@Autowired
	private final MemberRepository memberRepository;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	// 아이디 찾기 GET
	@GetMapping("/idRefefer")
	public String find() {
		return "/home/login/findId";
	}

	// 아이디 찾기 POST
	@PostMapping("/idRefefer")
	public String findId(@RequestParam String email, Model model, RedirectAttributes attributes) throws Exception {
		if (memberRepository.existsByEmail(email) == false) {
			attributes.addFlashAttribute("message", "존재하지 않는 이메일입니다.");
			return "redirect:/idRefefer";
		}
		Member member = memberRepository.findMemberByEmail(email);
		log.info("member : " + member);
		model.addAttribute("member", member);
		return "/home/login/find_id_change";
	}

	// 비밀번호 찾기 GET
	@GetMapping("/pwRefefer")
	public String findPwByAccount() {
		return "/home/login/findPw";
	}

	// 비밀번호 찾기 POST
	@PostMapping("/pwRefefer")
	public String findPw(@RequestParam String account, Model model, RedirectAttributes attributes) {

		if (memberRepository.existsByAccount(account) == false) {
			attributes.addFlashAttribute("message", "존재하지 않는 아이디입니다.");
			return "redirect:/pwRefefer";
		}
		Member member = memberRepository.findMemberByAccount(account);
		log.info("ACCOUNT : " + account);
		model.addAttribute("member", member);
		return "redirect:/idInfo";
	}

	// 비밀번호 변경
	@PostMapping("/changePwd")
	public String changePwd(@RequestParam String newPassword, String account) {
		
		memberService.changePasswordByAccount(account, newPassword);
		return "";
	}

	// 회원가입
	@InitBinder("register")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(signUpFormValidator);
	}

	// 회원가입 GET
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "/master/saveView";
	}

	// 회원가입 POST
	@PostMapping("/register")
	public String register(@Valid MemberDTO dto, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "/master/register";
		}

		if (memberRepository.existsByAccount(dto.getAccount())) {
			attributes.addFlashAttribute("message", "이미 사용중인 아이디입니다.");
			return "redirect:/register";
		}

		if (memberRepository.existsByEmail(dto.getEmail())) {
			attributes.addFlashAttribute("message", "이미 사용중인 이메일입니다.");
			return "redirect:/register";
		}
		
		attributes.addFlashAttribute("message", "회원가입 성공");
		Long result = memberService.save(dto);

		log.info("register : " + dto);
		return "redirect:/home";

	}

	/*
	 * @GetMapping("/findIdChange/{memberId}") public String
	 * IdInfo(@PathVariable("memberId") Long memberId, Model model) {
	 *
	 * return "home/login/find_id_change"; }
	 */
}

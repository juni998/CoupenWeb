package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
	@GetMapping("/login")
	public void login() {

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


	// 회원가입
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "/saveView";
	}

	// 회원가입 완료
	@PostMapping("/register")
	public String register(@Valid MemberDTO dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()){
			return "redirect:/register";
		}

		Long result = ms.save(dto);
		log.info("register : " + dto);


		if(result == null) {
			return "redirect:/register";
		}
		return "/home";
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

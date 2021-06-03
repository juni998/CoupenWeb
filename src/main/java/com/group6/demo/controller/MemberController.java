package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.security.SignUpFormValidator;
import com.group6.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
public class MemberController {
	// private static final Logger logger =
	// LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService ms;
	
	@Autowired
	private MemberRepository mr;
	
	
	@Autowired
	private SignUpFormValidator signUpFormValidator;

	// 홈
	@GetMapping("/home")
	public String home(Principal principal,Model model) throws Exception{
		if(principal != null) {
			model.addAttribute("account", principal.getName());
			
		}
		
		return "/home/index";
	}

	// 로그인폼
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);

		return "/login";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout() {
		
		return "/logout";
	}
	
	@PostMapping("/modify")
	public String modify(MemberDTO newMemberDTO, Authentication authentication) throws Exception {
		MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Member member = Member.builder().name(memberDTO.getName()).account(memberDTO.getAccount())
				.password(passwordEncoder.encode(newMemberDTO.getPassword())).email(newMemberDTO.getEmail()).build();

		return "redirect:/home";
	}

	// 아이디 찾기폼 (매핑주소, 리턴주소 변경예정)
	@GetMapping("/findId")
	public String find() {
		return "/home/login/findId";
	}

	
	// 아이디 찾기 (매핑주소, 리턴주소 변경예정)
	@PostMapping("/findIda")
	public String findId(@RequestParam String email, Model model) {
		Member member = mr.findMemberByEmail(email);
		
		if(member == null) {
			//존재하지 않는 이메일
			return "redirect:/find";
		}
		log.info("member : "+ member);
		model.addAttribute("userId", member.getAccount());
		return "redirect:/findIdChange";
	}
	
	// 이메일로 아이디 찾기 -> 아이디 확인 (매핑주소, 리턴주소 변경예정)
	@GetMapping("/findIdChange")
	public String IdInfo() {
		return "home/login/find_id_change";
	}
	
	// 아이디로 비밀번호 찾기 (매핑주소, 리턴주소 변경예정)
	@PostMapping("/findPw") 
	public String findPw(@RequestParam String account, Model model) {
		Member member = mr.findMemberByAccount(account);
		if(member == null) {
			//존재하지 않는 아이디
			return "redirect:/";
		}
		log.info("ACCOUNT : " + account);
		model.addAttribute("member", member);
		return "redirect:/idInfo";
	}
	
	// 비밀번호 찾기 -> 비밀번호 변경 (account값 나중에 수정할듯..? 매핑주소, 리턴주소 변경예정)
	@PostMapping("/changePwd")
	public String changePwd(@RequestParam String newPassword,String account) {
		
		ms.changePasswordByAccount(account, newPassword);
		return "";
	}
	
	// 마이페이지 비밀번호 변경 
	@PostMapping("/changePw")
	public String changePw(@RequestParam String newPassword,Principal principal) {
		String account = principal.getName();
		log.info("ACCOUNT : " + account + ", NEWPASSWORD : " + newPassword);
		ms.changePasswordByAccount(account, newPassword);
		return "redirect:/home";
	}
	
	// 회원가입
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "/master/saveView";
	}

	// 회원가입 완료
	@PostMapping("/register")
	public String register(@Valid MemberDTO dto, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "/register";
		}

		attributes.addFlashAttribute("message", "회원가입 성공");
		Long result = ms.save(dto);

		log.info("register : " + dto);
		return "redirect:/home";

	}

	//  수정폼
	@GetMapping("/mypage")
	public String mypage(Principal principal, Model model) {
		String account = principal.getName();
		model.addAttribute("account", account);
		return "/modify";
	}

	@InitBinder("register")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(signUpFormValidator);
	}
	
	// 회원정보 보기
	@GetMapping("gg")
	public String mypage1(Principal principal, Model model) {
		String account = principal.getName();
		Member member = mr.findMemberByAccount(account);
		
		log.info("Member :" + member);
		model.addAttribute("member", member);
		
		return "";
	}
	
	/*  참고용
	@GetMapping("/username1")
	public String currentUserName(Authentication authentication, Model model) {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String name = userDetails.getUsername();

		model.addAttribute("name", name);
		return "username1";
	}
	*/
}

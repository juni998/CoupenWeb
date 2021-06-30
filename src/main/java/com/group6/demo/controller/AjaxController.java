package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AjaxController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final MemberRepository memberRepository;

    @RequestMapping(value = "/autocomplete")
    @ResponseBody
    public List<String> autoName(@RequestParam(value = "term", required = false, defaultValue = "")String term){
        List<String> designation = itemService.getItemSearchListAjax(term);
        return designation;
    }

    @ResponseBody
    @RequestMapping(value = "/accountDuplicate", method = RequestMethod.POST)
    public Boolean checkAccountDuplicate(@RequestParam String account) throws Exception{
        boolean result = memberRepository.existsByAccount(account);
        log.info("result 값 : " + result);
        return memberRepository.existsByAccount(account);
    }
    @ResponseBody
    @RequestMapping(value = "emailDuplicate", method = RequestMethod.POST)
    public Boolean checkEmailDuplicate(@RequestParam String email) throws Exception{
        boolean result = memberRepository.existsByEmail(email);
        log.info("result 값 : " + result);
        return memberRepository.existsByEmail(email);
    }

    @ResponseBody
    @RequestMapping(value = "/pwRefeferInfo", method = RequestMethod.POST)
    public int pwRefeferInfo(@RequestParam String account, @RequestParam String email)throws  Exception{
        log.info("pwRefeferInfo 실행");
        Member member = memberRepository.findMemberByAccount(account);
        int result = 0;
        if (member == null){
            result = 0;
        }else {
           if(member.getEmail().equals(email)){
               result = 1;
           }
           else {
               result = 2;
           }
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/pwCheck", method = RequestMethod.POST)
    public Boolean pwCheck(@RequestParam String account, @RequestParam String password){

        Member member = memberRepository.findMemberByAccount(account);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password,member.getPassword())){

            return true;

        }

        return false;
    }
}

package com.group6.demo.controller;

import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
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
	public Boolean checkAccountDuplicate(@PathVariable String account){
	    return memberRepository.existsByAccount(account);
	}

    @ResponseBody
    @RequestMapping(value = "/emailDuplicate", method = RequestMethod.POST)
    public Boolean checkEmailDuplicate(@PathVariable String email){
        return memberRepository.existsByAccount(email);
    }
	
}

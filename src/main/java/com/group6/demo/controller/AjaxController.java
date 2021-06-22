package com.group6.demo.controller;

import com.group6.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class AjaxController {

    private final ItemRepository itemRepository;

    @RequestMapping(value = "/searchList", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public void searchList(Locale locale, Model model){
    }

	
	
}

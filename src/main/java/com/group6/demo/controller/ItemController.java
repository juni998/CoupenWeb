package com.group6.demo.controller;

import com.group6.demo.entity.Item.ItemDTO;
import com.group6.demo.entity.Item.PageRequestDTO;
import com.group6.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO , Model model){
        model.addAttribute("result", itemService.getList(pageRequestDTO));
    }

    @GetMapping("read/{id}")
    public String getItem(@PathVariable("id") Long id, Model model){
        ItemDTO itemDTO = itemService.getItemById(id);
        
        model.addAttribute("dto",itemDTO);

        return "read";
    }
    
    // 아이템 작성 GET
    @GetMapping("itemRegister")
    public String registerForm(Model model) {
    	model.addAttribute("itemDTO", new ItemDTO());
    	
    	return "itemRegister";
    }
    
    // 아이템 작성 POST
    @PostMapping("itemRegister")
    public String register(ItemDTO itemDTO){
    	Long result = itemService.register(itemDTO);
    	
    	log.info("itemDTO : "+ itemDTO);
    	return "redirect:/read/" + result;
    }
    
    // 아이템 수정 GET
    @GetMapping("itemModify/{id}")
    public String modifyForm(@PathVariable("id") Long id, Model model) {
    	ItemDTO itemDTO = itemService.getItemById(id);
    	
    	model.addAttribute("dto",itemDTO);
    	
    	return "itemModify";
    }
    
    // 아이템 수정 POST
    @PostMapping("itemModify/{id}")
    public String modify(@PathVariable("id") Long id, ItemDTO itemDTO) {
    	log.info("itemDTO : " + itemDTO);
    	
    	itemService.modifyItem(itemDTO);
    	
    	
    	return "redirect:/read/" + id;
    }
    
    // 아이템 삭제
    @GetMapping("itemRemove/{id}")
    public String remove(@PathVariable("id") Long id) {
    	itemService.removeItem(id);
    	
    	return "redirect:/list";
    }
    
    
    
    

}
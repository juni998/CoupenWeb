package com.group6.demo.controller;

import com.group6.demo.entity.item.ItemDTO;
import com.group6.demo.entity.item.PageRequestDTO;
import com.group6.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
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

}

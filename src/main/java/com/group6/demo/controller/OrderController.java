package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderRepository;
import com.group6.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    private final OrderService orderService;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final OrderRepository orderRepository;

    @GetMapping("/order")
    public String order(Principal principal, Model model){
        log.info("get order");
        Member result = memberRepository.findMemberByAccount(principal.getName());

        Optional<Orders> orders = orderRepository.findById(result.getId());
        System.out.println("orders.toString() = " + orders.toString());
        if (orders.isEmpty()){
            System.out.println("orders Present실행");
            model.addAttribute("orderDTO", new OrderDTO());
            return "/createOrder";
        }
        System.out.println("orders를 실행 안했음 = " + orders);
        Orders order = orders.get();
        model.addAttribute("orderDTO", order);
        return "myOrder";
    }
    @PostMapping("/order")
    public String makeOrder(OrderDTO orderDTO,Principal principal){
        log.info("Make Order ... ");
        Member result = memberRepository.findMemberByAccount(principal.getName());
        orderService.makeOrder(result.getId(), orderDTO);

        return "myOrder";
    }
    @GetMapping("/myOrder")
    public void myOrderPage(Principal principal, Model model){
        Member result = memberRepository.findMemberByAccount(principal.getName());
        Optional<Orders> ordersOptional = orderRepository.findById(result.getId());
        Orders orders = ordersOptional.get();

        model.addAttribute("orders", orders);
    }


}

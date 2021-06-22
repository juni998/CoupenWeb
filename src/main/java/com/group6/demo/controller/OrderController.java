package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.OrderItem;
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
import java.util.List;
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
        try {log.info("get order");
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
            return "redirect:/myOrder";
        } catch (NullPointerException e){
            return "redirect:/login";
        }
    }
    @PostMapping("/makeOrder")
    public String makeOrder(OrderDTO orderDTO,Principal principal){
        log.info("Make Order ... ");
        Member result = memberRepository.findMemberByAccount(principal.getName());
        orderService.makeOrder(result.getId(), orderDTO);

        return "redirect:/myOrder";
    }
    @GetMapping("/myOrder")
    public String myOrderPage(Principal principal, Model model){
        try{Member result = memberRepository.findMemberByAccount(principal.getName());
        log.info("MyOrder : "+ principal.getName());
        Optional<Orders> ordersOptional = orderRepository.findById(result.getId());
        Orders orders = ordersOptional.get();
        List<OrderItem> orderItemList = orderService.getItemList(result.getId());
        System.out.println("MyOrder");
        System.out.println("MyOrder");
        System.out.println("MyOrder");
        System.out.println("orderItemList.getClass() = " + orderItemList.getClass());
        for (OrderItem get: orderItemList) {
            System.out.println("=========================");
            System.out.println("orderItem.get = " + get.getItemName());
            System.out.println("orderItem.get = " + get.getId());
            System.out.println("orderItem.get = " + get.getPrice());
            System.out.println("orderItem.get = " + get.getCount());
        }

        model.addAttribute("orders", orders);
        model.addAttribute("orderItemList",orderItemList);
        return "/myOrder";}
        catch (NullPointerException e){
            return "/login";
        }
    }


}

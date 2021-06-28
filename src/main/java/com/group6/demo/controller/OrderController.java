package com.group6.demo.controller;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.CompleteOrder;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.OrderItem;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.repository.CompleteRepository;
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
import java.util.NoSuchElementException;
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
    @Autowired
    private final CompleteRepository completeRepository;


    //상품을 담으려면 무조건 order가있어야함
    @GetMapping("/order")
    public String order(Principal principal, Model model){
        try
        {
            log.info("get order");
            Member result = memberRepository.findMemberByAccount(principal.getName());

            Optional<Orders> orders = orderRepository.findByMemberId(result.getId());
            if (orders.isEmpty()){
                model.addAttribute("orderDTO", new OrderDTO());
                return "/createOrder";
            }
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

        return "redirect:/order";
    }
    @GetMapping("/myOrder")
    public String myOrderPage(Principal principal, Model model){
        try{
            Member result = memberRepository.findMemberByAccount(principal.getName());
            log.info("MyOrder : "+ principal.getName());
            Optional<Orders> ordersOptional = orderRepository.findByMemberId(result.getId());
            Orders orders = ordersOptional.get();
            List<OrderItem> orderItemList = orderService.getItemList(result.getId());
            model.addAttribute("orders", orders);
            model.addAttribute("orderItemList",orderItemList);
            return "/myOrder";
        }catch (NullPointerException e){
            return "redirect:/login";
        }catch (NoSuchElementException e ){
            return "redirect:/home";
        }
    }
    @GetMapping("/myItemList")
    public String itemList(Principal principal,Model model){
        try {
            log.info("");
            Member result = memberRepository.findMemberByAccount(principal.getName());
            List<OrderItem> orderItemList = orderService.getItemList(result.getId());
            model.addAttribute("orderItemList", orderItemList);
            return "/myItemList";
        }catch (NullPointerException e){
            return "redirect:/order";
        }catch (NoSuchElementException e){
            return "redirect:/order";
        }
    }

    //주문완료
    @GetMapping("/completeOrder")
    public String CompleteOrder(Principal principal){
        Member result = memberRepository.findMemberByAccount(principal.getName());
        Optional<Orders> ordersOptional = orderRepository.findByMemberId(result.getId());
        Orders orders = ordersOptional.get();
        orderService.completeOrder(orders.getId());
        return "redirect:/myOrderList";
    }

    //주문 취소
    @GetMapping("/cancelOrder")
    public String CancelOrder(Principal principal){
        Member result = memberRepository.findMemberByAccount(principal.getName());

        Optional<Orders> ordersOptional = orderRepository.findByMemberId(result.getId());
        Orders orders = ordersOptional.get();
        orderService.cancelOrder(orders.getId());

        return "redirect:/myOrderList";
    }
    @GetMapping("/myOrderList")
    public String myOrderList(Principal principal, Model model){
        Member result = memberRepository.findMemberByAccount(principal.getName());
        List<CompleteOrder> completeOrderList = completeRepository.findByMemberId(result.getId());
        model.addAttribute("completeOrderList", completeOrderList);

        return "/orderList";
    }


}


package com.group6.demo.controller;

import com.group6.demo.entity.item.PageRequestDTO;
import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.*;
import com.group6.demo.repository.CompleteRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderItemRepository;
import com.group6.demo.repository.OrderRepository;
import com.group6.demo.service.ItemService;
import com.group6.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private final ItemService itemService;
    @Autowired
    private final OrderItemRepository orderItemRepository;


    //상품을 담으려면 무조건 order가있어야함
    @PreAuthorize("hasRole('ROLE_MEMBER')")
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
            return "redirect:/myItemList";
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
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/myOrder")
    public String myOrderPage(@RequestParam(value = "name", required = false) String ordersTotalPrice, Principal principal, Model model, PageRequestDTO pageRequestDTO){
        try{
            Member result = memberRepository.findMemberByAccount(principal.getName());
            log.info("MyOrder : "+ principal.getName());
            Optional<Orders> ordersOptional = orderRepository.findByMemberId(result.getId());
            Orders orders = ordersOptional.get();
            List<OrderItem> orderItemList = orderService.getItemList(result.getId());
            model.addAttribute("orders", orders);
            model.addAttribute("orderItemList",orderItemList);
            model.addAttribute("ordersTotalPrice", orders.getTotalPrice());
            model.addAttribute("result", itemService.getList(pageRequestDTO));
            return "/myOrder";
        }catch (NullPointerException e){
            return "redirect:/login";
        }catch (NoSuchElementException e ){
            return "redirect:/home";
        }
    }
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/myItemList") // 장바구니
    public String itemList(@RequestParam(value = "name", required = false) String ordersTotalPrice, Principal principal,Model model, PageRequestDTO pageRequestDTO){
        try {
            Member result = memberRepository.findMemberByAccount(principal.getName());
            List<OrderItem> orderItemList = orderService.getItemList(result.getId());
            Optional<Orders> ordersOptional = orderRepository.findByMemberId(result.getId());
            Orders orders = ordersOptional.get();

            model.addAttribute("result", itemService.getList(pageRequestDTO));
            model.addAttribute("orderItemList", orderItemList);
            model.addAttribute("orderItemList", orderItemList);
            model.addAttribute("ordersTotalPrice", orders.getTotalPrice());
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
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/myOrderList")
    public String myOrderList(Principal principal, Model model, PageRequestDTO pageRequestDTO){
        Member result = memberRepository.findMemberByAccount(principal.getName());
        List<CompleteOrder> completeOrderList = completeRepository.findByMemberId(result.getId());
        model.addAttribute("completeOrderList", completeOrderList);
        model.addAttribute("result", itemService.getList(pageRequestDTO));

        return "/orderList";
    }
    //    @PostMapping("/myOrderList")
//    public String myOrderListPost(Principal principal, Model model){
//        Member result = memberRepository.findMemberByAccount(principal.getName());
//        List<CompleteOrder> completeOrderList = completeRepository.findByMemberId(result.getId());
//        model.addAttribute("completeOrderList", completeOrderList);
//
//        for (CompleteOrder completeOrder : completeOrderList) {
//            System.out.println("completeOrder = " + completeOrder.getStatus());
//        }
//        return "/orderList";
//    }
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @PostMapping("/addOrder")
    public String getItemOrder(OrderItemDTO orderItemDTO, Principal principal){
        try{
            Member member = memberRepository.findMemberByAccount(principal.getName());
            Optional<Orders> result = orderRepository.findByMemberId(member.getId());
            Orders orders = result.get();
            if (result.isEmpty()){
                return "redirect:/myOrder";
            }
            orderService.makeOrderItem(orderItemDTO.getId(), member.getId(), orders.getId(), orderItemDTO.getCount());

            return "redirect:/myItemList";
        }catch (NoSuchElementException e){
            return "redirect:/login";
        }catch (NullPointerException e){
            return "redirect:/login";
        }
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/removeItem/{id}")
    public String getItemGet(@PathVariable("id") Long id ){
        orderItemRepository.deleteById(id);
        return "redirect:/myItemList";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/completeStatus/{id}")
    public String completeStatus(@PathVariable("id") Long id ){
        Optional<CompleteOrder> result = completeRepository.findById(id);
        CompleteOrder completeOrder = result.get();
        completeOrder.setStatus(OrderStatus.COMPLETE);
        completeRepository.save(completeOrder);
        return "redirect:/myOrderList";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/removeStatus/{id}")
    public String removeStatus(@PathVariable("id") Long id ){
        Optional<CompleteOrder> result = completeRepository.findById(id);
        CompleteOrder completeOrder = result.get();
        completeOrder.setStatus(OrderStatus.CANCEL);
        completeRepository.save(completeOrder);
        return "redirect:/myOrderList";
    }

}


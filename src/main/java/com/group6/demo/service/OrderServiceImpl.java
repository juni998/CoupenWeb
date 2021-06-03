package com.group6.demo.service;

import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
//    @Override
//    public  void makeOrder(String account,OrderDTO orderDTO) {
//        Orders order = new Orders();
//        Optional<Orders> orders = orderRepository.findById(memberRepository.findMemberByAccount(account));
//
//        if (orders.isPresent() == false){
//            log.info("create New order by " + account);
//            order.setMember(memberRepository.findMemberByAccount(account));
//            order.setName(orderDTO.getName());
//            order.setPhoneNumber(orderDTO.getPhoneNumber());
//            order.
//        }
//
//    }
}

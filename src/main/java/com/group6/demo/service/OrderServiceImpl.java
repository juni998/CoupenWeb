package com.group6.demo.service;

import com.group6.demo.entity.order.Orders;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Override
    public  void makeOrder(String account) {
        Optional<Orders> orders = orderRepository.findById(memberRepository.findMemberByAccount(account));
        if (orders.isPresent() == false){

        }
    }
}

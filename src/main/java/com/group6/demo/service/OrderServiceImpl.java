package com.group6.demo.service;

import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;

//    @Override
//    public Orders makeOrder(String account, Long itemId, Address address, int count) {
//
//        Member member = memberRepository.findMemberByAccount(account);
//        Item item = (itemRepository.findById(itemId)).get();
//
//
//        Orders order = Orders.createOrder(member,address,orderItem);
//
//        orderRepository.save(order);
//
//        return order;
//
//    }
}

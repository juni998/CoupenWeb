package com.group6.demo.service;

import com.group6.demo.entity.Item.Item;
import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.Address;
import com.group6.demo.entity.order.OrderItem;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.repository.ItemRepository;
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
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Orders makeOrder(String account, Long itemId, Address address, int count) {

        Member member = memberRepository.findMemberByAccount(account);
        Item item = (itemRepository.findById(itemId)).get();

        OrderItem orderItem = OrderItem.createOrderItem(item,item.getPrice(),count);
        Orders order = Orders.createOrder(member,address,orderItem);

        orderRepository.save(order);

        return order;

    }
}

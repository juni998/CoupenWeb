package com.group6.demo.service;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.OrderItem;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderItemRepository;
import com.group6.demo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public Long makeOrder(Long memberId, OrderDTO orderDTO) {
        Member member = memberRepository.findMemberById(memberId);
        Orders orders = Orders.createOrder(member,orderDTO);
        orderRepository.save(orders);
        return orders.getId();
    }

    @Override
    public void makeOrderItem(Long itemId, Long memberId,Long orderId, int count) {
        Item item = itemRepository.getById(itemId);
        Member member = memberRepository.findMemberById(memberId);
        Optional<Orders> result = orderRepository.findById(orderId);
        Orders orders = result.get();

        OrderItem orderItem = OrderItem.createOrderItem(item,3);
        orderItem.setOrders(orders);

        orderItemRepository.save(orderItem);
    }

    @Override
    public void completeOrder(Long orderId) {
        Optional<Orders> result = orderRepository.findById(orderId);
        Orders orders =  result.get();
    }

    @Override
    public List<OrderItem> getItemList(Long memberId) {
        Member result = memberRepository.findMemberById(memberId);
        Optional<Orders> ordersOptional = orderRepository.findById(result.getId());
        Orders orders = ordersOptional.get();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItem orderItem : orders.getOrderItems()) {
            orderItemList.add(orderItem);
        }
       return orderItemList;
    }


//
}

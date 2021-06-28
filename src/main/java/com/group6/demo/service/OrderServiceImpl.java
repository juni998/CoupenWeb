package com.group6.demo.service;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.*;
import com.group6.demo.repository.*;
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
    @Autowired
    CompleteRepository completeRepository;

    @Override
    @Transactional
    public Long makeOrder(Long memberId, OrderDTO orderDTO) {
        Member member = memberRepository.findMemberById(memberId);
        Orders orders = Orders.createOrder(member,orderDTO);
        orderRepository.save(orders);
        return orders.getId();
    }

    @Override
    @Transactional
    public void makeOrderItem(Long itemId, Long memberId,Long orderId, int count) {
        Item item = itemRepository.getById(itemId);
        Member member = memberRepository.findMemberById(memberId);
        Optional<Orders> result = orderRepository.findById(orderId);
        Orders orders = result.get();

        Optional<OrderItem> itemResult = orderItemRepository.findByOrdersIdAndItemId(orderId,itemId);

        if (itemResult.isPresent()){
            OrderItem orderItem = itemResult.get();
            orderItem.addCount(count);
            orderItemRepository.save(orderItem);
        }else {
            OrderItem orderItem = OrderItem.createOrderItem(item,count);
            orderItem.setOrders(orders);
            orderItemRepository.save(orderItem);
        }
    }

    @Override
    @Transactional
    public void completeOrder(Long orderId) {
        Optional<Orders> result = orderRepository.findById(orderId);
        Orders orders =  result.get();
        Member member = memberRepository.findMemberById(orders.getMember().getId());

        CompleteOrder completeOrder = new CompleteOrder();
        completeOrder.setMember(member);
        completeOrder.setName(orders.getName());
        completeOrder.setAddress(orders.getAddress());
        completeOrder.setPhoneNumber(orders.getPhoneNumber());
        completeOrder.setStatus(OrderStatus.ORDER);
        completeOrder.setTotalPrice(orders.getTotalPrice());
        completeRepository.save(completeOrder);

        for (OrderItem orderItems : orders.getOrderItems()) {
            orderItemRepository.deleteById(orderItems.getId());
        }
        orderRepository.deleteById(orders.getId());
    }

    @Override
    public List<OrderItem> getItemList(Long memberId) {
        Member result = memberRepository.findMemberById(memberId);
        Optional<Orders> ordersOptional = orderRepository.findByMemberId(result.getId());
        Orders orders = ordersOptional.get();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItem orderItem : orders.getOrderItems()) {
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    @Transactional
    // 추가설정 필요
    public void cancelOrder(Long orderId){
        Optional<Orders> result = orderRepository.findById(orderId);
        Orders orders =  result.get();
        Member member = memberRepository.findMemberById(orders.getMember().getId());


        CompleteOrder completeOrder = new CompleteOrder();
        completeOrder.setMember(member);
        completeOrder.setName(orders.getName());
        completeOrder.setAddress(orders.getAddress());
        completeOrder.setPhoneNumber(orders.getPhoneNumber());
        completeOrder.setStatus(OrderStatus.CANCEL);
        completeOrder.setTotalPrice(orders.getTotalPrice());
        completeRepository.save(completeOrder);

        orders.cancel();
        for (OrderItem orderItems : orders.getOrderItems()) {
            orderItemRepository.deleteById(orderItems.getId());
        }
        orderRepository.deleteById(orders.getId());
    }




}

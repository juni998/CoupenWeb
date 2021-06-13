package com.group6.demo.service;

import com.group6.demo.entity.order.OrderDTO;

public interface OrderService {

    Long makeOrder(Long memberId, OrderDTO orderDTO);
    void makeOrderItem(Long itemId, Long memberId,Long orderId,int count);
    void completeOrder(Long orderId);

}

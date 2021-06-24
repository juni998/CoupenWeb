package com.group6.demo.service;

import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.OrderItem;

import java.util.List;

public interface OrderService {

    Long makeOrder(Long memberId, OrderDTO orderDTO);
    void makeOrderItem(Long itemId, Long memberId,Long orderId,int count);
    void completeOrder(Long orderId);
    List<OrderItem> getItemList(Long memberId);
    void cancelOrder(Long orderId);
}

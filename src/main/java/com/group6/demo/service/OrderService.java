package com.group6.demo.service;

import com.group6.demo.entity.order.Address;
import com.group6.demo.entity.order.Orders;

public interface OrderService {

    public Orders makeOrder(String account, Long itemId, Address address, int count);
}

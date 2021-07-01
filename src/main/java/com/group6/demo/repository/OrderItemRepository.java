package com.group6.demo.repository;

import com.group6.demo.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findByOrdersIdAndItemId(Long orderId, Long itemId);
}

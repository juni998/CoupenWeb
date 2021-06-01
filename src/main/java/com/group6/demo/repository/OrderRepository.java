package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findById(Member memberByAccount);
}

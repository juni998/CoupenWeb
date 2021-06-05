package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Transactional(readOnly = true)
    Optional<Orders> findById(Member memberByAccount);
}

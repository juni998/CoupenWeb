package com.group6.demo.repository;

import com.group6.demo.entity.order.CompleteOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompleteRepository extends JpaRepository<CompleteOrder, Long> {


}

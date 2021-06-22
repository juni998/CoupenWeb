package com.group6.demo.repository;

import com.group6.demo.entity.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long>, QuerydslPredicateExecutor {

    Optional<Item> findById(Long ItemId);

    Page<Item> findByType(String type, Pageable pageable);

    List<Item> findByTitleContaining(String title);
}

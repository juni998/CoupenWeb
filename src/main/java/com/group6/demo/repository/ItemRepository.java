package com.group6.demo.repository;

import com.group6.demo.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Optional<Item> findById(Long ItemId);

}

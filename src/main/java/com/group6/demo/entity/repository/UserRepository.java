package com.group6.demo.entity.repository;

import com.group6.demo.entity.login.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {
}

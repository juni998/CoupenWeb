package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional findByAccount(String account);
}

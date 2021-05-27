package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByAccount(String account);

    @Query("select m from Member m where m.account = :account")
    Member findMemberByAccount(String account);



}

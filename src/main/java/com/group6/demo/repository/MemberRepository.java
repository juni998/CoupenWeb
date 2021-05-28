package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByAccount(String account);

    @Query("select m from Member m where m.account = :account")
    Member findMemberByAccount(@Param("account") String account);

    Member findMemberByName(String name);


}

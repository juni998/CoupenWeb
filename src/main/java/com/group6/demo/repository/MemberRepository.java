package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional(readOnly = true)
    Optional<Member> findByAccount(String account);


    @EntityGraph(attributePaths = {"account"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.account = :account")
    Member findMemberByAccount(@Param("account") String account);



    @Transactional(readOnly = true)
    Member findMemberByName(String name);
    @Transactional(readOnly = true)
    Member findMemberByEmail(String email);
    @Transactional(readOnly = true)
    Member findMemberById(Long id);
    boolean existsByAccount(String account);
    boolean existsByEmail(String email);
}

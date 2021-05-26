package com.group6.demo.repository;

import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("from Role where name=:name")
    Role findByName(@Param("name") String name);
}
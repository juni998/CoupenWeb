package com.group6.demo.repository;

import com.group6.demo.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "from User where username=:username")
    User findByUsername(@Param("username") String username);
}

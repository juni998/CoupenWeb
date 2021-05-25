package com.group6.demo.entity.repository;

import com.group6.demo.entity.login.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void makeUserDummies() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i ->{
            Member member= Member.builder()
                    .name("dummies" + i)
                    .id("User"+i)
                    .pw("Pw"+ i)
                    .build();

            userRepository.save(member);
        });
    }

}
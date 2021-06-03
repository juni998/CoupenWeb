package com.group6.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private MemberServiceImpl memberService;
    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void findID() throws Exception{
        //given
        memberService.findMemberByName()
        //when

        //then
     }

}
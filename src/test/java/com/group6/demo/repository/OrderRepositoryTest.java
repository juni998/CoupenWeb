package com.group6.demo.repository;

import com.group6.demo.entity.order.Orders;
import com.group6.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;


    @Test
    public void saveOrder() throws Exception {
    }



    @Test
    public void findOrderByAccount() throws Exception{
        //given
        String orderAccount = "accout2";
        //when
        List<Orders> order = orderRepository.findByMemberAccount(orderAccount);
        //then
        for (Orders orders: order) {
            System.out.println("orders.get = " + orders.getId());
            System.out.println("orders.get = " + orders.getName());
            System.out.println("orders.get = " + orders.getPhoneNumber());
        }
     }


}
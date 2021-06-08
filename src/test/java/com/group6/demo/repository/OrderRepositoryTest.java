package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.entity.order.Address;
import com.group6.demo.entity.order.OrderStatus;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

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
        Member member = memberRepository.findMemberByAccount("Saccout");

        Address address = new Address("Tcity3","Tstreet23","Tzip23");
        Orders orders = new Orders();
        orders.setName("Tname3");
        orders.setMember(member);
        orders.setPhoneNumber("111-11123");
        orders.setAddress(address);
        orders.setOrderDate(LocalDateTime.now());
        orders.setStatus(OrderStatus.ORDER);

        orderRepository.save(orders);
        System.out.println(member.toString());
        System.out.println(orders.toString());
    }

    @Test
    private void createMember() {
        MemberDTO member = new MemberDTO();
        member.setName("Kim Ju");
        member.setAccount("Saccout");
        member.setEmail("adf123");
        member.setPassword("12334");

        memberService.save(member);
    }
}
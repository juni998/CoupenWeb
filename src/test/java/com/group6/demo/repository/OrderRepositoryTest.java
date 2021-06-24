package com.group6.demo.repository;

import com.group6.demo.entity.order.OrderItem;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    OrderItemRepository orderItemRepository;


    @Test
    public void orderItem() throws Exception {
        Optional<OrderItem> orderItem = orderItemRepository.findByOrdersIdAndItemId(1L,7L);

        if (orderItem.isPresent()){
            System.out.println(" 실행했음" );
        }else {
            System.out.println("안했음");
        }
        
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
package com.group6.demo.service;

import com.group6.demo.entity.order.Address;
import com.group6.demo.entity.order.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    MemberServiceImpl memberService;
    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void findID() throws Exception{
        //given
        String account ="SAccount88";
        OrderDTO orderDTO = new OrderDTO("testName","testPhone","testAddress","testStreet","testZipcode");



        Address address =  new Address("testCity","testStreet","testZipcode");
        //when
        Orders orders = orderService.makeOrder(account,1L,address,3);
        //then
        orders.toString();

     }

}
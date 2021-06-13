package com.group6.demo.service;

import com.group6.demo.entity.order.Address;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.OrderItemRepository;
import com.group6.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTests {

    @Autowired
    OrderService orderService;

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void makeOrder() throws Exception{
        OrderDTO orderDTO = OrderDTO.builder()
                .name("testOrder")
                .phoneNumber("111-123123-123123")
                .address(new Address("123","123","123")).build();

        Long id = orderService.makeOrder(1L,orderDTO);

        orderService.completeOrder(id);

    }

    @Test
    public void makeOrderItem() throws Exception{
        orderService.makeOrderItem(1L,1L,33L,4);
    }

}


//    @Test
//    public void OrderStatusTest2() throws Exception{
//        List<Orders> orders = orderRepository.findOrderByOrderStatus();
//
//        for (Orders result : orders) {
//            System.out.println(result.getId());
//            System.out.println(result.getPhoneNumber());
//            System.out.println(result.getName());
//            System.out.println(result.getMember().getId());
//            System.out.println("=====End First ====");
//        }
//    }



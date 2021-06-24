package com.group6.demo.service;

import com.group6.demo.entity.order.CompleteOrder;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.OrderItem;
import com.group6.demo.repository.CompleteRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceTests {

    @Autowired
    OrderService orderService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CompleteRepository completeRepository;



    @Test
    public void OrderItemTest() throws Exception{
        List<OrderItem> result = orderService.getItemList(1L);
        System.out.println("result.getClass() = " + result.getClass());
        for (OrderItem orderItem: result) {
            System.out.println("=========================");
            System.out.println("orderItem.get = " + orderItem.getItemName());
            System.out.println("orderItem.get = " + orderItem.getId());
            System.out.println("orderItem.get = " + orderItem.getPrice());
            System.out.println("orderItem.get = " + orderItem.getCount());
        }

    }



    @Test
    public void complete() throws Exception{
        //given
        List<CompleteOrder> list= completeRepository.findByMemberId(2L);
        //when
        for (CompleteOrder completeOrder :
                list) {
            System.out.println("completeOrder.get = " + completeOrder.getName());
            System.out.println("completeOrder.get = " + completeOrder.getOrderDate());
            System.out.println("completeOrder.get = " + completeOrder.getPhoneNumber());
        }
        //then
     }

    @Test
    public void makeOrder() throws Exception{
        OrderDTO orderDTO = OrderDTO.builder()
                .name("testOrder")
                .phoneNumber("111-123123-123123").build();
        Long id = orderService.makeOrder(1L,orderDTO);

        orderService.completeOrder(id);

    }

    @Test
    public void makeOrderItem() throws Exception{
        orderService.makeOrderItem(4L,2L,31L,4);
    }




    @Test
    public void sdf() throws Exception{
       orderService.completeOrder(31L);
     }
    @Test
    public void OrderCancel() throws Exception{
        //given
        orderService.cancelOrder(2L);
        //when

        //then
    }

}




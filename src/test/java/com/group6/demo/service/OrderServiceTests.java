package com.group6.demo.service;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.entity.order.Orders;
import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderItemRepository;
import com.group6.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.stream.IntStream.rangeClosed;

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
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    public void MakeDummies() throws Exception{

         rangeClosed(1,30).forEach(i ->{
             MemberDTO memberDTO = new MemberDTO();
             memberDTO.setEmail("test"+i);
             memberDTO.setName("testname"+i);
             memberDTO.setPassword("1234");
             memberDTO.setAccount("accout"+i);
             Long result = memberService.save(memberDTO);
             Orders orders = new Orders();
             orders.setMember(memberRepository.findMemberById((long)i));
             System.out.println("result = " + result);
          });

        rangeClosed(1,30).forEach(i ->{
            Item item =Item.builder()
                    .stock((int) (Math.random() *150+1))
                    .price((int) ((Math.random() *20+1)*100))
                    .thumbImg("testImg"+i)
                    .writer("writer"+i)
                    .content("testcontent"+i)
                    .title("testTitle"+i)
                    .type("A")
                    .build();
            itemRepository.save(item);
        });
        rangeClosed(1,30).forEach(i ->{
            Item item =Item.builder()
                    .stock((int) (Math.random() *150+1))
                    .price((int) ((Math.random() *20+1)*100))
                    .thumbImg("testImg"+i)
                    .writer("writer"+i)
                    .content("testcontent"+i)
                    .title("testTitle"+i)
                    .type("B")
                    .build();

            itemRepository.save(item);
        });

        for (int i = 1; i <= 200; i++) {
            orderService.makeOrderItem((long) (Math.random() * 60 + 1),(long) (Math.random() * 10 + 1) , (long) (Math.random() *5 + 1), (int) (Math.random() *3 + 1));
        }

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



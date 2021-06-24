package com.group6.demo.dummies;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.entity.order.OrderDTO;
import com.group6.demo.repository.ItemRepository;
import com.group6.demo.repository.MemberRepository;
import com.group6.demo.repository.OrderItemRepository;
import com.group6.demo.repository.OrderRepository;
import com.group6.demo.service.MemberService;
import com.group6.demo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.stream.IntStream.rangeClosed;

@SpringBootTest
public class DummyTest {

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
    @Autowired
    OrderService orderService;


    @Test
    public void MakeDummies1() throws Exception {

        rangeClosed(1, 30).forEach(i -> {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setEmail("test" + i);
            memberDTO.setName("testname" + i);
            memberDTO.setPassword("1234");
            memberDTO.setAccount("accout" + i);
            Long result = memberService.save(memberDTO);
            System.out.println("result = " + result);

        });

    }

    @Test
    public void MakeDummies2() throws Exception {
        rangeClosed(1, 30).forEach(i -> {
            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setCity("testCity"+i);
            orderDTO.setPhoneNumber("testPhoneNumber"+i);
            orderDTO.setZipcode("testZipcode"+i);
            orderDTO.setStreet("testStreet"+i);
            orderDTO.setName("testOrderName" + i);
            orderService.makeOrder((long)i,orderDTO);
        });
    }

    @Test
    public void MakeDummies3() throws Exception {
        rangeClosed(1, 30).forEach(i -> {
            Item item = Item.builder()
                    .stock((int) (Math.random() * 1500 + 1))
                    .price((int) ((Math.random() * 20 + 1) * 100))
                    .thumbImg("testImg" + i)
                    .writer("writer" + i)
                    .content("testcontent" + i)
                    .title("testTitle" + i)
                    .type("meet")
                    .build();

            itemRepository.save(item);
        });
        rangeClosed(1, 30).forEach(i -> {
            Item item = Item.builder()
                    .stock((int) (Math.random() * 1500 + 1))
                    .price((int) ((Math.random() * 20 + 1) * 100))
                    .thumbImg("testImg" + i)
                    .writer("writer" + i)
                    .content("testcontent" + i)
                    .title("testTitle" + i)
                    .type("vegetable")
                    .build();

            itemRepository.save(item);
        });
        rangeClosed(1, 30).forEach(i -> {
            Item item = Item.builder()
                    .stock((int) (Math.random() * 1500 + 1))
                    .price((int) ((Math.random() * 20 + 1) * 100))
                    .thumbImg("testImg" + i)
                    .writer("writer" + i)
                    .content("testcontent" + i)
                    .title("testTitle" + i)
                    .type("grain")
                    .build();

            itemRepository.save(item);
        });
    }

    @Test
    public void MakeDummies4() throws Exception {

        for (int i = 1; i <= 200; i++) {
            orderService.makeOrderItem((long) (Math.random() * 60 + 1), (long) (Math.random() * 10 + 1), (long) (Math.random() * 5 + 1), 1);
        }
    }

}


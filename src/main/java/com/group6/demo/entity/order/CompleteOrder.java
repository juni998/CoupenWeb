package com.group6.demo.entity.order;

import com.group6.demo.entity.login.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompleteOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompleteOrder_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;
    private String phoneNumber;
    private Address address;

    private LocalDateTime orderDate;
    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}

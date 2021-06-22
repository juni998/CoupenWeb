package com.group6.demo.entity.order;

import com.group6.demo.entity.login.Member;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime orderDate;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}

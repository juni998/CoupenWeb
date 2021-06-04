package com.group6.demo.entity.order;

import com.group6.demo.entity.login.Member;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter  //
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private String name;

    private String phoneNumber;

    private Address address;

    @CreatedDate
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrders(this);
    }

    public static Orders createOrder(Member member,Address address, OrderItem... orderItems){
        Orders orders = new Orders();
        orders.setMember(member);
        orders.setAddress(address);
        for (OrderItem orderItem : orderItems){
            orders.addOrderItem(orderItem);
        }
        orders.setStatus(OrderStatus.ORDER);
        orders.setOrderDate(LocalDateTime.now());
        return orders;
    }
}


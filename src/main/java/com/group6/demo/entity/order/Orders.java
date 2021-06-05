package com.group6.demo.entity.order;

import com.group6.demo.entity.login.Member;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter  //
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

//    @OneToMany(mappedBy = "orders")
//    private List<OrderItem> orderItems = new ArrayList<>();
    private String name;
    private String phoneNumber;
    private Address address;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        member.getOrders().add(this);
        this.member = member;
    }

//    public void addOrderItem(OrderItem orderItem){
//        orderItems.add(orderItem);
//        orderItem.setOrders(this);
//    }

//    public static Orders createOrder(Member member,Address address, OrderItem... orderItems){
//        Orders orders = new Orders();
//        orders.setMember(member);
//        orders.setAddress(address);
//        for (OrderItem orderItem : orderItems){
//            orders.addOrderItem(orderItem);
//        }
//        orders.setStatus(OrderStatus.ORDER);
//        orders.setOrderDate(LocalDateTime.now());
//        return orders;
//    }
}


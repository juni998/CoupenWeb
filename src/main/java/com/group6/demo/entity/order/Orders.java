package com.group6.demo.entity.order;

import com.group6.demo.entity.login.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter  //
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@EntityListeners(AuditingEntityListener.class)
public class Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private String name;
    private String phoneNumber;
    private Address address;

    @CreatedDate
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime orderDate;

    public void setMember(Member member){
        this.member = member;
        member.setOrders(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrders(this);
    }

    public static Orders createOrder(Member member,OrderDTO orderDTO){
        Orders orders = new Orders();
        orders.setMember(member);
        orders.setName(orderDTO.getName());
        orders.setAddress(new Address(orderDTO.getCity(),orderDTO.getStreet(),orderDTO.getZipcode()));
        orders.setPhoneNumber(orderDTO.getPhoneNumber());
        orders.setOrderDate(LocalDateTime.now());

        System.out.println(" createOrder order"+ orders.toString());
        return orders;
    }

    public void cancel(){
        for (OrderItem orderItem : orderItems) {
            orderItem.cancelItem();
        }
    }
    public int getTotalPrice(){
        return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
    }
}


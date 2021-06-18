package com.group6.demo.entity.login;

import com.group6.demo.entity.order.CompleteOrder;
import com.group6.demo.entity.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {

    @Id // !
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String account; // username

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "member")
    private Orders orders;

    @OneToMany(mappedBy = "member")
    private List<CompleteOrder> completeOrders = new ArrayList<>();

    public void changePassword(String password) {
        this.password = password;
    }
}

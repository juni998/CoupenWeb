package com.group6.demo.entity.login;

import com.group6.demo.entity.order.Orders;
import lombok.*;

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

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<>();


    public void changePassword(String password) {
        this.password = password;
    }
}

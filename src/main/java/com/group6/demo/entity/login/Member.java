package com.group6.demo.entity.login;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String account;

    @Column(length = 255, nullable = false)
    private String email;

    public Member(Long id, String name, String password, String account, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.account = account;
        this.email = email;
    }
}

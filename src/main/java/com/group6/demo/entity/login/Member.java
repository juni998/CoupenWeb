package com.group6.demo.entity.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NamedEntityGraph
@Getter
@ToString()
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;
    private String id;
    private String pw;

    @Embedded
    private Address address;
}

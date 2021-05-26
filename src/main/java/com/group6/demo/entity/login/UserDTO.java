package com.group6.demo.entity.login;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String firstName;

    private String email;
    private List<String> roles;
}

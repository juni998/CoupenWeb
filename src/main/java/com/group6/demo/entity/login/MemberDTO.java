package com.group6.demo.entity.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private Long id;
    private String account;
    private String name;
    private String password;
    private String email;

    public Member toEntity() {
        return new  Member( id,  name,  password,  account, email);
    }
}

package com.group6.demo.entity.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long id;


    @NotBlank(message="필수 입력 값 입니다")
    private String account;
    @NotBlank(message="필수 입력 값 입니다")
    private String name;
    @NotBlank(message="필수 입력 값 입니다")
    private String password;
    @NotBlank(message="필수 입력 값 입니다")
    private String email;

}

package com.group6.demo.entity.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public Member toEntity() {
        return new  Member( id,  name,  password,  account, email);
    }
}

package com.group6.demo.security;

import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

    private final MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(MemberDTO.class);   // 어떤 타입의 인스턴스를 검증을 할 것인가?
    }

    @Override
    public void validate(Object o, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) o;
        if(memberRepository.existsByEmail(memberDTO.getEmail())){
            errors.rejectValue("email","invalid email","이미 사용중인 이메일입니다.");
        }
    }
}
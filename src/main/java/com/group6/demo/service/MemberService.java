package com.group6.demo.service;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    void changeAllByAccount(String account);
    void changePasswordByAccount(String account,String newPassword);
    Long save(MemberDTO memberDTO);
    Member findMemberByName(String name); // 쓰지말것
    Boolean checkAccountValidate(String account); // false면 아이디가존재


}

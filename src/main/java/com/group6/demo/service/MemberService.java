package com.group6.demo.service;

import com.group6.demo.entity.login.MemberDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    Long save(MemberDTO memberDTO);
}

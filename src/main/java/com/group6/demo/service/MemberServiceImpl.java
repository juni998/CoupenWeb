package com.group6.demo.service;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import com.group6.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    @Override
    public void changePasswordByAccount(String account,String newPassword){
        Member member = memberRepository.findMemberByAccount(account);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.changePassword(passwordEncoder.encode(newPassword));
    }



    @Override
    @Transactional
    public Long save(MemberDTO memberDTO) {
        Member member = memberDTO.toEntity();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public Member findMemberByName(String name) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Optional memberEntityWrapper = memberRepository.findByAccount(account);
        Member member = (Member) memberEntityWrapper.orElse(null);

        List authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        return new User(member.getAccount(), member.getPassword(), authorities);
    }
}

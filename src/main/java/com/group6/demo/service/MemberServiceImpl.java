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


    @Override
    @Transactional
    public void changeAllByAccount(MemberDTO memberDTO) {
        Member member = memberRepository.findMemberByAccount(memberDTO.getAccount());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));

        member.setName(memberDTO.getName());
        member.setEmail(member.getEmail());
        member.setPassword(member.getPassword());


        memberRepository.flush();
    }

    @Override
    @Transactional
    public Long save(MemberDTO memberDTO) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        Member member = new Member();

        member.setAccount(memberDTO.getAccount());
        member.setName(member.getName());
        member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        member.setEmail(member.getEmail());

        memberRepository.save(member);
        return member.getId();
    }



    @Transactional
    @Override
    public void changePasswordByAccount(String account,String newPassword){
        Member member = memberRepository.findMemberByAccount(account);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.changePassword(passwordEncoder.encode(newPassword));
    }



    @Override
    public Member findMemberByName(String name) {
        Member member = memberRepository.findMemberByName(name);

        if(member == null){
            new NullPointerException("Null member");
        }
        return member;
    }

    @Override
    public Boolean checkAccountValidate(String account) {
        try {
            Member member = memberRepository.findMemberByAccount(account);
            String rawName  = member.getAccount();
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Optional memberEntityWrapper = memberRepository.findByAccount(account);
        Member member = (Member) memberEntityWrapper.orElse(null);

        List authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER")); // Member

        return new User(member.getAccount(), member.getPassword(), authorities);

    }
}

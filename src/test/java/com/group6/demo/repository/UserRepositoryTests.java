package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserRepositoryTests {

    @Autowired
    MemberRepository memberRepository;



//    @Test
//    public void makeDummies() throws Exception{
//        IntStream.rangeClosed(1,100).forEach(i ->{
//            Member member = Member.builder()
//                    .name("testName"+i)
//                    .account("testAccount"+i)
//                    .password("1234")
//                    .email("test"+i+"coupeng.org")
//                    .build();
//            memberRepository.save(member);
//        });
//    }


    @Test
    public void save() throws Exception{
        for (int i=0; i<200; i++) {
            Member member = new Member();
            member.setEmail("test"+i);
            member.setName("name"+i);
            member.setPassword("1234");
            member.setAccount("account"+i);
            memberRepository.save(member);
        }
     }
    @Test
    public void saveSeller() throws Exception{
        for (int i=0; i<200; i++) {
            Member member = new Member();
            member.setEmail("test"+i);
            member.setName("saveSeller"+i);
            member.setPassword("1234");
            member.setAccount("account"+i);
            memberRepository.save(member);
        }
    }

    @Test
    public void find_ID() throws Exception{
        String rawAccount = memberRepository.findMemberById(1L).getAccount();

        Member member = memberRepository.findMemberByAccount(rawAccount);

        Assertions.assertThat(member.getName()).isEqualTo("Sname2");
    }



    @Test
    public void Optional() throws Exception{
        Optional<Member> result = memberRepository.findById(1L);

        Member member = result.get();

        Assertions.assertThat(member.getAccount()).isEqualTo("SAccount1");
    }

    @Test
    public void find_NAME() throws Exception{
        String rawName =  memberRepository.findMemberById(1L).getName();

        Member member = memberRepository.findMemberByName(rawName);

        Assertions.assertThat(member.getName()).isEqualTo("Sname4");
    }



    @Test
    public void getOPTIONAL() throws Exception{
        String rawAccount =  memberRepository.findMemberById(1L).getAccount();

        Optional<Member> result = memberRepository.findByAccount(rawAccount);
        Member member = result.get();

        Assertions.assertThat(member.getAccount()).isEqualTo("SAccount10");
    }



    @Test
    public void findEmail() throws Exception{
        String findEmail =  memberRepository.findMemberById(1L).getEmail();

        Member member = memberRepository.findMemberByEmail(findEmail);
        member.toString();

    }
    
    
    



}
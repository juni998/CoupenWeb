package com.group6.demo.repository;

import com.group6.demo.entity.login.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTests {

    @Autowired
    MemberRepository memberRepository;



    @Test
    @Rollback
    public void makeDummies() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i ->{
            Member member = Member.builder()
                    .name("testName"+i)
                    .account("testAccount"+i)
                    .password("1234")
                    .email("test"+i+"coupeng.org")
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void 아이디_찾기() throws Exception{
        String rawAccount = "testAccount3";

        Member member = memberRepository.findMemberByAccount(rawAccount);

        Assertions.assertThat(member.getName()).isEqualTo("testName3");
    }

    
    
    @Test
    public void Optional() throws Exception{
        Optional<Member> result = memberRepository.findById(1L);
        
        Member member = result.get();

        Assertions.assertThat(member.getAccount()).isEqualTo("testAccount1");
     }

    @Test
    public void 이름_찾기() throws Exception{
        String rawName = "testName4";

        Member member = memberRepository.findMemberByName(rawName);

        Assertions.assertThat(member.getAccount()).isEqualTo("testAccount4");
     }



     @Test
     public void 계정OPTIONAL로반환하기() throws Exception{
         String rawAccount = "test3";

         Optional<Member> result = memberRepository.findByAccount(rawAccount);
         Member member = result.get();

         Assertions.assertThat(member.getAccount()).isEqualTo("testAccount3");
      }



      @Test
      public void findEmail() throws Exception{
         String findemail = "test1coupeng.org";

         Member member = memberRepository.findMemberByEmail(findemail);
         member.toString();

       }


}
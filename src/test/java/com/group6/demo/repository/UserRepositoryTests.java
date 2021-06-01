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
//    @Rollback
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
    public void find_ID() throws Exception{
        String rawAccount = "SAccount2";

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
        String rawName = "Sname4";

        Member member = memberRepository.findMemberByName(rawName);

        Assertions.assertThat(member.getName()).isEqualTo("Sname4");
    }



    @Test
    public void getOPTIONAL() throws Exception{
        String rawAccount = "SAccount10";

        Optional<Member> result = memberRepository.findByAccount(rawAccount);
        Member member = result.get();

        Assertions.assertThat(member.getAccount()).isEqualTo("SAccount10");
    }



    @Test
    public void findEmail() throws Exception{
        String findemail = "SEmail9@coupeng.org";

        Member member = memberRepository.findMemberByEmail(findemail);
        member.toString();

    }


}
package com.group6.demo.service;

import com.group6.demo.entity.login.Member;
import com.group6.demo.entity.login.MemberDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static java.util.stream.IntStream.rangeClosed;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;



//    @Test
//    public void safeSave() throws Exception{
//        rangeClosed(1,100).forEach(i ->{
//            MemberDTO memberDTO =MemberDTO.builder()
//                    .account("SAccount"+i)
//                    .password("1234")
//                    .email("SEmail"+i+"@coupeng.org")
//                    .name("Sname"+i)
//                    .build();
//            memberService.save(memberDTO);
//        });
//    }
    
    
    
    @Test
    public void changePassword() throws Exception{
        String account = "SAccount3";
        String newPassword = "1111";

        memberService.changePasswordByAccount(account,newPassword);
     }



     
     @Test
     public void findMemberByNameTrue() throws Exception{
        String Saccount = "SAccount1";
        memberService.findMemberByName(Saccount);
      }

    @Test
    public void findMemberByNameFalse() throws Exception{
        String Saccount = "Account1";
        memberService.findMemberByName(Saccount);
    }



    @Test
    public void checkAccountValidateTrue() throws Exception{
        String SAccount = "Account1";

        Boolean aBoolean = memberService.checkAccountValidate(SAccount);

        Assertions.assertThat(false).isEqualTo(aBoolean);
     }

    @Test
    public void checkAccountValidateFalse() throws Exception{
        String SAccount = "SAccount1";

        Boolean aBoolean = memberService.checkAccountValidate(SAccount);

        Assertions.assertThat(true).isEqualTo(aBoolean);
    }

}
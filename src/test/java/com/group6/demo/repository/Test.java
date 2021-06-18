package com.group6.demo.repository;


import java.util.Optional;

public class Test {

    @org.junit.jupiter.api.Test
    public void gsd() throws Exception{
        Optional<String> sdfa = Optional.empty();//given

        if (sdfa.isPresent()){
            System.out.println("나오면 null아닌거");
            System.out.println("sdfa = " + sdfa);
        }else {
            System.out.println("나오면 null인거");
            System.out.println("sdfa = " + sdfa);
        }


        if (sdfa.isEmpty()){
            System.out.println("나오면 if");
            System.out.println("sdfa.get() = " + sdfa.get());
        }else {
            System.out.println("나오면 else");
            System.out.println("sdfa.get() = " + sdfa.get());
        }
        //when

        //then
    }
}

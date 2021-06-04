package com.group6.demo.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {
    private String name;
    private String phoneNumber;
    private String address;
    private String street;
    private String zipcode;

//    public Orders toEntity(){
//        return new Orders()
//    }
}

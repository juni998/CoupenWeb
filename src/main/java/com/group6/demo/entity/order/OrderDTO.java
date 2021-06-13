package com.group6.demo.entity.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDTO {
    private String name;
    private String phoneNumber;
    private Address address;


}

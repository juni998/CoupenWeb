package com.group6.demo.entity.order;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String name;
    private String phoneNumber;


    private String city;
    private String street;
    private String zipcode;


}

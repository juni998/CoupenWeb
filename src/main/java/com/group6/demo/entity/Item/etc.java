package com.group6.demo.entity.Item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("E")
public class etc extends Item{
    private String andSoOn;


}

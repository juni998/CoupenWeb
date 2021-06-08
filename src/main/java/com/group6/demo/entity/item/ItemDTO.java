package com.group6.demo.entity.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    private Long id;

    private String title;
    private int price;
    private int stock;
    private String content;

    private String writer;
    private String thumbImg;

    private LocalDateTime uploadDate;

}

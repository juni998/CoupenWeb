package com.group6.demo.entity.Item;

import com.group6.demo.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype")
public class Item  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "Item_id")
    private Long id;

    private String title;
    private int price;
    private int stockQuantity;
    private String content;

    private String img;
    private String thumbImg;
    private LocalDateTime orderDate;



    public void changeTitle(String title) {
        this.title = title;
    }
    public void changeContent(String content) {
        this.content = content;
    }
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
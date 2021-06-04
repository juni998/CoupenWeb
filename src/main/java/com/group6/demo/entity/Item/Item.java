package com.group6.demo.entity.Item;

import com.group6.demo.exception.NotEnoughStockException;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "dtype")
public abstract class Item  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "Item_id")
    private Long id;

    private String title;
    private int price;
    private int stock;
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
        this.stock += quantity;
    }
    public void removeStock(int quantity){
        int restStock = this.stock - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stock = restStock;
    }
}
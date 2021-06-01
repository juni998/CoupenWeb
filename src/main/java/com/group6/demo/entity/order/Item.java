package com.group6.demo.entity.order;

import com.group6.demo.exception.NotEnoughStockException;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype")
public class Item extends BaseEntity{

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
package com.group6.demo.entity.item;

import com.group6.demo.exception.NotEnoughStockException;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Item  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "Item_id")
    private Long id;

    private String title;
    private int price;
    private int stock;

    @Lob @Type(type = "org.hibernate.type.TextType")
    private String content;
    private String writer;
    private String thumbImg;

    private String type;

    @CreatedDate
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime uploadDate;




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
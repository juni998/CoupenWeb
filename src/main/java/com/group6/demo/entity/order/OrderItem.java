package com.group6.demo.entity.order;

import com.group6.demo.entity.item.Item;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Setter
@NoArgsConstructor
@Getter
@ToString()
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count;
    private int price;
    private String itemName;

    @ManyToOne(fetch = LAZY)
    private Orders orders;

    public static OrderItem createOrderItem(Item item, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItemName(item.getTitle());
        orderItem.setCount(count);
        orderItem.setPrice(item.getPrice());

        item.removeStock(count);
        return orderItem;
    }

    int getTotalPrice(){
        return getPrice() * getCount();
    }
}

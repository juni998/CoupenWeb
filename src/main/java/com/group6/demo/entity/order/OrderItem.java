package com.group6.demo.entity.order;

import com.group6.demo.entity.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Setter
@NoArgsConstructor
@Getter
@ToString()
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItem_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

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
        orderItem.setItem(item);

        item.removeStock(count);
        return orderItem;
    }

    int getTotalPrice(){
        return getPrice() * getCount();

    }
    public void cancelItem(){
        getItem().addStock(this.count);
    }


}

package com.group6.demo.entity.order;

import com.group6.demo.entity.Item.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Item item;


    private int price;
    private int count;

    public static OrderItem createOrderItem(Item item, int price, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setPrice(price);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    public void cancel(){
        getItem().addStock(count);
    }


    int getTotalPrice(){
        return getPrice() * getCount();
    }
}

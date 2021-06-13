package com.group6.demo.entity.order;

import javax.persistence.AttributeConverter;

public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus attribute) {
        if (attribute == null)
            return null;
        return null;
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        return null;
    }
}

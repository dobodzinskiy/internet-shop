package com.shop.entity;

/**
 * Created by dobodzinskiy on 30.03.2016.
 */
public enum OrderState {
    ACCEPTED("Accepted"),
    IN_PROGRESS("InProgress"),
    SHIPPED("SHIPPED"),
    DELIVERED("Delivered");

    private String value;

    OrderState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

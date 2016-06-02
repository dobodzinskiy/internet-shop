package com.shop.entity;

public enum OrderState {

    ACCEPTED("Accepted"),
    IN_PROGRESS("In progress"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered");

    private String value;

    OrderState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderState getEnum(String value) {
        for (OrderState v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }
}

package com.shop.entity;

/**
 * Created by dobodzinskiy on 29.03.2016.
 */
public enum ProductType {
    COMPUTERS("Computers"),
    PHONES("Phones"),
    LAPTOPS("Laptops");

    private String value;

    ProductType(String value) {
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

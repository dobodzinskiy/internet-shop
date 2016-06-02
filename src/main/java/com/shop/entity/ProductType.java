package com.shop.entity;

public enum ProductType {

    COMPUTERS("computers"),
    PHONES("phones"),
    LAPTOPS("laptops");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProductType getEnum(String value) {
        for (ProductType v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }

}

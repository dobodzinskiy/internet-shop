package com.shop.entity;

public enum SortType {

    NAME("name"),
    PRICE_DESC("priceDesc"),
    PRICE_ASC("priceAsc"),
    COMPANY("company");

    private String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SortType getEnum(String value) {
        for (SortType v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }

}

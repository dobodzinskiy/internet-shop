package com.shop.entity;

public enum UserRoles {

    ROLE_USER("user"),
    ROLE_ADMIN("admin"),
    ROLE_MANAGER("manager"),
    ROLE_MODERATOR("moderator");

    private String value;

    UserRoles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserRoles getEnum(String value) {
        for (UserRoles v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }
}

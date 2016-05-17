package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "laptops")
@NamedQueries({
        @NamedQuery(name = "getLaptops", query = "SELECT l from Laptop l"),
        @NamedQuery(name = "getLaptop", query = "SELECT l from Laptop l WHERE l.id = :id"),
})
public class Laptop extends Product{

    @Column(name = "keyboard_light")
    private boolean keyboardLight;

    public boolean isKeyboardLight() {
        return keyboardLight;
    }

    public void setKeyboardLight(boolean keyboardLight) {
        this.keyboardLight = keyboardLight;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "keyboardLight=" + keyboardLight +
                "} " + super.toString();
    }
}

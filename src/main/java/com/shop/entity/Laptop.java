package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "laptops")
@NamedQueries({
        @NamedQuery(name = "Laptop.getLaptops", query = "SELECT l from Laptop l"),
        @NamedQuery(name = "Laptop.getLaptopsByName", query = "SELECT l from Laptop l order by l.name"),
        @NamedQuery(name = "Laptop.getLaptopsByPriceDesc", query = "SELECT l from Laptop l order by l.price desc "),
        @NamedQuery(name = "Laptop.getLaptopsByPriceAsc", query = "SELECT l from Laptop l order by l.price asc"),
        @NamedQuery(name = "Laptop.getLaptopsByCompany", query = "SELECT l from Laptop l order by l.company"),
        @NamedQuery(name = "Laptop.getLaptop", query = "SELECT l from Laptop l WHERE l.id = :id"),
})
public class Laptop extends Product {

    @Column(name = "keyboard_light")
    private boolean keyboardLight;

    public boolean isKeyboardLight() {
        return keyboardLight;
    }

    public void setKeyboardLight(boolean keyboardLight) {
        this.keyboardLight = keyboardLight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        return keyboardLight == laptop.keyboardLight;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (keyboardLight ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "keyboardLight=" + keyboardLight +
                '}';
    }
}

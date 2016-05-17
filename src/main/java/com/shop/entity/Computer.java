package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by dobodzinskiy on 30.03.2016.
 */
@Entity
@Table(name = "computers")
@NamedQueries({
        @NamedQuery(name = "getComputers", query = "SELECT c from Computer c"),
        @NamedQuery(name = "getComputer", query = "SELECT c from Computer c WHERE c.id = :id"),
})
public class Computer extends Product{

    @Column(name = "motherboard")
    private String motherboard;

    @Column(name = "cooling_system")
    private String coolingSystem;

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "motherboard='" + motherboard + '\'' +
                ", coolingSystem='" + coolingSystem + '\'' +
                "} " + super.toString();
    }
}

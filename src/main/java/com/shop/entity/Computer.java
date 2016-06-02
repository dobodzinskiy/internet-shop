package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "computers")
@NamedQueries({
        @NamedQuery(name = "Computer.getComputers", query = "SELECT c from Computer c"),
        @NamedQuery(name = "Computer.getComputersByName", query = "SELECT c from Computer c order by c.name"),
        @NamedQuery(name = "Computer.getComputersByPriceDesc",
                query = "SELECT c from Computer c order by c.price desc "),
        @NamedQuery(name = "Computer.getComputersByPriceAsc", query = "SELECT c from Computer c order by c.price asc"),
        @NamedQuery(name = "Computer.getComputersByCompany", query = "SELECT c from Computer c order by c.company"),
        @NamedQuery(name = "Computer.getComputer", query = "SELECT c from Computer c WHERE c.id = :id"),
})
public class Computer extends Product {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Computer computer = (Computer) o;

        if (motherboard != null ? !motherboard.equals(computer.motherboard) : computer.motherboard != null) {
            return false;
        }

        return coolingSystem != null ? coolingSystem.equals(computer.coolingSystem) : computer.coolingSystem == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (motherboard != null ? motherboard.hashCode() : 0);
        result = 31 * result + (coolingSystem != null ? coolingSystem.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "motherboard='" + motherboard + '\'' +
                ", coolingSystem='" + coolingSystem + '\'' +
                '}';
    }
}

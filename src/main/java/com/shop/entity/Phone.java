package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "phones")
@NamedQueries({
        @NamedQuery(name = "Phone.getPhones", query = "SELECT p from Phone p"),
        @NamedQuery(name = "Phone.getPhonesByName", query = "SELECT p from Phone p order by p.name"),
        @NamedQuery(name = "Phone.getPhonesByPriceDesc", query = "SELECT p from Phone p order by p.price desc "),
        @NamedQuery(name = "Phone.getPhonesByPriceAsc", query = "SELECT p from Phone p order by p.price asc"),
        @NamedQuery(name = "Phone.getPhonesByCompany", query = "SELECT p from Phone p order by p.company"),
        @NamedQuery(name = "Phone.getPhone", query = "SELECT p from Phone p WHERE p.id = :id"),
})
public class Phone extends Product {

    @Column(name = "dual_sim")
    private boolean dualSim;

    @Column(name = "sim_type")
    private String simType;

    @Column(name = "message_type")
    private String messageType;

    public Phone() {
    }

    public boolean isDualSim() {
        return dualSim;
    }

    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Phone phone = (Phone) o;

        if (dualSim != phone.dualSim) return false;
        if (simType != null ? !simType.equals(phone.simType) : phone.simType != null) return false;
        return messageType != null ? messageType.equals(phone.messageType) : phone.messageType == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dualSim ? 1 : 0);
        result = 31 * result + (simType != null ? simType.hashCode() : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "dualSim=" + dualSim +
                ", simType='" + simType + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}

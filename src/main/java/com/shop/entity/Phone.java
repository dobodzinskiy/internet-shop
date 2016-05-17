package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "phones")
@NamedQueries({
        @NamedQuery(name = "getPhones", query = "SELECT p from Phone p"),
        @NamedQuery(name = "getPhone", query = "SELECT p from Phone p WHERE p.id = :id"),
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
    public String toString() {
        return "Phone{" +
                "simType='" + simType + '\'' +
                ", dualSim=" + dualSim +
                ", messageType='" + messageType + '\'' +
                "} " + super.toString();
    }
}

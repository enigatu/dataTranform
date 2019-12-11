package com.example.jsonbmodel.domain;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"name", "shippingAddress", "billingAddress", "loyalty"})
public class Customer {
    private String name;
    private Address shippingAddress;
    private Address billingAddress;
    private Loyalty loyalty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Loyalty getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }
}

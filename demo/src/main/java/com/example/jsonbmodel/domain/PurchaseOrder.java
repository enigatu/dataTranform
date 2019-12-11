package com.example.jsonbmodel.domain;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;

import com.example.jsonbmodel.jsonbservice.ItemMapAdapter;

import java.util.List;
import java.util.Map;

@JsonbPropertyOrder({"customer", "items", "comment"})
public class PurchaseOrder {

    @JsonbTypeAdapter(ItemMapAdapter.class)
    private Map<String, Item> items;

    private Customer customer;
    private String comment;

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

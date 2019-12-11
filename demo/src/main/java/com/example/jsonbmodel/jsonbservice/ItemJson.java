package com.example.jsonbmodel.jsonbservice;

import javax.json.bind.annotation.JsonbPropertyOrder;

import com.example.jsonbmodel.domain.Item;

@JsonbPropertyOrder({"productCode", "item"})
public class ItemJson {
    private String productCode;
    private Item item;

    public ItemJson() {
        this.item = new Item();
    }

    public ItemJson(String productCode, Item item) {
        this.productCode = productCode;
        this.item = item;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

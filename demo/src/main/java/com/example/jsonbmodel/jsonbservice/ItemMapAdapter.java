package com.example.jsonbmodel.jsonbservice;

import javax.json.bind.adapter.JsonbAdapter;

import com.example.jsonbmodel.domain.Item;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemMapAdapter implements JsonbAdapter<Map<String, Item>, List<ItemJson>> {

    @Override
    public List<ItemJson> adaptToJson(Map<String, Item> map) throws Exception {
        return map.entrySet().stream()
                .map(entry -> new ItemJson(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Item> adaptFromJson(List<ItemJson> list) throws Exception {
        return list.stream()
                .collect(Collectors.toMap(ItemJson::getProductCode, ItemJson::getItem));
    }
}

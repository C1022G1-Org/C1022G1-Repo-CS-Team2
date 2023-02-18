package com.example.iphone_store.service;

import com.example.iphone_store.model.Accessory;

import java.util.List;

public interface IAccessoryService {
    List<Accessory> listAll(String accessoryName);

}

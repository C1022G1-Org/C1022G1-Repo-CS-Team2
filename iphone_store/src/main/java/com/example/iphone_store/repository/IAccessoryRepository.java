package com.example.iphone_store.repository;

import com.example.iphone_store.model.Accessory;

import java.util.List;

public interface IAccessoryRepository {
    List<Accessory> listAll(String accessoryName);

}

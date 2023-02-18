package com.example.iphone_store.service.impl;

import com.example.iphone_store.model.Accessory;
import com.example.iphone_store.repository.IAccessoryRepository;
import com.example.iphone_store.repository.impl.AccessoryRepository;
import com.example.iphone_store.service.IAccessoryService;

import java.util.List;

public class AccessoryService implements IAccessoryService {
    IAccessoryRepository iAccessoryRepository = new AccessoryRepository();
    @Override
    public List<Accessory> listAll(String accessoryName) {
        if (accessoryName == null){
            accessoryName = "";
        }
        return iAccessoryRepository.listAll(accessoryName);
    }
}

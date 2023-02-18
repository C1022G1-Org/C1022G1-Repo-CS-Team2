package com.example.iphone_store.service.impl;

import com.example.iphone_store.model.Iphone;
import com.example.iphone_store.repository.IIphoneRepository;
import com.example.iphone_store.repository.impl.IphoneRepository;
import com.example.iphone_store.service.IIphoneService;

import java.util.List;

public class IphoneService implements IIphoneService {
    IIphoneRepository iIphoneRepository = new IphoneRepository();
    @Override
    public List<Iphone> listAll(String iphoneName) {
        if (iphoneName == null){
            iphoneName = "";
        }
        return iIphoneRepository.listAll(iphoneName);
    }
}

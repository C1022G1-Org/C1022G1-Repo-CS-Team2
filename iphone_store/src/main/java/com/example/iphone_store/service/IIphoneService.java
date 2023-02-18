package com.example.iphone_store.service;

import java.util.List;
import com.example.iphone_store.model.Iphone;
public interface IIphoneService {
    List<Iphone> listAll(String iphoneName);
}

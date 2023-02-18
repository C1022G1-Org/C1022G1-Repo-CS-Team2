package com.example.iphone_store.repository;



import com.example.iphone_store.model.Iphone;

import java.util.List;

public interface IIphoneRepository {
    List<Iphone> listAll(String iphoneName);

}

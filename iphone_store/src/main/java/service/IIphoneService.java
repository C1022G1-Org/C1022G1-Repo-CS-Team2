package service;

import model.Iphone;

import java.util.List;

public interface IIphoneService {
    List<Iphone> listAll(String iphoneName);
    void delete (int id);
    Iphone findById(int id);
}

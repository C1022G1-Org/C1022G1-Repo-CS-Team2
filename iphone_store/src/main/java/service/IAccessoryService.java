package service;

import model.Accessory;

import java.util.List;

public interface IAccessoryService {
    List<Accessory> listAll(String accessoryName);

}

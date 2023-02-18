package service.impl;

import model.Accessory;
import repository.IAccessoryRepository;
import repository.impl.AccessoryRepository;
import service.IAccessoryService;

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

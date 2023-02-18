package repository;

import model.Accessory;

import java.util.List;

public interface IAccessoryRepository {
    List<Accessory> listAll(String accessoryName);

}

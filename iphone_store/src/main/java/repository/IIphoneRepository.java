package repository;

import model.Iphone;



import java.util.List;


public interface IIphoneRepository {
    List<Iphone> listAll(String iphoneName);

}

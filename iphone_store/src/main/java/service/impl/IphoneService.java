package service.impl;

import model.Iphone;
import repository.IIphoneRepository;
import repository.impl.IphoneRepository;
import service.IIphoneService;

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
    @Override
    public boolean inserIphone(Iphone iphone) {
        return this.iIphoneRepository.inserUser(iphone);
    }
}

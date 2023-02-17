package repository.impl;

import model.Iphone;
import repository.IIphoneRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IphoneRepository implements IIphoneRepository {
    private static final String LIST_ALL = "select sp.id, lsp.ten_loai_san_pham, sp.ten_san_pham, sp.nha_cung_cap,\n" +
            " sp.hinh_anh, sp.gia, sp.so_luong from san_pham sp join loai_san_pham lsp on sp.id_loai_san_pham =\n" +
            " lsp.id_loai_san_pham" + " where sp.ten_san_pham like concat('%', ?, '%') and sp.id_loai_san_pham = 1";

    @Override
    public List<Iphone> listAll(String iphoneName) {
        List<Iphone> iphoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(LIST_ALL);
            preparedStatement.setString(1,iphoneName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Iphone iphone;
            while (resultSet.next()){
                iphone = new Iphone();
                iphone.setId(resultSet.getInt("sp.id"));
                iphone.setProductName(resultSet.getString("lsp.ten_loai_san_pham"));
                iphone.setIphoneName(resultSet.getString("sp.ten_san_pham"));
                iphone.setSupplier(resultSet.getString("sp.nha_cung_cap"));
                iphone.setPhoto(resultSet.getString("sp.hinh_anh"));
                iphone.setPrice(resultSet.getDouble("sp.gia"));
                iphone.setQuantity(resultSet.getInt("sp.so_luong"));
                iphoneList.add(iphone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return iphoneList;
    }
}

package com.example.iphone_store.repository.impl;

import com.example.iphone_store.model.Accessory;
import com.example.iphone_store.repository.IAccessoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccessoryRepository implements IAccessoryRepository {
    private static final String LIST_ALL_ACC = "select sp.id, lsp.ten_loai_san_pham, sp.ten_san_pham, sp.nha_cung_cap,\n" +
            " sp.hinh_anh, sp.gia, sp.so_luong from san_pham sp join loai_san_pham lsp on sp.id_loai_san_pham =\n" +
            " lsp.id_loai_san_pham" + " where sp.ten_san_pham like concat('%', ?, '%') and sp.id_loai_san_pham = 2";
    @Override
    public List<Accessory> listAll(String accessoryName) {
        List<Accessory> accessoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(LIST_ALL_ACC);
            preparedStatement.setString(1, accessoryName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Accessory accessory;
            while (resultSet.next()){
                accessory = new Accessory();
                accessory.setId(resultSet.getInt("sp.id"));
                accessory.setProductName(resultSet.getString("lsp.ten_loai_san_pham"));
                accessory.setAccessoryName(resultSet.getString("sp.ten_san_pham"));
                accessory.setSupplier(resultSet.getString("sp.nha_cung_cap"));
                accessory.setPhoto(resultSet.getString("sp.hinh_anh"));
                accessory.setPrice(resultSet.getDouble("sp.gia"));
                accessory.setQuantity(resultSet.getInt("sp.so_luong"));
                accessoryList.add(accessory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accessoryList;
    }
}

package repository.impl;

import model.Iphone;
import repository.IIphoneRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IphoneRepository implements IIphoneRepository {
    private static final String LIST_ALL = "select sp.id, lsp.ten_loai_san_pham, sp.ten_san_pham, sp.nha_cung_cap,\n" +
            " sp.hinh_anh, sp.gia, sp.so_luong from san_pham sp join loai_san_pham lsp on sp.id_loai_san_pham =\n" +
            " lsp.id_loai_san_pham" + " where sp.ten_san_pham like concat('%', ?, '%') and sp.id_loai_san_pham = 1";
    private static final String DELETE_IPHONE = "delete from san_pham s where s.id = ?";
    private static final String INSERT_INTO="insert into san_pham(id_loai_san_pham,ten_san_pham,nha_cung_cap,hinh_anh,gia,so_luong) value(?,?,?,?,?,?)";
    private static final String UPDATE_IHONE = "update san_pham set id_loai_san_pham=?,ten_san_pham=?,nha_cung_cap=?,hinh_anh=?,gia=?,so_luong=? where id=?";


    @Override
    public List<Iphone> listAll(String iphoneName) {
        List<Iphone> iphoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(LIST_ALL);
            preparedStatement.setString(1, iphoneName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Iphone iphone;
            while (resultSet.next()) {
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

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_IPHONE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Iphone findById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.getConnection().prepareStatement(" select id, lsp.ten_loai_san_pham, ten_san_pham, nha_cung_cap, hinh_anh, gia, so_luong from san_pham join loai_san_pham as lsp on san_pham.id_loai_san_pham = lsp.id_loai_san_pham where id =?;\n");
            preparedStatement.setInt(1, id);
            Iphone iphone;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                iphone = new Iphone();
                iphone.setId(resultSet.getInt("id"));
                iphone.setProductName(resultSet.getString("lsp.ten_loai_san_pham"));
                iphone.setIphoneName(resultSet.getString("ten_san_pham"));
                iphone.setSupplier(resultSet.getString("nha_cung_cap"));
                iphone.setPhoto(resultSet.getString("hinh_anh"));
                iphone.setPrice(resultSet.getDouble("gia"));
                iphone.setQuantity(resultSet.getInt("so_luong"));
                return iphone;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean inserIphone(Iphone iphone) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,iphone.getId());
            preparedStatement.setString(2,iphone.getProductName());
            preparedStatement.setString(3,iphone.getSupplier());
            preparedStatement.setString(4,iphone.getPhoto());
            preparedStatement.setDouble(5,iphone.getPrice());
            preparedStatement.setInt(6,iphone.getQuantity());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean updateIphone(int id, Iphone iphone) {
        Connection connection=BaseRepository.getConnection();
       try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_IHONE);
           preparedStatement.setInt(1,iphone.getId_lsp());
           preparedStatement.setString(2,iphone.getIphoneName());
           preparedStatement.setString(3,iphone.getSupplier());
           preparedStatement.setString(4,iphone.getPhoto());
           preparedStatement.setDouble(5,iphone.getPrice());
           preparedStatement.setInt(6,iphone.getQuantity());
           preparedStatement.setInt(7,iphone.getId());
            return preparedStatement.executeUpdate()>0;
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  false;

    }

}

package services;

import entity.ThuocTinh;
import ultis.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThuocTinhService extends DBContext {

    public void addThuocTinh(ThuocTinh thuocTinh, String key) {
        try {
            String sql = "insert " + key + "(ten)" + " values(?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, thuocTinh.getValue());
            int i = st.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ThuocTinh> getAllByKey(String key) {
        List<ThuocTinh> list = new ArrayList<>();
        try {
            String sql = "select * from " + key;
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ThuocTinh thuocTinh = new ThuocTinh();
                thuocTinh.setId(rs.getInt(1));
                thuocTinh.setValue(rs.getString(2));
                list.add(thuocTinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateThuocTinh(ThuocTinh thuocTinh, String key) {
        try {
            String sql = "update " + key + " set ten = ? where id" + key + " = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, thuocTinh.getValue());
            st.setInt(2, thuocTinh.getId());
            int i = st.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteThuocTinh(ThuocTinh thuocTinh, String key) {
        try {
            String sql = "delete " + key + "  where id" + key + " = ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, thuocTinh.getId());
            int i = st.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public boolean exitsByTen(String ten, String key) {
        try {
            String sql = "select count(*) from " + key + " where ten  = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ten);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ThuocTinh getThuocTinhById(int id, String key) {
         ThuocTinh thuocTinh = null;
        try {
            String sql = "select * from " + key + "  where id" + key + " = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
               thuocTinh = new ThuocTinh(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thuocTinh;
    }
    
    public ThuocTinh getThuocTinhByName(String name , String key) {
         ThuocTinh thuocTinh = null;
        try {
            String sql = "select * from " + key + "  where ten = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
               thuocTinh = new ThuocTinh(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thuocTinh;
    }

}

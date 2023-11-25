package services;

import entity.SanPham;
import ultis.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamService extends DBContext {

    public void addSanPham(SanPham sanPham) {
        try {
            String sql = "insert into sanpham(masp,ten,tinhtrang,idthuonghieu,idthanhphan, mota)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sanPham.getMaSp());
            st.setString(2, sanPham.getTenSp());
            st.setBoolean(3, sanPham.getTinhTrang());
            st.setInt(4, sanPham.getIdThuongHieu());
            st.setInt(5, sanPham.getIdThanhPhan());
            st.setString(6, sanPham.getMoTa());

            int i = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> getAllSp() {
        List<SanPham> sanPhamList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setId(rs.getInt("IDSanPham"));
                sanPham.setMaSp(rs.getString("masp"));
                sanPham.setTenSp(rs.getString("ten"));
                sanPham.setTinhTrang(rs.getBoolean("tinhtrang"));
                sanPham.setIdThuongHieu(rs.getInt("idthuonghieu"));
                sanPham.setIdThanhPhan(rs.getInt("idthanhphan"));
                sanPham.setMoTa(rs.getString("mota"));
                sanPhamList.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public SanPham getByMaSP(String masp) {
        String sql = "SELECT * FROM sanpham where masp = ?";
        SanPham sanPham = new SanPham();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, masp);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                sanPham.setId(rs.getInt("IDSanPham"));
                sanPham.setMaSp(rs.getString("masp"));
                sanPham.setTenSp(rs.getString("ten"));
                sanPham.setTinhTrang(rs.getBoolean("tinhtrang"));
                sanPham.setIdThuongHieu(rs.getInt("idthuonghieu"));
                sanPham.setIdThanhPhan(rs.getInt("idthanhphan"));
                sanPham.setMoTa(rs.getString("mota"));
            }
            return sanPham;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham getByID(int id) {
        String sql = "SELECT * FROM sanpham where IDSanPham = ?";
        SanPham sanPham = new SanPham();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                sanPham.setId(rs.getInt("IDSanPham"));
                sanPham.setMaSp(rs.getString("masp"));
                sanPham.setTenSp(rs.getString("ten"));
                sanPham.setTinhTrang(rs.getBoolean("tinhtrang"));
                sanPham.setIdThuongHieu(rs.getInt("idthuonghieu"));
                sanPham.setIdThanhPhan(rs.getInt("idthanhphan"));
                sanPham.setMoTa(rs.getString("mota"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public void updateSanPham(SanPham sanPham, String maSp) {
        try {
            String sql = "UPDATE sanpham SET  ten=?, tinhtrang=?, idthuonghieu=?, idthanhphan=?, mota=? WHERE masp=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sanPham.getTenSp());
            st.setBoolean(2, sanPham.getTinhTrang());
            st.setInt(3, sanPham.getIdThuongHieu());
            st.setInt(4, sanPham.getIdThanhPhan());
            st.setString(5, sanPham.getMoTa());
            st.setString(6, maSp);

            int i = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

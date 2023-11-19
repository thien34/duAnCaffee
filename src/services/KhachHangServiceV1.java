/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entity.KhachHang;
import java.util.List;
import ultis.DBContext;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class KhachHangServiceV1 extends DBContext {

    public List<KhachHang> getAll() {
        List<KhachHang> list = new ArrayList<>();
        try {
            String sql = "Select * from khachHang ";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getInt(1));
                khachHang.setTen(rs.getString(2));
                khachHang.setSdt(rs.getString(3));
                khachHang.setNgaySinh(rs.getString(4));
                khachHang.setDiaChi(rs.getString(5));
                khachHang.setEmail(rs.getString(6));
                khachHang.setTichDiem(rs.getInt(7));
                khachHang.setCapBac(rs.getString(8));
                list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void create(KhachHang khachHang) {
        try {
            String sql = "INSERT INTO KhachHang (Ten, SDT, NgaySinh, DiaChi, Email, TichDiem, CapBac) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, khachHang.getTen());
            statement.setString(2, khachHang.getSdt());
            statement.setString(3, khachHang.getNgaySinh());
            statement.setString(4, khachHang.getDiaChi());
            statement.setString(5, khachHang.getEmail());
            statement.setInt(6, khachHang.getTichDiem());
            statement.setString(7, khachHang.getCapBac());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(KhachHang khachHang, Integer id) {
        try {
            String sql = "UPDATE KhachHang SET Ten=?, SDT=?, NgaySinh=?, DiaChi=?, Email=?  WHERE IDKhachHang=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, khachHang.getTen());
            statement.setString(2, khachHang.getSdt());
            statement.setString(3, khachHang.getNgaySinh());
            statement.setString(4, khachHang.getDiaChi());
            statement.setString(5, khachHang.getEmail());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

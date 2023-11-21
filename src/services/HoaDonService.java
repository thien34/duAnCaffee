package services;

import entity.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultis.JdbcHelper;

public class HoaDonService implements MethodService<HoaDon> {

    String GET_ALL = "Select * From HoaDon";
    String GET_BY_ID = "Select * From HoaDon Where IDHoaDon = ?";
    String INSERT = "Insert HoaDon(IDNhanVien, IDKhachHang, TrangThai, NgayMua, TongTien) VALUES (?,?,?,?,?)";
    String UPDATE = "UPDATE HoaDon SET IDNhanVien = ?, IDKhachHang = ?, TrangThai = ?, NgayMua = ?, TongTien  = ? WHERE IDHoaDon = ?";
    String DELETE = "Delete HoaDon Where IDHoaDon = ?";

    @Override
    public List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HoaDon hoaDon = HoaDon.builder()
                        .idHoaDon(rs.getInt(1))
                        .idNhanVien(rs.getInt(2))
                        .idKhachHang(rs.getInt(3))
                        .trangThai(rs.getString(4))
                        .ngayMua(rs.getString(5))
                        .tien(rs.getInt(6))
                        .build();
                list.add(hoaDon);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public List<HoaDon> getAll() {
        return selectBySQL(GET_ALL);
    }

    @Override
    public HoaDon getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(HoaDon o) {
        JdbcHelper.executeUpdate(INSERT, o.getIdNhanVien(), o.getIdKhachHang(),
                o.getTrangThai(), o.getNgayMua(), o.getTien());

    }

    @Override
    public void update(HoaDon o, int id) {
        JdbcHelper.executeUpdate(UPDATE, o.getIdNhanVien(), o.getIdKhachHang(),
                o.getTrangThai(), o.getNgayMua(), o.getTien(), id);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

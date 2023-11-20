package services;

import entity.HoaDonChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultis.JdbcHelper;

public class HoaDonCTService implements MethodService<HoaDonChiTiet> {

    String GET_ALL = "Select * From HoaDonChiTiet";
    String GET_BY_ID = "Select * From HoaDonChiTiet Where ID = ?";
    String GET_BY_IDHD = "Select * From HoaDonChiTiet Where IDHoaDon = ?";
    String INSERT = "Insert HoaDonChiTiet(IDHoaDon, IDSPCT, SoLuong) VALUES (?,?,?)";
    String UPDATE = "UPDATE HoaDonChiTiet SET IDHoaDon = ?, IDSPCT = ?, SoLuong  = ? WHERE ID = ?";
    String DELETE = "Delete HoaDonChiTiet Where ID = ?";

    @Override
    public List<HoaDonChiTiet> selectBySQL(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet hoaDon = HoaDonChiTiet.builder()
                        .idHDCT(rs.getInt(1))
                        .idHoaDon(rs.getInt(2))
                        .idSPCT(rs.getInt(3))
                        .soLongMua(rs.getInt(4))
                        .build();
                list.add(hoaDon);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return selectBySQL(GET_ALL);
    }

    @Override
    public HoaDonChiTiet getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<HoaDonChiTiet> getByIDHD(int id) {
        return selectBySQL(GET_BY_IDHD, id);
    }

    @Override
    public void add(HoaDonChiTiet o) {
        JdbcHelper.executeUpdate(INSERT, o.getIdHoaDon(), o.getIdSPCT(), o.getSoLongMua());

    }

    @Override
    public void update(HoaDonChiTiet o, int id) {
        JdbcHelper.executeUpdate(UPDATE, o.getIdHoaDon(), o.getIdSPCT(), o.getSoLongMua(), id);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

package services;

import entity.SanPhamChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultis.JdbcHelper;

public class SPCTService implements MethodService<SanPhamChiTiet> {

    String GET_ALL = "Select * From SanPhamChiTiet";
    String GET_BY_ID = "Select * From SanPhamChiTiet Where IDSPCT = ?";
    String GET_BY_MASPCT = "Select * From SanPhamChiTiet Where MaSPCT = ?";
    String INSERT = "Insert SanPhamChiTiet(MaSPCT, IDSanPham ,IDKhoiLuong, IDDoRang, IDHuongVi, Anh, SoLuong, Gia, Mota) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    String UPDATE = "UPDATE SanPhamChiTiet SET MaSPCT = ?, IDKhoiLuong = ?, IDDoRang = ?, IDHuongVi = ?, Anh = ?, SoLuong = ?, Gia = ?, Mota  = ? WHERE IDSPCT = ?";
    String DELETE = "Delete SanPhamChiTiet Where IDSPCT = ?";
    String GET_BY_IDSP = "Select * From SanPhamChiTiet Where IDSanPham = ?";

    @Override
    public List<SanPhamChiTiet> selectBySQL(String sql, Object... args) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                SanPhamChiTiet spct = SanPhamChiTiet.builder()
                        .id(rs.getInt(1))
                        .ma(rs.getString(2))
                        .idSanPham(rs.getInt(3))
                        .idKhoiLuong(rs.getInt(4))
                        .idDoRang(rs.getInt(5))
                        .idHuongVi(rs.getInt(6))
                        .anh(rs.getString(7))
                        .soLuong(rs.getInt(8))
                        .gia(rs.getInt(9))
                        .moTa(rs.getString(10))
                        .build();
                list.add(spct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPhamChiTiet> getAll() {
        return selectBySQL(GET_ALL);
    }

    public List<SanPhamChiTiet> getByIDSP(int idsp) {
        return selectBySQL(GET_BY_IDSP, idsp);
    }

    @Override
    public SanPhamChiTiet getByID(int id) {
        List<SanPhamChiTiet> list = selectBySQL(GET_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public SanPhamChiTiet getByMSPCT(String maspct) {
        List<SanPhamChiTiet> list = selectBySQL(GET_BY_MASPCT, maspct);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void add(SanPhamChiTiet o) {
        JdbcHelper.executeUpdate(INSERT, o.getMa(), o.getIdSanPham(),
                o.getIdKhoiLuong(), o.getIdDoRang(), o.getIdHuongVi(),
                o.getAnh(), o.getSoLuong(), o.getGia(), o.getMoTa()
        );

    }

    @Override
    public void update(SanPhamChiTiet o, int id) {
        JdbcHelper.executeUpdate(UPDATE, o.getMa(), o.getIdKhoiLuong(),
                o.getIdDoRang(), o.getIdHuongVi(), o.getAnh(),
                o.getSoLuong(), o.getGia(), o.getMoTa(), id);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

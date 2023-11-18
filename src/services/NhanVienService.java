package services;

import entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ultis.JdbcHelper;

public class NhanVienService implements MethodService<NhanVien> {

    String GET_ALL = "Select * From NhanVien";
    String GET_BY_ID = "Select * From NhanVien Where idNhanVien = ?";
    String INSERT = "Insert NhanVien(ten, gioitinh, ngaysinh, sdt,email,diachi,matkhau,vaitro,trangthai) "
            + "VALUES (?, ?, ?, ?,?,?,?,?,?)";
    String UPDATE = "UPDATE NhanVien SET ten = ?, gioitinh = ?, ngaysinh = ?, sdt = ?, email = ?, diachi = ?, matkhau = ?, vaitro = ?, trangthai = ? WHERE IDNhanVien = ?";
    String DELETE = "Delete SanPham Where IDSanPham = ?";

    @Override
    public List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = NhanVien.builder()
                        .id(rs.getInt("IDNhanVien"))
                        .hoTen(rs.getString("Ten"))
                        .gioiTinh(rs.getBoolean("GioiTinh"))
                        .ngaySinh(rs.getString("NgaySinh"))
                        .soDienThoai(rs.getString("SDT"))
                        .emial(rs.getString("Email"))
                        .diaChi(rs.getString("DiaChi"))
                        .matKhau(rs.getString("MatKhau"))
                        .vaiTro(rs.getBoolean("VaiTro"))
                        .trangThai(rs.getBoolean("TrangThai"))
                        .build();
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<NhanVien> getAll() {
        return selectBySQL(GET_ALL);
    }

    @Override
    public NhanVien getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(NhanVien o) {
        JdbcHelper.executeUpdate(INSERT, o.getHoTen(), o.getGioiTinh(),
                o.getNgaySinh(), o.getSoDienThoai(),
                o.getEmial(), o.getDiaChi(),
                o.getMatKhau(),
                o.getVaiTro(),
                o.getTrangThai());

    }

    @Override
    public void update(NhanVien o, int id) {
        JdbcHelper.executeUpdate(UPDATE, o.getHoTen(), o.getGioiTinh(),
                o.getNgaySinh(), o.getSoDienThoai(),
                o.getEmial(), o.getDiaChi(),
                o.getMatKhau(),
                o.getVaiTro(),
                o.getTrangThai(),
                id);
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVien {

    private Integer id;
    private String hoTen;
    private Boolean gioiTinh;
    private String ngaySinh;
    private String soDienThoai;
    private String emial;
    private String diaChi;
    private String matKhau;
    private Boolean vaiTro;
    private Boolean trangThai;
}

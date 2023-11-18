/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author ACER
 */
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

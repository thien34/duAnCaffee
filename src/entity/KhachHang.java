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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class KhachHang {
    
    private Integer id;
    private String ten;
    private String sdt;
    private String ngaySinh;
    private String diaChi;
    private String email;
    private Integer tichDiem;
    private String capBac;
    
}

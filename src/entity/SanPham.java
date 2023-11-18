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
public class SanPham {
    
    private Integer id;
    private String maSp;
    private String tenSp;
    private String moTa;
    private Boolean tinhTrang;
    private Integer idThuongHieu;
    private Integer idThanhPhan;
}

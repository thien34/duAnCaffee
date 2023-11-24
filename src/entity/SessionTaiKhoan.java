/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ACER
 */

public class SessionTaiKhoan {
    
    public static NhanVien nhanVien;

    public static NhanVien getNhanVien() {
        return nhanVien;
    }
    
    public static void setNhanVien(NhanVien nhanVien) {
        SessionTaiKhoan.nhanVien = nhanVien;
    }
     
    
    
}

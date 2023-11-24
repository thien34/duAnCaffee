package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

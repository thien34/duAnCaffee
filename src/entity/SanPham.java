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
public class SanPham {
    
    private Integer id;
    private String maSp;
    private String tenSp;
    private String moTa;
    private Boolean tinhTrang;
    private Integer idThuongHieu;
    private Integer idThanhPhan;
}

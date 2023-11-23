package component;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.SanPhamChiTiet;
import entity.ThuocTinh;
import event.ItemClickListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import services.HoaDonCTService;
import services.HoaDonService;
import services.SanPhamService;
import services.ThuocTinhService;
import ultis.ImageHelper;
import ultis.MsgHelper;

public final class ItemProduct extends javax.swing.JPanel {

    private final SanPhamService sanPhamService = new SanPhamService();
    private final ThuocTinhService thuocTinhService = new ThuocTinhService();
    private final HoaDonService donService = new HoaDonService();
    private final HoaDonCTService cTService = new HoaDonCTService();
    public static boolean isEnabled;
    private ItemClickListener itemClickListener;

    public SanPhamChiTiet getData() {
        return data;
    }

    public void setItemClickListener(ItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    private boolean selected;

    public void setButtonClickListener(ActionListener listener) {
        jButton1.addActionListener(listener);
    }

    public ItemProduct() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setEnabled(isEnabled);

    }

    @Override
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
        jButton1.setEnabled(enabled);
    }

    private SanPhamChiTiet data;

    public void setData(SanPhamChiTiet data) {
        this.data = data;
        pic.setImage(ImageHelper.readImg(data.getAnh()));
        lbItemName.setText(sanPhamService.getByID(data.getIdSanPham()).getTenSp());
        ThuocTinh doRang = thuocTinhService.getThuocTinhById(data.getIdDoRang(), "DoRang");
        ThuocTinh huongVi = thuocTinhService.getThuocTinhById(data.getIdHuongVi(), "HuongVi");
        ThuocTinh khoiLuong = thuocTinhService.getThuocTinhById(data.getIdKhoiLuong(), "KhoiLuong");
        setToolTipText("IDSPCT: " + data.getMa() + "\nĐộ rang: " + doRang.getValue()
                + "\nHương vị: " + huongVi.getValue() + "\nKhối lượng: "
                + khoiLuong.getValue() + "\nSố lượng: " + data.getSoLuong());
        DecimalFormat df = new DecimalFormat("VND#,##0");
        lbPrice.setText(df.format(data.getGia()));
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    HoaDonChiTiet getModelHDCT() {
        return HoaDonChiTiet.builder()
                .idHoaDon(donService.getAll().get(donService.getAll().size() - 1).getIdHoaDon())
                .idSPCT(data.getId())
                .soLongMua(Integer.valueOf(jSpinner1.getValue().toString()))
                .build();
    }

    HoaDonChiTiet getModelHDCT_v2() {
        HoaDon hoaDon = donService.getAll().get(donService.getAll().size() - 1);
        HoaDonChiTiet chiTiet = cTService.getByIDHDSP(hoaDon.getIdHoaDon(), data.getId());
        return HoaDonChiTiet.builder()
                .idHoaDon(donService.getAll().get(donService.getAll().size() - 1).getIdHoaDon())
                .idSPCT(data.getId())
                .soLongMua(Integer.valueOf(jSpinner1.getValue().toString()) + chiTiet.getSoLongMua())
                .build();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        pic = new com.raven.swing.PictureBox();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(76, 76, 76));
        lbItemName.setText("Item Name");

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(115, 156, 121));
        lbPrice.setText("$0.00");

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/coffee(1).png"))); // NOI18N

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jSpinner1.setBorder(null);
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jSpinner1InputMethodTextChanged(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrice)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Integer.valueOf(jSpinner1.getValue().toString()) < 0) {
            MsgHelper.alert(this, "Không amm \nThêm thất bại");
            jSpinner1.setValue(0);
            return;
        }
        if (Integer.valueOf(jSpinner1.getValue().toString()) > data.getSoLuong()) {
            MsgHelper.alert(this, "Không đủ số lượng cho đại gia mua \nThêm thất bại ");
            jSpinner1.setValue(data.getSoLuong());
            return;
        }
        HoaDon lastHD = donService.getAll().get(donService.getAll().size() - 1);
        HoaDonChiTiet chiTiet = cTService.getByIDHDSP(lastHD.getIdHoaDon(), data.getId());
        if (chiTiet == null) {
            cTService.add(getModelHDCT());
        } else {
            cTService.update(getModelHDCT_v2(), chiTiet.getIdHDCT());
        }
        jSpinner1.setValue(0);
        itemClickListener.onItemClick(data);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        if (Integer.valueOf(jSpinner1.getValue().toString()) < 0) {
            MsgHelper.alert(this, "Không amm");
            jSpinner1.setValue(0);
        }
        if (Integer.valueOf(jSpinner1.getValue().toString()) > data.getSoLuong()) {
            MsgHelper.alert(this, "Không đủ số lượng cho đại gia mua");
            jSpinner1.setValue(data.getSoLuong());
        }
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jSpinner1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSpinner1InputMethodTextChanged
        if (Integer.valueOf(jSpinner1.getValue().toString()) < 0) {
            MsgHelper.alert(this, "Không amm");
            jSpinner1.setValue(0);
        }
        if (Integer.valueOf(jSpinner1.getValue().toString()) > data.getSoLuong()) {
            MsgHelper.alert(this, "Không đủ số lượng cho đại gia mua");
            jSpinner1.setValue(data.getSoLuong());
        }
    }//GEN-LAST:event_jSpinner1InputMethodTextChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private com.raven.swing.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}

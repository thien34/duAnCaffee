package form;

import java.awt.BorderLayout;
import model.Model_Card;

import javax.swing.ImageIcon;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import services.HoaDonServiceV2;

public class Form_Home extends javax.swing.JPanel {

    private final HoaDonServiceV2 donServiceV2 = new HoaDonServiceV2();

    public Form_Home() {
        initComponents();
        int soLuongDon = donServiceV2.thongKeByNgay();
        double tienTheoNgay = donServiceV2.thongKeDoanhThuByNgay();

        int soLuongDonTheoNam = donServiceV2.thongKeByNam();
        int soLuongDonTheoThang = donServiceV2.thongKeByThang();

        double tienTheoThang = donServiceV2.thongKeDoanhThuByThang();
        double tienTheoNam = donServiceV2.thongKeDoanhThuByNam();

        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Thống kê theo ngày", "Số lượng tiền : " + tienTheoNgay + " VND", "Số lượng đơn: " + soLuongDon));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Thống kê theo tháng", "Số lượng tiền : " + tienTheoThang +" VND", "Số lượng đơn: " + soLuongDonTheoThang));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Thống kê theo năm", "Số lượng tiền : " + tienTheoNam +" VND", "Số lượng đơn: " + soLuongDonTheoNam));
        //  add row table
        JFreeChart chart = TestBarChart.createChart();

        // Create a chart panel and add it to the panelBorder1 panel
        ChartPanel chartPanel = new ChartPanel(chart);

        this.panelBorder1.setLayout(new BorderLayout());
        this.panelBorder1.add(chartPanel, BorderLayout.CENTER);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new component.Card();
        card2 = new component.Card();
        card3 = new component.Card();
        panelBorder1 = new swing.PanelBorder();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private javax.swing.JLayeredPane panel;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}

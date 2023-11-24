package main;

import com.formdev.flatlaf.FlatLightLaf;
import entity.SessionTaiKhoan;
import form.Form_QLSP;
import form.Form_BanHang;
import form.Form_QLHoaDon;
import form.Form_Home;
import form.Form_KhachHang;
import form.Form_NhanVien;
import form.Form_ThanhPhan;
import form.Form_ThuongHieuV2;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends javax.swing.JFrame {

    private static Main main;

    public Main() {

        initComponents();
        jLabel2.setText(SessionTaiKhoan.getNhanVien() != null ? SessionTaiKhoan.getNhanVien().getHoTen() : "");
        main = this;
        titleBar1.initJFram(Main.main);
        setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(Main.this);
        menu.addEventMenuSelected((var index) -> {
            switch (index) {
                case 0 ->
                    setForm(new Form_Home());
                case 1 ->
                    setForm(new Form_QLSP());
                case 2 ->
                    setForm(new Form_BanHang());
                case 3 ->
                    setForm(new Form_QLHoaDon());
                case 7 ->
                    setForm(new Form_NhanVien());
                case 8 ->
                    setForm(new Form_KhachHang());
                case 9 ->
                    setForm(new Form_ThuongHieuV2());
                case 10 ->
                    setForm(new Form_ThanhPhan());
                case 11 ->
                    System.exit(0);
                default -> {
                }
            }
        });
        setForm(new Form_Home());
    }

    public Main(String key) {
        main.dispose();
        main = this;
        if (key.equalsIgnoreCase("ThanhPhan")) {
            initComponents();
            titleBar1.initJFram(Main.main);
            jLabel2.setText(SessionTaiKhoan.getNhanVien() != null ? SessionTaiKhoan.getNhanVien().getHoTen() : "");
            setBackground(new Color(0, 0, 0, 0));
            menu.initMoving(Main.this);
            menu.addEventMenuSelected((var index) -> {
                System.out.println(index);
                switch (index) {
                    case 0 ->
                        setForm(new Form_Home());
                    case 1 ->
                        setForm(new Form_QLSP());
                    case 2 ->
                        setForm(new Form_BanHang());
                    case 3 ->
                        setForm(new Form_QLHoaDon());
                    case 7 ->
                        setForm(new Form_NhanVien());
                    case 8 ->
                        setForm(new Form_KhachHang());
                    case 9 ->
                        setForm(new Form_ThuongHieuV2());
                    case 10 ->
                        setForm(new Form_ThanhPhan());
                    default -> {
                    }
                }
            });
            setForm(new Form_ThanhPhan());
        }
        if (key.equalsIgnoreCase("ThuongHieu")) {
            initComponents();
            titleBar1.initJFram(Main.main);
            jLabel2.setText(SessionTaiKhoan.getNhanVien() != null ? SessionTaiKhoan.getNhanVien().getHoTen() : "");
            setBackground(new Color(0, 0, 0, 0));
            menu.initMoving(Main.this);
            menu.addEventMenuSelected((var index) -> {
                System.out.println(index);
                switch (index) {
                    case 0 ->
                        setForm(new Form_Home());
                    case 1 ->
                        setForm(new Form_QLSP());
                    case 2 ->
                        setForm(new Form_BanHang());
                    case 3 ->
                        setForm(new Form_QLHoaDon());
                    case 7 ->
                        setForm(new Form_NhanVien());
                    case 8 ->
                        setForm(new Form_KhachHang());
                    case 9 ->
                        setForm(new Form_ThuongHieuV2());
                    case 10 ->
                        setForm(new Form_ThanhPhan());
                    default -> {
                    }
                }
            });
            setForm(new Form_ThuongHieuV2());
        }
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu = new component.Menu();
        header2 = new component.Header();
        mainPanel = new javax.swing.JPanel();
        titleBar1 = new titlebar.TitleBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(96, 153, 102));

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ảnh");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Lê Trung Nguyên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header header2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private component.Menu menu;
    private swing.PanelBorder panelBorder1;
    private titlebar.TitleBar titleBar1;
    // End of variables declaration//GEN-END:variables
}

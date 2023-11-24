package form;

import entity.ThuocTinh;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import services.ThuocTinhService;

public final class Form_ThanhPhan extends javax.swing.JPanel {

    private final ThuocTinhService thuocTinhService = new ThuocTinhService();

    public Form_ThanhPhan() {
        initComponents();
        loadData();
        jTable1.setSelectionBackground(new Color(112, 192, 109));
    }

    public void loadData() {
        TableCellRenderer buttonRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Component component) {
                    return component;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };

        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        updateButton.setBackground(new java.awt.Color(0, 153, 51));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
//        deleteButton.setBackground(new java.awt.Color(255, 0, 0));
//        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
//        deleteButton.setForeground(new java.awt.Color(255, 255, 255));

        TableColumn updateColumn = jTable1.getColumnModel().getColumn(2);
        updateColumn.setCellRenderer(buttonRenderer);
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.setRowCount(0);
        for (ThuocTinh o : thuocTinhService.getAllByKey("ThanhPhan")) {
            tm.addRow(new Object[]{
                o.getId(), o.getValue(), updateButton
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Thành Phần", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Quản Lý Thành Phần");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        View_ModalThanhPhan view_ModalThanhPhan = new View_ModalThanhPhan(null);
        view_ModalThanhPhan.setVisible(true);
        view_ModalThanhPhan.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            int row = jTable1.getSelectedRow();
            int id = (int) tm.getValueAt(row, 0);
            ThuocTinh thuocTinh = thuocTinhService.getThuocTinhById(id, "ThanhPhan");

            View_ModalThanhPhan view_ModalThanhPhan = new View_ModalThanhPhan(thuocTinh);
            view_ModalThanhPhan.setVisible(true);
            view_ModalThanhPhan.setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

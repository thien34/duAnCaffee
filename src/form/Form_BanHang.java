package form;

import entity.ModelItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Form_BanHang extends javax.swing.JPanel {

    private FormHomeUI home;
    private final Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;

    public Form_BanHang() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        animator = PropertySetter.createAnimator(500, mainPanel, "imageLocation", animatePoint, mainPanel.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel, "imageSize", new Dimension(180, 120), mainPanel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }

    private void init() {
        home = new FormHomeUI();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        testData();
    }

    private void testData() {
        home.setEvent((Component com, ModelItem item) -> {
            if (itemSelected != null) {
                mainPanel.setImageOld(itemSelected.getImage());
            }
            if (itemSelected != item) {
                if (!animator.isRunning()) {
                    itemSelected = item;
                    animatePoint = getLocationOf(com);
                    mainPanel.setImage(item.getImage());
                    mainPanel.setImageLocation(animatePoint);
                    mainPanel.setImageSize(new Dimension(180, 120));
                    mainPanel.repaint();
                    home.setSelected(com);
                    home.showItem(item);
                    animator.start();
                }
            }
        });
        int ID = 1;
        for (int i = 0; i <= 5; i++) {
            home.addItem(new ModelItem(ID++, "SUPERNOVA", "NMD City Stock 2", 150, "Adidas", new ImageIcon(getClass().getResource("/image/img1.png"))));
            home.addItem(new ModelItem(ID++, "SUPERNOVA", "NMD City Stock 2", 150, "Adidas", new ImageIcon(getClass().getResource("/image/img2.png"))));
            home.addItem(new ModelItem(ID++, "SUPERNOVA", "NMD City Stock 2", 150, "Adidas", new ImageIcon(getClass().getResource("/image/img3.png"))));
            home.addItem(new ModelItem(ID++, "Adidas", "NMD City Stock 2", 160, "Adidas", new ImageIcon(getClass().getResource("/image/img4.png"))));
            home.addItem(new ModelItem(ID++, "Adidas", "NMD City Stock 2", 120, "Adidas", new ImageIcon(getClass().getResource("/image/img5.png"))));
            home.addItem(new ModelItem(ID++, "Adidas", "NMD City Stock 2", 120, "Adidas", new ImageIcon(getClass().getResource("/image/img6.png"))));
        }
    }

    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.swing.Background();
        mainPanel = new com.raven.swing.MainPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 971, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Background background1;
    private com.raven.swing.MainPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
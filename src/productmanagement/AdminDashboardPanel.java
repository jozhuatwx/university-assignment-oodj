/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class AdminDashboardPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminDashboardPanel
     */
    public AdminDashboardPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTopProducts = new javax.swing.JPanel();
        cmbTitle = new javax.swing.JComboBox<>();
        lblTopProducts = new javax.swing.JLabel();
        pnlTopProductColLeft = new javax.swing.JPanel();
        lblThirdItem = new javax.swing.JLabel();
        lblThirdItemUnit = new javax.swing.JLabel();
        pnlThird = new javax.swing.JPanel();
        pnlTopProductColCenter = new javax.swing.JPanel();
        lblSecondItem = new javax.swing.JLabel();
        lblSecondItemUnit = new javax.swing.JLabel();
        pnlSecond = new javax.swing.JPanel();
        pnlTopProductColRight = new javax.swing.JPanel();
        lblFirstdItem = new javax.swing.JLabel();
        lblFirstItemUnit = new javax.swing.JLabel();
        pnlFirst = new javax.swing.JPanel();
        pnlRevenue = new javax.swing.JPanel();
        lblRevenueTitle = new javax.swing.JLabel();
        lblRevenue = new javax.swing.JLabel();
        pnlLatestCatalogue = new javax.swing.JPanel();
        lblLatestCatalogue = new javax.swing.JLabel();
        lblCatalogueTitle = new javax.swing.JLabel();
        lblCatalogueDate = new javax.swing.JLabel();
        pnlSupplier = new javax.swing.JPanel();
        lblSupplierTitle = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        lblInactive = new javax.swing.JLabel();
        lblActiveSupplier = new javax.swing.JLabel();
        lblInactiveSupplier = new javax.swing.JLabel();

        setBackground(new java.awt.Color(18, 22, 31));
        setPreferredSize(new java.awt.Dimension(775, 485));

        pnlTopProducts.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProducts.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlTopProducts.setPreferredSize(new java.awt.Dimension(542, 464));

        cmbTitle.setBackground(new java.awt.Color(204, 204, 204));
        cmbTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbTitle.setForeground(new java.awt.Color(255, 255, 255));
        cmbTitle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly Total Sales", "Top Products" }));

        lblTopProducts.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTopProducts.setForeground(new java.awt.Color(255, 255, 255));
        lblTopProducts.setText("Top Products");

        pnlTopProductColLeft.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColLeft.setPreferredSize(new java.awt.Dimension(154, 406));

        lblThirdItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblThirdItem.setForeground(new java.awt.Color(255, 255, 255));
        lblThirdItem.setText(" ");
        lblThirdItem.setPreferredSize(new java.awt.Dimension(110, 14));
        lblThirdItem.setHorizontalAlignment(JLabel.CENTER);

        lblThirdItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblThirdItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblThirdItemUnit.setText(" ");
        lblThirdItemUnit.setPreferredSize(new java.awt.Dimension(110, 14));
        lblThirdItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlThird.setBackground(new java.awt.Color(82, 82, 247));
        pnlThird.setMinimumSize(new java.awt.Dimension(100, 0));

        javax.swing.GroupLayout pnlThirdLayout = new javax.swing.GroupLayout(pnlThird);
        pnlThird.setLayout(pnlThirdLayout);
        pnlThirdLayout.setHorizontalGroup(
            pnlThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnlThirdLayout.setVerticalGroup(
            pnlThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTopProductColLeftLayout = new javax.swing.GroupLayout(pnlTopProductColLeft);
        pnlTopProductColLeft.setLayout(pnlTopProductColLeftLayout);
        pnlTopProductColLeftLayout.setHorizontalGroup(
            pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductColLeftLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThirdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThirdItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThird, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTopProductColLeftLayout.setVerticalGroup(
            pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColLeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThirdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThirdItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThird, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTopProductColCenter.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColCenter.setPreferredSize(new java.awt.Dimension(154, 406));

        lblSecondItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSecondItem.setForeground(new java.awt.Color(255, 255, 255));
        lblSecondItem.setText(" ");
        lblSecondItem.setPreferredSize(new java.awt.Dimension(110, 14));
        lblSecondItem.setHorizontalAlignment(JLabel.CENTER);

        lblSecondItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSecondItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblSecondItemUnit.setText(" ");
        lblSecondItemUnit.setPreferredSize(new java.awt.Dimension(110, 14));
        lblSecondItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlSecond.setBackground(new java.awt.Color(247, 185, 36));
        pnlSecond.setMinimumSize(new java.awt.Dimension(100, 0));

        javax.swing.GroupLayout pnlSecondLayout = new javax.swing.GroupLayout(pnlSecond);
        pnlSecond.setLayout(pnlSecondLayout);
        pnlSecondLayout.setHorizontalGroup(
            pnlSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnlSecondLayout.setVerticalGroup(
            pnlSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTopProductColCenterLayout = new javax.swing.GroupLayout(pnlTopProductColCenter);
        pnlTopProductColCenter.setLayout(pnlTopProductColCenterLayout);
        pnlTopProductColCenterLayout.setHorizontalGroup(
            pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductColCenterLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSecondItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSecondItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTopProductColCenterLayout.setVerticalGroup(
            pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColCenterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSecondItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSecondItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTopProductColRight.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColRight.setPreferredSize(new java.awt.Dimension(154, 406));

        lblFirstdItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblFirstdItem.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstdItem.setText(" ");
        lblFirstdItem.setPreferredSize(new java.awt.Dimension(110, 14));
        lblFirstdItem.setHorizontalAlignment(JLabel.CENTER);

        lblFirstItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblFirstItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstItemUnit.setText(" ");
        lblFirstItemUnit.setPreferredSize(new java.awt.Dimension(110, 14));
        lblFirstItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlFirst.setBackground(new java.awt.Color(0, 205, 154));
        pnlFirst.setMinimumSize(new java.awt.Dimension(100, 0));

        javax.swing.GroupLayout pnlFirstLayout = new javax.swing.GroupLayout(pnlFirst);
        pnlFirst.setLayout(pnlFirstLayout);
        pnlFirstLayout.setHorizontalGroup(
            pnlFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnlFirstLayout.setVerticalGroup(
            pnlFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTopProductColRightLayout = new javax.swing.GroupLayout(pnlTopProductColRight);
        pnlTopProductColRight.setLayout(pnlTopProductColRightLayout);
        pnlTopProductColRightLayout.setHorizontalGroup(
            pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductColRightLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTopProductColRightLayout.setVerticalGroup(
            pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFirstdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFirstItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlTopProductsLayout = new javax.swing.GroupLayout(pnlTopProducts);
        pnlTopProducts.setLayout(pnlTopProductsLayout);
        pnlTopProductsLayout.setHorizontalGroup(
            pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductsLayout.createSequentialGroup()
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopProductsLayout.createSequentialGroup()
                        .addComponent(pnlTopProductColLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTopProductColCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlTopProductsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTopProducts)
                        .addGap(267, 267, 267)))
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTopProductsLayout.createSequentialGroup()
                        .addComponent(cmbTitle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addComponent(pnlTopProductColRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlTopProductsLayout.setVerticalGroup(
            pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTopProducts)
                    .addComponent(cmbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTopProductColLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(pnlTopProductColRight, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(pnlTopProductColCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
        );

        pnlRevenue.setBackground(new java.awt.Color(46, 52, 66));
        pnlRevenue.setPreferredSize(new java.awt.Dimension(200, 220));

        lblRevenueTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblRevenueTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblRevenueTitle.setText("Revenue");

        lblRevenue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblRevenue.setForeground(new java.awt.Color(255, 255, 255));
        lblRevenue.setText("RM 1,000,000.00");
        lblRevenue.setHorizontalAlignment(JLabel.CENTER);

        javax.swing.GroupLayout pnlRevenueLayout = new javax.swing.GroupLayout(pnlRevenue);
        pnlRevenue.setLayout(pnlRevenueLayout);
        pnlRevenueLayout.setHorizontalGroup(
            pnlRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRevenueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblRevenueTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRevenueLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblRevenue)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlRevenueLayout.setVerticalGroup(
            pnlRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRevenueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblRevenueTitle)
                .addGap(45, 45, 45)
                .addComponent(lblRevenue)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pnlLatestCatalogue.setBackground(new java.awt.Color(46, 52, 66));
        pnlLatestCatalogue.setPreferredSize(new java.awt.Dimension(200, 225));

        lblLatestCatalogue.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblLatestCatalogue.setForeground(new java.awt.Color(255, 255, 255));
        lblLatestCatalogue.setText("Latest Catalogue");

        lblCatalogueTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        lblCatalogueTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCatalogueTitle.setText("Catalogue Title");
        lblCatalogueTitle.setHorizontalAlignment(JLabel.CENTER);

        lblCatalogueDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblCatalogueDate.setForeground(new java.awt.Color(255, 255, 255));
        lblCatalogueDate.setText("10/10/1010 - 10/10/1010");
        lblCatalogueDate.setHorizontalAlignment(JLabel.CENTER);

        javax.swing.GroupLayout pnlLatestCatalogueLayout = new javax.swing.GroupLayout(pnlLatestCatalogue);
        pnlLatestCatalogue.setLayout(pnlLatestCatalogueLayout);
        pnlLatestCatalogueLayout.setHorizontalGroup(
            pnlLatestCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatestCatalogueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLatestCatalogue)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLatestCatalogueLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(pnlLatestCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCatalogueTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCatalogueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLatestCatalogueLayout.setVerticalGroup(
            pnlLatestCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatestCatalogueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLatestCatalogue)
                .addGap(38, 38, 38)
                .addComponent(lblCatalogueTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCatalogueDate)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlSupplier.setBackground(new java.awt.Color(46, 52, 66));
        pnlSupplier.setPreferredSize(new java.awt.Dimension(200, 220));

        lblSupplierTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSupplierTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplierTitle.setText("Supplier");

        lblActive.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        lblActive.setForeground(new java.awt.Color(255, 255, 255));
        lblActive.setText("Active:");
        lblActive.setPreferredSize(new java.awt.Dimension(89, 20));
        lblRevenue.setHorizontalAlignment(JLabel.CENTER);

        lblInactive.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        lblInactive.setForeground(new java.awt.Color(255, 255, 255));
        lblInactive.setText("Inactive:");
        lblRevenue.setHorizontalAlignment(JLabel.CENTER);

        lblActiveSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblActiveSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblActiveSupplier.setText("20");
        lblActiveSupplier.setPreferredSize(new java.awt.Dimension(89, 20));
        lblRevenue.setHorizontalAlignment(JLabel.CENTER);

        lblInactiveSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblInactiveSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblInactiveSupplier.setText("1000");
        lblInactiveSupplier.setPreferredSize(new java.awt.Dimension(89, 20));
        lblRevenue.setHorizontalAlignment(JLabel.CENTER);

        javax.swing.GroupLayout pnlSupplierLayout = new javax.swing.GroupLayout(pnlSupplier);
        pnlSupplier.setLayout(pnlSupplierLayout);
        pnlSupplierLayout.setHorizontalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplierTitle)
                    .addGroup(pnlSupplierLayout.createSequentialGroup()
                        .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInactive))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInactiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblActiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlSupplierLayout.setVerticalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSupplierTitle)
                .addGap(29, 29, 29)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInactive)
                    .addComponent(lblInactiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTopProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlLatestCatalogue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlRevenue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTopProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlLatestCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTitle;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblActiveSupplier;
    private javax.swing.JLabel lblCatalogueDate;
    private javax.swing.JLabel lblCatalogueTitle;
    private javax.swing.JLabel lblFirstItemUnit;
    private javax.swing.JLabel lblFirstdItem;
    private javax.swing.JLabel lblInactive;
    private javax.swing.JLabel lblInactiveSupplier;
    private javax.swing.JLabel lblLatestCatalogue;
    private javax.swing.JLabel lblRevenue;
    private javax.swing.JLabel lblRevenueTitle;
    private javax.swing.JLabel lblSecondItem;
    private javax.swing.JLabel lblSecondItemUnit;
    private javax.swing.JLabel lblSupplierTitle;
    private javax.swing.JLabel lblThirdItem;
    private javax.swing.JLabel lblThirdItemUnit;
    private javax.swing.JLabel lblTopProducts;
    private javax.swing.JPanel pnlFirst;
    private javax.swing.JPanel pnlLatestCatalogue;
    private javax.swing.JPanel pnlRevenue;
    private javax.swing.JPanel pnlSecond;
    private javax.swing.JPanel pnlSupplier;
    private javax.swing.JPanel pnlThird;
    private javax.swing.JPanel pnlTopProductColCenter;
    private javax.swing.JPanel pnlTopProductColLeft;
    private javax.swing.JPanel pnlTopProductColRight;
    private javax.swing.JPanel pnlTopProducts;
    // End of variables declaration//GEN-END:variables
}
package productmanagement;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.JLabel;

public class AdminDashboardPanel extends javax.swing.JPanel {

    public AdminDashboardPanel() {
        initComponents();

        resetBarchart();

        // Set the String format to add commas and zeros
        DecimalFormat revenueFormat = new DecimalFormat("#,##0.00");

        // Get the total revenue and set the label to display it
        lblRevenue.setText("RM " + revenueFormat.format(InventoryTransaction.totalRevenue()));

        // Get the number of Suppliers
        int[] suppliers = Supplier.totalSuppliers();
        lblActiveSupplier.setText(String.valueOf(suppliers[1]));
        lblInactiveSupplier.setText(String.valueOf(suppliers[2]));

        // Get the latest catalogue name and date
        String[] catalogueDetails = ProductCatalogue.latestCatalogue();

        // Set the labels to display the catalogue name and date
        lblCatalogueTitle.setText(catalogueDetails[1]);
        lblCatalogueDate.setText(catalogueDetails[4] + " - " + catalogueDetails[5]);
    }

    private void resetBarchart() {
        int selected = cmbTitle.getSelectedIndex();
        // Clear previous information
        lblRightItem.setText(" ");
        lblRightItemUnit.setText(" ");
        lblCenterItem.setText(" ");
        lblCenterItemUnit.setText(" ");
        lblLeftItem.setText(" ");
        lblLeftItemUnit.setText(" ");
        int firstUnits = 0, secondUnits = 0, thirdUnits = 0, rightBarHeight = 0, centerBarHeight = 0, leftBarHeight = 0;

        // Set the String format to add commas
        DecimalFormat unitFormat = new DecimalFormat("#,###");

        if (selected == 1) {
            lblTopProducts.setText("Top Products");
            // Top products
            // Get the top products
            String[][] topProducts = InventoryTransaction.topProductItems();
            if (topProducts[0][3] != null) {
                firstUnits = Integer.valueOf(topProducts[0][3]);

                // Set the labels to display the top products only if it has more than 1 unit
                if (firstUnits > 0) {
                    lblRightItem.setText(topProducts[0][1]);
                    lblRightItemUnit.setText(unitFormat.format(firstUnits) + " units");
                    rightBarHeight = 350;

                    if (topProducts[1][3] != null) {
                        secondUnits = Integer.valueOf(topProducts[1][3]);

                        if (secondUnits > 0) {
                            lblCenterItem.setText(topProducts[1][1]);
                            lblCenterItemUnit.setText(unitFormat.format(secondUnits)+ " units");
                            centerBarHeight = (int) Math.round((double) secondUnits / (double) firstUnits * 350);
                        }

                        if (topProducts[2][3] != null) {
                            thirdUnits = Integer.valueOf(topProducts[2][3]);

                            if (thirdUnits > 0) {
                                lblLeftItem.setText(topProducts[2][1]);
                                lblLeftItemUnit.setText(unitFormat.format(thirdUnits) + " units");
                                leftBarHeight = (int) Math.round((double) thirdUnits / (double) firstUnits * 350);
                            }
                        }
                    }
                }
            }
        } else {
            lblTopProducts.setText("Monthly Total Sales");
            // Monthly total sales
            double firstMonth = InventoryTransaction.totalRevenue(LocalDate.now().minusDays(LocalDate.now().getDayOfMonth()), LocalDate.now());
            double secondMonth = InventoryTransaction.totalRevenue(LocalDate.now().minusMonths(2).minusDays(LocalDate.now().getDayOfMonth()), LocalDate.now().minusMonths(1).minusDays(LocalDate.now().getDayOfMonth()));
            double thirdMonth = InventoryTransaction.totalRevenue(LocalDate.now().minusMonths(3).minusDays(LocalDate.now().getDayOfMonth()), LocalDate.now().minusMonths(2).minusDays(LocalDate.now().getDayOfMonth()));

            lblRightItem.setText(String.valueOf(LocalDate.now().getMonth()));
            lblRightItemUnit.setText(String.valueOf(unitFormat.format(Math.round(firstMonth))));

            lblCenterItem.setText(String.valueOf(LocalDate.now().minusMonths(1).getMonth()));
            lblCenterItemUnit.setText(String.valueOf(unitFormat.format(Math.round(secondMonth))));

            lblLeftItem.setText(String.valueOf(LocalDate.now().minusMonths(2).getMonth()));
            lblLeftItemUnit.setText(String.valueOf(unitFormat.format(Math.round(thirdMonth))));

            double highest;
            if (firstMonth < secondMonth) {
                if (firstMonth > thirdMonth) {
                    highest = secondMonth;
                } else {
                    if (secondMonth > thirdMonth) {
                        highest = secondMonth;
                    } else {
                        highest = thirdMonth;
                    }
                }
            } else {
                if (firstMonth > thirdMonth) {
                    highest = firstMonth;
                } else {
                    highest = thirdMonth;
                }
            }
            rightBarHeight = (int) Math.round(firstMonth / highest * 350);
            centerBarHeight = (int) Math.round(secondMonth / highest * 350);
            leftBarHeight = (int) Math.round(thirdMonth / highest * 350);
        }

        pnlRightBar.setPreferredSize(new Dimension(85, rightBarHeight));
        pnlCenter.setPreferredSize(new Dimension(85, centerBarHeight));
        pnlLeftBar.setPreferredSize(new Dimension(85, leftBarHeight));
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
        lblLeftItem = new javax.swing.JLabel();
        lblLeftItemUnit = new javax.swing.JLabel();
        pnlLeftBar = new javax.swing.JPanel();
        pnlTopProductColCenter = new javax.swing.JPanel();
        lblCenterItem = new javax.swing.JLabel();
        lblCenterItemUnit = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlTopProductColRight = new javax.swing.JPanel();
        lblRightItem = new javax.swing.JLabel();
        lblRightItemUnit = new javax.swing.JLabel();
        pnlRightBar = new javax.swing.JPanel();
        pnlRevenue = new javax.swing.JPanel();
        lblRevenueTitle = new javax.swing.JLabel();
        lblRevenue = new javax.swing.JLabel();
        pnlSupplier = new javax.swing.JPanel();
        lblSupplierTitle = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        lblInactive = new javax.swing.JLabel();
        lblActiveSupplier = new javax.swing.JLabel();
        lblInactiveSupplier = new javax.swing.JLabel();
        pnlLatestCatalogue = new javax.swing.JPanel();
        lblLatestCatalogue = new javax.swing.JLabel();
        lblCatalogueTitle = new javax.swing.JLabel();
        lblCatalogueDate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(18, 22, 31));
        setPreferredSize(new java.awt.Dimension(775, 485));

        pnlTopProducts.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProducts.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlTopProducts.setPreferredSize(new java.awt.Dimension(537, 463));

        cmbTitle.setBackground(new java.awt.Color(204, 204, 204));
        cmbTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbTitle.setForeground(new java.awt.Color(255, 255, 255));
        cmbTitle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly Total Sales", "Top Products" }));
        cmbTitle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTitleItemStateChanged(evt);
            }
        });

        lblTopProducts.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTopProducts.setForeground(new java.awt.Color(255, 255, 255));
        lblTopProducts.setText("Top Products");

        pnlTopProductColLeft.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColLeft.setPreferredSize(new java.awt.Dimension(154, 406));

        lblLeftItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblLeftItem.setForeground(new java.awt.Color(255, 255, 255));
        lblLeftItem.setText(" ");
        lblLeftItem.setPreferredSize(new java.awt.Dimension(110, 14));
        lblLeftItem.setHorizontalAlignment(JLabel.CENTER);

        lblLeftItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblLeftItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblLeftItemUnit.setText(" ");
        lblLeftItemUnit.setPreferredSize(new java.awt.Dimension(110, 14));
        lblLeftItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlLeftBar.setBackground(new java.awt.Color(82, 82, 247));
        pnlLeftBar.setMaximumSize(new java.awt.Dimension(110, 0));
        pnlLeftBar.setMinimumSize(new java.awt.Dimension(110, 0));

        javax.swing.GroupLayout pnlLeftBarLayout = new javax.swing.GroupLayout(pnlLeftBar);
        pnlLeftBar.setLayout(pnlLeftBarLayout);
        pnlLeftBarLayout.setHorizontalGroup(
            pnlLeftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLeftBarLayout.setVerticalGroup(
            pnlLeftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTopProductColLeftLayout = new javax.swing.GroupLayout(pnlTopProductColLeft);
        pnlTopProductColLeft.setLayout(pnlTopProductColLeftLayout);
        pnlTopProductColLeftLayout.setHorizontalGroup(
            pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductColLeftLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLeftItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLeftItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLeftBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTopProductColLeftLayout.setVerticalGroup(
            pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColLeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLeftItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLeftItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLeftBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTopProductColCenter.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColCenter.setPreferredSize(new java.awt.Dimension(154, 406));

        lblCenterItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblCenterItem.setForeground(new java.awt.Color(255, 255, 255));
        lblCenterItem.setText(" ");
        lblCenterItem.setPreferredSize(new java.awt.Dimension(110, 14));
        lblCenterItem.setHorizontalAlignment(JLabel.CENTER);

        lblCenterItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblCenterItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblCenterItemUnit.setText(" ");
        lblCenterItemUnit.setPreferredSize(new java.awt.Dimension(110, 14));
        lblCenterItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlCenter.setBackground(new java.awt.Color(247, 185, 36));
        pnlCenter.setMaximumSize(new java.awt.Dimension(110, 0));
        pnlCenter.setMinimumSize(new java.awt.Dimension(110, 0));

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(lblCenterItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCenterItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTopProductColCenterLayout.setVerticalGroup(
            pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColCenterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCenterItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCenterItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTopProductColRight.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColRight.setPreferredSize(new java.awt.Dimension(154, 406));

        lblRightItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblRightItem.setForeground(new java.awt.Color(255, 255, 255));
        lblRightItem.setText(" ");
        lblRightItem.setPreferredSize(new java.awt.Dimension(110, 14));
        lblRightItem.setHorizontalAlignment(JLabel.CENTER);

        lblRightItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblRightItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblRightItemUnit.setText(" ");
        lblRightItemUnit.setPreferredSize(new java.awt.Dimension(110, 14));
        lblRightItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlRightBar.setBackground(new java.awt.Color(0, 205, 154));
        pnlRightBar.setMaximumSize(new java.awt.Dimension(110, 0));
        pnlRightBar.setMinimumSize(new java.awt.Dimension(110, 0));

        javax.swing.GroupLayout pnlRightBarLayout = new javax.swing.GroupLayout(pnlRightBar);
        pnlRightBar.setLayout(pnlRightBarLayout);
        pnlRightBarLayout.setHorizontalGroup(
            pnlRightBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRightBarLayout.setVerticalGroup(
            pnlRightBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTopProductColRightLayout = new javax.swing.GroupLayout(pnlTopProductColRight);
        pnlTopProductColRight.setLayout(pnlTopProductColRightLayout);
        pnlTopProductColRightLayout.setHorizontalGroup(
            pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductColRightLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRightItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRightItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRightBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTopProductColRightLayout.setVerticalGroup(
            pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRightItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRightItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRightBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlTopProductsLayout = new javax.swing.GroupLayout(pnlTopProducts);
        pnlTopProducts.setLayout(pnlTopProductsLayout);
        pnlTopProductsLayout.setHorizontalGroup(
            pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductsLayout.createSequentialGroup()
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopProductsLayout.createSequentialGroup()
                        .addComponent(pnlTopProductColLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 32, Short.MAX_VALUE)
                        .addComponent(pnlTopProductColCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 33, Short.MAX_VALUE))
                    .addGroup(pnlTopProductsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTopProducts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTopProductColRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
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
                    .addComponent(pnlTopProductColLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(pnlTopProductColRight, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(pnlTopProductColCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
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
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRevenueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRevenue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRevenueLayout.setVerticalGroup(
            pnlRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRevenueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblRevenueTitle)
                .addGap(30, 30, 30)
                .addComponent(lblRevenue)
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInactive))
                .addGap(18, 18, 18)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInactiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(pnlSupplierLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSupplierTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSupplierLayout.setVerticalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSupplierTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInactive)
                    .addComponent(lblInactiveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
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
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLatestCatalogueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(lblCatalogueTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCatalogueDate)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTopProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTopProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlLatestCatalogue, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTitleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTitleItemStateChanged
        resetBarchart();
    }//GEN-LAST:event_cmbTitleItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTitle;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblActiveSupplier;
    private javax.swing.JLabel lblCatalogueDate;
    private javax.swing.JLabel lblCatalogueTitle;
    private javax.swing.JLabel lblCenterItem;
    private javax.swing.JLabel lblCenterItemUnit;
    private javax.swing.JLabel lblInactive;
    private javax.swing.JLabel lblInactiveSupplier;
    private javax.swing.JLabel lblLatestCatalogue;
    private javax.swing.JLabel lblLeftItem;
    private javax.swing.JLabel lblLeftItemUnit;
    private javax.swing.JLabel lblRevenue;
    private javax.swing.JLabel lblRevenueTitle;
    private javax.swing.JLabel lblRightItem;
    private javax.swing.JLabel lblRightItemUnit;
    private javax.swing.JLabel lblSupplierTitle;
    private javax.swing.JLabel lblTopProducts;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlLatestCatalogue;
    private javax.swing.JPanel pnlLeftBar;
    private javax.swing.JPanel pnlRevenue;
    private javax.swing.JPanel pnlRightBar;
    private javax.swing.JPanel pnlSupplier;
    private javax.swing.JPanel pnlTopProductColCenter;
    private javax.swing.JPanel pnlTopProductColLeft;
    private javax.swing.JPanel pnlTopProductColRight;
    private javax.swing.JPanel pnlTopProducts;
    // End of variables declaration//GEN-END:variables
}

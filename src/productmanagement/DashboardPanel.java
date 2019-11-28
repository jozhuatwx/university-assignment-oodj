package productmanagement;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JLabel;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel() {
        initComponents();

        // Set the String format to add commas
        DecimalFormat unitFormat = new DecimalFormat("#,###");

        // Get the top products
        String[][] topProducts = InventoryTransaction.topProductItems();
        int firstUnits = Integer.valueOf(topProducts[0][3]);
        int secondUnits = Integer.valueOf(topProducts[1][3]);
        int thirdUnits = Integer.valueOf(topProducts[2][3]);

        // Set the labels to display the top products only if it has more than 1 unit
        if (firstUnits > 0) {
            lblFirstdItem.setText(topProducts[0][1]);
            lblFirstItemUnit.setText(unitFormat.format(firstUnits) + " units");

            if (secondUnits > 0) {
                lblSecondItem.setText(topProducts[1][1]);
                lblSecondItemUnit.setText(unitFormat.format(secondUnits)+ " units");

                if (thirdUnits > 0) {
                    lblThirdItem.setText(topProducts[2][1]);
                    lblThirdItemUnit.setText(unitFormat.format(thirdUnits) + " units");
                }
            }

            // Set the bar chart height
            int firstHeight = 280;
            int secondHeight = (int) Math.round((double) secondUnits / (double) firstUnits * 280);
            int thirdHeight = (int) Math.round((double) thirdUnits / (double) firstUnits * 280);

            pnlFirst.setPreferredSize(new Dimension(85, firstHeight));
            pnlSecond.setPreferredSize(new Dimension(85, secondHeight));
            pnlThird.setPreferredSize(new Dimension(85, thirdHeight));
        }

        // Set the String format to add commas and zeros
        DecimalFormat revenueFormat = new DecimalFormat("#,##0.00");

        // Get the total revenue and set the label to display it
        lblRevenue.setText("RM " + revenueFormat.format(InventoryTransaction.totalRevenue()));

        // Get the latest catalogue name and date
        String[] catalogueDetails = ProductCatalogue.latestCatalogue();

        // Set the labels to display the catalogue name and date
        lblCatalogueTitle.setText(catalogueDetails[1]);
        lblCatalogueDate.setText(catalogueDetails[4] + " - " + catalogueDetails[5]);
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

        setBackground(new java.awt.Color(18, 22, 31));
        setMinimumSize(new java.awt.Dimension(780, 485));

        pnlTopProducts.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProducts.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlTopProducts.setPreferredSize(new java.awt.Dimension(542, 463));

        lblTopProducts.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTopProducts.setForeground(new java.awt.Color(255, 255, 255));
        lblTopProducts.setText("Top Products");

        pnlTopProductColLeft.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColLeft.setPreferredSize(new java.awt.Dimension(154, 406));

        lblThirdItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblThirdItem.setForeground(new java.awt.Color(255, 255, 255));
        lblThirdItem.setText(" ");
        lblThirdItem.setHorizontalAlignment(JLabel.CENTER);

        lblThirdItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblThirdItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblThirdItemUnit.setText(" ");
        lblThirdItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlThird.setBackground(new java.awt.Color(82, 82, 247));
        pnlThird.setPreferredSize(new java.awt.Dimension(85, 0));

        javax.swing.GroupLayout pnlThirdLayout = new javax.swing.GroupLayout(pnlThird);
        pnlThird.setLayout(pnlThirdLayout);
        pnlThirdLayout.setHorizontalGroup(
            pnlThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
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
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThirdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThirdItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThird, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlTopProductColLeftLayout.setVerticalGroup(
            pnlTopProductColLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColLeftLayout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
                .addComponent(lblThirdItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThirdItemUnit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThird, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTopProductColCenter.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColCenter.setPreferredSize(new java.awt.Dimension(154, 406));

        lblSecondItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSecondItem.setForeground(new java.awt.Color(255, 255, 255));
        lblSecondItem.setText(" ");
        lblSecondItem.setHorizontalAlignment(JLabel.CENTER);

        lblSecondItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSecondItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblSecondItemUnit.setText(" ");
        lblSecondItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlSecond.setBackground(new java.awt.Color(247, 185, 36));
        pnlSecond.setPreferredSize(new java.awt.Dimension(85, 0));

        javax.swing.GroupLayout pnlSecondLayout = new javax.swing.GroupLayout(pnlSecond);
        pnlSecond.setLayout(pnlSecondLayout);
        pnlSecondLayout.setHorizontalGroup(
            pnlSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
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
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSecondItem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSecondItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlTopProductColCenterLayout.setVerticalGroup(
            pnlTopProductColCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColCenterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSecondItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSecondItemUnit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTopProductColRight.setBackground(new java.awt.Color(46, 52, 66));
        pnlTopProductColRight.setPreferredSize(new java.awt.Dimension(154, 406));

        lblFirstdItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblFirstdItem.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstdItem.setText(" ");
        lblFirstdItem.setHorizontalAlignment(JLabel.CENTER);

        lblFirstItemUnit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblFirstItemUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstItemUnit.setText(" ");
        lblFirstItemUnit.setHorizontalAlignment(JLabel.CENTER);

        pnlFirst.setBackground(new java.awt.Color(0, 205, 154));
        pnlFirst.setPreferredSize(new java.awt.Dimension(85, 0));

        javax.swing.GroupLayout pnlFirstLayout = new javax.swing.GroupLayout(pnlFirst);
        pnlFirst.setLayout(pnlFirstLayout);
        pnlFirstLayout.setHorizontalGroup(
            pnlFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
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
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstItemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlTopProductColRightLayout.setVerticalGroup(
            pnlTopProductColRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopProductColRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFirstdItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFirstItemUnit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlTopProductsLayout = new javax.swing.GroupLayout(pnlTopProducts);
        pnlTopProducts.setLayout(pnlTopProductsLayout);
        pnlTopProductsLayout.setHorizontalGroup(
            pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTopProducts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlTopProductsLayout.createSequentialGroup()
                .addComponent(pnlTopProductColLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTopProductColCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTopProductColRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTopProductsLayout.setVerticalGroup(
            pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopProductsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTopProducts)
                .addGap(18, 18, 18)
                .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlTopProductColRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTopProductColLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTopProductsLayout.createSequentialGroup()
                        .addComponent(pnlTopProductColCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0))))
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
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblRevenue)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlRevenueLayout.setVerticalGroup(
            pnlRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRevenueLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblRevenueTitle)
                .addGap(52, 52, 52)
                .addComponent(lblRevenue)
                .addContainerGap(108, Short.MAX_VALUE))
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
                .addGap(39, 39, 39)
                .addComponent(lblCatalogueTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCatalogueDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(pnlLatestCatalogue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRevenue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTopProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlLatestCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCatalogueDate;
    private javax.swing.JLabel lblCatalogueTitle;
    private javax.swing.JLabel lblFirstItemUnit;
    private javax.swing.JLabel lblFirstdItem;
    private javax.swing.JLabel lblLatestCatalogue;
    private javax.swing.JLabel lblRevenue;
    private javax.swing.JLabel lblRevenueTitle;
    private javax.swing.JLabel lblSecondItem;
    private javax.swing.JLabel lblSecondItemUnit;
    private javax.swing.JLabel lblThirdItem;
    private javax.swing.JLabel lblThirdItemUnit;
    private javax.swing.JLabel lblTopProducts;
    private javax.swing.JPanel pnlFirst;
    private javax.swing.JPanel pnlLatestCatalogue;
    private javax.swing.JPanel pnlRevenue;
    private javax.swing.JPanel pnlSecond;
    private javax.swing.JPanel pnlThird;
    private javax.swing.JPanel pnlTopProductColCenter;
    private javax.swing.JPanel pnlTopProductColLeft;
    private javax.swing.JPanel pnlTopProductColRight;
    private javax.swing.JPanel pnlTopProducts;
    // End of variables declaration//GEN-END:variables
}

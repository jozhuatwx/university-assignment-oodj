package productmanagement;

import java.awt.Image;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class ProductCatalogueTemplate extends javax.swing.JPanel {
    private ProductCatalogue catalogue;
    private ProductCataloguePage page;

    public ProductCatalogueTemplate(ProductCatalogue catalogue, ProductCataloguePage page) {
        initComponents();
        this.catalogue = catalogue;
        this.page = page;

        resetContent();
    }

    private void resetContent() {
        // Remove existing
        pnlContent.removeAll();

        switch (page.getPageNumberOfItems()) {
            case 1:
                pnlContent.add(new ProductCatalogueOneItemTemplate(page.getPageItemIds()));
                break;
            case 2:
                pnlContent.add(new ProductCatalogueTwoItemTemplate(page.getPageItemIds()));
                break;
            case 3:
                pnlContent.add(new ProductCatalogueThreeItemTemplate(page.getPageItemIds()));
                break;
            case 4:
                pnlContent.add(new ProductCatalogueFourItemTemplate(page.getPageItemIds()));
                break;
        }
        pnlContent.revalidate();

        lblTopBannerImage.setIcon(resizeImage((Paths.get("").toAbsolutePath().toString() + "/src" + catalogue.getCatalogueBannerPath())));
        lblBottomBannerImage.setIcon(resizeImage((Paths.get("").toAbsolutePath().toString() + "/src" + catalogue.getCatalogueBannerPath())));
        lblPageNumber.setText(String.valueOf(page.getPageNumber()));
    }

    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath) {
        // Get the imageicon
        ImageIcon MyImage = new ImageIcon(imagePath);
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblTopBannerImage.getPreferredSize().getWidth(),(int) lblTopBannerImage.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTopBannerImage = new javax.swing.JLabel();
        lblBottomBannerImage = new javax.swing.JLabel();
        lblPageNumber = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTopBannerImage.setBackground(new java.awt.Color(255, 0, 51));
        lblTopBannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBannerImage.setPreferredSize(new java.awt.Dimension(420, 60));

        lblBottomBannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomBannerImage.setToolTipText("");
        lblBottomBannerImage.setPreferredSize(new java.awt.Dimension(420, 60));

        lblPageNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPageNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPageNumber.setText("2");

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setMinimumSize(new java.awt.Dimension(400, 400));
        pnlContent.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTopBannerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBottomBannerImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTopBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBottomBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBottomBannerImage;
    private javax.swing.JLabel lblPageNumber;
    private javax.swing.JLabel lblTopBannerImage;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}

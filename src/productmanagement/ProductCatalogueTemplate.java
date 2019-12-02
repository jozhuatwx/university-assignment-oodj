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
                ProductCatalogueOneItemTemplate one = new ProductCatalogueOneItemTemplate(page.getPageItemIds());
                one.setSize(one.getPreferredSize());
                pnlContent.add(one);
                break;
            case 2:
                ProductCatalogueTwoItemTemplate two = new ProductCatalogueTwoItemTemplate(page.getPageItemIds());
                two.setSize(two.getPreferredSize());
                pnlContent.add(two);
                break;
            case 3:
                ProductCatalogueThreeItemTemplate three = new ProductCatalogueThreeItemTemplate(page.getPageItemIds());
                three.setSize(three.getPreferredSize());
                pnlContent.add(three);
                break;
            case 4:
                ProductCatalogueFourItemTemplate four = new ProductCatalogueFourItemTemplate(page.getPageItemIds());
                four.setSize(four.getPreferredSize());
                pnlContent.add(four);
                break;
        }
        pnlContent.revalidate();

        lblTopBannerImage.setSize(lblTopBannerImage.getPreferredSize());
        lblBottomBannerImage.setSize(lblBottomBannerImage.getPreferredSize());
        lblPageNumber.setSize(lblPageNumber.getPreferredSize());
        
        lblTopBannerImage.setLocation(0, 20);
        pnlContent.setLocation(0, 86);
        lblBottomBannerImage.setLocation(0, 431);
        lblPageNumber.setLocation(0, 502);

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
        lblPageNumber.setPreferredSize(new java.awt.Dimension(420, 15));

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setMinimumSize(new java.awt.Dimension(400, 400));
        pnlContent.setPreferredSize(new java.awt.Dimension(420, 420));
        pnlContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTopBannerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBottomBannerImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPageNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTopBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBottomBannerImage;
    private javax.swing.JLabel lblPageNumber;
    private javax.swing.JLabel lblTopBannerImage;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}

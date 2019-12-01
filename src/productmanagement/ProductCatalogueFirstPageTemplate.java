package productmanagement;

import java.awt.Image;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class ProductCatalogueFirstPageTemplate extends javax.swing.JPanel {
    private ProductCatalogue catalogue;
    private ProductCataloguePage page;

    public ProductCatalogueFirstPageTemplate(ProductCatalogue catalogue, ProductCataloguePage page) {
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

        lblTitle.setText(catalogue.getCatalogueTitle());
        lblTopBannerImage.setIcon(resizeImageTop((Paths.get("").toAbsolutePath().toString() + "/src" + catalogue.getCatalogueBannerPath())));
        lblBottomBannerImage.setIcon(resizeImageBottom((Paths.get("").toAbsolutePath().toString() + "/src" + catalogue.getCatalogueBannerPath())));
        lblPageNumber.setText(String.valueOf(page.getPageNumber()));
    }

    // Create a method to resize the image
    private ImageIcon resizeImageTop(String imagePath) {
        // Get the imageicon
        ImageIcon MyImage = new ImageIcon(imagePath);
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblTopBannerImage.getPreferredSize().getWidth(),(int) lblTopBannerImage.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    // Create a method to resize the image
    private ImageIcon resizeImageBottom(String imagePath) {
        // Get the imageicon
        ImageIcon MyImage = new ImageIcon(imagePath);
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblBottomBannerImage.getPreferredSize().getWidth(),(int) lblBottomBannerImage.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTopBannerImage = new javax.swing.JLabel();
        lblBottomBannerImage = new javax.swing.JLabel();
        lblPageNumber = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTopBannerImage.setBackground(new java.awt.Color(255, 0, 51));
        lblTopBannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBannerImage.setPreferredSize(new java.awt.Dimension(63, 60));

        lblBottomBannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomBannerImage.setPreferredSize(new java.awt.Dimension(425, 60));

        lblPageNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPageNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPageNumber.setText("1");

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setMinimumSize(new java.awt.Dimension(400, 400));
        pnlContent.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlContent.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        lblTitle.setText("TITLE: CATALOGUE CNY");
        lblTitle.setPreferredSize(new java.awt.Dimension(31, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(184, 184, 184))
                .addComponent(lblBottomBannerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblTopBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(lblTopBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
                    .addComponent(lblBottomBannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBottomBannerImage;
    private javax.swing.JLabel lblPageNumber;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTopBannerImage;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}

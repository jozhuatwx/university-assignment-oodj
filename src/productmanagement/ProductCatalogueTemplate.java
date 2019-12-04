package productmanagement;

import java.awt.Dimension;
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
        pnlContent = new javax.swing.JPanel();
        lblBottomBannerImage = new javax.swing.JLabel();
        lblPageNumber = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(420, 594));
        setMinimumSize(new java.awt.Dimension(420, 594));
        setLayout(null);

        lblTopBannerImage.setBackground(new java.awt.Color(255, 0, 51));
        lblTopBannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopBannerImage.setMaximumSize(new java.awt.Dimension(420, 60));
        lblTopBannerImage.setMinimumSize(new java.awt.Dimension(420, 60));
        lblTopBannerImage.setPreferredSize(new java.awt.Dimension(420, 60));
        add(lblTopBannerImage);
        lblTopBannerImage.setBounds(0, 20, 420, 60);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setMaximumSize(new java.awt.Dimension(420, 420));
        pnlContent.setMinimumSize(new java.awt.Dimension(420, 420));
        pnlContent.setPreferredSize(new java.awt.Dimension(420, 420));
        pnlContent.setLayout(null);
        add(pnlContent);
        pnlContent.setBounds(0, 80, 420, 420);

        lblBottomBannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomBannerImage.setToolTipText("");
        lblBottomBannerImage.setMaximumSize(new java.awt.Dimension(420, 60));
        lblBottomBannerImage.setMinimumSize(new java.awt.Dimension(420, 60));
        lblBottomBannerImage.setPreferredSize(new java.awt.Dimension(420, 60));
        add(lblBottomBannerImage);
        lblBottomBannerImage.setBounds(0, 500, 420, 60);

        lblPageNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPageNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPageNumber.setMaximumSize(new java.awt.Dimension(420, 15));
        lblPageNumber.setMinimumSize(new java.awt.Dimension(420, 15));
        lblPageNumber.setPreferredSize(new java.awt.Dimension(420, 15));
        add(lblPageNumber);
        lblPageNumber.setBounds(0, 570, 420, 15);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBottomBannerImage;
    private javax.swing.JLabel lblPageNumber;
    private javax.swing.JLabel lblTopBannerImage;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}

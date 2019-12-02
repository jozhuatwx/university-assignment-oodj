package productmanagement;

import java.awt.Image;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ProductCatalogueOneItemTemplate extends javax.swing.JPanel {
    private ProductItem item;
    
    public ProductCatalogueOneItemTemplate(String[] itemIds) {
        initComponents();
        
        if (!itemIds[0].trim().equalsIgnoreCase("")) {
            ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
            for (String itemDetails : itemArray) {
                String[] details = itemDetails.split(";");
                if (details[0].equalsIgnoreCase(itemIds[0])) {
                    item = new ProductItem(details);
                }
            }

            lblImage.setIcon(resizeImage(Paths.get("").toAbsolutePath().toString() + "/src" + item.getItemImagePath()));
            lblTitle.setText(item.getItemName());
            lblBrand.setText(item.getItemBrand());
            lblPrice.setText("RM " + String.valueOf(item.getItemPrice()));
            txaDescription.setText(item.getItemDescription());
        } else {
            lblImage.setIcon(new ImageIcon());
            lblTitle.setText("Title");
            lblBrand.setText("Brand");
            lblPrice.setText("Price");
            txaDescription.setText("");
        }
    }
    
       
    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath){
        int x, y;
        
        // Get the imageicon and get the width & height of the image
        ImageIcon MyImage = new ImageIcon(imagePath);
        x = MyImage.getIconWidth();
        y = MyImage.getIconHeight();
        
        // To differentiate the dimension of image (horizontal,vertical or square)
        // To resize the label based on the dimension
        if (x > y) {
            // If the width longer than height, then it is a horizontal image
            lblImage.setBounds(75,10,255,180);
            
        } else if (y > x){
            // If the height longer than width, then it is a vertical image
            lblImage.setBounds(138,10,128,180);
            
        } else {
            // The width is equal to the height, then it is a square image
            lblImage.setBounds(112,10,180,180);
        }
            
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblImage.getBounds().getWidth(),(int) lblImage.getBounds().getHeight(), Image.SCALE_SMOOTH);
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

        pnlContent = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblBrand = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        pnlImage = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblTitle.setText("MR CHAIR");

        scrDescription.setBorder(null);
        scrDescription.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrDescription.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txaDescription.setEditable(false);
        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("Arial Narrow", 0, 13)); // NOI18N
        txaDescription.setLineWrap(true);
        txaDescription.setRows(5);
        txaDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry\n. Lorem Ipsum has been the industry's standard dummy text ever since t\nhe 1500s, when an unknown printer took a galley of type and scrambled it to m\nake a type specimen book. It has survived not only five centuries, but also the\n leap into electronic typesetting, remaining essentially unchanged. It was popula\nrised in the 1960s w");
        txaDescription.setBorder(null);
        scrDescription.setViewportView(txaDescription);

        lblBrand.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBrand.setText("BRAND");

        lblPrice.setText("RM 100");

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrDescription)
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrice)
                .addGap(18, 18, 18)
                .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlImage.setBackground(new java.awt.Color(255, 255, 255));
        pnlImage.setPreferredSize(new java.awt.Dimension(405, 200));
        pnlImage.setLayout(null);

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImage.setPreferredSize(new java.awt.Dimension(180, 180));
        pnlImage.add(lblImage);
        lblImage.setBounds(110, 10, 180, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlImage;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    // End of variables declaration//GEN-END:variables
}

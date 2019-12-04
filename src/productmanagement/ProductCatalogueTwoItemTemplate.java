package productmanagement;

import java.awt.Image;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ProductCatalogueTwoItemTemplate extends javax.swing.JPanel {
    ArrayList<ProductItem> items = new ArrayList<>();

    public ProductCatalogueTwoItemTemplate(String[] itemIds) {
        initComponents();
        
        // Get first two Items
        for (int i = 0; i < 2; i++) {
            boolean found = false;
            ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
            // Iterate through the Item array
            for (String itemDetails : itemArray) {
                // Split the line into details
                String[] details = itemDetails.split(";");
                // Check the details for a matching Id
                if (details[0].equalsIgnoreCase(itemIds[i])) {
                    // Create a Product Item object and add into array list
                    items.add(new ProductItem(details));
                    found = true;
                    break;
                }
            }
            // If item is not found, create an empty Product Item object and add it to the array list
            if (!found) {
                items.add(new ProductItem("", "", "", 0, "", "", "", "", ""));
            }
        }

        resetItem(items.get(0), lblImageItem1, lblNameItem1, lblBrandItem1, lblPriceItem1, txaDescriptionItem1, 1);
        resetItem(items.get(1), lblImageItem2, lblNameItem2, lblBrandItem2, lblPriceItem2, txaDescriptionItem2, 2);
    }

    private void resetItem(ProductItem item, JLabel lblImage, JLabel lblName, JLabel lblBrand, JLabel lblPrice, JTextArea txaDescription, int i) {
        if (!item.getItemId().trim().equalsIgnoreCase("")) {
            lblImage.setIcon(resizeImage(Paths.get("").toAbsolutePath().toString() + "/src" + item.getItemImagePath(), lblImage, i));
            lblName.setText(item.getItemName());
            lblBrand.setText(item.getItemBrand());
            lblPrice.setText("RM " + String.valueOf(item.getItemPrice()));
            txaDescription.setText(item.getItemDescription());
        } else {
            lblImage.setIcon(new ImageIcon());
            lblName.setText("Title");
            lblBrand.setText("Brand");
            lblPrice.setText("Price");
            txaDescription.setText("");
        }
        lblImage.setLocation(lblImage.getBounds().x, lblImage.getBounds().y);
    }
    
    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath, JLabel lblImage, int itemNo){
        int x, y;
        double width, height, ratio;
        width = lblImage.getPreferredSize().getWidth();
        height = lblImage.getPreferredSize().getHeight();
        
        // Get the imageicon and get the width & height of the image
        ImageIcon MyImage = new ImageIcon(imagePath);
        x = MyImage.getIconWidth();
        y = MyImage.getIconHeight();
        ratio = (double) x / y;
        
        // To differentiate the dimension of image (horizontal,vertical or square)
        // To resize the label based on the dimension
        // To relocate the picture to the right position based on the item number 
        if (ratio > (width / height)) {
            // If the width longer than height, then it is a horizontal image
            if (itemNo == 1){
                lblImageItem1.setBounds(210, (int) Math.round((height - (height / ratio)) / 2), (int) width, (int) Math.round(height / ratio));
            } else {
                lblImageItem2.setBounds(0, (int) Math.round((height - (height / ratio)) / 2), (int) width, (int) Math.round(height / ratio));
            }
        } else if (ratio < (width / height)){
            // If the height longer than width, then it is a vertical image
            if (itemNo == 1){
                lblImageItem1.setBounds((int) Math.round((width - (width / ratio)) / 2), 0, (int) Math.round(width / ratio), (int) height);
            } else {
                lblImageItem2.setBounds((int) Math.round((width - (width / ratio)) / 2), 0, (int) Math.round(width / ratio), (int) height);
            }
        } else {
            // The width is equal to the height, then it is a square image
            //Relocate the position of lblImage
            if (itemNo == 1){
                lblImageItem1.setBounds(210, 0, (int) width, (int) height);
            } else {
                lblImageItem2.setBounds(0, 210, (int) width, (int) height);
            }
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

        pnlItem1 = new javax.swing.JPanel();
        pnlContentItem1 = new javax.swing.JPanel();
        scrDescriptionItem1 = new javax.swing.JScrollPane();
        txaDescriptionItem1 = new javax.swing.JTextArea();
        lblBrandItem1 = new javax.swing.JLabel();
        lblPriceItem1 = new javax.swing.JLabel();
        lblNameItem1 = new javax.swing.JLabel();
        lblImageItem1 = new javax.swing.JLabel();
        pnlItem2 = new javax.swing.JPanel();
        lblImageItem2 = new javax.swing.JLabel();
        pnlContentItem2 = new javax.swing.JPanel();
        scrDescriptionItem2 = new javax.swing.JScrollPane();
        txaDescriptionItem2 = new javax.swing.JTextArea();
        lblBrandItem2 = new javax.swing.JLabel();
        lblPriceItem2 = new javax.swing.JLabel();
        lblNameItem2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(420, 420));
        setMinimumSize(new java.awt.Dimension(420, 420));
        setPreferredSize(new java.awt.Dimension(420, 420));
        setLayout(null);

        pnlItem1.setBackground(new java.awt.Color(255, 255, 255));
        pnlItem1.setPreferredSize(new java.awt.Dimension(420, 210));
        pnlItem1.setLayout(null);

        pnlContentItem1.setMaximumSize(new java.awt.Dimension(210, 210));
        pnlContentItem1.setMinimumSize(new java.awt.Dimension(210, 210));
        pnlContentItem1.setPreferredSize(new java.awt.Dimension(210, 210));
        pnlContentItem1.setLayout(null);

        scrDescriptionItem1.setBorder(null);
        scrDescriptionItem1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrDescriptionItem1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txaDescriptionItem1.setEditable(false);
        txaDescriptionItem1.setBackground(new java.awt.Color(240, 240, 240));
        txaDescriptionItem1.setColumns(20);
        txaDescriptionItem1.setFont(new java.awt.Font("Arial Narrow", 0, 13)); // NOI18N
        txaDescriptionItem1.setLineWrap(true);
        txaDescriptionItem1.setRows(5);
        txaDescriptionItem1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry\n. Lorem Ipsum has been the industry's standard dummy text ever since t\nhe 1500s, when an unknown printer took a galley of type and scrambled it to m\nake a type specimen book. It has survived not only five centuries, but also the\n leap into electronic typesetting, remaining essentially unchanged. It was popula\nrised in the 1960s w");
        txaDescriptionItem1.setBorder(null);
        scrDescriptionItem1.setViewportView(txaDescriptionItem1);

        pnlContentItem1.add(scrDescriptionItem1);
        scrDescriptionItem1.setBounds(10, 89, 180, 100);

        lblBrandItem1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBrandItem1.setText("BRAND");
        pnlContentItem1.add(lblBrandItem1);
        lblBrandItem1.setBounds(10, 38, 165, 13);

        lblPriceItem1.setText("RM 100");
        pnlContentItem1.add(lblPriceItem1);
        lblPriceItem1.setBounds(10, 57, 97, 14);

        lblNameItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblNameItem1.setText("MR CHAIR");
        pnlContentItem1.add(lblNameItem1);
        lblNameItem1.setBounds(10, 11, 190, 21);

        pnlItem1.add(pnlContentItem1);
        pnlContentItem1.setBounds(0, 0, 210, 210);

        lblImageItem1.setMaximumSize(new java.awt.Dimension(210, 210));
        lblImageItem1.setMinimumSize(new java.awt.Dimension(210, 210));
        lblImageItem1.setPreferredSize(new java.awt.Dimension(210, 210));
        pnlItem1.add(lblImageItem1);
        lblImageItem1.setBounds(210, 0, 210, 210);

        add(pnlItem1);
        pnlItem1.setBounds(0, 0, 420, 210);

        pnlItem2.setBackground(new java.awt.Color(255, 255, 255));
        pnlItem2.setPreferredSize(new java.awt.Dimension(420, 210));
        pnlItem2.setLayout(null);

        lblImageItem2.setMaximumSize(new java.awt.Dimension(210, 210));
        lblImageItem2.setMinimumSize(new java.awt.Dimension(210, 210));
        lblImageItem2.setPreferredSize(new java.awt.Dimension(210, 210));
        pnlItem2.add(lblImageItem2);
        lblImageItem2.setBounds(0, 0, 210, 210);

        pnlContentItem2.setMaximumSize(new java.awt.Dimension(210, 210));
        pnlContentItem2.setMinimumSize(new java.awt.Dimension(210, 210));
        pnlContentItem2.setPreferredSize(new java.awt.Dimension(210, 210));
        pnlContentItem2.setLayout(null);

        scrDescriptionItem2.setBorder(null);
        scrDescriptionItem2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrDescriptionItem2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txaDescriptionItem2.setEditable(false);
        txaDescriptionItem2.setBackground(new java.awt.Color(240, 240, 240));
        txaDescriptionItem2.setColumns(20);
        txaDescriptionItem2.setFont(new java.awt.Font("Arial Narrow", 0, 13)); // NOI18N
        txaDescriptionItem2.setLineWrap(true);
        txaDescriptionItem2.setRows(5);
        txaDescriptionItem2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry\n. Lorem Ipsum has been the industry's standard dummy text ever since t\nhe 1500s, when an unknown printer took a galley of type and scrambled it to m\nake a type specimen book. It has survived not only five centuries, but also the\n leap into electronic typesetting, remaining essentially unchanged. It was popula\nrised in the 1960s w");
        txaDescriptionItem2.setBorder(null);
        scrDescriptionItem2.setViewportView(txaDescriptionItem2);

        pnlContentItem2.add(scrDescriptionItem2);
        scrDescriptionItem2.setBounds(10, 89, 190, 100);

        lblBrandItem2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBrandItem2.setText("BRAND");
        pnlContentItem2.add(lblBrandItem2);
        lblBrandItem2.setBounds(10, 38, 165, 13);

        lblPriceItem2.setText("RM 100");
        pnlContentItem2.add(lblPriceItem2);
        lblPriceItem2.setBounds(10, 57, 97, 14);

        lblNameItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblNameItem2.setText("MR CHAIR");
        pnlContentItem2.add(lblNameItem2);
        lblNameItem2.setBounds(10, 11, 190, 21);

        pnlItem2.add(pnlContentItem2);
        pnlContentItem2.setBounds(210, 0, 210, 210);

        add(pnlItem2);
        pnlItem2.setBounds(0, 210, 420, 210);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBrandItem1;
    private javax.swing.JLabel lblBrandItem2;
    private javax.swing.JLabel lblImageItem1;
    private javax.swing.JLabel lblImageItem2;
    private javax.swing.JLabel lblNameItem1;
    private javax.swing.JLabel lblNameItem2;
    private javax.swing.JLabel lblPriceItem1;
    private javax.swing.JLabel lblPriceItem2;
    private javax.swing.JPanel pnlContentItem1;
    private javax.swing.JPanel pnlContentItem2;
    private javax.swing.JPanel pnlItem1;
    private javax.swing.JPanel pnlItem2;
    private javax.swing.JScrollPane scrDescriptionItem1;
    private javax.swing.JScrollPane scrDescriptionItem2;
    private javax.swing.JTextArea txaDescriptionItem1;
    private javax.swing.JTextArea txaDescriptionItem2;
    // End of variables declaration//GEN-END:variables
}

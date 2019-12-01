/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class ProductCatalogueTwoItemTemplate extends javax.swing.JPanel {

    /**
     * Creates new form ProductCatalogueTwoItemTemplate
     */
    public ProductCatalogueTwoItemTemplate() {
        initComponents();
        
    }
    
    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath, JLabel lblImage, int itemNo){
        int x, y;
        
        // Get the imageicon and get the width & height of the image
        ImageIcon MyImage = new ImageIcon(imagePath);
        x = MyImage.getIconWidth();
        y = MyImage.getIconHeight();
        
        // To differentiate the dimension of image (horizontal,vertical or square)
        // To resize the label based on the dimension
        // To relocate the picture to the right position based on the item number 
        if (x > y) {
            // If the width longer than height, then it is a horizontal image
            if(itemNo == 1){
                lblImageItem1.setBounds(212,34,183,130);
            }else{
                lblImageItem2.setBounds(10,34,183,130);
            }
            
        } else if (y > x){
            // If the height longer than width, then it is a vertical image
            if(itemNo == 1){
                lblImageItem1.setBounds(241,10,125,177);
            }else{
                lblImageItem2.setBounds(38,10,125,177);
            }    
                
        } else {
            // The width is equal to the height, then it is a square image
            
            //Relocate the position of lblImage
                if(itemNo == 1){
                    lblImageItem1.setBounds(233,30,140,140);
                }else{
                    lblImageItem2.setBounds(31,30,140,140);
                }
        }
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblImage.getPreferredSize().getWidth(),(int) lblImage.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
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
        pnlContentItem2 = new javax.swing.JPanel();
        scrDescriptionItem2 = new javax.swing.JScrollPane();
        txaDescriptionItem2 = new javax.swing.JTextArea();
        lblBrandItem2 = new javax.swing.JLabel();
        lblPriceItem2 = new javax.swing.JLabel();
        lblNameItem2 = new javax.swing.JLabel();
        lblImageItem2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlItem1.setBackground(new java.awt.Color(255, 255, 255));
        pnlItem1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlItem1.setPreferredSize(new java.awt.Dimension(254, 199));
        pnlItem1.setLayout(null);

        pnlContentItem1.setPreferredSize(new java.awt.Dimension(202, 200));

        scrDescriptionItem1.setBorder(null);
        scrDescriptionItem1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrDescriptionItem1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txaDescriptionItem1.setBackground(new java.awt.Color(240, 240, 240));
        txaDescriptionItem1.setColumns(20);
        txaDescriptionItem1.setFont(new java.awt.Font("Arial Narrow", 0, 13)); // NOI18N
        txaDescriptionItem1.setRows(5);
        txaDescriptionItem1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry\n. Lorem Ipsum has been the industry's standard dummy text ever since t\nhe 1500s, when an unknown printer took a galley of type and scrambled it to m\nake a type specimen book. It has survived not only five centuries, but also the\n leap into electronic typesetting, remaining essentially unchanged. It was popula\nrised in the 1960s w");
        txaDescriptionItem1.setBorder(null);
        scrDescriptionItem1.setViewportView(txaDescriptionItem1);

        lblBrandItem1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBrandItem1.setText("BRAND");

        lblPriceItem1.setText("RM 100");

        lblNameItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblNameItem1.setText("MR CHAIR");

        javax.swing.GroupLayout pnlContentItem1Layout = new javax.swing.GroupLayout(pnlContentItem1);
        pnlContentItem1.setLayout(pnlContentItem1Layout);
        pnlContentItem1Layout.setHorizontalGroup(
            pnlContentItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentItem1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContentItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlContentItem1Layout.createSequentialGroup()
                        .addGroup(pnlContentItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPriceItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrDescriptionItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBrandItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlContentItem1Layout.setVerticalGroup(
            pnlContentItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentItem1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameItem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBrandItem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPriceItem1)
                .addGap(18, 18, 18)
                .addComponent(scrDescriptionItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlItem1.add(pnlContentItem1);
        pnlContentItem1.setBounds(1, 1, 202, 197);

        lblImageItem1.setText("Image");
        lblImageItem1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlItem1.add(lblImageItem1);
        lblImageItem1.setBounds(234, 31, 140, 140);

        pnlItem2.setBackground(new java.awt.Color(255, 255, 255));
        pnlItem2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlItem2.setLayout(null);

        pnlContentItem2.setPreferredSize(new java.awt.Dimension(202, 200));

        scrDescriptionItem2.setBorder(null);
        scrDescriptionItem2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrDescriptionItem2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txaDescriptionItem2.setBackground(new java.awt.Color(240, 240, 240));
        txaDescriptionItem2.setColumns(20);
        txaDescriptionItem2.setFont(new java.awt.Font("Arial Narrow", 0, 13)); // NOI18N
        txaDescriptionItem2.setRows(5);
        txaDescriptionItem2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry\n. Lorem Ipsum has been the industry's standard dummy text ever since t\nhe 1500s, when an unknown printer took a galley of type and scrambled it to m\nake a type specimen book. It has survived not only five centuries, but also the\n leap into electronic typesetting, remaining essentially unchanged. It was popula\nrised in the 1960s w");
        txaDescriptionItem2.setBorder(null);
        scrDescriptionItem2.setViewportView(txaDescriptionItem2);

        lblBrandItem2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBrandItem2.setText("BRAND");

        lblPriceItem2.setText("RM 100");

        lblNameItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblNameItem2.setText("MR CHAIR");

        javax.swing.GroupLayout pnlContentItem2Layout = new javax.swing.GroupLayout(pnlContentItem2);
        pnlContentItem2.setLayout(pnlContentItem2Layout);
        pnlContentItem2Layout.setHorizontalGroup(
            pnlContentItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentItem2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContentItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameItem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlContentItem2Layout.createSequentialGroup()
                        .addGroup(pnlContentItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPriceItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBrandItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(scrDescriptionItem2))
                .addContainerGap())
        );
        pnlContentItem2Layout.setVerticalGroup(
            pnlContentItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentItem2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameItem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBrandItem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPriceItem2)
                .addGap(18, 18, 18)
                .addComponent(scrDescriptionItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlItem2.add(pnlContentItem2);
        pnlContentItem2.setBounds(203, 1, 202, 197);

        lblImageItem2.setText("Image");
        lblImageItem2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlItem2.add(lblImageItem2);
        lblImageItem2.setBounds(33, 30, 140, 140);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
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

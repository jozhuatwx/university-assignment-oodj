/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class AddProductCataloguePage extends javax.swing.JFrame {
    int xMouse, yMouse;
    /**
     * Creates new form AddProductCatalogueForm
     */
    public AddProductCataloguePage() {
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

        pnlBackground = new javax.swing.JPanel();
        pnlCatalogue = new javax.swing.JPanel();
        pnlOption = new javax.swing.JPanel();
        lblPageNum = new javax.swing.JLabel();
        lblNumOfItem = new javax.swing.JLabel();
        lblItem1 = new javax.swing.JLabel();
        lblItem2 = new javax.swing.JLabel();
        lblItem3 = new javax.swing.JLabel();
        lblItem4 = new javax.swing.JLabel();
        cmbPageNum = new javax.swing.JComboBox<>();
        cmbNumOfItem = new javax.swing.JComboBox<>();
        cmbItem1 = new javax.swing.JComboBox<>();
        cmbItem2 = new javax.swing.JComboBox<>();
        cmbItem3 = new javax.swing.JComboBox<>();
        cmbItem4 = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        pnlFrameBar = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AddProductCatalogueForm");
        setBackground(new java.awt.Color(255, 0, 0));
        setName("AddProductCatalogueForm"); // NOI18N
        setUndecorated(true);

        pnlBackground.setBackground(new java.awt.Color(0, 0, 51));

        pnlCatalogue.setPreferredSize(new java.awt.Dimension(425, 600));

        javax.swing.GroupLayout pnlCatalogueLayout = new javax.swing.GroupLayout(pnlCatalogue);
        pnlCatalogue.setLayout(pnlCatalogueLayout);
        pnlCatalogueLayout.setHorizontalGroup(
            pnlCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        pnlCatalogueLayout.setVerticalGroup(
            pnlCatalogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlOption.setBackground(new java.awt.Color(46, 52, 66));

        lblPageNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblPageNum.setForeground(new java.awt.Color(255, 255, 255));
        lblPageNum.setText("Page Number :");

        lblNumOfItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblNumOfItem.setForeground(new java.awt.Color(255, 255, 255));
        lblNumOfItem.setText("Number of Item :");

        lblItem1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblItem1.setForeground(new java.awt.Color(255, 255, 255));
        lblItem1.setText("Item 1 :");

        lblItem2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblItem2.setForeground(new java.awt.Color(255, 255, 255));
        lblItem2.setText("Item 2 :");

        lblItem3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblItem3.setForeground(new java.awt.Color(255, 255, 255));
        lblItem3.setText("Item 3 :");

        lblItem4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lblItem4.setForeground(new java.awt.Color(255, 255, 255));
        lblItem4.setText("Item 4 :");

        cmbPageNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbNumOfItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbItem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbItem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbItem3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbItem4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSubmit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnSubmit.setText("Done");

        btnNext.setBackground(new java.awt.Color(46, 52, 66));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/arrow-right.png"))); // NOI18N
        btnNext.setBorder(null);

        btnBack.setBackground(new java.awt.Color(46, 52, 66));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/arrow-left.png"))); // NOI18N
        btnBack.setBorder(null);

        javax.swing.GroupLayout pnlOptionLayout = new javax.swing.GroupLayout(pnlOption);
        pnlOption.setLayout(pnlOptionLayout);
        pnlOptionLayout.setHorizontalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblPageNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNumOfItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblItem1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblItem2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPageNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbNumOfItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbItem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbItem2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addComponent(lblItem3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOptionLayout.createSequentialGroup()
                                .addComponent(lblItem4)
                                .addGap(109, 109, 109)
                                .addComponent(cmbItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        pnlOptionLayout.setVerticalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPageNum))
                .addGap(30, 30, 30)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumOfItem)
                    .addComponent(cmbNumOfItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItem1)
                    .addComponent(cmbItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItem2)
                    .addComponent(cmbItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItem3)
                    .addComponent(cmbItem3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbItem4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblItem4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlFrameBar.setBackground(new java.awt.Color(0, 0, 51));
        pnlFrameBar.setPreferredSize(new java.awt.Dimension(670, 65));
        pnlFrameBar.setRequestFocusEnabled(false);
        pnlFrameBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlFrameBarMouseDragged(evt);
            }
        });
        pnlFrameBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlFrameBarMousePressed(evt);
            }
        });

        lblClose.setBackground(new java.awt.Color(0, 0, 51));
        lblClose.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.setMaximumSize(new java.awt.Dimension(45, 25));
        lblClose.setMinimumSize(new java.awt.Dimension(45, 25));
        lblClose.setName("lblClose"); // NOI18N
        lblClose.setOpaque(true);
        lblClose.setPreferredSize(new java.awt.Dimension(45, 25));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });

        lblMinimize.setBackground(new java.awt.Color(0, 0, 51));
        lblMinimize.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblMinimize.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setText("-");
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.setMaximumSize(new java.awt.Dimension(45, 25));
        lblMinimize.setMinimumSize(new java.awt.Dimension(45, 25));
        lblMinimize.setName("lblMinimize"); // NOI18N
        lblMinimize.setOpaque(true);
        lblMinimize.setPreferredSize(new java.awt.Dimension(45, 25));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlFrameBarLayout = new javax.swing.GroupLayout(pnlFrameBar);
        pnlFrameBar.setLayout(pnlFrameBarLayout);
        pnlFrameBarLayout.setHorizontalGroup(
            pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlFrameBarLayout.setVerticalGroup(
            pnlFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameBarLayout.createSequentialGroup()
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnlCatalogue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlFrameBar, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCatalogue, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addComponent(pnlOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(830, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // Close the form
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        // To change the background colour to red colour
        lblClose.setBackground(Color.RED);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        // To change the background colour back to its original colour
        lblClose.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // Minimize the form.
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        // To change the background colour to light gray colour
        lblMinimize.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        // To change the background colour back to its original colour
        lblMinimize.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void pnlFrameBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFrameBarMouseDragged
        // To get the absolute x,y on the screen when being dragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        // Set the form to the location of (x,y)
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_pnlFrameBarMouseDragged

    private void pnlFrameBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFrameBarMousePressed
        // To get the x,y relative to the source component
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlFrameBarMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProductCataloguePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProductCataloguePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProductCataloguePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProductCataloguePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProductCataloguePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbItem1;
    private javax.swing.JComboBox<String> cmbItem2;
    private javax.swing.JComboBox<String> cmbItem3;
    private javax.swing.JComboBox<String> cmbItem4;
    private javax.swing.JComboBox<String> cmbNumOfItem;
    private javax.swing.JComboBox<String> cmbPageNum;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblItem1;
    private javax.swing.JLabel lblItem2;
    private javax.swing.JLabel lblItem3;
    private javax.swing.JLabel lblItem4;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblNumOfItem;
    private javax.swing.JLabel lblPageNum;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCatalogue;
    private javax.swing.JPanel pnlFrameBar;
    private javax.swing.JPanel pnlOption;
    // End of variables declaration//GEN-END:variables
}

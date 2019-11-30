/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productmanagement;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class ProductCategoryUniversalPanel extends javax.swing.JPanel {

    /** Creates new form CategoryUniversalPanel */
    public ProductCategoryUniversalPanel() {
        initComponents();
        close();
        
    }
        //Create a variable to check the panel is closed or opened
        boolean isClose;
        
        //Create a variable to check the textbox is enabled or disabled 
        boolean isEnabled = false;
    
    public void close(){
        //Set the pnlBackground to close(Resize it smaller to hide all the labels, textfield, buttons and textarea. )
        pnlTesting.setPreferredSize(new Dimension(712,50));
        pnlTesting.revalidate();
        pnlTesting.repaint();
        
        //Set the displaying label from invisible to visible
        lblShortDescription.setVisible(true);
        
        //When the panel is closed, set the boolean variable to true.
        isClose = true;    
    }

    public void open(){
        //If the panel is closed,then execute codes below:
        //Set the pnlBackground to open(Resize it larger to show all the labels, textfield, buttons and textarea. )
        pnlTesting.setPreferredSize(new Dimension(712,178));
        pnlTesting.revalidate();
        pnlTesting.repaint();
        
        //Set the displaying label to invisible
        lblShortDescription.setVisible(false);
        
        //When the panel is opened, set the boolean variable to false.
        isClose = false;
        
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTesting = new javax.swing.JPanel();
        pnlBackground = new javax.swing.JPanel();
        lblNum = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblShortDescription = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblControl = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(713, 180));

        pnlTesting.setPreferredSize(new java.awt.Dimension(712, 178));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlBackground.setPreferredSize(new java.awt.Dimension(712, 179));

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblNum.setText("1.");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtName.setText("Chooi Chun Wei");
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);

        lblNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText("ERROR");

        lblShortDescription.setText("DESCRIPTION OF ASDADSDASDASDSADASDASDASDSADADA");

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        lblStatus.setDisabledIcon(null);
        lblStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStatusMouseClicked(evt);
            }
        });

        lblControl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png"))); // NOI18N
        lblControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControlMouseClicked(evt);
            }
        });

        scrDescription.setPreferredSize(new java.awt.Dimension(241, 197));

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        txaDescription.setEnabled(false);
        scrDescription.setViewportView(txaDescription);

        lblDescriptionError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblDescriptionError.setForeground(new java.awt.Color(255, 0, 0));
        lblDescriptionError.setText("ERROR");

        lblEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Edit.png"))); // NOI18N
        lblEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNum)
                .addGap(30, 30, 30)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblShortDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblStatus)
                        .addGap(14, 14, 14))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)))
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNum)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblShortDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNameError))
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEdit)
                    .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescriptionError)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout pnlTestingLayout = new javax.swing.GroupLayout(pnlTesting);
        pnlTesting.setLayout(pnlTestingLayout);
        pnlTestingLayout.setHorizontalGroup(
            pnlTestingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        pnlTestingLayout.setVerticalGroup(
            pnlTestingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTesting, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTesting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlMouseClicked
        // Check if it is closed and enabled
        if(isClose && !isEnabled){
            open();
            
            // Change the icon from down to up
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-up.png")));

        }else if(!isClose && !isEnabled){
            close();

            // Change the icon from up to down
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png")));
        }
    }//GEN-LAST:event_lblControlMouseClicked

    private void lblStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatusMouseClicked
        
        if(isEnabled){
        System.out.println("success");

        // Change the icon from On to Off
        lblStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
        }
    }//GEN-LAST:event_lblStatusMouseClicked

    private void lblEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditMouseClicked
        
        if(isEnabled == false){
            txtName.setEnabled(true);
            scrDescription.setEnabled(true);
            txaDescription.setEnabled(true);
            lblControl.setEnabled(false);
            
            // Change the icon from edit icon to save icon
            lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Save.png")));
            
            //When the textbox is enabled, set the boolean variable to true.
            isEnabled = true;
          
        }else{
            txtName.setEnabled(false);
            scrDescription.setEnabled(false);
            txaDescription.setEnabled(false);
            lblControl.setEnabled(true);
            
            // Change the icon from save icon to edit icon
            lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));
            
            //When the textbox is enabled, set the boolean variable to true.
            isEnabled = false;
        }
    }//GEN-LAST:event_lblEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblShortDescription;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlTesting;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}
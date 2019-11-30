package productmanagement;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class ProductCategoryUniversalPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int MAIN_MAX_HEIGHT = 217;
    public static final int MAIN_MIN_HEIGHT = 77;
    public static final int MAIN_WIDTH = 755;
    public static final int PANEL_MAX_HEIGHT = 195;
    public static final int PANEL_MIN_HEIGHT = 55;
    public static final int PANEL_WIDTH = 735;

    // Product Category information
    ProductCategory category;

    // Create a variable to check the panel is closed or opened
    boolean isClosed;
    
    // Create a variable to check the textbox is enabled or disabled 
    boolean isEditing = false;

    public ProductCategoryUniversalPanel(ProductCategory category, int i) {
        initComponents();
        // Hide the Panel
        hidePanel();     
        // Set the Product Category information
        this.category = category;
        // Set the list number
        lblNum.setText(String.valueOf(i) + ".");
        resetFields();
    }
    
    public void hidePanel(){
        // Resize the Panel and hide the components inside
        pnlBox.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MIN_HEIGHT));
        pnlBox.revalidate();
        pnlBox.repaint();

        setPreferredSize(new Dimension(MAIN_WIDTH, MAIN_MIN_HEIGHT));
        revalidate();
        repaint();
        
        // Set the displaying label from invisible to visible
        lblShortDescription.setVisible(true);
        
        // When the panel is closed, set the boolean variable to true.
        isClosed = true;    
    }

    public void showPanel(){
        // Resize the Panel and show the components inside
        pnlBox.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MAX_HEIGHT));
        pnlBox.revalidate();
        pnlBox.repaint();

        setPreferredSize(new Dimension(MAIN_WIDTH, MAIN_MAX_HEIGHT));
        revalidate();
        repaint();
        
        // Set the displaying label to invisible
        lblShortDescription.setVisible(false);
        
        // When the panel is opened, set the boolean variable to false.
        isClosed = false;
    }

    private void resetFields() {
        // Fill the fields with Product Category information
        txtName.setText(category.getCategoryName());
        lblShortDescription.setText(category.getCategoryDescription());
        txaDescription.setText(category.getCategoryDescription());

        switch (category.getCategoryStatus()) {
            case ProductCategory.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                break;
        
            case ProductCategory.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                break;
        }
    }

    // Validation
    private boolean validateName(String categoryName) {
        boolean validated = true;

        if (categoryName.length() <= 0) {
            lblNameError.setText("Category Name cannot be empty");
            validated = false;
        } else if (!categoryName.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
            lblNameError.setText("Please enter a valid name");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateDescription(String categoryDescription) {
        boolean validated = true;

        if (categoryDescription.contains(";")) {
            lblDescriptionError.setText("Category Description cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblDescriptionError.setText(" ");
        }
        return validated;
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBox = new javax.swing.JPanel();
        pnlBackground = new javax.swing.JPanel();
        lblNum = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblShortDescription = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();
        lblControl = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));
        setPreferredSize(new java.awt.Dimension(755, 217));

        pnlBox.setPreferredSize(new java.awt.Dimension(735, 195));
        pnlBox.setLayout(new javax.swing.BoxLayout(pnlBox, javax.swing.BoxLayout.LINE_AXIS));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum.setText("1.");
        lblNum.setPreferredSize(new java.awt.Dimension(40, 30));

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtName.setText("Name");
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);
        txtName.setPreferredSize(new java.awt.Dimension(250, 30));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        lblNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText(" ");

        lblShortDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblShortDescription.setText(" ");
        lblShortDescription.setPreferredSize(new java.awt.Dimension(250, 30));

        scrDescription.setPreferredSize(new java.awt.Dimension(241, 197));

        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txaDescription.setRows(4);
        txaDescription.setText("Description");
        txaDescription.setEnabled(false);
        txaDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txaDescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaDescriptionFocusLost(evt);
            }
        });
        txaDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDescriptionKeyReleased(evt);
            }
        });
        scrDescription.setViewportView(txaDescription);

        lblDescriptionError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblDescriptionError.setForeground(new java.awt.Color(255, 0, 0));
        lblDescriptionError.setText(" ");

        btnStatus.setBackground(new java.awt.Color(255, 255, 255));
        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        btnStatus.setBorder(null);
        btnStatus.setDisabledIcon(null);
        btnStatus.setMaximumSize(new java.awt.Dimension(30, 30));
        btnStatus.setMinimumSize(new java.awt.Dimension(30, 30));
        btnStatus.setPreferredSize(new java.awt.Dimension(30, 30));
        btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatusMouseClicked(evt);
            }
        });

        lblControl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png"))); // NOI18N
        lblControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblControl.setMaximumSize(new java.awt.Dimension(30, 30));
        lblControl.setMinimumSize(new java.awt.Dimension(30, 30));
        lblControl.setPreferredSize(new java.awt.Dimension(30, 30));
        lblControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblControlMouseClicked(evt);
            }
        });

        lblEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Edit.png"))); // NOI18N
        lblEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEdit.setMaximumSize(new java.awt.Dimension(30, 30));
        lblEdit.setMinimumSize(new java.awt.Dimension(30, 30));
        lblEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        lblEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(lblShortDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDescriptionError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblShortDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNameError)))
                        .addGap(18, 20, Short.MAX_VALUE)
                        .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescriptionError)))
                .addContainerGap())
        );

        pnlBox.add(pnlBackground);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlMouseClicked
        if (isClosed && !isEditing){
            showPanel();
            
            // Change the icon from down to up
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-up.png")));

        } else if (!isClosed && !isEditing){
            hidePanel();

            // Change the icon from up to down
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png")));
        }
    }//GEN-LAST:event_lblControlMouseClicked

    private void btnStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseClicked
        if (isEditing) {
            String categoryStatus = ProductCategory.ACTIVE;
            // Set new Product Category status as active or inactive
            switch (category.getCategoryStatus()) {
                case ProductCategory.ACTIVE:
                    categoryStatus = ProductCategory.INACTIVE;
                    break;
            
                case ProductCategory.INACTIVE:
                    categoryStatus = ProductCategory.ACTIVE;
                    break;
            }
            
            // Update the Category status
            ProductCategory modifiedCategory = new ProductCategory(category.getCategoryId(), category.getCategoryName(), category.getCategoryDescription(), categoryStatus);
            if (ProductCategory.modify(modifiedCategory)) {
                category = modifiedCategory;
                resetFields();
            }
        }
    }//GEN-LAST:event_btnStatusMouseClicked

    private void lblEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditMouseClicked
        if (!isEditing) {
            // Enable the editing of fields
            txtName.setEnabled(true);
            scrDescription.setEnabled(true);
            txaDescription.setEnabled(true);
            lblControl.setEnabled(false);
            lblControl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            btnStatus.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            // Change the icon from edit icon to save icon
            lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Save.png")));
            
            // When the textbox is enabled, set the boolean variable to true.
            isEditing = true;
        } else {
            boolean validated = true;

            String categoryName = txtName.getText().trim();
            String categoryDescription = txaDescription.getText().trim();
            
            // Validate
            if (!validateName(categoryName)) {
                validated = false;
            }

            if (!validateDescription(categoryDescription)) {
                validated = false;
            }

            if (validated) {
                // Register the Product Category if no error
                ProductCategory modifiedCategory = new ProductCategory(category.getCategoryId(), categoryName, categoryDescription, category.getCategoryStatus());
                if (ProductCategory.modify(modifiedCategory)) {
                    category = modifiedCategory;
                    resetFields();

                    // Disable the editing of fields
                    txtName.setEnabled(false);
                    scrDescription.setEnabled(false);
                    txaDescription.setEnabled(false);
                    lblControl.setEnabled(true);
                    lblControl.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    btnStatus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    
                    // Change the icon from save icon to edit icon
                    lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));
                    
                    // When the textbox is enabled, set the boolean variable to true.
                    isEditing = false;
                }
            }
        }
    }//GEN-LAST:event_lblEditMouseClicked

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String categoryName = txtName.getText().trim();
        validateName(categoryName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String categoryName = txtName.getText().trim();
        validateName(categoryName);
        if (categoryName.equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescriptionKeyReleased
        String categoryDescription = txaDescription.getText().trim();
        validateDescription(categoryDescription);
    }//GEN-LAST:event_txaDescriptionKeyReleased

    private void txaDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusLost
        String categoryDescription = txaDescription.getText().trim();
        validateDescription(categoryDescription);
        if (categoryDescription.equalsIgnoreCase("")) {
            txaDescription.setText("Description");
        }
    }//GEN-LAST:event_txaDescriptionFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().trim().equalsIgnoreCase("Name")) {
            txtName.setText("");
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txaDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusGained
        if (txaDescription.getText().trim().equalsIgnoreCase("Description")) {
            txaDescription.setText("");
        }
    }//GEN-LAST:event_txaDescriptionFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblShortDescription;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBox;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}

package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductCategoryPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int PANEL_MAX_HEIGHT = 359;
    public static final int PANEL_MIN_HEIGHT = 61;
    public static final int PANEL_WIDTH = 755;

    MainForm main;

    public ProductCategoryPanel(MainForm main) {
        initComponents();
        this.main = main;
        // Hide the Panel
        hideAddPanel();
        // Populate the list with Categories
        repopulateCategoriesList();
    }
    
    private void showAddPanel() {
        // Resize the Panel and show the components inside
        pnlAddCategory.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MAX_HEIGHT));
        pnlAddCategory.revalidate();
        pnlAddCategory.repaint();
        
        // Disable the button
        btnAdd.setEnabled(false);
    }

    private void hideAddPanel() {
        // Resize the Panel and hide the components inside
        pnlAddCategory.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MIN_HEIGHT));
        pnlAddCategory.revalidate();
        pnlAddCategory.repaint();
        
        // Enable the button
        btnAdd.setEnabled(true);
    }
    
    private void resetFields() {
        txtName.setText("Name");
        txaDescription.setText("Description");
        lblNameError.setText(" ");
        lblDescriptionError.setText(" ");
    }

    private void repopulateCategoriesList() {
        // Remove all existing Categories
        pnlCategoryList.removeAll();

        int i = 0;
        ArrayList<String> categoryArray = ReadObject.readArray(ProductCategory.FILE_NAME);
        // Iterate through the Product Category array
        for (; i < categoryArray.size(); i++) {
            // Split the line into an array
            String[] details = categoryArray.get(i).split(";");
            // Create a Product Category object with the details
            ProductCategory category = new ProductCategory(details);
            // Create a Universal Panel object with the Category object
            ProductCategoryUniversalPanel pcup = new ProductCategoryUniversalPanel(main, category, i + 1);
            // Set the size of the Universal Panel
            pcup.setPreferredSize(new Dimension(ProductCategoryUniversalPanel.MAIN_WIDTH, ProductCategoryUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlCategoryList.add(pcup);
        }
        // Fill remaining space with an empty box
        if (i * ProductCategoryUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlCategoryList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductCategoryUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlCategoryList.revalidate();
    }

    private void search() {
        String keyword = txtSearch.getText().trim();

        hideAddPanel();
        // Remove all existing Product Categories
        pnlCategoryList.removeAll();

        int i = 0;
        // Get an array list of the Product Categories matching the keyword
        ArrayList<ProductCategory> categoryArray = ProductCategory.search(keyword);
        for (; i < categoryArray.size(); i++) {
            // Create a Universal Panel object with the Prodect Category object
            ProductCategoryUniversalPanel pcup = new ProductCategoryUniversalPanel(main, categoryArray.get(i), i + 1);
            // Set the size of the Universal Panel object
            pcup.setPreferredSize(new Dimension(ProductCategoryUniversalPanel.MAIN_WIDTH, ProductCategoryUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlCategoryList.add(pcup);
        }
        // Fill remaining space with an empty box
        if (i * ProductCategoryUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlCategoryList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductCategoryUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlCategoryList.revalidate();
        pnlCategoryList.revalidate();
        pnlCategoryList.repaint();
    }

    // Validation
    private boolean validateName(String categoryName) {
        boolean validated = true;
        
        if (categoryName.length() <= 0 || categoryName.equalsIgnoreCase("Name")) {
            lblNameError.setText("Category Name cannot be empty");
            validated = false;
        } else if (categoryName.contains(";")) {
            lblNameError.setText("Category Name cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateDescription(String categoryDescription) {
        boolean validated = true;
        
        if (categoryDescription.length() <= 0 || categoryDescription.equalsIgnoreCase("Description")) {
            lblDescriptionError.setText("Category Description cannot be empty");
            validated = false;
        }else if (categoryDescription.contains(";")) {
            lblDescriptionError.setText("Category Description cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblDescriptionError.setText(" ");
        }
        return validated;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAddCategory = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        pnlAddCategoryForm = new javax.swing.JPanel();
        lblAddCategory = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrCategoryList = new javax.swing.JScrollPane();
        pnlCategoryList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));
        setMinimumSize(new java.awt.Dimension(775, 485));
        setName("CategoryPanel"); // NOI18N

        pnlAddCategory.setBackground(new java.awt.Color(46, 52, 66));
        pnlAddCategory.setPreferredSize(new java.awt.Dimension(755, 359));

        txtSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setText("Search");
        txtSearch.setBorder(null);
        txtSearch.setPreferredSize(new java.awt.Dimension(407, 37));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(46, 52, 66));
        btnAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setPreferredSize(new java.awt.Dimension(150, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        pnlAddCategoryForm.setBackground(new java.awt.Color(18, 22, 31));
        pnlAddCategoryForm.setPreferredSize(new java.awt.Dimension(735, 292));

        lblAddCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblAddCategory.setText("Add Category");
        lblAddCategory.setPreferredSize(new java.awt.Dimension(110, 20));

        lblName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name :");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtName.setText("Name");
        txtName.setBorder(null);
        txtName.setPreferredSize(new java.awt.Dimension(350, 30));
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

        lblDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description :");

        scrDescription.setToolTipText("");

        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txaDescription.setRows(4);
        txaDescription.setText("Description");
        txaDescription.setBorder(null);
        txaDescription.setLineWrap(true);
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

        btnSubmit.setBackground(new java.awt.Color(46, 52, 66));
        btnSubmit.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Add");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setPreferredSize(new java.awt.Dimension(150, 40));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(46, 52, 66));
        btnCancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddCategoryFormLayout = new javax.swing.GroupLayout(pnlAddCategoryForm);
        pnlAddCategoryForm.setLayout(pnlAddCategoryFormLayout);
        pnlAddCategoryFormLayout.setHorizontalGroup(
            pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCategoryFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddCategoryFormLayout.createSequentialGroup()
                        .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblDescription))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlAddCategoryFormLayout.createSequentialGroup()
                        .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrDescription)
                            .addGroup(pnlAddCategoryFormLayout.createSequentialGroup()
                                .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddCategoryFormLayout.createSequentialGroup()
                                .addComponent(lblDescriptionError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(59, 59, 59)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnlAddCategoryFormLayout.setVerticalGroup(
            pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddCategoryFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameError)
                .addGap(18, 18, 18)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddCategoryFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDescriptionError))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAddCategoryLayout = new javax.swing.GroupLayout(pnlAddCategory);
        pnlAddCategory.setLayout(pnlAddCategoryLayout);
        pnlAddCategoryLayout.setHorizontalGroup(
            pnlAddCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddCategoryForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAddCategoryLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAddCategoryLayout.setVerticalGroup(
            pnlAddCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAddCategoryForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrCategoryList.setBackground(new java.awt.Color(46, 52, 66));
        scrCategoryList.setBorder(null);
        scrCategoryList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrCategoryList.setMinimumSize(new java.awt.Dimension(755, 385));
        scrCategoryList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrCategoryList.getVerticalScrollBar().setUnitIncrement(16);

        pnlCategoryList.setBackground(new java.awt.Color(46, 52, 66));
        pnlCategoryList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlCategoryList.setLayout(new javax.swing.BoxLayout(pnlCategoryList, javax.swing.BoxLayout.Y_AXIS));
        scrCategoryList.setViewportView(pnlCategoryList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrCategoryList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrCategoryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("CategoryPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!main.isEditing) {
            showAddPanel();
            resetFields();
            main.isEditing = true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You have unsaved work. Please save it first.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        hideAddPanel();
        resetFields();
        main.isEditing = false;
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
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
            ProductCategory category = new ProductCategory(ProductCategory.generateCategoryId(), categoryName, categoryDescription, ProductCategory.ACTIVE);
            if (ProductCategory.register(category)) {
                resetFields();
                repopulateCategoriesList();
                main.isEditing = false;
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().trim().equalsIgnoreCase("Search")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().trim().equalsIgnoreCase("")) {
            txtSearch.setText("Search");
        }
    }//GEN-LAST:event_txtSearchFocusLost

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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblAddCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JPanel pnlAddCategory;
    private javax.swing.JPanel pnlAddCategoryForm;
    private javax.swing.JPanel pnlCategoryList;
    private javax.swing.JScrollPane scrCategoryList;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

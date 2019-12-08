package productmanagement;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SupplierUniversalPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int MAIN_MAX_HEIGHT = 168;
    public static final int MAIN_MIN_HEIGHT = 77;
    public static final int MAIN_WIDTH = 755;
    public static final int PANEL_MAX_HEIGHT = 143;
    public static final int PANEL_MIN_HEIGHT = 55;
    public static final int PANEL_WIDTH = 735;

    MainForm main;

    // Supplier information
    Supplier supplier;
    
    // Create a variable to check the panel is closed or opened
    boolean isClosed;
    
    // Create a variable to check the textbox is enabled or disabled 
    boolean isEditing = false;
    
    // Create a variable to check the supplierStatus is activated or deactivated
    boolean isActivated;

    public SupplierUniversalPanel(MainForm main, Supplier supplier, int i) {
        initComponents();
        this.main = main;
        // Hide edit button for Product Manager
        if (ProductManager.isProductManager()) {
            lblEdit.setVisible(false);
            btnStatus.setEnabled(false);
        }         
        // Hide the Panel
        hidePanel();
        // Set the Supplier information
        this.supplier = supplier;
        // Set the list number
        lblNum.setText(String.valueOf(i) + ".");
        resetFields();
    }
    
    private void hidePanel() {
        // Resize the Panel and hide the components inside
        pnlBackground.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MIN_HEIGHT));
        pnlBackground.revalidate();
        pnlBackground.repaint();

        setPreferredSize(new Dimension(MAIN_WIDTH, MAIN_MIN_HEIGHT));
        revalidate();
        repaint();

        // When the panel is closed, set the boolean variable to true.
        isClosed = true;
    }
    
    private void showPanel() {
        // Resize the Panel and show the components inside
        pnlBackground.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MAX_HEIGHT));
        pnlBackground.revalidate();
        pnlBackground.repaint();

        setPreferredSize(new Dimension(MAIN_WIDTH, MAIN_MAX_HEIGHT));
        revalidate();
        repaint();
        
        // When the panel is opened, set the boolean variable to false.
        isClosed = false;
    }

    private void resetFields() {
        // Fill the fields with Supplier information
        txtName.setText(supplier.getSupplierName());
        txtEmail.setText(supplier.getSupplierEmail());
        txtContact.setText(supplier.getSupplierContact());
        txtAddress.setText(supplier.getSupplierAddress());

        switch (supplier.getSupplierStatus()) {
            case Supplier.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                lblEdit.setEnabled(true);
                isActivated = true;
                break;
        
            case Supplier.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                lblEdit.setEnabled(false);
                isActivated = false;
                break;
        }
        
        lblNameError.setText(" ");
        lblAddressError.setText(" ");
        lblContactError.setText(" ");
        lblEmailError.setText(" ");
    }

    // Validation
    private boolean validateName(String supplierName) {
        boolean validated = true;

        if (supplierName.length() <= 0 || supplierName.equalsIgnoreCase("Name")) {
            lblNameError.setText("Supplier Name cannot be empty");
            validated = false;
        } else if (supplierName.contains(";")) {
            lblNameError.setText("Supplier Name cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateAddress(String supplierAddress) {
        boolean validated = true;

        if (supplierAddress.length() <= 0 || supplierAddress.equalsIgnoreCase("Address")) {
            lblAddressError.setText("Supplier Address cannot be empty");
            validated = false;
        } else if (supplierAddress.contains(";")) {
            lblAddressError.setText("Supplier Address cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblAddressError.setText(" ");
        }
        return validated;
    }

    private boolean validateEmail(String supplierEmail) {
        boolean validated = true;

        if (supplierEmail.length() <= 0 || supplierEmail.equalsIgnoreCase("Email")) {
            lblEmailError.setText("Supplier Email cannot be empty");
            validated = false;
        } else if (!supplierEmail.matches("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?")) {
            lblEmailError.setText("Please enter a valid email");
            validated = false;
        }

        if (validated) {
            lblEmailError.setText(" ");
        }
        return validated;
    }

    private boolean validateContact(String supplierContact) {
        boolean validated = true;

        if (supplierContact.length() <= 0) {
            lblContactError.setText("Supplier contact cnnot be empty");
            validated = false;
        } else if (!supplierContact.matches("^(|\\+6)(?:[0-9]( |-)?){9,10}[0-9]")) {
            lblContactError.setText("Please enter a valid contact");
            validated = false;
        }

        if (validated) {
            lblContactError.setText(" ");
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

        pnlBackground = new javax.swing.JPanel();
        lblNum = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailError = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        lblContactError = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddressError = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();
        lblControl = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));
        setMinimumSize(new java.awt.Dimension(755, 50));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum.setText("1.");
        lblNum.setPreferredSize(new java.awt.Dimension(40, 30));

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
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

        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtEmail.setText("Email");
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEmail.setEnabled(false);
        txtEmail.setPreferredSize(new java.awt.Dimension(250, 30));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        lblEmailError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setText(" ");

        txtContact.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtContact.setText("Contact");
        txtContact.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtContact.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtContact.setEnabled(false);
        txtContact.setPreferredSize(new java.awt.Dimension(250, 30));
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });
        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContactKeyReleased(evt);
            }
        });

        lblContactError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblContactError.setForeground(new java.awt.Color(255, 0, 0));
        lblContactError.setText(" ");

        txtAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtAddress.setText("Address");
        txtAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAddress.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAddress.setEnabled(false);
        txtAddress.setPreferredSize(new java.awt.Dimension(250, 30));
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });

        lblAddressError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblAddressError.setForeground(new java.awt.Color(255, 0, 0));
        lblAddressError.setText(" ");

        btnStatus.setBackground(new java.awt.Color(255, 255, 255));
        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        btnStatus.setBorder(null);
        btnStatus.setMaximumSize(new java.awt.Dimension(30, 30));
        btnStatus.setMinimumSize(new java.awt.Dimension(30, 30));
        btnStatus.setPreferredSize(new java.awt.Dimension(30, 30));
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
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
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContactError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAddressError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNameError))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmailError))
                            .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAddressError))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContactError)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlMouseClicked
        if (isClosed && !isEditing) {
            showPanel();
            // Change the icon from down to up
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-up.png")));
        } else if (!isClosed && !isEditing) {
            hidePanel();
            // Change the icon from up to down
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png")));
        }
    }//GEN-LAST:event_lblControlMouseClicked

    private void lblEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditMouseClicked
        if (isActivated) {
            if (!isEditing && !main.isEditing) {
                // Enable editing of fields
                txtName.setEnabled(true);
                txtEmail.setEnabled(true);
                txtContact.setEnabled(true);
                txtAddress.setEnabled(true);
                lblControl.setEnabled(false);
                lblControl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                // Disable editing of btnStatus
                btnStatus.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnStatus.setEnabled(false);

                // Change the icon from edit icon to save icon
                lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Save.png")));
                
                // When the textbox is enabled, set the boolean variable to true.
                isEditing = true;
                main.isEditing = true;
            } else if (!isEditing && main.isEditing) {
                JOptionPane.showMessageDialog(new JFrame(), "You have unsaved work. Please save it first.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                boolean validated = true;
            
                String supplierName = txtName.getText().trim();
                String supplierAddress = txtAddress.getText().trim();
                String supplierEmail = txtEmail.getText().trim();
                String supplierContact = txtContact.getText().trim();
                
                // Validation
                if (!validateName(supplierName)) {
                    validated = false;
                }

                if (!validateAddress(supplierAddress)) {
                    validated = false;
                }

                if (!validateEmail(supplierEmail)) {
                    validated = false;
                }

                if (!validateContact(supplierContact)) {
                    validated = false;
                }

                if (validated) {
                    // Update the Supplier if no error
                    Supplier modifiedSupplier = new Supplier(supplier.getSupplierId(), supplierName, supplierAddress, supplierEmail, supplierContact, supplier.getSupplierStatus());
                    if (Supplier.modify(modifiedSupplier, supplier.getSupplierStatus())) {
                        supplier = modifiedSupplier;
                        resetFields();
                        
                        // Disable the editing of fields
                        txtName.setEnabled(false);
                        txtEmail.setEnabled(false);
                        txtContact.setEnabled(false);
                        txtAddress.setEnabled(false);
                        lblControl.setEnabled(true);
                        lblControl.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        // Enable the editing of btn Status
                        btnStatus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        btnStatus.setEnabled(true);

                        // Change the icon from save icon to edit icon
                        lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));
                        
                        // When the textbox is enabled, set the boolean variable to true.
                        isEditing = false;
                        main.isEditing = false;
                    }
                }
            }
        }
    }//GEN-LAST:event_lblEditMouseClicked

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String supplierName = txtName.getText().trim();
        validateName(supplierName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String supplierName = txtName.getText().trim();
        validateName(supplierName);
        
        if (txtName.getText().trim().equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        String supplierAddress = txtAddress.getText().trim();
        validateAddress(supplierAddress);
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        String supplierAddress = txtAddress.getText().trim();
        validateAddress(supplierAddress);
        
        if (txtAddress.getText().trim().equalsIgnoreCase("")) {
            txtAddress.setText("Address");
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyReleased
        String supplierContact = txtContact.getText().trim();
        validateContact(supplierContact);
    }//GEN-LAST:event_txtContactKeyReleased

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost
        String supplierContact = txtContact.getText().trim();
        validateContact(supplierContact);
        
        if (txtContact.getText().trim().equalsIgnoreCase("")) {
            txtContact.setText("Contact");
        }
    }//GEN-LAST:event_txtContactFocusLost

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        String supplierEmail = txtEmail.getText().trim();
        validateEmail(supplierEmail);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String supplierEmail = txtEmail.getText().trim();
        validateEmail(supplierEmail);
        
        if (txtEmail.getText().trim().equalsIgnoreCase("")) {
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().trim().equalsIgnoreCase("Name")) {
            txtName.setText("");
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().trim().equalsIgnoreCase("Email")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusGained
        if (txtContact.getText().trim().equalsIgnoreCase("Contact")) {
            txtContact.setText("");
        }
    }//GEN-LAST:event_txtContactFocusGained

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        if (txtAddress.getText().trim().equalsIgnoreCase("Address")) {
            txtAddress.setText("");
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
            String supplierStatus = Supplier.ACTIVE;
            // Set new Supplier status as active or inactive
            switch (supplier.getSupplierStatus()) {
                case Supplier.ACTIVE:
                    supplierStatus = Supplier.INACTIVE;
                    lblEdit.setEnabled(false);
                    isActivated = false;
                    break;
            
                case Supplier.INACTIVE:
                    supplierStatus = Supplier.ACTIVE;
                    lblEdit.setEnabled(true);
                    isActivated = true;
                    break;
            }
            
            // Update the Supplier status
            Supplier modifiedSupplier = new Supplier(supplier.getSupplierId(), supplier.getSupplierName(), supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierContact(), supplierStatus);
            if (Supplier.modify(modifiedSupplier, supplier.getSupplierStatus())) {
                supplier = modifiedSupplier;
                resetFields();
            }
    }//GEN-LAST:event_btnStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JLabel lblAddressError;
    private javax.swing.JLabel lblContactError;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductManagerUniversalPanel extends javax.swing.JPanel {
    ProductManager productManager;

    // Create a variable to check the panel is closed or opened
    boolean isClosed;

    // Create a variable to check the textbox is enabled or disabled 
    boolean isEditing = false;

    public ProductManagerUniversalPanel(ProductManager productManager, int i) {
        initComponents();
        this.productManager = productManager;
        lblNum.setText(String.valueOf(i) + ".");
        hidePanel();
        resetFields();
    }
        
    public void hidePanel(){
        // Set the pnlBackground to close(Resize it smaller to hide all the labels, textfield, buttons and textarea. )
        pnlBackground.setPreferredSize(new Dimension(713,63));
        pnlBackground.revalidate();
        pnlBackground.repaint();

        // When the panel is closed, set the boolean variable to true.
        isClosed = true;    
    }
    
    public void showPanel(){
        // If the panel is closed,then execute codes below:
        // Set the pnlBackground to open(Resize it larger to show all the labels, textfield, buttons and textarea. )
        pnlBackground.setPreferredSize(new Dimension(712,136));
        pnlBackground.revalidate();
        pnlBackground.repaint();
           
        // When the panel is opened, set the boolean variable to false.
        isClosed = false;
    }

    private void resetFields() {
        txtName.setText(productManager.getUserName());
        txtLoginName.setText(productManager.getUserLoginName());
        txtLoginName.setEnabled(false);
        txtEmail.setText(productManager.getUserAddress());
        txtAddress.setText(productManager.getUserAddress());

        switch (productManager.getProductManagerStatus()) {
            case ProductManager.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                break;
        
            case ProductManager.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                break;
        }
    }

    // Validation
    private boolean validateName(String userName) {
        boolean validated = true;

        if (userName.length() <= 0) {
            lblNameError.setText("Product Manager Name cannot be empty");
            validated = false;
        } else if (!userName.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
            lblNameError.setText("Please enter a valid name");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }  

    private boolean validateLoginName(String userLoginName) {
        boolean validated = true;

        if (userLoginName.length() <= 0) {
            lblLoginNameError.setText("Product Manager Login Name cannot be empty");
            validated = false;
        }

        if (validated) {
            lblLoginNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateAddress(String userAddress) {
        boolean validated = true;

        if (userAddress.length() <= 0) {
            lblAddressError.setText("Product Manager Address cannot be empty");
            validated = false;
        }
        
        if (validated) {
            lblAddressError.setText(" ");
        }
        return validated;
    }

    private boolean validateEmail(String userEmail) {
        boolean validated = true;

        if (userEmail.length() <= 0) {
            lblEmailError.setText("Product Manager Email cannot be empty");
            validated = false;
        } else if (!userEmail.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")) {
            lblEmailError.setText("Please enter a valid email");
            validated = false;
        }

        if (validated) {
            lblEmailError.setText(" ");
        }
        return validated;
    }

    private boolean validatePassword(char[] userPassword) {
        boolean validated = true;

        String passwordString = new String(userPassword);

        if (userPassword.length <= 8) {
            lblNewPasswordError.setText("New Password cannot be less than 8 characters");
            validated = false;
        } else if (userPassword.length > 16) {
            lblNewPasswordError.setText("New Password cannot be more than 16 characters");
            validated = false;
        } else if (passwordString.matches(";")) {
            lblNewPasswordError.setText("New Password cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblNewPasswordError.setText(" ");
        }
        return validated;
    }

    private boolean validateConfirmPassword(char[] userPassword, char[] confirmPassword) {
        boolean validated = true;

        if (userPassword.equals(confirmPassword)) {
            lblConfirmPasswordError.setText("Confirm New Password does not match");
            validated = false;
        }

        if (validated) {
            lblConfirmPasswordError.setText(" ");
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
        btnStatus = new javax.swing.JButton();
        lblControl = new javax.swing.JLabel();
        txtLoginName = new javax.swing.JTextField();
        lblLoginNameError = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddressError = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        chkUpdatePassword = new javax.swing.JCheckBox();
        txtNewPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblConfirmPasswordError = new javax.swing.JLabel();
        lblNewPasswordError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNum.setText("1.");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);

        lblNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText("ERROR");

        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEmail.setEnabled(false);

        lblEmailError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setText("ERROR");

        btnStatus.setBackground(new java.awt.Color(255, 255, 255));
        btnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png"))); // NOI18N
        btnStatus.setBorder(null);
        btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatusMouseClicked(evt);
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

        txtLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtLoginName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtLoginName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLoginName.setEnabled(false);

        lblLoginNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblLoginNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblLoginNameError.setText("ERROR");

        txtAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAddress.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAddress.setEnabled(false);

        lblAddressError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblAddressError.setForeground(new java.awt.Color(255, 0, 0));
        lblAddressError.setText("ERROR");

        lblEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/Edit.png"))); // NOI18N
        lblEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditMouseClicked(evt);
            }
        });

        chkUpdatePassword.setText("Update Password");

        lblConfirmPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblConfirmPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmPasswordError.setText("ERROR");

        lblNewPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNewPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblNewPasswordError.setText("ERROR");

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNum)
                .addGap(30, 30, 30)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLoginName)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addComponent(lblLoginNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkUpdatePassword)
                    .addComponent(lblNewPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(btnStatus))
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEdit)
                            .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddressError, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblControl, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNum)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmailError)
                    .addComponent(lblNameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblEdit)
                        .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddressError)
                    .addComponent(lblLoginNameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkUpdatePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPasswordError)
                    .addComponent(lblNewPasswordError))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseClicked
        if (isEditing) {
            String productManagerStatus = ProductManager.ACTIVE;
            switch (productManager.getProductManagerStatus()) {
                case ProductManager.ACTIVE:
                    productManagerStatus = Supplier.INACTIVE;
                    break;
            
                case ProductManager.INACTIVE:
                    productManagerStatus = Supplier.ACTIVE;
                    break;
            }

            // Get the password
            ArrayList<String> userArray = ReadObject.readArray(User.FILE_NAME);

            // Iterate through the User array
            for (String user : userArray) {
                // Split each line into an array
                String[] details = user.split(";");
                // Find the User id in the array list
                if (details[0].equalsIgnoreCase(productManager.getUserId())) {
                    String userPassword = details[6];
                    // Create a Product Manager object
                    ProductManager modifiedProductManager = new ProductManager(productManager.getUserId(), productManager.getUserName(), productManager.getUserAddress(), productManager.getUserEmail(), productManager.getUserLoginName(), userPassword, productManagerStatus);
                    // Update the Product Manager
                    if (ProductManager.modify(modifiedProductManager, false)) {
                        productManager = modifiedProductManager;
                        resetFields();

                        // Change the icon from save icon to edit icon
                        lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));
                        
                        // When the textbox is enabled, set the boolean variable to true.
                        isEditing = false;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnStatusMouseClicked

    private void lblControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblControlMouseClicked
        if (isClosed && !isEditing) {
            showPanel();

            // Change the icon from down to up
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-up.png")));

        } else if (!isClosed && !isEditing){
            hidePanel();

            // Change the icon from up to down
            lblControl.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Black-arrow-down.png")));
        }
    }//GEN-LAST:event_lblControlMouseClicked

    private void lblEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditMouseClicked
        if (!isEditing) {
            txtName.setEnabled(true);
            txtEmail.setEnabled(true);
            txtLoginName.setEnabled(true);
            txtAddress.setEnabled(true);
            lblControl.setEnabled(false);

            // Change the icon from edit icon to save icon
            lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Save.png")));

            // When the textbox is enabled, set the boolean variable to true.
            isEditing = true;

        } else {
            txtName.setEnabled(false);
            txtEmail.setEnabled(false);
            txtLoginName.setEnabled(false);
            txtAddress.setEnabled(false);
            lblControl.setEnabled(true);

            boolean validated = true;

            String userId = User.myUser.getUserId();
            String userName = txtName.getText().trim();
            String userAddress = txtAddress.getText().trim();
            String userEmail = txtEmail.getText().trim();
            String userLoginName = User.myUser.getUserLoginName();

            char[] newPassword = txtNewPassword.getPassword();
            char[] confirmPassword = txtConfirmPassword.getPassword();

            // Validation
            if (!validateName(userName)) {
                validated = false;
            }

            if (!validateAddress(userAddress)) {
                validated = false;
            }

            if (!validateEmail(userEmail)) {
                validated = false;
            }

            if (chkUpdatePassword.isSelected()) {
                if (!validatePassword(newPassword)) {
                    validated = false;
                }

                if (!validateConfirmPassword(newPassword, confirmPassword)) {
                    validated = false;
                }
            }

            try {
                if (validated && chkUpdatePassword.isSelected()) {
                    String userPassword = Encryption.encryptPassword(newPassword);
                    // Create a Product Manager object
                    ProductManager userDetail = new ProductManager(userId, userName, userAddress, userEmail, userLoginName, userPassword, ProductManager.ACTIVE);
                    // Update the Product Manager
                    if (ProductManager.modify(userDetail, false)) {
                        resetFields();

                        // Change the icon from save icon to edit icon
                        lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));

                        // When the textbox is enabled, set the boolean variable to true.
                        isEditing = false;
                    }
                } else if (validated && !chkUpdatePassword.isSelected()) {
                    // Get the password
                    ArrayList<String> userArray = ReadObject.readArray(User.FILE_NAME);
                    
                    // Iterate through the User array
                    for (String user : userArray) {
                        // Split each line into an array
                        String[] details = user.split(";");
                        // Find the User id in the array list
                        if (details[0].equalsIgnoreCase(userId)) {
                            String userPassword = details[6];
                            // Create a Product Manager object
                            ProductManager userDetail = new ProductManager(userId, userName, userAddress, userEmail, userLoginName, userPassword, ProductManager.ACTIVE);
                            // Update the Product Manager
                            if (ProductManager.modify(userDetail, false)) {
                                resetFields();

                                // Change the icon from save icon to edit icon
                                lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));

                                // When the textbox is enabled, set the boolean variable to true.
                                isEditing = false;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                // Display the error message
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        }

    }//GEN-LAST:event_lblEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStatus;
    private javax.swing.JCheckBox chkUpdatePassword;
    private javax.swing.JLabel lblAddressError;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblLoginNameError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblNewPasswordError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNewPassword;
    // End of variables declaration//GEN-END:variables
}

package productmanagement;

import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductManagerUniversalPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int MAIN_MAX_HEIGHT = 271;
    public static final int MAIN_MIN_HEIGHT = 77;
    public static final int MAIN_WIDTH = 755;
    public static final int PANEL_MAX_HEIGHT = 249;
    public static final int PANEL_MIN_HEIGHT = 55;
    public static final int PANEL_WIDTH = 735;

    MainForm main;

    // Product Manager information
    ProductManager productManager;

    // Create a variable to check the panel is closed or opened
    boolean isClosed;

    // Create a variable to check the textbox is enabled or disabled 
    boolean isEditing = false;
    
    // Create a variable to check the itemStatus is activated or deactivated
    boolean isActivated;

    public ProductManagerUniversalPanel(MainForm main, ProductManager productManager, int i) {
        initComponents();
        this.main = main;
        // Hide the panel
        hidePanel();
        // Set the Product Manager information
        this.productManager = productManager;
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
        // Fill the fields with Product Manager information
        txtName.setText(productManager.getUserName());
        txtLoginName.setText(productManager.getUserLoginName());
        txtLoginName.setEnabled(false);
        txtEmail.setText(productManager.getUserEmail());
        txtAddress.setText(productManager.getUserAddress());
        
        switch (productManager.getProductManagerStatus()) {
            case ProductManager.ACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-on.png")));
                lblEdit.setEnabled(true);
                isActivated = true;
                break;
        
            case ProductManager.INACTIVE:
                btnStatus.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/switch-off.png")));
                lblEdit.setEnabled(false);
                isActivated = false;
                break;
        }
    }

    // Validation
    private boolean validateName(String userName) {
        boolean validated = true;

        if (userName.length() <= 0 || userName.equalsIgnoreCase("Name")) {
            lblNameError.setText("Manager Name cannot be empty");
            validated = false;
        } else if (!userName.matches("^[a-zA-Z]+(([',. /-][a-zA-Z ])?[a-zA-Z]*)*$")) {
            lblNameError.setText("Please enter a valid name");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateAddress(String userAddress) {
        boolean validated = true;

        if (userAddress.length() <= 0  || userAddress.equalsIgnoreCase("Address")) {
            lblAddressError.setText("Manager Address cannot be empty");
            validated = false;
        }else if (userAddress.contains(";")) {
            lblAddressError.setText("Manager Address cannot contain semi-colons");
            validated = false;
        }
        
        if (validated) {
            lblAddressError.setText(" ");
        }
        return validated;
    }

    private boolean validateEmail(String userEmail) {
        boolean validated = true;

        if (userEmail.length() <= 0 || userEmail.equalsIgnoreCase("Email")) {
            lblEmailError.setText("Manager Email cannot be empty");
            validated = false;
        } else if (!userEmail.matches("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?")) {
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

        if (userPassword.length < 8) {
            lblNewPasswordError.setText("New Password cannot be less than 8 characters");
            validated = false;
        } else if (userPassword.length > 16) {
            lblNewPasswordError.setText("New Password cannot be more than 16 characters");
            validated = false;
        }

        if (validated) {
            lblNewPasswordError.setText(" ");
        }
        return validated;
    }

    private boolean validateConfirmPassword(char[] userPassword, char[] confirmPassword) {
        boolean validated = true;

        if (!Arrays.equals(userPassword, confirmPassword)) {
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
        txtLoginName = new javax.swing.JTextField();
        lblLoginNameError = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddressError = new javax.swing.JLabel();
        chkUpdatePassword = new javax.swing.JCheckBox();
        txtNewPassword = new javax.swing.JPasswordField();
        lblNewPasswordError = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblConfirmPasswordError = new javax.swing.JLabel();
        btnStatus = new javax.swing.JButton();
        lblControl = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(46, 52, 66));

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

        txtLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtLoginName.setText("Login Name");
        txtLoginName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtLoginName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLoginName.setEnabled(false);
        txtLoginName.setPreferredSize(new java.awt.Dimension(250, 30));
        txtLoginName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginNameFocusLost(evt);
            }
        });

        lblLoginNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblLoginNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblLoginNameError.setText(" ");

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

        chkUpdatePassword.setBackground(new java.awt.Color(255, 255, 255));
        chkUpdatePassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        chkUpdatePassword.setText("Update Password");
        chkUpdatePassword.setEnabled(false);
        chkUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUpdatePasswordActionPerformed(evt);
            }
        });

        txtNewPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtNewPassword.setEnabled(false);
        txtNewPassword.setPreferredSize(new java.awt.Dimension(250, 30));
        txtNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNewPasswordFocusLost(evt);
            }
        });
        txtNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewPasswordKeyReleased(evt);
            }
        });

        lblNewPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNewPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblNewPasswordError.setText(" ");

        txtConfirmPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtConfirmPassword.setEnabled(false);
        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(250, 30));
        txtConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusLost(evt);
            }
        });
        txtConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmPasswordKeyReleased(evt);
            }
        });

        lblConfirmPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblConfirmPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmPasswordError.setText(" ");

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
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(chkUpdatePassword)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLoginNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNewPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAddressError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmailError)
                                    .addComponent(lblNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLoginNameError)
                            .addComponent(lblAddressError))
                        .addGap(18, 18, 18)
                        .addComponent(chkUpdatePassword)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPasswordError)
                            .addComponent(lblConfirmPasswordError))))
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
                txtAddress.setEnabled(true);
                chkUpdatePassword.setEnabled(true);
                lblControl.setEnabled(false);
                lblControl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                // Disable the editing of btnStatus
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
                String userId = productManager.getUserId();
                String userName = txtName.getText().trim();
                String userAddress = txtAddress.getText().trim();
                String userEmail = txtEmail.getText().trim();
                String userLoginName = productManager.getUserLoginName();

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
                        if (ProductManager.modify(userDetail, true, productManager.getProductManagerStatus())) {
                            resetFields();

                            // Disable the editing of fields
                            txtName.setEnabled(false);
                            txtEmail.setEnabled(false);
                            txtAddress.setEnabled(false);
                            chkUpdatePassword.setEnabled(false);
                            lblControl.setEnabled(true);
                            lblControl.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            // Enable the editing of btnStatus
                            btnStatus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            btnStatus.setEnabled(true);

                            // Change the icon from save icon to edit icon
                            lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));

                            // Set the boolean variable to false.
                            isEditing = false;
                            main.isEditing = false;
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
                                ProductManager modifiedProductManager = new ProductManager(userId, userName, userAddress, userEmail, userLoginName, userPassword, ProductManager.ACTIVE);
                                // Update the Product Manager
                                if (ProductManager.modify(modifiedProductManager, false, productManager.getProductManagerStatus())) {
                                    productManager = modifiedProductManager;
                                    resetFields();

                                    // Disable the editing of fields
                                    txtName.setEnabled(false);
                                    txtEmail.setEnabled(false);
                                    txtAddress.setEnabled(false);
                                    chkUpdatePassword.setEnabled(false);
                                    lblControl.setEnabled(true);
                                    lblControl.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                    // Enable the editing of btnStatus
                                    btnStatus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                    btnStatus.setEnabled(true);

                                    // Change the icon from save icon to edit icon
                                    lblEdit.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/Edit.png")));

                                    // Set the boolean variable to false.
                                    isEditing = false;
                                    main.isEditing = false;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    // Display the error message
                    JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_lblEditMouseClicked

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().trim().equalsIgnoreCase("Name")) {
            txtName.setText("");
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String productManagerName = txtName.getText().trim();
        validateName(productManagerName);
        
        if (txtName.getText().trim().equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().trim().equalsIgnoreCase("Email")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String productManagerEmail = txtEmail.getText().trim();
        validateEmail(productManagerEmail);
        
        if (txtEmail.getText().trim().equalsIgnoreCase("")) {
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtLoginNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginNameFocusLost
        if (txtLoginName.getText().trim().equalsIgnoreCase("")) {
            txtLoginName.setText("Login Name");
        }
    }//GEN-LAST:event_txtLoginNameFocusLost

    private void txtLoginNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginNameFocusGained
        if (txtLoginName.getText().trim().equalsIgnoreCase("Login Name")) {
            txtLoginName.setText("");
        }
    }//GEN-LAST:event_txtLoginNameFocusGained

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        if (txtAddress.getText().trim().equalsIgnoreCase("Address")) {
            txtAddress.setText("");
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        String productManagerAddress = txtAddress.getText().trim();
        validateAddress(productManagerAddress);
        
        if (txtAddress.getText().trim().equalsIgnoreCase("")) {
            txtAddress.setText("Address");
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void chkUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUpdatePasswordActionPerformed
        
        if(chkUpdatePassword.isSelected()){
            //If checkbox is checked, then enable the password fields
            txtNewPassword.setEnabled(true);
            txtConfirmPassword.setEnabled(true);
            
        }else{
            //If checkbox is unchecked, then disable the password fields
            txtNewPassword.setEnabled(false);
            txtConfirmPassword.setEnabled(false);
        }
    }//GEN-LAST:event_chkUpdatePasswordActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String productManagerName = txtName.getText().trim();
        validateName(productManagerName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        String productManagerEmail = txtEmail.getText().trim();
        validateEmail(productManagerEmail);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        String productManagerAddress = txtAddress.getText().trim();
        validateAddress(productManagerAddress);
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPasswordKeyReleased
        char[] productManagerNewPassword = txtNewPassword.getPassword();
        validatePassword(productManagerNewPassword);
    }//GEN-LAST:event_txtNewPasswordKeyReleased

    private void txtNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPasswordFocusLost
        char[] productManagerNewPassword = txtNewPassword.getPassword();
        validatePassword(productManagerNewPassword);
    }//GEN-LAST:event_txtNewPasswordFocusLost

    private void txtConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPasswordKeyReleased
        char[] productManagerNewPassword = txtNewPassword.getPassword();
        char[] productManagerConfirmPassword = txtConfirmPassword.getPassword();
        validateConfirmPassword(productManagerNewPassword,productManagerConfirmPassword);
    }//GEN-LAST:event_txtConfirmPasswordKeyReleased

    private void txtConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusLost
        char[] productManagerNewPassword = txtNewPassword.getPassword();
        char[] productManagerConfirmPassword = txtConfirmPassword.getPassword();
        validateConfirmPassword(productManagerNewPassword,productManagerConfirmPassword);
    }//GEN-LAST:event_txtConfirmPasswordFocusLost

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
            String productManagerStatus = ProductManager.ACTIVE;
            // Set new Product Manager status as active or inactive
            switch (productManager.getProductManagerStatus()) {
                case ProductManager.ACTIVE:
                    productManagerStatus = ProductManager.INACTIVE;
                    lblEdit.setEnabled(false);
                    isActivated = false;
                    break;
            
                case ProductManager.INACTIVE:
                    productManagerStatus = ProductManager.ACTIVE;
                    lblEdit.setEnabled(true);
                    isActivated = true;
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
                    // Update the Product Manager status
                    if (ProductManager.modify(modifiedProductManager, false, productManager.getProductManagerStatus())) {
                        productManager = modifiedProductManager;
                        resetFields();
                    }
                }
            }
    }//GEN-LAST:event_btnStatusActionPerformed


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

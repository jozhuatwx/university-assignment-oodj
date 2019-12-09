package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProfilePanel extends javax.swing.JPanel {
    MainForm main;
    // Created a variable to check the panel is closed or opened
    boolean isClosed = false;
    
    public ProfilePanel(MainForm main) {
        initComponents();
        this.main = main;
        resetFields();
        updatePasswordPanel();
    }
    
    private void updatePasswordPanel() {
        if (isClosed) {
            // If the panel is closed, then open the panel and set the boolean variable to false.
            pnlUpdatePassword.setPreferredSize(new Dimension(290, 369));
            pnlUpdatePassword.revalidate();
            pnlUpdatePassword.repaint();
            isClosed = false;
            // Change the icon from arrow-down to arrow-up
            lblArrow.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/arrow-up.png")));
            
            // Clear the field
            txtOldPassword.setText("");
            txtNewPassword.setText("");
            txtConfirmNewPassword.setText("");
            
            // Clear the error label
            lblOldPasswordError.setText(" ");
            lblNewPasswordError.setText(" ");
            lblConfirmPasswordError.setText(" ");
        } else {
            // The panel is opened, then close the panel and set the boolean variable to true.
            pnlUpdatePassword.setPreferredSize(new Dimension(290, 40));
            pnlUpdatePassword.revalidate();
            pnlUpdatePassword.repaint();
            isClosed = true;
            // Change the icon from arrow-up to arrow-down
            lblArrow.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/arrow-down.png")));
        }
    }

    private void resetFields() {
        // Fill the fields with User information
        txtName.setText(User.myUser.getUserName());
        txtAddress.setText(User.myUser.getUserAddress());
        txtEmail.setText(User.myUser.getUserEmail());
        lblUserLoginName.setText(User.myUser.getUserLoginName());

        // Clear the fields
        lblNameError.setText(" ");
        lblAddressError.setText(" ");
        lblEmailError.setText(" ");
    }

    // Validation
    private boolean validateName(String userName) {
        boolean validated = true;

        if (userName.length() <= 0 || userName.equalsIgnoreCase("Name")) {
            lblNameError.setText("User Name cannot be empty");
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

        if (userAddress.length() <= 0 || userAddress.equalsIgnoreCase("Address")) {
            lblAddressError.setText("User Address cannot be empty");
            validated = false;
        } else if (userAddress.contains(";")) {
            lblAddressError.setText("User Address cannot contain semi-colons");
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
            lblEmailError.setText("User Email cannot be empty");
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

    private boolean validateOldPassword(char[] userPassword) {
        boolean validated = true;

        if (userPassword.length <= 0) {
            lblOldPasswordError.setText("Old Password cannot be empty");
            validated = false;
        }

        if (validated) {
            lblOldPasswordError.setText(" ");
        }
        return validated;
    }

    private boolean validateNewPassword(char[] userPassword) {
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

    private boolean validateConfirmNewPassword(char[] userPassword, char[] confirmPassword) {
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
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUpdateProfile = new javax.swing.JPanel();
        lblUpdateProfile = new javax.swing.JLabel();
        lblLoginName = new javax.swing.JLabel();
        lblUserLoginName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddressError = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailError = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        pnlUpdatePassword = new javax.swing.JPanel();
        lblUpdatePassword = new javax.swing.JLabel();
        lblArrow = new javax.swing.JLabel();
        lblOldPassword = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        lblOldPasswordError = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        lblNewPasswordError = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        lblConfirmNewPassword = new javax.swing.JLabel();
        txtConfirmNewPassword = new javax.swing.JPasswordField();
        lblConfirmPasswordError = new javax.swing.JLabel();
        btnUpdatePassword = new javax.swing.JButton();

        setBackground(new java.awt.Color(18, 22, 31));
        setMinimumSize(new java.awt.Dimension(775, 485));
        setPreferredSize(new java.awt.Dimension(775, 485));

        pnlUpdateProfile.setBackground(new java.awt.Color(46, 52, 66));
        pnlUpdateProfile.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        lblUpdateProfile.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblUpdateProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdateProfile.setText("Update Profile");
        lblUpdateProfile.setMaximumSize(new java.awt.Dimension(200, 20));
        lblUpdateProfile.setMinimumSize(new java.awt.Dimension(200, 20));
        lblUpdateProfile.setPreferredSize(new java.awt.Dimension(200, 20));

        lblLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblLoginName.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginName.setText("Login Name :");
        lblLoginName.setMaximumSize(new java.awt.Dimension(200, 20));
        lblLoginName.setMinimumSize(new java.awt.Dimension(200, 20));
        lblLoginName.setPreferredSize(new java.awt.Dimension(200, 20));

        lblUserLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblUserLoginName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserLoginName.setText("User Login Name");
        lblUserLoginName.setMaximumSize(new java.awt.Dimension(200, 20));
        lblUserLoginName.setMinimumSize(new java.awt.Dimension(200, 20));
        lblUserLoginName.setPreferredSize(new java.awt.Dimension(200, 20));

        lblName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name :");
        lblName.setMaximumSize(new java.awt.Dimension(200, 20));
        lblName.setMinimumSize(new java.awt.Dimension(200, 20));
        lblName.setPreferredSize(new java.awt.Dimension(200, 20));

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtName.setBorder(null);
        txtName.setMinimumSize(new java.awt.Dimension(7, 30));
        txtName.setPreferredSize(new java.awt.Dimension(7, 30));
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

        lblAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address :");
        lblAddress.setMaximumSize(new java.awt.Dimension(200, 20));
        lblAddress.setMinimumSize(new java.awt.Dimension(200, 20));
        lblAddress.setPreferredSize(new java.awt.Dimension(200, 20));

        txtAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtAddress.setBorder(null);
        txtAddress.setMinimumSize(new java.awt.Dimension(7, 30));
        txtAddress.setPreferredSize(new java.awt.Dimension(7, 30));
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

        lblEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email :");
        lblEmail.setMaximumSize(new java.awt.Dimension(200, 20));
        lblEmail.setMinimumSize(new java.awt.Dimension(200, 20));
        lblEmail.setPreferredSize(new java.awt.Dimension(200, 20));

        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtEmail.setBorder(null);
        txtEmail.setMinimumSize(new java.awt.Dimension(7, 30));
        txtEmail.setPreferredSize(new java.awt.Dimension(7, 30));
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

        btnUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setMaximumSize(new java.awt.Dimension(200, 40));
        btnUpdate.setMinimumSize(new java.awt.Dimension(200, 40));
        btnUpdate.setPreferredSize(new java.awt.Dimension(200, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUpdateProfileLayout = new javax.swing.GroupLayout(pnlUpdateProfile);
        pnlUpdateProfile.setLayout(pnlUpdateProfileLayout);
        pnlUpdateProfileLayout.setHorizontalGroup(
            pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateProfileLayout.createSequentialGroup()
                .addGroup(pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUpdateProfileLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlUpdateProfileLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAddressError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblUserLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdateProfileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUpdateProfileLayout.setVerticalGroup(
            pnlUpdateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameError)
                .addGap(18, 18, 18)
                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAddressError)
                .addGap(18, 18, 18)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlUpdatePassword.setBackground(new java.awt.Color(46, 52, 66));
        pnlUpdatePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlUpdatePassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlUpdatePassword.setPreferredSize(new java.awt.Dimension(290, 369));

        lblUpdatePassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblUpdatePassword.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdatePassword.setText("Update Password");
        lblUpdatePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUpdatePassword.setMaximumSize(new java.awt.Dimension(200, 20));
        lblUpdatePassword.setMinimumSize(new java.awt.Dimension(200, 20));
        lblUpdatePassword.setPreferredSize(new java.awt.Dimension(200, 20));
        lblUpdatePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUpdatePasswordMouseClicked(evt);
            }
        });

        lblArrow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/arrow-up.png"))); // NOI18N
        lblArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblArrow.setMaximumSize(new java.awt.Dimension(20, 20));
        lblArrow.setMinimumSize(new java.awt.Dimension(20, 20));
        lblArrow.setPreferredSize(new java.awt.Dimension(20, 20));
        lblArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblArrowMouseClicked(evt);
            }
        });

        lblOldPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblOldPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblOldPassword.setText("Old Password :");
        lblOldPassword.setMaximumSize(new java.awt.Dimension(200, 20));
        lblOldPassword.setMinimumSize(new java.awt.Dimension(200, 20));
        lblOldPassword.setPreferredSize(new java.awt.Dimension(200, 20));

        txtOldPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtOldPassword.setBorder(null);
        txtOldPassword.setMinimumSize(new java.awt.Dimension(7, 30));
        txtOldPassword.setPreferredSize(new java.awt.Dimension(7, 30));
        txtOldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOldPasswordFocusLost(evt);
            }
        });
        txtOldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOldPasswordKeyReleased(evt);
            }
        });

        lblOldPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblOldPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblOldPasswordError.setText(" ");

        lblNewPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblNewPassword.setText("New Password :");
        lblNewPassword.setMaximumSize(new java.awt.Dimension(200, 20));
        lblNewPassword.setMinimumSize(new java.awt.Dimension(200, 20));
        lblNewPassword.setPreferredSize(new java.awt.Dimension(200, 20));

        lblNewPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblNewPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblNewPasswordError.setText(" ");

        txtNewPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtNewPassword.setBorder(null);
        txtNewPassword.setMinimumSize(new java.awt.Dimension(7, 30));
        txtNewPassword.setPreferredSize(new java.awt.Dimension(7, 30));
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

        lblConfirmNewPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblConfirmNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmNewPassword.setText("Confirm New Password :");
        lblConfirmNewPassword.setMaximumSize(new java.awt.Dimension(200, 20));
        lblConfirmNewPassword.setMinimumSize(new java.awt.Dimension(200, 20));
        lblConfirmNewPassword.setPreferredSize(new java.awt.Dimension(200, 20));

        txtConfirmNewPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtConfirmNewPassword.setBorder(null);
        txtConfirmNewPassword.setMinimumSize(new java.awt.Dimension(7, 30));
        txtConfirmNewPassword.setPreferredSize(new java.awt.Dimension(7, 30));
        txtConfirmNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmNewPasswordFocusLost(evt);
            }
        });
        txtConfirmNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmNewPasswordKeyReleased(evt);
            }
        });

        lblConfirmPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblConfirmPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmPasswordError.setText(" ");

        btnUpdatePassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnUpdatePassword.setText("Update Password");
        btnUpdatePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdatePassword.setMinimumSize(new java.awt.Dimension(200, 40));
        btnUpdatePassword.setPreferredSize(new java.awt.Dimension(200, 40));
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUpdatePasswordLayout = new javax.swing.GroupLayout(pnlUpdatePassword);
        pnlUpdatePassword.setLayout(pnlUpdatePasswordLayout);
        pnlUpdatePasswordLayout.setHorizontalGroup(
            pnlUpdatePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdatePasswordLayout.createSequentialGroup()
                .addGroup(pnlUpdatePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdatePasswordLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblUpdatePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(lblArrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdatePasswordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlUpdatePasswordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdatePasswordLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(pnlUpdatePasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUpdatePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOldPasswordError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNewPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlUpdatePasswordLayout.createSequentialGroup()
                        .addGroup(pnlUpdatePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtConfirmNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlUpdatePasswordLayout.setVerticalGroup(
            pnlUpdatePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdatePasswordLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlUpdatePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOldPasswordError)
                .addGap(18, 18, 18)
                .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNewPasswordError)
                .addGap(18, 18, 18)
                .addComponent(lblConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirmPasswordError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUpdateProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlUpdateProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean validated = true;

        String userId = User.myUser.getUserId();
        String userName = txtName.getText().trim();
        String userAddress = txtAddress.getText().trim();
        String userEmail = txtEmail.getText().trim();
        String userLoginName = User.myUser.getUserLoginName();

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

        if (validated) {
            // Get the password
            ArrayList<String> userArray = ReadObject.readArray(User.FILE_NAME);
            
            // Iterate through the User array
            for (String user : userArray) {
                // Split each line into an array
                String[] details = user.split(";");
                // Find the User id in the array list
                if (details[0].equalsIgnoreCase(userId)) {
                    String userPassword = details[6];
                    // Check if it is admin or product manager
                    if (Administrator.isAdministrator()) {
                        // Create a Adminstrator object
                        Administrator userDetail = new Administrator(userId, userName, userAddress, userEmail, userLoginName, userPassword);
                        // Update the Administrator
                        if (Administrator.modify(userDetail, false)) {
                            resetFields();
                            main.isEditing = false;
                        }
                    } else if (ProductManager.isProductManager()) {
                        // Create a Product Manager object
                        ProductManager userDetail = new ProductManager(userId, userName, userAddress, userEmail, userLoginName, userPassword, ProductManager.ACTIVE);
                        // Update the Product Manager
                        if (ProductManager.modify(userDetail, false)) {
                            resetFields();
                            main.isEditing = false;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        boolean validated = true;
        
        String userId = User.myUser.getUserId();
        String userName = User.myUser.getUserName();
        String userAddress = User.myUser.getUserAddress();
        String userEmail = User.myUser.getUserEmail();
        String userLoginName = User.myUser.getUserLoginName();

        char[] oldPassword = txtOldPassword.getPassword();
        char[] newPassword = txtNewPassword.getPassword();
        char[] retypeNewPassword = txtConfirmNewPassword.getPassword();

        // Validation
        if (!validateOldPassword(oldPassword)) {
            validated = false;
        }

        if (!validateNewPassword(newPassword)) {
            validated = false;
        }

        if (!validateConfirmNewPassword(newPassword, retypeNewPassword)) {
            validated = false;
        }

        if (validated) {
            try {
                // Check if the password is correct
                ArrayList<String> userArray = ReadObject.readArray(User.FILE_NAME);
                
                // Iterate through the User array
                for (String user : userArray) {
                    // Split each line into an array
                    String[] details = user.split(";");
                    // Find the user login name in the array list
                    if (details[0].equalsIgnoreCase(userId)) {
                        // Compare if the password equals the input password
                        if (Encryption.validatePassword(oldPassword, details[6])) {
                            // Encrypt the new password
                            String userPassword = Encryption.encryptPassword(newPassword);
                            // Check if it is admin or product manager
                            if (Administrator.isAdministrator()) {
                                // Create a Adminstrator object
                                Administrator userDetail = new Administrator(userId, userName, userAddress, userEmail, userLoginName, userPassword);
                                // Update the Administrator
                                if (Administrator.modify(userDetail, true)) {
                                    resetFields();
                                    main.isEditing = false;
                                }
                            } else if (ProductManager.isProductManager()) {
                                // Create a Product Manager object
                                ProductManager userDetail = new ProductManager(userId, userName, userAddress, userEmail, userLoginName, userPassword, ProductManager.ACTIVE);
                                // Update the Product Manager
                                if (ProductManager.modify(userDetail, true)) {
                                    resetFields();
                                    main.isEditing = false;
                                }
                            }
                        } else {
                            // Display the error message
                            JOptionPane.showMessageDialog(new JFrame(), "Wrong password", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            } catch (Exception e) {
                // Display the error message
              JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void lblUpdatePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdatePasswordMouseClicked
        updatePasswordPanel();
    }//GEN-LAST:event_lblUpdatePasswordMouseClicked

    private void lblArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblArrowMouseClicked
        updatePasswordPanel();
    }//GEN-LAST:event_lblArrowMouseClicked

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String userName = txtName.getText().trim();
        validateName(userName);
        main.isEditing = true;
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String userName = txtName.getText().trim();
        validateName(userName);
        
        if (userName.equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        String userAddress = txtAddress.getText().trim();
        validateAddress(userAddress);
        main.isEditing = true;
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        String userAddress = txtAddress.getText().trim();
        validateAddress(userAddress);
        
        if (userAddress.equalsIgnoreCase("")) {
            txtAddress.setText("Address");
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        String userEmail = txtEmail.getText().trim();
        validateEmail(userEmail);
        main.isEditing = true;
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String userEmail = txtEmail.getText().trim();
        validateEmail(userEmail);
        
        if (userEmail.equalsIgnoreCase("")) {
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtOldPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOldPasswordKeyReleased
        char[] userPassword = txtOldPassword.getPassword();
        validateOldPassword(userPassword);
        main.isEditing = true;
    }//GEN-LAST:event_txtOldPasswordKeyReleased

    private void txtOldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOldPasswordFocusLost
        char[] userPassword = txtOldPassword.getPassword();
        validateOldPassword(userPassword);
    }//GEN-LAST:event_txtOldPasswordFocusLost

    private void txtNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPasswordKeyReleased
        char[] userPassword = txtNewPassword.getPassword();
        validateNewPassword(userPassword);
        main.isEditing = true;
    }//GEN-LAST:event_txtNewPasswordKeyReleased

    private void txtNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPasswordFocusLost
        char[] userPassword = txtNewPassword.getPassword();
        validateNewPassword(userPassword);
    }//GEN-LAST:event_txtNewPasswordFocusLost

    private void txtConfirmNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmNewPasswordKeyReleased
        char[] userPassword = txtNewPassword.getPassword();
        char[] retypePassword = txtConfirmNewPassword.getPassword();
        validateConfirmNewPassword(userPassword, retypePassword);
        main.isEditing = true;
    }//GEN-LAST:event_txtConfirmNewPasswordKeyReleased

    private void txtConfirmNewPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmNewPasswordFocusLost
        char[] userPassword = txtNewPassword.getPassword();
        char[] retypePassword = txtConfirmNewPassword.getPassword();
        validateConfirmNewPassword(userPassword, retypePassword);
    }//GEN-LAST:event_txtConfirmNewPasswordFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().trim().equalsIgnoreCase("Name")) {
            txtName.setText("");
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        if (txtAddress.getText().trim().equalsIgnoreCase("Address")) {
            txtAddress.setText("");
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().trim().equalsIgnoreCase("Email")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressError;
    private javax.swing.JLabel lblArrow;
    private javax.swing.JLabel lblConfirmNewPassword;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblLoginName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNewPasswordError;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JLabel lblOldPasswordError;
    private javax.swing.JLabel lblUpdatePassword;
    private javax.swing.JLabel lblUpdateProfile;
    private javax.swing.JLabel lblUserLoginName;
    private javax.swing.JPanel pnlUpdatePassword;
    private javax.swing.JPanel pnlUpdateProfile;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirmNewPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables

}

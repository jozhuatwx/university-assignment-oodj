package productmanagement;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {
    int xMouse, yMouse;
    
    public LoginForm() {
        initComponents();
        this.getRootPane().setDefaultButton(btnLogin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        BackgroundPanel = new javax.swing.JPanel();
        WhitePanel = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblLoginName = new javax.swing.JLabel();
        txtLoginName = new javax.swing.JTextField();
        lblLoginNameError = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPasswordError = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblSystemName2 = new javax.swing.JLabel();
        lblSystemName = new javax.swing.JLabel();
        lblLoginLogo = new javax.swing.JLabel();
        TopFrameBar = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Form");
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        BackgroundPanel.setBackground(new java.awt.Color(0, 0, 51));

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));

        lblLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");

        lblLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblLoginName.setText("Login Name :");
        lblLoginName.setName(""); // NOI18N

        txtLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtLoginName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLoginName.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(204, 204, 204)));
        txtLoginName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtLoginName.setName("txtLoginName"); // NOI18N
        txtLoginName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginNameFocusLost(evt);
            }
        });
        txtLoginName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginNameKeyReleased(evt);
            }
        });

        lblLoginNameError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblLoginNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblLoginNameError.setText(" ");
        lblLoginNameError.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPassword.setText("Password :");
        lblPassword.setName(""); // NOI18N

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 3, 3, new java.awt.Color(204, 204, 204)));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        lblPasswordError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblPasswordError.setText(" ");

        btnLogin.setBackground(new java.awt.Color(0, 0, 51));
        btnLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setName("btnLogin\\"); // NOI18N
            btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btnLoginMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
            WhitePanel.setLayout(WhitePanelLayout);
            WhitePanelLayout.setHorizontalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(WhitePanelLayout.createSequentialGroup()
                    .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLoginNameError)
                                .addComponent(lblPasswordError)))
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(19, Short.MAX_VALUE))
            );
            WhitePanelLayout.setVerticalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(WhitePanelLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)
                    .addComponent(lblLoginNameError)
                    .addGap(2, 2, 2)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPasswordError)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28))
            );

            lblSystemName2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
            lblSystemName2.setForeground(new java.awt.Color(255, 255, 255));
            lblSystemName2.setText("Management System");
            lblSystemName2.setName("lblSystemName"); // NOI18N

            lblSystemName.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
            lblSystemName.setForeground(new java.awt.Color(255, 255, 255));
            lblSystemName.setText("Product Catalogue");
            lblSystemName.setName("lblSystemName"); // NOI18N

            lblLoginLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblLoginLogo.setName("lblLoginLogo"); // NOI18N

            javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
            BackgroundPanel.setLayout(BackgroundPanelLayout);
            BackgroundPanelLayout.setHorizontalGroup(
                BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BackgroundPanelLayout.createSequentialGroup()
                    .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BackgroundPanelLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLoginLogo)
                            .addGap(86, 86, 86))
                        .addGroup(BackgroundPanelLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(lblSystemName))
                                .addComponent(lblSystemName2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18))
            );
            BackgroundPanelLayout.setVerticalGroup(
                BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BackgroundPanelLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(lblLoginLogo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblSystemName)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblSystemName2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(BackgroundPanelLayout.createSequentialGroup()
                    .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE))
            );

            TopFrameBar.setBackground(new java.awt.Color(0, 0, 51));

            lblClose.setBackground(new java.awt.Color(0, 0, 51));
            lblClose.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
            lblClose.setForeground(new java.awt.Color(255, 255, 255));
            lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblClose.setText("X");
            lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblClose.setName("lblClose"); // NOI18N
            lblClose.setOpaque(true);
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
            lblMinimize.setName("lblMinimize"); // NOI18N
            lblMinimize.setOpaque(true);
            lblMinimize.setPreferredSize(new java.awt.Dimension(11, 21));
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

            javax.swing.GroupLayout TopFrameBarLayout = new javax.swing.GroupLayout(TopFrameBar);
            TopFrameBar.setLayout(TopFrameBarLayout);
            TopFrameBarLayout.setHorizontalGroup(
                TopFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopFrameBarLayout.createSequentialGroup()
                    .addContainerGap(520, Short.MAX_VALUE)
                    .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            TopFrameBarLayout.setVerticalGroup(
                TopFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TopFrameBarLayout.createSequentialGroup()
                    .addGroup(TopFrameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 4, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TopFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(TopFrameBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            setSize(new java.awt.Dimension(600, 420));
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        // To change the background colour to red colour
        lblClose.setBackground(Color.RED);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        // To change the background colour back to its original colour     
        lblClose.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        // To change the background colour to light gray colour
        lblMinimize.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        // To change the background colour back to its original colour     
        lblMinimize.setBackground(new Color(0,0,51));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        // Minimize the form.
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // Close the form
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // To get the absolute x,y on the screen when being dragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        // Set the form to the location of (x,y)
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // To get the x,y relative to the source component
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        String userLoginName = txtLoginName.getText();
        char[] userPassword = txtPassword.getPassword();

        if (userLoginName.trim().length() > 0 && userPassword.length > 0) {
            if (User.login(userLoginName, userPassword)) {
            // Display form based on role
            switch (User.myUser.getUserRole()) {
                case ProductManager.ROLE:
                    
                    break;
            
                case Administrator.ROLE:

                    break;
            }

            // Close the login form
            this.dispose();
            }
        } else if (userLoginName.trim().length() == 0 && userPassword.length == 0) {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), "Login Name and password cannot be empty", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (userLoginName.trim().length() == 0) {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), "Login Name cannot be empty", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (userPassword.length == 0) {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), "Password cannot be empty", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    private void txtLoginNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginNameFocusLost
        String userLoginName = txtLoginName.getText();
        if (userLoginName.trim().length() == 0) {
            lblLoginNameError.setText("Login Name cannot be empty");
        } else {
            lblLoginNameError.setText(" ");
        }
    }//GEN-LAST:event_txtLoginNameFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        char[] userPassword = txtPassword.getPassword();
        if (userPassword.length == 0) {
            lblPasswordError.setText("Password cannot be empty");
        } else {
            lblPasswordError.setText(" ");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtLoginNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginNameKeyReleased
        String userLoginName = txtLoginName.getText();
        if (userLoginName.trim().length() == 0) {
            lblLoginNameError.setText("Login Name cannot be empty");
        } else {
            lblLoginNameError.setText(" ");
        }
    }//GEN-LAST:event_txtLoginNameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        char[] userPassword = txtPassword.getPassword();
        if (userPassword.length == 0) {
            lblPasswordError.setText("Password cannot be empty");
        } else {
            lblPasswordError.setText(" ");
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JPanel TopFrameBar;
    private javax.swing.JPanel WhitePanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginLogo;
    private javax.swing.JLabel lblLoginName;
    private javax.swing.JLabel lblLoginNameError;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblSystemName2;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}

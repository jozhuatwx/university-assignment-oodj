package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductManagerPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int PANEL_MAX_HEIGHT = 446;
    public static final int PANEL_MIN_HEIGHT = 61;
    public static final int PANEL_WIDTH = 755;

    MainForm main;

    public ProductManagerPanel(MainForm main) {
        initComponents();
        this.main = main;
        // Hide the Panel
        hideAddPanel();
        // Popualate the list with Product Managers
        repopulateProductManagerList();
    }
    
    private void showAddPanel() {
        // Resize the Panel and show the components inside
        pnlAddProductManager.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MAX_HEIGHT));
        pnlAddProductManager.revalidate();
        pnlAddProductManager.repaint();
        
        // Disable the button
        btnAdd.setEnabled(false);
    }

    private void hideAddPanel() {
        // Resize the Panel and hide the components inside
        pnlAddProductManager.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MIN_HEIGHT));
        pnlAddProductManager.revalidate();
        pnlAddProductManager.repaint();
        
        // Enable the button
        btnAdd.setEnabled(true);
    }
    
    private void resetFields() {
        // Clear the fields
        txtName.setText("Name");
        txtLoginName.setText("Login Name");
        txtAddress.setText("Address");
        txtEmail.setText("Email");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        
        lblNameError.setText(" ");
        lblLoginNameError.setText(" ");
        lblAddressError.setText(" ");
        lblEmailError.setText(" ");
        lblPasswordError.setText(" ");
        lblConfirmPasswordError.setText(" ");
    }

    private void repopulateProductManagerList() {
        // Remove all exisiting Product Managers
        pnlProductManagerList.removeAll();
        
        int i = 0, x = 0;
        ArrayList<String> userArray = ReadObject.readArray(ProductManager.FILE_NAME);
        // Iterate through the User array
        for (; i < userArray.size(); i++) {
            // Split the line into an array
            String[] details = userArray.get(i).split(";");
            // Find Product Managers only
            if (details[4].equalsIgnoreCase(ProductManager.ROLE)) {
                // Create a Product Manager object with the details
                ProductManager user = new ProductManager(details);
                // Create a Universal Panel with the Project Manager object
                ProductManagerUniversalPanel pmup = new ProductManagerUniversalPanel(main, user, x + 1);
                // Set the size of the Universal Panel
                pmup.setPreferredSize(new Dimension(ProductManagerUniversalPanel.MAIN_WIDTH, ProductManagerUniversalPanel.MAIN_MIN_HEIGHT));
                // Add the panel into the list
                pnlProductManagerList.add(pmup);
                // Keeps track of the number of Product Managers
                x++;
            }
        }
        // Fill remaining space with an empty box
        if (x * ProductManagerUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlProductManagerList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductManagerUniversalPanel.MAIN_MIN_HEIGHT * x))));
        }
        pnlProductManagerList.revalidate();
    }

    private void search() {
        String keyword = txtSearch.getText().trim();

        hideAddPanel();
        // Remove all existing Product Managers
        pnlProductManagerList.removeAll();
        
        int i = 0;
        // Get an array list of Product Managers matching the keyword
        ArrayList<ProductManager> userArray = ProductManager.searchProductManager(keyword);
        for (; i < userArray.size(); i++) {
            // Create a Universal Panel object with the Product Manager object
            ProductManagerUniversalPanel pmup = new ProductManagerUniversalPanel(main, userArray.get(i), i + 1);
            // Set the size of the Universal Panel
            pmup.setPreferredSize(new Dimension(ProductManagerUniversalPanel.MAIN_WIDTH, ProductManagerUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlProductManagerList.add(pmup);
        }
        // Fill remaining space with an empty box
        if (i * ProductManagerUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlProductManagerList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductManagerUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlProductManagerList.revalidate();
        pnlProductManagerList.repaint();
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

    private boolean validateLoginName(String userLoginName) {
        boolean validated = true;

        if (userLoginName.length() <= 0 || userLoginName.equalsIgnoreCase("Login Name") || userLoginName.equalsIgnoreCase("LoginName")) {
            lblLoginNameError.setText("Manager Login Name cannot be empty");
            validated = false;
        }else if (userLoginName.contains(";")) {
            lblLoginNameError.setText("Manager Login Name cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblLoginNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateAddress(String userAddress) {
        boolean validated = true;

        if (userAddress.length() <= 0 || userAddress.equalsIgnoreCase("Address")) {
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
            lblPasswordError.setText("New Password cannot be less than 8 characters");
            validated = false;
        } else if (userPassword.length > 16) {
            lblPasswordError.setText("New Password cannot be more than 16 characters");
            validated = false;
        }

        if (validated) {
            lblPasswordError.setText(" ");
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

        pnlAddProductManager = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        pnlAddProductManagerForm = new javax.swing.JPanel();
        lblAddProductManager = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblLoginName = new javax.swing.JLabel();
        txtLoginName = new javax.swing.JTextField();
        lblLoginNameError = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddressError = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPasswordError = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailError = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblConfirmPasswordError = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrProductManagerList = new javax.swing.JScrollPane();
        pnlProductManagerList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));

        pnlAddProductManager.setBackground(new java.awt.Color(46, 52, 66));

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

        pnlAddProductManagerForm.setBackground(new java.awt.Color(18, 22, 31));

        lblAddProductManager.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddProductManager.setForeground(new java.awt.Color(255, 255, 255));
        lblAddProductManager.setText("Add Product Manager");
        lblAddProductManager.setPreferredSize(new java.awt.Dimension(150, 20));

        lblName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name :");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtName.setText("Name");
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

        lblLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblLoginName.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginName.setText("Login Name :");

        txtLoginName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtLoginName.setText("Login Name");
        txtLoginName.setPreferredSize(new java.awt.Dimension(350, 30));
        txtLoginName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginNameFocusGained(evt);
            }
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

        lblAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address :");

        txtAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtAddress.setText("Address");
        txtAddress.setPreferredSize(new java.awt.Dimension(350, 30));
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

        lblPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password :");

        txtPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(350, 30));
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

        lblEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email :");

        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtEmail.setText("Email");
        txtEmail.setPreferredSize(new java.awt.Dimension(350, 30));
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

        lblConfirmPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmPassword.setText("Confirm Password :");

        txtConfirmPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(350, 30));
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

        btnSubmit.setBackground(new java.awt.Color(46, 52, 66));
        btnSubmit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
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
        btnCancel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new java.awt.Dimension(150, 40));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddProductManagerFormLayout = new javax.swing.GroupLayout(pnlAddProductManagerForm);
        pnlAddProductManagerForm.setLayout(pnlAddProductManagerFormLayout);
        pnlAddProductManagerFormLayout.setHorizontalGroup(
            pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                        .addComponent(lblAddProductManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                        .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAddressError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAddress)
                                .addComponent(lblName))
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLoginName)
                            .addComponent(txtLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLoginNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPassword)
                            .addComponent(lblConfirmPassword))))
                .addContainerGap())
        );
        pnlAddProductManagerFormLayout.setVerticalGroup(
            pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddProductManagerFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddProductManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNameError)
                        .addGap(18, 18, 18)
                        .addComponent(lblAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddressError)
                            .addComponent(lblPasswordError))
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmailError))
                    .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                        .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblLoginNameError))
                            .addGroup(pnlAddProductManagerFormLayout.createSequentialGroup()
                                .addComponent(lblLoginName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblConfirmPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblConfirmPasswordError)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlAddProductManagerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlAddProductManagerLayout = new javax.swing.GroupLayout(pnlAddProductManager);
        pnlAddProductManager.setLayout(pnlAddProductManagerLayout);
        pnlAddProductManagerLayout.setHorizontalGroup(
            pnlAddProductManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddProductManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddProductManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddProductManagerLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAddProductManagerForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAddProductManagerLayout.setVerticalGroup(
            pnlAddProductManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddProductManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddProductManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAddProductManagerForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrProductManagerList.setBackground(new java.awt.Color(46, 52, 66));
        scrProductManagerList.setBorder(null);
        scrProductManagerList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrProductManagerList.setToolTipText("");
        scrProductManagerList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrProductManagerList.getVerticalScrollBar().setUnitIncrement(16);

        pnlProductManagerList.setBackground(new java.awt.Color(46, 52, 66));
        pnlProductManagerList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlProductManagerList.setLayout(new javax.swing.BoxLayout(pnlProductManagerList, javax.swing.BoxLayout.Y_AXIS));
        scrProductManagerList.setViewportView(pnlProductManagerList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddProductManager, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrProductManagerList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddProductManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrProductManagerList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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

        String userName = txtName.getText().trim();
        String userAddress = txtAddress.getText().trim();
        String userEmail = txtEmail.getText().trim();
        String userLoginName = txtLoginName.getText().trim();

        char[] password = txtPassword.getPassword();
        char[] confirmPassword = txtConfirmPassword.getPassword();

        if (!validateName(userName)) {
            validated = false;
        }

        if (!validateAddress(userAddress)) {
            validated = false;
        }

        if (!validateEmail(userEmail)) {
            validated = false;
        }

        if (!validateLoginName(userLoginName)) {
            validated = false;
        }

        if (!validatePassword(password)) {
            validated = false;
        }

        if (!validateConfirmPassword(password, confirmPassword)) {
            validated = false;
        }

        if (validated) {
            try {
                // Encrypt the new password
                String userPassword = Encryption.encryptPassword(password);
                // Register the Product Manager if no error
                ProductManager productManager = new ProductManager(User.generateUserId(), userName, userAddress, userEmail, userLoginName, userPassword, ProductManager.ACTIVE);
                if (ProductManager.register(productManager)) {
                    resetFields();
                    repopulateProductManagerList();
                    main.isEditing = false;
                }
            } catch (Exception e) {
                // Display the error message
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String userName = txtName.getText().trim();
        validateName(userName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String userName = txtName.getText().trim();
        validateName(userName);
        
        if (txtName.getText().trim().equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtLoginNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginNameKeyReleased
        String userLoginName = txtLoginName.getText().trim();
        validateLoginName(userLoginName);
    }//GEN-LAST:event_txtLoginNameKeyReleased

    private void txtLoginNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginNameFocusLost
        String userLoginName = txtLoginName.getText().trim();
        validateLoginName(userLoginName);
        
        if (txtLoginName.getText().trim().equalsIgnoreCase("")) {
            txtLoginName.setText("Login Name");
        }
    }//GEN-LAST:event_txtLoginNameFocusLost

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        String userAddress = txtAddress.getText().trim();
        validateAddress(userAddress);
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        String userAddress = txtAddress.getText().trim();
        validateAddress(userAddress);
        
        if (txtAddress.getText().trim().equalsIgnoreCase("")) {
            txtAddress.setText("Address");
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        char[] userPassword = txtPassword.getPassword();
        validatePassword(userPassword);
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        char[] userPassword = txtPassword.getPassword();
        validatePassword(userPassword);
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        String userEmail = txtEmail.getText().trim();
        validateEmail(userEmail);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String userEmail = txtEmail.getText().trim();
        validateEmail(userEmail);
        
        if (txtEmail.getText().trim().equalsIgnoreCase("")) {
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPasswordKeyReleased
        char[] userPassword = txtPassword.getPassword();
        char[] confirmPassword = txtConfirmPassword.getPassword();
        validateConfirmPassword(userPassword, confirmPassword);
    }//GEN-LAST:event_txtConfirmPasswordKeyReleased

    private void txtConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusLost
        char[] userPassword = txtPassword.getPassword();
        char[] confirmPassword = txtConfirmPassword.getPassword();
        validateConfirmPassword(userPassword, confirmPassword);
    }//GEN-LAST:event_txtConfirmPasswordFocusLost

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

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().trim().equalsIgnoreCase("Email")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblAddProductManager;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressError;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblLoginName;
    private javax.swing.JLabel lblLoginNameError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JPanel pnlAddProductManager;
    private javax.swing.JPanel pnlAddProductManagerForm;
    private javax.swing.JPanel pnlProductManagerList;
    private javax.swing.JScrollPane scrProductManagerList;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

package productmanagement;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SupplierPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int PANEL_MAX_HEIGHT = 359;
    public static final int PANEL_MIN_HEIGHT = 61;
    public static final int PANEL_WIDTH = 755;

    MainForm main;

    public SupplierPanel(MainForm main) {
        initComponents();
        this.main = main;
        // Hide the Panel
        hideAddPanel();
        // Hide the Add button for Product Manager
        if (ProductManager.isProductManager()){
            btnAdd.setVisible(false);
        }
        // Populate the list with Suppliers
        repopulateSupplierList();
    }
    
    private void showAddPanel() {
        // Resize the Panel and show the components inside
        pnlAddSupplier.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MAX_HEIGHT));
        pnlAddSupplier.revalidate();
        pnlAddSupplier.repaint();
        
        // Disable the button
        btnAdd.setEnabled(false);
    }

    private void hideAddPanel() {
        // Resize the Panel and hide the components inside
        pnlAddSupplier.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_MIN_HEIGHT));
        pnlAddSupplier.revalidate();
        pnlAddSupplier.repaint();
        
        // Enable the button
        btnAdd.setEnabled(true);
    }
    
    private void resetFields() {
        // Clear the fields
        txtName.setText("Name");
        txtAddress.setText("Address");
        txtContact.setText("Contact");
        txtEmail.setText("Email");
        
        lblNameError.setText(" ");
        lblAddressError.setText(" ");
        lblContactError.setText(" ");
        lblEmailError.setText(" ");
    }

    private void repopulateSupplierList() {
        // Remove all existing Suppliers
        pnlSupplierList.removeAll();
        
        int i = 0;
        ArrayList<String> supplierArray = ReadObject.readArray(Supplier.FILE_NAME);
        // Iterate through the Supplier array
        for (; i < supplierArray.size(); i++) {
            // Split the line into an array
            String[] details = supplierArray.get(i).split(";");
            // Create a Supplier object with the details
            Supplier supplier = new Supplier(details);
            // Create a Universal Panel object with the Supplier object
            SupplierUniversalPanel sup = new SupplierUniversalPanel(main, supplier, i + 1);
            // Set the size of the Universal Panel
            sup.setPreferredSize(new Dimension(SupplierUniversalPanel.MAIN_WIDTH, SupplierUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlSupplierList.add(sup);
        }
        // Fill remaining space with an empty box
        if (i * SupplierUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlSupplierList.add(Box.createRigidArea(new Dimension(0, 385 - (SupplierUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlSupplierList.revalidate();
    }

    private void search() {
        String keyword = txtSearch.getText().trim();

        hideAddPanel();
        // Remove all existing Suppliers
        pnlSupplierList.removeAll();
        
        int i = 0;
        // Get an array list of the Suppliers matching the keyword
        ArrayList<Supplier> supplierArray = Supplier.search(keyword);
        for (; i < supplierArray.size(); i++) {
            // Create a Universal Panel object with the Supplier object
            SupplierUniversalPanel sup = new SupplierUniversalPanel(main, supplierArray.get(i), i + 1);
            // Set the size of the Universal Panel object
            sup.setPreferredSize(new Dimension(SupplierUniversalPanel.MAIN_WIDTH, SupplierUniversalPanel.MAIN_MIN_HEIGHT));
            // Add the Panel into the list
            pnlSupplierList.add(sup);
        }
        // Fill remaining space with an empty box
        if (i * SupplierUniversalPanel.MAIN_MIN_HEIGHT < 385) {
            pnlSupplierList.add(Box.createRigidArea(new Dimension(0, 385 - (SupplierUniversalPanel.MAIN_MIN_HEIGHT * i))));
        }
        pnlSupplierList.revalidate();
        pnlSupplierList.repaint();
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

        pnlAddSupplier = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        pnlAddSupplierForm = new javax.swing.JPanel();
        lblAddSupplier = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAddressError = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        lblContactError = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailError = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrSupplierList = new javax.swing.JScrollPane();
        pnlSupplierList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));

        pnlAddSupplier.setBackground(new java.awt.Color(46, 52, 66));

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

        pnlAddSupplierForm.setBackground(new java.awt.Color(18, 22, 31));
        pnlAddSupplierForm.setPreferredSize(new java.awt.Dimension(735, 292));

        lblAddSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblAddSupplier.setText("Add Supplier");
        lblAddSupplier.setPreferredSize(new java.awt.Dimension(110, 20));

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

        lblAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address :");

        txtAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtAddress.setText("Address");
        txtAddress.setBorder(null);
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

        lblContact.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblContact.setForeground(new java.awt.Color(255, 255, 255));
        lblContact.setText("Contact :");

        txtContact.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtContact.setText("Contact");
        txtContact.setBorder(null);
        txtContact.setPreferredSize(new java.awt.Dimension(350, 30));
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

        lblEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email :");

        txtEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtEmail.setText("Email");
        txtEmail.setBorder(null);
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

        javax.swing.GroupLayout pnlAddSupplierFormLayout = new javax.swing.GroupLayout(pnlAddSupplierForm);
        pnlAddSupplierForm.setLayout(pnlAddSupplierFormLayout);
        pnlAddSupplierFormLayout.setHorizontalGroup(
            pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                        .addComponent(lblAddSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                        .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContact, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContactError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAddress)
                                .addComponent(lblAddressError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEmail)
                            .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblEmailError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddSupplierFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAddSupplierFormLayout.setVerticalGroup(
            pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAddress))
                        .addGap(5, 5, 5)
                        .addComponent(lblAddressError)
                        .addGap(19, 19, 19)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddSupplierFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNameError)
                        .addGap(18, 18, 18)
                        .addComponent(lblContact)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContactError)
                            .addComponent(lblEmailError))))
                .addGap(33, 83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddSupplierFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAddSupplierFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlAddSupplierLayout = new javax.swing.GroupLayout(pnlAddSupplier);
        pnlAddSupplier.setLayout(pnlAddSupplierLayout);
        pnlAddSupplierLayout.setHorizontalGroup(
            pnlAddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddSupplierLayout.createSequentialGroup()
                        .addComponent(pnlAddSupplierForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlAddSupplierLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAddSupplierLayout.setVerticalGroup(
            pnlAddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAddSupplierForm, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrSupplierList.setBackground(new java.awt.Color(46, 52, 66));
        scrSupplierList.setBorder(null);
        scrSupplierList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrSupplierList.setToolTipText("");
        scrSupplierList.setMinimumSize(new java.awt.Dimension(755, 385));
        scrSupplierList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrSupplierList.getVerticalScrollBar().setUnitIncrement(16);

        pnlSupplierList.setBackground(new java.awt.Color(46, 52, 66));
        pnlSupplierList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlSupplierList.setLayout(new javax.swing.BoxLayout(pnlSupplierList, javax.swing.BoxLayout.Y_AXIS));
        scrSupplierList.setViewportView(pnlSupplierList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrSupplierList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrSupplierList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            // Register the Supplier if no error
            Supplier supplier = new Supplier(Supplier.generateSupplierId(), supplierName, supplierAddress, supplierEmail, supplierContact, Supplier.ACTIVE);
            if (Supplier.register(supplier)) {
                resetFields();
                repopulateSupplierList();
                main.isEditing = false;
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

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

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        if (txtAddress.getText().trim().equalsIgnoreCase("Address")) {
            txtAddress.setText("");
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusGained
        if (txtContact.getText().trim().equalsIgnoreCase("Contact")) {
            txtContact.setText("");
        }
    }//GEN-LAST:event_txtContactFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().trim().equalsIgnoreCase("Email")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblAddSupplier;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressError;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblContactError;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JPanel pnlAddSupplier;
    private javax.swing.JPanel pnlAddSupplierForm;
    private javax.swing.JPanel pnlSupplierList;
    private javax.swing.JScrollPane scrSupplierList;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

package productmanagement;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductItemPanel extends javax.swing.JPanel {
    // Constant fields
    public static final int PANEL_MAX_HEIGHT = 633;
    public static final int PANEL_MIN_HEIGHT = 61;
    public static final int PANEL_WIDTH = 755;

    MainForm main;
    
    // Keeps track of temporary image file path
    String imageTempPath = "/productmanagement/img/InsertImage.png", latestImageTempPath;

    public ProductItemPanel(MainForm main) {
        initComponents();
        this.main = main;
        // Hide the Panel
        hideAddPanel();
        resetCategory();
        resetSupplier();
        // Populate the list with Product Items
        repopulateItemList();
    }
    
    private void showAddPanel() {
        // Resize the Panel and show the components inside
        pnlAddItem.setPreferredSize(new Dimension(755, 633));
        pnlAddItem.revalidate();
        pnlAddItem.repaint();
        
        // Disable the button
        btnAdd.setEnabled(false);
    }

    private void hideAddPanel() {
        // Resize the Panel and hide the components inside
        pnlAddItem.setPreferredSize(new Dimension(755, 61));
        pnlAddItem.revalidate();
        pnlAddItem.repaint();
        
        // Enable the button
        btnAdd.setEnabled(true);
    }
    
    private void resetFields() {
        // Clear the fields
        txtName.setText("Name");
        txtBrand.setText("Brand");
        txtSellingPrice.setText("Selling Price");
        txtQuantity.setText("Quantity");
        txaDescription.setText("Description");
        lblImage.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png")));
        lblNameError.setText(" ");
        lblBrandError.setText(" ");
        lblSellingPriceError.setText(" ");
        lblQuantityError.setText(" ");
        lblDescriptionError.setText(" ");
        lblImageError.setText(" ");
    }

    private void resetCategory() {
        // Remove existing Categories
        cmbCategory.removeAllItems();

        ArrayList<String> categoryArray = ReadObject.readArray(ProductCategory.FILE_NAME);
        // Iterate through the Category array
        for (String category : categoryArray) {
            // Split the line into an array
            String[] details = category.split(";");
            if (details[3].equalsIgnoreCase(ProductCategory.ACTIVE)) {
                String comboItem = details[0] + ": " + details[1];
                // Add the item into the combobox
                cmbCategory.addItem(comboItem);
            }
        }
    }

    private void resetSupplier() {
        // Remove existing Suppliers
        cmbSupplier.removeAllItems();

        ArrayList<String> supplierArray = ReadObject.readArray(Supplier.FILE_NAME);
        // Iterate through the Supplier array
        for (String supplier : supplierArray) {
            // Split the line into an array
            String[] details = supplier.split(";");
            if (details[5].equalsIgnoreCase(Supplier.ACTIVE)) {
                String comboItem = details[0] + ": " + details[1];
                // Add the item into the combobox
                cmbSupplier.addItem(comboItem);
            }
        }
    }

    private void repopulateItemList() {
        // Remove all existing Product Items
        pnlItemList.removeAll();
        
        int i = 0;
        ArrayList<String> itemArray = ReadObject.readArray(ProductItem.FILE_NAME);
        // Iterate through the Item array
        for (; i < itemArray.size(); i++) {
            // Split the line into an array
            String[] details = itemArray.get(i).split(";");
            // Create an Item object with the details
            ProductItem item = new ProductItem(details);
            // Create a Universal Panel object with the Item object
            ProductItemUniversalPanel iup = new ProductItemUniversalPanel(main, item, i + 1);
            // Set the size of the Universal Panel
            iup.setPreferredSize(new Dimension(ProductItemUniversalPanel.MAIN_WIDTH, ProductItemUniversalPanel.MAIN_HEIGHT));
            // Add the panel into the list
            pnlItemList.add(iup);
        }
        // Fill remaining space with an empty box
        if (i * ProductItemUniversalPanel.MAIN_HEIGHT < 385) {
            pnlItemList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductItemUniversalPanel.MAIN_HEIGHT * i))));
        }
        pnlItemList.revalidate();
    }
    
    // Create a method to resize the image and label
    private ImageIcon resizeImage(String imagePath){
        int x, y;
        double width, height, ratio;
        width = lblImage.getPreferredSize().getWidth();
        height = lblImage.getPreferredSize().getHeight();

        // Get the imageicon and get the width & height of the image
        ImageIcon MyImage = new ImageIcon(imagePath);
        x = MyImage.getIconWidth();
        y = MyImage.getIconHeight();
        ratio = (double) x / y;
        
        // To differentiate if the image is wider or higher than the label
        if (ratio > (width / height)) {
            if (ratio >= 1) {
                lblImage.setBounds(lblImage.getBounds().x, lblImage.getBounds().y + (int) Math.round((height - (height / ratio)) / 2), (int) width, (int) Math.round(height / ratio));
            } else {
                lblImage.setBounds(lblImage.getBounds().x, lblImage.getBounds().y + (int) Math.round((height - (height * ratio)) / 2), (int) width, (int) Math.round(height * ratio));
            }
        } else if (ratio < (width / height)){
            if (ratio >= 1) {
                lblImage.setBounds(lblImage.getBounds().x + (int) Math.round((width - (height / ratio)) / 2), lblImage.getBounds().y, (int) Math.round(height / ratio), (int) height);
            } else {
                lblImage.setBounds(lblImage.getBounds().x + (int) Math.round((width - (height * ratio)) / 2), lblImage.getBounds().y, (int) Math.round(height * ratio), (int) height);
            }
        } else {
            // The width is equal to the height, then only scale the image
            lblImage.setBounds(lblImage.getBounds().x, lblImage.getBounds().y, (int) width, (int) height);
        }
        
        // Resize the image to the size of the label
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance((int) lblImage.getBounds().getWidth(),(int) lblImage.getBounds().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void search() {
        String keyword = txtSearch.getText().trim();

        hideAddPanel();
        // Remove all existing Product Items
        pnlItemList.removeAll();
        
        int i = 0;
        // Get an array list of the Product Items matching the keyword
        ArrayList<ProductItem> itemArray = ProductItem.search(keyword);
        for (; i < itemArray.size(); i++) {
            // Create a Universal Panel object with the Product Item object
            ProductItemUniversalPanel iup = new ProductItemUniversalPanel(main, itemArray.get(i), i + 1);
            // Set the size of the Universal Panel object
            iup.setPreferredSize(new Dimension(ProductItemUniversalPanel.MAIN_WIDTH, ProductItemUniversalPanel.MAIN_HEIGHT));
            // Add the Panel into the list
            pnlItemList.add(iup);
        }
        // Fill remaining space with an empty box
        if (i * ProductItemUniversalPanel.MAIN_HEIGHT < 385) {
            pnlItemList.add(Box.createRigidArea(new Dimension(0, 385 - (ProductItemUniversalPanel.MAIN_HEIGHT * i))));
        }
        pnlItemList.revalidate();
        pnlItemList.repaint();
    }

    // Validation
    private boolean validateName(String itemName) {
        boolean validated = true;

        if (itemName.length() <= 0 || itemName.equalsIgnoreCase("Name")) {
            lblNameError.setText("Cannot be empty");
            validated = false;
        } else if (itemName.contains(";")) {
            lblNameError.setText("Cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblNameError.setText(" ");
        }
        return validated;
    }

    private boolean validateBrand(String itemBrand) {
        boolean validated = true;

        if (itemBrand.length() <= 0 || itemBrand.equalsIgnoreCase("Brand")) {
            lblBrandError.setText("Cannot be empty");
            validated = false;
        } else if (itemBrand.contains(";")) {
            lblBrandError.setText("Cannot contain semi-colons");
            validated = false;
        }
        
        if (validated) {
            lblBrandError.setText(" ");
        }
        return validated;
    }

    private boolean validatePrice(String itemPriceString) {
        boolean validated = true;

        try {
            if (itemPriceString.length() <= 0) {
                lblSellingPriceError.setText("Cannot be empty");
                validated = false;
            } else {
                double itemPrice = Double.valueOf(itemPriceString);
                if (itemPrice < 0) {
                    lblSellingPriceError.setText("Cannot be negative");
                    validated = false;
                }
            }
        } catch (NumberFormatException e) {
            lblSellingPriceError.setText("Please enter a valid number");
            validated = false;
        }

        if (validated) {
            lblSellingPriceError.setText(" ");
        }
        return validated;
    }

    private boolean validateQuantity(String itemQuantityString) {
        boolean validated = true;

        try {
            if (itemQuantityString.length() <= 0) {
                lblQuantityError.setText("Cannot be empty");
                validated = false;
            } else {
                int itemQuantity = Integer.valueOf(itemQuantityString);
                if (itemQuantity < 0) {
                    lblQuantityError.setText("Cannot be negative");
                    validated = false;
                }
            }
        } catch (NumberFormatException e) {
            lblQuantityError.setText("Please enter a valid number");
            validated = false;
        }

        if (validated) {
            lblQuantityError.setText(" ");
        }
        return validated;
    }

    private boolean validateDescription(String itemDescription) {
        boolean validated = true;
        
        if (itemDescription.length() <= 0 || itemDescription.equalsIgnoreCase("Description")) {
            lblDescriptionError.setText("Cannot be empty");
            validated = false;
        }else if (itemDescription.contains(";")) {
            lblDescriptionError.setText("Cannot contain semi-colons");
            validated = false;
        }

        if (validated) {
            lblDescriptionError.setText(" ");
        }
        return validated;
    }

    private boolean validateImagePath(String itemImageTempPath) {
        boolean validated = true;

        if (itemImageTempPath.length() <= 0 || itemImageTempPath.equalsIgnoreCase("/productmanagement/img/InsertImage.png")) {
            lblImageError.setText("Cannot be empty");
            validated = false;
        }

        if (validated) {
            lblImageError.setText(" ");
        }
        return validated;
    }

    private boolean validateSupplierId(String itemSupplierId) {
        boolean validated = true;

        if (itemSupplierId.length() <= 0) {
            lblSupplierError.setText("Please select a supplier");
            validated = false;
        }

        if (validated) {
            lblSupplierError.setText(" ");
        }
        return validated;
    }

    private boolean validateCategoryId(String itemCategoryId) {
        boolean validated = true;

        if (itemCategoryId.length() <= 0) {
            lblCategoryError.setText("Please select a category");
            validated = false;
        }

        if (validated) {
            lblCategoryError.setText(" ");
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

        pnlAddItem = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        pnlAddItemForm = new javax.swing.JPanel();
        lblAddItem = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        lblCategoryError = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        lblSupplierError = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblNameError = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblQuantityError = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lblBrandError = new javax.swing.JLabel();
        lblSellingPrice = new javax.swing.JLabel();
        txtSellingPrice = new javax.swing.JTextField();
        lblSellingPriceError = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        scrDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        lblDescriptionError = new javax.swing.JLabel();
        lblSelectImage = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblImageError = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrItemList = new javax.swing.JScrollPane();
        pnlItemList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(18, 22, 31));

        pnlAddItem.setBackground(new java.awt.Color(46, 52, 66));
        pnlAddItem.setMaximumSize(new java.awt.Dimension(755, 32767));

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

        pnlAddItemForm.setBackground(new java.awt.Color(18, 22, 31));
        pnlAddItemForm.setPreferredSize(new java.awt.Dimension(735, 571));

        lblAddItem.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblAddItem.setForeground(new java.awt.Color(255, 255, 255));
        lblAddItem.setText("Add Item");
        lblAddItem.setPreferredSize(new java.awt.Dimension(110, 20));

        lblCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblCategory.setText("Category :");

        cmbCategory.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbCategory.setBorder(null);
        cmbCategory.setMinimumSize(new java.awt.Dimension(350, 30));
        cmbCategory.setPreferredSize(new java.awt.Dimension(350, 30));

        lblCategoryError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblCategoryError.setForeground(new java.awt.Color(255, 0, 0));
        lblCategoryError.setText(" ");

        lblSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplier.setText("Supplier :");

        cmbSupplier.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cmbSupplier.setMaximumSize(new java.awt.Dimension(350, 30));
        cmbSupplier.setMinimumSize(new java.awt.Dimension(350, 30));
        cmbSupplier.setPreferredSize(new java.awt.Dimension(350, 30));

        lblSupplierError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSupplierError.setForeground(new java.awt.Color(255, 0, 0));
        lblSupplierError.setText(" ");

        lblName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name :");

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtName.setText("Name");
        txtName.setBorder(null);
        txtName.setMinimumSize(new java.awt.Dimension(350, 30));
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

        lblQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity :");

        txtQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtQuantity.setText("Quantity");
        txtQuantity.setBorder(null);
        txtQuantity.setMaximumSize(new java.awt.Dimension(350, 30));
        txtQuantity.setMinimumSize(new java.awt.Dimension(350, 30));
        txtQuantity.setPreferredSize(new java.awt.Dimension(350, 30));
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });

        lblQuantityError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblQuantityError.setForeground(new java.awt.Color(255, 0, 0));
        lblQuantityError.setText(" ");

        lblBrand.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(255, 255, 255));
        lblBrand.setText("Brand :");

        txtBrand.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtBrand.setText("Brand");
        txtBrand.setBorder(null);
        txtBrand.setMinimumSize(new java.awt.Dimension(350, 30));
        txtBrand.setPreferredSize(new java.awt.Dimension(350, 30));
        txtBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBrandFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBrandFocusLost(evt);
            }
        });
        txtBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBrandKeyReleased(evt);
            }
        });

        lblBrandError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblBrandError.setForeground(new java.awt.Color(255, 0, 0));
        lblBrandError.setText(" ");

        lblSellingPrice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSellingPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblSellingPrice.setText("Selling Price :");

        txtSellingPrice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtSellingPrice.setText("Selling Price");
        txtSellingPrice.setBorder(null);
        txtSellingPrice.setMaximumSize(new java.awt.Dimension(350, 30));
        txtSellingPrice.setMinimumSize(new java.awt.Dimension(350, 30));
        txtSellingPrice.setPreferredSize(new java.awt.Dimension(350, 30));
        txtSellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSellingPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSellingPriceFocusLost(evt);
            }
        });
        txtSellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSellingPriceKeyReleased(evt);
            }
        });

        lblSellingPriceError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblSellingPriceError.setForeground(new java.awt.Color(255, 0, 0));
        lblSellingPriceError.setText(" ");

        lblDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description :");

        scrDescription.setToolTipText("");

        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txaDescription.setRows(8);
        txaDescription.setText("Description\n");
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

        lblSelectImage.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblSelectImage.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectImage.setText("Image :");

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblImage.setForeground(new java.awt.Color(255, 255, 255));
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png"))); // NOI18N
        lblImage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImage.setMaximumSize(new java.awt.Dimension(156, 128));
        lblImage.setMinimumSize(new java.awt.Dimension(156, 128));
        lblImage.setPreferredSize(new java.awt.Dimension(156, 128));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        lblImageError.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lblImageError.setForeground(new java.awt.Color(255, 0, 0));
        lblImageError.setText(" ");

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

        javax.swing.GroupLayout pnlAddItemFormLayout = new javax.swing.GroupLayout(pnlAddItemForm);
        pnlAddItemForm.setLayout(pnlAddItemFormLayout);
        pnlAddItemFormLayout.setHorizontalGroup(
            pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCategoryError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblNameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(scrDescription, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDescription)
                                            .addComponent(lblName)
                                            .addComponent(lblBrand)
                                            .addComponent(lblBrandError, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE))
                            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                                .addComponent(lblDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblSelectImage)
                                .addComponent(lblSellingPrice)
                                .addComponent(lblQuantity)
                                .addComponent(lblSupplier)
                                .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSupplierError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblQuantityError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSellingPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSellingPriceError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblImageError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddItemFormLayout.createSequentialGroup()
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlAddItemFormLayout.setVerticalGroup(
            pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCategoryError)
                        .addGap(18, 18, 18)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSupplierError)
                        .addGap(18, 18, 18)
                        .addComponent(lblQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addComponent(lblQuantityError)
                        .addGap(18, 18, 18)
                        .addComponent(lblSellingPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSellingPriceError)
                        .addGap(18, 18, 18)
                        .addComponent(lblSelectImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddItemFormLayout.createSequentialGroup()
                        .addComponent(lblNameError)
                        .addGap(18, 18, 18)
                        .addComponent(lblBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBrandError)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImageError)
                    .addComponent(lblDescriptionError))
                .addGap(18, 18, 18)
                .addGroup(pnlAddItemFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAddItemLayout = new javax.swing.GroupLayout(pnlAddItem);
        pnlAddItem.setLayout(pnlAddItemLayout);
        pnlAddItemLayout.setHorizontalGroup(
            pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddItemForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAddItemLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlAddItemLayout.setVerticalGroup(
            pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAddItemForm, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scrItemList.setBackground(new java.awt.Color(46, 52, 66));
        scrItemList.setBorder(null);
        scrItemList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrItemList.setToolTipText("");
        scrItemList.setPreferredSize(new java.awt.Dimension(755, 385));
        scrItemList.getVerticalScrollBar().setUnitIncrement(16);

        pnlItemList.setBackground(new java.awt.Color(46, 52, 66));
        pnlItemList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        pnlItemList.setLayout(new javax.swing.BoxLayout(pnlItemList, javax.swing.BoxLayout.Y_AXIS));
        scrItemList.setViewportView(pnlItemList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrItemList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrItemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        // To let the user insert the image after pressed the label
        // Set the home directory of the filechooser to user
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        // Create a new file name extension which including .jpg and .png file
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lblImage.setIcon(resizeImage(path));
            latestImageTempPath = path;
            imageTempPath = path;
            lblImageError.setText(" ");
        } else if (result == JFileChooser.CANCEL_OPTION){
            if(latestImageTempPath == null){
                lblImage.setIcon(new ImageIcon(getClass().getResource("/productmanagement/img/InsertImage.png")));
                imageTempPath = "/productmanagement/img/InsertImage.png";
                lblImageError.setText("Item Image cannot be empty");
            }else{
                    lblImage.setIcon(resizeImage(latestImageTempPath));
            }
        }
    }//GEN-LAST:event_lblImageMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        hideAddPanel();
        resetFields();
        main.isEditing = false;
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!main.isEditing) {
            showAddPanel();
            resetFields();
            main.isEditing = true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You have unsaved work. Please save it first.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        boolean validated = true;

        String itemName = txtName.getText().trim();
        String itemBrand = txtBrand.getText().trim();
        String itemPriceString = txtSellingPrice.getText().trim();
        String itemQuantityString = txtQuantity.getText().trim();
        String itemDescription = txaDescription.getText().trim();
        String itemImageTempPath = imageTempPath;
        String itemSupplierId = String.valueOf(cmbSupplier.getSelectedItem()).substring(0, 9);
        String itemCategoryId = String.valueOf(cmbCategory.getSelectedItem()).substring(0, 10);
        
        // Remove the "RM" in the itemPrice, because we just want the price value
        if (itemPriceString.startsWith("RM")) {
            itemPriceString = itemPriceString.substring(2, itemPriceString.length()).trim();
        }

        try {
            // Validation
            if (!validateName(itemName)) {
                validated = false;
            }

            if (!validateBrand(itemBrand)) {
                validated = false;
            }

            if (!validatePrice(itemPriceString)) {
                validated = false;
            }

            if (!validateQuantity(itemQuantityString)) {
                validated = false;
            }

            if (!validateDescription(itemDescription)) {
                validated = false;
            }

            if (!validateImagePath(itemImageTempPath)) {
                validated = false;
            }

            if (!validateSupplierId(itemSupplierId)) {
                validated = false;
            }

            if (!validateCategoryId(itemCategoryId)) {
                validated = false;
            }
            
            if (validated) {
                // Convert String to int
                double itemPrice = Double.valueOf(itemPriceString);
                int itemQuantity = Integer.valueOf(itemQuantityString);

                // Generate Item Id
                String itemId = ProductItem.generateItemId();

                // Copy image file to system
                Path tempPath = Path.of(imageTempPath);
                String newPathString = "/productmanagement/img/productitem/";
                String fileName = itemId + imageTempPath.substring(imageTempPath.lastIndexOf("."));
                WriteObject.saveImage(tempPath, newPathString, fileName);
                String itemImagePath = newPathString + fileName;
                
                // Register the Product Item if no error
                ProductItem item = new ProductItem(itemId, itemName, itemBrand, itemPrice, itemDescription, itemImagePath, itemSupplierId, itemCategoryId, ProductItem.ACTIVE);
                if (ProductItem.register(item, itemQuantity)) {
                    resetFields();
                    repopulateItemList();
                    main.isEditing = false;
                }
            }
        } catch (Exception e) {
            // Display the error message
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String itemName = txtName.getText().trim();
        validateName(itemName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String itemName = txtName.getText().trim();
        validateName(itemName);
        
        if (txtName.getText().trim().equalsIgnoreCase("")) {
            txtName.setText("Name");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        String itemQuantityString = txtQuantity.getText().trim();
        validateQuantity(itemQuantityString);
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        String itemQuantityString = txtQuantity.getText().trim();
        validateQuantity(itemQuantityString);
        
        if (txtQuantity.getText().trim().equalsIgnoreCase("")) {
            txtQuantity.setText("Quantity");
        }
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtBrandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrandKeyReleased
        String itemBrand = txtBrand.getText().trim();
        validateBrand(itemBrand);
    }//GEN-LAST:event_txtBrandKeyReleased

    private void txtBrandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusLost
        String itemBrand = txtBrand.getText().trim();
        validateBrand(itemBrand);
        
        if (txtBrand.getText().trim().equalsIgnoreCase("")) {
            txtBrand.setText("Brand");
        }
    }//GEN-LAST:event_txtBrandFocusLost

    private void txtSellingPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSellingPriceKeyReleased
        String itemPriceString = txtSellingPrice.getText().trim();
        if(itemPriceString.startsWith("RM")){
            itemPriceString = itemPriceString.substring(2,itemPriceString.length());
        }
        validatePrice(itemPriceString);
    }//GEN-LAST:event_txtSellingPriceKeyReleased

    private void txtSellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusLost
        String itemPriceString = txtSellingPrice.getText().trim();
        if(itemPriceString.startsWith("RM")){
            itemPriceString = itemPriceString.substring(2,itemPriceString.length());
        }
        validatePrice(itemPriceString);
        
        if (txtSellingPrice.getText().trim().equalsIgnoreCase("")) {
            txtSellingPrice.setText("Selling Price");
        }
    }//GEN-LAST:event_txtSellingPriceFocusLost

    private void txaDescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescriptionKeyReleased
        String itemDescription = txaDescription.getText().trim();
        validateDescription(itemDescription);
    }//GEN-LAST:event_txaDescriptionKeyReleased

    private void txaDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusLost
        String itemDescription = txaDescription.getText().trim();
        validateDescription(itemDescription);
        
        if (txaDescription.getText().trim().equalsIgnoreCase("")) {
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

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        if (txtQuantity.getText().trim().equalsIgnoreCase("Quantity")) {
            txtQuantity.setText("");
        }
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtBrandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusGained
        if (txtBrand.getText().trim().equalsIgnoreCase("Brand")) {
            txtBrand.setText("");
        }
    }//GEN-LAST:event_txtBrandFocusGained

    private void txtSellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusGained
        if (txtSellingPrice.getText().trim().equalsIgnoreCase("Selling Price")) {
            txtSellingPrice.setText("RM");
        }
    }//GEN-LAST:event_txtSellingPriceFocusGained

    private void txaDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaDescriptionFocusGained
        if (txaDescription.getText().trim().equalsIgnoreCase("Description")) {
            txaDescription.setText("");
        }
    }//GEN-LAST:event_txaDescriptionFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel lblAddItem;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandError;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategoryError;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionError;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantityError;
    private javax.swing.JLabel lblSelectImage;
    private javax.swing.JLabel lblSellingPrice;
    private javax.swing.JLabel lblSellingPriceError;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblSupplierError;
    private javax.swing.JPanel pnlAddItem;
    private javax.swing.JPanel pnlAddItemForm;
    private javax.swing.JPanel pnlItemList;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JScrollPane scrItemList;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSellingPrice;
    // End of variables declaration//GEN-END:variables
}
